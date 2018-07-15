package karaoke.control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import karaoke.dao.SistemaDao;
import karaoke.model.Sistema;

public class SistemaControl {

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private Sistema sistemaDigitado;
    private Sistema sistemaSelecionado;
    private List<Sistema> sistemaTabela;
    private final SistemaDao sistemaDao;

    public SistemaControl() {
        sistemaDao = new SistemaDao(Persistence.createEntityManagerFactory("karaokePU"));
        novo();
        pesquisar();
    }

    public void novo() {
        setSistemaDigitado(new Sistema());
    }

    public void pesquisar() {
        if (this.sistemaDao.findSistema(1) == null) {
            try {
                salvar();
            } catch (Exception ex) {
                Logger.getLogger(SistemaControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            setSistemaDigitado(this.sistemaDao.findSistema(Integer.valueOf(1)));
        }
    }

    public void salvar() throws Exception {
        this.sistemaDigitado.setId(Integer.valueOf(1));
        this.sistemaDao.create(this.sistemaDigitado);
    }

    public void editar() throws Exception {
        if (this.sistemaDigitado.getId() != null) {
            this.sistemaDao.edit(this.sistemaDigitado);
        }
    }

    public Sistema getSistemaDigitado() {
        return this.sistemaDigitado;
    }

    public void setSistemaDigitado(Sistema sistemaDigitado) {
        Sistema oldSistemaDigitado = this.sistemaDigitado;
        this.sistemaDigitado = sistemaDigitado;
        this.propertyChangeSupport.firePropertyChange("sistemaDigitado", oldSistemaDigitado, sistemaDigitado);
    }

    public Sistema getSistemaSelecionado() {
        return this.sistemaSelecionado;
    }

    public void setSistemaSelecionado(Sistema sistemaSelecionado) {
        this.sistemaSelecionado = sistemaSelecionado;
        if (this.sistemaSelecionado != null) {
            setSistemaDigitado(sistemaSelecionado);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.addPropertyChangeListener(e);
    }

    public void removePropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.removePropertyChangeListener(e);
    }
}
