package com.thoughtworks;

import java.util.ArrayList;

public class FinalInfo {
    private ArrayList<DishOrdered> dishOrdered = new ArrayList<>();
    private int finalPrice;
    private Discount fullReduceDiscount;;
    private Discount noDiscount;
    private Discount halfCutDiscount;

    public FinalInfo(ArrayList<DishOrdered> dishOrdered) {
        this.dishOrdered = dishOrdered;
    }

    public void getDiscountInfo () {
        fullReduceDiscount = new FullReduceDiscount(dishOrdered);;
        noDiscount = new NoDiscount(dishOrdered);
        halfCutDiscount = new HalfCutDiscount(dishOrdered);
    }

    public String discountInfo() {
        getDiscountInfo();
        int fullPrice = noDiscount.discount();
        int halfCutPrice = halfCutDiscount.discount();
        int fullReducePrice = fullReduceDiscount.discount();

        if (fullReducePrice == fullPrice && halfCutPrice == fullPrice) {
            finalPrice = fullPrice;
            return noDiscount.discountInfo();
        } else if (fullReducePrice > halfCutPrice) {
            finalPrice = halfCutPrice;
            return halfCutDiscount.discountInfo();
        } else {
            finalPrice = fullReducePrice;
            return fullReduceDiscount.discountInfo();
        }
    }

    public String orderInfo(ArrayList<DishOrdered> dishOrdered) {
        StringBuilder orderInfo = new StringBuilder("============= 订餐明细 =============\n");
        for (DishOrdered dish : dishOrdered) {
            int price = (int) (dish.getAmount() * dish.getDish().getPrice());
            String dishInfo = String.format("%s x %d = %d元\n", dish.getDish().getName(),
                                            dish.getAmount(), price);
            orderInfo.append(dishInfo);
        }
        return orderInfo.toString();
    }

    public String finalPriceInfo() {
        StringBuilder finalPriceInfo = new StringBuilder("-----------------------------------\n");
        finalPriceInfo.append(String.format("总计：%d元\n", finalPrice))
                      .append("===================================");
        return finalPriceInfo.toString();
    }

    public String getFinalInfo() {
        return String.format("%s%s%s", orderInfo(dishOrdered), discountInfo(), finalPriceInfo());
    }
}
