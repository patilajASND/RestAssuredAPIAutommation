package org.testingAcademy.Testng.Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test006 {
    @Test(groups = {"sanity","QA"})
    public void sanityRun(){
        System.out.println("sanity");
    }
@Test(groups = {"reg","sanity","prepod"})
    public void regRun(){
        System.out.println("reg");
    }
    @Test(groups = {"reg","sanity","Smoke","DEV"})
    public void SmokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }
}
