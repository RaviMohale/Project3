package com.ravi.service;

import com.ravi.binding.LoginForm;
import com.ravi.binding.RegistrationForm;

public interface UserService {
	
	public boolean signup(RegistrationForm form);
	
	public String login(LoginForm form);

}
