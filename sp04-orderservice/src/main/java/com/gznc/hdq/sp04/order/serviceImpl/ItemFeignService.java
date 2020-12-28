package com.gznc.hdq.sp04.order.serviceImpl;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gznc.hdq.pojo.Item;
import com.gznc.hdq.util.JsonResult;

@FeignClient(name = "item-service",fallback = ItemFeignServiceFB.class)
public interface ItemFeignService {
	
	@GetMapping("/{orderId}")
	public JsonResult<List<Item>> getItems(@PathVariable("orderId") String orderId);
	
	@PostMapping("/decreaseNumber")
	public JsonResult decreaseNumber(List<Item> items);
}
