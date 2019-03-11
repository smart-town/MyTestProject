package smalltown.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import smalltown.service.UserService;

/**
 * configure rpc bean
 * @author luhha
 *
 */
@Configuration
public class RmiBeanConfig {
	@Bean
	public RmiServiceExporter rmiExporter(UserService userService) {
		System.out.println("生成 userServiceBean");
		RmiServiceExporter rmi = new RmiServiceExporter() ;
		rmi.setService(userService) ;
		rmi.setServiceName("UserService") ;
		rmi.setServiceInterface(UserService.class);
//		rmi.setRegistryHost("localhost");
//		rmi.setRegistryPort(9999); //默认 1099
		return rmi ;
	}
}
