package Tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Pens_Pastures extends Herdx{

    @Test(priority = 2,enabled = false)
    public void createPens() throws InterruptedException {
        //Total Animals
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        //plus icon
        Thread.sleep(3000);
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[4]"))).click();
        //Add pen/pastures
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@content-desc='Add Pen / Pasture']")).click();
        //Enter name
        Thread.sleep(2000);
        WebElement enterName = driver.findElement(By.xpath("//android.widget.EditText[@index='2']"));
        enterName.click();
        enterName.sendKeys("bull1");
        //select pen
        driver.findElement(By.xpath("//*[@content-desc='Pen']")).click();
        //save
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@content-desc='Save']")).click();
        //verifyPage
//        WebElement verify = driver.findElement(By.xpath("//*[@content-desc='Add New Pen / Pasture']"));
//        boolean penVerify = verify.isDisplayed();
//        System.out.println(penVerify);
//         if(penVerify){
//             System.out.println("pen create is failed");
//             driver.pressKey(new KeyEvent(AndroidKey.BACK));
//         }
//         else {
//             System.out.println("pen is successfully create");
//         }
//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Pasture')]")));
//        List<WebElement> element = driver.findElements(By.xpath("//*[contains(@content-desc,'Total A')]"));
//        for(WebElement ele:element){
//            if(ele.isDisplayed()){
//
//            }
//        }
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }


    @Test(priority = 1,enabled = false)
    public void createPasture() throws InterruptedException {
        //plus icon
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[4]")).click();
        //Add pen/pastures
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@content-desc='Add Pen / Pasture']")).click();
        //Enter name
        WebElement enterName = driver.findElement(By.xpath("//android.widget.EditText[@index='2']"));
        enterName.click();
        enterName.sendKeys("Bull");
        //select pen
        driver.findElement(By.xpath("//*[@content-desc='Pasture']")).click();
        //save
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@content-desc='Save']")).click();
        WebElement verify = driver.findElement(By.xpath("//*[@content-desc='Add New Pen / Pasture']"));
        boolean pastureVerify = verify.isDisplayed();
        System.out.println(pastureVerify);
        if(pastureVerify){
            System.out.println("pasture create is failed");
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }
        else {
            System.out.println("Pasture create is successfully");
        }
    }

    @Test(priority = 3,enabled = false)
    public void deletePens() throws InterruptedException {

//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//*[contains(@content-desc,'Pens')]")).click();
        //dot menu
        Thread.sleep(3000);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull')]//*[@index='0']"))).click();
        //delete pen/pasture
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Delete')]")).click();
        //confirm delete
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Delete']")).click();
    }
    @Test(priority = 2,enabled = false)
    public void deletePastures() throws InterruptedException {
        //Total Animals
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        //pasture tab
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Pastures')]")).click();
        //dot menu
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Bull')]//*[@index='0']")).click();
        //delete pen/pasture
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Delete')]")).click();
        //confirm delete
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Delete']")).click();
    }

    @Test(priority = 3,enabled = false)
    public void editPens() throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Pens')]")).click();
        //dot menu
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'bull')]//*[@index='0']")).click();
        //Edit
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Edit')]")).click();
        //enterName
        Thread.sleep(3000);
        WebElement enterValue = driver.findElement(By.className("android.widget.EditText"));
        enterValue.click();
        enterValue.clear();
        enterValue.sendKeys("Cow1");
        driver.hideKeyboard();
        //save
        driver.findElement(By.className("android.widget.Button")).click();
    }

    @Test(priority = 2,enabled = false)
    public void editPasture() throws InterruptedException {

        //pasture tab
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Pastures')]")).click();
        //dot menu
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Bull')]//*[@index='0']")).click();
        //Edit
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Edit')]")).click();
        //enterName
        Thread.sleep(3000);
        WebElement enterValue = driver.findElement(By.className("android.widget.EditText"));
        enterValue.click();
        enterValue.clear();
        enterValue.sendKeys("Cow");
        driver.hideKeyboard();
        //save
        driver.findElement(By.className("android.widget.Button")).click();
    }

//    @Test
    public void addAnimalPen() throws InterruptedException {
        //Total Animals
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        Thread.sleep(5000);
        //plus icon
        driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[4]")).click();

        Thread.sleep(3000);
        //Add animal to inventory
        driver.findElement(By.xpath("//*[@index='0' and @class='android.widget.ImageView']")).click();

        Thread.sleep(2000);
        //Manual Entry
        driver.findElement(By.xpath("//*[@index='7']")).click();
        //Manual click
        Thread.sleep(4000);
        //Right Arrow
        driver.findElement(By.xpath("(//*[@index=3])[2]")).click();
        //Click pen/pasture
        driver.findElement(By.xpath("//*[@content-desc='Pen / Pasture']")).click();
        //Right Arrow
        driver.findElement(By.xpath("(//*[@index=3])[2]")).click();
        //EPC Prefix
        driver.findElement(By.xpath("//*[@content-desc='Select']")).click();
        Thread.sleep(1000);
        //EPC Prefix dropdown select
        driver.findElement(By.xpath("(//*[@index='1'])[1]")).click();
        //select
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//android.widget.Button)[3]")).click();
        Thread.sleep(1000);
        //select dropDown
        driver.findElement(By.xpath("//*[@index='3']")).click();
        //enter tag
        WebElement out = driver.findElement(By.xpath("(//*[@index='1'])[3]"));
        out.click();
        out.sendKeys("2802");
        //pen/pasture
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
        //select enclosure
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Cow1')]")).click();
        //done
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Done']")).click();
        //save
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@content-desc='Save']")).click();
        //view summary
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@content-desc='View Summary']")).click();
        //add Animals to inventory
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@content-desc='Add Animals to Inventory']")).click();
        //yes
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Yes']")).click();
        //pen enclosure cow1
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Cow1')]")).click();
        //select add tag
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'2802')]")).click();

       //back arrow
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//android.widget.ImageView[@index='0'])[1]")).click();
        //tag menu
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'2802')]//*[@index='1']")).click();
        //move to pen /pasture
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Move to Pen / Pasture']")).click();
        //select
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Select']")).click();
        //pasture tag
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Pastures')]")).click();
        //enclosure cow
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Cow')]//*[@index='0']")).click();
        //done
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Done']")).click();
        //move
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Move']")).click();
        //pasture tag
        Thread.sleep(12000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Pastures')]")).click();
        //enclosure cow
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Cow')]")).click();
    }

    //@Test
    public void addAnimalPasture() throws InterruptedException {
        //Total Animals
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        Thread.sleep(8000);
        //plus icon
        driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[4]")).click();

        Thread.sleep(3000);
        //Add animal to inventory
        driver.findElement(By.xpath("//*[@index='0' and @class='android.widget.ImageView']")).click();

        Thread.sleep(2000);
        //Manual Entry
        driver.findElement(By.xpath("//*[@index='7']")).click();
        //Manual click
        Thread.sleep(4000);
        //Right Arrow
        driver.findElement(By.xpath("(//*[@index=3])[2]")).click();
        //Click pen/pasture
        driver.findElement(By.xpath("//*[@content-desc='Pen / Pasture']")).click();
        //Right Arrow
        driver.findElement(By.xpath("(//*[@index=3])[2]")).click();
        //EPC Prefix
        driver.findElement(By.xpath("//*[@content-desc='Select']")).click();
        Thread.sleep(1000);
        //EPC Prefix dropdown select
        driver.findElement(By.xpath("(//*[@index='1'])[1]")).click();
        //select
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//android.widget.Button)[3]")).click();
        Thread.sleep(1000);
        //select dropDown
        driver.findElement(By.xpath("//*[@index='3']")).click();
        //enter tag
        WebElement out = driver.findElement(By.xpath("(//*[@index='1'])[3]"));
        out.click();
        Thread.sleep(1000);
        out.sendKeys("2808");
        //pen/pasture
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
        //pasture tab
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Pasture')]")).click();
        Thread.sleep(2000);
        //select enclosure
        driver.findElement(By.xpath("//*[contains(@content-desc,'Cow')]")).click();
        //done
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Done']")).click();
        //save
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@content-desc='Save']")).click();
        //view summary
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@content-desc='View Summary']")).click();
        //add Animals to inventory
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@content-desc='Add Animals to Inventory']")).click();
        //yes
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Yes']")).click();
        //pen enclosure cow1
        Thread.sleep(10000);
        //pasture tab
        driver.findElement(By.xpath("//*[contains(@content-desc,'Pasture')]")).click();
        Thread.sleep(2000);
        //select enclosure
        driver.findElement(By.xpath("//*[contains(@content-desc,'Cow')]")).click();
        //select add tag
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'2808')]")).click();
        //back arrow
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//android.widget.ImageView[@index='0'])[1]")).click();
        //tag menu
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'2808')]//*[@index='1']")).click();
        //move to pen /pasture
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Move to Pen / Pasture']")).click();
        //select
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Select']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Cow')]//*[@index='0']")).click();
        //done
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Done']")).click();
        //move
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Move']")).click();
        //pasture tag
        Thread.sleep(18000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Pasture')]")).click();
        //Pens tab
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Pens')]")).click();
        //enclosure cow
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@content-desc,'Cow')]")).click();
    }

    @Test
    public void moveAndCreatePen() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        //Total Animals

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]"))).click();
        //unassigned content
        Thread.sleep(10000);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Un')]"))).click();
        //tag menu
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'28')]//*[@index='1']"))).click();
        //move to pen /pasture
        Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@content-desc='Move to Pen / Pasture']")).click();
//        //select
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@content-desc='Select']")).click();
//        //plus icon
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//android.widget.ImageView[@index='2']")).click();
//        //add pen / pasture
//        driver.findElement(By.xpath("//*[@content-desc='Add Pen / Pasture']")).click();
//        //Enter name
//        WebElement enterName = driver.findElement(By.xpath("//android.widget.EditText[@index='2']"));
//        enterName.click();
//        enterName.sendKeys("Bull");
//        //select pen
//        driver.findElement(By.xpath("//*[@content-desc='Pen']")).click();
//        //save
//        driver.hideKeyboard();
//        driver.findElement(By.xpath("//*[@content-desc='Save']")).click();
//        //create enclosure
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//*[contains(@content-desc,'Bull')]//*[@index='0']")).click();
//        //done
//        driver.findElement(By.xpath("//*[@content-desc='Done']")).click();
//        //cancel icon
//        driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();

    }
}