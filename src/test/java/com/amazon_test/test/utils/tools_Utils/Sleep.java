package com.amazon_test.test.utils.tools_Utils;

public class Sleep {

    public static void seconds(int sec){
        sec*=1000;
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {


        }
    }


}
