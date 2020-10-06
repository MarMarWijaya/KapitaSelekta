package views;

import controllers.MenuController;
import controllers.PendaftaranController;
import java.awt.Dimension;
import java.awt.Toolkit;
import utils.ConnectionDB;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.Account;
import models.User;

public class Daftar extends javax.swing.JFrame {

    static Connection conn;
    MenuController menuController;

    public Daftar() {
        initComponents();
        confirmationLabel.setVisible(false);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfNamaPengguna = new javax.swing.JTextField();
        tfNik = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        tfTelepon = new javax.swing.JTextField();
        tfPin = new javax.swing.JTextField();
        tfSaldo = new javax.swing.JTextField();
        batal = new javax.swing.JButton();
        Daftar = new javax.swing.JButton();
        confirmationLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pendaftaran Akun");

        jLabel1.setText("DAFTAR");

        jLabel2.setText("Nama");

        jLabel3.setText("NIK");

        jLabel4.setText("Email");

        jLabel5.setText("No.Telp");

        jLabel6.setText("Pin");

        jLabel7.setText("Saldo Awal");

        tfNamaPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaPenggunaActionPerformed(evt);
            }
        });

        tfNik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNikActionPerformed(evt);
            }
        });

        batal.setText("BATAL");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        Daftar.setText("DAFTAR");
        Daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DaftarActionPerformed(evt);
            }
        });

        confirmationLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        confirmationLabel.setText("Pendaftaran Berhasil");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfNamaPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfNik, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfPin, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(batal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Daftar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmationLabel)
                            .addComponent(tfSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfNamaPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tfNik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addComponent(tfTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(tfPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(confirmationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batal)
                    .addComponent(Daftar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        this.dispose();

        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_batalActionPerformed

    private void DaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DaftarActionPerformed
        if (tfNamaPengguna.getText().isEmpty() || tfNik.getText().isEmpty() || tfEmail.getText().isEmpty()
                || tfTelepon.getText().isEmpty() || tfPin.getText().isEmpty() || tfSaldo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi Semua field");
        } else {
            Connection con;
            con = new ConnectionDB().getConnection();
            if (con == null) {
                System.out.println("null");
                return;
            }

            String email = tfEmail.getText();
            if (tfNik.getText().matches("[0-9]*")) {
                if (tfSaldo.getText().matches("[0-9]*")) {
                    if (tfTelepon.getText().matches("[0-9]*")) {
                        if (isValidEmail(email) == true) {
                            if (tfPin.getText().matches("[0-9]*")) {
                                Account account = new Account();
                                account.setName(tfNamaPengguna.getText().toString());
                                account.setPin(tfPin.getText());
                                account.setCurrentBalance(Integer.parseInt(tfSaldo.getText()));
                                account.setUser(tfNik.getText());

                                User user = new User();
                                user.setUserID(tfNik.getText());
                                user.setName(tfNamaPengguna.getText());
                                user.setPhoneNum(tfTelepon.getText());
                                user.setEmail(tfEmail.getText());
                                if (new PendaftaranController(con).InsertUser(account, user)) {
                                    new PendaftaranController(this).sendConfirmationEmail();

                                    JOptionPane.showMessageDialog(this, "Data Pelanggna berhasil disimpan");
                                    this.dispose();
                                    Login login = new Login();
                                    menuController = new MenuController(account, login);
                                    menuController.createLoginView();
                                } else {
                                    JOptionPane.showMessageDialog(this, "Data Pelanggana gagal disimpan !");
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(this, "PIN harus angka");
                            }

                        } else {
                            JOptionPane.showMessageDialog(this, "Format email salah");
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Telfon harus angka");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Saldo harus angka");
                }
            } else {
                JOptionPane.showMessageDialog(this, "NIK harus angka");
            }
        }
    }//GEN-LAST:event_DaftarActionPerformed

    public static boolean isValidEmail(String email) {
        boolean validate;
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String emailPattern2 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.+[a-z]+";

        if (email.matches(emailPattern)) {
            validate = true;
        } else if (email.matches(emailPattern2)) {
            validate = true;
        } else {
            validate = false;
        }
        return validate;
    }

    private void tfNamaPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaPenggunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaPenggunaActionPerformed

    private void tfNikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNikActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Daftar().setVisible(true);
            }
        });
    }

    public JButton getDaftar() {
        return Daftar;
    }

    public void setDaftar(JButton Daftar) {
        this.Daftar = Daftar;
    }

    public JButton getBatal() {
        return batal;
    }

    public void setBatal(JButton batal) {
        this.batal = batal;
    }

    public JTextField getTfEmail() {
        return tfEmail;
    }

    public void setTfEmail(JTextField tfEmail) {
        this.tfEmail = tfEmail;
    }

    public JTextField getTfNamaPengguna() {
        return tfNamaPengguna;
    }

    public void setTfNamaPengguna(JTextField tfNamaPengguna) {
        this.tfNamaPengguna = tfNamaPengguna;
    }

    public JTextField getTfNik() {
        return tfNik;
    }

    public void setTfNik(JTextField tfNik) {
        this.tfNik = tfNik;
    }

    public JTextField getTfPin() {
        return tfPin;
    }

    public void setTfPin(JTextField tfPin) {
        this.tfPin = tfPin;
    }

    public JTextField getTfSaldo() {
        return tfSaldo;
    }

    public void setTfSaldo(JTextField tfSaldo) {
        this.tfSaldo = tfSaldo;
    }

    public JTextField getTfTelepon() {
        return tfTelepon;
    }

    public void setTfTelepon(JTextField tfTelepon) {
        this.tfTelepon = tfTelepon;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Daftar;
    private javax.swing.JButton batal;
    private javax.swing.JLabel confirmationLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNamaPengguna;
    private javax.swing.JTextField tfNik;
    private javax.swing.JTextField tfPin;
    private javax.swing.JTextField tfSaldo;
    private javax.swing.JTextField tfTelepon;
    // End of variables declaration//GEN-END:variables
}
