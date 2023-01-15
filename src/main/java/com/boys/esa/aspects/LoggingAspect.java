package com.boys.esa.aspects;

import com.boys.esa.models.LogRow;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Topic;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private JmsTemplate jmsTemplate;

    private Topic topic;

    @Autowired
    public LoggingAspect(JmsTemplate jmsTemplate) throws JMSException {
        this.jmsTemplate = jmsTemplate;
        this.topic = jmsTemplate.getConnectionFactory()
                .createConnection()
                .createSession()
                .createTopic("event");
    }

    @AfterReturning(value = "within(com.boys.esa.services.*) && @annotation(Logging)", returning = "returnValue")
    public void performLogging(JoinPoint joinPoint, Object returnValue) throws JMSException {
        String methodName = joinPoint.getSignature().getName();
        String[] packageName = joinPoint.getTarget().getClass().getName().split("\\.", 0);
        String entity = packageName[packageName.length - 1].split("RepositoryService")[0];
        String arguments = Arrays.toString(joinPoint.getArgs());
        String eventType = "";
        if (methodName.equals("save")) {
            eventType += "save";
        } else if (methodName.equals("delete")) {
            eventType += "delete";
        }

        LogRow log = new LogRow();
        log.setEntity(entity);
        log.setEventType(eventType);
        log.setMessage(arguments);

        jmsTemplate.convertAndSend(topic, log);
    }
}
