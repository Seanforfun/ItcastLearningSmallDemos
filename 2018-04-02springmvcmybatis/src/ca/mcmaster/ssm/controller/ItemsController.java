package ca.mcmaster.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ca.mcmaster.ssm.po.ItemsCustom;
import ca.mcmaster.ssm.service.ebi.ItemsService;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 2, 2018 3:22:51 PM
 * @version 1.0
 */
@Controller
@RequestMapping("/items")
public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping(value="/queryItems",method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView queryItems() throws Exception{
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("itemsList");
		return modelAndView;
	}
	
	@RequestMapping(value="/editItems",method=RequestMethod.GET)
	public ModelAndView editItems() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		ItemsCustom itemsCustom = itemsService.getItemsById(1);
		modelAndView.addObject("item", itemsCustom);
		modelAndView.setViewName("editItem");
		return modelAndView;
	}
}
