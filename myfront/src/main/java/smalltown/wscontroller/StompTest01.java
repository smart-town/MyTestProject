package smalltown.wscontroller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import smalltown.model.ShotMessage;

@Controller

public class StompTest01 {
	@MessageMapping("/login")
	public void handleLogin(ShotMessage msg) {
		System.out.println(">>>Deal login");

	}
}
