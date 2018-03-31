package ca.mcmaster.mybatis.mapper;

import java.util.List;

import ca.mcmaster.vo.Orders;
import ca.mcmaster.vo.OrdersCustom;

/**
 * @author SeanForFun
 * @date  Mar 30, 2018 7:04:43 PM
 * @version 1.0
 */
public interface OrdersMapperCustom {
	public List<OrdersCustom> findOrderUserList() throws Exception;
	public List<Orders> findOrderUserListByMap() throws Exception;
	public List<Orders> findOrderAndOrderdetail() throws Exception;
}
