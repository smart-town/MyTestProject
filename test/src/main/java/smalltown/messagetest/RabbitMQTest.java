package smalltown.messagetest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQTest {
	@Autowired
	RabbitTemplate rabbit;

	public void getMessage(){
		System.out.println("Test-About-RabbitMQ-receiveAndConvert");
		System.out.println("Receive:"+rabbit.receiveAndConvert("user.alerts"));
	}
}
