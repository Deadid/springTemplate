package com.smakhov.springtemplate.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 * Created by SMakhov on 29.09.2016.
 */
@SpringView(name = "")
public class HelloView extends HorizontalLayout implements View {
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        this.addComponent(new Label("blyad"));
    }
}
