package Tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class MenuBar extends Herdx{
    WebDriverWait wait;

    //using beforeClass
    @Test(priority = 0,enabled = false)
    public void createAssignedReader() throws InterruptedException {
        //menuBar
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //settings
        driver.findElement(By.xpath("//*[@content-desc='Settings']")).click();
        //reader name

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Name Your Readers']"))).click();
        //create edit icon

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0']//android.widget.ImageView[@index='1'])[2]"))).click();
        //enter name
        WebElement name = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText")));
        name.click();
        name.sendKeys("Good");
        //apply
        driver.findElement(By.xpath("//*[@content-desc='Apply']")).click();


    }
    @Test(priority = 1,enabled = false)
        public void editAssignedReader() throws InterruptedException {
        //edit icon
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0']//android.widget.ImageView[@index='2'])"))).click();
        //edit name
        WebElement editName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText")));
        editName.click();
        editName.clear();
        editName.sendKeys("GoodOne");
        //apply
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Apply']"))).click();
    }
    @Test(priority = 2,enabled = false)
        public void deleteAssignedReader() throws InterruptedException {
        //delete icon
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0']//android.widget.ImageView[@index='1'])[2]"))).click();
        //ok
        driver.findElement(By.xpath("//*[@content-desc='OK']")).click();

    }

    //create Protocols

    @Test(enabled = false,priority = 0)
    public void createProtocols() throws InterruptedException {
        //menuBar
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //settings

        driver.findElement(By.xpath("//*[@content-desc='Settings']")).click();
        //protocols
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Protocols']")).click();
        //add ICon
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='2']")).click();
        //enter Protocol
        Thread.sleep(1000);
        WebElement enterPName = driver.findElement(By.xpath("//*[@index='4' and @class='android.widget.EditText']"));
        enterPName.click();
        Thread.sleep(1000);
        enterPName.sendKeys("qa");
        //enter description
        Thread.sleep(1000);
        WebElement enterPDescription = driver.findElement(By.xpath("//*[@index='6' and @class='android.widget.EditText']"));
        enterPDescription.click();
        enterPDescription.sendKeys("ruby");
        driver.hideKeyboard();
        // protocol activity
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Add Activity")).click();
        //medicine add icon
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@index='4' and @class='android.widget.ImageView']")).click();
        //select treatment
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Select Treatment Type")).click();
        //select treatment type
        driver.findElement(By.xpath("//*[@content-desc='Vaccine']")).click();
        //select medicine
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Select Medicine")).click();
        //select medicine type
        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@content-desc='BOVILIS® COVEXIN® 8']")).click();
        WebElement scroll = driver.findElement(By.xpath("//*[@content-desc='BOVILIS® COVEXIN® 8']"));
        scroll.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
        //save
        driver.findElement(AppiumBy.accessibilityId("Save")).click();
        //done
        driver.findElement(AppiumBy.accessibilityId("Done")).click();
        //save
        driver.findElement(AppiumBy.accessibilityId("Save")).click();
        Thread.sleep(5000);
        //verify
        WebElement pName = driver.findElement(By.xpath("//*[contains(@content-desc,'qa')]"));
        String displayName = pName.getText();
        if (!displayName.isEmpty()) {
            String verifyName = displayName.substring(0, 1);
            System.out.println(verifyName);
        } else {
            System.out.println("protocolName string is empty.");
        }
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @Test(priority = 1,enabled = false)
    public void editProtocols() throws InterruptedException {
        //menuBar
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //settings
        driver.findElement(By.xpath("//*[@content-desc='Settings']")).click();
        //protocols
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Protocols']")).click();

        //edit icon
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'qa')]//*[@index='0']"))).click();
//        //active
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//android.widget.Switch")).click();
        //enter name
        Thread.sleep(1000);
        WebElement enterPName = driver.findElement(By.xpath("//*[@index='4' and @class='android.widget.EditText']"));
        enterPName.click();
        enterPName.clear();
        Thread.sleep(1000);
        enterPName.sendKeys("Paracetamol");
        //enter description
        Thread.sleep(1000);
        WebElement enterPDescription = driver.findElement(By.xpath("//*[@index='6' and @class='android.widget.EditText']"));
        enterPDescription.click();
        enterPDescription.clear();
        enterPDescription.sendKeys("Medicines used for fever");
        driver.hideKeyboard();
        // protocol activity
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Treatment")).click();
        //medicine edit icon
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.View[@index='5']//*[@index='0']")).click();
        //select treatment
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='3']")).click();
        //select treatment type
        driver.findElement(By.xpath("//*[@content-desc='Antibiotics']")).click();
        //back arrow
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
        //select medicine
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Select Medicine")).click();
        //select medicine type
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Penicillin B']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
        //save
        driver.findElement(AppiumBy.accessibilityId("Save")).click();
        //done
        WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Done"))).click();
        //save
        driver.findElement(AppiumBy.accessibilityId("Save")).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
    @Test(priority = 3,enabled = false)
    public void deleteProtocols() throws InterruptedException {
        //menuBar
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //settings
        driver.findElement(By.xpath("//*[@content-desc='Settings']")).click();
        //protocols
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Protocols']")).click();
        //delete icon
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Para')]//*[@index='1']"))).click();
        //delete
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@content-desc='Yes']")).click();
    }

    //User added medicines

    @Test(priority = 0)
    public void createMedicines() throws InterruptedException {
        //menuBar
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //settings
        driver.findElement(By.xpath("//*[@content-desc='Settings']")).click();
        //user added medicines
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='User Added Medicines']"))).click();
        //plus icon
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //enter  medicines name
        WebElement enterName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        enterName.click();
        enterName.sendKeys("pain Tablet");
        //medicines type
        driver.findElement(By.xpath("//android.widget.ImageView[@index='7']")).click();
        //select medicine type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Antibiotics']"))).click();
        //back arrow
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
        //save
        driver.findElement(By.xpath("//*[@content-desc='Save']")).click();

    }
    @Test(priority = 1)
    public void updateMedicines() throws InterruptedException {


        //edit icon
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Antibiotics')]//*[@index='0']"))).click();
        //enter  medicines name
        WebElement enterName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        enterName.click();
        enterName.clear();
        enterName.sendKeys("pain Killer");
        //medicines type
        Thread.sleep(500);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='7']")).click();
        //select medicine type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Hormones']"))).click();
        //back arrow
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
        //save
        driver.findElement(By.xpath("//*[@content-desc='Save']")).click();
    }

    @Test(priority = 2)
    public void deleteMedicines(){
        //delete icon
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'pain')]//*[@index='1']"))).click();
        //yes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
        WebElement display = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'User Added Medicines')]")));
        System.out.println(display.isDisplayed());
        boolean displayVerify = display.isDisplayed();

        if (displayVerify){
            driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
        }
        //user added medicines
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='User Added Medicines']"))).click();
    }
}
