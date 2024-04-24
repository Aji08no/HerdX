package Test_Pages;

import Common.Attributes;
import Common.JavaUtility;
import Pages.Home_page;
import Pages.Login_Page;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Engine {

    public static AndroidDriver driver;

    public  Login_Page log;
    public JavaUtility javaUtility;
    public Home_page home;
//login page scenario
//    @BeforeMethod
    @BeforeTest
    public void openApp() throws MalformedURLException, InterruptedException {

        UiAutomator2Options options=new UiAutomator2Options();
//        options.setDeviceName("Hardik...");
//        options.setPlatformName("Android");
//        options.setApp("C:\\APk_files\\HerdxBuild(2).apk");

        options.setPlatformName("Android");
        options.setPlatformVersion("13");
        options.setDeviceName("Galaxy Note20");
        options.setUdid("RZ8N81X10EH");
        options.setAppActivity("com.herdx.herdviewnewapp.MainActivity");
        options.setAppPackage("com.herdx.herdviewnewapp");
        options.setAutomationName("UiAutomator2");

        URL url=new URL("http://0.0.0.0:4723/wd/hub");

        driver=new AndroidDriver(url, options);
        log=new Login_Page(driver);
        javaUtility=new JavaUtility(driver);
        home=new Home_page(driver);
        //login
        log.clickAllows();
        Thread.sleep(Attributes.TimeOut.sleep8);
        log.enterMail("gangappan@pro17analytics.com");
        log.enterPassword("Otis@2023");
        log.loginButton();
        Thread.sleep(5000);


//        WebElement out;
//        if (page) {
//            out = log.verifyHome();
//            boolean input = out.isDisplayed();
//            Assert.assertTrue(input);
//            System.out.println("Login succeeded for valid credentials");
//
//        } else {
//            out = log.verifyLogin();
//            boolean input = out.isDisplayed();
//            Assert.assertTrue(input);
//            System.out.println("Login succeeded for invalid credentials");
//            log.closeApp();
//        }



    }
//    @BeforeMethod
    public void homePage() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement location = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
//        WebElement location = driver.findElement(By.xpath("//*[@content-desc='Abi test']"));
        String locate = location.getText();
        if(locate.contains("Abi test")){
            System.out.println(locate);
        }
        else {
            driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
            Thread.sleep(3000);
            driver.findElement(AppiumBy.accessibilityId("A test")).click();
//        driver.findElement(By.xpath("(//android.view.View[@index='0'])[9]")).click();
            //Total Animals
            Thread.sleep(3000);
//            driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        }
    }

    @AfterTest(enabled = false)
    public void closeApp(){
        driver.quit();
    }

}
