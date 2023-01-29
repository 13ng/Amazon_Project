package com.amazon_test.test.utils.tools_Utils;

import org.openqa.selenium.WebElement;

public class Custom_Output {

    public static void output(WebElement name, WebElement price, WebElement qa){

        System.out.println("________________________________________");
        String line1 = new String( name.getText().substring(6,15)+" Size:"+name.getText().substring(16,24).replace("(","").replace(")",""));
        String line2 = new String("Color:"+name.getText().substring(26)+" Price:"+price.getText().substring(0,6)+","+price.getText().substring(7));
        String line3 = new String( "Stock:"+qa.getText());



        System.out.println(line1+"\n"+line2+"\n"+line3);

    }

}




