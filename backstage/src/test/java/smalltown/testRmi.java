package smalltown;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import smalltown.config.BackStageConfig;
import smalltown.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={BackStageConfig.class,})
@Ignore
public class testRmi {

	@Autowired
	UserService userService;
	@Autowired
	RmiServiceExporter exporter;

	@BeforeClass
	public static void beforeClass(){
		System.out.println("UserBean:");
	}

	@Before
	public void before(){
		System.out.println("====Test RMI====");
	}

	@Test
	public void testUserGet(){
		System.out.println("=Test User RMI get=");
		System.out.println("rmi exporter:"+exporter);
		System.out.println("获得:"+userService.getUser("1"));
	}
}
