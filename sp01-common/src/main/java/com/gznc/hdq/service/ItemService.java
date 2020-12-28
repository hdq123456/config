package com.gznc.hdq.service;

import java.util.List;

import com.gznc.hdq.pojo.Item;

public interface ItemService {
	List<Item> getItems(String orderId);
	void decreaseNumbers(List<Item> list);
}
