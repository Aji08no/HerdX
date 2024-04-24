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

public class MenuBarNegative extends Herd{

    WebDriverWait wait;

    @BeforeClass
    public void homePage() throws InterruptedException {
        Thread.sleep(5000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement location = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
//        WebElement location = driver.findElement(By.xpath("//*[@content-desc='Abi test']"));
        String locate = location.getText();
        if(locate.contains("Abi test")){
            System.out.println(locate);
        }
        else {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("A test"))).click();
        }
    }

    @Test(enabled = true,priority = 0)
    public void createProtocols() throws InterruptedException {
        //menuBar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //settings
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Settings']"))).click();
        //protocols

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Protocols']"))).click();
        //add ICon
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //enter Protocol

        WebElement enterPName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='4' and @class='android.widget.EditText']")));
        enterPName.click();
        Thread.sleep(100);
        enterPName.sendKeys("Paracetamol");
        //enter description

        WebElement enterPDescription = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='6' and @class='android.widget.EditText']")));
        enterPDescription.click();
        enterPDescription.sendKeys("Medicines used for fever");
        driver.hideKeyboard();
        // protocol activity

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Add Activity"))).click();
        //medicine add icon

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='4' and @class='android.widget.ImageView']"))).click();
        //select treatment

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Select Treatment Type"))).click();
        //select treatment type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Antibiotics']"))).click();
        //select medicine

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Select Medicine"))).click();
        //select medicine type
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();
        WebElement scroll = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Penicillin B']")));
        scroll.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Save"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Done"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Save"))).click();
        //verify
       /* WebElement pName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'qa')]")));
        String displayName = pName.getText();
        if (displayName.isEmpty()) {
            String verifyName = displayName.substring(0, 1);
            System.out.println(verifyName);
        } else {
            System.out.println("protocolName string is empty.");
        }*/
        //back arrow//android.widget.ImageView[@index='0']
    }

    @Test(priority = 1,enabled = true)
    public void editProtocols() throws InterruptedException {
        //edit icon
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Paracetamol')]//*[@index='0']"))).click();
//        //active
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//android.widget.Switch")).click();
        //enter name
        WebElement enterPName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='4' and @class='android.widget.EditText']")));
        enterPName.click();
        enterPName.clear();
        Thread.sleep(1000);
        enterPName.sendKeys("t1");
        //enter description
        WebElement enterPDescription = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='6' and @class='android.widget.EditText']")));
        enterPDescription.click();
        enterPDescription.clear();
        enterPDescription.sendKeys("Medicines used for fever");
        driver.hideKeyboard();
        // protocol activity

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Treatment"))).click();
        //medicine edit icon

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@index='5']//*[@index='0']"))).click();
        //select treatment
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        //select treatment type
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Antibiotics']"))).click();
        //back arrow

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //select medicine

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Select Medicine"))).click();
        //select medicine type
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Penicillin B']"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Save"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Done"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Save"))).click();
        Thread.sleep(2000);
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("//android.widget.ImageView[@index='0']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("(//android.widget.ImageView[@index='0'])[1]"))).click();
    }

    @Test(priority = 2)
    public void createMedicines() throws InterruptedException {
        //menuBar
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
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
    @Test(priority = 3)
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
}
