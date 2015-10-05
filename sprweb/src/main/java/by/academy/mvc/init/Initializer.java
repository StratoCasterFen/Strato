package by.academy.mvc.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import by.academy.mvc.controller.HomeController;
import by.academy.service.cfg.ServiceCfg;

public class Initializer implements WebApplicationInitializer {
	static Logger logger= Logger.getLogger(Initializer.class.getName());
	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		logger.info("**********onStartup***********");
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebAppCfg.class);
		ctx.register(ServiceCfg.class);
		ctx.register(SecurityCfg.class);
		servletContext.addListener(new ContextLoaderListener(ctx));
	
		
		ctx.setServletContext(servletContext);

		Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
}
