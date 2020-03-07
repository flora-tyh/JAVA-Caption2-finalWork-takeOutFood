package com.thoughtworks;

import java.util.ArrayList;

public class NoDiscount implements Discount {
    private ArrayList<DishOrdered> dishOrdered;

    public NoDiscount(ArrayList<DishOrdered> dishOrdered) {
        this.dishOrdered = dishOrdered;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int discount() {
        int fullPrice = 0;
        for (DishOrdered dish : dishOrdered) {
            fullPrice += (int) (dish.getDish().getPrice() * dish.getAmount());
        }
        return fullPrice;
    }

    @Override
    public String discountInfo() {
        return getName();
    };
}
