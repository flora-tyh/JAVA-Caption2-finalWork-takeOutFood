package com.thoughtworks;

public class DishOrdered {
    private Dish dish;
    private int amount;
    private boolean isHalfDish;

    public DishOrdered(Dish dish, int amount) {
        this.dish = dish;
        this.amount = amount;
    }

    public Dish getDish() {
        return dish;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isHalfDish() {
        return isHalfDish;
    }

    public void setHalfDish(boolean halfDish) {
        isHalfDish = halfDish;
    }
}
