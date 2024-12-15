package ui;

import java.util.Map;

import models.OrderedItems;
import repository.OrderedItemsRepo;

public class OrderedItemsList {
	public static void insertOrders(int order_id) {
		Map <Integer,Integer> order = OrdersForm.order;
		
		if (order == null || order.isEmpty()) {
			System.out.println("No orders to insert.");
			return;
		}
		
		boolean success = OrderedItemsRepo.saveFoodQuantity(order_id, order);
		
		
	}
}
