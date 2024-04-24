package Task;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OfflinePenAndParse extends Herd{

    WebDriverWait wait;
    @Test(priority = 0)
    public void createPen() throws InterruptedException {

        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(8000);
        //pop up ok
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='OK']"))).click();
        //Total Animals

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]"))).click();
        Thread.sleep(2000);
        //plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
        //Add pen/pastures
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
        //Enter name
        String name = "CreatePen";
        WebElement enterName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterName.click();
        enterName.sendKeys(name);
        //select pen
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
        //save
        driver.hideKeyboard();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        WebElement verifyName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
        verifyName.click();
        verifyName.sendKeys(name);
        driver.hideKeyboard();
        //verify pen
        WebElement penDetails = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[19]")));

        String verify = penDetails.getAttribute("content-desc");
        String actual = verify.substring(0, 9);

        String[] lines = verify.split("\\r?\\n");
        StringBuilder firstThreeLines = new StringBuilder();
        for (int i = 0; i < Math.min(3, lines.length); i++) {
            firstThreeLines.append(lines[i]);
            firstThreeLines.append("\n");
        }
        String actual1 = firstThreeLines.toString().trim();
        System.out.println(actual1);
        Assert.assertEquals(actual,name);
        System.out.println("Created pensuccessful is offline");
    }

    @Test(priority = 1,enabled = true)
    public void editPen() throws InterruptedException {
        Thread.sleep(2000);
        String editName = "EditPen";
        //content dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[19]//android.widget.ImageView[@index='0']"))).click();
        //edit
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Edit Pen / Pasture']"))).click();
        //edit enter
        WebElement enterName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enterName.click();
        enterName.clear();
        enterName.sendKeys(editName);
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        WebElement verifyEditName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
        verifyEditName.click();
        verifyEditName.sendKeys(editName);
        driver.hideKeyboard();
        //verify pen
        WebElement penDetails = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[19]")));

        String verify = penDetails.getAttribute("content-desc");
        String actual = verify.substring(0, 7);

        String[] lines = verify.split("\\r?\\n");
        StringBuilder firstThreeLines = new StringBuilder();
        for (int i = 0; i < Math.min(3, lines.length); i++) {
            firstThreeLines.append(lines[i]);
            firstThreeLines.append("\n");
        }
        String actual1 = firstThreeLines.toString().trim();
        System.out.println(actual1);
        Assert.assertEquals(actual,editName);
        System.out.println("Edit pen successful is offline");
    }

    @Test(priority = 2)
    public void createParse() throws InterruptedException {
        Thread.sleep(2000);
      //pasture tab
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Pasture')])[3]"))).click();
        //plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
        //Add pen/pastures
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
        //Enter name
        String createName = "CreatePasture";
        WebElement enterName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterName.click();
        enterName.sendKeys(createName);
        //select pen
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pasture']"))).click();
        //save
        driver.hideKeyboard();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        WebElement verifyName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
        verifyName.click();
        verifyName.sendKeys(createName);
        driver.hideKeyboard();
        //verify pen
        WebElement penDetails = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[19]")));

        String verify = penDetails.getAttribute("content-desc");

        String actual = verify.substring(0, 13);

        String[] lines = verify.split("\\r?\\n");
        StringBuilder firstThreeLines = new StringBuilder();
        for (int i = 0; i < Math.min(3, lines.length); i++) {
            firstThreeLines.append(lines[i]);
            firstThreeLines.append("\n");
        }
        String actual1 = firstThreeLines.toString().trim();
        System.out.println(actual1);
        Assert.assertEquals(actual,createName);
        System.out.println("Created pasture successful is offline");
    }

    @Test(priority = 3,enabled = true)
    public void editPasture() throws InterruptedException {
        Thread.sleep(2000);
        String editName = "EditPasture";
        //content dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[19]//android.widget.ImageView[@index='0']"))).click();
        //edit
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Edit Pen / Pasture']"))).click();
        //edit enter
        WebElement enterName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enterName.click();
        enterName.clear();
        enterName.sendKeys(editName);
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        WebElement verifyEditName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
        verifyEditName.click();
        verifyEditName.sendKeys(editName);
        driver.hideKeyboard();
        //verify pen
        WebElement penDetails = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[19]")));

        String verify = penDetails.getAttribute("content-desc");
        String actual = verify.substring(0, 11);

        String[] lines = verify.split("\\r?\\n");
        StringBuilder firstThreeLines = new StringBuilder();
        for (int i = 0; i < Math.min(3, lines.length); i++) {
            firstThreeLines.append(lines[i]);
            firstThreeLines.append("\n");
        }
        String actual1 = firstThreeLines.toString().trim();
        System.out.println(actual1);
        Assert.assertEquals(actual,editName);
        System.out.println("Edit pasture successful is offline");
    }

    }

