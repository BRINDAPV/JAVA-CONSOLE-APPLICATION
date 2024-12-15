package repository;

import java.util.*;

import models.Address;

public class ListAddressRepo implements IAddressRepo{
	
	private List<Address> addresses;
	private int addressIdCount;
	
	public ListAddressRepo() {
		addresses = new ArrayList<>();
		addressIdCount = 1;
	}
	
	@Override
	public Address addAddress(Address address) {
		// declaring the addressId
		address.Address_id = addressIdCount + 1;
		
		// adding the details here
		addresses.add(address);
		return address;
		
	}
	
	@Override
	public List<Address> getAddressesByUserID(int user_id){
		List<Address> userAddresses = new ArrayList<>();
		for (Address address : addresses) {
			if (address.UserId == user_id) {
				userAddresses.add(address);
			}
		}
		
		return userAddresses;
		
	}
}
