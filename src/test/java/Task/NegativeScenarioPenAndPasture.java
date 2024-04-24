package Task;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class NegativeScenarioPenAndPasture extends Herd{

    WebDriverWait wait;

    @BeforeClass
    public void homePage() throws InterruptedException {

        Thread.sleep(5000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        WebElement location = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
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
    public void createPenAndPasture() throws InterruptedException {
        //Total Animals
        WebElement location1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
        location1.click();
        Thread.sleep(2000);
        //plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
        //add pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
        //enter
        WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enter.click();
        enter.sendKeys("Bull2");
        driver.hideKeyboard();
        //pen
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        //enter
        WebElement enter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enter2.click();
        enter2.clear();
        enter2.sendKeys("bull");
        driver.hideKeyboard();
        //pen
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pasture']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //cancel icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
    }

    @Test(priority = 1)
    public void editPenAndPasture() throws InterruptedException {
        //pen menu dot
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull2')]//android.widget.ImageView[@index='0']"))).click();
        //edit pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Edit Pen / Pasture']"))).click();
        //enter
        WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enter.click();
        enter.clear();
        enter.sendKeys("Bull2");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        //pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Pastures')])[3]"))).click();
        //pasture menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Bull')]//android.widget.ImageView[@index='0']"))).click();
        //edit pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Edit Pen / Pasture']"))).click();
        //enter
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']"))).click();
        WebElement enter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enter2.click();
        enter2.clear();
        enter2.sendKeys("bull");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
}
