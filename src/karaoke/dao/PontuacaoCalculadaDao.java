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
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import karaoke.dao.exceptions.NonexistentEntityException;
import karaoke.model.Play;
import karaoke.model.PontuacaoCalculada;

/**
 *
 * @author Vandré
 */
public class PontuacaoCalculadaDao implements Serializable {

    public PontuacaoCalculadaDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PontuacaoCalculada pontuacaocalculada) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pontuacaocalculada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PontuacaoCalculada pontuacaoCalculada) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pontuacaoCalculada = em.merge(pontuacaoCalculada);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pontuacaoCalculada.getId();
                if (findPontuacaoCalculada(id) == null) {
                    throw new NonexistentEntityException("The pontuacaocalculada with id " + id + " no longer exists.");
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
            PontuacaoCalculada pontuacaocalculada;
            try {
                pontuacaocalculada = em.getReference(PontuacaoCalculada.class, id);
                pontuacaocalculada.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pontuacaocalculada with id " + id + " no longer exists.", enfe);
            }
            em.remove(pontuacaocalculada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PontuacaoCalculada> findPontuacaoCalculadaEntities() {
        return findPontuacaoCalculadaEntities(true, -1, -1);
    }

    public List<PontuacaoCalculada> findPontuacaoCalculadaEntities(int maxResults, int firstResult) {
        return findPontuacaoCalculadaEntities(false, maxResults, firstResult);
    }

    private List<PontuacaoCalculada> findPontuacaoCalculadaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PontuacaoCalculada.class));
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

    public PontuacaoCalculada findPontuacaoCalculada(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PontuacaoCalculada.class, id);
        } finally {
            em.close();
        }
    }

    public int getPontuacaoCalculadaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PontuacaoCalculada> rt = cq.from(PontuacaoCalculada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void createLote(List<PontuacaoCalculada> pontuacoesCalculada) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            int contador = 1;
            for (PontuacaoCalculada pontuacaoCalculada : pontuacoesCalculada) {

                em.persist(pontuacaoCalculada);
                if (contador % 100 == 0) {
                    em.flush();
                    em.clear();
                }

                contador++;
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PontuacaoCalculada> calcularPontosPlay(Play play) {
        EntityManager em = getEntityManager();
        StringBuilder sm = new StringBuilder("SELECT NEW karaoke.model.PontuacaoCalculada(p.playID, p.cantorID, AVG(CAST(p.ponto AS Float)))");
        sm.append(" FROM Pontuacao p");
        sm.append(" WHERE p.playID=").append(play.getId());
        sm.append(" GROUP BY p.cantorID");

        try {
            TypedQuery<PontuacaoCalculada> q = em.createQuery(sm.toString(), PontuacaoCalculada.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Object[]> retornarTotalPontosCantores(String de, String ate) {
        EntityManager em = getEntityManager();

        StringBuilder sm = new StringBuilder("SELECT cantores.apelido , ROUND(AVG(total),3) AS total");
        sm.append(" FROM pontuacaocalculada");
        sm.append(" INNER JOIN cantores");
        sm.append(" ON pontuacaocalculada.cantorID=cantores.id");
        sm.append(" INNER JOIN play");
        sm.append(" ON pontuacaocalculada.playID=play.id");
        sm.append(" WHERE votacaoencerrada=1");
        sm.append(" AND dtcadastro BETWEEN '").append(de).append("' AND '").append(ate);
        sm.append("' GROUP BY cantorID");
        sm.append(" ORDER BY AVG(total) desc");
        sm.append(" LIMIT 10");

        try {
            Query q = em.createNativeQuery(sm.toString());
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Object[]> retornarUltimaVotacao() {
        EntityManager em = getEntityManager();

        StringBuilder sm = new StringBuilder("SELECT apelido, ROUND(AVG(total),3)");
        sm.append(" FROM pontuacaocalculada");
        sm.append(" INNER JOIN cantores");
        sm.append(" ON pontuacaocalculada.cantorID=cantores.id");
        sm.append(" WHERE playID=(SELECT MAX(playID) from pontuacaocalculada)");
        sm.append(" GROUP BY cantorID");
        sm.append(" ORDER BY AVG(total) desc");
        
        try {
            Query q = em.createNativeQuery(sm.toString());
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}
