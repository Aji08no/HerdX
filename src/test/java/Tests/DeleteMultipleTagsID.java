package Tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeleteMultipleTagsID extends Herdx{
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
    public void deleteUnassignedTagsID() throws InterruptedException {
        WebElement totalAnimals = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
        //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();//*[contains(@content-desc,'Total Animals')]
        totalAnimals.click();
//        Thread.sleep(8000);
        //unassigned
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='2']"))).click();
        //unassigned content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='0']"))).click();
        //menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        //select animals-manual
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Select Animals - M')]"))).click();
        //select all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select All']"))).click();
        //quick actions
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Quick Actions']"))).click();
        //delete from inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete From Inventory']"))).click();
        //accidental scan
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Accidental Scan']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
        //delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']"))).click();
//        //pop up delete
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']"))).click();
    }

    @Test(priority = 1)
    public void verifyDeletedMultipleTagID() throws InterruptedException {
        //pens
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Pens') and @index='0']"))).click();
        //unassigned
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='2']"))).click();
        //unassigned content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='0']"))).click();
    }
}
