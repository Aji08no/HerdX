package Tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class CreateMultipleTagsID extends Herdx{

    WebDriverWait wait;
    @BeforeClass
    public void homePage() throws InterruptedException {

        Thread.sleep(5000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement location = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
//        WebElement location = driver.findElement(By.xpath("//*[@content-desc='Abi test']"));
        String locate = location.getText();
        if (locate.contains("Abi test")) {
            System.out.println(locate);
        } else {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("A test"))).click();
        }
    }

    @Test(priority = 0)
    public void tags3502_to_3508() throws InterruptedException {
        WebElement totalAnimals = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
        //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();//*[contains(@content-desc,'Total Animals')]
        totalAnimals.click();
        Thread.sleep(8000);
        //plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[1]"))).click();

        //Add animal to inventory
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

        //Manual Entry
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
        //Manual click
        Thread.sleep(2000);
        //Right Arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index=3])[2]"))).click();
        //Click Treatment
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatments']"))).click();
        //Right Arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index=3])[2]"))).click();
        //EPC Prefix
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //EPC Prefix dropdown select
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[1]"))).click();
        //select
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[3]"))).click();
        //select dropDown
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='3']"))).click();
        //multiple tags toggle
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.Switch"))).click();
        //from enter
        WebElement fromEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='0']")));
        fromEnter.click();
        fromEnter.sendKeys("3502");
        //to enter
        WebElement toEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='1']")));
        toEnter.click();
        toEnter.sendKeys("3505");
        //view summary
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']"))).click();
        //add animals to inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
        //yes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
    }

    @Test(priority = 1)
    public void verifyCreatedMultipleTagID() throws InterruptedException {
        //unassigned
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='2']"))).click();
        //unassigned content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='0']"))).click();
        //back arrow
        Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(3))
                                .ignoring(NoSuchElementException.class);
        WebElement backArrow = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//android.widget.ImageView[@index='0']"));
            }
        });
        backArrow.click();
        //back
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

}
