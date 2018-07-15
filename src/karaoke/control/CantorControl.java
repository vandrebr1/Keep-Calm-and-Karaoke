package karaoke.control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import karaoke.dao.CantorDao;
import karaoke.dao.exceptions.NonexistentEntityException;
import karaoke.model.Cantor;
import org.jdesktop.observablecollections.ObservableCollections;

public class CantorControl {

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private Cantor cantorDigitado;
    private Cantor cantorSelecionado;
    private List<Cantor> cantoresTabela;
    private final CantorDao cantorDao;

    public CantorControl() {
        this.cantorDao = new CantorDao(Persistence.createEntityManagerFactory("karaokePU"));
        this.cantoresTabela = ObservableCollections.observableList(new ArrayList());
        novo();
        pesquisar();
    }

    public void novo() {
        setCantorDigitado(new Cantor());
    }

    public void pesquisar() {
        this.cantoresTabela.clear();
        this.cantoresTabela.addAll(this.cantorDao.findCantorEntities());
    }

    public void pesquisarNomeApelido() {
        this.cantoresTabela.clear();
        this.cantoresTabela.addAll(this.cantorDao.findCantorByNameApelido(this.cantorDigitado));
    }

    public void salvar() throws Exception {
        this.cantorDigitado.setId(null);
        this.cantorDao.create(this.cantorDigitado);
        novo();
        pesquisar();
    }

    public void editar() throws Exception {
        if (this.cantorDigitado.getId() != null) {
            this.cantorDao.edit(this.cantorDigitado);
            novo();
            pesquisar();
        }
    }

    public void excluir() throws NonexistentEntityException {
        if (this.cantorDigitado.getId() != null) {
            this.cantorDao.destroy(this.cantorDigitado.getId());
            novo();
            pesquisar();
        }
    }

    public Cantor getCantorDigitado() {
        return this.cantorDigitado;
    }

    public void setCantorDigitado(Cantor cantorDigitado) {
        Cantor oldCantorDigitado = this.cantorDigitado;
        this.cantorDigitado = cantorDigitado;
        this.propertyChangeSupport.firePropertyChange("cantorDigitado", oldCantorDigitado, cantorDigitado);
    }

    public Cantor getCantorSelecionado() {
        return this.cantorSelecionado;
    }

    public void setCantorSelecionado(Cantor cantorSelecionado) {
        this.cantorSelecionado = cantorSelecionado;
        if (this.cantorSelecionado != null) {
            setCantorDigitado(cantorSelecionado);
        }
    }

    public List<Cantor> getCantorTabela() {
        return this.cantoresTabela;
    }

    public void setCantorTabela(List<Cantor> cantoresTabela) {
        this.cantoresTabela = cantoresTabela;
    }

    public void addPropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.addPropertyChangeListener(e);
    }

    public void removePropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.removePropertyChangeListener(e);
    }
}
