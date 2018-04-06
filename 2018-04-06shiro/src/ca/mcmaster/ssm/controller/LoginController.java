package ca.mcmaster.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 5, 2018 7:21:08 PM
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class LoginController {
	@RequestMapping(value="/{usercode}/{password}", method=RequestMethod.POST)
	public String login(HttpSession session, @PathVariable String usercode, @PathVariable String password){
		System.out.println(usercode+":"+password);
		session.setAttribute("usercode", usercode);
		return "redirect:/items/queryItems.action";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session, String usercode, String password){
		session.invalidate();
		return "login";
	}
}
