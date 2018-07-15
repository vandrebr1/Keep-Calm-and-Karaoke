package karaoke;

import javax.swing.JOptionPane;
import karaoke.control.MusicaControl;
import karaoke.control.SistemaControl;

public class frmSistema extends javax.swing.JFrame {

    private final SistemaControl sistemaControl;

    public frmSistema() {
        sistemaControl = new SistemaControl();
        initComponents();

    }

    public SistemaControl getSistemaControl() {
        return this.sistemaControl;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        bg = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtPastaMusicas = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        btnLimparTabelaMusicas = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

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

        bg.setBackground(new java.awt.Color(54, 33, 89));
        bg.setMinimumSize(new java.awt.Dimension(1024, 700));
        bg.setPreferredSize(new java.awt.Dimension(1024, 700));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Pasta de musicas");
        bg.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Código");
        bg.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtPastaMusicas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${sistemaControl.sistemaDigitado.pastamusicas}"), txtPastaMusicas, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        bg.add(txtPastaMusicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 370, -1));

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtID.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${sistemaControl.sistemaDigitado.id}"), txtID, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        bg.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 120, -1));

        btnLimparTabelaMusicas.setBackground(new java.awt.Color(85, 65, 118));
        btnLimparTabelaMusicas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLimparTabelaMusicas.setForeground(new java.awt.Color(64, 43, 100));
        btnLimparTabelaMusicas.setText("Limpar tabela de músicas");
        btnLimparTabelaMusicas.setToolTipText("");
        btnLimparTabelaMusicas.setOpaque(false);
        btnLimparTabelaMusicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparTabelaMusicasActionPerformed(evt);
            }
        });
        bg.add(btnLimparTabelaMusicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, 40));

        btnSalvar.setBackground(new java.awt.Color(85, 65, 118));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karaoke/imagens/icons8_Checked_32px.png"))); // NOI18N
        btnSalvar.setToolTipText("Salvar");
        btnSalvar.setOpaque(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        bg.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

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
        bg.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, -1, -1));

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

    private void btnLimparTabelaMusicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparTabelaMusicasActionPerformed
        final MusicaControl musicaControl = new MusicaControl(true);
        if (musicaControl.truncate()) {
            JOptionPane.showMessageDialog(this, "Fecharemos o sistema para sincronizar as músicas novamente", "Tarefa concluída", 1);
            System.exit(0);
        }
    }//GEN-LAST:event_btnLimparTabelaMusicasActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        this.txtPastaMusicas.requestFocus();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            this.sistemaControl.editar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Falha ao Salvar", 2);
        } finally {
            this.fechar();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fechar();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnLimparTabelaMusicas;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPastaMusicas;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
