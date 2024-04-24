package Task;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeleteFilter extends Herd{

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
            Thread.sleep(2000);
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Am test"))).click();
            WebElement location1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
            location1.click();
            Thread.sleep(1000);
            //delete tag
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Deleted')]"))).click();
            //delete content
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Deleted') and @index='0']"))).click();
        }
    }

        @Test(priority = 0)
        public void shortByAnimalId() throws InterruptedException {
            //filter icon
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
            //descending
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Descending'])[1]"))).click();
            //show
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

            //Ascending
            //filter icon
            Thread.sleep(500);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
            //ascending
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Ascending'])[1]"))).click();
            //show
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

    }
    @Test(priority = 1)
    public void shortByDeletedDate(){
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //ascending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Ascending'])[2]"))).click();
        //show
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();

        //descending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Descending'])[2]"))).click();

        //show
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

    }

    @Test(priority = 2)
    public void filterByReason(){
        //Death
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();

        //clear
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Clear All']"))).click();

        //death
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Death']"))).click();

        //show
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();


        //Theft
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();

        //clear
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Clear All']"))).click();

        //theft
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Theft']"))).click();

        //show
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();


        //Missing
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();

        //clear
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Clear All']"))).click();

        //missing
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Missing']"))).click();

        //show
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();


        //Lost
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();

        //clear
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Clear All']"))).click();

        //lost
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Lost']"))).click();

        //show
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();



        //Sold
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();

        //clear
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Clear All']"))).click();

        //sold
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Sold']"))).click();

        //show
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

    }
    }

