package com.billingsystem.user;

//Class that represents affiliates of the store
public class Affiliate extends User {

    public Affiliate() {
    }

    public Affiliate(String id, String name) {
        super(id, name);
    }

    @Override
    public double getDiscount(){
        return 10.0;
    }
}