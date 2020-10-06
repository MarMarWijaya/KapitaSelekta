/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import models.Transaction;
import utils.ConnectionDB;

/**
 *
 * @author Ardian
 */
public class TransactionDaoImpl implements TransactionDao {
    
    private Transaction transaction = new Transaction();
    private ResultSet resultSet;
    private ConnectionDB connect = new ConnectionDB();

    @Override
    public ResultSet getRowLength() {
        try {
            resultSet = connect.connectDBResultSet(Query.QUERY_COUNT_ROW.getDisplayName());
            System.out.println(resultSet);
            System.out.println("berhasil");
        } catch (Exception e) {
            System.out.println("Row Length " + e);
        }
        return resultSet;
    }

    @Override
    public void deleteDatabaseData() {
        connect.queryUpdate(Query.QUERY_DELETE_DATA.getDisplayName());
        System.out.println("Delete success");
    }

    @Override
    public ResultSet getTransactionID() {
        try {
            resultSet = connect.connectDBResultSet(Query.QUERY_TRANSACTIONID.getDisplayName());
        } catch (SQLException ex) {
            System.out.println("TreansactionID " + ex);
        };
        return resultSet;
    }

    @Override
    public void insertTransactionDatabase(String destination, Transaction transaction) {
        connect.connectDBPreparedStatementInsert(
                Query.QUERY_INSERT_TRANSACTION.getDisplayName(),
                transaction.getTransactionID(),
                transaction.getType(),
                transaction.getNominal(),
                destination,
                transaction.getAccount()
        );
        System.out.println(transaction.getAccount() + " userid");
    }
    
}
