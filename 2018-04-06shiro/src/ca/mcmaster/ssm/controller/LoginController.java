package ca.mcmaster.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.mcmaster.ssm.po.ActiveUser;
import ca.mcmaster.ssm.service.ebi.SysEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 5, 2018 7:21:08 PM
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class LoginController {
	@Autowired
	private SysEbi sysEbi;
	@RequestMapping(value="/{usercode}/{password}", method=RequestMethod.POST)
	public String login(HttpSession session, @PathVariable String usercode, @PathVariable String password) throws Exception{
		ActiveUser activeUser = sysEbi.authenticate(usercode, password);
		session.setAttribute("activeUser", activeUser);
		return "redirect:/items/queryItems.action";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session, String usercode, String password){
		session.invalidate();
		return "login";
	}
}
