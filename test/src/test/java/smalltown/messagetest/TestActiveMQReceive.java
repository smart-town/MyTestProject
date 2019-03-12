package smalltown.messagetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ActiveMQConfig.class}/*, locations={"classpath:classpath:jmslistener.xml"}*/)
public class TestActiveMQReceive {
	@Autowired
	ActiveMQTest activeMqTest;
	@Autowired
	ActiveMqListenerTest activeMqListener ;
	@Test
	public void testReceive(){
		activeMqTest.testReceive();
	}

	@Test
	public void testReceiveListener(){
		activeMqListener.init();
	}

}
