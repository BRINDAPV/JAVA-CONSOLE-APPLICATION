package repository;

import java.sql.*;

import models.Orders;

public class OrdersRepo {
	public static Orders saveOrder(Orders newOrder) {
		String query = "Insert into Orders (UserId,Address_id) values (?,?)";
		try(Connection conn = DataBaseHelper.connect();
			 PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			
			pstmt.setInt(1, newOrder.UserId );
			pstmt.setInt(2, newOrder.Address_id);
			
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet generatedKeys = pstmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					newOrder.OrderId = generatedKeys.getInt(1);
				}
				return newOrder;
			}
			else {
                System.out.println("Failed to insert the order.");
                return null;
            }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
