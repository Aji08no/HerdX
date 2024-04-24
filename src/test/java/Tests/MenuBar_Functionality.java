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

public class MenuBar_Functionality extends Herdx {
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
    @Test(priority = -1)
    public void inventory() throws InterruptedException {
        //menu bar

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Inventory']"))).click();
        Thread.sleep(1000);
        WebElement inventory = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Inventory']")));
        boolean inventoryDisplay = inventory.isDisplayed();
        if(inventoryDisplay){
            Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(3))
                    .ignoring(NoSuchElementException.class);
            WebElement inventoryMenuBar = fluentWait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.xpath("(//android.widget.ImageView[@index='0'])[1]"));
                }
            });
            inventoryMenuBar.click();

        }

    }

    @Test(priority = 0)
    public void tasks() throws InterruptedException {

        //tasks
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Tasks']"))).click();
        WebElement taskVerify = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Created')])[1]")));
        boolean taskDisplay = taskVerify.isDisplayed();
        if (taskDisplay) {
            Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(3))
                    .ignoring(NoSuchElementException.class);
            WebElement tasksBackArrow = fluentWait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.xpath("(//android.widget.ImageView[@index='0'])[1]"));
                }
            });
            tasksBackArrow.click();
        }
    }
    //area monitoring
    @Test(priority = 1)
    public void areaMonitoring() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Area Monitoring']"))).click();
        WebElement enclosure = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Enclosure')])[1]")));
        boolean enclosureVerify = enclosure.isDisplayed();
        if (enclosureVerify) {
            Wait<WebDriver> enclosureWait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(3))
                    .ignoring(NoSuchElementException.class);
            WebElement areaMonitoringBackArrow = enclosureWait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.xpath("(//android.widget.ImageView[@index='0'])[1]"));
                }
            });
            areaMonitoringBackArrow.click();
        }
    }
    //counting sessions
    @Test(priority = 2)
    public void countingSession() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Counting Sessions']"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='android.widget.ImageView' and @index='0']")).click();
//            Wait<WebDriver> enclosureWait = new FluentWait<WebDriver>(driver)
//                    .withTimeout(Duration.ofSeconds(20))
//                    .pollingEvery(Duration.ofSeconds(3))
//                    .ignoring(NoSuchElementException.class);
//            WebElement countingSessionBackArrow = enclosureWait.until(new Function<WebDriver, WebElement>() {
//                @Override
//                public WebElement apply(WebDriver driver) {
//                    return driver.findElement(By.xpath("//*[@class='android.widget.ImageView' and @index='0']"));
//                }
//            });
//            Thread.sleep(500);
//            countingSessionBackArrow.click();
    }
    //transfer
    @Test(priority = 3)
    public void transfers() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Transfers']"))).click();
        WebElement transfer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Need to Approve']")));
        boolean transferVerify = transfer.isDisplayed();
        if (transferVerify) {
            Wait<WebDriver> transferWait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(3))
                    .ignoring(NoSuchElementException.class);
            WebElement transferBackArrow = transferWait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.xpath("(//android.widget.ImageView[@index='0'])[1]"));
                }
            });
            transferBackArrow.click();
        }
    }
    //notifications
    @Test(priority = 4)
    public void notification() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Notifications']"))).click();
        Thread.sleep(1000);
        Wait<WebDriver> notificationWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
        WebElement notificationBackArrow = notificationWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("(//android.widget.ImageView[@index='0'])[1]"));
            }
        });
        notificationBackArrow.click();
    }
        //settings
    @Test(priority = 5)
    public void setting() throws InterruptedException {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Settings']"))).click();
            Thread.sleep(1000);
            Wait<WebDriver> settingWait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(3))
                    .ignoring(NoSuchElementException.class);
            WebElement settingBackArrow = settingWait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.xpath("(//android.widget.ImageView[@index='0'])[1]"));
                }
            });
            settingBackArrow.click();
    }
    @Test(priority = 6)
    public void dashboard(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Dashboard']"))).click();
    }
    }

