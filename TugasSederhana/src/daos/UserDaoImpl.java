/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import models.Account;

/**
 *
 * @author Ardian
 */
public class UserDaoImpl implements UserDao {
    
    private Account account = new Account();
    private List<String> list;

    @Override
    public List<String> getActiveUser() {
        return list;
    }

    @Override
    public void setActiveUser(List<String> list) {
        this.list = list;
    }

    @Override
    public void addActiveUser(String name) {
        list = new ArrayList<>();
        list.add(name);
        System.out.println("Active User Added");
    }
    
}
