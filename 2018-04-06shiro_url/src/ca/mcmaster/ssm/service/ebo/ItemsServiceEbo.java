package ca.mcmaster.ssm.service.ebo;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import ca.mcmaster.ssm.exception.CustomException;
import ca.mcmaster.ssm.mapper.ItemsMapper;
import ca.mcmaster.ssm.mapper.ItemsMapperCustom;
import ca.mcmaster.ssm.po.Items;
import ca.mcmaster.ssm.po.ItemsCustom;
import ca.mcmaster.ssm.po.ItemsQueryVo;
import ca.mcmaster.ssm.service.ebi.ItemsService;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 2, 2018 3:19:08 PM
 * @version 1.0
 */
public class ItemsServiceEbo implements ItemsService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom getItemsById(int id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		if(items == null){
			throw new CustomException("商品信息不存在！");
		}
		ItemsCustom itemsCustom = new ItemsCustom();
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	@Override
	public void updateItem(Integer id, ItemsCustom itemsCustom) throws Exception {
		//Not null validation for service code.
		if(null == id){
			//Throw exception
		}
		itemsMapper.updateByPrimaryKeySelective(itemsCustom);
	}
}
