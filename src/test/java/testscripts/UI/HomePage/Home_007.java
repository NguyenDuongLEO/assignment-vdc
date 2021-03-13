package testscripts.UI.HomePage;

import data.OpenweathermapData;
import org.testng.annotations.Test;
import testscripts.BaseTest;

public class Home_007 extends BaseTest {
    @Test
    public void verifyInput100CharactersAndEnterOnKeyboard() {
        homePage.navSearchForm.click();
        homePage.navSearchForm.sendKeys(OpenweathermapData.INPUT_100_CHARACTERS);
        homePage.navSearchForm.submit();
        findPage.verifyNavigatedToFindPage(OpenweathermapData.FIND_PAGE_TITLE);
    }
}
