/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karaoke.model;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vandré
 */
@Entity
@Table(name = "play")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Play.findAll", query = "SELECT p FROM Play p")
    , @NamedQuery(name = "Play.findById", query = "SELECT p FROM Play p WHERE p.id = :id")
    , @NamedQuery(name = "Play.findByDtcadastro", query = "SELECT p FROM Play p WHERE p.dtcadastro = :dtcadastro")})
public class Play implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "musicaID")
    @ManyToOne
    private Musica musica;
    @JoinColumn(name = "cantor1ID")
    private Cantor cantor1;
    @JoinColumn(name = "cantor2ID", nullable = true)
    private Cantor cantor2;
    @Basic(optional = false)
    @Column(name = "batalha")
    private boolean batalha;
    @Basic(optional = false)
    @Column(name = "dtcadastro")
    private String dtcadastro;
    @Basic(optional = false)
    @Column(name = "votacaoencerrada")
    private boolean votacaoEncerrada;
    @Basic(optional = false)
    @Column(name = "concluida")
    private boolean concluida;

    public Play() {

    }

    public Play(Integer id) {
        this.id = id;
    }

    public Play(Integer id, Musica musica, Cantor cantor1, Cantor cantor2, boolean batalha, String dtcadastro, boolean votacaoEncerrada, boolean concluida) {
        this.id = id;
        this.musica = musica;
        this.cantor1 = cantor1;
        this.cantor2 = cantor2;
        this.batalha = batalha;
        this.dtcadastro = dtcadastro;
        this.votacaoEncerrada = votacaoEncerrada;
        this.concluida = concluida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    public String getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(String dtcadastro) {
        this.dtcadastro = dtcadastro;
    }

    public Cantor getCantor1() {
        return cantor1;
    }

    public void setCantor1(Cantor cantor1) {
        this.cantor1 = cantor1;
    }

    public Cantor getCantor2() {
        return cantor2;
    }

    public void setCantor2(Cantor cantor2) {
        this.cantor2 = cantor2;
    }

    public boolean isBatalha() {
        return batalha;
    }

    public void setBatalha(boolean batalha) {
        this.batalha = batalha;
    }

    public boolean isVotacaoEncerrada() {
        return votacaoEncerrada;
    }

    public void setVotacaoEncerrada(boolean votacaoEncerrada) {
        this.votacaoEncerrada = votacaoEncerrada;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.musica);
        hash = 59 * hash + Objects.hashCode(this.cantor1);
        hash = 59 * hash + Objects.hashCode(this.cantor2);
        hash = 59 * hash + (this.batalha ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.dtcadastro);
        hash = 59 * hash + (this.votacaoEncerrada ? 1 : 0);
        hash = 59 * hash + (this.concluida ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Play other = (Play) obj;
        if (this.batalha != other.batalha) {
            return false;
        }
        if (this.votacaoEncerrada != other.votacaoEncerrada) {
            return false;
        }
        if (this.concluida != other.concluida) {
            return false;
        }
        if (!Objects.equals(this.dtcadastro, other.dtcadastro)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.musica, other.musica)) {
            return false;
        }
        if (!Objects.equals(this.cantor1, other.cantor1)) {
            return false;
        }
        if (!Objects.equals(this.cantor2, other.cantor2)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Play{" + "id=" + id
                + ", musica=" + musica
                + ", cantor1=" + cantor1
                + ", cantor2=" + cantor2
                + ", batalha=" + batalha
                + ", dtcadastro=" + dtcadastro
                + ", votacaoEncerrada=" + votacaoEncerrada
                + ", concluida=" + concluida + '}';
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
