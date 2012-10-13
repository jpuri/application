package com.billingsystem.user;

//Abstract class User, it is super class for classes Customer,
//Employee, Affiliate and contain fields common to these classes.
public abstract class User {

    String id;
    String name;

    protected User() {
    }

    protected User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscount(){
        return 0.0;
    }
}
