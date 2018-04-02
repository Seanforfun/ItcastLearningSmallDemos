package ca.mcmaster.ssm.service.ebo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ca.mcmaster.ssm.mapper.ItemsMapperCustom;
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
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

}
