package repository;

import models.User;

import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements IUserRepo{
// list should be aaded over here,
//	List<User> users;
//	public UserRepo() {
//		users = new ArrayList<>();
//	}
	
    // Method to get a user by ID
	
	
	
    public User getUserById(int userId) {
        User user = null;
        String query = "SELECT * FROM User WHERE UserId = ?";

        try (Connection conn = DataBaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
            	user = new User();
            	user.UserId = rs.getInt("UserId");
            	user.Name = rs.getString("Name");
                user.UserTypeId = rs.getInt("UserTypeId");
                user.PhoneNumber = rs.getLong("PhoneNumber");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    // Method to get all users
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM User";

        try (Connection conn = DataBaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
            	User user = new User();
                user.UserId = rs.getInt("UserId");
                user.Name = rs.getString("Name");
                user.UserTypeId = rs.getInt("UserTypeId");
                user.PhoneNumber = rs.getLong("PhoneNumber");
                
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
    
    // Method to insert new User
    public User AddUser(User user) {
    	String query = "Insert into User (Name, UserTypeId, PhoneNumber) values (?,?,?)";
    	try (Connection conn = DataBaseHelper.connect();
    		 PreparedStatement pstmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)){
    		
//    		pstmt.setInt(1,user.UserId);
    		
    		// relates the query not the database
    		pstmt.setString(1,user.Name);
    		pstmt.setInt(2,user.UserTypeId);
    		pstmt.setLong(3,user.PhoneNumber);
    	
    		int rowsAffected = pstmt.executeUpdate();
    		
    		if (rowsAffected > 0) {
    			ResultSet generatedKeys = pstmt.getGeneratedKeys();
    			if (generatedKeys.next()) {
    				user.UserId = generatedKeys.getInt(1);
    			}
    			return user;
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		return null;
    }
}