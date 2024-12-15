package models;

public class User {
	public int UserId;
	public String Name;
	public int UserTypeId;
	public long PhoneNumber;
	
	public User() {}
	
	public User(int UserId, String Name, int UserTypeId, long PhoneNumber) {
		this.UserId = UserId;
		this.Name = Name;
		this.UserTypeId = UserTypeId;
		this.PhoneNumber = PhoneNumber;
	}
}
