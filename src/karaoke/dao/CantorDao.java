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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import karaoke.dao.exceptions.NonexistentEntityException;
import karaoke.model.Cantor;

/**
 *
 * @author Vandré
 */
public class CantorDao implements Serializable {

    public CantorDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cantor cantor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cantor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cantor cantor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cantor = em.merge(cantor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cantor.getId();
                if (findCantor(id) == null) {
                    throw new NonexistentEntityException("The cantor with id " + id + " no longer exists.");
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
            Cantor cantor;
            try {
                cantor = em.getReference(Cantor.class, id);
                cantor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cantor with id " + id + " no longer exists.", enfe);
            }
            em.remove(cantor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cantor> findCantorEntities() {
        return findCantorEntities(true, -1, -1);
    }

    public List<Cantor> findCantorEntities(int maxResults, int firstResult) {
        return findCantorEntities(false, maxResults, firstResult);
    }

    private List<Cantor> findCantorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cantor.class));
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

    public Cantor findCantor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cantor.class, id);
        } finally {
            em.close();
        }
    }

    public int getCantorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cantor> rt = cq.from(Cantor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Cantor> findCantorByNameApelido(Cantor cantor) {
        EntityManager em = getEntityManager();
        StringBuilder sm = new StringBuilder(" WHERE 1=1");
        try {
            if ((cantor.getNome() != null) && (!cantor.getNome().equals(""))) {
                sm.append(" AND c.nome LIKE '%").append(cantor.getNome()).append("%' ");
            }

            if ((cantor.getApelido() != null) && (!cantor.getApelido().equals(""))) {
                sm.append(" AND c.apelido LIKE '%").append(cantor.getApelido()).append("%' ");
            }

            TypedQuery<Cantor> q = em.createQuery("SELECT c FROM Cantor c" + sm.toString(), Cantor.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

}
