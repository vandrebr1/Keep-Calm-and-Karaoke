package karaoke.control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import karaoke.dao.MusicaDao;
import karaoke.dao.exceptions.IllegalOrphanException;
import karaoke.dao.exceptions.NonexistentEntityException;
import karaoke.frmSplash;
import karaoke.model.Musica;
import karaoke.model.Sistema;
import karaoke.util.Funcoes;
import org.jdesktop.observablecollections.ObservableCollections;

public class MusicaControl {

    private final PropertyChangeSupport propertyChangeSupport;
    private Musica musicaDigitada;
    private Musica musicaSelecionada;
    private List<Musica> musicasTabela;
    private MusicaDao musicaDao;

    public MusicaControl() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        this.musicaDao = new MusicaDao(Persistence.createEntityManagerFactory("karaokePU"));
        this.musicasTabela = ObservableCollections.observableList(new ArrayList());
        this.novo();
        this.pesquisar();
    }

    public MusicaControl(final boolean truncate) {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        this.musicaDao = new MusicaDao(Persistence.createEntityManagerFactory("karaokePU"));
    }

    public void novo() {
        this.setMusicaDigitada(new Musica());
    }

    public void pesquisar() {
        this.musicasTabela.clear();
        this.musicasTabela.addAll(this.musicaDao.findMusicaByMusicaCantorNacional(musicaDigitada, true));
    }

    public void salvar() throws Exception {
        this.musicaDigitada.setId(null);
        this.musicaDao.create(this.musicaDigitada);
        this.pesquisar();
    }

    public void pesquisarMusicaCantorNacional(final boolean ignorarNacionalInternacional) {
        this.musicasTabela.clear();
        this.musicasTabela.addAll(this.musicaDao.findMusicaByMusicaCantorNacional(this.musicaDigitada, ignorarNacionalInternacional));
    }

    public void editar() throws Exception {
        if (this.musicaDigitada.getId() != null) {
            this.musicaDao.edit(this.musicaDigitada);
            this.pesquisar();
            this.novo();
        }
    }

    public void desativar() throws Exception {
        if (this.musicaDigitada.getId() != null) {
            this.musicaDao.edit(this.musicaDigitada);
            this.pesquisar();
        }
    }

    public void excluir() throws IllegalOrphanException, NonexistentEntityException {
        if (this.musicaDigitada.getId() != null) {
            this.musicaDao.destroy(this.musicaDigitada.getId());
            this.novo();
            this.pesquisar();
        }
    }

    public boolean truncate() {
        return this.musicaDao.truncate();
    }

    public Musica getMusicaDigitada() {
        return this.musicaDigitada;
    }

    public void setMusicaDigitada(final Musica musicaDigitada) {
        final Musica oldMusicaDigitada = this.musicaDigitada;
        this.musicaDigitada = musicaDigitada;
        this.propertyChangeSupport.firePropertyChange("musicaDigitada", oldMusicaDigitada, musicaDigitada);
    }

    public Musica getMusicaSelecionada() {
        return this.musicaSelecionada;
    }

    public void setMusicaSelecionada(final Musica musicaSelecionada) {
        this.musicaSelecionada = musicaSelecionada;
        if (this.musicaSelecionada != null) {
            this.setMusicaDigitada(musicaSelecionada);
        }
    }

    public List<Musica> getMusicaTabela() {
        return this.musicasTabela;
    }

    public void setMusicaTabela(final List<Musica> musicasTabela) {
        this.musicasTabela = musicasTabela;
    }

    public void addPropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.addPropertyChangeListener(e);
    }

    public void removePropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.removePropertyChangeListener(e);
    }

    public boolean carregarMusicas(Sistema sistema, frmSplash frmsplash) {
        try {
            final Stream<Path> paths = Files.walk(Paths.get(sistema.getPastamusicas()));
            final List<Musica> musicasArquivo = this.prepararMusica(paths, frmsplash);
            if (this.getMusicaTabela().isEmpty()) {
                this.musicaDao.createLote(musicasArquivo, frmsplash);
            } else {
                final List<Musica> musicaNaoCadastrada = new ArrayList<>();
                for (final Musica musicaArquivo : musicasArquivo) {
                    final boolean isMusicaCadastrada = this.musicasTabela.stream().filter(o -> o.getNomearquivooriginal().equals(musicaArquivo.getNomearquivooriginal())).findFirst().isPresent();
                    if (!isMusicaCadastrada) {
                        musicaNaoCadastrada.add(musicaArquivo);
                    }
                }
                this.musicaDao.createLote(musicaNaoCadastrada, frmsplash);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frmsplash, "Erro: " + ex, "Falha ao salvar m\u00fasica", 2);
        }
        this.pesquisar();

        return true;
    }

    public List<Musica> prepararMusica(final Stream<Path> paths, final frmSplash frmsplash) {
        List<Musica> musicas = new ArrayList<>();

        paths.filter(Files::isRegularFile).forEach(filePath -> {
            boolean musicaOK;
            do {
                Musica musica = new Musica();
                musica.setId(null);
                musica.setDesativada(0);
                musica.setNomearquivooriginal(filePath.getFileName().toString());
                frmsplash.lblStatus.setText("Analisando o arquivo: " + musica.getNomearquivooriginal());

                String[] arrArquivo = filePath.getFileName().toString().split(";");
                if (arrArquivo.length == 3) {
                    musica.setCantor(Funcoes.primeiraMaiuscula(arrArquivo[0].trim().toLowerCase()));
                    musica.setMusica(Funcoes.primeiraMaiuscula(arrArquivo[1].trim().toLowerCase()));
                    musica.setNacional(1);
                    String nacional = String.valueOf(arrArquivo[2].trim().charAt(0));
                    if (Funcoes.isInteger(nacional) && (Integer.valueOf(nacional) == 0 || Integer.valueOf(nacional) == 1)) {
                        musica.setNacional(Integer.valueOf(nacional));
                    }
                    musicas.add(musica);
                    musicaOK = true;
                } else {
                    musicaOK = (JOptionPane.showConfirmDialog(frmsplash, "Arquivo não está no formato correto: " + musica.getNomearquivooriginal() + "\n\nTentar novamente?", "Falha ao salvar música", 0) != 0);
                }
            } while (!musicaOK);
        });
        return musicas;
    }

    public List<Object[]> retornarMusicasMaisTocadas(String de, String ate) {

        return musicaDao.retornarMusicasMaisTocadas(de, ate);
    }
}
