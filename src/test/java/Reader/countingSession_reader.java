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

public class countingSession_reader extends  Herd{


    @Test(priority = 0)
    public void countingSession() throws InterruptedException, IOException {

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));

        String path="C:\\Users\\E-7\\IdeaProjects\\HerdX\\src\\main\\resources\\Reader.properties";
        FileInputStream file=new FileInputStream(path);
        Properties pro=new Properties();
        pro.load(file);

    //counting session
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Counting Sessions')]"))).click();
    //plus icon
        Thread.sleep(10000);
    WebElement display = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']")));
        display.click();
        Thread.sleep(5000);
        try {
        if (driver.findElement(By.xpath("//android.widget.ImageView[@index='2']")).isDisplayed()) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        }

    } catch (Exception e) {
        e.getMessage();
    }

    //enter counting name
    WebElement enterName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterName.click();
        Thread.sleep(200);
        enterName.sendKeys("sample");

    //select pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
    //bull2
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull2')]"))).click();
    //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Done')]"))).click();

    //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();

    //herdView readers
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'HerdView Readers')]"))).click();
//        WebElement reader = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'HerdView Readers')]")));
//        try {
//            System.out.println(reader.isSelected());
//            if (reader.isSelected()){
//
//                System.out.println(reader.isSelected());
//            }
//            else {
//                reader.click();
//            }
//        }
//        catch (Exception e){
//            System.out.println(" ");
//        }
    //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

        Thread.sleep(5000);
    //reader
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'good now')]//android.widget.ImageView[@index='0']"))).click();

        //reader
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'"+pro.getProperty("countingSessionReader")+"')]//android.widget.ImageView[@index='0']"))).click();

    //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='5'])[2]"))).click();

    //no
        try {
        driver.findElement(By.xpath("//*[@content-desc='No']")).click();
    } catch (Exception e) {
        e.getMessage();
    }
    //scan
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Scan']"))).click();

        Thread.sleep(100);
    //scan stop
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='7'])[2]"))).click();
    //confirm tag
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Confirm Tags']"))).click();
    // next

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();

    //issues tag

    WebElement screen = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]")));
        try {
        for (int i = 1; i >= 0; i++) {

            if (screen.isDisplayed()) {
                screen.click();
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Mark as scanned' or @content-desc='Add to Counting Session']"))).click();
            } else {
                break;
            }
        }

    } catch (Exception e) {
        e.getMessage();
    }

    //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
    //finalize
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Finalize Session']"))).click();
    //no finalize
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='No,Finalize The Session']"))).click();
    //incomplete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Show Incomplete Sessions']"))).click();
    //search bar
    WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']")));
        enter.click();
        enter.sendKeys("sample");
    //sample content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'sample')]"))).click();
}
}
