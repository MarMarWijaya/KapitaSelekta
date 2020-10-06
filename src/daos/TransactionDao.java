/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.ResultSet;
import models.Transaction;

/**
 *
 * @author Ardian
 */
public interface TransactionDao {
    ResultSet getRowLength();
    void deleteDatabaseData();
    ResultSet getTransactionID();
    void insertTransactionDatabase(String destination, Transaction transaction);
}
