package com.mweya.vaadinrestdemo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.web.client.RestTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    // Elements to add to the view later
    Label text = new Label("This is the Kanye quote getter");
    Button button = new Button("Get a quote", event -> callRestService());

    public MainView() {
        add(text);
        add(button);
    }

    /**
     * Calls kanye.rest and shows the notification
     */
    private void callRestService() {
        RestTemplate restTemplate = new RestTemplate();
        Quote result = restTemplate.getForObject("https://api.kanye.rest/", Quote.class);
        Notification.show(result.toString());
    }

}