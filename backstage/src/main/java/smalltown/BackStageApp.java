package smalltown;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import smalltown.config.BackStageConfig;
import smalltown.model.User;
import smalltown.service.AlertUserService;

/**
 * Hello world!
 *
 */
public class BackStageApp
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(BackStageConfig.class) ;
        System.out.println( "spring background stage start..." );
        AlertUserService s = (AlertUserService)ctx.getBean("alertUserServiceImpl") ;
        User user = new User() ;
        user.setName("smalltown");
        user.setPassword("111222");
        s.sendUserService(user);
    }
}
