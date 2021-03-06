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
@Table(name = "cantores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cantor.findAll", query = "SELECT c FROM Cantor c")
    , @NamedQuery(name = "Cantor.findById", query = "SELECT c FROM Cantor c WHERE c.id = :id")
    , @NamedQuery(name = "Cantor.findByNome", query = "SELECT c FROM Cantor c WHERE c.nome = :nome")
    , @NamedQuery(name = "Cantor.findByApelido", query = "SELECT c FROM Cantor c WHERE c.apelido = :apelido")})
public class Cantor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "apelido")
    private String apelido;

    public Cantor() {
    }

    public Cantor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
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
        if (!(object instanceof Cantor)) {
            return false;
        }
        Cantor other = (Cantor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cantor{" + "id=" + id + ", nome=" + nome + ", apelido=" + apelido + '}';
    }

}
