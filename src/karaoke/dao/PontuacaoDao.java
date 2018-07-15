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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import karaoke.dao.exceptions.NonexistentEntityException;
import karaoke.model.Pontuacao;

/**
 *
 * @author Vandré
 */
public class PontuacaoDao implements Serializable {

    public PontuacaoDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pontuacao pontuacao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pontuacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pontuacao pontuacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pontuacao = em.merge(pontuacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pontuacao.getId();
                if (findPontuacao(id) == null) {
                    throw new NonexistentEntityException("The pontuacao with id " + id + " no longer exists.");
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
            Pontuacao pontuacao;
            try {
                pontuacao = em.getReference(Pontuacao.class, id);
                pontuacao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pontuacao with id " + id + " no longer exists.", enfe);
            }
            em.remove(pontuacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pontuacao> findPontuacaoEntities() {
        return findPontuacaoEntities(true, -1, -1);
    }

    public List<Pontuacao> findPontuacaoEntities(int maxResults, int firstResult) {
        return findPontuacaoEntities(false, maxResults, firstResult);
    }

    private List<Pontuacao> findPontuacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pontuacao.class));
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

    public Pontuacao findPontuacao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pontuacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getPontuacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pontuacao> rt = cq.from(Pontuacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public boolean createLote(List<Pontuacao> pontuacoes) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            int contador = 1;

            for (Pontuacao pontuacao : pontuacoes) {

                em.persist(pontuacao);
                if (contador % 100 == 0) {
                    em.flush();
                    em.clear();
                }

                contador++;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception(e);

        } finally {
            if (em != null) {
                em.close();
            }
        }
        return true;
    }

}
