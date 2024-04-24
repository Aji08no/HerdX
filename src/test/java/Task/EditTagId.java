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

public class EditTagId extends Herd{
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
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull2')]"))).click();
            //2804
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'2802')]"))).click();
        }
    }

    @Test(priority = -1)
    public void enclosureMove() throws InterruptedException {
        //dots
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[2]"))).click();
        Thread.sleep(4000);
        //move to pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move to Pen/Pasture']"))).click();
        //select
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Pastures')]"))).click();
        //Bull
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Bull')]/android.widget.ImageView[@index='0']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        //move
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move']"))).click();

    }
    @Test(priority = 0)
    public void enclosureHistory() throws InterruptedException {
        //Bull
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Bull')]"))).click();
        //2802
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'2802')]"))).click();
        //dots
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[2]"))).click();
        //view history
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Movement History']"))).click();
        Thread.sleep(3000);
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

    }
    @Test(priority = 1)
    public void addWeight(){
        //weight
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='3'])[1]"))).click();
        //add new weight
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add New Weight']"))).click();
        //enter weight
        WebElement enterWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterWeight.click();
        enterWeight.sendKeys("180");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 2)
    public void editWeight(){
        //weight
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='3'])[1]"))).click();
        //view weight history
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Weight History']"))).click();
        //edit icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'24')]//*[@index='0'])[1]"))).click();
        //enter weight
        WebElement enterWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterWeight.click();
        enterWeight.clear();
        enterWeight.sendKeys("190");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 3)
    public void deleteWeight(){
        //delete icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'24')]//*[@index='1'])[1]"))).click();
        //delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
    }
    @Test(priority = 4)
    public void addIntramuscularFat(){
        //intramuscular fat
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='4'])[1]"))).click();
        //add new intramuscular fat
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Add')]"))).click();
        //enter intramuscular
        WebElement enterIntramuscular = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterIntramuscular.click();
        enterIntramuscular.sendKeys("280");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 5)
    public void editIntramuscularFat(){
        //intramuscular fat
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='4'])[1]"))).click();
        //view intramuscular history
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'View')]"))).click();
        //edit icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'24')]//*[@index='0'])[1]"))).click();
        //enter intramuscular
        WebElement enterWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterWeight.click();
        enterWeight.clear();
        enterWeight.sendKeys("008");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 6)
    public void deleteIntramuscularFat(){
        //delete icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'24')]//*[@index='1'])[1]"))).click();
        //delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
    }


}
