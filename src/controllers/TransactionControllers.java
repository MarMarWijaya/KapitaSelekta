/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AccountDao;
import daos.AccountDaoImpl;
import daos.TransactionDao;
import daos.TransactionDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;
import models.Account;
import daos.Query;
import daos.UserDao;
import daos.UserDaoImpl;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import models.Transaction;
import utils.ConnectionDB;
import views.DepositView;
import views.Home;
import views.TransactionView;
import views.TransferView;
import views.WithdrawView;

/**
 *
 * @author Ardian
 */
public class TransactionControllers {

    private Transaction transactionModel;
    private Account accountModel;

    private TransactionDao transactionDao = new TransactionDaoImpl();
    private AccountDao accountDao = new AccountDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    private WithdrawView withdrawView;
    private DepositView depositView;
    private TransferView transferView;
    private TransactionView transactionView;
    private Home homeView;

    static ResultSet rs;
    static ConnectionDB connect = new ConnectionDB();

    MenuController menuController;

    /* Constructor */
    public TransactionControllers(Transaction transactionModel, WithdrawView view) {
        this.transactionModel = transactionModel;
        this.withdrawView = view;
    }

    public TransactionControllers(Transaction transactionModel, DepositView view) {
        this.transactionModel = transactionModel;
        this.depositView = view;
    }

    public TransactionControllers(Transaction transactionModel, TransferView view) {
        this.transactionModel = transactionModel;
        this.transferView = view;
    }

    public TransactionControllers(Transaction transactionModel, TransactionView view) {
        this.transactionModel = transactionModel;
        this.transactionView = view;
    }

    public TransactionControllers(Account accountModel, WithdrawView withdrawView) {
        this.accountModel = accountModel;
        this.withdrawView = withdrawView;
    }

    public TransactionControllers(Account accountModel, DepositView depositView) {
        this.accountModel = accountModel;
        this.depositView = depositView;
    }

    public TransactionControllers(Account accountModel, TransferView transferView) {
        this.accountModel = accountModel;
        this.transferView = transferView;
    }

    public TransactionControllers(Account accountModel, TransactionView transactionView) {
        this.accountModel = accountModel;
        this.transactionView = transactionView;
    }

    public void setTempUser(List list) {
        userDao.setActiveUser(list);
    }

    public List getTempUser() {
        return userDao.getActiveUser();
    }

    /* Init View */
    public void createWithdrawView() {
        withdrawView = new WithdrawView(userDao.getActiveUser());
        withdrawView.setVisible(true);
        doWithdrawTransaction();
    }

    public void createDepositView() {
        depositView = new DepositView(userDao.getActiveUser());
        depositView.setVisible(true);
        doDepositTransaction();
    }

    public void createTransferView() {
        transferView = new TransferView(userDao.getActiveUser());
        transferView.setVisible(true);
        doTransferTransaction();
    }

    public void createTransactionView(List list) {
        transactionView = new TransactionView(list);
        transactionView.setVisible(true);
        System.out.println("sukses " + list.get(0));
        doTransactionView(list);
        userDao.setActiveUser(list);
    }

    /* All Database Query Logic */
    public int checkCurrentBalance(ResultSet resultSet) {
        try {
            rs = resultSet;

            while (rs.next()) {
                accountModel.setCurrentBalance(rs.getInt("Saldo"));
            }

            System.out.println(accountModel.getCurrentBalance() + " saldo");
        } catch (Exception e) {
            System.out.println("Tidak bisa konek" + e);
        }
        return accountModel.getCurrentBalance();
    }

    public int checkCurrentBalanceReceiver(ResultSet resultSet) {
        try {
            rs = resultSet;

            while (rs.next()) {
                accountModel.setCurrentBalanceReceiver(rs.getInt("Saldo"));
            }

            System.out.println(accountModel.getCurrentBalanceReceiver() + " saldo");
        } catch (Exception e) {
            System.out.println("Tidak bisa konek" + e);
        }
        return accountModel.getCurrentBalanceReceiver();
    }

    public String getUserId(String name, ResultSet resultSet) {
        try {
            rs = resultSet;
            while (rs.next()) {
                transactionModel.setAccount(rs.getString("ID_user"));
            }

            System.out.println(transactionModel.getAccount() + " userID");
        } catch (Exception e) {
            System.out.println("userID " + e);
        }
        return transactionModel.getAccount();
    }

    public int getCountRow(int countRow) {
        try {
            rs = connect.connectDBResultSet(Query.QUERY_COUNT_ROW.getDisplayName());
            System.out.println(rs);
            rs.next();
            countRow = rs.getInt("COUNT(*)");

            System.out.println(countRow + " jumlah row");

            if (countRow >= 100) {
                transactionDao.deleteDatabaseData();
            }
        } catch (Exception e) {
            System.out.println("Countrow " + e);
        }
        return countRow;
    }

    public String getTransactionId(String subStringTransIDNum) {
        try {
            transactionModel = new Transaction();
            rs = transactionDao.getTransactionID();
            if (rs.next()) {
                transactionModel.setTransactionID(rs.getString("ID_trans"));
            }

            System.out.println(transactionModel.getTransactionID() + " trans ID 1");

            if (transactionModel.getTransactionID() == null) {
                transactionModel.setTransactionID("TR101");

                System.out.println(transactionModel.getTransactionID() + "trans ID");
            } else {

                String subStringTransIDPrefix = transactionModel.getTransactionID().substring(0, 2);

                switch (transactionModel.getTransactionID().length()) {
                    case 4:
                        subStringTransIDNum = transactionModel.getTransactionID().substring(2, 4);
                        break;
                    case 5:
                        subStringTransIDNum = transactionModel.getTransactionID().substring(2, 5);
                        break;
                    default:
                        break;
                }

                int transIDNum = Integer.parseInt(subStringTransIDNum);
                transIDNum++;

                transactionModel.setTransactionID(subStringTransIDPrefix + transIDNum);

                System.out.println(transactionModel.getTransactionID() + "trans ID");
            }
        } catch (Exception e) {
            System.out.println("TransactionID " + e);
        }
        return transactionModel.getTransactionID();
    }

    public void insertDatabaseTransaction(String destination) {
        transactionDao.insertTransactionDatabase(destination, transactionModel);
    }

    public void updateDatabaseBalance(String query, int value1, int value2) {
        accountDao.updateBalance(query, value1, value2, accountModel);
    }

    public void updateDatabaseBalanceReceiver(String query, int value1, int value2, String destination) {
        accountDao.updateBalanceReceiver(query, value1, value2, destination);
    }

    /* Spesific Function for each View */
    public void doWithdrawTransaction() {
        this.checkCurrentBalance(accountDao.getCurrentBalance(accountModel, userDao));
        withdrawView.getCurrentBalanceLabel().setText(accountModel.getCurrentBalance() + "");
        withdrawView.getConfirmationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (withdrawView.getNominalTextField().toString().length() > 0) {

                    if (withdrawView.getNominalTextField().getText().matches("[0-9]*")) {
                        accountModel.setName(userDao.getActiveUser().get(0));
                        System.out.println(accountModel.getName());

                        System.out.println(withdrawView.getCountRow() + " cr");
                        withdrawView.setCountRow(getCountRow(withdrawView.getCountRow()));

                        //untuk mendapatkan user ID
                        transactionModel = new Transaction();
                        transactionModel.setTransactionID(getTransactionId(withdrawView.getSubStringTransIDNum()));
                        transactionModel.setAccount(getUserId(accountModel.getName(), accountDao.getUserId(accountModel)));
                        transactionModel.setType("Penarikan");
                        transactionModel.setNominal(Integer.parseInt(withdrawView.getNominalTextField().getText()));
                        insertDatabaseTransaction("");

                        updateDatabaseBalance(
                                Query.QUERY_UPDATE_DECREMENT.getDisplayName(),
                                accountModel.getCurrentBalance(),
                                Integer.parseInt(withdrawView.getNominalTextField().getText())
                        );

                        withdrawView.dispose();
                        createTransactionView(userDao.getActiveUser());
                    } else {
                        JOptionPane.showMessageDialog(withdrawView, "Nominal harus angka");
                    }
                }
            }
        });
        withdrawView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawView.dispose();
                createTransactionView(userDao.getActiveUser());
            }
        });
    }

    public void doDepositTransaction() {
        depositView.getConfirmationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (depositView.getNominalTextField().getText().toString().length() > 0) {

                    if (depositView.getNominalTextField().getText().matches("[0-9]*")) {
                        checkCurrentBalance(accountDao.getCurrentBalance(accountModel, userDao));

                        accountModel.setName(userDao.getActiveUser().get(0));
                        System.out.println(accountModel.getName());

                        System.out.println(depositView.getCountRow() + " cr");
                        depositView.setCountRow(getCountRow(depositView.getCountRow()));

                        //untuk mendapatkan user ID
                        transactionModel = new Transaction();
                        transactionModel.setTransactionID(getTransactionId(depositView.getSubStringTransIDNum()));
                        transactionModel.setAccount(getUserId(accountModel.getName(), accountDao.getUserId(accountModel)));
                        transactionModel.setType("Deposit");
                        transactionModel.setNominal(Integer.parseInt(depositView.getNominalTextField().getText()));
                        insertDatabaseTransaction("");

                        updateDatabaseBalance(
                                Query.QUERY_UPDATE_INCREMENT.getDisplayName(),
                                accountModel.getCurrentBalance(),
                                Integer.parseInt(depositView.getNominalTextField().getText())
                        );

                        depositView.dispose();
                        createTransactionView(userDao.getActiveUser());
                    } else {
                        JOptionPane.showMessageDialog(depositView, "Nominal harus angka");
                    }

                }
            }
        });

        depositView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositView.dispose();
                createTransactionView(userDao.getActiveUser());
            }
        });

    }

    public void doTransferTransaction() {
        transferView.getConfirmationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (transferView.getNominalTextField().getText().toString().length() > 0 && transferView.getDestinationTextField().getText().toString().length() > 0) {

                    if (transferView.getNominalTextField().getText().matches("[0-9]*")) {
                        if (transferView.getDestinationTextField().getText().matches("[0-9]*")) {
                            accountModel.setName(userDao.getActiveUser().get(0));
                            System.out.println(accountModel.getName());

                            accountModel.setCurrentBalance(checkCurrentBalance(accountDao.getCurrentBalance(accountModel, userDao)));
                            accountModel.setCurrentBalanceReceiver(checkCurrentBalanceReceiver(accountDao.getCurrentBalanceDest(transferView.getDestinationTextField().getText())));

                            System.out.println("balance " + accountModel.getCurrentBalance());
                            System.out.println("balance " + accountModel.getCurrentBalanceReceiver());

                            System.out.println(transferView.getCountRow() + " cr");
                            transferView.setCountRow(getCountRow(transferView.getCountRow()));

                            getTransactionId(transferView.getSubStringTransIDNum());

                            //untuk mendapatkan user ID
                            transactionModel = new Transaction();
                            transactionModel.setTransactionID(getTransactionId(transferView.getSubStringTransIDNum()));
                            transactionModel.setAccount(getUserId(accountModel.getName(), accountDao.getUserId(accountModel)));
                            transactionModel.setType("Transfer");
                            transactionModel.setNominal(Integer.parseInt(transferView.getNominalTextField().getText()));
                            insertDatabaseTransaction(transferView.getDestinationTextField().getText());

                            //untuk mendapatkan user ID
                            transactionModel.setTransactionID(getTransactionId(transferView.getSubStringTransIDNum()) + 1);
                            transactionModel.setAccount(getUserId(accountModel.getName(), accountDao.getUserIdDest(transferView.getDestinationTextField().getText(), accountModel)));
                            transactionModel.setType("Terima");
                            transactionModel.setNominal(Integer.parseInt(transferView.getNominalTextField().getText()));
                            insertDatabaseTransaction("");

                            updateDatabaseBalance(
                                    Query.QUERY_UPDATE_DECREMENT.getDisplayName(),
                                    accountModel.getCurrentBalance(),
                                    Integer.parseInt(transferView.getNominalTextField().getText())
                            );

                            updateDatabaseBalanceReceiver(
                                    Query.QUERY_UPDATE_DEST.getDisplayName(),
                                    accountModel.getCurrentBalanceReceiver(),
                                    Integer.parseInt(transferView.getNominalTextField().getText()),
                                    transferView.getDestinationTextField().getText()
                            );

                            System.out.println(transferView.getDestinationTextField().getText() + " tujuan");

                            transferView.dispose();
                            createTransactionView(userDao.getActiveUser());
                        } else {
                            JOptionPane.showMessageDialog(transferView, "Rekening harus angka");
                        }
                    } else {
                        JOptionPane.showMessageDialog(depositView, "Nominal harus angka");
                    }
                }
            }
        });

        transferView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferView.dispose();
                createTransactionView(userDao.getActiveUser());
            }
        });
    }

    public void doTransactionView(List list) {
        transactionView.getWithdrawMenuButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transactionView.dispose();
                createWithdrawView();
            }
        });

        transactionView.getDepositMenuButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transactionView.dispose();
                createDepositView();
            }
        });

        transactionView.getTransferMenuButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transactionView.dispose();
                createTransferView();
            }
        });

        transactionView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transactionView.dispose();

                System.out.println("list " + list.get(0));
                menuController = new MenuController(accountModel, homeView);
                menuController.createHomeView(list);
            }
        });
    }
}
