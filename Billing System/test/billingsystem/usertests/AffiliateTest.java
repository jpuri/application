package billingsystem.usertests;

import com.billingsystem.user.Affiliate;

import junit.framework.Assert;
import org.junit.Test;

//Unit tests for class Affiliate.java
public class AffiliateTest {

    @Test
    public void affiliateConstructorTest(){
        Affiliate affiliate = new Affiliate("AffiliateId", "AffiliateName");
        Assert.assertEquals("AffiliateId", affiliate.getId());
        Assert.assertEquals("AffiliateName", affiliate.getName());
    }

    @Test
    public void affiliateSettersTest(){
        Affiliate affiliate = new Affiliate();
        affiliate.setId("AffiliateId");
        affiliate.setName("AffiliateName");
        Assert.assertEquals("AffiliateId", affiliate.getId());
        Assert.assertEquals("AffiliateName", affiliate.getName());
    }

    @Test
    public void affiliateDiscountTest(){
        Affiliate affiliate = new Affiliate();
        Assert.assertEquals(affiliate.getDiscount(), 10.0);
    }


}