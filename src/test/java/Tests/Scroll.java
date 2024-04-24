package Tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Scroll extends Herdx{


    @Test
    public void inventory() throws InterruptedException {

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
        //menu bar
        Thread.sleep(8000);
        driver.findElement(By.xpath("(//android.widget.ImageView[@index='0'])[1]")).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Inventory']"))).click();
        Thread.sleep(2000);

        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(1001, 897))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(1024, 419))
                .release()
                .perform();


//        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(30));
//        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
//
//        Wait<WebDriver> fluent=new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofSeconds(2))
//                .ignoring(NoSuchElementException.class);
//
//        fluent.until(new Function<WebDriver, WebElement>() {
//            @Override
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(By.xpath(""));
//            }
//        });



        //Automatic start the appiumServer
//        AppiumDriverLocalService server = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\E-7\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//                .withIPAddress("0.0.0.0").usingPort(4723).build();
//
//        server.start();

    }
}
