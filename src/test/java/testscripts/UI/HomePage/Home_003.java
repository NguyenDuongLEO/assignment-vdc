package testscripts.UI.HomePage;

import data.OpenweathermapData;
import org.testng.annotations.Test;
import testscripts.BaseTest;

public class Home_003 extends BaseTest {
    @Test
    public void verifyInputHoChiMinhCityAndEnterOnKeyboard() {
        homePage.navSearchForm.click();
        homePage.navSearchForm.sendKeys("ho chi minh");
        homePage.navSearchForm.submit();
        homePage.verifyNavigatedToFindPage(OpenweathermapData.FIND_PAGE_TITLE);
    }
}
