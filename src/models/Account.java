/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnectionDB;

/**
 *
 * @author Ardian
 */
public class Account {

    private String accountID;
    private String name;
    private String accNumber;
    private String cardNumber;
    private String pin;
    private int currentBalance;
    private int currentBalanceReceiver;
    private String user;

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accauntID) {
        this.accountID = accauntID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getCurrentBalanceReceiver() {
        return currentBalanceReceiver;
    }

    public void setCurrentBalanceReceiver(int currentBalanceReceiver) {
        this.currentBalanceReceiver = currentBalanceReceiver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
