package org.testingAcademy.Testng.DDT;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngDDT {
    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                new Object[]{"admin", "admin"},
                new Object[]{"admin", "admin"},
                new Object[]{"admin", "admin"}
        };

    }


    @Test(dataProvider = "getData")
    public void loginTest(String username, String password) {
        System.out.println(username);
        System.out.println(password);
    }

}