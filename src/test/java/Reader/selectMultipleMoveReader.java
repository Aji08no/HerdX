package Reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class selectMultipleMoveReader extends Herd{

    @Test(priority = 0,enabled = true)
    public void multipleMove() throws InterruptedException, IOException {

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));

        String path="C:\\Users\\E-7\\IdeaProjects\\HerdX\\src\\main\\resources\\Reader.properties";
        FileInputStream file=new FileInputStream(path);
        Properties pro=new Properties();
        pro.load(file);
        try {
            // Locate the element
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));

            // Perform actions on the element
            element.click(); // For example, clicking on the element
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            // If the element is stale, re-locate it and perform actions again
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
            element.click();
        }
////unassigned
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='2']"))).click();
////unassigned content
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='0']"))).click();
//search bar
//        WebElement searchTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
//        searchTag.click();
//        searchTag.sendKeys("102");
//        driver.hideKeyboard();
        Thread.sleep(1500);
        //pen content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]"))).click();
        //dot
//menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
//select animals-manual
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Select Animals - S')]"))).click();
//herdView readers
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'HerdView')]"))).click();
        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        Thread.sleep(5000);
        //reader
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Goodnow')]//android.widget.ImageView[@index='0']"))).click();

        //reader
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'"+pro.getProperty("multipleMoveReader")+"')]//android.widget.ImageView[@index='0']"))).click();
        Thread.sleep(3000);
        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='5'])"))).click();
        //no
        try {
            driver.findElement(By.xpath("//*[@content-desc='No']")).click();
        } catch (Exception e) {
            e.getMessage();
        }
        Thread.sleep(15000);
        //scan stop
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='7'])"))).click();
        Thread.sleep(3000);
        //confirm tag
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Confirm Tags']"))).click();
//quick actions
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Quick Actions']"))).click();
//move to pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move to Pen / Pasture']"))).click();
//confirm
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Confirm']"))).click();
//select
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
//pens content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'r')]//android.widget.ImageView[@index='0']"))).click();
//done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
//move
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move']"))).click();
    }
}
