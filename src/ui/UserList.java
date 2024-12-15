package ui;

import java.util.List;
import java.util.Scanner;

import models.User;
import repository.IUserRepo;
import repository.UserRepo;

public class UserList {
	public static void showUser(IUserRepo userRepo,Scanner scanner) {
		System.out.println("Select an option : ");
		System.out.println("1 : Display user by ID");
		System.out.println("2 : Display all users");
		int display_choice = scanner.nextInt();
		switch (display_choice) {
		case 1:
			System.out.println("Enter User Id : ");
			int user_id = scanner.nextInt();
			User user = userRepo.getUserById(user_id);
			System.out.println("Name : "+user.Name+"\t"+"Phone Number : "+user.PhoneNumber);
			break;
		case 2:
			List<User> users = userRepo.getAllUsers();
			for (User u : users) {
				System.out.println("Name : "+u.Name+"\t"+"User Id Type : "+u.UserTypeId);
			}
			break;
		}
	}
}
