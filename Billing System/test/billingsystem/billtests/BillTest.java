package billingsystem.billtests;

import com.billingsystem.bill.Bill;
import com.billingsystem.item.Item;
import com.billingsystem.item.ItemType;
import com.billingsystem.user.Affiliate;
import com.billingsystem.user.Customer;
import com.billingsystem.user.Employee;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//The class contains unit tests for class bill.
//The tests are mainly to check the logic of getPayableAmount() method.
public class BillTest {

    Customer newCustomer, oldCustomer;
    Employee employee;
    Affiliate affiliate;
    List<Item> items;

    @Before
    //Initializing method create instances of customers, employee,
    //affiliate and initialize list of items
    public void init(){

        newCustomer = new Customer("NewCustomerId", "NewCustomerName", new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -2);
        oldCustomer = new Customer("OldCustomerId", "OldCustomerName", calendar.getTime());
        employee = new Employee("EmpId", "EmpName");
        affiliate = new Affiliate("AffiliateId", "AffiliateName");

        items = new ArrayList<Item>();
        items.add(new Item("GroceryItemId1", "GroceryItemName1", 10.0, ItemType.GROCERY));
        items.add(new Item("GroceryItemId2", "GroceryItemName2", 20.0, ItemType.GROCERY));
        items.add(new Item("GroceryItemId3", "GroceryItemName3", 30.0, ItemType.GROCERY));
        items.add(new Item("GroceryItemId4", "GroceryItemName4", 40.0, ItemType.GROCERY));
        items.add(new Item("NonGroceryItemId1", "NonGroceryItemName1", 10.0, ItemType.CLOTHING));
        items.add(new Item("NonGroceryItemId2", "NonGroceryItemName2", 20.0, ItemType.CLOTHING));
        items.add(new Item("NonGroceryItemId3", "NonGroceryItemName3", 30.0, ItemType.ELECTRONIC));
        items.add(new Item("NonGroceryItemId4", "NonGroceryItemName4", 40.0, ItemType.ELECTRONIC));
    }

    @Test
    public void billConstructorTest(){
        Bill bill = new Bill(employee, items);
        Assert.assertEquals(bill.getUser(), employee);
        Assert.assertEquals(bill.getItems(), items);
    }

    @Test
    public void billSettersTest(){
        Bill bill = new Bill();
        bill.setUser(employee);
        bill.setItems(items);
        Assert.assertEquals(bill.getUser(), employee);
        Assert.assertEquals(bill.getItems(), items);
    }

    @Test
    public void newCustomerPayableAmountTest(){
        Bill bill = new Bill(newCustomer, items);
        Assert.assertEquals(bill.getPayableAmount(), (100 + 100) * 0.95);
    }

    @Test
    public void oldCustomerPayableAmountTest(){
        Bill bill = new Bill(oldCustomer, items);
        Assert.assertEquals(bill.getPayableAmount(), (100.0 + 95) * 0.95);
    }

    @Test
    public void affiliatePayableAmountTest(){
        Bill bill = new Bill(affiliate, items);
        Assert.assertEquals(bill.getPayableAmount(), (100.0 + 90.0) * 0.95);
    }

    @Test
    public void employeePayableAmountTest(){
        Bill bill = new Bill(employee, items);
        Assert.assertEquals(bill.getPayableAmount(), (100.0 + 70.0) * 0.95);
    }

}
