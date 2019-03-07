package smalltown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class MyIndex {
//	private static Logger;
	
	@RequestMapping(method=RequestMethod.GET)
	public String myIndex(){
		System.out.println("goto-\"\\033[31;4mRed Underline Text\\033[0m\"") ;
		return "myIndex" ;
	}
}
