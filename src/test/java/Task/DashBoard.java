package Task;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DashBoard extends Herd{
    WebDriverWait wait;

    @Test(priority = 0)
    public void verifyTotalAnimals() throws InterruptedException {
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        //total animals
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]"))).click();
        //plus icon
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //scanner icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //cancel icon
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //inventory icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        //back arrow
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //pastures
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Pastures')])[3]"))).click();
        //unassigned
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Unassigned')])[2]"))).click();
        //delete tags
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Deleted')]"))).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }
    @Test(priority = 1)
    public void verifyTransfers() throws InterruptedException {
        //transfers
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Transfers')]"))).click();
        //plus icon
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //cancel icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //confirm pop up
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Confirm')]"))).click();
        //outgoing
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Outgoing')]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

    }
    @Test(priority = 2)
    public void verifyTasks(){
        //tasks
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Tasks')]"))).click();
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //cancel icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='3'])[1]"))).click();
        //cancel icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //menu dots
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='4']"))).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
    @Test(priority = 3)
    public void verifyAreaMonitoring(){
        //area monitoring
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Area')]"))).click();
        //plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //cancel icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

    }

    @Test(priority = 4)
    public void verifyCountingSessions(){
        //counting session
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Counting')]"))).click();
        //plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
    }


    @Test(priority = 5)
    public void headerIcon(){
        //notification icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //transfers
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Transfers')]"))).click();
        //tasks
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Tasks')]"))).click();
        //area monitoring
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Area')]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //sled reader
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='3'])[1]"))).click();
        //cancel icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])"))).click();
    }
}
