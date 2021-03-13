package testscripts.UI.FindPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTest;

public class Find_001 extends BaseTest {
    @Test
    public void verifyFindPageDisplayCorrectly(){
        verifyInFindPage();
    }

    public void verifyInFindPage(){
        Assert.assertEquals(driver.getTitle(), openweathermapData.FIND_PAGE_TITLE);
        Assert.assertEquals(driver.getTitle(), openweathermapData.FIND_PAGE_TITLE);

    }
}
