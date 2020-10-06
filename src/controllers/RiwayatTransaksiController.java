

package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import daos.Query;
import models.Transaction;
import utils.ConnectionDB;
import views.Riwayat;


public class RiwayatTransaksiController {
    Connection con;
    String userID;
    public RiwayatTransaksiController(Connection con)
    {
        this.con = con;
    }
    
    public String ambilUserID(String name){
        
        try {
            ConnectionDB connectionDB = new ConnectionDB();
            
            ResultSet rs =  connectionDB.connectDBPreparedStatementSingleValue(Query.QUERY_USERID.getDisplayName(), name);
        
             while (rs.next()) {
                    this.userID = rs.getString("ID_user");
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(RiwayatTransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userID;
    }
    
    
public List<Transaction> TampilRiwayat(String idPengguna){
    List<Transaction> listRiwayats = new ArrayList<>();
    try{
        ConnectionDB connectionDB = new ConnectionDB();
        
        ResultSet rs = connectionDB.connectDBPreparedStatementSingleValue(Query.QUERY_HISTORY.getDisplayName(), idPengguna);
            
            while(rs.next()){
                Transaction rwy = new Transaction();
                rwy.setTransactionID(rs.getString(1));
                rwy.setType(rs.getString(2));
                rwy.setNominal(rs.getInt(3));
                rwy.setDate(rs.getDate(4));
                rwy.setAccNumberDestination(rs.getString(5));
                rwy.setAccount(rs.getString(6));
                listRiwayats.add(rwy);           
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Riwayat.class.getName()).log(Level.SEVERE, null, ex);
        }
    return listRiwayats;
    }


}
