//package transport;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import transport.model.User;
//
//
//@Controller
//public class UserController {
////	@RequestMapping(value = "/",method = RequestMethod.GET)
////	public String getLoginForm() {
////		return "login";
////	}
//	
//	@RequestMapping(value = "/login",method = RequestMethod.POST)
//	public String login(@ModelAttribute(name="user") User user,Model model) {
//		String username = user.getUsername();
//		String password = user.getPassword();
//		
//		if ("admin".equals(username) && "admin".equals(password)) {
//			return "home";
//		}
//		else {
//			model.addAttribute("wronginfor",true);
//			return "login";
//		}
//	}
//}
