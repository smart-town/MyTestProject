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
import smalltown.repositoryimpl.UserRepositoryJpaAuto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RepositoryConfig.class)
public class TestConfig {
	@Autowired
	@Qualifier("userRepositoryJpaImpl")
	UserRepository userRepository ;
	@Autowired
	UserRepositoryJpaAuto autoJpa ;

	@Before
	public void hello(){
		System.out.println("=====Test About Repository=====");
	}
	@Test
	public void log(){
		System.out.println("====Test====");
		User user = userRepository.getUserById("1") ;
		System.out.println(user);
	}

	@Test
	public void testAuto(){
		System.out.println("=====AutoJPA======");
		System.out.println("Auto:"+autoJpa.getOne(1));
	}

	@Test
	public void testAutoGenerate(){
		System.out.println("====AutoGenerateLanguage======");
		System.out.println(autoJpa.findByNameLike("lu%"));
	}

	@Test
	public void testAutoQuery(){
		System.out.println("====Test @Query======");
		System.out.println(autoJpa.findNameAndStatus("lu%",0));
	}
}
