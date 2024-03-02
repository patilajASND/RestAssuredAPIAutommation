package org.testingAcademy.Testng.Listenersdemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002 {
    @Test(groups = "sanity")
    public void test1(){
        System.out.println("test1");
        Assert.assertTrue(false);
    }


    @Test(groups = "sanity")
    public void test2(){
        System.out.println("test1");
        Assert.assertTrue(true);
    }

}
