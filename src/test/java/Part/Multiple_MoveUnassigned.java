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

public class Multiple_MoveUnassigned extends Herd{


    @Test(priority = 0)
    public void moveUnassigned_To_Pen() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(8));
        WebDriverWait waitLoad=new WebDriverWait(driver,Duration.ofSeconds(80));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
        WebElement location = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
        String getLocationContent = location.getAttribute("content-desc");
        String[] locationContent = getLocationContent.split("\\r?\\n");
        System.out.println("Location name : "+locationContent[0]);
        Thread.sleep(3000);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
            element.click();
        } catch (StaleElementReferenceException ex) {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
            element.click();
        }

        Thread.sleep(2000);

        try{
            //unassigned tab
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Unassigned')])[2]"))).click();
        }
        catch (StaleElementReferenceException s){
            //unassigned tab
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Unassigned')])[2]"))).click();
        }
        //unassigned content
        WebElement unassignedContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Unassigned')])[3]")));
        String content2 = unassignedContent.getAttribute("content-desc");
        String[] lines2 = content2.split("\\r?\\n");
        System.out.println("No.of.tags : " + lines2[1]);
        String totalTag = lines2[1];

        if (Integer.parseInt(totalTag) > 2){
            unassignedContent.click();
        }
        else {
            System.out.println("create a new tag");
            //plus icon
            Thread.sleep(5000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

            //Add animal to inventory
            Thread.sleep(500);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

            //Manual Entry
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
            //Manual click
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
            //right arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
            Thread.sleep(200);

            //right arrow
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
            //right arrow
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
            //multiple tags toggle
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.Switch"))).click();
            //from enter
            WebElement fromEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='0']")));
            fromEnter.click();
            Thread.sleep(200);
            Random r = new Random();
            int rNumber = r.nextInt(400, 499);
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
                        int rNumber1 = r1.nextInt(400, 499);
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
                        int rNumber2 = r2.nextInt(0, 10);
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
            //add animals to inventory
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
            //yes
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
            //unAssigned tab
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Unassigned')])[2]"))).click();
           //unAssigned content
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[4]"))).click();
        }
        //menu dot
        Thread.sleep(200);
        wait. until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        //select animals-manual
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Select Animals - M')]"))).click();
        //select all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select All']"))).click();
        //quick actions
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Quick Actions']"))).click();
        //move to pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move to Pen / Pasture']"))).click();
        //confirm
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Confirm']"))).click();
        //select
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        try{
            //a pen
            WebElement penContent = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[17]")));
            String content = penContent.getAttribute("content-desc");
            String[] lines = content.split("\\r?\\n");
            if (penContent.isDisplayed()){
                penContent.click();
                System.out.println("PenName : " + lines[0]);
                System.out.println("Before move to PenTag count : " + lines[1]);
            }

        }
        catch (Exception e){
            //plus icon
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
            //add pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
            //enter add pasture
            WebElement enterPName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            enterPName.click();
            Thread.sleep(100);
            enterPName.sendKeys("Ninja");
            driver.hideKeyboard();
            //pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
            //save
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

            //try
            try {
                wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Added Successfully')]")));
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
                        editText.sendKeys("Ninja"+rNumber);
                        driver.hideKeyboard();

                        //pen
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
                        //save
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

                        try {
                            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Enclosure Name Already Exists')]")));
                        }catch (Exception e2){
                            addCondition = false;
                        }

                    }

                }
            }
            //pen content
            WebElement penContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[17]")));
            String content = penContent.getAttribute("content-desc");
            String[] lines = content.split("\\r?\\n");
            System.out.println("PenName : " + lines[0]);
            System.out.println("Before move to PenTag count : " + lines[1]);
            if (penContent.isDisplayed()){
                penContent.click();
            }
        }
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        //move
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move']"))).click();

        //pop up
        WebElement success = waitLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Successfully')]")));
        System.out.println(success.getAttribute("content-desc"));
        //pasture content
        WebElement penContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
        String content = penContent.getAttribute("content-desc");
        String[] lines = content.split("\\r?\\n");
        System.out.println("After move to PenTag count : " + lines[1]);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @Test(priority = 1)
    public void moveUnassigned_To_Pasture() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(8));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
        WebElement location = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
        String getLocationContent = location.getAttribute("content-desc");
        String[] locationContent = getLocationContent.split("\\r?\\n");
        System.out.println("Location name : "+locationContent[0]);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
            element.click();
        } catch (StaleElementReferenceException ex) {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
            element.click();
        }

        Thread.sleep(2000);

        try{
            //unassigned tab
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Unassigned')])[2]"))).click();
        }
        catch (Exception e){
            //unassigned tab
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Unassigned')])[2]"))).click();
        }
        //unassigned content
        WebElement unassignedContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Unassigned')])[3]")));
        String content2 = unassignedContent.getAttribute("content-desc");
        String[] lines2 = content2.split("\\r?\\n");
        System.out.println("No.of.tags : " + lines2[1]);
        String totalTag = lines2[1];

        if (Integer.parseInt(totalTag) > 2){
            unassignedContent.click();
        }
        else {
            System.out.println("create a new tag");
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
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
            //right arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
            Thread.sleep(200);

            //right arrow
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
            //right arrow
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
            //multiple tags toggle
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.Switch"))).click();
            //from enter
            WebElement fromEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='0']")));
            fromEnter.click();
            Thread.sleep(200);
            Random r = new Random();
            int rNumber = r.nextInt(400, 499);
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
                        int rNumber1 = r1.nextInt(400, 499);
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
                        int rNumber2 = r2.nextInt(0, 10);
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
            //add animals to inventory
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
            //yes
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
            //unAssigned tab
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Unassigned')])[2]"))).click();
            //unAssigned content
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[4]"))).click();
        }
        //menu dot
        Thread.sleep(200);
        wait. until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        //select animals-manual
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Select Animals - M')]"))).click();
        //select all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select All']"))).click();
        //quick actions
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Quick Actions']"))).click();
        //move to pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move to Pen / Pasture']"))).click();
        //confirm
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Confirm']"))).click();
        //select
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //pasture tab
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Pastures')]"))).click();
        try{
            //a pasture
            WebElement pastureContent = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[17]")));
            String content = pastureContent.getAttribute("content-desc");
            String[] lines = content.split("\\r?\\n");
            if (pastureContent.isDisplayed()){
                pastureContent.click();
                System.out.println("PastureName : " + lines[0]);
                System.out.println("Before move to PastureTag count : " + lines[1]);
            }

        }
        catch (Exception e){
            //plus icon
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
            //add pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
            //enter add pasture
            WebElement enterPName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            enterPName.click();
            Thread.sleep(100);
            enterPName.sendKeys("Ninja");
            driver.hideKeyboard();
            //pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pasture']"))).click();
            //save
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

            //try
            try {
                wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Added Successfully')]")));
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
                        editText.sendKeys("Ninja"+rNumber);
                        driver.hideKeyboard();

                        //pasture
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pasture']"))).click();
                        //save
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

                        try {
                            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Enclosure Name Already Exists')]")));
                        }catch (Exception e2){
                            addCondition = false;
                        }

                    }

                }
            }
            //pasture content
            WebElement pastureContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[17]")));
            String content = pastureContent.getAttribute("content-desc");
            String[] lines = content.split("\\r?\\n");
            System.out.println("PastureName : " + lines[0]);
            System.out.println("Before move to PastureTag count : " + lines[1]);
            if (pastureContent.isDisplayed()){
                pastureContent.click();
            }
        }
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        //move
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move']"))).click();

        //pop up
        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Successfully')]")));
        System.out.println(success.getAttribute("content-desc"));
        //pasture content
        WebElement pastureContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
        String content = pastureContent.getAttribute("content-desc");
        String[] lines = content.split("\\r?\\n");
        System.out.println("After move to PastureTag count : " + lines[1]);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
