package controllers;

import java.sql.*;
import models.Account;
import daos.Query;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import models.User;
import utils.ConnectionDB;
import utils.EmailProperties;
import views.Daftar;

public class PendaftaranController {

    Daftar daftarView;

    Connection con;

    public PendaftaranController(Connection con) {
        this.con = con;
    }

    public PendaftaranController(Daftar daftarView) {
        this.daftarView = daftarView;
    }

    public boolean InsertUser(Account account, User user) {
        try {
            int id_user = 2;
            int rekening = 100;
            int nomorKartu = 200;

            ConnectionDB connectionDB = new ConnectionDB();

            ResultSet rs = connectionDB.connectDBResultSet(Query.QUERY_ACCOUNT.getDisplayName());

            while (rs.next()) {
                id_user++;
                rekening++;
                nomorKartu++;
            }

            connectionDB.connectDBPreparedStatementInsertAccount(
                    Query.QUERY_INSERT_ACCOUNT.getDisplayName(),
                    Integer.toString(id_user),
                    account.getName(),
                    Integer.toString(rekening),
                    Integer.toString(nomorKartu),
                    account.getPin(),
                    account.getCurrentBalance(),
                    account.getUser()
            );

            connectionDB.connectDBPreparedStatementInsertUser(
                    Query.QUERY_INSERT_USER.getDisplayName(),
                    user.getUserID(),
                    user.getName(),
                    user.getPhoneNum(),
                    user.getEmail(),
                    Integer.toString(id_user)
            );
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;

    }

    public void sendConfirmationEmail() {
        try {
            EmailProperties emailProperties = new EmailProperties();

            Session session = Session.getInstance(emailProperties.initEmailProperties(), new EmailAuth());
            Message message = new MimeMessage(session);

            InternetAddress sender = new InternetAddress("ardianpramudya81@gmail.com");
            message.setFrom(sender);

            InternetAddress destination = new InternetAddress(daftarView.getTfEmail().getText());

            message.setRecipient(Message.RecipientType.TO, destination);

            message.setSubject("Kapita Application Registration Success");
            message.setText("Terima kasih telah mendaftar");
            message.setContent(
                    "<h1>Hi " + daftarView.getTfNamaPengguna().getText() + "!, Thank You for Using Our App </h1>"
                            + "<p>Stay Tune for More Update!</p>", "text/html"
            );

            Transport.send(message);

            System.out.println("Email Berhasil");
        } catch (Exception e) {
            System.out.println("Email Gagal terkirim " + e);
        }
    }

    private static class EmailAuth extends Authenticator {

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("ardianpramudya81@gmail.com", "Cio030600");
        }

    }
}
