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
import karaoke.dao.exceptions.PreexistingEntityException;
import karaoke.model.Sistema;

/**
 *
 * @author Vandré
 */
public class SistemaDao implements Serializable {

    public SistemaDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sistema sistema) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sistema);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSistema(sistema.getId()) != null) {
                throw new PreexistingEntityException("Sistema " + sistema + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sistema sistema) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sistema = em.merge(sistema);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sistema.getId();
                if (findSistema(id) == null) {
                    throw new NonexistentEntityException("The sistema with id " + id + " no longer exists.");
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
            Sistema sistema;
            try {
                sistema = em.getReference(Sistema.class, id);
                sistema.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sistema with id " + id + " no longer exists.", enfe);
            }
            em.remove(sistema);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sistema> findSistemaEntities() {
        return findSistemaEntities(true, -1, -1);
    }

    public List<Sistema> findSistemaEntities(int maxResults, int firstResult) {
        return findSistemaEntities(false, maxResults, firstResult);
    }

    private List<Sistema> findSistemaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sistema.class));
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

    public Sistema findSistema(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sistema.class, id);
        } finally {
            em.close();
        }
    }

    public int getSistemaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sistema> rt = cq.from(Sistema.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
