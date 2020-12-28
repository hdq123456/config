package com.gznc.hdq.service;

import com.gznc.hdq.pojo.User;

public interface UserService {
	User getUser(Integer id);
	void addScore(Integer id, Integer score);
}
