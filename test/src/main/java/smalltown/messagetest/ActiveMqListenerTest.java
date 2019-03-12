package smalltown.messagetest;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Service;

/**
 * 测试消息驱动的 POJO
 * @author luhha
 *
 */
@Service
public class ActiveMqListenerTest implements MessageListener {
	public void listener(){
		System.out.println("========ActiveMqListenerTest=======ReceiveMessage!");
	}
	public void init(){
		System.out.println("begin...listener");
	}
	@Override
	public void onMessage(Message arg0) {
		System.out.println("========ActiveMqListenerTest=======ReceiveMessage!\n");

	}
}
