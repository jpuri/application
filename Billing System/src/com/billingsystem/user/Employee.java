package com.billingsystem.user;

//Class representing employee,
//It can have additional fields like date_of_joining, dob, salary, etc
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
