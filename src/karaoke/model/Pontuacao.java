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
@Table(name = "pontuacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pontuacao.findAll", query = "SELECT p FROM Pontuacao p")
    , @NamedQuery(name = "Pontuacao.findById", query = "SELECT p FROM Pontuacao p WHERE p.id = :id")
    , @NamedQuery(name = "Pontuacao.findByPlayID", query = "SELECT p FROM Pontuacao p WHERE p.playID = :playID")
    , @NamedQuery(name = "Pontuacao.findByCantorID", query = "SELECT p FROM Pontuacao p WHERE p.cantorID = :cantorID")
    , @NamedQuery(name = "Pontuacao.findByPonto", query = "SELECT p FROM Pontuacao p WHERE p.ponto = :ponto")
    , @NamedQuery(name = "Pontuacao.findByImei", query = "SELECT p FROM Pontuacao p WHERE p.imei = :imei")
    , @NamedQuery(name = "Pontuacao.findByJurado", query = "SELECT p FROM Pontuacao p WHERE p.jurado = :jurado")})
public class Pontuacao implements Serializable {

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
    @Column(name = "ponto")
    private int ponto;
    @Basic(optional = false)
    @Column(name = "imei")
    private String imei;
    @Basic(optional = false)
    @Column(name = "jurado")
    private String jurado;

    public Pontuacao() {
    }

    public Pontuacao(Integer id) {
        this.id = id;
    }

    public Pontuacao(Integer id, int playID, int cantorID, int ponto, String imei, String jurado) {
        this.id = id;
        this.playID = playID;
        this.cantorID = cantorID;
        this.ponto = ponto;
        this.imei = imei;
        this.jurado = jurado;
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

    public int getPonto() {
        return ponto;
    }

    public void setPonto(int ponto) {
        this.ponto = ponto;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getJurado() {
        return jurado;
    }

    public void setJurado(String jurado) {
        this.jurado = jurado;
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
        if (!(object instanceof Pontuacao)) {
            return false;
        }
        Pontuacao other = (Pontuacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pontuacao{" + "id=" + id + ", playID=" + playID + ", cantorID=" + cantorID + ", ponto=" + ponto + ", imei=" + imei + ", jurado=" + jurado + '}';
    }

}
