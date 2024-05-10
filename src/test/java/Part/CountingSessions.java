package Part;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class CountingSessions extends Herd {

    WebDriverWait wait;
    WebDriverWait wait1;
    String countingName = "";
    @Test(priority = 0)
    public void editCountingSessions() throws InterruptedException {


        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        Thread.sleep(500);
        //counting session
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Counting Session')]"))).click();

//        Thread.sleep(8000);
        //content menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[11]//android.widget.ImageView[@index='0']"))).click();
        //edit
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Edit Title']"))).click();

        try {
            WebElement editEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
            String counting = editEnter.getText();
            editEnter.click();
            Thread.sleep(500);
            editEnter.clear();
            editEnter.sendKeys(counting);
            driver.hideKeyboard();
        }
        catch (StaleElementReferenceException s){
            WebElement editEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
            String counting = editEnter.getText();
            editEnter.click();
            Thread.sleep(500);
            editEnter.clear();
            editEnter.sendKeys(counting);
            driver.hideKeyboard();
        }

        //save
        WebElement saveButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']")));
        if (saveButton.isEnabled()){
            saveButton.click();
        }else {
            System.out.println("Existing name is not updated in counting sessions");

        }

        try {
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Updated Successfully')]")));

        } catch (Exception e) {
            boolean condition = true;
            while (condition) {
                //search enter
                WebElement editEnter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));

                Thread.sleep(200);
                editEnter2.click();
                editEnter2.clear();
                Random r = new Random();
                int randomNumber = r.nextInt(0, 9);
                countingName = "TFS" + randomNumber;
               editEnter2.sendKeys(countingName);
                driver.hideKeyboard();
                //save
                WebElement save = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']")));
                if (save.isEnabled()) {
                    Thread.sleep(2000);
                    save.click();
                    condition = false;
                } else {
                    condition = true;
                }
            }
        }
        WebElement popUp = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Updated Successfully')]")));
        System.out.println(popUp.getAttribute("content-desc"));

        //verify
        WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']")));
        enter.click();
        Thread.sleep(200);
        enter.clear();
        enter.sendKeys(countingName);
        driver.hideKeyboard();

        //counting content
        WebElement countingContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[12]")));
        String VerifyCounting=countingContent.getAttribute("content-desc");

        String[] line = VerifyCounting.split("\\r?\\n");
        Assert.assertEquals(line[0],countingName);
        System.out.println("Counting Sessions Name : "+line[0]);

    }

    @Test(priority = 1)
    public void deleteCountingSessions() throws InterruptedException {
        Thread.sleep(500);

        //search enter
        WebElement deleteEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']")));
        deleteEnter.click();
        Thread.sleep(200);
        deleteEnter.clear();
        deleteEnter.sendKeys(countingName);
        driver.hideKeyboard();
        //content menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[11]//android.widget.ImageView[@index='0']"))).click();
        //delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']"))).click();
        //pop up delete
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
    }

}
