package com.billingsystem.bill;

import com.billingsystem.item.Item;
import com.billingsystem.item.ItemType;
import com.billingsystem.user.User;
import java.util.ArrayList;
import java.util.List;

public class Bill {

    private User user;
    private List<Item> items;

    public Bill(User user, List<Item> items) {
        this.user = user;
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getPayableAmount(){
        double payableAmount = 0.0;
        payableAmount = getItemsCost(findNonGroceryItems(items));
        payableAmount += getItemsCost(findGroceryItems(items)) * (100 - user.getDiscount()) / 100;
        payableAmount = payableAmount * 0.95;
        return payableAmount;
    }

    private List<Item> findGroceryItems(List<Item> items){
        List<Item> groceryItems = new ArrayList<Item>();
        for(Item item : items){
            if(item.getType().equals(ItemType.GROCERY))
                groceryItems.add(item);
        }
        return groceryItems;
    }

    private List<Item> findNonGroceryItems(List<Item> items){
        List<Item> nonGroceryItems = new ArrayList<Item>();
        for(Item item : items){
            if(!item.getType().equals(ItemType.GROCERY))
                nonGroceryItems.add(item);
        }
        return nonGroceryItems;
    }

    private double getItemsCost(List<Item> items){
        double addedCost = 0;
        for(Item item : items){
            addedCost += item.getCost();
        }
        return addedCost;
    }
}
