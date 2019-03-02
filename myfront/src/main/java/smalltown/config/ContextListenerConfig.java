package smalltown.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import smalltown.model.UseViewResolver;

@Configuration
@ComponentScan(basePackages={"smalltown.service","smalltown.model"})
public class ContextListenerConfig {
	@Bean
	@Profile("chooseViewResolver")
	public UseViewResolver useViewResolver() {
		UseViewResolver u = new UseViewResolver() ;
		u.setViewName("test");
		return u ;
	}
}
