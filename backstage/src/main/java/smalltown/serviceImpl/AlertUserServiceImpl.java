package smalltown.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

import smalltown.model.User;
import smalltown.service.AlertUserService;

@Service
public class AlertUserServiceImpl implements AlertUserService {
//	@Autowired
//	JmsOperations jmsOperations ;

	@Override
	public void sendUserService(User user) {
//		jmsOperations.convertAndSend(user);
	}

}
