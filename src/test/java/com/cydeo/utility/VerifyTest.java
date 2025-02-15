package com.cydeo.utility;

public class VerifyTest {

    public static void verify(String expected,String actual,String place){

        if (actual.equals(expected)){
            System.out.println(place + " verification PASSED!!!");
        }
        else{
            System.out.println(place+ " verification FAILED!!!");
        }

    }
}
