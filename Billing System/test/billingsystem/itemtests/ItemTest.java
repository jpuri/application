package billingsystem.itemtests;

import com.billingsystem.item.Item;
import com.billingsystem.item.ItemType;

import junit.framework.Assert;
import org.junit.Test;

//Class of unit tests for Item.java
public class ItemTest {

    @Test
    public void itemConstructorTest(){
        Item item = new Item("ItemId", "ItemName", 100.0, ItemType.GROCERY);
        Assert.assertEquals("ItemName", item.getName());
        Assert.assertEquals("ItemId", item.getId());
        Assert.assertEquals(100.0, item.getCost());
        Assert.assertEquals(ItemType.GROCERY, item.getType());
    }

    @Test
    public void itemSetterTest(){
        Item item = new Item();
        item.setId("ItemId");
        item.setName("ItemName");
        item.setCost(100.0);
        item.setType(ItemType.GROCERY);
        Assert.assertEquals("ItemName", item.getName());
        Assert.assertEquals("ItemId", item.getId());
        Assert.assertEquals(100.0, item.getCost());
        Assert.assertEquals(ItemType.GROCERY, item.getType());
    }

}
