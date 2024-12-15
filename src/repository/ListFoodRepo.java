package repository;
import java.util.*;

import models.Food;
import repository.IFoodRepo;
public class ListFoodRepo implements IFoodRepo {

	private List<Food> foodList;
	
	public ListFoodRepo() {
		this.foodList = new ArrayList<>();
		
		// wihout using constructor logic
		Food food = new Food();
		food.FoodId = 12;
		food.Name = "Iddiyapam";
		food.Quantity = 120;
		food.FoodType = "Non veg";
		foodList.add(food);
	}
	
	public Food addNewFood(Food food) {
		foodList.add(food);
        return food;
	}

	public List<Food> showAllFoods() {
		return foodList;
	}
	
}
