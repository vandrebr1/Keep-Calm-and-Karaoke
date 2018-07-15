package karaoke.control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.persistence.Persistence;
import karaoke.dao.PontuacaoDao;
import karaoke.model.Pontuacao;

public class PontuacaoControl {

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private Pontuacao pontuacaoDigitado;
    private Pontuacao pontuacaoSelecionado;
    private final PontuacaoDao pontuacaoDao;

    public PontuacaoControl() {
        pontuacaoDao = new PontuacaoDao(Persistence.createEntityManagerFactory("karaokePU"));
        novo();
    }

    public void novo() {
        setPontuacaoDigitado(new Pontuacao());
    }

    public void pesquisar() {
    }

    public void salvar() throws Exception {
        this.pontuacaoDao.create(this.pontuacaoDigitado);
    }

    public void editar() throws Exception {
        if (this.pontuacaoDigitado.getId() != null) {
            this.pontuacaoDao.edit(this.pontuacaoDigitado);
        }
    }

    public Pontuacao getPontuacaoDigitado() {
        return this.pontuacaoDigitado;
    }

    public void setPontuacaoDigitado(Pontuacao pontuacaoDigitado) {
        Pontuacao oldPontuacaoDigitado = this.pontuacaoDigitado;
        this.pontuacaoDigitado = pontuacaoDigitado;
        this.propertyChangeSupport.firePropertyChange("pontuacaoDigitado", oldPontuacaoDigitado, pontuacaoDigitado);
    }

    public Pontuacao getPontuacaoSelecionado() {
        return this.pontuacaoSelecionado;
    }

    public void setPontuacaoSelecionado(Pontuacao pontuacaoSelecionado) {
        this.pontuacaoSelecionado = pontuacaoSelecionado;
        if (this.pontuacaoSelecionado != null) {
            setPontuacaoDigitado(pontuacaoSelecionado);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.addPropertyChangeListener(e);
    }

    public void removePropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.removePropertyChangeListener(e);
    }
}
