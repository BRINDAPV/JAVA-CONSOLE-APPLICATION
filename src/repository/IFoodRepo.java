package repository;

import java.util.List;

import models.Food;

public interface IFoodRepo {
	Food addNewFood(Food food);
	List<Food> showAllFoods();
}
