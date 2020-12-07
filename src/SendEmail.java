import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail 
{
   public static void main(String [] args) 
   {    
      // Recipient's email ID needs to be mentioned.
      String to = "Anthony_Padalino@dme.net";

      // Sender's email ID needs to be mentioned
      String from = "dmeshippingupdate@gmail.com";

      // Assuming you are sending email from localhost
      String host = "localhost";

      // Get system properties
      Properties properties = System.getProperties();
      Properties props = new Properties();
     props.put("mail.smtp.host", "smtp.gmail.com");
     props.put("mail.stmp.user", "username of the sender");          
     //If you want you use TLS 
     props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.starttls.enable", "true");
     props.put("mail.smtp.password", "password of the sender");
     // If you want to use SSL
     props.put("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.socketFactory.class",
                               "javax.net.ssl.SSLSocketFactory");
     props.put("mail.smtp.auth", "true");
     props.put("mail.smtp.port", "465");
     Session session = Session.getDefaultInstance(props, new Authenticator() {
          @Override
               protected PasswordAuthentication getPasswordAuthentication() {
                  String username = "dmeshippingupdate@gmail.com";
                  String password = "newone62AZ";
               return new PasswordAuthentication(username , password); 
               }
        });

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("This is a test message!");

         // Now set the actual message
         message.setText("Hello, this is Leonard, testing out an stmp mailing app that I just created in java. I'm trying to see if I can get it on my work email.");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}