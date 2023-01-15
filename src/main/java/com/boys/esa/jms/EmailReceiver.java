package com.boys.esa.jms;

import com.boys.esa.models.EmailNotification;
import com.boys.esa.models.LogRow;
import com.boys.esa.repo.EmailNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EmailReceiver {

//    private final EmailNotificationRepository emailNotificationRepository;
//
//    public EmailReceiver(EmailNotificationRepository emailNotificationRepository) {
//        this.emailNotificationRepository = emailNotificationRepository;
//    }

    @Autowired
    private EmailNotificationRepository emailNotificationRepository;

    @JmsListener(destination = "event", containerFactory = "myFactory")
    public void receive(LogRow event) {
        String message = String.format(event.getEventType() + "action has performed on object with type " + event.getEntity());
        EmailNotification emailNotification = new EmailNotification();
        emailNotification.setAddress("localhost");
        emailNotification.setContent(message);
        emailNotificationRepository.save(emailNotification);

        System.out.println("JMS message is received: " + message);
    }
}
