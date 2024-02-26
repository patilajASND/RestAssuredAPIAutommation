package org.testingAcademy.Testng;

import org.testng.annotations.*;

public class Test002 {


    @BeforeSuite
    void demo4(){
        System.out.println("Beforesuite");
    }

    @BeforeTest
    void demo5(){
        System.out.println("BeforeTest");
    }

    @BeforeClass
    void demo6(){
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    void demo1(){
        System.out.println("BeforeTest");
    }

    @Test
    void demo2(){
        System.out.println("Test1");
    }

    @Test
    void demo22(){
        System.out.println("Test2");
    }
    @AfterMethod
    void demo3(){
        System.out.println("AfterTest");
    }
}
