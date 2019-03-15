package smalltown.wscontroller;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component
public class WebSocketTest01 extends AbstractWebSocketHandler {
	private static final Logger logger = LoggerFactory.getLogger(WebSocketTest01.class) ;
	private Scanner input ;
	public WebSocketTest01(){
		input = new Scanner(System.in) ;
	}

	public void handleTextMessage(WebSocketSession session,TextMessage message) throws Exception {
		logger.info("\n*****WebSocket..Lower API..");
		String msg = input.nextLine() ;
		if(!msg.equals("")){
			session.sendMessage(new TextMessage(msg));
		}
	}
}
