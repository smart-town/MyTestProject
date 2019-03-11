package smalltown.rpctest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import smalltown.service.UserService;

@Configuration
public class RmiTestConfig {
	@Bean
	public RmiProxyFactoryBean userService(){
		RmiProxyFactoryBean rmi = new RmiProxyFactoryBean() ;
		rmi.setServiceUrl("rmi://localhost/UserService");
		rmi.setServiceInterface(UserService.class);
		return rmi;
	}
}
