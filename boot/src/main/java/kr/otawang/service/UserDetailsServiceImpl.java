package kr.otawang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.otawang.model.User;
import kr.otawang.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public User loadUserByUsername(String id) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id);
		
		if (user == null) {
			throw new UsernameNotFoundException(id);
		}
		
		return user;
	}
 
}
