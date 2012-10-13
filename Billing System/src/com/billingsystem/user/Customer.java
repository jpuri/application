package com.billingsystem.user;

import java.util.Calendar;
import java.util.Date;

//Class representing customer,
// it has field startDate in addition to the fields of base class user.
public class Customer extends User {

    private Date startDate;

    public Customer() {
    }

    public Customer(Date startDate) {
        this.startDate = startDate;
    }

    public Customer(String id, String name, Date startDate) {
        super(id, name);
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    //A discount of 5% will be given to customers older than 2 years
    public double getDiscount(){

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -2);
        calendar.add(Calendar.DATE, 1);
        Date date = calendar.getTime();
        if(startDate.before(date))
            return 5.0;
        else
            return 0.0;
    }

}
