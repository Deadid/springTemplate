package com.smakhov.springtemplate.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class InitialUI extends UI {


    private static final long serialVersionUID = 8128515726064531026L;

    @Autowired
    private SpringViewProvider viewProvider;

    private Navigator navigator;

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(true);
        root.setSpacing(true);
        setContent(root);
        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        root.addComponent(viewContainer);
        root.setExpandRatio(viewContainer, 1.0f);
        navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
        navigator.addView("", viewProvider.getView(""));
    }

}
