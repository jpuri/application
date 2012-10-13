package com.billingsystem.user;

public class Employee extends User {

    public Employee() {
    }

    public Employee(String id, String name) {
        super(id, name);
    }

    @Override
    public double getDiscount(){
        return 30.0;
    }
}
