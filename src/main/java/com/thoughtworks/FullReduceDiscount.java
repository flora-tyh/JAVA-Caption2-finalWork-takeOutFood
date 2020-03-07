package com.thoughtworks;

import java.util.ArrayList;

public class FullReduceDiscount implements Discount {
    private static final int FULL_COUNT = 30;
    private static final int REDUCE_COUNT = 6;

    private ArrayList<DishOrdered> dishOrdered;

    public FullReduceDiscount(ArrayList<DishOrdered> dishOrdered) {
        this.dishOrdered = dishOrdered;
    }

    @Override
    public String getName() {
        return String.format("使用优惠:\n满%d减%d", FULL_COUNT, REDUCE_COUNT);
    }

    @Override
    public int discount() {
        int fullPrice = new NoDiscount(dishOrdered).discount();
        if (fullPrice > FULL_COUNT) {
            return fullPrice - REDUCE_COUNT;
        } else {
            return fullPrice;
        }
    }

    @Override
    public String discountInfo() {
        StringBuilder fullReduceInfo = new StringBuilder("-----------------------------------\n");
        fullReduceInfo.append(getName()).append("元，省")
                .append(REDUCE_COUNT).append("元\n");
        return fullReduceInfo.toString();
    }
}
