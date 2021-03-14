//package testscripts.UI;
//
//import data.OpenweathermapData;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Test;
//
//public class Home_002 extends BaseTest {
//    @Test
//    public void verifyInputHoChiMinhCityAndClickOnSearchIcon() {
//        homePage.navSearchForm.sendKeys("ho chi minh");
//        Actions actions = new Actions(driver);
//        actions.moveToElement(homePage.navSearchIcon).build().perform();
//        homePage.verifyNavigatedToFindPage(OpenweathermapData.FIND_PAGE_TITLE);
//    }
//}