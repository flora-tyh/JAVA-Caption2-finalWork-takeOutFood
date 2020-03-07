package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class HalfCutDiscount implements Discount {
    private List<String> orderedHalfCutItem = new ArrayList<>();
    private int halfCutPrice;
    private static final String ITEM_DELIMITER = "，";

    private ArrayList<DishOrdered> dishOrdered;

    public HalfCutDiscount(ArrayList<DishOrdered> dishOrdered) {
        this.dishOrdered = dishOrdered;
    }

    @Override
    public String getName() {
        return String.format("使用优惠:\n指定菜品半价(%s)", String.join(ITEM_DELIMITER, orderedHalfCutItem));
    }

    @Override
    public int discount() {
        for (DishOrdered dish : dishOrdered) {
            if (dish.isHalfDish()) {
                halfCutPrice += (int) (dish.getDish().getPrice() * dish.getAmount() * 0.5);
                orderedHalfCutItem.add(dish.getDish().getName());
            } else {
                halfCutPrice += (int) (dish.getDish().getPrice() * dish.getAmount());
            }
        }
        return halfCutPrice;
    }

    @Override
    public String discountInfo() {
        int fullPrice = new NoDiscount(dishOrdered).discount();

        StringBuilder halfDiscountInfo = new StringBuilder("-----------------------------------\n");
        halfDiscountInfo.append(String.format("%s，省%d元\n", getName(), fullPrice - halfCutPrice));
        return halfDiscountInfo.toString();
    }
}
