package com.berroteran.bmo.akademia.view.utils;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailUtils {

    private static final Logger LOGGER = Logger.getLogger(EmailUtils.class.getName());


    public static void sendEmail(Session session,String from,String destino,String cc,
                                 String bcc, String asunto, String mensaje){
        try
        {

            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress(from, "NoReply-JD"));

            msg.setRecipients(Message.RecipientType.CC,cc);
            msg.setRecipients(Message.RecipientType.BCC,bcc);

            msg.setSubject(asunto, "UTF-8");

            msg.setText(mensaje, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean confirmSMTP(final String host,final Integer port,
                                      final String username, final String password,
                                      final Boolean auth, final String enctype) {
        boolean result = false;
        try {
            Properties props = new Properties();
            if (auth.equals(true)) {
                props.setProperty("mail.smtp.auth", "true");
            } else {
                props.setProperty("mail.smtp.auth", "false");
            }
            if (enctype.endsWith("TLS")) {
                props.setProperty("mail.smtp.starttls.enable", "true");
            } else if (enctype.endsWith("SSL")) {
                props.setProperty("mail.smtp.startssl.enable", "true");
            }
            Session session = Session.getInstance(props, null);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, port, username, password);
            transport.close();
            result = true;

        } catch(AuthenticationFailedException e) {
            LOGGER.log(Level.SEVERE, "SMTP: Authentication Failed");

        } catch(MessagingException e) {
            LOGGER.log(Level.SEVERE, "SMTP: Messaging Exception Occurred");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "SMTP: Unknown Exception");
        }

        return result;
    }
}
