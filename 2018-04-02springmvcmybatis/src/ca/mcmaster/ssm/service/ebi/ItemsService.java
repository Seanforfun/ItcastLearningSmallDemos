package ca.mcmaster.ssm.service.ebi;

import java.util.List;

import ca.mcmaster.ssm.po.ItemsCustom;
import ca.mcmaster.ssm.po.ItemsQueryVo;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 2, 2018 3:17:40 PM
 * @version 1.0
 */
public interface ItemsService {
	/**
	 * @Description: Find items information with query conditions.
	 * @param itemsQueryVo
	 * @return
	 * @throws Exception
	 */
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception;
}
