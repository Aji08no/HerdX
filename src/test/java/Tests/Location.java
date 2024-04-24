package Tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Location extends Herdx{



    @Test(priority = 0)
    public void createLocation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //settings
        driver.findElement(By.xpath("//*[@content-desc='Settings']")).click();
        //manage sites
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Manage Sites']")).click();
        //add icon
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='2']")).click();
        //enter name
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement name = wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        name.click();
        name.sendKeys("B test");
        //enter mail
        WebElement mail = driver.findElement(By.xpath("//android.widget.EditText[@index='3']"));
        mail.click();
        mail.sendKeys("qaqc11no2022@gmail.com");
        //address
        WebElement address = driver.findElement(By.xpath("//android.widget.EditText[@index='5']"));
        address.click();
        address.sendKeys("UD");
        driver.hideKeyboard();
        //state
        driver.findElement(By.xpath("//*[@content-desc='Select']")).click();
        //select maryland
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Maryland']"))).click();
        //back arrow
        driver.findElement(By.xpath("//android.widget.ImageView[1]")).click();
        //city
        WebElement city = driver.findElement(By.xpath("//android.widget.EditText[@index='9']"));
        city.click();
        city.sendKeys("Tuty");
        driver.hideKeyboard();
        //zip code
        Thread.sleep(2000);
        WebElement zipCode = driver.findElement(By.xpath("//android.widget.EditText[@index='8']"));
        zipCode.click();
        zipCode.sendKeys("08110");
        driver.hideKeyboard();
        //sava
        driver.findElement(By.xpath("//*[@content-desc='Save']")).click();
        //search location
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchLocation = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']")));
        searchLocation.click();
        searchLocation.sendKeys("B test");
        driver.hideKeyboard();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));


        //search location
//        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement searchLocation1 = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']")));
//        searchLocation1.click();
//        searchLocation1.sendKeys("B test");

    }

    @Test(priority = 1)
    public void editLocation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //settings
        driver.findElement(By.xpath("//*[@content-desc='Settings']")).click();
        //manage sites
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Manage Sites']")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchLocation = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']")));
        searchLocation.click();
        searchLocation.sendKeys("B test");
        //edit location menu
        WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //edit location
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Edit Location']")).click();
        //edit address
        Thread.sleep(1000);
        WebElement editAddress = driver.findElement(By.xpath("//android.widget.EditText[@index='5']"));
        editAddress.click();
        editAddress.clear();
        editAddress.sendKeys("Tvl");
        driver.hideKeyboard();
        //sava
        driver.findElement(By.xpath("//*[@content-desc='Save']")).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
//        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }
    @Test(priority = 2,enabled = false)
    public void deleteLocation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //settings
        driver.findElement(By.xpath("//*[@content-desc='Settings']")).click();
        //manage sites
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Manage Sites']")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchLocation = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']")));
        searchLocation.click();
        searchLocation.sendKeys("B test");
        //delete location menu
        WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //delete location
        driver.findElement(By.xpath("//*[@content-desc='Delete Location']")).click();
        //delete
        driver.findElement(By.xpath("//*[@content-desc='Delete']")).click();

        Thread.sleep(1000);
        //cancel icon
        driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
        //manage sites
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Manage Sites']")).click();
        //search location
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchLocation1 = wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']")));
        searchLocation1.click();
        searchLocation1.sendKeys("B test");

    }

}
