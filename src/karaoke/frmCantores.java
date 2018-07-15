package karaoke;

import karaoke.control.CantorControl;

public class frmCantores extends javax.swing.JFrame {

    private CantorControl cantorControl;

    public frmCantores() {
        cantorControl = new CantorControl();
        initComponents();

    }

    public CantorControl getCantorControl() {
        return this.cantorControl;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        bg = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtApelido = new javax.swing.JTextField();
        txtCantor = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCantores = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1024, 700));
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(54, 33, 89));
        bg.setMinimumSize(new java.awt.Dimension(1024, 700));
        bg.setPreferredSize(new java.awt.Dimension(1024, 700));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        bg.add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Apelido");
        bg.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Nome");
        bg.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Código");
        bg.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtApelido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${cantorControl.cantorDigitado.apelido}"), txtApelido, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        bg.add(txtApelido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 370, -1));

        txtCantor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${cantorControl.cantorDigitado.nome}"), txtCantor, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtCantor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantorKeyReleased(evt);
            }
        });
        bg.add(txtCantor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 370, -1));

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtID.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${cantorControl.cantorDigitado.id}"), txtID, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        bg.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 120, -1));

        jScrollPane1.setBackground(new java.awt.Color(248, 248, 248));
        jScrollPane1.setBorder(null);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(810, 508));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(810, 508));

        tbCantores.setBackground(new java.awt.Color(248, 248, 248));
        tbCantores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbCantores.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbCantores.setForeground(new java.awt.Color(51, 51, 51));
        javax.swing.table.JTableHeader header = this.tbCantores.getTableHeader();
        header.setFont(new java.awt.Font("Segoe UI", 1, 18));
        tbCantores.setGridColor(new java.awt.Color(204, 204, 204));
        tbCantores.setRowHeight(30);
        tbCantores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbCantores.setShowVerticalLines(false);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${cantorControl.cantorTabela}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tbCantores);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Código");
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
        jTableBinding.bind();binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${cantorControl.cantorSelecionado}"), tbCantores, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(tbCantores);
        if (tbCantores.getColumnModel().getColumnCount() > 0) {
            tbCantores.getColumnModel().getColumn(0).setMinWidth(100);
            tbCantores.getColumnModel().getColumn(0).setMaxWidth(100);
            tbCantores.getColumnModel().getColumn(1).setMinWidth(300);
            tbCantores.getColumnModel().getColumn(1).setMaxWidth(300);
        }

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1024, 540));

        btnSalvar.setBackground(new java.awt.Color(85, 65, 118));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Add_Property_32px_2.png"))); // NOI18N
        btnSalvar.setToolTipText("Adicionar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        bg.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        btnPesquisar.setBackground(new java.awt.Color(85, 65, 118));
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Search_Property_32px.png"))); // NOI18N
        btnPesquisar.setToolTipText("Adicionar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        bg.add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));

        btnExcluir.setBackground(new java.awt.Color(85, 65, 118));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Delete_Document_32px.png"))); // NOI18N
        btnExcluir.setToolTipText("Adicionar");
        bg.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        btnEditar.setBackground(new java.awt.Color(85, 65, 118));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Edit_Property_32px_1.png"))); // NOI18N
        btnEditar.setToolTipText("Adicionar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        bg.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

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

        bindingGroup.bind();

        setSize(new java.awt.Dimension(1024, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        fechar();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtCantorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantorKeyReleased
        txtApelido.setText(this.txtCantor.getText());
    }//GEN-LAST:event_txtCantorKeyReleased

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        cantorControl.pesquisarNomeApelido();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            this.cantorControl.editar();
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex
                    .getMessage(), "Falha ao editar", 2);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            this.cantorControl.salvar();
            /*     */        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex
                    /* 218 */.getMessage(), "Falha ao Salvar", 2);
            /*     */        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCantores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCantores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCantores;
    private javax.swing.JTextField txtApelido;
    private javax.swing.JTextField txtCantor;
    private javax.swing.JTextField txtID;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
private void fechar() {
        dispose();
    }
}
