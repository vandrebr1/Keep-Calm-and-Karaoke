/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karaoke.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import karaoke.dao.exceptions.NonexistentEntityException;
import karaoke.model.Play;

/**
 *
 * @author Vandré
 */
public class PlayDao implements Serializable {

    public PlayDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Play play) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(play);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Play play) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            play = em.merge(play);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = play.getId();
                if (findPlay(id) == null) {
                    throw new NonexistentEntityException("The play with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Play play;
            try {
                play = em.getReference(Play.class, id);
                play.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The play with id " + id + " no longer exists.", enfe);
            }
            em.remove(play);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Play> findPlayEntities() {
        return findPlayEntities(true, -1, -1);
    }

    public List<Play> findPlayEntities(int maxResults, int firstResult) {
        return findPlayEntities(false, maxResults, firstResult);
    }

    private List<Play> findPlayEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Play.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Play findPlay(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Play.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlayCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Play> rt = cq.from(Play.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Play findUltimoPlayAberto() {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Play> q = em.createQuery("SELECT p FROM Play p WHERE p.concluida='false' ORDER BY p.id DESC", Play.class).setMaxResults(1);
            return q.getSingleResult();
        } catch (NoResultException e) {
            return new Play();

        } finally {
            em.close();
        }
    }

    public boolean concluirTodas() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            String sql = "UPDATE Play p SET p.concluida='true'";
            Query query = em.createQuery(sql);
            query.executeUpdate();
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return true;
    }

    public List<Object[]> retornarMaisCantou(String de, String ate) {
        EntityManager em = getEntityManager();

        StringBuilder sm = new StringBuilder("SELECT cantores.apelido, COUNT(cantorID) AS total");
        sm.append(" FROM (");
        sm.append(" SELECT cantor1ID AS cantorID FROM play WHERE cantor1ID IS NOT NULL AND votacaoencerrada=1 AND dtcadastro BETWEEN '").append(de).append("' AND '").append(ate);
        sm.append("' UNION ALL");
        sm.append(" SELECT cantor2ID AS cantorID FROM play WHERE cantor2ID IS NOT NULL AND votacaoencerrada=1 AND dtcadastro BETWEEN '").append(de).append("' AND '").append(ate);
        sm.append("') AS playcantores");
        sm.append(" INNER JOIN cantores");
        sm.append(" ON cantores.id = playcantores.cantorID");
        sm.append(" GROUP BY cantorID");
        sm.append(" ORDER BY COUNT(cantorID) DESC");
        sm.append(" LIMIT 10");

        try {
            Query q = em.createNativeQuery(sm.toString());
            return q.getResultList();

        } catch (NoResultException e) {
            return null;

        } finally {
            em.close();
        }
    }

}
