package testscripts.UI.HomePage;

import data.OpenweathermapData;
import org.testng.annotations.Test;
import testscripts.BaseTest;

public class Home_006 extends BaseTest {
    @Test
    public void verifyInputNothingAndEnterOnKeyboard() {
        homePage.navSearchForm.click();
        homePage.navSearchForm.submit();
        verifyHomePageWithSearchBoxInTopBar();
    }
}
