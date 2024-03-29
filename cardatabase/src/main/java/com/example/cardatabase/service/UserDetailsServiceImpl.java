package com.example.cardatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.cardatabase.domain.User;
import com.example.cardatabase.domain.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User currentUser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core
				.userdetails.User(username, currentUser.getPassword()
						, true, true, true, true,
						AuthorityUtils.createAuthorityList(currentUser.getRole()));
		return user;
	}
	
	
}