package ui;

import java.util.Scanner;

import models.Food;

public class MenuForm {
	public static Food collectFoodDetails(Scanner scanner) {
			// adding new food
			scanner.nextLine();
			System.out.println("Enter Food Name : ");
			String food_Name = scanner.nextLine();
			
			System.out.println("Quantity : ");
			int total_Quantity = scanner.nextInt();
			
			scanner.nextLine();
			System.out.println("Food Type : ");
			String food_Type = scanner.nextLine();
			
			
			
			Food newFood = new Food();
			newFood.Name = food_Name;
			newFood.Quantity = total_Quantity;
			newFood.FoodType = food_Type;
			
			return newFood;
	}
}
