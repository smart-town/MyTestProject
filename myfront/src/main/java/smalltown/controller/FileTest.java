package smalltown.controller;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/testFile")
public class FileTest {
	private static Logger log = LoggerFactory.getLogger(FileTest.class); 
	
	@RequestMapping(method=RequestMethod.POST)
	public String getFile(@RequestPart("testFile") MultipartFile file, Model model) throws Exception {
		log.info("fileName:{}\nContentType:{}", file.getName(), file.getContentType());
		file.transferTo(new File(file.getOriginalFilename()));
		model.addAttribute("item","file upload success") ;
		return "result/success" ;
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Model model) {
		log.info("save file somewrong");
		model.addAttribute("error", "save file exception,may ioException") ;
		return "result/error" ;
	}
}
