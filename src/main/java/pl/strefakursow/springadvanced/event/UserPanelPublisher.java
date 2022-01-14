package pl.strefakursow.springadvanced.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class UserPanelPublisher {

    ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    UserPanelPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(String username) {
        UserPanelEvent userPanelEvent = new UserPanelEvent(this, username);
        applicationEventPublisher.publishEvent(userPanelEvent);
    }
}
