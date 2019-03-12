package smalltown.messagetest;

import org.springframework.stereotype.Service;

/**
 * 消息驱动的 POJO
 * @author luhha
 *
 */
@Service
public class UserPojoListener {
	public void handleAlert(Object obj){
		System.out.println("=====POJO Listener=====");
		System.out.println("==GET:"+obj);
	}
	public void otherOperations(){
		System.out.println("it can do others things.");
	}
}
