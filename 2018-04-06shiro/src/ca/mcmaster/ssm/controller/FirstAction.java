package ca.mcmaster.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//
//import cn.itcast.ssm.po.ActiveUser;
//import cn.itcast.ssm.po.SysPermission;

@Controller
public class FirstAction {
	@RequestMapping("/first")
	public String first(Model model)throws Exception{
		return "/first";
	}
	
	@RequestMapping("/welcome")
	public String welcome(Model model)throws Exception{
		return "/welcome";
		
	}
}	
