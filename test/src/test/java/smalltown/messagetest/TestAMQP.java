package smalltown.messagetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AMQPConfig.class})
public class TestAMQP {
	@Autowired
	RabbitMQTest rbtest;
	@Autowired
	UserPojoListener listener;
	@Test
	public void testReceive(){
		System.out.println("=====Test Receive====");
		rbtest.getMessage();
	}

	@Test
	public void testReceivePOJO(){
		System.out.println("=====Test Receive====");
		//rbtest.getMessage();
		listener.otherOperations();
	}
}
