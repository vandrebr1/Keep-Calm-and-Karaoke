package karaoke;

import java.awt.event.*;
import org.netbeans.lib.awtextra.*;
import java.util.logging.*;
import javax.swing.*;
import java.awt.*;

public class frmSobre extends JFrame {

    private JLabel jLabel1;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JPanel jPanel1;

    public frmSobre() {
        this.initComponents();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel16 = new JLabel();
        this.jLabel17 = new JLabel();
        this.jLabel1 = new JLabel();
        this.jLabel15 = new JLabel();
        this.jLabel18 = new JLabel();
        this.jLabel19 = new JLabel();
        this.jLabel20 = new JLabel();
        this.jLabel21 = new JLabel();
        this.jLabel22 = new JLabel();
        this.jLabel23 = new JLabel();
        this.setDefaultCloseOperation(3);
        this.setBackground(new Color(248, 248, 248));
        this.setBounds(new Rectangle(0, 0, 640, 300));
        this.setUndecorated(true);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent evt) {
                frmSobre.this.formMouseClicked(evt);
            }
        });
        this.getContentPane().setLayout((LayoutManager) new AbsoluteLayout());
        this.jPanel1.setBackground(new Color(64, 43, 100));
        this.jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.jPanel1.setLayout((LayoutManager) new AbsoluteLayout());
        this.jLabel16.setFont(new Font("Tahoma", 0, 14));
        this.jLabel16.setForeground(new Color(204, 204, 204));
        this.jLabel16.setHorizontalAlignment(4);
        this.jLabel16.setText("Designer de layouts:");
        this.jLabel16.setToolTipText("");
        this.jLabel16.setAlignmentY(0.0f);
        this.jPanel1.add(this.jLabel16, new AbsoluteConstraints(360, 190, 170, -1));
        this.jLabel17.setFont(new Font("Tahoma", 0, 12));
        this.jLabel17.setForeground(new Color(204, 204, 204));
        this.jLabel17.setHorizontalAlignment(4);
        this.jLabel17.setText("Marco Ponciano");
        this.jLabel17.setToolTipText("");
        this.jLabel17.setAlignmentY(0.0f);
        this.jPanel1.add(this.jLabel17, new AbsoluteConstraints(530, 270, 100, -1));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/karaoke/imagens/icons8_Crown_100px_3.png")));
        this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(270, 0, -1, -1));
        this.jLabel15.setFont(new Font("Segoe UI", 0, 30));
        this.jLabel15.setForeground(new Color(204, 204, 204));
        this.jLabel15.setHorizontalAlignment(0);
        this.jLabel15.setText("Libere a Whitney Houston que existe em voc\u00ea");
        this.jLabel15.setToolTipText("");
        this.jLabel15.setAlignmentY(0.0f);
        this.jPanel1.add(this.jLabel15, new AbsoluteConstraints(10, 90, 620, 40));
        this.jLabel18.setFont(new Font("Tahoma", 0, 14));
        this.jLabel18.setForeground(new Color(204, 204, 204));
        this.jLabel18.setHorizontalAlignment(4);
        this.jLabel18.setIcon(new ImageIcon(this.getClass().getResource("/karaoke/imagens/icons8_Get_Quote_14px.png")));
        this.jLabel18.setToolTipText("");
        this.jLabel18.setAlignmentY(0.0f);
        this.jPanel1.add(this.jLabel18, new AbsoluteConstraints(610, 280, 20, 20));
        this.jLabel19.setFont(new Font("Tahoma", 0, 12));
        this.jLabel19.setForeground(new Color(204, 204, 204));
        this.jLabel19.setHorizontalAlignment(4);
        this.jLabel19.setText("O Simples \u00e9 que funciona.");
        this.jLabel19.setToolTipText("");
        this.jLabel19.setAlignmentY(0.0f);
        this.jPanel1.add(this.jLabel19, new AbsoluteConstraints(470, 250, 160, -1));
        this.jLabel20.setFont(new Font("Tahoma", 0, 14));
        this.jLabel20.setForeground(new Color(204, 204, 204));
        this.jLabel20.setHorizontalAlignment(4);
        this.jLabel20.setIcon(new ImageIcon(this.getClass().getResource("/karaoke/imagens/icons8_Quote_Left_14px.png")));
        this.jLabel20.setToolTipText("");
        this.jLabel20.setAlignmentY(0.0f);
        this.jPanel1.add(this.jLabel20, new AbsoluteConstraints(470, 240, -1, 20));
        this.jLabel21.setFont(new Font("Tahoma", 0, 14));
        this.jLabel21.setForeground(new Color(204, 204, 204));
        this.jLabel21.setHorizontalAlignment(4);
        this.jLabel21.setText("Desenvolvido por:");
        this.jLabel21.setToolTipText("");
        this.jLabel21.setAlignmentY(0.0f);
        this.jPanel1.add(this.jLabel21, new AbsoluteConstraints(360, 170, 170, -1));
        this.jLabel22.setFont(new Font("Tahoma", 0, 14));
        this.jLabel22.setForeground(new Color(204, 204, 204));
        this.jLabel22.setHorizontalAlignment(4);
        this.jLabel22.setText("Vandr\u00e9 Priaro");
        this.jLabel22.setToolTipText("");
        this.jLabel22.setAlignmentY(0.0f);
        this.jPanel1.add(this.jLabel22, new AbsoluteConstraints(530, 170, 100, -1));
        this.jLabel23.setFont(new Font("Tahoma", 0, 14));
        this.jLabel23.setForeground(new Color(204, 204, 204));
        this.jLabel23.setHorizontalAlignment(4);
        this.jLabel23.setText("Gabriela Amaral");
        this.jLabel23.setToolTipText("");
        this.jLabel23.setAlignmentY(0.0f);
        this.jPanel1.add(this.jLabel23, new AbsoluteConstraints(530, 190, 100, -1));
        this.getContentPane().add(this.jPanel1, new AbsoluteConstraints(0, 0, 640, 300));
        this.setSize(new Dimension(640, 300));
        this.setLocationRelativeTo(null);
    }

    private void formMouseClicked(final MouseEvent evt) {
        this.dispose();
    }

    public static void main(final String[] args) {
        try {
            for (final UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmSobre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex2) {
            Logger.getLogger(frmSobre.class.getName()).log(Level.SEVERE, null, ex2);
        } catch (IllegalAccessException ex3) {
            Logger.getLogger(frmSobre.class.getName()).log(Level.SEVERE, null, ex3);
        } catch (UnsupportedLookAndFeelException ex4) {
            Logger.getLogger(frmSobre.class.getName()).log(Level.SEVERE, null, ex4);
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmSobre().setVisible(true);
            }
        });
    }
}
