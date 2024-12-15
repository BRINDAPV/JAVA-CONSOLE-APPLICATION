package ui;

import java.util.*;
import java.util.Scanner;

import repository.ListAddressRepo;
import repository.ListUserRepo;
import repository.ListFoodRepo;
import repository.IUserRepo;
import repository.IAddressRepo;
import repository.IFoodRepo;

import models.User;
import repository.UserRepo;

import models.Food;
import models.Orders;
import repository.FoodRepo;

import models.Address;
import repository.AddressRepo;

//import repository.IUserRepo;
public class Main {

	public static void main(String[] args) {
		
		int currentUserId = 0; // identified using their user id
		int selectedAddressId = 0;
		
		IUserRepo userRepo = new ListUserRepo();
		IAddressRepo addressRepo = new ListAddressRepo();
		IFoodRepo foodRepo = new ListFoodRepo();
		
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("\nSelect an option : ");
			System.out.println("1 : Login");
			System.out.println("2 : Register");
			System.out.println("3 : Admin");
			
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Dear Customer,\n Enter Your User ID: ");
			    currentUserId = scanner.nextInt();
			    User currentUser = userRepo.getUserById(currentUserId);
			    System.out.println("Hi " + currentUser.Name + ",");

			    // storing the orders in the map
			    OrdersForm.yourOrders(scanner, foodRepo, currentUserId);

			    Address selectedAddress = AddressForm.handleAddressSelection(scanner, currentUserId);
                if (selectedAddress != null) {
                    selectedAddressId = selectedAddress.Address_id;
//                    System.out.println("Selected Address ID: " + selectedAddressId);
                } else {
                    System.out.println("Address selection failed.");
                }
				
                // storing it now to the database once the Address_id is retrived
				Orders currentOrders = OrdersForm.newOrder(scanner, foodRepo, currentUserId,selectedAddressId);
				
				// storing the food_id's and quantiy to the database
				OrderedItemsList.insertOrders(currentOrders.OrderId);
//				System.out.println("ThankYou!");
				break;
			case 2:
				User newUser = RegisterForm.collectUserDetails(scanner);
				// sir's line
				User addedUser = userRepo.AddUser(newUser);
				
				if (addedUser != null) {
//					System.out.println("User added Successfully: "+addedUser.Name);
					Address newAddress = RegisterForm.collectUserAddress(scanner,newUser.UserId);
					Address addedAddress = addressRepo.addAddress(newAddress);
					if (addedAddress != null) {
						System.out.println("User and Address added Successfully");
					}
					System.out.println("Your User ID : "+newUser.UserId);
					System.out.println("Kindly Save Your User ID for further Logins");
				}
				else {
					System.out.println("Failed to add user");
				}
				break;
			
			case 3:
				System.out.println("Enter Your Option : ");
				System.out.println("1 : Show user");
				System.out.println("2 : Add food");
				int adminChoice = scanner.nextInt();
				switch (adminChoice) {
					case 1:
						// admin side
						UserList.showUser(userRepo,scanner);
						break;
					case 2:
						// admin side
						Food newFood = MenuForm.collectFoodDetails(scanner);
						Food addedFood = foodRepo.addNewFood(newFood);
						
						if (addedFood != null) {
							System.out.println("Food Added Successfully!");
						}
						else {
							System.out.println("Failed To Add Food");
						}
						break;
				}
				break;
			}
			
		}
		
	}
	
}
