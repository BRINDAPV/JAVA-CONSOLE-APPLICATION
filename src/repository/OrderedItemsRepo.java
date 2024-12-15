package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import models.Orders;

public class OrderedItemsRepo {
	public static boolean saveFoodQuantity(int order_id, Map<Integer,Integer> order) {
		
		if (order == null || order.isEmpty()) {
			System.out.println("No Orders to Save.");
			return false;
		}
		
		String query = "Insert into Orderitem (OrderId, FoodId, Quantity) values (?,?,?)";
		try (Connection conn = DataBaseHelper.connect();
			 PreparedStatement pstmt = conn.prepareStatement(query)){
			for (Map.Entry<Integer,Integer> entry : order.entrySet()) {
				pstmt.setInt(1, order_id);
				pstmt.setInt(2, entry.getKey());
				pstmt.setInt(3, entry.getValue());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			return true;
		}
		catch(Exception e){
			System.out.println("Failed to insert in database: "+e.getMessage());
			return false;
		}
	}
}
