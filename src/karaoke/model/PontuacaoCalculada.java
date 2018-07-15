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
@Table(name = "pontuacaocalculada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PontuacaoCalculada.findAll", query = "SELECT p FROM PontuacaoCalculada p")
    , @NamedQuery(name = "PontuacaoCalculada.findById", query = "SELECT p FROM PontuacaoCalculada p WHERE p.id = :id")
    , @NamedQuery(name = "PontuacaoCalculada.findByPlayID", query = "SELECT p FROM PontuacaoCalculada p WHERE p.playID = :playID")
    , @NamedQuery(name = "PontuacaoCalculada.findByCantorID", query = "SELECT p FROM PontuacaoCalculada p WHERE p.cantorID = :cantorID")
    , @NamedQuery(name = "PontuacaoCalculada.findByTotal", query = "SELECT p FROM PontuacaoCalculada p WHERE p.total = :total")})
public class PontuacaoCalculada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "playID")
    private int playID;
    @Basic(optional = false)
    @Column(name = "cantorID")
    private int cantorID;
    @Basic(optional = false)
    @Column(name = "total")
    private double total;

    public PontuacaoCalculada() {
    }

    public PontuacaoCalculada(Integer id) {
        this.id = id;
    }

    public PontuacaoCalculada(Integer id, int playID, int cantorID, double total) {
        this.id = id;
        this.playID = playID;
        this.cantorID = cantorID;
        this.total = total;
    }

    public PontuacaoCalculada(int playID, int cantorID, double total) {
        this.playID = playID;
        this.cantorID = cantorID;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPlayID() {
        return playID;
    }

    public void setPlayID(int playID) {
        this.playID = playID;
    }

    public int getCantorID() {
        return cantorID;
    }

    public void setCantorID(int cantorID) {
        this.cantorID = cantorID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        if (!(object instanceof PontuacaoCalculada)) {
            return false;
        }
        PontuacaoCalculada other = (PontuacaoCalculada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "karaoke.model.PontuacaoCalculada[ id=" + id + " ]";
    }

}
