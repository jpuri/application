package com.billingsystem.bill;

import com.billingsystem.item.Item;
import com.billingsystem.item.ItemType;
import com.billingsystem.user.User;

import java.util.ArrayList;
import java.util.List;


// Class for bill it contains a user reference and a list of items,
// it provides method to calculate payable amount for bill
public class Bill {

    private User user;
    private List<Item> items;

    public Bill() {
    }

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

    /**
     * Method to calculate payable amount for bill.
     * Cost of grocery items is calculated.
     * Cost for non-grocery items is calculated applying percentage discount as applicable to the user.
     * A discount of $5 per $100 is then applied on the bill amount.
     */
    public double getPayableAmount(){
        double payableAmount = 0.0;
        payableAmount = getItemsCost(findGroceryItems(items));
        payableAmount += getItemsCost(findNonGroceryItems(items)) * (100 - user.getDiscount()) / 100;
        payableAmount = payableAmount * 0.95;
        return payableAmount;
    }

    //Method to find Grocery Items in the bill
    private List<Item> findGroceryItems(List<Item> items){
        List<Item> groceryItems = new ArrayList<Item>();
        for(Item item : items){
            if(item.getType().equals(ItemType.GROCERY))
                groceryItems.add(item);
        }
        return groceryItems;
    }

    //Method to find non grocery items in  the bill
    private List<Item> findNonGroceryItems(List<Item> items){
        List<Item> nonGroceryItems = new ArrayList<Item>();
        for(Item item : items){
            if(!item.getType().equals(ItemType.GROCERY))
                nonGroceryItems.add(item);
        }
        return nonGroceryItems;
    }

    //Method to find added cost of items in a list
    private double getItemsCost(List<Item> items){
        double addedCost = 0.0;
        for(Item item : items){
            addedCost += item.getCost();
        }
        return addedCost;
    }
}
