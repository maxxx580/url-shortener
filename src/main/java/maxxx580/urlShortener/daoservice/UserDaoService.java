package maxxx580.urlShortener.daoservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import maxxx580.urlShortener.model.User;

@Component
public class UserDaoService {
	
	private List<User> users = new ArrayList<User>();
	private int userCount = 0;
	
	public List<User> find() {
		return users;
	}
	
	public User find(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User save(User user) {
		User createdUser = new User(++userCount, user.getUserName(), "Token Place holder", new Date());
		users.add(createdUser);
		return createdUser;
	}
}
