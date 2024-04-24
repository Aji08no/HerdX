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

public class CreateTreatTag extends Herd{

    WebDriverWait wait;
    TouchAction touchAction;
    @BeforeClass
    public void homePage() throws InterruptedException {

        Thread.sleep(5000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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

    @Test(priority = 0,enabled = false)
    public void addTreatment() throws InterruptedException {
        //Total Animals
        WebElement location1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
        location1.click();
        //bull2
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull2')]"))).click();
        //2804 menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'2802')]//android.widget.ImageView[@index='1']"))).click();
        //treat
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treat']"))).click();
        //plus iCON
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='3'])[1]"))).click();

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
        WebElement enterCommon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterCommon.click();
        enterCommon.sendKeys("There's no cure for the common cold");
        javaUtility.hideKeyBoard();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
    }

    @Test(priority = 1,enabled = false)
    public void addMedicine() {
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
        WebElement enterPeriod = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='15']")));
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
    }
    @Test(priority = 2,enabled = false)
    public void addDoseLog() {
        //Dose log Plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView)[9]"))).click();
        //Select medicine
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Medicine']"))).click();
        //select painkiller
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'pain')]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        //serial
        WebElement enterSerial = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='13']")));
        enterSerial.click();
        enterSerial.sendKeys("28");
        javaUtility.hideKeyBoard();
        //lot
        WebElement enterLot = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='13']")));
        enterLot.click();
        enterLot.sendKeys("second");
        javaUtility.hideKeyBoard();
        //Mfg
        WebElement enterMfg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));
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
    }
    @Test(priority = 3,enabled = false)
    public void addReminder(){
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
        WebElement enterCustomNote = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='12']")));
        enterCustomNote.click();
        enterCustomNote.sendKeys("feedBack");
        javaUtility.hideKeyBoard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
    }

    //Edit
    @Test(priority = 0,enabled = true)
    public void editTreatment() throws InterruptedException {
//Total Animals
        WebElement location1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
        location1.click();
        //bull2
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull2')]"))).click();
        //2804 menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'2802')]//android.widget.ImageView[@index='1']"))).click();
        //treat
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treat']"))).click();
        //edit iCON
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'CREATED')]/*[@index='0']"))).click();
        //select treatment type content
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
//        //select treatment type
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Vaccine']"))).click();
//        //back arrow
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //vet
        WebElement entervet = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
        entervet.click();
        Thread.sleep(200);
        entervet.clear();
        entervet.sendKeys("Veterinarians treat");
        javaUtility.hideKeyBoard();

        //prescription notes
        touchAction.press(PointOption.point(488, 2011))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(537, 979))
                .release()
                .perform();
        WebElement enterPNotes = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterPNotes.click();
        enterPNotes.clear();
        enterPNotes.sendKeys("A prescription");
        javaUtility.hideKeyBoard();
        //comment

        touchAction.press(PointOption.point(523, 1781))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(478, 1227))
                .release()
                .perform();
        WebElement enterCommon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterCommon.click();
        enterCommon.clear();
        enterCommon.sendKeys("The common cold");
        javaUtility.hideKeyBoard();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
    }

    @Test(priority = 1,enabled = true)
    public void editMedicine() throws InterruptedException {
        //edit iCON
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'CREATED')]/*[@index='0']"))).click();
        //Select medicine
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='9'])"))).click();
        //select painkiller
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'new one san')]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //treatment route
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='11']"))).click();
        //select treatment route
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Nasally')]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //location
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='13']"))).click();
        //select treatment location
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Eye')]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //withdrawalPeriod
        WebElement enterPeriod = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='15']")));
        enterPeriod.click();
        enterPeriod.clear();
        enterPeriod.sendKeys("04");
        javaUtility.hideKeyBoard();

//        touchAction.press(PointOption.point(397,1953))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
//                .moveTo(PointOption.point(408,1488))
//                .release()
//                .perform();
        WebElement enterAmount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='11']")));
        enterAmount.click();
        enterAmount.clear();
        enterAmount.sendKeys("8");
        javaUtility.hideKeyBoard();
        //for every
        WebElement enterforEvery = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='12']")));
        enterforEvery.click();
        enterforEvery.clear();
        enterforEvery.sendKeys("88");
        javaUtility.hideKeyBoard();
        //duration
        WebElement enterDuration = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='12']")));
        enterDuration.click();
        enterDuration.clear();
        enterDuration.sendKeys("1");
        javaUtility.hideKeyBoard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
    }

    @Test(priority = 2,enabled = true)
    public void editDoseLog(){
        //edit iCON
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'CREATED')]/*[@index='0']"))).click();
//        //Select medicine
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Medicine']"))).click();
//        //select painkiller
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'pain')]"))).click();
//        //back arrow
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        //serial
        WebElement enterSerial = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='13']")));
        enterSerial.click();
        enterSerial.clear();
        enterSerial.sendKeys("48");
        javaUtility.hideKeyBoard();
        //lot
        WebElement enterLot = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='13']")));
        enterLot.click();
        enterLot.clear();
        enterLot.sendKeys("one");
        javaUtility.hideKeyBoard();
        //Mfg
        WebElement enterMfg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));
        enterMfg.click();
        enterMfg.clear();
        enterMfg.sendKeys("large");
        javaUtility.hideKeyBoard();


        touchAction.press(PointOption.point(537, 1795))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(547, 1416))
                .release()
                .perform();

        WebElement administered = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='12']")));
        administered.click();
        administered.sendKeys("employee");
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
    }

    @Test(priority = 3,enabled = true)
    public void editReminder(){
        //Reminder edit icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'ACTIVE')]/*[@index='0']"))).click();
        //custom reminder
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@index='9']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        //select time
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@index='10']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        WebElement enterCustomNote = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='12']")));
        enterCustomNote.click();
        enterCustomNote.clear();
        enterCustomNote.sendKeys("Create custom treatment note templates with diagrams");
        javaUtility.hideKeyBoard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
    }
    @Test(priority = 4)
    public void deleteTreat(){
        //delete iCON
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'CREATED')]/*[@index='1']"))).click();
        //yes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();

    }
}
