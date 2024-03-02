package org.testingAcademy.Testng.Examples;

import org.testng.annotations.Test;

public class TestNG003 {
    @Test(groups = {"init"},priority = 1)
    public void gettoken(){
        System.out.println("Server started");
    }

    @Test(groups = {"init"},priority = 2)
    public void getBookingid(){
        System.out.println("initEnvironment");
    }

    @Test(dependsOnGroups = {"init.*"})
    public void testputrequest(){
        System.out.println("Now i will Start Server started");
    }
}
