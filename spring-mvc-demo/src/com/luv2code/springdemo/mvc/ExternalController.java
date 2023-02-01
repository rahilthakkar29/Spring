package com.luv2code.springdemo.mvc;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExternalController {
	
	@RequestMapping("/resourcePage")
	public String resourcePage() {
		return "newpage";
	}
	
	// request param using annotations
	@RequestMapping("processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String name,
			Model model) {
		

		
		// convert the data to all caps
		name = name.toUpperCase();
		
		// create the message
		String message = "Hey my friend from v3! " + name;
		
		// add message to the model
		model.addAttribute("message", message);
		
		
		return "helloworld";
	}

}
