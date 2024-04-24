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

public class CreateMultipleAnimalsAndBulkTreat extends Herd{
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
    public void addBulkTreat() throws InterruptedException {
    //Total Animals
    WebElement location1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
    location1.click();
    //search bar
        WebElement enterSearchValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
        enterSearchValue.click();
        enterSearchValue.sendKeys("pen");
        javaUtility.hideKeyBoard();


        //bull2
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'test pen')]"))).click();
        //dot
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        //select manual
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Animals - Manual']"))).click();
        //select all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select All']"))).click();
        //quick actions
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Quick Actions']"))).click();
        //treat
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treat']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();


        //Treatment
        //select treatment type content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Type']"))).click();
        //select treatment type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Antibiotics']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //vet
        WebElement entervet = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
        entervet.click();
        entervet.sendKeys("Veterinarians treat the injuries and illnesses of pets");
        javaUtility.hideKeyBoard();
        //prescription notes
        WebElement enterPNotes = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='7']")));
        enterPNotes.click();
        enterPNotes.sendKeys("A prescription has several parts");
        javaUtility.hideKeyBoard();
        //comment

        touchAction.press(PointOption.point(523, 1781))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(478, 1227))
                .release()
                .perform();
        WebElement enterCommon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='7']")));
        enterCommon.click();
        enterCommon.sendKeys("There's no cure for the common cold");
        javaUtility.hideKeyBoard();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();

        //medicine
        //medicine Plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView)[9]"))).click();
        //Select medicine
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Medicine']"))).click();
        //select painkiller
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'pain')]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //treatment route
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Route']"))).click();
        //select treatment route
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Orally')]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //location
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Location']"))).click();
        //select treatment location
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Neck')]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //withdrawalPeriod
        WebElement enterPeriod = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
        enterPeriod.click();
        enterPeriod.sendKeys("08");
        javaUtility.hideKeyBoard();

//        touchAction.press(PointOption.point(397,1953))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
//                .moveTo(PointOption.point(408,1488))
//                .release()
//                .perform();
        WebElement enterAmount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='11']")));
        enterAmount.click();
        enterAmount.sendKeys("4");
        javaUtility.hideKeyBoard();
        //for every
        WebElement enterforEvery = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='12']")));
        enterforEvery.click();
        enterforEvery.sendKeys("8");
        javaUtility.hideKeyBoard();
        //duration
        WebElement enterDuration = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='12']")));
        enterDuration.click();
        enterDuration.sendKeys("2");
        javaUtility.hideKeyBoard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();

        //dose log
        //Dose log Plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView)[9]"))).click();
        //Select medicine
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Medicine']"))).click();
        //select painkiller
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'pain')]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        //serial
        WebElement enterSerial = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='11']")));
        enterSerial.click();
        enterSerial.sendKeys("28");
        javaUtility.hideKeyBoard();
        //lot
        WebElement enterLot = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='13']")));
        enterLot.click();
        enterLot.sendKeys("second");
        javaUtility.hideKeyBoard();
        //Mfg
        WebElement enterMfg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='13']")));
        enterMfg.click();
        enterMfg.sendKeys("huge");
        javaUtility.hideKeyBoard();


        touchAction.press(PointOption.point(537, 1795))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(547, 1416))
                .release()
                .perform();

        WebElement administered = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='12']")));
        administered.click();
        administered.sendKeys("admin");
        javaUtility.hideKeyBoard();
        //comment
//        WebElement enterComment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='15']")));
//        enterComment.click();
//        enterComment.sendKeys("You always know what to say to make me feel better");
//        javaUtility.hideKeyBoard();

        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();

        //reminder
        //Reminder Plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView)[9]"))).click();
        //custom reminder
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        //select time
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Time']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        WebElement enterCustomNote = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='11']")));
        enterCustomNote.click();
        enterCustomNote.sendKeys("feedBack");
        javaUtility.hideKeyBoard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();

        //review & save
        //edit icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[3]"))).click();
        //select tag
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Selected Tags (6)']"))).click();
        //tag one
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='1084']"))).click();
        //tag second
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='1085']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //pop up save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        //tag content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'1052')]"))).click();
        //treatment icon
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='4'])[2]"))).click();
}
}
