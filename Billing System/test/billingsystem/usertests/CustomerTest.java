package billingsystem.usertests;

import com.billingsystem.user.Customer;
import org.junit.Test;
import junit.framework.Assert;

import java.util.Calendar;
import java.util.Date;

//Unit tests for class Customer.java
public class CustomerTest {

    @Test
    public void customerConstructorTest(){
        Date date =  new Date();
        Customer customer = new Customer("CustId", "CustName", date);
        Assert.assertEquals("CustName", customer.getName());
        Assert.assertEquals("CustId", customer.getId());
        Assert.assertEquals(date, customer.getStartDate());

        customer = new Customer(date);
        Assert.assertEquals(date, customer.getStartDate());
    }

    @Test
    public void customerSettersTest(){
        Date date =  new Date();
        Customer customer = new Customer();
        customer.setId("CustId");
        customer.setName("CustName");
        customer.setStartDate(date);
        Assert.assertEquals("CustName", customer.getName());
        Assert.assertEquals("CustId", customer.getId());
        Assert.assertEquals(date, customer.getStartDate());
    }

    @Test
    public void customerDiscountTest(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -2);
        Customer customer = new Customer(calendar.getTime());
        Assert.assertEquals(customer.getDiscount(), 5.0);

        calendar.add(Calendar.YEAR, 1);
        customer.setStartDate(calendar.getTime());
        Assert.assertEquals(customer.getDiscount(), 0.0);
    }

}