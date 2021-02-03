package org.acme.servlet.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import org.acme.servlet.MainLayout;

/**
 * Port of the "Skeleton Starter" Vaadin app on top of Quarkus+Undertow.
 * @author Martin Vysny <mavi@vaadin.com>
 */
@PageTitle("Skeleton Starter Demo | Vaadin Quarkus Demo")
@Route(value = "", layout = MainLayout.class)
public class MainRoute extends VerticalLayout {
    public MainRoute() {
        add(new Span("Port of the \"Skeleton Starter\" Vaadin app on top of Quarkus+Undertow."));

        // Use TextField for standard text input
        TextField textField = new TextField("Your name");
        textField.addThemeName("bordered");

        // Button click listeners can be defined as lambda expressions
        GreetService greetService = new GreetService();
        Button button = new Button("Say hello",
                e -> Notification.show(greetService.greet(textField.getValue())));

        // Theme variants give you predefined extra styles for components.
        // Example: Primary button is more prominent look.
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // You can specify keyboard shortcuts for buttons.
        // Example: Pressing enter in this view clicks the Button.
        button.addClickShortcut(Key.ENTER);

        add(textField, button);
    }
}
