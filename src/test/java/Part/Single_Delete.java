package Part;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Single_Delete extends Herd{
    String deleteID="";
    String PenName="";
    String transferPenName="";
    WebDriverWait wait;
    WebDriverWait wait1;
    WebDriverWait loadWait;

    @Test(priority = 0)
    public void deletePenTagID() throws InterruptedException {
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait1=new WebDriverWait(driver, Duration.ofSeconds(5));

        Thread.sleep(1000);
        //total animals
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Anima')]"))).click();
        try{
            Thread.sleep(3000);
            //pens content
            WebElement penContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
            String content2 = penContent.getAttribute("content-desc");
            String[] lines2 = content2.split("\\r?\\n");
            System.out.println("penName : " + lines2[0]);
            PenName=lines2[0];
            if (penContent.isDisplayed()){
                System.out.println("Tags are in a page");
            }
        }
        catch (Exception e){
            //plus icon
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
            //add pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
            //enter add pasture
            WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            enter.click();
            Thread.sleep(100);
            PenName="Cartoon";
            enter.sendKeys(PenName);

            driver.hideKeyboard();
            //pen
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
            //save
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
            //try
            try {
                wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Added Successfully')]")));
                System.out.println("penName : "+PenName);
            }
            catch (Exception e1){
                boolean addCondition = true;
                while (addCondition){
                    WebElement editText = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
                    if (editText.isDisplayed()){
                        editText.click();
                        Thread.sleep(200);
                        editText.clear();
                        Random r=new Random();
                        int rNumber = r.nextInt(0, 99);
                        Thread.sleep(100);
                        PenName="Cartoon"+rNumber;
                        editText.sendKeys(PenName);
                        driver.hideKeyboard();

                        //pasture
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
                        //save
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

                        try {
                            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Enclosure Name Already Exists')]")));
                        }catch (Exception e2){
                            System.out.println("penName : "+PenName);
                            addCondition = false;
                        }

                    }

                }
            }
        }
//            //pen content
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[17]"))).click();

        Thread.sleep(200);
        //pen tag
        WebElement penContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
        String content2 = penContent.getAttribute("content-desc");
        String[] lines2 = content2.split("\\r?\\n");
        String totalTag = lines2[1];

        if (Integer.parseInt(totalTag) > 0){
            System.out.println("Before deleted a tag count : "+totalTag);
            penContent.click();
        }
        else {

            System.out.println("Create a new tag");
            //plus icon
            Thread.sleep(5000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

            //Add animal to inventory
            Thread.sleep(500);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

            //Manual Entry
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
            //Manual click
            Thread.sleep(1000);
            //click pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen / Pasture']"))).click();
            //right arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
            //select pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();
            //select pen
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]"))).click();
            //done
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
            //right arrow
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
            //right arrow
            Thread.sleep(200);
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
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
            //EPC Prefix dropdown select
            Thread.sleep(500);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='E26878434']"))).click();
            //select
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[3]"))).click();
            //select dropDown
            Thread.sleep(100);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='99977149481']"))).click();
            //enter tag
            Thread.sleep(500);

//            WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
//            enter.click();
//            Random r = new Random();
//            int rNumber = r.nextInt(100, 999);
//            enter.sendKeys("2" + rNumber);
//            driver.hideKeyboard();
//            Thread.sleep(1500);

            try {
                boolean condition = false;
                while (!condition){
                    try{
                        WebElement viewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']")));
                        String summeryview = viewButton.getAttribute("enabled");
                        if (summeryview.equals("false")){
                            //enter tag
                            Thread.sleep(500);
                            WebElement enter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                            enter2.click();
                            enter2.clear();
                            Random r2 = new Random();
                            int rNumber2 = r2.nextInt(100, 999);
                            enter2.sendKeys("2" + rNumber2);
                            driver.hideKeyboard();

                        }else {
                            //view summary
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='View Summary']"))).click();
                            //add animals to inventory
                            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
                            //yes
                            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
                            //pen
                            WebElement content = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
                            String getTagContent = content.getAttribute("content-desc");
                            String[] getTagCount = getTagContent.split("\\r?\\n");
                            System.out.println("Before deleted a tag count : "+getTagCount[1]);
                            content.click();
                            condition=true;
                        }
                    }
                    catch (Exception e){
                        e.getMessage();
                    }
                }
            }
            catch (Exception e1) {
                e1.getMessage();
            }
        }
        //tag details
        Thread.sleep(3000);
        WebElement tagD = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]")));
        String TagValue="";
        try {
            String tagValue = tagD.getAttribute("content-desc");
            TagValue=tagValue;
        }
        catch (StaleElementReferenceException s){
            String tagValue = tagD.getAttribute("content-desc");
            TagValue=tagValue;
        }
//        System.out.println(tagD.getAttribute("content-desc"));
        Thread.sleep(200);
        String[] line = TagValue.split(" ");
        Thread.sleep(500);
        String deleteTag = line[1].substring(0,5);
        deleteID=deleteTag;

        //tag menu dot
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]//android.widget.ImageView[@index='1']"))).click();
        //delete inventory
        try {
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete From Inventory']"))).click();
        }
        catch (Exception e){

            System.out.println("Tags are under transfer status");
            //back arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
            //back arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

            //plus icon create pen
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
            //add pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
            //enter add pasture
            Random ran=new Random();
            int outR = ran.nextInt(0,10);
            WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            enter.click();
            String penName = "0aa"+outR;
            transferPenName=penName;
            Thread.sleep(200);
//            enter.sendKeys(transferPenName);
            enter.sendKeys(penName);
            driver.hideKeyboard();
            //pen
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
            //save
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
            //try
            try {
                wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Added Successfully')]")));
                System.out.println("penName : "+transferPenName);
            }
            catch (Exception e1){
                boolean addCondition = true;
                while (addCondition){
                    WebElement editText = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
                    if (editText.isDisplayed()){
                        editText.click();
                        Thread.sleep(200);
                        editText.clear();
                        Random r=new Random();
                        int rNumber = r.nextInt(0, 99);
                        Thread.sleep(100);
                        String penName2 = "0aa"+outR;
                        transferPenName=penName2;
                        Thread.sleep(200);
//                        enter.sendKeys(transferPenName);
                        enter.sendKeys(penName2);
                        driver.hideKeyboard();

                        //pasture
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
                        //save
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

                        try {
                            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Enclosure Name Already Exists')]")));
                        }catch (Exception e2){
                            System.out.println("penName : "+transferPenName);
                            addCondition = false;
                        }

                    }

                }
            }
            //plus icon create inventory
            Thread.sleep(5000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

            //Add animal to inventory
            Thread.sleep(500);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

            //Manual Entry
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
            //Manual click
            Thread.sleep(1000);
            //click pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen / Pasture']"))).click();
            //right arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

            //select pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();
            //select pen
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]"))).click();
            //done
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
            //right arrow
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
            //right arrow
            Thread.sleep(200);
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
            } catch (Exception e1) {
                e1.getMessage();
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
            //enter tag
            Thread.sleep(500);
            try {
                boolean condition = false;
                while (!condition){
                    try{
                        WebElement viewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']")));
                        String summeryview = viewButton.getAttribute("enabled");
                        if (summeryview.equals("false")){
                            //enter tag
                            Thread.sleep(500);
                            WebElement enter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                            enter2.click();
                            enter2.clear();
                            Random r2 = new Random();
                            int rNumber2 = r2.nextInt(100, 999);
                            enter2.sendKeys("2" + rNumber2);
                            driver.hideKeyboard();

                        }else {
                            //view summary
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='View Summary']"))).click();
                            //add animals to inventory
                            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
                            //yes
                            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
                            //pen
                            WebElement content = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
                            String getTagContent = content.getAttribute("content-desc");
                            String[] getTagCount = getTagContent.split("\\r?\\n");
                            System.out.println("Before deleted a tag count : "+getTagCount[1]);
                            content.click();
                            condition=true;
                        }
                    }
                    catch (Exception e2){
                        e2.getMessage();
                    }
                }
            }
            catch (Exception e1) {
                e1.getMessage();
            }
            //tag details
            Thread.sleep(500);
            WebElement tagD1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]")));
            String tagValue1 = tagD1.getAttribute("content-desc");
//        System.out.println(tagD.getAttribute("content-desc"));
            Thread.sleep(200);
            String[] line1 = tagValue1.split(" ");
            String deleteTag1 = line1[1].substring(0,5);
            deleteID=deleteTag1;
            //menu dot
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index=0])[14]//android.widget.ImageView[@index='1']"))).click();
            //delete inventory
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete From Inventory']"))).click();

        }

        Thread.sleep(1000);
        //accident scan
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Accidental Scan']"))).click();
        Thread.sleep(200);
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();

        try{
            WebElement nextButton = driver.findElement(By.xpath("//*[@content-desc='Next']"));
            //accident scan
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Accidental Scan']"))).click();
            Thread.sleep(200);
            //next
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();

        }
        catch (Exception e){
            e.getMessage();
        }

            //delete
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']")));

        Thread.sleep(200);
        try {
            //delete
            driver.findElement(By.xpath("//*[@content-desc='Delete']")).click();
        }
        catch (StaleElementReferenceException s){
            s.getMessage();
        }

        try {
            WebElement deleteButton =driver.findElement(By.xpath("//*[@content-desc='Delete']"));
            if (deleteButton.isDisplayed()){
                Thread.sleep(200);
                deleteButton.click();
            }
        }
        catch (Exception e){
            e.getMessage();
        }

        loadWait=new WebDriverWait(driver,Duration.ofSeconds(50));

//        Thread.sleep(5000);
        try{
            loadWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));

            //pop up
            WebElement success = loadWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@content-desc,'Deleted')])[2]")));
            System.out.println(success.getAttribute("content-desc"));
            }
        catch (Exception e) {
            //back arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        }
        System.out.println("Deleted TagID :"+deleteID);
    }

    @Test(priority = 1)
    public void deleteVerify() throws InterruptedException {

        //pens content
        WebElement penContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
        String content2 = penContent.getAttribute("content-desc");
        String[] lines2 = content2.split("\\r?\\n");
        String actual=lines2[0];
        String totalTag = lines2[1];
        System.out.println("After deleted a tag count : "+totalTag);

        if(actual.equals(PenName)){
            if (Integer.parseInt(totalTag) > 0) {
                penContent.click();
                Thread.sleep(200);
                //search enter
                Thread.sleep(200);
                WebElement sEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
                Thread.sleep(200);
                sEnter.click();
                Thread.sleep(200);
                sEnter.sendKeys(deleteID);
                driver.hideKeyboard();
                //tag details
                Thread.sleep(200);
                WebElement tagD = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[15]")));
                String tagValue = tagD.getAttribute("content-desc");

                String[] lines = tagValue.split("\\r?\\n");
                String actualTagId = lines[0];
                Assert.assertEquals(actualTagId,"No Results Found");
                System.out.println(actualTagId);

                //back arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

                driver.pressKey(new KeyEvent(AndroidKey.BACK));
            }
            else {
                Assert.assertEquals(Integer.parseInt(totalTag),0);
                System.out.println("Verified Successfully");
            }
        }

    }
}
