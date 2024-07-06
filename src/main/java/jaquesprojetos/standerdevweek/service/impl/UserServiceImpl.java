package jaquesprojetos.standerdevweek.service.impl;

import jaquesprojetos.standerdevweek.domain.model.User;
import jaquesprojetos.standerdevweek.domain.repository.UserRepository;
import jaquesprojetos.standerdevweek.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
		private final UserRepository userRepository;
		
		public UserServiceImpl(UserRepository userRepository) {
				this.userRepository = userRepository;
		}
		
		@Override
		public User findById(Long id) {
				if (!userRepository.existsById(id)) {
						throw new NoSuchElementException("User not found");
				}
				
				return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
		}
		
		@Override
		public User create(User userToCreate) {
				if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
						throw new IllegalArgumentException("This account number already exists");
				}
				return userRepository.save(userToCreate);
		}
}
