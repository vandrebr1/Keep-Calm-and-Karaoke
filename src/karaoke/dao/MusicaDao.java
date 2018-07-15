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
import karaoke.frmSplash;
import karaoke.model.Musica;

/**
 *
 * @author Vandré
 */
public class MusicaDao implements Serializable {

    public MusicaDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Musica musica) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(musica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Musica musica) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            musica = em.merge(musica);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = musica.getId();
                if (findMusica(id) == null) {
                    throw new NonexistentEntityException("The musica with id " + id + " no longer exists.");
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
            Musica musica;
            try {
                musica = em.getReference(Musica.class, id);
                musica.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The musica with id " + id + " no longer exists.", enfe);
            }
            em.remove(musica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Musica> findMusicaEntities() {
        return findMusicaEntities(true, -1, -1);
    }

    public List<Musica> findMusicaEntities(int maxResults, int firstResult) {
        return findMusicaEntities(false, maxResults, firstResult);
    }

    private List<Musica> findMusicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Musica.class));
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

    public Musica findMusica(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Musica.class, id);
        } finally {
            em.close();
        }
    }

    public int getMusicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Musica> rt = cq.from(Musica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void createLote(List<Musica> musicas, frmSplash frmsplash) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            int contador = 1;

            for (Musica musica : musicas) {
                frmsplash.lblStatus.setText("Adicionando música: " + musica.getMusica());

                em.persist(musica);
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

    public boolean truncate() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            String sql = "delete from Musica m";
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

    public List<Musica> findMusicaByMusicaCantorNacional(Musica musica, boolean ignorarNacionalInternacional) {
        EntityManager em = getEntityManager();
        StringBuilder sm = new StringBuilder(" WHERE 1=1");
        try {
            if ((musica.getMusica() != null) && (!musica.getMusica().equals(""))) {
                sm.append(" AND m.musica LIKE '%").append(musica.getMusica()).append("%' ");
            }

            if ((musica.getCantor() != null) && (!musica.getCantor().equals(""))) {
                sm.append(" AND m.cantor LIKE '%").append(musica.getCantor()).append("%' ");
            }

            if (!ignorarNacionalInternacional) {
                sm.append(" AND m.nacional=").append(musica.getNacional());
            }
            sm.append(" AND m.desativada=0");

            TypedQuery<Musica> q = em.createQuery("SELECT m FROM Musica m" + sm.toString(), Musica.class);
            List<Musica> m = q.getResultList();
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Object[]> retornarMusicasMaisTocadas(String de, String ate) {
        EntityManager em = getEntityManager();

        StringBuilder sm = new StringBuilder("SELECT musica, count(musicaID) AS total");
        sm.append(" FROM musicas");
        sm.append(" INNER JOIN play");
        sm.append(" ON musicas.id=play.musicaID");
        sm.append(" WHERE votacaoencerrada=1");
        sm.append(" AND dtcadastro BETWEEN '").append(de).append("' AND '").append(ate);
        sm.append("' GROUP BY musicaID");
        sm.append(" ORDER BY COUNT(musicaID) desc");
        sm.append(" LIMIT 10");

        try {
            Query q = em.createNativeQuery(sm.toString());
            return q.getResultList();
        } finally {
            em.close();
        }
    }

}
