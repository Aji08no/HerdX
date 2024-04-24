package Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CountingSessions extends Herd{

    WebDriverWait wait;

    @Test(priority = 0)
    public void editCountingSessions() throws InterruptedException {

        String countingName = "joe";

        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(500);
        //counting session
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Counting Session')]"))).click();
        //content menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[11]//android.widget.ImageView[@index='0']"))).click();
        //edit
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Edit Title']"))).click();
        //search enter
        WebElement editEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        editEnter.click();
        editEnter.clear();
        editEnter.sendKeys(countingName);
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }

    @Test(priority = 1)
    public void deleteCountingSessions() throws InterruptedException {
        String countingName = "joe";
        Thread.sleep(500);

        //search enter
        WebElement deleteEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']")));
        deleteEnter.click();
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
    }

    @Test(priority = 2)
    public void offlineEdit() throws InterruptedException {
        Thread.sleep(8000);

    }
}
