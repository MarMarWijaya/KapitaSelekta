/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.ResultSet;
import models.Account;

/**
 *
 * @author Ardian
 */
public interface AccountDao {

    /**
     * Melakukan pengambilan saldo terbaru dari Active User
     *
     * @param account -> AccountModel
     * @param userDao -> DAO
     * @return -> ResultSet
     */
    ResultSet getCurrentBalance(Account account, UserDao userDao);

    ResultSet getCurrentBalanceDest(String destination);

    ResultSet getUserId(Account account);

    ResultSet getUserIdDest(String destination, Account account);

    void updateBalance(String query, int value1, int value2, Account account);

    void updateBalanceReceiver(String query, int value1, int value2, String destination);
}
