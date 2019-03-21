package smalltown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class MyIndex {
//	private static Logger;
	@Autowired
	MbeanTest mbeanTest;
	private String msbean = "MsBean-default";
	public String getMsbean() {
		return msbean;
	}
	public void setMsbean(String msbean) {
		this.msbean = msbean;
	}
	@RequestMapping(method=RequestMethod.GET)
	public String myIndex(){
		System.out.println("goto-\"\\033[31;4mRed Underline Text\\033[0m\"") ;
		System.out.println("******MBEAN******"+this.mbeanTest.getName());
		return "myIndex" ;
	}
}
