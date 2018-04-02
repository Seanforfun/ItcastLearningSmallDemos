package ca.mcmaster.ssm.service.ebi;

import java.util.List;

import org.springframework.beans.factory.BeanCreationException;

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

	/**
	 * @Description Get an item by its id.
	 * @return
	 * @throws Exception
	 */
	public ItemsCustom getItemsById(int id) throws Exception;

	/**
	 * @Description Update a item information.
	 * @param id	Id of item to be updated.
	 * @param itemsCustom
	 * @throws Exception
	 */
	public void updateItem(Integer id, ItemsCustom itemsCustom) throws Exception;
}
