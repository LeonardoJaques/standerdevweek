package jaquesprojetos.standerdevweek.service;

import jaquesprojetos.standerdevweek.domain.model.User;


public interface UserService {
		User findById(Long id);
		
		User create(User userToCreate);
}
