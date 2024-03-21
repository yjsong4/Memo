package com.syj.memo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syj.memo.common.EncryptUtils;
import com.syj.memo.user.domain.User;
import com.syj.memo.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public int addUser(String loginId, String password, String name, String email) {
		
		String encryptPassword = EncryptUtils.md5(password);

		return userRepository.insertUser(loginId, encryptPassword, name, email);
	}
	
	public User getuserByLoginIdAndPassword(String loginId, String password) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		return userRepository.selectUserByLoginIdAndPassword(loginId, password);
	}

}
