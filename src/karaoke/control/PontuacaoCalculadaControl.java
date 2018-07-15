package karaoke.control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import karaoke.dao.PontuacaoCalculadaDao;
import karaoke.model.Play;
import karaoke.model.PontuacaoCalculada;

public class PontuacaoCalculadaControl {

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private PontuacaoCalculada pontuacaoCalculadaDigitado;
    private PontuacaoCalculada pontuacaoCalculadaSelecionado;
    private final PontuacaoCalculadaDao pontuacaoCalculadaDao;
    private List<PontuacaoCalculada> pontuacoesCalculada;

    public PontuacaoCalculadaControl() {
        pontuacaoCalculadaDao = new PontuacaoCalculadaDao(Persistence.createEntityManagerFactory("karaokePU"));
        this.pontuacoesCalculada = new ArrayList<>();
        novo();
    }

    public void novo() {
        setPontuacaoCalculadaDigitado(new PontuacaoCalculada());
    }

    public void pesquisar() {
    }

    public void calcularPontuacao(Play play) {
        pontuacoesCalculada.clear();
        pontuacoesCalculada.addAll(pontuacaoCalculadaDao.calcularPontosPlay(play));
        pontuacaoCalculadaDao.createLote(pontuacoesCalculada);
    }

    public List<PontuacaoCalculada> getPontuacoesCalculada() {
        return this.pontuacoesCalculada;
    }

    public void setPontuacoesCalculada(List<PontuacaoCalculada> pontuacoesCalculada) {
        this.pontuacoesCalculada = pontuacoesCalculada;
    }

    public void salvar() throws Exception {
        this.pontuacaoCalculadaDao.create(this.pontuacaoCalculadaDigitado);
    }

    public void editar() throws Exception {
        if (this.pontuacaoCalculadaDigitado.getId() != null) {
            this.pontuacaoCalculadaDao.edit(this.pontuacaoCalculadaDigitado);
        }
    }

    public PontuacaoCalculada getPontuacaoCalculadaDigitado() {
        return this.pontuacaoCalculadaDigitado;
    }

    public void setPontuacaoCalculadaDigitado(PontuacaoCalculada pontuacaoCalculadaDigitado) {
        PontuacaoCalculada oldPontuacaoCalculadaDigitado = this.pontuacaoCalculadaDigitado;
        this.pontuacaoCalculadaDigitado = pontuacaoCalculadaDigitado;
        this.propertyChangeSupport.firePropertyChange("pontuacaoCalculadaDigitado", oldPontuacaoCalculadaDigitado, pontuacaoCalculadaDigitado);
    }

    public PontuacaoCalculada getPontuacaoCalculadaSelecionado() {
        return this.pontuacaoCalculadaSelecionado;
    }

    public void setPontuacaoSelecionado(PontuacaoCalculada pontuacaoCalculadaSelecionado) {
        this.pontuacaoCalculadaSelecionado = pontuacaoCalculadaSelecionado;
        if (this.pontuacaoCalculadaSelecionado != null) {
            setPontuacaoCalculadaDigitado(pontuacaoCalculadaSelecionado);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.addPropertyChangeListener(e);
    }

    public void removePropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.removePropertyChangeListener(e);
    }

    public List<Object[]> retornarTotalPontosCantores(String de, String ate) {

        return pontuacaoCalculadaDao.retornarTotalPontosCantores(de, ate);
    }

    public List<Object[]> retornarUltimaVotacao() {

        return pontuacaoCalculadaDao.retornarUltimaVotacao();
    }
}
