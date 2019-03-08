package smalltown.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestNotify{

	@Pointcut("execution(* smalltown.repository.*.getUserById(..))")
	public void getPointcut(){}

	@Before("getPointcut()")
	public void beforeGet(){
		System.out.println("Aspect===GET USER===Aspect");
	}
}
