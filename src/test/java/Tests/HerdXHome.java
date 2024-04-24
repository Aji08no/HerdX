package Tests;

import io.appium.java_client.AppiumBy;
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

public class HerdXHome extends Herdx{
    @BeforeClass
    public void homePage() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    @Test(enabled = false)
    public void createTasks() throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        //tasks
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Tasks')]"))).click();
        //plus icon
        Thread.sleep(10000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        //enter task title
        WebElement enterTask = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
        enterTask.click();
        Thread.sleep(100);
        enterTask.sendKeys("morning");
        //enter description
        WebElement enterDescription = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        enterDescription.click();
        enterDescription.sendKeys("This task is very difficult");
        driver.hideKeyboard();

        //select assign
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='7']"))).click();
        //select drop down value
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='You']"))).click();
        //select location
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='9']"))).click();
        //select asTest
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='As Testt']"))).click();
        //calendar icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }

    @Test(enabled = false)
    public void createAreaMonitoring() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        //area monitoring
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Area')]"))).click();
        //plus icon
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //add new area to monitoring
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Add')]"))).click();
        //select the area type
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Area Type')]"))).click();
        //select drop down value
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='forests ']"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //select pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull')]"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        Thread.sleep(2000);

        //back
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //menu bar
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //area monitoring
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Area Monitoring']"))).click();
    }

    @Test(priority = 0,enabled = false)
    public void editTasks() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        //tasks
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Tasks')]"))).click();
        //tasks content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2' and contains(@content-desc,'CREATE')]"))).click();
        //menu dot
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.ImageView' and @index='2']"))).click();
        //edit
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Edit']"))).click();
        //enter task title
        Thread.sleep(500);
        WebElement enterTask = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterTask.click();
        Thread.sleep(500);
        enterTask.clear();
        enterTask.sendKeys("Task");
        //enter description
        WebElement enterDescription = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterDescription.click();
        enterDescription.clear();
        enterDescription.sendKeys("Task was completed");
        driver.hideKeyboard();

        //select assign
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='6']"))).click();
        //select drop down value
//        Thread.sleep(100);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=' You']"))).click();
        //select location
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='8']"))).click();
        //select asTest
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='As Testt']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //back
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

    }
    @Test(priority = 1,enabled = false)
    public void tasksCompleteAndIncomplete() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //tasks content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2' and contains(@content-desc,'CREATE')]"))).click();
        //mark as complete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Mark as Complete']"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        //tasks content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2' and contains(@content-desc,'CREATE')]"))).click();
        ////mask as incomplete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Mark as Incomplete']"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
    }
    @Test(enabled = false)
    public void deleteTasks() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //tasks
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Tasks')]"))).click();
        //tasks content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2' and contains(@content-desc,'CREATE')]"))).click();
        //menu dot
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.ImageView' and @index='2']"))).click();
        //delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']"))).click();
        //confirm delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']"))).click();
    }

    @Test
    public void deleteAllYourTasks() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        //tasks
        Thread.sleep(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Tasks')]"))).click();
        //menu dot
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement fOut = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//*[@class='android.widget.ImageView' and @index='4']"));
            }
        });
        fOut.click();

//        Thread.sleep(500);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.ImageView' and @index='4']"))).click();
        //delete all your tasks
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Delete')]"))).click();
        //confirm delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']"))).click();
    }

}

