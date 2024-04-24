package Task;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeleteFunctionality extends Herd{

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
            //Total Animals
            WebElement location1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
            location1.click();
            //bull2
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull2')]"))).click();
            //2804
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'2802')]"))).click();
        }
    }

    @Test(priority = 0)
    public void deleteTagId(){
        //dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'2802')]//android.widget.ImageView[@index='1']"))).click();
        //delete from inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete From Inventory']"))).click();
        //accidental scan
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Missing']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
        //delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']"))).click();
    }

    @Test(priority = 1)
    public void undoDelete(){
        //delete tab
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Deleted Tags')]"))).click();
        //delete tab content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Deleted Tags')])[3]"))).click();
        //dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'2802')]//android.widget.ImageView[@index='1']"))).click();
        //undo delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Undo Delete']"))).click();
        //enter notes
        WebElement enterNotes = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterNotes.click();
        enterNotes.sendKeys("undo delete");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //alert undo delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Undo Delete']"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
    }
    @Test(priority = 2)
    public void verifyUndoDelete() throws InterruptedException {
        //pen tab
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Pens')])[3]"))).click();
        //bull2
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull2')]"))).click();
    }
}
