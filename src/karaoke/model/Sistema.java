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
@Table(name = "sistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sistema.findAll", query = "SELECT s FROM Sistema s")
    , @NamedQuery(name = "Sistema.findById", query = "SELECT s FROM Sistema s WHERE s.id = :id")
    , @NamedQuery(name = "Sistema.findByPastamusicas", query = "SELECT s FROM Sistema s WHERE s.pastamusicas = :pastamusicas")})
public class Sistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "pastamusicas")
    private String pastamusicas;
    @Basic(optional = false)
    @Column(name = "ultimaopcaobatalha")
    private boolean ultimaopcaobatalha;

    public Sistema() {
    }

    public Sistema(Integer id, String pastamusicas, boolean ultimaopcaobatalha) {
        this.id = id;
        this.pastamusicas = pastamusicas;
        this.ultimaopcaobatalha = ultimaopcaobatalha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPastamusicas() {
        return pastamusicas;
    }

    public void setPastamusicas(String pastamusicas) {
        this.pastamusicas = pastamusicas;
    }

    public boolean getUltimaOpcaoBatalha() {
        return ultimaopcaobatalha;
    }

    public void setUltimaOpcaoBatalha(boolean ultimaopcaobatalha) {
        this.ultimaopcaobatalha = ultimaopcaobatalha;
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
        if (!(object instanceof Sistema)) {
            return false;
        }
        Sistema other = (Sistema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sistema{" + "id=" + id + ", pastamusicas=" + pastamusicas + ", ultimaopcaobatalha=" + ultimaopcaobatalha + '}';
    }

}
