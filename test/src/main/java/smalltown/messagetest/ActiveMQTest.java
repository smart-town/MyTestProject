package smalltown.messagetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQTest {
//	@Autowired
//	JmsOperations jsmOperations ;

	public void testReceive(){
		System.out.println("接收消息");
//		System.out.println(jsmOperations.receiveAndConvert().toString());
	}
}
