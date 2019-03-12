package smalltown.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages={"smalltown.service","smalltown.serviceImpl",})
@Import(value={RmiBeanConfig.class,DbConfig.class,/*ActiveMQConfig.class*/})
@ImportResource({"classpath:config/rabbitmq.xml",})
public class BackStageConfig {

}
