package com.smakhov.springtemplate.ui;

import com.smakhov.springtemplate.model.dao.UserRepository;
import com.smakhov.springtemplate.model.entity.User;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * Created by SMakhov on 29.09.2016.
 */
@SpringView(name = "")
public class HelloView extends HorizontalLayout implements View {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageSource i18n;

    private static final long serialVersionUID = 7872993556914807253L;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

        Table users = new Table();
        users.setContainerDataSource(new BeanItemContainer<User>(User.class, userRepository.findAll()));
        this.addComponent(users);

        TextField username = new TextField(i18n.getMessage("username", null, Locale.forLanguageTag("NL")));
        PasswordField password = new PasswordField("Password");
        Button submit = new Button("OK", clickEvent -> {
            User created = new User();
            created.setUsername(username.getValue());
            created.setPassword(password.getValue());
            created = userRepository.save(created);
            users.getContainerDataSource().addItem(created);
        });
        FormLayout form = new FormLayout(username, password, submit);
        this.addComponent(form);
    }
}
