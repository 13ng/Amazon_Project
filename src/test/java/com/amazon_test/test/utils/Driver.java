package com.amazon_test.test.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private static Properties property = new Properties();

    static {

        FileInputStream file = null;
        try {
            file = new FileInputStream("configuration.properties");
            property.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




}

    private Driver(){};

    public static String getProperty(String key){return property.getProperty(key);}

    public static WebDriver getDriver() {

        if(driver==null) {

            String browserType = getProperty("browser");

            if(browserType.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else if(browserType.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            }else {
                System.out.println("Please check if browser name in \"configuration.properties\" is correct, current name: "+browserType);
                System.exit(0);
            }







        return driver;
    }









        return driver;
    }


public static void off(){
        if(driver != null){
            driver.quit();
            driver=null;
        }

}


}
