package controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome-home";
	}
	
	
	@RequestMapping("/processOrder")
	public String confirmOrder(HttpServletRequest request, Model model) {
		String orderName = request.getParameter("orderDetail");
		model.addAttribute("name", orderName);
		return "confirmation";
	}
}
