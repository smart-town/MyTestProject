package smalltown.wscontroller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import smalltown.model.ShotMessage;
import smalltown.model.UserInfo;

@Controller

public class StompTest01 {
	private Scanner input ;
	public StompTest01() {
		this.input = new Scanner(System.in); 
	}
	
	@MessageMapping("/login")
	@SendTo("/queue/login") // Use @SendTo to specify the destination
	public ShotMessage handleLogin(UserInfo msg) {
		System.out.println(">>>Deal login,param:"+msg);
		ShotMessage result = new ShotMessage();
		result.setMessage("success");
		return result;
	}
	
	@MessageMapping("/loginInfo") //Default return, add prefix "/topic",and destination is "/loginInfo"
	public ShotMessage handleLogin(String msg) {
		ShotMessage result = new ShotMessage();
		System.out.print("Input Content:");
		result.setMessage(input.nextLine());
		return result;
	}
}
