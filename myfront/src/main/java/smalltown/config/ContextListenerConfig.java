package smalltown.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.jmx.export.MBeanExporter;

import smalltown.controller.MbeanTest;
import smalltown.model.UseViewResolver;

@Configuration
@ComponentScan(basePackages={"smalltown.service","smalltown.model"})
@Import({WebSocketConfig.class,WebSecurityConfig.class})
public class ContextListenerConfig {
	@Bean
	@Profile("chooseViewResolver")
	public UseViewResolver useViewResolver() {
		UseViewResolver u = new UseViewResolver() ;
		u.setViewName("test");
		return u ;
	}

	@Bean
	public MbeanTest mbeanTest(){
		return new MbeanTest() ;
	}
	@Bean
	public MBeanExporter mbeanExporter(MbeanTest mbeanTest) {
		System.out.println("Mbean:"+mbeanTest.getName());
		MBeanExporter exporter = new MBeanExporter() ;
		Map<String,Object> beans = new HashMap<>() ;
		beans.put("myfront:name=testMBEAN", mbeanTest) ;

		exporter.setBeans(beans);
		return exporter ;
	}

}
