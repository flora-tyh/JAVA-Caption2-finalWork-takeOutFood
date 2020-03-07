package com.thoughtworks;

import java.util.ArrayList;

public class Restaurant {
  public String bestCharge(String selectedItems) {
    ArrayList<DishOrdered> dishOrdered = new DateToOrder().dateToOrder(selectedItems);
    FinalInfo finalInfo = new FinalInfo(dishOrdered);
    return finalInfo.getFinalInfo();
  }
}