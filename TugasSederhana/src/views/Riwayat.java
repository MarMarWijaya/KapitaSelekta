package views;

import com.sun.xml.internal.txw2.Document;
import controllers.MenuController;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import utils.ConnectionDB;
import controllers.RiwayatTransaksiController;
import daos.UserDao;
import daos.UserDaoImpl;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Account;
import models.Transaction;
import java.io.File;
import java.io.IOException;
import java.util.List;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import java.io.FileOutputStream;
import java.io.OutputStream;

 

public class Riwayat extends javax.swing.JFrame {

    DefaultTableModel model;
    Account accountModel = new Account();
    UserDao userDao = new UserDaoImpl();
    
    List<Transaction> listRiwayat = new ArrayList<>();
    static List userList = new ArrayList();

    public Riwayat(List list) {
        initComponents();
        userList = list;

        String[] isi = {"ID trans", "Jenis", "Nominal", "Tanggal", "Rekening tujuan", "ID user"};
        model = new DefaultTableModel(isi, 0);
        tabelRiwayat.setModel(model);
        userDao.setActiveUser(list);
        tampilkan();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelRiwayat = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Riwayat Transaksi");

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabelRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(tabelRiwayat);

        jButton2.setText("Cetak ke Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        Home homeView = new Home(userDao.getActiveUser());
        MenuController menuController = new MenuController(accountModel, homeView);
        menuController.createHomeView(userDao.getActiveUser());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            
        Connection con;
        con = new ConnectionDB().getConnection();
        
        String name = (String) userList.get(0);
        String idUser = new RiwayatTransaksiController(con).ambilUserID(name);
        listRiwayat = new RiwayatTransaksiController(con).TampilRiwayat(idUser);     
            
         
            File path=new File("D:\\excel.xls");
            WritableWorkbook workbook=Workbook.createWorkbook(path);
           
            WritableSheet sheet=workbook.createSheet("Sheet 1", 0);
            
            WritableCellFormat cellFormat=new WritableCellFormat();
            cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
            
            WritableCellFormat numberCellFormat=new WritableCellFormat(NumberFormats.INTEGER);
            numberCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
            
            WritableCellFormat priceCellFormat=new WritableCellFormat(NumberFormats.FLOAT);
            priceCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
            

            
            Label lblHeader=new Label(2, 1, "Laporan Riwayat");
            sheet.addCell(lblHeader);
            
            Label lblNo=new Label(0, 2, "Id Transaksi",cellFormat);
            sheet.addCell(lblNo);
            
            Label lblJenis=new Label(1, 2, "Jenis",cellFormat);
            sheet.addCell(lblJenis);
            
            Label lblNominal=new Label(2, 2, "Nominal",cellFormat);
            sheet.addCell(lblNominal);
            
            Label lblTanggal=new Label(3, 2, "Tanggal",cellFormat);
            sheet.addCell(lblTanggal);
            
            Label lblTujuan=new Label(4, 2, "Rekening Tujuan",cellFormat);
            sheet.addCell(lblTujuan);
            
            Label lblUser=new Label(5, 2, "ID_User",cellFormat);
            sheet.addCell(lblUser);
            
            
            Label lbl;
            
            int number=1;
            int cellRow=3;
           
           // Object[][] o = new Object[listRiwayat.size()][6];
            for (int i = 0; i < listRiwayat.size(); i++) {

                
                sheet.addCell(new Label(0, cellRow, listRiwayat.get(i).getTransactionID(),cellFormat));
                sheet.addCell(new Label(1, cellRow, listRiwayat.get(i).getType(),cellFormat));
                sheet.addCell(new Number(2, cellRow, listRiwayat.get(i).getNominal(),numberCellFormat));
                sheet.addCell(new DateTime(3, cellRow, listRiwayat.get(i).getDate(),cellFormat));
                sheet.addCell(new Label(4, cellRow, listRiwayat.get(i).getAccNumberDestination(),cellFormat));
                sheet.addCell(new Label(5, cellRow, listRiwayat.get(i).getAccount(),cellFormat));
                number++;
                cellRow++;
            }
            
            workbook.write();
            workbook.close();
        } catch (IOException ex) {
            Logger.getLogger(Riwayat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(Riwayat.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Riwayat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Riwayat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Riwayat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Riwayat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Riwayat(userList).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelRiwayat;
    // End of variables declaration//GEN-END:variables

    private void tampilkan() {
        int row = model.getRowCount();
        for (int i = 0; i < row; i++) {
            model.removeRow(0);
        }
        System.out.println("berhasil");

        Connection con;
        con = new ConnectionDB().getConnection();
        if (con == null) {
            System.out.println("null");
            return;
        }
        String name = (String) userList.get(0);
        String idUser = new RiwayatTransaksiController(con).ambilUserID(name);
        listRiwayat = new RiwayatTransaksiController(con).TampilRiwayat(idUser);

        Object[][] o = new Object[listRiwayat.size()][6];
        for (int i = 0; i < listRiwayat.size(); i++) {
            o[i][0] = listRiwayat.get(i).getTransactionID();
            o[i][1] = listRiwayat.get(i).getType();
            o[i][2] = listRiwayat.get(i).getNominal();
            o[i][3] = listRiwayat.get(i).getDate();
            o[i][4] = listRiwayat.get(i).getAccNumberDestination();
            o[i][5] = listRiwayat.get(i).getAccount();
            model.addRow(o[i]);
        }
    }
}
