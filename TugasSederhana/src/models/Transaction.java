/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author Ardian
 */
public class Transaction {
    private String transactionID;
    private String transactionIDReceive;
    private String type;
    private int nominal;
    private Date date;
    private String accNumberDestination;
    private String account;

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getTransactionIDReceive() {
        return transactionIDReceive;
    }

    public void setTransactionIDReceive(String transactionIDReceive) {
        this.transactionIDReceive = transactionIDReceive;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAccNumberDestination() {
        return accNumberDestination;
    }

    public void setAccNumberDestination(String accNumberDestination) {
        this.accNumberDestination = accNumberDestination;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
   
}
