package ca.mcmaster.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.mcmaster.ssm.po.ItemsCustom;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 4, 2018 1:14:02 PM
 * @version 1.0
 */
@Controller
public class JsonTestController {
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) throws Exception{
		return itemsCustom;
	}
	
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom) throws Exception{
		return itemsCustom;
	}
}
