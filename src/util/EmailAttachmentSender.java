package util;

/**
 * Created by Chloe on 11/5/2017.
 */

import model.HotelName;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EmailAttachmentSender {

    public static void main(Set<HotelName> hotelNames){

        String to = "chloebocker@gmail.com";   //recipient's email ID
        String from = "chloebocker@gmail.com"; //sender's email ID
        final String username = "chloebocker@gmail.com";
        final String password = "Blink182!";//change accordingly

        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Multipart multipart = new MimeMultipart();

            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,   //can also use addRecipient()
                    InternetAddress.parse(to));

            // Set Subject: header field
            //assumption here that all hotels belong to the same resort
            message.setSubject(hotelNames.iterator().next().getResortName().getDisplayName() + " Availability");

            StringBuffer text = new StringBuffer();

            //add attachment
            for (HotelName hotelName : hotelNames) {
                // Now set the actual message
                text.append("See attached file for up to date availability of " + hotelName.getDisplayName() + "\n");
                addAttachmentToEmail(hotelName, multipart);
            }

            //add all body of email lines
            message.setText(text.toString());
            //add the mulitpart containing all the attachments to the email
            message.setContent(multipart);
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addAttachmentToEmail(HotelName hotelName, Multipart multipart) throws MessagingException {
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(ExcelWriter.EXCEL_FILE_PATH + hotelName.getResortName().getDisplayName() + "/" + hotelName.getDisplayName() + ".xls");
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(hotelName.getDisplayName() + ".xls");
        multipart.addBodyPart(messageBodyPart);
    }
}
