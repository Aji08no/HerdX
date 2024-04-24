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

public class CreateMultipleTagID_and_MoveToPens extends Herdx{

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
    public void createMultipleTagId() throws InterruptedException {
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
        //from enter1
        WebElement fromEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='0']")));
        fromEnter.click();
        fromEnter.sendKeys("1005");
        //to enter2 manual entry
//        WebElement toEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='1']")));
//        toEnter.click();
//        toEnter.sendKeys("3505");
        //plus icon
        //from enter2//*[contains(@content-desc,'From')]//android.view.View[@index='0']
        //to enter2
        //plus icon
        int clickCount=2;
        for (int i=0;i < clickCount;i++){
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        }
        //from enter3
        //to enter3

        //view summary
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='View Summary']"))).click();
        //add animals to inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
        //yes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
    }

    @Test(priority = 1)
    public void verifyCreatedTagsId(){
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
    @Test(priority = 2)
    public void moveToTagsIdInPens() throws InterruptedException {
        try {
            // Locate the element
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));

            // Perform actions on the element
            element.click(); // For example, clicking on the element
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            // If the element is stale, re-locate it and perform actions again
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
            element.click();
        }
//        WebElement totalAnimals = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
//        //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();//*[contains(@content-desc,'Total Animals')]
//        Thread.sleep(2000);
//        totalAnimals.click();
        //unassigned
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='2']"))).click();
        //unassigned content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='0']"))).click();
        //search bar
        WebElement searchTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
        searchTag.click();
        searchTag.sendKeys("102");
        driver.hideKeyboard();
        //menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        //select animals-manual
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Select Animals - M')]"))).click();
        //select all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select All']"))).click();
        //quick actions
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Quick Actions']"))).click();
        //move to pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move to Pen / Pasture']"))).click();
        //confirm
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Confirm']"))).click();
        //select
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //pens content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'test pen')]//android.widget.ImageView[@index='0']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        //move
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move']"))).click();
    }
    @Test(priority = 3)
    public void verifyMovedTagsId(){
        //search bar
        WebElement searchPen = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText']")));
        searchPen.click();
        searchPen.sendKeys("test");
        driver.hideKeyboard();
        //pens content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'test pen')]"))).click();

    }
}
