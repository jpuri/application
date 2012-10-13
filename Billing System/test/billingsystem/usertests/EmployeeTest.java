package billingsystem.usertests;

import com.billingsystem.user.Employee;

import junit.framework.Assert;
import org.junit.Test;

//Unit tests for class Employee.java
public class EmployeeTest {

    @Test
    public void employeeConstructorTest(){
        Employee employee = new Employee("EmpId", "EmpName");
        Assert.assertEquals("EmpId", employee.getId());
        Assert.assertEquals("EmpName", employee.getName());
    }

    @Test
    public void employeeSettersTest(){
        Employee employee = new Employee();
        employee.setId("EmpId");
        employee.setName("EmpName");
        Assert.assertEquals("EmpId", employee.getId());
        Assert.assertEquals("EmpName", employee.getName());
    }

    @Test
    public void employeeDiscountTest(){
        Employee employee = new Employee();
        Assert.assertEquals(employee.getDiscount(), 30.0);
    }

}