package Task;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TaskFunctionality extends Herd{
    WebDriverWait wait;
    TouchAction touchAction;

    @BeforeClass
    public void homePage() throws InterruptedException {

        Thread.sleep(5000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        touchAction = new TouchAction(driver);
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
    public void createTask() throws InterruptedException {
        //tasks
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Tasks')]"))).click();
        //plus icon
        Thread.sleep(25000);
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

        touchAction.press(PointOption.point(474,2047))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                                .moveTo(PointOption.point(469,397))
                                        .release()
                                                .perform();
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Sang']"))).click();
        //calendar icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }

    @Test(priority = 1)
    public void editTask() throws InterruptedException {
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

        //select location
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='8']"))).click();
        //select asTest
        touchAction.press(PointOption.point(469,397))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(474,2047))
                .release()
                .perform();
        Thread.sleep(1000);
        touchAction.press(PointOption.point(483,1015))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(501,2002))
                .release()
                .perform();

        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='A test']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //back
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
    }

    @Test(priority = 2)
    public void deleteTask() throws InterruptedException {
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

}
