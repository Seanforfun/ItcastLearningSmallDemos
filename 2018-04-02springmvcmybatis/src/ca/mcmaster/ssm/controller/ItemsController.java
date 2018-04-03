package ca.mcmaster.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ca.mcmaster.ssm.po.Items;
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

	// ����һ���ַ������ַ���Ϊ�߼���ͼ��
	@RequestMapping(value = "/editItems", method = RequestMethod.GET)
	public String editItems(Model model,
			@ModelAttribute(value = "id") Integer id) throws Exception {
		ItemsCustom itemsCustom = itemsService.getItemsById(id);
		model.addAttribute("item", itemsCustom);
		return "editItem";
	}

	// RequestParamע���õĲ��࣬���request����Ĳ��������β���һ������Ҫ��
	// required��ʾ��ֵ�Ƿ��Ǳ���ģ�defaultValue������һ��Ĭ��ֵ��
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

	// �ض����޷�����request������ݣ�����url�ᷢ���仯
	@RequestMapping(value = "/updateItems", method = RequestMethod.GET)
	public String updateItems(Model model,
			@ModelAttribute(value = "id") Integer id,
			@ModelAttribute(value = "item") ItemsCustom itemsCustom,
			ItemsQueryVo itemsQueryVo) throws Exception {
		// ͨ������model�����ݻ���
		// model.addAttribute("id", id);
		// model.addAttribute("item", item);
		itemsService.updateItem(id, itemsCustom);
		// return "redirect:queryItems.action";
		// return "forward:queryItems.action";
		return "editItem";
	}

	// �Զ������Ա༭��,�޷��ڶ�����й���
	// @InitBinder
	// public void initBind(WebDataBinder binder) throws Exception{
	// binder.registerCustomEditor(Date.class, new CustomDateEditor(new
	// SimpleDateFormat("yyyy-MM-dd HH-mm-ss"), true));
	// }
	
	//�����õ�ȡ���ݵķ������ݵ�ҳ�棬����ÿ�ε��õ�ǰcontroller����ʹ�ã������ӷ����ڸ�����
	@ModelAttribute(value="itemsType")
	public Map<String, String> getItemsMap(){
		Map<String, String> itemsType = new HashMap<>();
		itemsType.put("001", "������");
		itemsType.put("002", "��װ");
		return itemsType;
	}
}
