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
import org.testng.annotations.Test;

import java.time.Duration;

public class Location extends Herd{
    @Test(priority = 0)
    public void negativeCreateLocation() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        Thread.sleep(8000);
        //menu bar icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //setting
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Settings']"))).click();
        //manage sites
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Manage Sites']"))).click();
        //add icon
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //enter name
        WebElement name = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        name.click();
        name.sendKeys("Abi test");
        //enter mail
        WebElement mail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
        mail.click();
        mail.sendKeys("qa11no20@gmail.com");
        //address
        WebElement address = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        address.click();
        address.sendKeys("UD");
        driver.hideKeyboard();
        //state
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //select California
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='California']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[1])[1]"))).click();
        //city
        WebElement city = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='9']")));
        city.click();
        city.sendKeys("Tuty");
        driver.hideKeyboard();

        TouchAction touchAction=new TouchAction<>(driver);
        touchAction.press(PointOption.point(478,1921))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(496,1610))
                .release()
                .perform();
        //zip code

        WebElement zipCode = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));
        zipCode.click();
        zipCode.sendKeys("08110");
        driver.hideKeyboard();
        //sava
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @Test(priority = 1)
    public void negativeEditLocation() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));

        //manage sites
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Manage Sites']"))).click();
        //location content (//android.view.View[@index='0'])[11]//android.widget.ImageView[@index=0]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[11]//android.widget.ImageView[@index=0]"))).click();
        //edit location
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Edit Location']"))).click();
        //enter name
        WebElement name = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        name.click();
        Thread.sleep(200);
        name.clear();
        name.sendKeys("A test");
        //enter mail
        WebElement mail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
        mail.click();
        mail.clear();
        mail.sendKeys("qa11no20@gmail.com");
        //address
        WebElement address = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        address.click();
        address.clear();
        address.sendKeys("UD");
        driver.hideKeyboard();
        //state
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='District of Columbia']"))).click();
        //select California
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='California']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[1])[1]"))).click();
        //city
        WebElement city = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='9']")));
        city.click();
        city.clear();
        city.sendKeys("Tuty");
        driver.hideKeyboard();

        TouchAction touchAction=new TouchAction<>(driver);
        touchAction.press(PointOption.point(478,1921))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(496,1610))
                .release()
                .perform();
        //zip code

        WebElement zipCode = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));
        zipCode.click();
        zipCode.clear();
        zipCode.sendKeys("08110");
        driver.hideKeyboard();
        //sava
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }
}
