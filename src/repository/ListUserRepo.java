package repository;

import java.util.*;

import models.User;

public class ListUserRepo implements IUserRepo{
	// 1 -> CREATING A PRIVATE LIST
	private List<User> users;
	
	// 2 -> INITIALIZING THE LIST USING THE CONSTRUCTOR
	public ListUserRepo() {
		users = new ArrayList<>();
	}
	
	@Override
	public User getUserById(int userId) {
		for (User user : users) {
			if (user.UserId == userId) {
				return user;
			}
		}
		return null;
	}
	
	@Override
	public List<User> getAllUsers(){
		return new ArrayList<>(users);
	}
	
	@Override
	public User AddUser(User user) {
		int newUserId = users.size() > 0 ? users.get(users.size() - 1).UserId + 1 : 1;
		// declaring the userId
		user.UserId = newUserId;
		users.add(user);
		return user;
	}
}
