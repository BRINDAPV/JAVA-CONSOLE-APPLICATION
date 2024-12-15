package ui;

import java.util.Scanner;
import models.Address;
import models.User;

public class RegisterForm {
	public static User collectUserDetails(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Enter Name : ");
		String name = scanner.nextLine();
		
		System.out.println("Select User Type : ");
		System.out.println("1 : Vendor");
		System.out.println("2 : Buyer");
		System.out.println("3 : Delivery Person");
		
		int user_type_id = scanner.nextInt();
		
		
		System.out.println("Enter Phone Number");
		long phone_number = scanner.nextLong();
		
		// this is for default parameterized
//		User newUser = new User();
//		newUser.Name = name;
//		newUser.UserTypeId = user_type_id;
//		newUser.PhoneNumber = phone_number;
//		return newUser;
		
		User newUser = new User(0,name,user_type_id,phone_number);
		return newUser;
		
	}
	public static Address collectUserAddress(Scanner scanner, int user_id) {
		System.out.println("Enter Door Number");
		int door_number = scanner.nextInt();
		System.out.println("Enter Street");
		scanner.nextLine();
		String street = scanner.nextLine();
		System.out.println("Enter City");
		String city = scanner.nextLine();
		System.out.println("Enter Address Type : ");
		System.out.println("1 : Office");
		System.out.println("2 : Residential");
		int address_type = scanner.nextInt();
		
//		Address newAddress = new Address();
//		newAddress.UserId = user_id;
//		newAddress.DoorNumber = door_number;
//		newAddress.Street = street;
//		newAddress.City = city;
//		newAddress.AddressTypeId = address_type;		
//		return newAddress;
		
		Address newAddress = new Address(user_id,door_number,street,city,address_type);
		return newAddress;
	}
}
