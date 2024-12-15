package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Address;

public class AddressRepo {
	public static Address addAddress(Address address) {
		String query = "Insert into Address (UserId,DoorNumber,Street,City,AddressTypeId) values (?,?,?,?,?)";
		try (Connection conn = DataBaseHelper.connect();
			 PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			
			pstmt.setInt(1, address.UserId);
			pstmt.setInt(2, address.DoorNumber);
			pstmt.setString(3, address.Street);
			pstmt.setString(4, address.City);
			pstmt.setInt(5, address.AddressTypeId);
			
			int rowInserted = pstmt.executeUpdate();
			
			if (rowInserted > 0) {
				ResultSet generatedKeys = pstmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					address.Address_id = generatedKeys.getInt(1);
				}
				return address;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static List<Address> getAddressesByUserID(int user_id){
		String query = "Select * from Address where UserId = ?";
		try(Connection conn = DataBaseHelper.connect();
			 PreparedStatement pstmt = conn.prepareStatement(query)){
			
			pstmt.setInt(1, user_id);
			ResultSet rs = pstmt.executeQuery();
			
			List<Address> allAddress = new ArrayList<>();
			
			while (rs.next()) {
				Address address = new Address();
				address.Address_id = rs.getInt("Address_id");
				address.UserId = user_id;
				address.DoorNumber = rs.getInt("DoorNumber");
				address.Street = rs.getString("Street");
				address.City = rs.getString("City");
				
				allAddress.add(address);
			}
			return allAddress;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
