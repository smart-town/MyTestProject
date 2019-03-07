package smalltown.config;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import smalltown.model.User;
import smalltown.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RepositoryConfig.class)
public class TestConfig {
	@Autowired
	@Qualifier("UserJap")
	UserRepository userRepository ;

	@Before
	public void hello(){
		System.out.println("=====Test About Repository=====");
	}
	@Test
	public void log(){
		System.out.println("====Test====");
		User user = userRepository.getUserById("1") ;
		System.out.println(user.getName());
	}
}
