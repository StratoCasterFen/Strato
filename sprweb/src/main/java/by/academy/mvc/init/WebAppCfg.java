package by.academy.mvc.init;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;
import org.springframework.web.servlet.view.tiles2.SpringWildcardServletTilesApplicationContext;

@Configuration
@EnableWebMvc
@ComponentScan( {"by.academy.mvc"} )
public class WebAppCfg extends WebMvcConfigurerAdapter {

	@Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	 }
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Bean
//	public TilesConfigurer getTilesConfigurer() {
//		TilesConfigurer tilesConfigurer = new TilesConfigurer();
//		tilesConfigurer.setCheckRefresh(true);
//		tilesConfigurer.setDefinitions("/WEB-INF/pages/layout/tiles-templates.xml");
//	//	tilesConfigurer.setDefinitionsFactoryClass(definitionsFactoryClass);(TilesConfigurer.class);
//
//		// Add apache tiles definitions
//		//TilesDefinitionsConfig.addDefinitions();
//
//		return tilesConfigurer;
//	}
	

	@Bean
    public TilesViewResolver getTilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("classpath:messages.properties");
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}
    
//    @Bean
//    public Validator validator() {
//        return new UserValidator();
//    }

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:content");
        return messageSource;
    }

}

