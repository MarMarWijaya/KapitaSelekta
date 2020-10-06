/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import models.Account;
import daos.Query;
import daos.UserDao;
import daos.UserDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import utils.ConnectionDB;
import views.Home;
import views.LihatSaldo;

/**
 *
 * @author DCW
 */
public class LihatSaldoPenggunaController {

    Account acc;
    UserDao userDao = new UserDaoImpl();
    LihatSaldo lhtsaldo;
    Home home;

    public LihatSaldoPenggunaController(Account acc, LihatSaldo lhtsaldo) {
        this.acc = acc;
        this.lhtsaldo = lhtsaldo;
    }

    public void tampilan(List list) {
        try {
            lhtsaldo.setVisible(true);
            userDao.setActiveUser(list);

            //open connection
            ConnectionDB db = new ConnectionDB();
            ResultSet rs = db.connectDBPreparedStatementSingleValue(Query.QUERY_LIHAT_SALDO.getDisplayName(), userDao.getActiveUser().get(0));

            while (rs.next()) {

                String Nama = rs.getString("nama");
                String Rekening = rs.getString("Rekening");
                String Saldo = String.valueOf(rs.getInt("Saldo"));

                String tbData[] = {Nama, Rekening, Saldo};
                DefaultTableModel tb1Model = (DefaultTableModel) lhtsaldo.getjTable1().getModel();
                if (lhtsaldo.getViewholder() == 0) {
                    tb1Model.addRow(tbData);
                }
                lhtsaldo.setViewholder(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        lhtsaldo.getjButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lhtsaldo.dispose();

                MenuController mc = new MenuController(acc, home);
                mc.createHomeView(userDao.getActiveUser());
            }
        });
    }

}
