package com.gznc.hdq.sp03.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gznc.hdq.pojo.User;
import com.gznc.hdq.service.UserService;
import com.gznc.hdq.util.JsonResult;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/{userId}")
	public JsonResult<User> getUser(@PathVariable Integer userId) {
		log.info("get user,userId=" + userId);
		User user = userService.getUser(userId);
		return JsonResult.ok(user);
	}

	@GetMapping("/{userId}/{score}")
	public JsonResult addScore(@PathVariable Integer userId, @PathVariable Integer score) {
		userService.addScore(userId, score);
		return JsonResult.ok();
	}
	

}
