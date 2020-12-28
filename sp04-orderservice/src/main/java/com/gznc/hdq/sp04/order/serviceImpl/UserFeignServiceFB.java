package com.gznc.hdq.sp04.order.serviceImpl;

import org.springframework.stereotype.Component;

import com.gznc.hdq.pojo.User;
import com.gznc.hdq.util.JsonResult;

@Component
public class UserFeignServiceFB implements UserFeignService{
	@Override
	public JsonResult<User> getUser(Integer userId) {
		return JsonResult.err("无法获取用户信息");
	}

	@Override
	public JsonResult addScore(Integer userId, Integer score) {
		return JsonResult.err("无法增加用户积分");
	}

}
