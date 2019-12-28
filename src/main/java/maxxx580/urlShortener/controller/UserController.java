package maxxx580.urlShortener.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import maxxx580.urlShortener.daoservice.UserDaoService;
import maxxx580.urlShortener.exception.UserNotFoundException;
import maxxx580.urlShortener.model.User;


@RestController
public class UserController {
	
	@Autowired
	private UserDaoService userDaoService;

	@GetMapping(path = "/users")
	public List<User> find() {
		return userDaoService.find();
	}

	@GetMapping(path = "/users/{id}")
	public User find(@PathVariable int id) throws UserNotFoundException {
		User userFound = userDaoService.find(id);
		if (userFound == null) {
			throw new UserNotFoundException("User " + id + " not found"); 
		}
		return userFound;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build(); 
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) throws UserNotFoundException {
		User userDeleted = userDaoService.delete(id);
		if (userDeleted == null) {
			throw new UserNotFoundException("User " + id + " not found"); 
		}
		return;
	}

}
