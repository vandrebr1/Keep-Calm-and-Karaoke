package karaoke;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import karaoke.control.MusicaControl;
import karaoke.model.Musica;
import karaoke.model.Sistema;
import karaoke.socket.EchoHandler;
import karaoke.socket.SocketServer;
import karaoke.util.Funcoes;

public final class frmPrincipal extends javax.swing.JFrame {

    private MusicaControl musicaControl;
    private final Musica musica = new Musica();
    private static final frmSplash frmsplash = new frmSplash();
    private Sistema sistema;
    SocketServer server;

    private static final String solve = "Solve";
    private static final String conexaoQRCode = "conexaoQRCode";
    private static final String conexaoQRCodeGrande = "conexaoQRCodeGrande";

    public frmPrincipal() {

        if (carregarSistema()) {
            this.musicaControl = new MusicaControl();
            frmsplash.lblStatus.setText("Sincronizando músicas...");
            this.musicaControl.carregarMusicas(this.sistema, frmsplash);
        }

        initComponents();
        lblQRCodeGrande.setVisible(false);
        btnSalvar.setVisible(false);
        this.tbMusicas.addMouseListener(new tbMusicasMouseAdapter(this.tbMusicas));

        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        this.tbMusicas.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, solve);
        this.tbMusicas.getActionMap().put(solve, new EnterAction());
        //animacaoNota();
        startServer();

    }

    private void startServer() {
        try {
            System.out.println("Start a server.");
            server = new SocketServer(5556, new EchoHandler());

            InetAddress ip = InetAddress.getLocalHost();
            String ipPorta = ip.getHostAddress() + " : " + server.getServerSocket().getLocalPort();
            gerarQRCodeConexao(ipPorta);
            txtIpPorta.setText(ipPorta);
            lblQRCode.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\" + conexaoQRCode + ".png"));
        } catch (IOException e) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Não foi possível conectar para votação, porta 5556. "
                    + "\nDeseja continuar?", "Erro de conexão socket", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (dialogResult == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Votação indiponível", ":(", JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                System.exit(0);
            }
        }

    }

    private class EnterAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            play();
        }
    }

    public MusicaControl getMusicaControl() {
        return this.musicaControl;
    }

    private class tbMusicasMouseAdapter extends java.awt.event.MouseAdapter {

        JTable table;

        public tbMusicasMouseAdapter(JTable table) {
            this.table = table;
        }

        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                frmPrincipal.this.play();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        bg = new javax.swing.JPanel();
        jpEsquerda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSobre = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnConfiguracoes = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnEstatisticas = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnCantores = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnPlay = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDireita = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtMusica = new javax.swing.JTextField();
        txtCantor = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        chkInternacional = new javax.swing.JCheckBox();
        chkNacional = new javax.swing.JCheckBox();
        lblQRCodeGrande = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMusicas = new javax.swing.JTable();
        btnPlayComCantor = new javax.swing.JButton();
        btnPlayAnonimo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lblQRCode = new javax.swing.JLabel();
        txtIpPorta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1024, 700));
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(204, 204, 204));
        bg.setMinimumSize(new java.awt.Dimension(1024, 700));
        bg.setPreferredSize(new java.awt.Dimension(1024, 700));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpEsquerda.setBackground(new java.awt.Color(54, 33, 89));
        jpEsquerda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Crown_64px.png"))); // NOI18N
        jpEsquerda.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, -1));

        jLabel2.setFont(new java.awt.Font("Keep Calm Med", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("KARAOKÊ");
        jpEsquerda.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 40));

        jLabel3.setFont(new java.awt.Font("Keep Calm Med", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("KEEP");
        jpEsquerda.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, -1));

        jLabel4.setFont(new java.awt.Font("Keep Calm Med", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CALM");
        jpEsquerda.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 210, -1));

        jLabel5.setFont(new java.awt.Font("Keep Calm Med", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("and");
        jpEsquerda.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 210, -1));

        btnSobre.setBackground(new java.awt.Color(64, 43, 100));
        btnSobre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSobre.setName("btnSobre"); // NOI18N
        btnSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSobreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSobreMouseEntered(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(204, 204, 204));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Sobre");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Info_24px.png"))); // NOI18N

        javax.swing.GroupLayout btnSobreLayout = new javax.swing.GroupLayout(btnSobre);
        btnSobre.setLayout(btnSobreLayout);
        btnSobreLayout.setHorizontalGroup(
            btnSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSobreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnSobreLayout.setVerticalGroup(
            btnSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSobreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(btnSobreLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpEsquerda.add(btnSobre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 210, 60));

        btnConfiguracoes.setBackground(new java.awt.Color(64, 43, 100));
        btnConfiguracoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfiguracoes.setName("btnConfiguracoes"); // NOI18N
        btnConfiguracoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfiguracoesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfiguracoesMouseEntered(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Configurações");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout btnConfiguracoesLayout = new javax.swing.GroupLayout(btnConfiguracoes);
        btnConfiguracoes.setLayout(btnConfiguracoesLayout);
        btnConfiguracoesLayout.setHorizontalGroup(
            btnConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnConfiguracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnConfiguracoesLayout.setVerticalGroup(
            btnConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnConfiguracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(btnConfiguracoesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpEsquerda.add(btnConfiguracoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 210, 60));

        btnEstatisticas.setBackground(new java.awt.Color(64, 43, 100));
        btnEstatisticas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstatisticas.setName("btnEstatisticas"); // NOI18N
        btnEstatisticas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstatisticasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEstatisticasMouseEntered(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Estatísticas");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Combo_Chart_24px.png"))); // NOI18N

        javax.swing.GroupLayout btnEstatisticasLayout = new javax.swing.GroupLayout(btnEstatisticas);
        btnEstatisticas.setLayout(btnEstatisticasLayout);
        btnEstatisticasLayout.setHorizontalGroup(
            btnEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEstatisticasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnEstatisticasLayout.setVerticalGroup(
            btnEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEstatisticasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(btnEstatisticasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpEsquerda.add(btnEstatisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 210, 60));

        btnCantores.setBackground(new java.awt.Color(64, 43, 100));
        btnCantores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCantores.setName("btnCantores"); // NOI18N
        btnCantores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCantoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCantoresMouseEntered(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Cantores");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Microphone_2_24px.png"))); // NOI18N

        javax.swing.GroupLayout btnCantoresLayout = new javax.swing.GroupLayout(btnCantores);
        btnCantores.setLayout(btnCantoresLayout);
        btnCantoresLayout.setHorizontalGroup(
            btnCantoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCantoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnCantoresLayout.setVerticalGroup(
            btnCantoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCantoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnCantoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(btnCantoresLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpEsquerda.add(btnCantores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 210, 60));

        btnPlay.setBackground(new java.awt.Color(85, 65, 118));
        btnPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlay.setName("btnPlay"); // NOI18N
        btnPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayMouseEntered(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Play");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Play_32px.png"))); // NOI18N

        javax.swing.GroupLayout btnPlayLayout = new javax.swing.GroupLayout(btnPlay);
        btnPlay.setLayout(btnPlayLayout);
        btnPlayLayout.setHorizontalGroup(
            btnPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPlayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnPlayLayout.setVerticalGroup(
            btnPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPlayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(btnPlayLayout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jpEsquerda.add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 210, 60));

        bg.add(jpEsquerda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 700));

        jDireita.setBackground(new java.awt.Color(54, 33, 89));
        jDireita.setMinimumSize(new java.awt.Dimension(810, 700));
        jDireita.setPreferredSize(new java.awt.Dimension(810, 700));
        jDireita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Close_Window_32px_roxo.png"))); // NOI18N
        jButton1.setToolTipText("Fechar");
        jButton1.setBorder(null);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setOpaque(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Close_Window_32px_vermelho.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDireita.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Música");
        jDireita.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Cantor/Banda");
        jDireita.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Código");
        jDireita.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtMusica.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${musicaControl.musicaDigitado.musica}"), txtMusica, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtMusica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMusicaKeyReleased(evt);
            }
        });
        jDireita.add(txtMusica, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 370, -1));

        txtCantor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${musicaControl.musicaDigitado.cantor}"), txtCantor, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtCantor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantorKeyReleased(evt);
            }
        });
        jDireita.add(txtCantor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 370, -1));

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${musicaControl.musicaDigitado.id}"), txtID, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jDireita.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 120, -1));

        chkInternacional.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chkInternacional.setForeground(new java.awt.Color(204, 204, 204));
        chkInternacional.setText("Internacional");
        chkInternacional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Circle_24px_1.png"))); // NOI18N
        chkInternacional.setOpaque(false);
        chkInternacional.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Checked_24px_1.png"))); // NOI18N
        chkInternacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkInternacionalActionPerformed(evt);
            }
        });
        jDireita.add(chkInternacional, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        chkNacional.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chkNacional.setForeground(new java.awt.Color(204, 204, 204));
        chkNacional.setText("Nacional");
        chkNacional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Circle_24px_1.png"))); // NOI18N
        chkNacional.setOpaque(false);
        chkNacional.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Checked_24px_1.png"))); // NOI18N
        chkNacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkNacionalActionPerformed(evt);
            }
        });
        jDireita.add(chkNacional, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        lblQRCodeGrande.setBackground(new java.awt.Color(54, 33, 89));
        lblQRCodeGrande.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQRCodeGrande.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/qrCodeGrande.png"))); // NOI18N
        lblQRCodeGrande.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQRCodeGrande.setOpaque(true);
        lblQRCodeGrande.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQRCodeGrandeMouseClicked(evt);
            }
        });
        jDireita.add(lblQRCodeGrande, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 280, 280));

        jScrollPane1.setBackground(new java.awt.Color(248, 248, 248));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(810, 508));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(810, 508));

        tbMusicas.setBackground(new java.awt.Color(248, 248, 248));
        tbMusicas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbMusicas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbMusicas.setForeground(new java.awt.Color(51, 51, 51));
        tbMusicas.setGridColor(new java.awt.Color(204, 204, 204));
        tbMusicas.setRowHeight(30);
        tbMusicas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbMusicas.setShowVerticalLines(false);
        javax.swing.table.JTableHeader header = this.tbMusicas.getTableHeader();
        header.setFont(new java.awt.Font("Segoe UI", 1, 18));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${musicaControl.musicaTabela}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tbMusicas);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${musica}"));
        columnBinding.setColumnName("Música");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cantor}"));
        columnBinding.setColumnName("Cantor");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nacional==1?'Sim':'Não'}"));
        columnBinding.setColumnName("Nacional");
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${musicaControl.musicaSelecionada}"), tbMusicas, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(tbMusicas);
        if (tbMusicas.getColumnModel().getColumnCount() > 0) {
            tbMusicas.getColumnModel().getColumn(2).setMinWidth(60);
            tbMusicas.getColumnModel().getColumn(2).setMaxWidth(60);
        }

        jDireita.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 814, -1));

        btnPlayComCantor.setBackground(new java.awt.Color(85, 65, 118));
        btnPlayComCantor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/play_jurados.png"))); // NOI18N
        btnPlayComCantor.setToolTipText("Play Cantor");
        btnPlayComCantor.setBorder(null);
        btnPlayComCantor.setFocusPainted(false);
        btnPlayComCantor.setOpaque(false);
        btnPlayComCantor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayComCantorActionPerformed(evt);
            }
        });
        jDireita.add(btnPlayComCantor, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 60, 55));

        btnPlayAnonimo.setBackground(new java.awt.Color(85, 65, 118));
        btnPlayAnonimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Play_Record_48px.png"))); // NOI18N
        btnPlayAnonimo.setToolTipText("Play Anônimo");
        btnPlayAnonimo.setBorder(null);
        btnPlayAnonimo.setFocusPainted(false);
        btnPlayAnonimo.setOpaque(false);
        btnPlayAnonimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayAnonimoActionPerformed(evt);
            }
        });
        jDireita.add(btnPlayAnonimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 60, 55));

        btnSalvar.setBackground(new java.awt.Color(85, 65, 118));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Add_Property_32px_2.png"))); // NOI18N
        btnSalvar.setToolTipText("Adicionar");
        btnSalvar.setEnabled(false);
        btnSalvar.setOpaque(false);
        jDireita.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        btnExcluir.setBackground(new java.awt.Color(85, 65, 118));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Delete_Document_32px.png"))); // NOI18N
        btnExcluir.setToolTipText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.setOpaque(false);
        jDireita.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        btnEditar.setBackground(new java.awt.Color(85, 65, 118));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Edit_Property_32px_1.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.setOpaque(false);
        jDireita.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        lblQRCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/qrCode.png"))); // NOI18N
        lblQRCode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQRCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQRCodeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQRCodeMouseExited(evt);
            }
        });
        jDireita.add(lblQRCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 150, 150));

        txtIpPorta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIpPorta.setForeground(new java.awt.Color(204, 204, 204));
        txtIpPorta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIpPorta.setText("IP: 255.255.255.255:5556");
        jDireita.add(txtIpPorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 170, 30));

        bg.add(jDireita, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 814, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        setSize(new java.awt.Dimension(1024, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseEntered
        setColor(this.btnPlay);
    }//GEN-LAST:event_btnPlayMouseEntered

    private void btnCantoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCantoresMouseEntered
        setColor(this.btnCantores);
    }//GEN-LAST:event_btnCantoresMouseEntered

    private void btnEstatisticasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstatisticasMouseEntered
        setColor(this.btnEstatisticas);    }//GEN-LAST:event_btnEstatisticasMouseEntered

    private void btnConfiguracoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracoesMouseEntered
        setColor(this.btnConfiguracoes);
    }//GEN-LAST:event_btnConfiguracoesMouseEntered

    private void btnSobreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSobreMouseEntered
        setColor(this.btnSobre);
    }//GEN-LAST:event_btnSobreMouseEntered

    private void chkNacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkNacionalActionPerformed
        this.musica.setNacional(1);
        this.musicaControl.setMusicaDigitada(this.musica);
        this.musicaControl.pesquisarMusicaCantorNacional(ignorarNacionalInternacional());
    }//GEN-LAST:event_chkNacionalActionPerformed

    private void chkInternacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkInternacionalActionPerformed
        this.chkNacional.setSelected(false);

        this.musica.setNacional(0);
        this.musicaControl.setMusicaDigitada(this.musica);
        this.musicaControl.pesquisarMusicaCantorNacional(ignorarNacionalInternacional());
    }//GEN-LAST:event_chkInternacionalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCantoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCantoresMouseClicked
        new frmCantores().setVisible(true);    }//GEN-LAST:event_btnCantoresMouseClicked

    private void btnConfiguracoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracoesMouseClicked
        new frmSistema().setVisible(true);
    }//GEN-LAST:event_btnConfiguracoesMouseClicked

    private void txtMusicaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMusicaKeyReleased
        this.musica.setMusica(this.txtMusica.getText());
        this.musicaControl.setMusicaDigitada(this.musica);
        this.musicaControl.pesquisarMusicaCantorNacional(this.ignorarNacionalInternacional());

    }//GEN-LAST:event_txtMusicaKeyReleased

    private void txtCantorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantorKeyReleased
        this.musica.setCantor(this.txtCantor.getText());
        this.musicaControl.setMusicaDigitada(this.musica);
        this.musicaControl.pesquisarMusicaCantorNacional(this.ignorarNacionalInternacional());
    }//GEN-LAST:event_txtCantorKeyReleased

    private void btnPlayAnonimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayAnonimoActionPerformed
        play();
    }//GEN-LAST:event_btnPlayAnonimoActionPerformed

    private void btnSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSobreMouseClicked
        new frmSobre().setVisible(true);
    }//GEN-LAST:event_btnSobreMouseClicked

    private void btnPlayComCantorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayComCantorActionPerformed

        if (this.musicaControl.getMusicaSelecionada() != null) {
            if (arquivoExiste()) {
                new frmCantoresSelecionar(this.musicaControl.getMusicaSelecionada(), server).setVisible(true);
            } else {
                try {
                    JOptionPane.showMessageDialog(this, "Não foi possível localizar essa música", "Opss...!", 1);
                    musicaControl.getMusicaDigitada().setDesativada(1);
                    musicaControl.editar();
                    musicaControl.pesquisarMusicaCantorNacional(ignorarNacionalInternacional());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao editar música", "Opss...!", 1);

                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma m\u00fasica primeiro", "Opss...!", 1);
        }


    }//GEN-LAST:event_btnPlayComCantorActionPerformed

    private void lblQRCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQRCodeMouseClicked
        lblQRCodeGrande.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\" + conexaoQRCodeGrande + ".png"));
        lblQRCodeGrande.setVisible(true);
    }//GEN-LAST:event_lblQRCodeMouseClicked

    private void lblQRCodeGrandeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQRCodeGrandeMouseClicked
    }//GEN-LAST:event_lblQRCodeGrandeMouseClicked

    private void lblQRCodeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQRCodeMouseExited
        lblQRCodeGrande.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_lblQRCodeMouseExited

    private void btnEstatisticasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstatisticasMouseClicked
        new frmEstatisticas().setVisible(true);
    }//GEN-LAST:event_btnEstatisticasMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        frmsplash.setVisible(true);

        frmPrincipal frmprincipal = new frmPrincipal();
        frmsplash.setVisible(false);
        frmsplash.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmprincipal.setVisible(true);
            }
        });

        //frmprincipal.animacaoNota();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btnCantores;
    private javax.swing.JPanel btnConfiguracoes;
    private javax.swing.JButton btnEditar;
    private javax.swing.JPanel btnEstatisticas;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JPanel btnPlay;
    private javax.swing.JButton btnPlayAnonimo;
    private javax.swing.JButton btnPlayComCantor;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel btnSobre;
    private javax.swing.JCheckBox chkInternacional;
    private javax.swing.JCheckBox chkNacional;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jDireita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpEsquerda;
    private javax.swing.JLabel lblQRCode;
    private javax.swing.JLabel lblQRCodeGrande;
    private javax.swing.JTable tbMusicas;
    private javax.swing.JTextField txtCantor;
    private javax.swing.JTextField txtID;
    private javax.swing.JLabel txtIpPorta;
    private javax.swing.JTextField txtMusica;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
private void setColor(JPanel panel) {
        for (java.awt.Component c : this.jpEsquerda.getComponents()) {
            if ((c instanceof JPanel)) {
                if (c.getName().equals(panel.getName())) {
                    panel.setBackground(new Color(85, 65, 118));
                } else {
                    c.setBackground(new Color(64, 43, 100));
                }
            }
        }
    }

    private boolean ignorarNacionalInternacional() {
        return (!this.chkNacional.isSelected()) && (!this.chkInternacional.isSelected());
    }

    private void play() {

        if (this.musicaControl.getMusicaSelecionada() != null) {
            String caminhoCompletoArquivo = this.sistema.getPastamusicas() + "\\";
            caminhoCompletoArquivo = caminhoCompletoArquivo + this.musicaControl.getMusicaSelecionada().getNomearquivooriginal();

            File myFile = new File(caminhoCompletoArquivo);
            try {
                java.awt.Desktop.getDesktop().open(myFile);
            } catch (java.io.IOException ex) {
                JOptionPane.showMessageDialog(this, ex
                        .getMessage(), "Opss...!", 2);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma música primeiro", "Opss...!", 1);
        }

    }

    public boolean carregarSistema() {
        karaoke.control.SistemaControl sistemaControl = new karaoke.control.SistemaControl();
        boolean blnConecatado = false;
        this.sistema = sistemaControl.getSistemaDigitado();

        if ((this.sistema.getPastamusicas() == null) || (this.sistema.getPastamusicas().equals(""))) {
            String pastamusicas = System.getProperty("user.dir") + "\\musicas";

            new File(pastamusicas).mkdirs();
            this.sistema.setPastamusicas(pastamusicas);
            try {
                sistemaControl.editar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex
                        .getMessage(), "Falha ao carregar sisitema", 2);
            }

        } else {
            new File(this.sistema.getPastamusicas()).mkdirs();
        }
        return true;
    }

    private void gerarQRCodeConexao(String ipPorta) {
        Funcoes.qrCodeGenerator(ipPorta, 150, conexaoQRCode);
        Funcoes.qrCodeGenerator(ipPorta, 264, conexaoQRCodeGrande);

    }

    private boolean arquivoExiste() {

        String caminhoCompletoArquivo = this.sistema.getPastamusicas() + "\\";
        caminhoCompletoArquivo = caminhoCompletoArquivo + this.musicaControl.getMusicaSelecionada().getNomearquivooriginal();
        File myFile = new File(caminhoCompletoArquivo);

        return myFile.exists();
    }

    private void animacaoNota() {

        Random rand = new Random();

        TimerTask tt = new TimerTask() {

            Integer inteiro;
            Integer decimal;

            @Override
            public void run() {
                inteiro = rand.nextInt(5 - 0) + 1;
                decimal = rand.nextInt(9 - 0) + 1;

                //lblInteiro.setText(inteiro.toString());
                //lblDecimal.setText(decimal.toString());
            }
        };

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(tt, 0, 1000);
    }

}
