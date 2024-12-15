package ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

import models.Food;
import models.Orders;
import repository.FoodRepo;
import repository.IFoodRepo;
import repository.OrdersRepo;

public class OrdersForm {
	static Map<Integer,Integer> order;

	public static void yourOrders(Scanner scanner,IFoodRepo foodRepo, int current_user_id) {
		// show foods
		List<Food> foods = foodRepo.showAllFoods();
		System.out.println("Today's Menu");
		for (Food f : foods) {
			System.out.println("Food ID : "+f.FoodId+"\t"+"Name : "+f.Name);
		}
		
		// get orders
		System.out.println("Press 0 to complete your order");
		System.out.println("Enter Food Id and Quantity :");
		
		order = new HashMap<>();
		
		while (true) {
			
			int foodId = scanner.nextInt();
			int quantity = 0;
			if (foodId == 0) {
				break;
			}
			else {
				quantity = scanner.nextInt();
				order.put(foodId,quantity);
			}
		}
		
		
		// show orders
		System.out.println("Your Orders : ");
		for (Map.Entry<Integer,Integer> entry : order.entrySet()) {
			int foodId2 = entry.getKey();
			int quantity2 = entry.getValue();
			
			Food orderedFood = foods.stream()
				.filter(f -> f.FoodId == foodId2)
				.findFirst()
				.orElse(null);
			
			if (orderedFood != null) {
				System.out.println(orderedFood.Name+"\t"+quantity2);
			}
			else {
				System.out.println("Food Id : "+foodId2+" not found in today's menu");
			}
		}
		
	}
	
	public static Orders newOrder(Scanner scanner,IFoodRepo foodRepo, int current_user_id, int selected_address) {		
		// DB CALLS
		Orders newOrder = new Orders();
		newOrder.UserId = current_user_id;
		newOrder.Address_id = selected_address;
		
		return OrdersRepo.saveOrder(newOrder);
		
	}
}
