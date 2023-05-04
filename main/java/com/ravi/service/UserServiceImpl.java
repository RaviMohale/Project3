package com.ravi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.binding.LoginForm;
import com.ravi.binding.RegistrationForm;
import com.ravi.entity.User;
import com.ravi.repo.UserDltsRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDltsRepo userRepo;
	
	@Override
	public boolean signup(RegistrationForm form) {
		
		User user = userRepo.findByEmail(form.getEmail());
		
		if(user != null) {
			return false;
		}
		 User userEntity = new User();
		 BeanUtils.copyProperties(form, userEntity);
		 
		 userRepo.save(userEntity);
		 
		
		
		return true;
	}

	@Override
	public String login(LoginForm form) {
		 User entity = userRepo.findByEmailAndPassword(form.getEmail(), form.getPassword());
		
		if(entity == null) {
			return "invalid Credential";
		}
		return "success";
	}
}
