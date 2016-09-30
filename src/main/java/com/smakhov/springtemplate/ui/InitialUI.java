package com.smakhov.springtemplate.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.spring.server.SpringVaadinServlet;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@SpringUI
@Theme("valo")
public class InitialUI extends UI {


	private static final long serialVersionUID = 8128515726064531026L;

	@WebServlet(urlPatterns = {"/ui/*", "/VAADIN/*"}, name = "UIServlet", asyncSupported = true)
    public static class Servlet extends SpringVaadinServlet {

		private static final long serialVersionUID = 2468628734226742916L;

		@Override
		protected void servletInitialized() throws ServletException {
			// TODO Auto-generated method stub
			super.servletInitialized();
			
		}
    	
    }

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
    	navigator.addView( "", viewProvider.getView( "" ));
    }

}
