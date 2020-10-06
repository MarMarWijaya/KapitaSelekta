/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Properties;

/**
 *
 * @author Ardian
 */
public class EmailProperties {
    public Properties initEmailProperties() {
        Properties properties = null;
        try {
            properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "465");
        } catch (Exception e) {
            System.out.println("Properties Email " + e);
        }
        return properties;
    }
}
