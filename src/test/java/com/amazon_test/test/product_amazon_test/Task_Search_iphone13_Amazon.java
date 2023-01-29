package com.amazon_test.test.product_amazon_test;
import com.amazon_test.test.utils.Driver;
import com.amazon_test.test.utils.tools_Utils.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import static com.amazon_test.test.utils.tools_Utils.Custom_Output.output;
import static com.amazon_test.test.utils.tools_Utils.ReAssign_WebElement.reAssign;


public class Task_Search_iphone13_Amazon {
    @BeforeTest
    public void Search_Iphone13() {


        //1. Go to 'https://www.amazon.com.tr/'
        Driver.getDriver().get(Driver.getProperty("url"));
        //url =  "https://www.amazon.com.tr/"


        //2. Search iPhone13 512
        WebElement searchBar = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchBar.sendKeys(Driver.getProperty("searchValue")+Keys.ENTER);

        WebElement PopUp_Tercihlerinizi_Seçin = Driver.getDriver().findElement(By.id("sp-cc-accept"));
        PopUp_Tercihlerinizi_Seçin.click();

        //3. Check that the results are listed
        WebElement h1_search_result_bar = Driver.getDriver().findElement(By.cssSelector("div[class='a-section a-spacing-small a-spacing-top-small'] "));
        String searchBarResults = h1_search_result_bar.getText();


        //4. Click iPhone13 at the top of the list
        List<WebElement> firstItemOfTheList = new ArrayList<>(Driver.getDriver().findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")));
        //Linked list to be sure that item on top of the list, will be first.
        for (WebElement eachItem : firstItemOfTheList) {
            if (eachItem.getText().contains("13")) {
                eachItem.click();
                break;
            }
        }
    }


    @Test
    public void Size_OutPut() throws InterruptedException {
        //5. Log the following values for each size
        //.Size information .Price .Color .Stock status

        List<WebElement> sizes = Driver.getDriver().findElements(By.xpath("(//ul[@data-csa-c-id])[1]//button"));
        try {
            Assert.assertTrue(sizes.size() == 3);
        } catch (RuntimeException e) {
            throw new RuntimeException("size is > 3");
        }


        //main elements for output
        WebElement productTitle = Driver.getDriver().findElement(By.xpath("//div[@id='titleSection']/h1[@id='title']"));
       try {
           Assert.assertTrue(productTitle.isDisplayed() && productTitle.getText().contains("iPhone"));

       }catch (RuntimeException e){
           System.out.println(" Product Title: is not Displayed or Product is not Iphone");
       }

        WebElement itemPrice = Driver.getDriver().findElement(By.xpath("//div[@id='corePrice_feature_div']"));
        try {
            Assert.assertTrue(itemPrice.isDisplayed());

        }catch (RuntimeException e){
            System.out.println("Item Price: is not displayed!");
        }

        WebElement stokta = Driver.getDriver().findElement(By.cssSelector("div>#availability"));
        try {
            Assert.assertTrue(stokta.isDisplayed());
        }catch (RuntimeException e){
            System.out.println("Quantity information is displayed");
        }



        //This loop is clicking product, each - "size option".
        for (WebElement eachSize : sizes) {
            eachSize.click();

         //   Sleep.seconds(2); <-----Because of my internet connection i need sleep 2 sec. ------->

//Reassign WebElement with custom method "reAssign",to prevent StaleElementExeption;
            productTitle = reAssign("xpath", productTitle);
            itemPrice = reAssign("xpath", itemPrice);
            stokta = reAssign("css", stokta);
//Use custom method, to create a requirement output. Task Requirement: "We expect an output similar to this screenshot"
            output(productTitle, itemPrice, stokta);
        }


        Driver.off();
    }//end of test

}