package pl.strefakursow.springadvanced.component.mailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SignUpMailer {

    JavaMailSender javaMailSender;
    SignUpMailTextFactory signUpMailTextFactory;

    @Autowired
    SignUpMailer(JavaMailSender javaMailSender, SignUpMailTextFactory signUpMailTextFactory) {
        this.javaMailSender = javaMailSender;
        this.signUpMailTextFactory = signUpMailTextFactory;
    }


    public void sendMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    public void sendConfirmationLink(String email, String token){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(signUpMailTextFactory.getConfirmationMailSubject());
        message.setText(signUpMailTextFactory.getConfirmationMailText(token));
        javaMailSender.send(message);

    }
}
