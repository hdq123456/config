package com.gznc.hdq.service;

import com.gznc.hdq.pojo.Order;

public interface OrderService {
	Order getOrder(String orderId);
	void addOrder(Order order);

}
