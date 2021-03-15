package util;

import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class AssertUtil {
    public static void AssertEqualsCustomize(String actualResult, String expectedResult){
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println("=================================");
        System.out.println("Actual Result: " + "\n   " + actualResult);
        System.out.println("Expected Result: " + "\n   " + expectedResult);
        System.out.println("=================================");
    }
}
