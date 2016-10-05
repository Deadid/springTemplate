package com.smakhov.springtemplate.config;

import com.vaadin.spring.server.SpringVaadinServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * Created by SMakhov on 28.09.2016.
 */
public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		ctx.setServletContext(servletContext);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
		ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dispatcher", dispatcherServlet);
		servletRegistration.setLoadOnStartup(1);
		servletRegistration.addMapping("/api/*");
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		FilterRegistration.Dynamic characterEncoding = servletContext.addFilter("characterEncoding",
				characterEncodingFilter);
		EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST);
		characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
		servletContext.addListener(new ContextLoaderListener(ctx));
		ServletRegistration.Dynamic vaadinDispatcher = servletContext.addServlet(
				"vaadin", SpringVaadinServlet.class);
		vaadinDispatcher.setLoadOnStartup(1);
		vaadinDispatcher.addMapping("/ui/*");
		vaadinDispatcher.addMapping("/VAADIN/*");
		
	}
}
