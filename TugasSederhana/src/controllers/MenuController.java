/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.Query;
import daos.UserDao;
import daos.UserDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;
import models.Account;
import utils.ConnectionDB;
import views.Daftar;
import views.Home;
import views.LihatSaldo;
import views.Login;
import views.Riwayat;
import views.TransactionView;

/**
 *
 * @author Ardian
 */
public class MenuController {

    private Account model;
    
    private UserDao userDao = new UserDaoImpl();
    
    private Login loginView;
    private Home homeView;
    private Daftar daftarView;
    private TransactionView transactionView;
    private Riwayat riwayatView;

    private TransactionControllers transactionControllers;

    static ResultSet rs;
    static ConnectionDB connect = new ConnectionDB();

    /* Constructor */
    public MenuController(Account model, Login loginView) {
        this.model = model;
        this.loginView = loginView;
    }

    public MenuController(Account model, Home homeView) {
        this.model = model;
        this.homeView = homeView;
    }

    /* All Database Query Logic */
    public void loginAuth() {
        try {

            rs = connect.connectDBResultSet(Query.QUERY_ACCOUNT.getDisplayName());

            while (rs.next()) {
                if (rs.getString("Nama").equals(loginView.getUsernameTextField().getText())) {
                    if (rs.getString("PIN").equals(loginView.getPasswordField().getText())) {

                        if (userDao.getActiveUser() == null) {
                            userDao.addActiveUser(loginView.getUsernameTextField().getText());
                        }

                        createHomeView(userDao.getActiveUser());
                        loginView.dispose();

                        for (String name : userDao.getActiveUser()) {
                            System.out.println(name);
                        }
                    } else {
                        loginView.getSalah2().setVisible(true);
                    }
                } else {
                    loginView.getSalah().setVisible(true);
                    System.out.println("Error");

                }
            }
        } catch (Exception e) {
            System.out.println("Tidak bisa connect " + e);
        }
    }

    /* Spesific Function for each View */
    public void createHomeView(List list) {
        homeView = new Home(list);
        System.out.println("List " + list.get(0));
        homeView.setVisible(true);
        homeView.getNameText().setText((String) list.get(0));

        homeView.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeView.dispose();
            }
        });
        
        homeView.getjButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                homeView.dispose();
                LihatSaldo lhtsaldo = new LihatSaldo(userDao.getActiveUser());
                LihatSaldoPenggunaController lhtsaldopengguna = new LihatSaldoPenggunaController(model, lhtsaldo);
                lhtsaldopengguna.tampilan(list);
            }
        });

        homeView.getTransactionButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeView.dispose();
                System.out.println("list list " + list.get(0));
                transactionControllers = new TransactionControllers(model, transactionView);
                transactionControllers.createTransactionView(list);
            }
        });
        
        homeView.getjButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeView.dispose();
                riwayatView = new Riwayat(list);
                riwayatView.setVisible(true);
            }
        });

    }

    public void createLoginView() {
        loginView.setVisible(true);
        loginView.getSalah().setVisible(false);
        loginView.getSalah2().setVisible(false);

        loginView.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAuth();
            }
        });

        loginView.getDaftarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginView.dispose();
                daftarView = new Daftar();
                daftarView.setVisible(true);
            }
        });
    }

}
