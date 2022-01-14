package pl.strefakursow.springadvanced.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerServiceThree implements ApplicationListener<UserPanelEvent> {


    @Override
    public void onApplicationEvent(UserPanelEvent userPanelEvent) {
        System.out.println("ListenerServiceThree received event, username " + userPanelEvent.getUsername());
    }
}
