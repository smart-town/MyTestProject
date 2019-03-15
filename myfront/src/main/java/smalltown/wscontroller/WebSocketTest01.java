package smalltown.wscontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component
public class WebSocketTest01 extends AbstractWebSocketHandler { 
	private static final Logger logger = LoggerFactory.getLogger(WebSocketTest01.class) ;
	
	public void handleTextMessage(WebSocketSession session,TextMessage message) throws Exception {
		logger.info("\n*****WebSocket..Lower API..");
		System.out.println("Receive:" + message.getPayload()) ;
		Thread.sleep(2000);
		session.sendMessage(new TextMessage("Hello!"));
	}
}
