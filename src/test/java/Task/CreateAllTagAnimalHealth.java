package Task;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAllTagAnimalHealth extends Herd{
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
            //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
            location1.click();
            //bull2
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'A pen')]"))).click();
//            //2804
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'1401')]"))).click();
//            //animal health
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='3'])[2]"))).click();

            //animal notes
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='5']"))).click();
        }
    }
@Test(priority = -1)
    public void selectAllTags(){
        //menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        //select animals
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Animals - Manual']"))).click();
        //select all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select All']"))).click();
        //quick action
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Quick Actions']"))).click();
        //animal health
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Animal Health']"))).click();

    }

    @Test(priority = 0)
    public void createSymptomsAllTags() throws InterruptedException {

        //symptoms
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Symptoms']"))).click();
        //select symptoms
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Symptoms']"))).click();
        Thread.sleep(2000);
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(454,1933))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(465,999)).release().perform();

        //warts
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Warts']"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //comment
        WebElement enterComment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='8']")));
        enterComment.click();
        enterComment.sendKeys("Warts are caused by the human papillomavirus");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }

    @Test(priority = 1)
    public void createDiagnosisAllTags(){
        //diagnosis
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Diagnosis']"))).click();
        //select diagnosis
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Diagnosis']"))).click();
        //pneumonia
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pneumonia']"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])"))).click();
        //diagnosis by
        WebElement enterDiagnosisBY = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterDiagnosisBY.click();
        enterDiagnosisBY.sendKeys("caused by");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //comment
        WebElement enterComment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));
        enterComment.click();
        enterComment.sendKeys("Pneumonia is an infection that inflames the air sacs in one or both lungs.");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 2)
    public void createHealthScoreAllTags(){
        //healthScore
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Score')]"))).click();
        //seekBar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.SeekBar"))).click();
        //comment
        WebElement enterComment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='9']")));
        enterComment.click();
        enterComment.sendKeys("A health score can be a number that indicates.");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 3)
    public void createBCSAllTags(){
        //bcs
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='BCS']"))).click();
        //condition score
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='8']"))).click();
        //comment
        WebElement enterComment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='17']")));
        enterComment.click();
        enterComment.sendKeys("BCS stands for Body Conditioning Scoring.");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 4)
    public void createTempAllTags(){
        //temp
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Temp.']"))).click();
        //enter temperature
        WebElement enterTemperature = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterTemperature.click();
        enterTemperature.sendKeys("110");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //recorded by
        WebElement enterRecord = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterRecord.click();
        enterRecord.sendKeys("Best");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //comment
        WebElement enterComment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));
        enterComment.click();
        enterComment.sendKeys("Temperature is a measure of the average kinetic energy of the particles in an object.");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 5)
    public void createHealthNoteAllTag() throws InterruptedException {
        //health notes
        Thread.sleep(4000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Notes')]"))).click();
        //health note
        WebElement enterNotes = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterNotes.click();
        enterNotes.sendKeys("Health Conditions Find information about conditions.");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 6)
    public void createWatchList() throws InterruptedException {
        Thread.sleep(4000);
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(41,1804))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(72,1127))
                .release()
                .perform();
        //watch list
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'List')]"))).click();
        //to date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        //comment
        WebElement enterComment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterComment.click();
        enterComment.sendKeys("Internal Watch List");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 7)
    public void verifyCreateAnimalHealth() throws InterruptedException {
        Thread.sleep(4000);
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(594,1698))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(643,651))
                .release()
                .perform();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='  Save  ']"))).click();
        //pop up save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }

}
