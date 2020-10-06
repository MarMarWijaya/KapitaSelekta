/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.ResultSet;
import models.Account;
import utils.ConnectionDB;

/**
 *
 * @author Ardian
 */
public class AccountDaoImpl implements AccountDao{
    
    private UserDao userDao = new UserDaoImpl();
    private ResultSet resultSet;
    private ConnectionDB connect = new ConnectionDB();

    @Override
    public ResultSet getCurrentBalance(Account account, UserDao userDao) {
        System.out.println("test " + userDao.getActiveUser());
        resultSet = connect.connectDBPreparedStatementSingleValue(Query.QUERY_CHECK_BALANCE.getDisplayName(), (String) userDao.getActiveUser().get(0));
        System.out.println("connect success");
        return resultSet;
    }

    @Override
    public ResultSet getCurrentBalanceDest(String destination) {
        resultSet = connect.connectDBPreparedStatementSingleValue(Query.QUERY_CHECK_BALANCE_DEST.getDisplayName(), destination);
        System.out.println("connect success");
        return resultSet;
    }

    @Override
    public ResultSet getUserId(Account account) {
        resultSet = connect.connectDBPreparedStatementSingleValue(Query.QUERY_USERID.getDisplayName(), account.getName());
        System.out.println(account.getName());
        System.out.println("connect success");
        System.out.println(account.getAccountID());

        return resultSet;
    }

    @Override
    public ResultSet getUserIdDest(String destination, Account account) {
        resultSet = connect.connectDBPreparedStatementSingleValue(Query.QUERY_USERID_RECEIVER.getDisplayName(), destination);
        System.out.println(account.getName());
        System.out.println("connect success");
        System.out.println(account.getAccountID());

        return resultSet;
    }

    @Override
    public void updateBalance(String query, int value1, int value2, Account account) {
        connect.connectDBPreparedStatementUpdate(
                query,
                value1,
                value2,
                account.getName()
        );
    }

    @Override
    public void updateBalanceReceiver(String query, int value1, int value2, String destination) {
        connect.connectDBPreparedStatementUpdate(
                query,
                value1,
                value2,
                destination
        );
    }
    
}
