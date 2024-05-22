package Part;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class MultipleAddToInventory3 extends Herd{

    @Test
    public void withoutCommonAndSpecificInfo() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(5));

        Thread.sleep(5000);
        WebElement totalAnimals = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
        //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        totalAnimals.click();

        //unassigned tab
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Unassigned')])[2]"))).click();

        //unassigned content
        WebElement beforeContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[4]")));
        String getWordBefore = beforeContent.getAttribute("content-desc");
        String[] beforeTagCount = getWordBefore.split("\\r?\\n");
        System.out.println("Before added no.of.tags : "+beforeTagCount[1]);

        try {
            Thread.sleep(3000);
            // plus icon
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
            element.click();
        } catch (StaleElementReferenceException ex) {
            //plus icon
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
            element.click();
        }
        //Add animal to inventory
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

        //Manual Entry
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
        //Manual click
        // Right Arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index=3])[2]"))).click();
        Thread.sleep(200);
        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

        try{
            //EPC Prefix
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'No tags assigned to this organization')]")));
            System.out.println("No tags assigned to this organization! Please contact HerdX support.");
            //back arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

            //close pop up
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Close']"))).click();
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        } catch (Exception e) {
            e.getMessage();
        }

        //EPC Prefix
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //EPC Prefix dropdown select
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='E26878434']"))).click();
        //select
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[3]"))).click();
        //select dropDown
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='99977149481']"))).click();
        //multiple tags toggle
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.Switch"))).click();
        //from enter
        WebElement fromEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='0']")));
        fromEnter.click();
        Thread.sleep(200);
        Random r = new Random();
        int rNumber = r.nextInt(200, 299);
        Thread.sleep(200);
        fromEnter.sendKeys(rNumber+"0");

        //try  pop up this tag is already existing
        try {
            boolean condition = false;

            while (!condition){
                try{
                    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='This Tag Already Exists In Your Inventory ']")));
                    //from enter
                    WebElement fromEnter1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='0']")));
                    fromEnter1.click();
                    Thread.sleep(200);
                    fromEnter1.clear();
                    Random r1 = new Random();
                    int rNumber1 = r1.nextInt(200, 299);
                    Thread.sleep(200);
                    fromEnter1.sendKeys(rNumber1+"0");
                }
                catch (Exception e){
                    condition = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //get text
        Thread.sleep(2000);
        WebElement fromEnterValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='0']")));
        String toEnter = fromEnterValue.getText().substring(0, 3);


        //to enter
        try {
            boolean condition = false;

            while (!condition){
                //view summary
                WebElement viewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']")));
                String summary = viewButton.getAttribute("enabled");
                if (summary.equals("false")) {
                    //enter tag
                    Thread.sleep(500);
                    WebElement enter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='1']")));
                    enter2.click();
                    enter2.clear();
                    Random r2 = new Random();
                    int rNumber2 = r2.nextInt(1, 10);
                    Thread.sleep(200);
                    enter2.sendKeys(toEnter + rNumber2);
                } else {
                    condition = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //tags count 54
        WebElement tagsCount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[11]")));
        String pageContent = tagsCount.getAttribute("content-desc");
        String[] line = pageContent.split("\\r?\\n");
        String createTags = line[3];
        System.out.println("No.of created tags : "+createTags);
        //view summary
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']"))).click();

        Thread.sleep(500);
        //add animals to inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
        //yes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();

        //created pop up
        WebDriverWait loadWait=new WebDriverWait(driver,Duration.ofSeconds(60));
        loadWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Successfully')]")));
        System.out.println("created successfully");

        //unassigned tab
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Unassigned')])[2]"))).click();

        //unassigned content
        WebElement afterContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[4]")));
        String getWordAfter = afterContent.getAttribute("content-desc");
        String[] afterTagCount = getWordAfter.split("\\r?\\n");
        System.out.println("After added no.of.tags : "+afterTagCount[1]);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
