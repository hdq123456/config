package com.gznc.hdq.sp03.user.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gznc.hdq.pojo.User;
import com.gznc.hdq.service.UserService;
import com.gznc.hdq.util.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Value("${sp.user-service.users}")
	private String userJson;

	@Override
	public User getUser(Integer id) {
		log.info("users json string:" + userJson);

		List<User> userList = JsonUtil.from(userJson, new TypeReference<List<User>>() {
		});
		for (User user : userList) {
			if (id.equals(user.getId())) {
				return user;
			}
		}
		return new User(id, "name-" + id, "pwd-" + id);

	}

	@Override
	public void addScore(Integer id, Integer score) {
		// 增加积分
		log.info("user-" + id + " - 增加积分 " + score);

	}

}
