package ca.mcmaster.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ca.mcmaster.ssm.po.ItemsCustom;
import ca.mcmaster.ssm.po.ItemsQueryVo;
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

	@RequestMapping(value = "/queryItems", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView queryItems() throws Exception {
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("itemsList");
		return modelAndView;
	}

	// @RequestMapping(value="/editItems",method=RequestMethod.GET)
	// public ModelAndView editItems() throws Exception{
	// ModelAndView modelAndView = new ModelAndView();
	// ItemsCustom itemsCustom = itemsService.getItemsById(1);
	// modelAndView.addObject("item", itemsCustom);
	// modelAndView.setViewName("editItem");
	// return modelAndView;
	// }

	// 返回一个字符串，字符串为逻辑视图名
	@RequestMapping(value = "/editItems", method = RequestMethod.GET)
	public String editItems(Model model,
			@ModelAttribute(value = "id") Integer id) throws Exception {
		ItemsCustom itemsCustom = itemsService.getItemsById(id);
		model.addAttribute("item", itemsCustom);
		return "editItem";
	}

	// RequestParam注解用的不多，如果request请求的参数名和形参名一致则不需要。
	// required表示该值是否是必须的，defaultValue给定了一个默认值。
	// @RequestMapping(value = "/editItems", method = RequestMethod.GET)
	// public void editItems(
	// HttpServletRequest request,
	// HttpServletResponse response,
	// @RequestParam(value = "item_id", required = false, defaultValue = "1")
	// Integer id)
	// throws Exception {
	// ItemsCustom itemsCustom = itemsService.getItemsById(id);
	// request.setAttribute("item", itemsCustom);
	// request.getRequestDispatcher("/WEB-INF/jsp/editItem.jsp").forward(
	// request, response);
	// }

	// 重定向无法共享request域的数据，并且url会发生变化
	@RequestMapping(value = "/updateItems", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateItems(Model model,
			MultipartFile pictureFile,
			@ModelAttribute(value = "id") Integer id,
			@ModelAttribute(value = "item") ItemsCustom itemsCustom,
			ItemsQueryVo itemsQueryVo) throws Exception {
		if(null != pictureFile && !pictureFile.getOriginalFilename().trim().equals("")){
			String originName = pictureFile.getOriginalFilename();
			String path = "F:\\ImageSave\\";
			String newFilename = UUID.randomUUID() + originName.substring(originName.lastIndexOf("."));
			String name = path + newFilename;
			File image = new File(name);
			pictureFile.transferTo(image);
			itemsCustom.setPic(newFilename);
		}
		// 通过传入model将数据回显
		// model.addAttribute("id", id);
		// model.addAttribute("item", item);
		itemsService.updateItem(id, itemsCustom);
//		 return "redirect:queryItems.action";
		// return "forward:queryItems.action";
		return "redirect:queryItems.action";
	}

	// 自定义属性编辑器,无法在多个类中公用
	// @InitBinder
	// public void initBind(WebDataBinder binder) throws Exception{
	// binder.registerCustomEditor(Date.class, new CustomDateEditor(new
	// SimpleDateFormat("yyyy-MM-dd HH-mm-ss"), true));
	// }
	
	//将公用的取数据的方法传递到页面，但是每次调用当前controller都会使用，会增加服务期负担。
	@ModelAttribute(value="itemsType")
	public Map<String, String> getItemsMap(){
		Map<String, String> itemsType = new HashMap<>();
		itemsType.put("001", "数码类");
		itemsType.put("002", "服装");
		return itemsType;
	}
	
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] delete_id) throws Exception{
		return "redirect:queryItems.action";
	}
}
