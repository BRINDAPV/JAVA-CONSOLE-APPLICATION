package repository;

import java.util.List;

import models.User;

public interface IUserRepo {
	User getUserById(int userId);
	List<User> getAllUsers();
	User AddUser(User user);
}
