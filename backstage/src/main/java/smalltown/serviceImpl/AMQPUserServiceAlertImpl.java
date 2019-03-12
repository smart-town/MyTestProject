package smalltown.serviceImpl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smalltown.model.User;
import smalltown.service.AlertUserService;

@Service
public class AMQPUserServiceAlertImpl implements AlertUserService{
	@Autowired
	RabbitTemplate rabbit ;

	@Override
	public void sendUserService(User user) {
		System.out.print("*****Test RabbitTemplate sendAndConvert");
		rabbit.convertAndSend("user.alerts",user);
		System.out.println(".....send Over");
	}
}
