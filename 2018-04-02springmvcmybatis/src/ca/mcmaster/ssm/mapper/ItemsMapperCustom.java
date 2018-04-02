package ca.mcmaster.ssm.mapper;

import java.util.List;

import ca.mcmaster.ssm.po.ItemsCustom;
import ca.mcmaster.ssm.po.ItemsQueryVo;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 2, 2018 2:39:17 PM
 * @version 1.0
 */
public interface ItemsMapperCustom {
	/**
	 * @Description: Find items information with query conditions.
	 * @param itemsQueryVo
	 * @return
	 * @throws Exception
	 */
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception;
}
