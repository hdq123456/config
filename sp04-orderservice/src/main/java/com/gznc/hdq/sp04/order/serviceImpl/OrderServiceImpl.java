package com.gznc.hdq.sp04.order.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gznc.hdq.pojo.Item;
import com.gznc.hdq.pojo.Order;
import com.gznc.hdq.pojo.User;
import com.gznc.hdq.service.OrderService;
import com.gznc.hdq.util.JsonResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ItemFeignService itemService;
	@Autowired
	private UserFeignService userService;

	@Override
	public Order getOrder(String orderId) {
		// TODO: 调用user-service获取用户信息
		JsonResult<User> user = userService.getUser(7);
		
		// TODO: 调用item-service获取商品信息
		JsonResult<List<Item>> jr = itemService.getItems(orderId);
		
		Order order = new Order();
		order.setId(orderId);
		order.setItems(jr.getData());
		order.setUser(user.getData());
		return order;
	}

	@Override
	public void addOrder(Order order) {
		// TODO: 调用user-service增加用户积分
		userService.addScore(order.getUser().getId(), 1000);
		// TODO: 调用item-service减少商品库存
		itemService.decreaseNumber(order.getItems());
		log.info("保存订单：" + order);
	}

}
