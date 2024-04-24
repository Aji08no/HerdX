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

public class TreatFilter extends Herd{

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

            WebElement location1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
            location1.click();
            //bull2
            Thread.sleep(500);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull2')]"))).click();
            //2802
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'4622')]//android.widget.ImageView[@index='1']"))).click();
            //treat
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Treat')]"))).click();
        }
    }

    @Test(priority = 0)
    public void filterTreatmentType() throws InterruptedException {
        //Hormones
        //filter icon
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //hormones
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Hormones']"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        //Antibiotics
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //clear all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Clear All']"))).click();
        //antibiotics
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Antibiotics']"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
    }

    @Test(priority = 1)
    public void filterCreatedDateRange() throws InterruptedException {
        //positive filterRange
        //filter icon
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //clear all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Clear All']"))).click();
        //calendar icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //scroll
        touchAction.press(PointOption.point(528,636))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(528,1321))
                .release()
                .perform();
        //start date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'30, S')]"))).click();
        //end date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'1, Monday, A')]"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'SAVE')]"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        //negative filterRange
        //filter icon
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //calendar icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //start date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'2, Tuesday, A')]"))).click();
        //end date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'3, W')]"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'SAVE')]"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
    }

    @Test(priority = 2)
    public void filterSortCreatedDate() throws InterruptedException {
        //filter icon
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //Ascending
        //clear all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Clear All']"))).click();
        //ascending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Ascending']"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        //Descending
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //descending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Descending']"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
    }

    @Test(priority = 3)
    public void filterMedicine() throws InterruptedException {
        Thread.sleep(500);
        //anti
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Anti-')]//android.widget.ImageView[@index='0']"))).click();
        //medicine
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Medicine')]"))).click();
        //positive
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
        //calendar icon
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]"))).click();
        //scroll
        touchAction.press(PointOption.point(528,636))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(528,1321))
                .release()
                .perform();
        //start date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'30, S')]"))).click();
        //end date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'1, Monday, A')]"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'SAVE')]"))).click();
        //show
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //negative
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
        //calendar icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]"))).click();
        //start date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'4, Thursday, A')]"))).click();
        //end date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'8, M')]"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'SAVE')]"))).click();
        //show
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();
    }

    @Test(priority = 4)
    public void filterDoseLog() throws InterruptedException {
        Thread.sleep(500);
        //dose
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Dose')]"))).click();
        //new 1
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
        //new 1
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='new 1']"))).click();
        //show
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //medicine1
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
        //clear all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Clear All']"))).click();
        //medicine 1
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Medicine 1']"))).click();
        //show
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //range
        //filter icon
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
        //clear all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Clear All']"))).click();
        //calendar icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //start date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'1, M')]"))).click();
        //end date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'2, Tuesday')]"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'SAVE')]"))).click();
        //show
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //negative
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
        //clear all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Clear All']"))).click();
        //calendar icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //start date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'2, Tuesday')]"))).click();
        //end date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'3, W')]"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'SAVE')]"))).click();
        //show
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();
    }
    @Test(priority = 5)
    public void filterReminder() throws InterruptedException {
        Thread.sleep(500);
        //reminder
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Reminder')]"))).click();
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='3'])"))).click();
        //calendar
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //start date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'1, M')]"))).click();
        //end date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'4, Thursday')]"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'SAVE')]"))).click();
        //show
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //negative
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='3'])"))).click();
        //calendar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //start date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'5, F')]"))).click();
        //end date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'8, M')]"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'SAVE')]"))).click();
        //show
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

    }
}
