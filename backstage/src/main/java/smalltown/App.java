package smalltown;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import smalltown.config.BackStageConfig;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(BackStageConfig.class) ;
        System.out.println( "spring background stage start..." );
    }
}
