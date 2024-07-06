package jaquesprojetos.standerdevweek.controller;


import jaquesprojetos.standerdevweek.domain.model.User;
import jaquesprojetos.standerdevweek.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
		private final UserService userService;
		
		public UserController(UserService userService) {
				this.userService = userService;
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<User> findById(@PathVariable("id") Long id) {
				return ResponseEntity.ok(userService.findById(id));
		}
		
		@PostMapping
		public ResponseEntity<User> create(@RequestBody User user) {
				User userCreated = userService.create(user);
				URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getId()).toUri();
				return ResponseEntity.created(uri).body(userCreated);
		}
		
		
}
