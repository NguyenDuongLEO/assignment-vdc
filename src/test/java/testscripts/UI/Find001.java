package testscripts.UI;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Find001 extends BaseTest {
    @Test
    public void verifyFindPageDisplayCorrectly(){
        verifyInFindPage();
    }

    public void verifyInFindPage(){
        Assert.assertEquals(driver.getTitle(), openweathermapData.FIND_PAGE_TITLE);
        Assert.assertEquals(driver.getTitle(), openweathermapData.FIND_PAGE_TITLE);

    }
}
