package repository;

import java.util.*;

import models.Food;
import java.sql.*;

public class FoodRepo {
	
	// Adding new Food
	public Food addNewFood(Food food) {
		String query = "insert into Food (FoodId,Name,Quantity,FoodType) values (?,?,?,?)";
		
		try (Connection conn = DataBaseHelper.connect();
			 PreparedStatement pstmt = conn.prepareStatement(query)){
			
			pstmt.setInt(1, food.FoodId);
			pstmt.setString(2, food.Name);
			pstmt.setInt(3, food.Quantity);
			pstmt.setString(4, food.FoodType);
			
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				return food;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// Method to display all foods
	public List<Food> showAllFoods() {
		List<Food> foods = new ArrayList<>();
		String query = "Select * from Food";
		
		try (Connection conn = DataBaseHelper.connect();
			 PreparedStatement pstmt = conn.prepareStatement(query);
			 ResultSet rs = pstmt.executeQuery()){
			
			while (rs.next()) {
				Food food = new Food();
				food.FoodId = rs.getInt("FoodId");
				food.Name = rs.getString("Name");
				food.Quantity = rs.getInt("Quantity");
				food.FoodType = rs.getString("FoodType");
				
				foods.add(food);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return foods;
	}
}
