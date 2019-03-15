package smalltown.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import smalltown.wscontroller.WebSocketTest01;

@Configuration
@EnableWebSocketMessageBroker
@EnableWebSocket
@ComponentScan(value = { "smalltown.wscontroller", })
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer, WebSocketConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/stomp").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/queue", "/topic");
		registry.setApplicationDestinationPrefixes("/app");
	}

	// WebSocketConfigurer method. lower api
	@Autowired
	WebSocketTest01 test01;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		System.out.println("\n*****增加 websocket 映射");
		registry.addHandler(test01, "/test01").addInterceptors(websocketInterceptor()).setAllowedOrigins("*");
	}

	@Bean
	public WebSocketInterceptor websocketInterceptor() {
		return new WebSocketInterceptor();
	}

}
