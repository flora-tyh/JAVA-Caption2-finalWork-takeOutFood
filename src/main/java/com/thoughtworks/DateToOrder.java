package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

//将输入变为DishOrdered对象
public class DateToOrder {
    public ArrayList<DishOrdered> dateToOrder(String selectedItems) {
        DataProvider dataProvider = new DataProvider();
        List<Dish> dishList = dataProvider.getDishes();
        ArrayList<DishOrdered> dishOrdered = new ArrayList<>();

        String[] selectedItemList = selectedItems.split(",");
        for (String i : selectedItemList) {
            for (Dish dish : dishList) {
                if (i.split("x")[0].trim().equals(dish.getId())) {
                    dishOrdered.add(new DishOrdered(new Dish(dish.getId(), dish.getName(), dish.getPrice()), Integer.parseInt(i.split("x")[1].trim())));
                }
            }
        }

        for(DishOrdered dish : dishOrdered) {
            isHalfCount(dish);
        }
        return dishOrdered;
    }

    public void isHalfCount(DishOrdered dishOrdered) {
        DataProvider dataProvider = new DataProvider();
        List<String> halfDishIds = dataProvider.getHalfDishIds();
        for (String halfDishid : halfDishIds) {
            if (halfDishid.equals(dishOrdered.getDish().getId())) {
                dishOrdered.setHalfDish(true);
            }
        }
    }
}
