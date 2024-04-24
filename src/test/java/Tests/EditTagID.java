package Tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class EditTagID extends Herdx{

    @BeforeClass
    public void homePage() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
            //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
            location1.click();
            //bull2
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'A pen')]"))).click();
            //2804
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'1401')]"))).click();
            //animal health
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='3'])[2]"))).click();

            //animal notes
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='5']"))).click();
        }
    }

    //animal health

    @Test(priority = 0,enabled = false)
    public void createSymptoms() throws InterruptedException {
        //Total Animals
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement location1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
        //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        location1.click();
        //bull2
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull2')]"))).click();
        //2804 menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'2802')]//android.widget.ImageView[@index='1']"))).click();
        //animal health
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Animal Health']"))).click();
        //symptoms
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Symptoms']"))).click();
        //plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[2]"))).click();
        //select symptoms
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Symptoms']"))).click();
        //enter symptoms
        WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
        enter.click();
        enter.sendKeys("ulcer");
        //select symptoms
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Ulcer on eye']"))).click();
        //cancel icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='  Save  ']"))).click();

    }
    @Test(priority = 1,enabled = false)
    public void createDiagnosis() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //diagnosis
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Diagnosis']"))).click();
        //plus icon
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[2]"))).click();
        //select symptoms
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Diagnosis']"))).click();
        //enter symptoms
        WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
        enter.click();
        enter.sendKeys("pneumonia");
        //select symptoms
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pneumonia']"))).click();
        //cancel icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])"))).click();
        //enter by
        WebElement enterBy = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='18']")));
        enterBy.click();
        enterBy.sendKeys("QA");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='  Save  ']"))).click();

    }
    @Test(priority = 2,enabled = false)
    public void createHealthScore() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //health score
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Health\n" +
                "Score']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[2]"))).click();
        //required information
        Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
        WebElement plusIcon = wait1.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//android.widget.SeekBar"));
            }
        });
        plusIcon.click();

        //calendar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //save
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='  Save  ']"))).click();
        //back
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //2804
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'2802')]"))).click();
        //animal health
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='3'])[2]"))).click();
    }

    @Test(priority = 3,enabled = false)
    public void createBCS() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //bcs
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='BCS']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[2]"))).click();
        //required information
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='4']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='  Save  ']"))).click();
    }
    @Test(priority = 4,enabled = false)
    public void createTemp() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //temp
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Temp.']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[2]"))).click();
        //required information
        WebElement enterTemp = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='16']")));
        enterTemp.click();
        enterTemp.sendKeys("120");
        //enterBY
        WebElement enterBy = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='18']")));
        enterBy.click();
        enterBy.sendKeys("QA");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='  Save  ']"))).click();
    }
    @Test(priority = 5,enabled = false)
    public void createHealthNotes() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //health notes
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Health\n" +
//                "Notes']"))).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//android.widget.ImageView[@index='2'])[2]")).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[2]"))).click();
        //required information
        WebElement enterNotes = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='16']")));
        enterNotes.click();
        enterNotes.sendKeys("bacterial disease of cattle");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='  Save  ']"))).click();
    }
    @Test(priority = 6,enabled = false)
    public void createWatchList() throws InterruptedException {

        Thread.sleep(8000);
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(41,1804))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(72,1127))
                .release()
                .perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //watch list
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Watch\n" +
                "List']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[2]"))).click();
        //to date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='18']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='  Save  ']"))).click();
        //back
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //2804
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'2802')]"))).click();
        //animal health
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='3'])[2]"))).click();

    }
    //animal notes
    @Test(priority = 0,enabled = false)
    public void createAnimalsNotes(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //enter notes
        WebElement enterNotes = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText")));
        enterNotes.click();
        enterNotes.sendKeys("Animals are multicellar, eukaryotic organisms in the biological kingdom Animalia.");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 1,enabled = false)
    public void flag(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //notes menu
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
        //flag
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Flag']"))).click();
    }
    @Test(priority = 2,enabled = false)
    public void unFlag() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //notes menu
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
        //flag
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Unflag']"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //2804
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'2804')]"))).click();
        //animal notes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='5']"))).click();
    }
    @Test(priority = 3,enabled = false)
    public void verifyFlagged(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //check button
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Switch"))).click();
    }
    //Edit

    @Test(priority = 0)
    public void editSymptoms(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //symptoms
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Symptoms']"))).click();
        //edit icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'CREATED')]//*[@index='0']"))).click();
        //select symptoms
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='16']"))).click();
        //enter symptoms
        WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
        enter.click();
        enter.sendKeys("Swollen");
        //select symptoms
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Swollen Foot']"))).click();
        //cancel icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='  Save  ']"))).click();
    }

    @Test(priority = 1)
    public void editDiagnosis() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //diagnosis
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Diagnosis']"))).click();
        //edit icon
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'CREATED')]//*[@index='0']"))).click();
        //select diagnosis
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='16']"))).click();
        //enter symptoms
        WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
        enter.click();
        enter.sendKeys("foot");
        //select symptoms
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Foot Rot']"))).click();
        //cancel icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])"))).click();
        //enter by
        WebElement enterBy = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='18']")));
        enterBy.click();
        enterBy.clear();
        enterBy.sendKeys("diagnosed");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='  Save  ']"))).click();
    }

    @Test(priority = 2)
    public void editHealthScore() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //health score
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Health\n" +
                "Score']"))).click();
        //edit icon
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'CREATED')]//*[@index='0']"))).click();
        //required information
        Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
        WebElement plusIcon = wait1.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//android.widget.SeekBar"));
            }
        });
        plusIcon.click();

        //calendar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //save
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='  Save  ']"))).click();
    }

    @Test(priority = 3)
    public void editBCS() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //bcs
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='BCS']"))).click();
        //edit icon
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'CREATED')]//*[@index='0']"))).click();
        //required information
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='8']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='  Save  ']"))).click();
    }

    @Test(priority = 4)
    public void editTemp() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //temp
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Temp.']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'CREATED')]//*[@index='0']"))).click();
        //required information
        WebElement enterTemp = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='16']")));
        enterTemp.click();
        enterTemp.clear();
        enterTemp.sendKeys("108");
        //enterBY
        WebElement enterBy = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='18']")));
        enterBy.click();
        enterTemp.clear();
        enterBy.sendKeys("Temp");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='  Save  ']"))).click();
    }

    @Test(priority = 5)
    public void editHealthNotes() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //health notes
        Thread.sleep(14000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Health\n" +
                "Notes']"))).click();
Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'CREATED')]//*[@index='0']"))).click();
        //required information
        WebElement enterNotes = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='16']")));
        enterNotes.click();
        enterNotes.clear();
        enterNotes.sendKeys("bacterial disease");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='  Save  ']"))).click();

    }

    @Test(priority = 6)
    public void editWatchList() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(8000);
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(41,1804))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(72,1127))
                .release()
                .perform();
        //watch list
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Watch\n" +
                "List']"))).click();

        //edit icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'CREATED')]//*[@index='0']"))).click();
        //to date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='18']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='  Save  ']"))).click();

    }
}
