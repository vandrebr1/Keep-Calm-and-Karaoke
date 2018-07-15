package karaoke;

import com.google.gson.Gson;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import karaoke.control.PlayControl;
import karaoke.control.PontuacaoCalculadaControl;
import karaoke.model.Pontuacao;
import karaoke.model.PontuacaoCalculada;
import karaoke.socket.ConnectionThread;
import static karaoke.socket.MessageFlag.KEY_ULTIMORESULTADO;
import karaoke.socket.SocketServer;
import karaoke.util.Funcoes;

public class frmVotacao extends javax.swing.JFrame {

    SocketServer server;
    private PlayControl playControl;
    private PontuacaoCalculada pontuacaoCalculada;
    private Pontuacao pontuacao;
    Clip clip;
    TimerTask tt;
    Timer timer = new Timer();
    Thread t;
    Double totalCantor1 = 0.0;
    Double totalCantor2 = 0.0;
    Double totalNaoBatalha = 0.0;

    public frmVotacao(PlayControl playControl, SocketServer server) {
        this.server = server;
        this.playControl = playControl;
        this.initComponents();

        lblMusica.setText(playControl.getPlaySelecionado().getMusica().getMusica() + " - "
                + playControl.getPlaySelecionado().getMusica().getCantor());
        lblCantor1.setText(playControl.getPlaySelecionado().getCantor1().getApelido());

        lblVotacaoEncerrada.setVisible(false);

        verificarCantor2();

    }

    public PlayControl getPlayControl() {
        return this.playControl;
    }

    private void verificarCantor2() {
        if (playControl.getPlaySelecionado().getCantor2() == null) {
            lblCantor2.setText("Seria melhor ter ido ver o filme do Pelé");
            lblIconeBatalha.setIcon(null);
            jpStarsCantor2.setVisible(false);
            lblNotaCantor2.setVisible(false);
            lblCantor2.setVisible(false);

        } else {
            lblCantor2.setText(playControl.getPlaySelecionado().getCantor2().getApelido());
            if (playControl.getPlaySelecionado().isBatalha()) {
                lblIconeBatalha.setIcon(new ImageIcon(this.getClass().getResource("/karaoke/imagens/versus.png")));

            } else {
                lblIconeBatalha.setIcon(new ImageIcon(this.getClass().getResource("/karaoke/imagens/speech-circle-blue-80.png")));
            }
        }
    }

    private void desenharEstrelas(JPanel jp, String meiaEstrela, Double cantorPontosTotal) {
        int i = 0;
        double resto;

        for (Component c : jp.getComponents()) {
            if (c instanceof JLabel) {

                if (i < cantorPontosTotal.intValue()) {
                    ((JLabel) c).setIcon(new ImageIcon(this.getClass().getResource("/karaoke/imagens/star_enable_full.png")));
                } else {
                    resto = cantorPontosTotal - i;
                    if (resto >= 0.5 && resto <= 1.0) {
                        ((JLabel) c).setIcon(new ImageIcon(this.getClass().getResource("/karaoke/imagens/star_enable_half_" + meiaEstrela + ".png")));
                    } else {
                        ((JLabel) c).setIcon(new ImageIcon(this.getClass().getResource("/karaoke/imagens/star_enable.png")));
                    }

                }
                i++;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cantorRemover = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        jpStarsCantor1 = new javax.swing.JPanel();
        lblStar1Cantor1 = new javax.swing.JLabel();
        lblStar2Cantor1 = new javax.swing.JLabel();
        lblStar3Cantor1 = new javax.swing.JLabel();
        lblStar4Cantor1 = new javax.swing.JLabel();
        lblStar5Cantor1 = new javax.swing.JLabel();
        lblCantor1 = new javax.swing.JLabel();
        lblNotaCantor1 = new javax.swing.JLabel();
        lblCantor2 = new javax.swing.JLabel();
        lblIconeBatalha = new javax.swing.JLabel();
        lblMusica = new javax.swing.JLabel();
        jpStarsCantor2 = new javax.swing.JPanel();
        lblStar1Cantor2 = new javax.swing.JLabel();
        lblStar2Cantor2 = new javax.swing.JLabel();
        lblStar3Cantor2 = new javax.swing.JLabel();
        lblStar4Cantor2 = new javax.swing.JLabel();
        lblStar5Cantor2 = new javax.swing.JLabel();
        lblNotaCantor2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnEncerrarVotacao = new javax.swing.JButton();
        lblVotacaoEncerrada = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1024, 700));
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setUndecorated(true);

        cantorRemover.setBackground(new java.awt.Color(54, 33, 89));
        cantorRemover.setMinimumSize(new java.awt.Dimension(1024, 700));
        cantorRemover.setPreferredSize(new java.awt.Dimension(1024, 700));
        cantorRemover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Close_Window_32px_roxo.png"))); // NOI18N
        btnFechar.setToolTipText("Fechar");
        btnFechar.setBorder(null);
        btnFechar.setFocusPainted(false);
        btnFechar.setFocusable(false);
        btnFechar.setOpaque(false);
        btnFechar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Close_Window_32px_vermelho.png"))); // NOI18N
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        cantorRemover.add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, -1, -1));

        jpStarsCantor1.setOpaque(false);
        jpStarsCantor1.setLayout(new java.awt.GridBagLayout());

        lblStar1Cantor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStar1Cantor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/star_disable.png"))); // NOI18N
        jpStarsCantor1.add(lblStar1Cantor1, new java.awt.GridBagConstraints());

        lblStar2Cantor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStar2Cantor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/star_disable.png"))); // NOI18N
        jpStarsCantor1.add(lblStar2Cantor1, new java.awt.GridBagConstraints());

        lblStar3Cantor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStar3Cantor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/star_disable.png"))); // NOI18N
        jpStarsCantor1.add(lblStar3Cantor1, new java.awt.GridBagConstraints());

        lblStar4Cantor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStar4Cantor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/star_disable.png"))); // NOI18N
        jpStarsCantor1.add(lblStar4Cantor1, new java.awt.GridBagConstraints());

        lblStar5Cantor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStar5Cantor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/star_disable.png"))); // NOI18N
        jpStarsCantor1.add(lblStar5Cantor1, new java.awt.GridBagConstraints());

        cantorRemover.add(jpStarsCantor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 178, 470, -1));

        lblCantor1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCantor1.setForeground(new java.awt.Color(255, 255, 0));
        lblCantor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantor1.setText("Selecione o cantor 1");
        cantorRemover.add(lblCantor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 470, 60));

        lblNotaCantor1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblNotaCantor1.setForeground(new java.awt.Color(204, 204, 204));
        lblNotaCantor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNotaCantor1.setText("Aguardando votação");
        cantorRemover.add(lblNotaCantor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 470, 70));

        lblCantor2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCantor2.setForeground(new java.awt.Color(255, 255, 0));
        lblCantor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantor2.setText("Selecione o cantor 2");
        cantorRemover.add(lblCantor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 470, 60));

        lblIconeBatalha.setBackground(new java.awt.Color(64, 43, 100));
        lblIconeBatalha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblIconeBatalha.setForeground(new java.awt.Color(204, 204, 204));
        lblIconeBatalha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconeBatalha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/versus.png"))); // NOI18N
        lblIconeBatalha.setOpaque(true);
        cantorRemover.add(lblIconeBatalha, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 80, 210));

        lblMusica.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblMusica.setForeground(new java.awt.Color(255, 255, 0));
        lblMusica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMusica.setText("Música - Cantor");
        cantorRemover.add(lblMusica, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 110));

        jpStarsCantor2.setOpaque(false);
        jpStarsCantor2.setLayout(new java.awt.GridBagLayout());

        lblStar1Cantor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStar1Cantor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/star_disable.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        jpStarsCantor2.add(lblStar1Cantor2, gridBagConstraints);

        lblStar2Cantor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStar2Cantor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/star_disable.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        jpStarsCantor2.add(lblStar2Cantor2, gridBagConstraints);

        lblStar3Cantor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStar3Cantor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/star_disable.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        jpStarsCantor2.add(lblStar3Cantor2, gridBagConstraints);

        lblStar4Cantor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStar4Cantor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/star_disable.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        jpStarsCantor2.add(lblStar4Cantor2, gridBagConstraints);

        lblStar5Cantor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStar5Cantor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/star_disable.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        jpStarsCantor2.add(lblStar5Cantor2, gridBagConstraints);

        cantorRemover.add(jpStarsCantor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 178, 470, -1));

        lblNotaCantor2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblNotaCantor2.setForeground(new java.awt.Color(204, 204, 204));
        lblNotaCantor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNotaCantor2.setText("Aguardando votação");
        cantorRemover.add(lblNotaCantor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 472, 70));

        jPanel1.setBackground(new java.awt.Color(64, 43, 100));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        cantorRemover.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1024, 210));

        btnEncerrarVotacao.setText("Encerrar votação");
        btnEncerrarVotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrarVotacaoActionPerformed(evt);
            }
        });
        cantorRemover.add(btnEncerrarVotacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, 30));

        lblVotacaoEncerrada.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblVotacaoEncerrada.setForeground(new java.awt.Color(204, 204, 204));
        lblVotacaoEncerrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVotacaoEncerrada.setText("Votação encerrada!");
        cantorRemover.add(lblVotacaoEncerrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1024, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cantorRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cantorRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1024, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        try {
            if (clip != null) {
                clip.stop();
            }
            playControl.getPlayDigitado().setConcluida(true);
            playControl.editar();
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha ao editar: " + ex.getMessage(),
                    "Opss...!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnEncerrarVotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarVotacaoActionPerformed
        lblVotacaoEncerrada.setVisible(true);
        btnEncerrarVotacao.setVisible(false);
        lblVotacaoEncerrada.setText("Calculando votos");
        animacaoNotaIniciar();

    }//GEN-LAST:event_btnEncerrarVotacaoActionPerformed

    private void encerrarVotacao() {

        try {
            playControl.getPlayDigitado().setVotacaoEncerrada(true);
            playControl.getPlayDigitado().setConcluida(true);
            playControl.editar();
            PontuacaoCalculadaControl pontuacaoCalculadaControl = new PontuacaoCalculadaControl();
            pontuacaoCalculadaControl.calcularPontuacao(playControl.getPlayDigitado());

            for (PontuacaoCalculada pontuacaoCalculada : pontuacaoCalculadaControl.getPontuacoesCalculada()) {
                if (playControl.getPlayDigitado().getCantor1().getId() == pontuacaoCalculada.getCantorID()) {
                    totalCantor1 = pontuacaoCalculada.getTotal();
                    totalNaoBatalha = totalCantor1;
                }
                if (playControl.getPlayDigitado().getCantor2() != null) {
                    if (playControl.getPlayDigitado().getCantor2().getId() == pontuacaoCalculada.getCantorID()) {
                        totalCantor2 = pontuacaoCalculada.getTotal();

                        if (!playControl.getPlayDigitado().isBatalha()) {
                            totalNaoBatalha = (totalCantor1 + totalCantor2) / 2;
                        }
                    }
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha ao editar: " + ex.getMessage(),
                    "Opss...!", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void calculoSomNota(Double nota) {
        if (nota >= 4) {
            tocarEfeito("bom.wav", false);
        } else if (nota >= 2.5) {
            tocarEfeito("medio.wav", false);
        } else {
            tocarEfeito("ruim.wav", false);
        }
    }

    private void tocarEfeito(String filename, boolean aguardar) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(System.getProperty("user.dir") + "\\sons\\" + filename)));
            clip.start();

            if (!aguardar) {

                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }

        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException exc) {
            exc.printStackTrace(System.out);
        }
    }

    private void animacaoNotaIniciar() {

        Random rand = new Random();

        tt = new TimerTask() {

            Integer inteiro;
            Integer decimal;
            boolean iniciou = false;

            @Override
            public void run() {

                inteiro = rand.nextInt(5 - 0) + 1;

                if (inteiro == 5) {
                    decimal = 0;
                } else {
                    decimal = rand.nextInt(9 - 0) + 1;
                }

                lblNotaCantor1.setText(inteiro.toString() + "," + decimal.toString());
                lblNotaCantor2.setText(inteiro.toString() + "," + decimal.toString());

                desenharEstrelas(jpStarsCantor1, "esquerda", Double.parseDouble(inteiro + "." + decimal));
                desenharEstrelas(jpStarsCantor2, "direita", Double.parseDouble(inteiro + "." + decimal));
                
                if (!iniciou) {
                    iniciou = true;
                    tocarEfeito("rufartambores.wav", true);
                    encerrarVotacao();
                }

                if (clip.getMicrosecondLength() - 1200000 <= clip.getMicrosecondPosition()) {
                    animacaoNotaParar();
                }

            }
        };

        timer.scheduleAtFixedRate(tt, 0, 100);

    }

    private void animacaoNotaParar() {
        tt.cancel();
        timer.cancel();

        if (playControl.getPlayDigitado().isBatalha()) {
            desenharEstrelas(jpStarsCantor1, "esquerda", totalCantor1);
            desenharEstrelas(jpStarsCantor2, "direita", totalCantor2);

            lblNotaCantor1.setText(Funcoes.formatarDecimal(totalCantor1, 1));
            lblNotaCantor2.setText(Funcoes.formatarDecimal(totalCantor2, 1));
            calculoSomNota((totalCantor1 + totalCantor2) / 2);
        } else {
            desenharEstrelas(jpStarsCantor1, "esquerda", totalNaoBatalha);
            desenharEstrelas(jpStarsCantor2, "direita", totalNaoBatalha);

            lblNotaCantor1.setText(Funcoes.formatarDecimal(totalNaoBatalha, 1));
            lblNotaCantor2.setText(Funcoes.formatarDecimal(totalNaoBatalha, 1));
            calculoSomNota(totalNaoBatalha);
        }

        lblVotacaoEncerrada.setText("Votação encerrada!");

        enviarMensagemTodos();

    }

    private void enviarMensagemTodos() {
        Gson gson = new Gson();
        StringBuilder resposta = new StringBuilder(KEY_ULTIMORESULTADO);
        String retorno;
        PontuacaoCalculadaControl pontuacaoCalculadaControl = new PontuacaoCalculadaControl();
        List<Object[]> results = pontuacaoCalculadaControl.retornarUltimaVotacao();

        for (Object[] result : results) {
            resposta.append(result[0].toString()).append(": ").append(result[1].toString()).append("|");
        }

        retorno = resposta.substring(0, resposta.length() - 1);

        List<ConnectionThread> connectionThreads = server.getListeningThread().getConnectionThreads();
        for (ConnectionThread cnThread : connectionThreads) {
            cnThread.getConnection().println(retorno);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEncerrarVotacao;
    private javax.swing.JButton btnFechar;
    private javax.swing.JPanel cantorRemover;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpStarsCantor1;
    private javax.swing.JPanel jpStarsCantor2;
    private javax.swing.JLabel lblCantor1;
    private javax.swing.JLabel lblCantor2;
    private javax.swing.JLabel lblIconeBatalha;
    private javax.swing.JLabel lblMusica;
    private javax.swing.JLabel lblNotaCantor1;
    private javax.swing.JLabel lblNotaCantor2;
    private javax.swing.JLabel lblStar1Cantor1;
    private javax.swing.JLabel lblStar1Cantor2;
    private javax.swing.JLabel lblStar2Cantor1;
    private javax.swing.JLabel lblStar2Cantor2;
    private javax.swing.JLabel lblStar3Cantor1;
    private javax.swing.JLabel lblStar3Cantor2;
    private javax.swing.JLabel lblStar4Cantor1;
    private javax.swing.JLabel lblStar4Cantor2;
    private javax.swing.JLabel lblStar5Cantor1;
    private javax.swing.JLabel lblStar5Cantor2;
    private javax.swing.JLabel lblVotacaoEncerrada;
    // End of variables declaration//GEN-END:variables
}
