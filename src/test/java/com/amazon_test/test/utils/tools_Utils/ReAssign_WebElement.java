package com.amazon_test.test.utils.tools_Utils;

import com.amazon_test.test.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReAssign_WebElement {


    public static WebElement reAssign(String locator, WebElement element) {

        String elementValue = element.toString().substring(element.toString().lastIndexOf(" ") + 1, element.toString().length() - 1);

        if (locator.equalsIgnoreCase("css")) {
            element = Driver.getDriver().findElement(By.cssSelector(elementValue));
        } else {
            if (locator.equalsIgnoreCase("xpath")) {
                element = Driver.getDriver().findElement(By.xpath(elementValue));
            }
        }

        return element;
    }
}