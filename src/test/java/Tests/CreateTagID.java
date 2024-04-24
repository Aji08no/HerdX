package Tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateTagID extends Herdx{
    WebDriverWait wait;

    @BeforeClass
    public void homePage() throws InterruptedException {

        Thread.sleep(5000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement location = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
//        WebElement location = driver.findElement(By.xpath("//*[@content-desc='Abi test']"));
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
            public void tagId () throws InterruptedException {
                WebElement totalAnimals = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
                //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
                totalAnimals.click();
                Thread.sleep(8000);
                //plus icon
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[1]"))).click();

                //Add animal to inventory
                Thread.sleep(500);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

                //Manual Entry
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
                //Manual click
                Thread.sleep(4000);
                //Click Treatment
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatments']"))).click();
//right arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

                //treatment
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add']"))).click();


//                // select treatment
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatment']//*[@class='android.widget.ImageView']"))).click();
                //select treatment type content
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Type']"))).click();
                //select treatment type
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Antibiotics']"))).click();
                //back arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
                //next
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
                //medicine Plus icon
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView)[8]"))).click();
                //Select medicine
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Medicine']"))).click();
                //select painkiller
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'pain')]"))).click();
                //back arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
                //amount
                WebElement enterAmount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='12']")));
                enterAmount.click();
                enterAmount.sendKeys("4");
                javaUtility.hideKeyBoard();
                //duration
                WebElement enterDuration = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
                enterDuration.click();
                enterDuration.sendKeys("2");
                javaUtility.hideKeyBoard();
                //save
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
                int next=5;
                for(int i=0;i < next;i++){
                    Thread.sleep(50);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
                }
                //next
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
//                //next
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
//                //next
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
//                //next
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
//                //pop up next
//                Thread.sleep(100);
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();

                //right arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
                //pen/pasture
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen / Pasture']"))).click();
                //right arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
                //EPC Prefix
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
                //EPC Prefix dropdown select
                Thread.sleep(500);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[1]"))).click();
                //select
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[3]"))).click();
                //select dropDown
                Thread.sleep(100);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='3']"))).click();
                //enter tag
                Thread.sleep(500);
                WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                enter.click();
                enter.sendKeys("2804");
                //select pen/pasture
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();
                //select pen
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull2')]"))).click();
                //done
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

            }
            @Test(priority = 1,enabled = true)
            public void tagIdSecond() throws InterruptedException {
                //add tag second
                Thread.sleep(500);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Tap to scan Animals')]"))).click();
                //EPC Prefix
                Thread.sleep(100);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
                //EPC Prefix dropdown select
                Thread.sleep(100);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[1]"))).click();
                //select
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[3]"))).click();
                //select dropDown
                Thread.sleep(100);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='3']"))).click();

                //enter
                WebElement enter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                enter2.click();
                enter2.sendKeys("2818");

                //select pen/pasture
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
                //pasture
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[contains(@content-desc,'Pasture')]")).click();
                //select bull
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Bull')]"))).click();
                //done
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
                //save
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
                //view summary
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']"))).click();
                //add animals to inventory
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
                //yes
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
            }

            @Test(priority = 2)
            public void verifyAddTagId(){
                //pens bull2
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull')]"))).click();
                //back arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
                //pastures
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Pasture')])[3]"))).click();
                //pastures bull
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Bull')]"))).click();

            }
        }

