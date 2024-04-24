package Task;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class InventoryFilter extends Herd{
    WebDriverWait wait;

    @BeforeClass
    public void homePage() throws InterruptedException {

        Thread.sleep(5000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        WebElement location = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
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
    public void filterPen() throws InterruptedException {
        //Total Animals
        WebElement location1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
        location1.click();
        Thread.sleep(1000);
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='15']"))).click();

        //pen name descending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen Name (Descending)']"))).click();
        //apply
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Apply']"))).click();

        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='15']"))).click();

        //pen name ascending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen Name (Ascending)']"))).click();
        //apply
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Apply']"))).click();

        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='15']"))).click();

        //lod id ascending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Lot ID (Ascending)']"))).click();
        //apply
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Apply']"))).click();

        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='15']"))).click();

        //lod id descending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Lot ID (Descending)']"))).click();
        //apply
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Apply']"))).click();
    }

    @Test(priority = 1)
    public void filterPasture() throws InterruptedException {
        //pasture
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Pastures')])[3]"))).click();

        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='15']"))).click();

        //pasture name descending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pasture Name (Descending)']"))).click();
        //apply
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Apply']"))).click();

        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='15']"))).click();

        //pasture name ascending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pasture Name (Ascending)']"))).click();
        //apply
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Apply']"))).click();

        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='15']"))).click();

        //lod id ascending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Lot ID (Ascending)']"))).click();
        //apply
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Apply']"))).click();

        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='15']"))).click();

        //lod id descending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Lot ID (Descending)']"))).click();
        //apply
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Apply']"))).click();
    }
}
