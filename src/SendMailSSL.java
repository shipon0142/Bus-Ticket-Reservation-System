import java.io.IOException;
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

 
public class SendMailSSL {
    public static void sendEmailWithAttachments(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message)
            throws AddressException, MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);
 
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        msg.setContent(multipart);
        Transport.send(msg);
 
    }
 
  
public static String emai=Ticket.passmail().toString();
 public static String mes=Ticket.passmessege().toString();
 // public static String emai="";
 //  public static String mes="";
    public static void main(String[] args) {

        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "busticketingbd@gmail.com";
        String password = "*****";
 
        String mailTo = emai;
        String subject = "Bus_Ticket_Bd";
        String message = mes;
 
 
        try {
            sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
            subject, message);
            System.out.println("Email sent.");
        } catch (Exception ex) {
           System.out.println("Could not send email.");
            ex.printStackTrace();
        }
    }
}