package Tests;

import Common.Attributes;
import Test_Pages.Engine;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login extends Engine {

    @Test(dataProvider = "app")
    public void loginProcess(String mail,String pass,boolean page) throws InterruptedException {
        log.clickAllows();
        javaUtility.explicitWaitXpath(Attributes.Locator.loginText);
        log.enterMail(mail);
        log.enterPassword(pass);
        log.loginButton();
        Thread.sleep(5000);


        WebElement out;
        if (page) {
            out = log.verifyHome();
            boolean input = out.isDisplayed();
            Assert.assertTrue(input);
            System.out.println("Login succeeded for valid credentials");

        } else {
            out = log.verifyLogin();
            boolean input = out.isDisplayed();
            Assert.assertTrue(input);
            System.out.println("Login succeeded for invalid credentials");
            log.closeApp();
        }


    }
    @DataProvider(name = "app")
    public Object[][] getData(){
        return new Object[][]{
                //valid mail & invalid password
                {"gangappan@pro17analytics.com","Hardik@2022",false},
                {"ganappan@pro17analytics.com","Otis@2023",false},
                {"angappan@pro17analytics.com","Ruby@2023",false},
                {"gangappan@pro17analytics.com","Otis@2023",true}
        };
    }
}
