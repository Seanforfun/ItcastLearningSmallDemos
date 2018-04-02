package ca.mcmaster.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ca.mcmaster.ssm.po.Items;
import ca.mcmaster.ssm.po.ItemsCustom;
import ca.mcmaster.ssm.service.ebi.ItemsService;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 2, 2018 3:22:51 PM
 * @version 1.0
 */
@Controller
public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems.action")
	public ModelAndView queryItems() throws Exception{
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("itemsList");
		
		return modelAndView;
	}
}
