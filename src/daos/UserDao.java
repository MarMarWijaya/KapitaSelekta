/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;

/**
 *
 * @author Ardian
 */
public interface UserDao {
    List<String> getActiveUser();
    void setActiveUser(List<String> list);
    void addActiveUser(String name);
}
