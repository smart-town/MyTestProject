package smalltown.rpctest;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import smalltown.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RmiTestConfig.class})
@Ignore
public class RmiTest {
	@Autowired
	UserService userService;

	@Test
	public void test(){
		System.out.println("===rmi user test===");
		System.out.println(userService.getUser("1"));
	}
}
