package com.boys.esa.jms;

import com.boys.esa.models.LogRow;
import com.boys.esa.repo.EmailNotificationRepository;
import com.boys.esa.repo.LogRowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EventReceiver {

//    private final LogRowRepository logRowRepository;
//
//    public EventReceiver(LogRowRepository logRowRepository) {
//        this.logRowRepository = logRowRepository;
//    }

    @Autowired
    private LogRowRepository logRowRepository;

    @JmsListener(destination = "event", containerFactory = "myFactory")
    public void receive(LogRow event) {
        logRowRepository.save(event);
        System.out.println("JMS LogRow event: " + event);
    }
}
