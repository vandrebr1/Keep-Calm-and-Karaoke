package karaoke;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import karaoke.control.CantorControl;
import karaoke.control.PlayControl;
import karaoke.control.SistemaControl;
import karaoke.model.Cantor;
import karaoke.model.Musica;
import karaoke.model.Play;
import karaoke.model.Sistema;
import karaoke.socket.ConnectionThread;
import static karaoke.socket.MessageFlag.KEY_SOLICITARCANTORES;
import karaoke.socket.SocketServer;
import karaoke.util.Funcoes;

public class frmCantoresSelecionar extends javax.swing.JFrame {

    private final CantorControl cantorControl;
    private final Cantor cantorProcura;
    private Cantor cantor1;
    private Cantor cantor2;
    private final Musica musica;
    private final Sistema sistema;
    private final SistemaControl sistemaControl;
    private static final String solve = "Solve";
    private final SocketServer server;

    public frmCantoresSelecionar(Musica musica, SocketServer server) {
        this.cantorProcura = new Cantor();
        this.musica = musica;
        this.cantorControl = new CantorControl();
        this.sistemaControl = new SistemaControl();
        this.server = server;
        sistema = sistemaControl.getSistemaDigitado();
        this.initComponents();
        chkBatalha.setSelected(sistema.getUltimaOpcaoBatalha());
        verificarBatalha();
        this.lblMusica.setText(musica.getMusica() + " - " + musica.getCantor());

        this.tbCantores.addMouseListener(new tbCantoresMouseAdapter(this.tbCantores));

        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        this.tbCantores.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, solve);
        this.tbCantores.getActionMap().put(solve, new EnterAction());
    }

    public CantorControl getCantorControl() {
        return this.cantorControl;
    }

    public SistemaControl getSistemaControl() {
        return this.sistemaControl;
    }

    private class EnterAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            adicionarCantor();
        }
    }

    private class tbCantoresMouseAdapter extends java.awt.event.MouseAdapter {

        JTable table;

        public tbCantoresMouseAdapter(JTable table) {
            this.table = table;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                adicionarCantor();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        cantorRemover = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        lblCoroa1 = new javax.swing.JLabel();
        lblCantor1 = new javax.swing.JLabel();
        lblCantor2 = new javax.swing.JLabel();
        lblCoroa2 = new javax.swing.JLabel();
        chkBatalha = new javax.swing.JCheckBox();
        lblIconeBatalha = new javax.swing.JLabel();
        lblMusica = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCantores = new javax.swing.JTable();
        btnCantorExcluir = new javax.swing.JButton();
        btnCantorAdicionar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtApelido = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();

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

        lblCoroa1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCoroa1.setForeground(new java.awt.Color(204, 204, 204));
        lblCoroa1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCoroa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Crown_32px_1.png"))); // NOI18N
        lblCoroa1.setText("Cantor 1");
        lblCoroa1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/disable_icons8_Crown_32px_2.png"))); // NOI18N
        lblCoroa1.setEnabled(false);
        cantorRemover.add(lblCoroa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 30, -1));

        lblCantor1.setFont(new java.awt.Font("Keep Calm Med", 0, 18)); // NOI18N
        lblCantor1.setForeground(new java.awt.Color(204, 204, 204));
        lblCantor1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCantor1.setText("Selecione o cantor 1");
        cantorRemover.add(lblCantor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 340, -1));

        lblCantor2.setFont(new java.awt.Font("Keep Calm Med", 0, 18)); // NOI18N
        lblCantor2.setForeground(new java.awt.Color(204, 204, 204));
        lblCantor2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCantor2.setText("Selecione o cantor 2");
        cantorRemover.add(lblCantor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 340, -1));

        lblCoroa2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCoroa2.setForeground(new java.awt.Color(204, 204, 204));
        lblCoroa2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCoroa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Crown_32px_1.png"))); // NOI18N
        lblCoroa2.setText("Cantor 1");
        lblCoroa2.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/disable_icons8_Crown_32px_2.png"))); // NOI18N
        lblCoroa2.setEnabled(false);
        cantorRemover.add(lblCoroa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 110, 30, -1));

        chkBatalha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chkBatalha.setForeground(new java.awt.Color(204, 204, 204));
        chkBatalha.setText("Batalha");
        chkBatalha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Circle_24px_1.png"))); // NOI18N
        chkBatalha.setOpaque(false);
        chkBatalha.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Checked_24px_1.png"))); // NOI18N
        chkBatalha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBatalhaActionPerformed(evt);
            }
        });
        cantorRemover.add(chkBatalha, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 100, -1));

        lblIconeBatalha.setBackground(new java.awt.Color(64, 43, 100));
        lblIconeBatalha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblIconeBatalha.setForeground(new java.awt.Color(204, 204, 204));
        lblIconeBatalha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconeBatalha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/versus.png"))); // NOI18N
        lblIconeBatalha.setOpaque(true);
        cantorRemover.add(lblIconeBatalha, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 80, 80));

        lblMusica.setFont(new java.awt.Font("Keep Calm Med", 0, 22)); // NOI18N
        lblMusica.setForeground(new java.awt.Color(255, 255, 0));
        lblMusica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMusica.setText("Música - Cantor");
        cantorRemover.add(lblMusica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1010, 50));

        jLabel18.setBackground(new java.awt.Color(64, 43, 100));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Contacts_100px.png"))); // NOI18N
        jLabel18.setOpaque(true);
        cantorRemover.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 472, 160));

        jLabel26.setBackground(new java.awt.Color(64, 43, 100));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Contacts_100px.png"))); // NOI18N
        jLabel26.setOpaque(true);
        cantorRemover.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 472, 160));

        jScrollPane1.setBackground(new java.awt.Color(248, 248, 248));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(810, 508));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(810, 508));

        tbCantores.setBackground(new java.awt.Color(248, 248, 248));
        tbCantores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbCantores.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbCantores.setForeground(new java.awt.Color(51, 51, 51));
        tbCantores.setGridColor(new java.awt.Color(204, 204, 204));
        tbCantores.setRowHeight(30);
        tbCantores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbCantores.setShowVerticalLines(false);
        javax.swing.table.JTableHeader header = this.tbCantores.getTableHeader();
        header.setFont(new java.awt.Font("Segoe UI", 1, 18));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${cantorControl.cantorTabela}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tbCantores);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Cód.");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${apelido}"));
        columnBinding.setColumnName("Apelido");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${cantorControl.cantorSelecionado}"), tbCantores, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(tbCantores);
        if (tbCantores.getColumnModel().getColumnCount() > 0) {
            tbCantores.getColumnModel().getColumn(0).setMinWidth(60);
            tbCantores.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        cantorRemover.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1024, 400));

        btnCantorExcluir.setBackground(new java.awt.Color(85, 65, 118));
        btnCantorExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Denied_32px.png"))); // NOI18N
        btnCantorExcluir.setToolTipText("Excluir");
        btnCantorExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCantorExcluir.setOpaque(false);
        btnCantorExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantorExcluirActionPerformed(evt);
            }
        });
        cantorRemover.add(btnCantorExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 228, -1, 58));

        btnCantorAdicionar.setBackground(new java.awt.Color(85, 65, 118));
        btnCantorAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Add_User_Male_32px.png"))); // NOI18N
        btnCantorAdicionar.setToolTipText("Adicionar");
        btnCantorAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCantorAdicionar.setOpaque(false);
        cantorRemover.add(btnCantorAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 228, -1, 58));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Apelido");
        cantorRemover.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 70, 20));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Nome");
        cantorRemover.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 60, 20));

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });
        cantorRemover.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 370, -1));

        txtApelido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtApelido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApelidoKeyReleased(evt);
            }
        });
        cantorRemover.add(txtApelido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 370, -1));

        jPanel1.setBackground(new java.awt.Color(64, 43, 100));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        cantorRemover.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 80, 160));

        btnPlay.setBackground(new java.awt.Color(85, 65, 118));
        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Play_Record_48px.png"))); // NOI18N
        btnPlay.setToolTipText("Play Anônimo");
        btnPlay.setBorder(null);
        btnPlay.setFocusPainted(false);
        btnPlay.setOpaque(false);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        cantorRemover.add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 228, 70, 58));

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

        bindingGroup.bind();

        setSize(new java.awt.Dimension(1024, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void chkBatalhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBatalhaActionPerformed
        sistema.setUltimaOpcaoBatalha(chkBatalha.isSelected());
        verificarBatalha();
        try {
            this.sistemaControl.setSistemaDigitado(sistema);
            this.sistemaControl.editar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Falha ao Salvar", 2);
        }
    }//GEN-LAST:event_chkBatalhaActionPerformed

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        this.cantorProcura.setNome(this.txtNome.getText());
        this.cantorControl.setCantorDigitado(this.cantorProcura);
        this.cantorControl.pesquisarNomeApelido();
    }//GEN-LAST:event_txtNomeKeyReleased

    private void txtApelidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApelidoKeyReleased
        this.cantorProcura.setApelido(this.txtApelido.getText());
        this.cantorControl.setCantorDigitado(this.cantorProcura);
        this.cantorControl.pesquisarNomeApelido();
    }//GEN-LAST:event_txtApelidoKeyReleased

    private void btnCantorExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantorExcluirActionPerformed
        removerCantor();
    }//GEN-LAST:event_btnCantorExcluirActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        play();
    }//GEN-LAST:event_btnPlayActionPerformed

    private void verificarBatalha() {
        if (chkBatalha.isSelected()) {
            lblIconeBatalha.setIcon(new ImageIcon(this.getClass().getResource("/karaoke/imagens/versus.png")));

        } else {
            lblIconeBatalha.setIcon(new ImageIcon(this.getClass().getResource("/karaoke/imagens/speech-circle-blue-80.png")));
        }

    }

    private void play() {

        if (this.musica != null) {
            String caminhoCompletoArquivo = this.sistema.getPastamusicas() + "\\";
            caminhoCompletoArquivo = caminhoCompletoArquivo + this.musica.getNomearquivooriginal();

            File myFile = new File(caminhoCompletoArquivo);

            if (cantor1 != null) {
                try {
                    String dataHora = Funcoes.formatarDataHora(new Date(), "yyyy-MM-dd HH:mm:ss");

                    Play play = new Play(null, musica, cantor1, cantor2,
                            sistema.getUltimaOpcaoBatalha(), dataHora, false, false);

                    PlayControl playControl = new PlayControl();

                    if (playControl.concluirTodas()) {
                        playControl.setPlayDigitado(play);
                        playControl.salvar();

                        playControl.retornarUltimoPlayAberto();
                        java.awt.Desktop.getDesktop().open(myFile);

                        frmVotacao aguardar = new frmVotacao(playControl, server);

                        aguardar.setVisible(true);

                        if (server != null) {
                            String formartarSolicitarCantroes = KEY_SOLICITARCANTORES + playControl.getPlaySelecionado().toJson();
                            enviarMensagemTodos(formartarSolicitarCantroes);
                        }

                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao encerrar ultima votação., \nNão é possível continuar", "Opss...!", JOptionPane.WARNING_MESSAGE);

                    }

                } catch (java.io.IOException ex) {
                    JOptionPane.showMessageDialog(this, ex
                            .getMessage(), "Opss...!", 2);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex
                            .getMessage(), "Opss...!", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(frmCantoresSelecionar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma música primeiro", "Opss...!", 1);
        }

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCantoresSelecionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new frmCantoresSelecionar(new Musica(), null).setVisible(true);
        });
    }

    private void adicionarCantor() {
        if (cantor1 == null) {
            cantor1 = new Cantor();
            cantor1 = cantorControl.getCantorSelecionado();
            lblCantor1.setText(cantor1.getApelido());
            lblCantor1.setForeground(new java.awt.Color(255, 255, 0));
            lblCoroa1.setEnabled(true);
        } else {
            if (cantor1.getId() != cantorControl.getCantorSelecionado().getId()) {
                cantor2 = new Cantor();
                cantor2 = cantorControl.getCantorSelecionado();
                lblCantor2.setText(cantor2.getApelido());
                lblCantor2.setForeground(new java.awt.Color(255, 255, 0));
                lblCoroa2.setEnabled(true);
            }
        }
    }

    private void removerCantor() {

        if (cantor2 != null) {
            cantor2 = null;
            lblCantor2.setText("Selecione o cantor 2");
            lblCantor2.setForeground(new java.awt.Color(204, 204, 204));
            lblCoroa2.setEnabled(false);
        } else {
            cantor1 = null;
            lblCantor1.setText("Selecione o cantor 1");
            lblCantor1.setForeground(new java.awt.Color(204, 204, 204));

            lblCoroa1.setEnabled(false);
        }
    }

    private void enviarMensagemTodos(String formartarSolicitarCantroes) {
        List<ConnectionThread> connectionThreads = server.getListeningThread().getConnectionThreads();
        for (ConnectionThread cnThread : connectionThreads) {
            cnThread.getConnection().println(formartarSolicitarCantroes);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCantorAdicionar;
    private javax.swing.JButton btnCantorExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPlay;
    private javax.swing.JPanel cantorRemover;
    private javax.swing.JCheckBox chkBatalha;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantor1;
    private javax.swing.JLabel lblCantor2;
    private javax.swing.JLabel lblCoroa1;
    private javax.swing.JLabel lblCoroa2;
    private javax.swing.JLabel lblIconeBatalha;
    private javax.swing.JLabel lblMusica;
    private javax.swing.JTable tbCantores;
    private javax.swing.JTextField txtApelido;
    private javax.swing.JTextField txtNome;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
