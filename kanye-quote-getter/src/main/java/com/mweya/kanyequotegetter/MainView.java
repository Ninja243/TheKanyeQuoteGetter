package com.mweya.kanyequotegetter;

import javax.swing.GroupLayout.Alignment;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.springframework.web.client.RestTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.dialog.Dialog;

@Route
public class MainView extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    // Elements to add to the view later
    H1 text = new H1("This is the Kanye quote getter");
    Button button = new Button("Get a quote", event -> callRestService());

    public MainView() {
        // Styling
        HorizontalLayout h = new HorizontalLayout();
        h.setVerticalComponentAlignment(Alignment.CENTER, text);
        h.setVerticalComponentAlignment(Alignment.CENTER, button);
        // Actually add things to the page
        add(text, button);
    }

    /**
     * Calls kanye.rest and shows the notification
     */
    private void callRestService() {
        RestTemplate restTemplate = new RestTemplate();
        Quote result = restTemplate.getForObject("https://api.kanye.rest/", Quote.class);
        Dialog dialog = new Dialog();
        VerticalLayout layout = new VerticalLayout();
        Button close = new Button("Close", event -> dialog.close());
        // Notification.show(result.toString());
        layout.add(new Label(result.toString()));
        layout.add(close);
        dialog.add(layout);
        dialog.open();
    }

}