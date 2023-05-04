package com.ravi.repo;

 
import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.User;

public interface UserDltsRepo  extends JpaRepository<User, Integer>{
	
	public User findByEmail(String email);
	
	

	public User findByUserEmailAndUserPwd(String email, String password);

	
}
