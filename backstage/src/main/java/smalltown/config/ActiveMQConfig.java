package smalltown.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

@Configuration
public class ActiveMQConfig {
	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
		ActiveMQConnectionFactory amq = new ActiveMQConnectionFactory() ;
//		amq.setBrokerURL(""); //默认 tcp://localhost:61616
		return amq;
	}

	@Bean
	public JmsTemplate jmsTemplate(){
		JmsTemplate jt = new JmsTemplate() ;
		jt.setConnectionFactory(connectionFactory());
//		jt.setMessageConverter(messageConverter());
		jt.setDefaultDestinationName("smalltown.user");
		return jt;
	}

//	@Bean
//	public MappingJackson2MessageConverter messageConverter(){
//		return new MappingJackson2MessageConverter() ;
//	}

	@Bean
	public ActiveMQTopic topic(){
		ActiveMQTopic t = new ActiveMQTopic("smalltown.user") ;
		return t ;
	}
}
