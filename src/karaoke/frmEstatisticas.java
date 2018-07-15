package karaoke;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import karaoke.control.MusicaControl;
import karaoke.control.PlayControl;
import karaoke.control.PontuacaoCalculadaControl;
import karaoke.util.Funcoes;

public class frmEstatisticas extends javax.swing.JFrame {

    PlayControl playControl = new PlayControl();
    PontuacaoCalculadaControl pontuacaoCalculadaControl = new PontuacaoCalculadaControl();
    MusicaControl musicaControl = new MusicaControl();

    DefaultTableModel tbModelMusicasTop10;
    DefaultTableModel tbModelCantorTop10;
    DefaultTableModel tbModelMaisCantou;
    DefaultTableModel tbModelUltimaVotacao;

    public frmEstatisticas() {
        initComponents();
        iniciarDatas();
        iniciarTabelas();

        carregarMusicasTop10();
        carregarCantorTop10();
        carregarMaisCantou();
        carregarUltimaVotacao();

    }

    private void carregarMusicasTop10() {
        String de = Funcoes.formatarDataHora(dtDeMusicaTop10.getDate(), "yyyy-MM-dd 00:00:00");
        String ate = Funcoes.formatarDataHora(dtAteMusicaTop10.getDate(), "yyyy-MM-dd 23:59:59");

        preencherTabela(musicaControl.retornarMusicasMaisTocadas(de, ate), tbModelMusicasTop10);

    }

    private void carregarCantorTop10() {
        String de = Funcoes.formatarDataHora(dtDeCantoresTop10.getDate(), "yyyy-MM-dd 00:00:00");
        String ate = Funcoes.formatarDataHora(dtAteCantoresTop10.getDate(), "yyyy-MM-dd 23:59:59");

        preencherTabela(pontuacaoCalculadaControl.retornarTotalPontosCantores(de, ate), tbModelCantorTop10);

    }

    private void carregarMaisCantou() {
        String de = Funcoes.formatarDataHora(dtDeMaisCantou.getDate(), "yyyy-MM-dd 00:00:00");
        String ate = Funcoes.formatarDataHora(dtAteMaisCantou.getDate(), "yyyy-MM-dd 23:59:59");

        preencherTabela(playControl.retornarPlayCantoresMaisCantou(de, ate), tbModelMaisCantou);
    }

    private void carregarUltimaVotacao() {
        preencherTabela(pontuacaoCalculadaControl.retornarUltimaVotacao(), tbModelUltimaVotacao);
    }

    private void preencherTabela(List<Object[]> results, DefaultTableModel tabela) {
        tabela.setRowCount(0);
        for (Object[] result : results) {
            tabela.addRow(result);
        }
    }

    private void iniciarTabelas() {
        tbModelMusicasTop10 = (DefaultTableModel) tbMusicasTop10.getModel();
        tbModelCantorTop10 = (DefaultTableModel) tbCantoresTop10.getModel();
        tbModelMaisCantou = (DefaultTableModel) tbMaisCantou.getModel();
        tbModelUltimaVotacao = (DefaultTableModel) tbUltimaVotacao.getModel();

    }

    private void iniciarDatas() {
        Date hoje = new Date();
        Calendar cal = new GregorianCalendar();

        cal.setTime(hoje);
        cal.add(Calendar.DAY_OF_MONTH, -30);
        Date mesPassado = cal.getTime();

        cal.setTime(hoje);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date ontem = cal.getTime();

        dtDeMusicaTop10.setDate(mesPassado);
        dtDeCantoresTop10.setDate(ontem);
        dtDeMaisCantou.setDate(ontem);

        dtAteMusicaTop10.setDate(hoje);
        dtAteCantoresTop10.setDate(hoje);
        dtAteMaisCantou.setDate(hoje);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        jpMusicasTop10 = new javax.swing.JPanel();
        lblTituloMuiscaTop10 = new javax.swing.JLabel();
        tbMusicasTop10 = new javax.swing.JTable();
        lblDeMusicaTop10 = new javax.swing.JLabel();
        dtDeMusicaTop10 = new com.toedter.calendar.JDateChooser();
        lblAteMusicaTop10 = new javax.swing.JLabel();
        dtAteMusicaTop10 = new com.toedter.calendar.JDateChooser();
        btnAtualizarMusicaTop10 = new javax.swing.JButton();
        jpCantoresTop10 = new javax.swing.JPanel();
        lblCantoresTop10 = new javax.swing.JLabel();
        tbCantoresTop10 = new javax.swing.JTable();
        lblDeCantoresTop10 = new javax.swing.JLabel();
        dtDeCantoresTop10 = new com.toedter.calendar.JDateChooser();
        lbAteCaontoresTop10 = new javax.swing.JLabel();
        dtAteCantoresTop10 = new com.toedter.calendar.JDateChooser();
        btnAtualizarCantoresTop10 = new javax.swing.JButton();
        jpMaisCantou = new javax.swing.JPanel();
        lblMaisCantou = new javax.swing.JLabel();
        tbMaisCantou = new javax.swing.JTable();
        lblDeMaisCantou = new javax.swing.JLabel();
        dtDeMaisCantou = new com.toedter.calendar.JDateChooser();
        lblAteMaisCantou = new javax.swing.JLabel();
        dtAteMaisCantou = new com.toedter.calendar.JDateChooser();
        btnAtualizarMaisCantou = new javax.swing.JButton();
        jpUltimaVotacao = new javax.swing.JPanel();
        lblUltimaVotacao = new javax.swing.JLabel();
        tbUltimaVotacao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1024, 700));
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setUndecorated(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        bg.setBackground(new java.awt.Color(64, 43, 100));
        bg.setMinimumSize(new java.awt.Dimension(1024, 700));
        bg.setPreferredSize(new java.awt.Dimension(1024, 700));

        lblTitulo.setFont(new java.awt.Font("Keep Calm Med", 0, 22)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 0));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Estatísticas");

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

        jpMusicasTop10.setBackground(new java.awt.Color(54, 33, 89));

        lblTituloMuiscaTop10.setBackground(new java.awt.Color(85, 65, 118));
        lblTituloMuiscaTop10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloMuiscaTop10.setForeground(new java.awt.Color(255, 255, 0));
        lblTituloMuiscaTop10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloMuiscaTop10.setText("Top 10  - Músicas cantadas");
        lblTituloMuiscaTop10.setOpaque(true);

        tbMusicasTop10.setBackground(new java.awt.Color(54, 33, 89));
        tbMusicasTop10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbMusicasTop10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbMusicasTop10.setForeground(new java.awt.Color(255, 255, 0));
        tbMusicasTop10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon", null}
            },
            new String [] {
                "Música", "Qtdade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbMusicasTop10.setEnabled(false);
        tbMusicasTop10.setGridColor(new java.awt.Color(54, 33, 89));
        tbMusicasTop10.setOpaque(false);
        tbMusicasTop10.setRowHeight(25);
        tbMusicasTop10.setShowHorizontalLines(false);
        tbMusicasTop10.setShowVerticalLines(false);

        lblDeMusicaTop10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDeMusicaTop10.setForeground(new java.awt.Color(240, 240, 240));
        lblDeMusicaTop10.setText("De");

        dtDeMusicaTop10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblAteMusicaTop10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAteMusicaTop10.setForeground(new java.awt.Color(240, 240, 240));
        lblAteMusicaTop10.setText("Até");

        dtAteMusicaTop10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dtAteMusicaTop10.setOpaque(false);

        btnAtualizarMusicaTop10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Refresh_16px.png"))); // NOI18N
        btnAtualizarMusicaTop10.setOpaque(false);
        btnAtualizarMusicaTop10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarMusicaTop10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpMusicasTop10Layout = new javax.swing.GroupLayout(jpMusicasTop10);
        jpMusicasTop10.setLayout(jpMusicasTop10Layout);
        jpMusicasTop10Layout.setHorizontalGroup(
            jpMusicasTop10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMusicasTop10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jpMusicasTop10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbMusicasTop10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTituloMuiscaTop10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMusicasTop10Layout.createSequentialGroup()
                        .addComponent(lblDeMusicaTop10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtDeMusicaTop10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAteMusicaTop10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtAteMusicaTop10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizarMusicaTop10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))))
        );
        jpMusicasTop10Layout.setVerticalGroup(
            jpMusicasTop10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMusicasTop10Layout.createSequentialGroup()
                .addGap(2, 11, Short.MAX_VALUE)
                .addGroup(jpMusicasTop10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDeMusicaTop10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtDeMusicaTop10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAteMusicaTop10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtAteMusicaTop10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAtualizarMusicaTop10, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(lblTituloMuiscaTop10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbMusicasTop10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        if (tbMusicasTop10.getColumnModel().getColumnCount() > 0) {
            tbMusicasTop10.getColumnModel().getColumn(1).setMinWidth(70);
            tbMusicasTop10.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        jpCantoresTop10.setBackground(new java.awt.Color(54, 33, 89));

        lblCantoresTop10.setBackground(new java.awt.Color(85, 65, 118));
        lblCantoresTop10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCantoresTop10.setForeground(new java.awt.Color(255, 255, 0));
        lblCantoresTop10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantoresTop10.setText("Cantores pontuação - Média");
        lblCantoresTop10.setOpaque(true);

        tbCantoresTop10.setBackground(new java.awt.Color(54, 33, 89));
        tbCantoresTop10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbCantoresTop10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbCantoresTop10.setForeground(new java.awt.Color(255, 255, 0));
        tbCantoresTop10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon", null}
            },
            new String [] {
                "Música", "Qtdade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbCantoresTop10.setEnabled(false);
        tbCantoresTop10.setGridColor(new java.awt.Color(54, 33, 89));
        tbCantoresTop10.setOpaque(false);
        tbCantoresTop10.setRowHeight(25);
        tbCantoresTop10.setShowHorizontalLines(false);
        tbCantoresTop10.setShowVerticalLines(false);

        lblDeCantoresTop10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDeCantoresTop10.setForeground(new java.awt.Color(240, 240, 240));
        lblDeCantoresTop10.setText("De");

        dtDeCantoresTop10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbAteCaontoresTop10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbAteCaontoresTop10.setForeground(new java.awt.Color(240, 240, 240));
        lbAteCaontoresTop10.setText("Até");

        dtAteCantoresTop10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dtAteCantoresTop10.setOpaque(false);

        btnAtualizarCantoresTop10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Refresh_16px.png"))); // NOI18N
        btnAtualizarCantoresTop10.setOpaque(false);
        btnAtualizarCantoresTop10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarCantoresTop10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCantoresTop10Layout = new javax.swing.GroupLayout(jpCantoresTop10);
        jpCantoresTop10.setLayout(jpCantoresTop10Layout);
        jpCantoresTop10Layout.setHorizontalGroup(
            jpCantoresTop10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCantoresTop10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jpCantoresTop10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbCantoresTop10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantoresTop10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCantoresTop10Layout.createSequentialGroup()
                        .addComponent(lblDeCantoresTop10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtDeCantoresTop10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbAteCaontoresTop10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtAteCantoresTop10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizarCantoresTop10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))))
        );
        jpCantoresTop10Layout.setVerticalGroup(
            jpCantoresTop10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCantoresTop10Layout.createSequentialGroup()
                .addGap(2, 11, Short.MAX_VALUE)
                .addGroup(jpCantoresTop10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDeCantoresTop10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtDeCantoresTop10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAteCaontoresTop10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtAteCantoresTop10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAtualizarCantoresTop10, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(lblCantoresTop10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbCantoresTop10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        if (tbCantoresTop10.getColumnModel().getColumnCount() > 0) {
            tbCantoresTop10.getColumnModel().getColumn(1).setMinWidth(70);
            tbCantoresTop10.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        jpMaisCantou.setBackground(new java.awt.Color(54, 33, 89));

        lblMaisCantou.setBackground(new java.awt.Color(85, 65, 118));
        lblMaisCantou.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMaisCantou.setForeground(new java.awt.Color(255, 255, 0));
        lblMaisCantou.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaisCantou.setText("Quem mais cantou");
        lblMaisCantou.setOpaque(true);

        tbMaisCantou.setBackground(new java.awt.Color(54, 33, 89));
        tbMaisCantou.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbMaisCantou.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbMaisCantou.setForeground(new java.awt.Color(255, 255, 0));
        tbMaisCantou.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon", null}
            },
            new String [] {
                "Música", "Qtdade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbMaisCantou.setEnabled(false);
        tbMaisCantou.setGridColor(new java.awt.Color(54, 33, 89));
        tbMaisCantou.setOpaque(false);
        tbMaisCantou.setRowHeight(25);
        tbMaisCantou.setShowHorizontalLines(false);
        tbMaisCantou.setShowVerticalLines(false);

        lblDeMaisCantou.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDeMaisCantou.setForeground(new java.awt.Color(240, 240, 240));
        lblDeMaisCantou.setText("De");

        dtDeMaisCantou.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblAteMaisCantou.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAteMaisCantou.setForeground(new java.awt.Color(240, 240, 240));
        lblAteMaisCantou.setText("Até");

        dtAteMaisCantou.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dtAteMaisCantou.setOpaque(false);

        btnAtualizarMaisCantou.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Refresh_16px.png"))); // NOI18N
        btnAtualizarMaisCantou.setOpaque(false);
        btnAtualizarMaisCantou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarMaisCantouActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpMaisCantouLayout = new javax.swing.GroupLayout(jpMaisCantou);
        jpMaisCantou.setLayout(jpMaisCantouLayout);
        jpMaisCantouLayout.setHorizontalGroup(
            jpMaisCantouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMaisCantouLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jpMaisCantouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbMaisCantou, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaisCantou, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMaisCantouLayout.createSequentialGroup()
                        .addComponent(lblDeMaisCantou)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtDeMaisCantou, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAteMaisCantou)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtAteMaisCantou, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizarMaisCantou, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))))
        );
        jpMaisCantouLayout.setVerticalGroup(
            jpMaisCantouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMaisCantouLayout.createSequentialGroup()
                .addGap(2, 11, Short.MAX_VALUE)
                .addGroup(jpMaisCantouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDeMaisCantou, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtDeMaisCantou, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAteMaisCantou, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtAteMaisCantou, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAtualizarMaisCantou, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(lblMaisCantou, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbMaisCantou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        if (tbMaisCantou.getColumnModel().getColumnCount() > 0) {
            tbMaisCantou.getColumnModel().getColumn(1).setMinWidth(70);
            tbMaisCantou.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        jpUltimaVotacao.setBackground(new java.awt.Color(54, 33, 89));

        lblUltimaVotacao.setBackground(new java.awt.Color(85, 65, 118));
        lblUltimaVotacao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUltimaVotacao.setForeground(new java.awt.Color(255, 255, 0));
        lblUltimaVotacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUltimaVotacao.setText("Resultado última votação");
        lblUltimaVotacao.setOpaque(true);

        tbUltimaVotacao.setBackground(new java.awt.Color(54, 33, 89));
        tbUltimaVotacao.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbUltimaVotacao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbUltimaVotacao.setForeground(new java.awt.Color(255, 255, 0));
        tbUltimaVotacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"The Dark Side Of The Moon",  new Integer(999999)},
                {"The Dark Side Of The Moon",  new Integer(999999)}
            },
            new String [] {
                "Música", "Qtdade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbUltimaVotacao.setEnabled(false);
        tbUltimaVotacao.setGridColor(new java.awt.Color(54, 33, 89));
        tbUltimaVotacao.setOpaque(false);
        tbUltimaVotacao.setRowHeight(25);
        tbUltimaVotacao.setShowHorizontalLines(false);
        tbUltimaVotacao.setShowVerticalLines(false);

        javax.swing.GroupLayout jpUltimaVotacaoLayout = new javax.swing.GroupLayout(jpUltimaVotacao);
        jpUltimaVotacao.setLayout(jpUltimaVotacaoLayout);
        jpUltimaVotacaoLayout.setHorizontalGroup(
            jpUltimaVotacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUltimaVotacaoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jpUltimaVotacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbUltimaVotacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUltimaVotacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jpUltimaVotacaoLayout.setVerticalGroup(
            jpUltimaVotacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpUltimaVotacaoLayout.createSequentialGroup()
                .addComponent(lblUltimaVotacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbUltimaVotacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        if (tbUltimaVotacao.getColumnModel().getColumnCount() > 0) {
            tbUltimaVotacao.getColumnModel().getColumn(1).setMinWidth(70);
            tbUltimaVotacao.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(990, 990, 990)
                .addComponent(btnFechar))
            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jpMusicasTop10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jpCantoresTop10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jpMaisCantou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jpUltimaVotacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFechar)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpMusicasTop10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpCantoresTop10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpMaisCantou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpUltimaVotacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1024, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

    }//GEN-LAST:event_formWindowGainedFocus

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        fechar();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnAtualizarMusicaTop10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarMusicaTop10ActionPerformed
        carregarMusicasTop10();
    }//GEN-LAST:event_btnAtualizarMusicaTop10ActionPerformed

    private void btnAtualizarCantoresTop10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarCantoresTop10ActionPerformed
        carregarCantorTop10();
    }//GEN-LAST:event_btnAtualizarCantoresTop10ActionPerformed

    private void btnAtualizarMaisCantouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarMaisCantouActionPerformed
        carregarMaisCantou();
    }//GEN-LAST:event_btnAtualizarMaisCantouActionPerformed

    private void fechar() {
        this.dispose();
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
            java.util.logging.Logger.getLogger(frmEstatisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEstatisticas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnAtualizarCantoresTop10;
    private javax.swing.JButton btnAtualizarMaisCantou;
    private javax.swing.JButton btnAtualizarMusicaTop10;
    private javax.swing.JButton btnFechar;
    private com.toedter.calendar.JDateChooser dtAteCantoresTop10;
    private com.toedter.calendar.JDateChooser dtAteMaisCantou;
    private com.toedter.calendar.JDateChooser dtAteMusicaTop10;
    private com.toedter.calendar.JDateChooser dtDeCantoresTop10;
    private com.toedter.calendar.JDateChooser dtDeMaisCantou;
    private com.toedter.calendar.JDateChooser dtDeMusicaTop10;
    private javax.swing.JPanel jpCantoresTop10;
    private javax.swing.JPanel jpMaisCantou;
    private javax.swing.JPanel jpMusicasTop10;
    private javax.swing.JPanel jpUltimaVotacao;
    private javax.swing.JLabel lbAteCaontoresTop10;
    private javax.swing.JLabel lblAteMaisCantou;
    private javax.swing.JLabel lblAteMusicaTop10;
    private javax.swing.JLabel lblCantoresTop10;
    private javax.swing.JLabel lblDeCantoresTop10;
    private javax.swing.JLabel lblDeMaisCantou;
    private javax.swing.JLabel lblDeMusicaTop10;
    private javax.swing.JLabel lblMaisCantou;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloMuiscaTop10;
    private javax.swing.JLabel lblUltimaVotacao;
    private javax.swing.JTable tbCantoresTop10;
    private javax.swing.JTable tbMaisCantou;
    private javax.swing.JTable tbMusicasTop10;
    private javax.swing.JTable tbUltimaVotacao;
    // End of variables declaration//GEN-END:variables
}
