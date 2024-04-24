package Common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaUtility {

    AndroidDriver driver;
    public JavaUtility(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


//    public static AndroidDriver driver;
//    public static void setDriver(AndroidDriver driver) {
//        JavaUtility.driver = driver;
//    }

    public  void explicitWaitXpath(String elementor){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementor)));
    }

    public WebElement explicitWait(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement icon = wait.until(ExpectedConditions.visibilityOf(element));
        return icon;
    }
    public void hideKeyBoard(){

        driver.hideKeyboard();
    }

}
