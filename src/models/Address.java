package models;

public class Address {
	public int Address_id;
	public int UserId;
	public int DoorNumber;
	public String Street;
	public String City;
	public int AddressTypeId;
	
	public Address() {}

	public Address(int user_id, int door_number, String street, String city, int address_type) {
		this.UserId = user_id;
		this.DoorNumber = door_number;
		this.Street = street;
		this.City = city;
		this.AddressTypeId = address_type;
	}
}
