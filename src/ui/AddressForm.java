package ui;

import java.util.List;
import java.util.Scanner;

import models.Address;
import repository.AddressRepo;

public class AddressForm {

    // Method to handle address selection and addition
    public static Address handleAddressSelection(Scanner scanner, int currentUserId) {
        Address selectedAddress = null;
        List<Address> allAddressesOfUser = AddressRepo.getAddressesByUserID(currentUserId); // Fetch user addresses
        
        if (allAddressesOfUser != null && !allAddressesOfUser.isEmpty()) {
            System.out.println("Your Existing Addresses:");
            for (int i = 0; i < allAddressesOfUser.size(); i++) {
                Address address = allAddressesOfUser.get(i);
                System.out.println((i + 1) + ": Address ID: " + address.Address_id + ", "
                        + address.DoorNumber + ", " + address.Street + ", " + address.City);
            }

            System.out.println("Would you like to:");
            System.out.println("1: Use an existing address");
            System.out.println("2: Add a new address");

            int addressChoice = scanner.nextInt();
            
            if (addressChoice == 1) {
                System.out.println("Select an address by number:");
                int selectedNumber = scanner.nextInt();
                if (selectedNumber > 0 && selectedNumber <= allAddressesOfUser.size()) {
                	
                    selectedAddress = allAddressesOfUser.get(selectedNumber - 1);
                    
                    System.out.println("Your Order has been Confirmed");
                    System.out.println("Your Order will be sent to this Address : "+selectedAddress.Street+" , "+selectedAddress.City);
                    System.out.println("Thankyou!");
                
                } 
                else {
                    System.out.println("Invalid selection.");
                    return null; }
            } 
            
            else if (addressChoice == 2) {
                // User wants to add a new address
                System.out.println("Enter new address details:");
                Address newAddress = collectUserAddress(scanner, currentUserId); // Collect new address details
                Address addedAddress = AddressRepo.addAddress(newAddress); // Add address to the database
                if (addedAddress != null) {
//                    System.out.println("New Address added successfully. Selected Address ID: " + addedAddress.Address_id);
                    selectedAddress = addedAddress; // Set the selected address to the new one added
                    System.out.println("Your Order has been Confirmed");
                    System.out.println("Your Order will be sent to this Address : "+selectedAddress.Street+" , "+selectedAddress.City);
                    System.out.println("Thankyou!");
                } else {
                    System.out.println("Failed to add a new address.");
                }
            }
            
            else {
                System.out.println("Invalid choice.");
            }
        } 
        
        else {
            System.out.println("No existing addresses found. Please add a new address.");
            Address newAddress = collectUserAddress(scanner, currentUserId);
            Address addedAddress = AddressRepo.addAddress(newAddress);
            if (addedAddress != null) {
            	selectedAddress = addedAddress;
            	System.out.println("Your Order has been Confirmed");
                System.out.println("Your Order will be sent to this Address : "+selectedAddress.Street+" , "+selectedAddress.City);
                System.out.println("Thankyou!");
//                System.out.println("New Address added successfully. "+selectedAddress.Street+" , "+selectedAddress.City);
            } else {
                System.out.println("Failed to add a new address.");
            }
        }
        return selectedAddress;
    }

    // Method to collect address details
    private static Address collectUserAddress(Scanner scanner, int userId) {
        // Collecting address details from the user
        System.out.print("Enter Door Number: ");
        int doorNumber = scanner.nextInt();
        scanner.nextLine();  // Consume the newline left by nextInt()

        System.out.print("Enter Street: ");
        String street = scanner.nextLine();

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        System.out.println("Enter Address Type : ");
        System.out.println("1 : Office");
        System.out.println("2 : Residential");
        int addressTypeChoice = scanner.nextInt();

//        String addressType = (addressTypeChoice == 1) ? "Office" : "Residential";

        Address newAddress = new Address();
        newAddress.UserId = userId;
        newAddress.DoorNumber = doorNumber;
        newAddress.Street = street;
        newAddress.City = city;
        newAddress.AddressTypeId = addressTypeChoice;
        return newAddress;
    }
}
