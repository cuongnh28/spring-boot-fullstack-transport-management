package transport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import transport.model.User;

@Controller
public class HomeController {
	
	private Environment env;

	@Autowired
	HomeController(Environment env){
		this.env = env;
	}
	
	@GetMapping("/")
	public String home() {
		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHome(){
		return "home";
	}
	
	@RequestMapping(value = "/home",method = RequestMethod.POST)
	public String login(@ModelAttribute(name="user") User user,Model model) {
		String username = user.getUsername();
		String password = user.getPassword();
		
		if ("admin".equals(username) && "admin".equals(password)) {
			return "home";
		}
		else {
			model.addAttribute("wronginfor",true);
			return "login";
		}
	}
}
