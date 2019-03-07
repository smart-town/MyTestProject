package smalltown.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import smalltown.model.TestModel;
import smalltown.model.UseViewResolver;

@Controller
@RequestMapping("/")
public class Login {
	private static Logger log = LoggerFactory.getLogger(Login.class) ;
	
	@Autowired(required=false)
	UseViewResolver useViewResolver;
	
	@RequestMapping(method=RequestMethod.GET)
	public String toLogin(Model model) {
//		HashMap<String,String> testModel = new HashMap<>() ;
		TestModel testModel = new TestModel() ;
		testModel.setName("Cherry!");
		testModel.setAge("23");
		
		if(useViewResolver != null)
			model.addAttribute("theme","Test About Thymeleaf") ;
		log.info("using-profiles:{}",useViewResolver);
		model.addAttribute("testModel",testModel) ;
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String dealData(@Valid TestModel param,Errors errors,Model model) {
		if(errors.hasErrors()) {
			return "index" ;
		}
		log.info("name:{},age:{}",param.getName(),param.getAge()) ;
		model.addAttribute("name",param.getName()) ;
		return "myIndex";
	}
}
