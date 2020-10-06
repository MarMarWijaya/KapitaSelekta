
import controllers.MenuController;
import controllers.TransactionControllers;
import models.Account;
import views.Login;
import views.WithdrawView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ardian
 */
public class App {
    public static void main(String[] args) {
        Account model = new Account();
        Login view = new Login();
        MenuController controller = new MenuController(model, view);
        controller.createLoginView();
    }
}
