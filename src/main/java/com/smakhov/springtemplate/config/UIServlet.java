package com.smakhov.springtemplate.config;

import javax.servlet.annotation.WebServlet;

import com.vaadin.spring.server.SpringVaadinServlet;


@WebServlet( urlPatterns = { "/ui/*", "/VAADIN/*" }, name = "UIServlet", asyncSupported = true )
public class UIServlet extends SpringVaadinServlet{

}
