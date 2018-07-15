package karaoke.control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import javax.persistence.Persistence;
import karaoke.dao.PlayDao;
import karaoke.model.Play;

public class PlayControl {

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private Play playDigitado;
    private Play playSelecionado;
    private final PlayDao playDao;

    public PlayControl() {
        playDao = new PlayDao(Persistence.createEntityManagerFactory("karaokePU"));
        novo();
    }

    public void novo() {
        setPlayDigitado(new Play());
    }

    public void pesquisar() {
    }

    public void salvar() throws Exception {
        this.playDao.create(this.playDigitado);
    }

    public void editar() throws Exception {
        if (this.playDigitado.getId() != null) {
            this.playDao.edit(this.playDigitado);
        }
    }

    public Play getPlayDigitado() {
        return this.playDigitado;
    }

    public void setPlayDigitado(Play playDigitado) {
        Play oldPlayDigitado = this.playDigitado;
        this.playDigitado = playDigitado;
        this.propertyChangeSupport.firePropertyChange("playDigitado", oldPlayDigitado, playDigitado);
    }

    public Play getPlaySelecionado() {
        return this.playSelecionado;
    }

    public void setPlaySelecionado(Play playSelecionado) {
        this.playSelecionado = playSelecionado;
        if (this.playSelecionado != null) {
            setPlayDigitado(playSelecionado);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.addPropertyChangeListener(e);
    }

    public void removePropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.removePropertyChangeListener(e);
    }

    public void retornarUltimoPlayAberto() {
        setPlaySelecionado(playDao.findUltimoPlayAberto());
    }

    public List<Object[]> retornarPlayCantoresMaisCantou(String de, String ate) {

        return playDao.retornarMaisCantou(de, ate);
    }

    public boolean concluirTodas() {
        return playDao.concluirTodas();
    }
}
