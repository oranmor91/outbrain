package outbrain;

import com.sun.mail.smtp.SMTPTransport;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendEmailSMTP {

    // for example, smtp.mailgun.org
//    private static final String SMTP_SERVER = "127.0.0.1";
//    private static final String SMTP_SERVER = "http://localhost:8080/";
//    private static final String SMTP_SERVER = "stmp.gmail.com";
//    private static final String SMTP_SERVER = "smtp.googlemail.com";
    private static final String SMTP_SERVER = "www.gmail.com";
    private static final String USERNAME = "oranmor91@gmail.com";
    private static final String PASSWORD = "12738545";

    private static final String EMAIL_FROM = "oranmor91@gmail.com";
    //    private static final String EMAIL_TO = "oranmor91@gmail.com, email_2@gmail.com";
    private static final String EMAIL_TO = "oranmor91@gmail.com";
    private static final String EMAIL_TO_CC = "oranmor91@gmail.com";

    private static final String EMAIL_SUBJECT = "Test Send Email via SMTP";
    private static final String EMAIL_TEXT = "Hello Java Mail \n ABC123";

    public static void main(String[] args) {

        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587"); // default port 25
        prop.put("mail.smtp.starttls", "true"); // default port 25

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
        Message msg = new MimeMessage(session);

        try {

            // from
            msg.setFrom(new InternetAddress(EMAIL_FROM));

            // to
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(EMAIL_TO, false));

            // cc
            msg.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(EMAIL_TO_CC, false));

            // subject
            msg.setSubject(EMAIL_SUBJECT);

            // content
            msg.setText(EMAIL_TEXT);

            msg.setSentDate(new Date());

            // Get SMTPTransport
            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");



            // connect
            t.connect(SMTP_SERVER, USERNAME, PASSWORD);

//             send
            t.sendMessage(msg, msg.getAllRecipients());
            Transport.send(msg);

//            System.out.println("Response: " + t.getLastServerResponse());

//            t.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}

