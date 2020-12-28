package com.gznc.hdq.sp04.order.serviceImpl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gznc.hdq.pojo.User;
import com.gznc.hdq.util.JsonResult;

@FeignClient(name = "user-service",fallback = UserFeignServiceFB.class)
public interface UserFeignService {
	@GetMapping("/{userId}")
	public JsonResult<User> getUser(@PathVariable("userId") Integer id);

	@GetMapping("/{userId}/{score}")
	public JsonResult addScore(@PathVariable("userId") Integer id, @PathVariable("score") Integer score);
}
