/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karaoke.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vandré
 */
@Entity
@Table(name = "musicas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musica.findAll", query = "SELECT m FROM Musica m")
    , @NamedQuery(name = "Musica.findById", query = "SELECT m FROM Musica m WHERE m.id = :id")
    , @NamedQuery(name = "Musica.findByNomearquivooriginal", query = "SELECT m FROM Musica m WHERE m.nomearquivooriginal = :nomearquivooriginal")
    , @NamedQuery(name = "Musica.findByMusica", query = "SELECT m FROM Musica m WHERE m.musica = :musica")
    , @NamedQuery(name = "Musica.findByCantor", query = "SELECT m FROM Musica m WHERE m.cantor = :cantor")
    , @NamedQuery(name = "Musica.findByNacional", query = "SELECT m FROM Musica m WHERE m.nacional = :nacional")
    , @NamedQuery(name = "Musica.findByDesativada", query = "SELECT m FROM Musica m WHERE m.desativada = :desativada")})
public class Musica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nomearquivooriginal")
    private String nomearquivooriginal;
    @Basic(optional = false)
    @Column(name = "musica")
    private String musica;
    @Basic(optional = false)
    @Column(name = "cantor")
    private String cantor;
    @Basic(optional = false)
    @Column(name = "nacional")
    private int nacional;
    @Basic(optional = false)
    @Column(name = "desativada")
    private int desativada;

    public Musica() {
    }

    public Musica(Integer id) {
        this.id = id;
    }

    public Musica(Integer id, String nomearquivooriginal, String musica, String cantor, int nacional, int desativada) {
        this.id = id;
        this.nomearquivooriginal = nomearquivooriginal;
        this.musica = musica;
        this.cantor = cantor;
        this.nacional = nacional;
        this.desativada = desativada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomearquivooriginal() {
        return nomearquivooriginal;
    }

    public void setNomearquivooriginal(String nomearquivooriginal) {
        this.nomearquivooriginal = nomearquivooriginal;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public int getNacional() {
        return nacional;
    }

    public void setNacional(int nacional) {
        this.nacional = nacional;
    }

    public int getDesativada() {
        return desativada;
    }

    public void setDesativada(int desativada) {
        this.desativada = desativada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musica)) {
            return false;
        }
        Musica other = (Musica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Musica{" + "id=" + id + ", nomearquivooriginal=" + nomearquivooriginal + ", musica=" + musica + ", cantor=" + cantor + ", nacional=" + nacional + ", desativada=" + desativada + '}';
    }

}
