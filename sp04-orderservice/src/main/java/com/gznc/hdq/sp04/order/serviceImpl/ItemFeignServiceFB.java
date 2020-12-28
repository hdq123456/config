package com.gznc.hdq.sp04.order.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gznc.hdq.pojo.Item;
import com.gznc.hdq.util.JsonResult;

@Component
public class ItemFeignServiceFB implements ItemFeignService {

	@Override
	public JsonResult<List<Item>> getItems(String orderId) {
		if (Math.random() < 0.5) {
			List<Item> list = new ArrayList<>();
			list.add(new Item(1,"缓存aaa",1));
			list.add(new Item(2,"缓存bbb",2));
			list.add(new Item(3,"缓存ccc",2));
			return JsonResult.ok(list);
		}
		return JsonResult.err("无法获取商品失败");

	}

	@Override
	public JsonResult decreaseNumber(List<Item> items) {
		return JsonResult.err("无法减少商品失败");
	}

}
