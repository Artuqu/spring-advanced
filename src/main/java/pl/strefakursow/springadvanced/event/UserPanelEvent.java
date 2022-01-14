package pl.strefakursow.springadvanced.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserPanelEvent extends ApplicationEvent {

    private String username;

    public UserPanelEvent(Object source, String username) {
        super(source);
        this.username = username;
    }


}
