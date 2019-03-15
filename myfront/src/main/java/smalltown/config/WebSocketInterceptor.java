package smalltown.config;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.reactive.ServletHttpHandlerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Component
public class WebSocketInterceptor implements HandshakeInterceptor{
	public WebSocketInterceptor(){
		System.out.println("\n**********\nWebSocketInterceptor\n*********");
	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		/*
		 * if(request instanceof ServletServerHttpRequest) { ServletServerHttpRequest
		 * serverRequest = (ServletServerHttpRequest)request ; HttpSession session =
		 * serverRequest.getServletRequest().getSession(); if(session != null) {
		 * attributes.put("username", session.getAttribute("username")) ; } }
		 */
		System.out.println("握手拦截请求...");
		return true;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		// TODO Auto-generated method stub

	}

}
