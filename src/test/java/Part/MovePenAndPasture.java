package Part;

import io.appium.java_client.AppiumBy;
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

public class MovePenAndPasture extends Herd {

    //    @BeforeClass
    public void homePage() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement location = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
//        WebElement location = driver.findElement(By.xpath("//*[@content-desc='Abi test']"));
        String locate = location.getText();
        if (locate.contains("Abi test")) {
            System.out.println(locate);
        } else {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Am test"))).click();
        }
    }

    @Test(priority = 0, enabled = true)
    public void multipleMove() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(8));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
        WebElement location = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
        String getLocationContent = location.getAttribute("content-desc");
        String[] locationContent = getLocationContent.split("\\r?\\n");
        System.out.println("Location name : "+locationContent[0]);
        try {
            // Locate the element
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));

            // Perform actions on the element
            element.click(); // For example, clicking on the element
        } catch (StaleElementReferenceException ex) {
            // If the element is stale, re-locate it and perform actions again
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
            element.click();
        }
        Thread.sleep(2000);
//unassigned
        try{
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='2']"))).click();
        }
        catch (Exception e){
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='2']"))).click();
        }

//unassigned content
        try {
            WebElement unassignedContent = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='0']")));
            String content = unassignedContent.getAttribute("content-desc");

            String[] lines = content.split("\\r?\\n");
            System.out.println("No.of UnassignedTag : " + lines[1]);

            if (Integer.parseInt(lines[1]) > 0) {
                unassignedContent.click();
            } else {
                //plus icon
                Thread.sleep(5000);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

                //Add animal to inventory
                Thread.sleep(500);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

                //Manual Entry
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
                //Manual click

                //Click Treatment
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatments']"))).click();
                //right arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

                //treatment
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add']"))).click();
                //select treatment type content
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Type']"))).click();
                //select treatment type
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Antibiotics']"))).click();
                //back arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
                //back arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

                for (int j = 0; j < 2; j++) {
                    //right arrow
                    Thread.sleep(50);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
                }
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
                //enter tag
                Thread.sleep(500);
                for (int i = 0; i < 4; i++) {
                    WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                    enter.click();
                    enter.clear();
                    Random r = new Random();
                    int rNumber = r.nextInt(100, 999);
                    enter.sendKeys("2" + rNumber);
                    driver.hideKeyboard();
                }
                Thread.sleep(1500);

                try {
                    boolean condition = false;
                    while (!condition) {
                        //view summary
                        WebElement viewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']")));
                        String summary = viewButton.getAttribute("enabled");
                        if (summary.equals("false")){
                            WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                            enter.click();
                            Thread.sleep(200);
                            Random r=new Random();
                            enter.clear();
                            int rNumber2 = r.nextInt(100, 999);
                            String tagId2 = "4" + rNumber2;
                            enter.sendKeys(tagId2);
                            driver.hideKeyboard();
                        }
                        else {
                            condition = true;
                        }
                    }
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']"))).click();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                //add animals to inventory
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
                //yes
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
                //unassigned
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='2']"))).click();
                //unassigned content
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='0']"))).click();
            }
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
//search bar
//        WebElement searchTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
//        searchTag.click();
//        searchTag.sendKeys("102");
//        driver.hideKeyboard();

//menu dot
        try {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        }catch (StaleElementReferenceException s){
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        }
//select animals-manual
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

            //pens content
            WebElement pastureContent = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[17]")));
            String content2 = pastureContent.getAttribute("content-desc");
            String[] lines2 = content2.split("\\r?\\n");
            System.out.println("PenName : " + lines2[0]);
            System.out.println("No.of PenTag : " + lines2[1]);
            if(pastureContent.isDisplayed()){
                System.out.println("inside");

                try {
                    String under = lines2[25];
                    if (under.equals("Under Transfer")) {
                        System.out.println("under tranfer");

                            //plus icon
                            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
                            //add pen/pasture
                            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
                            //enter add pasture
                            WebElement enterPName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
                            enterPName.click();
                            Random ran=new Random();
                            int outR = ran.nextInt(0,10);
                            Thread.sleep(100);
                            enterPName.sendKeys("0aa"+outR);
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
                                        editText.sendKeys("0aa"+rNumber);
                                        driver.hideKeyboard();

                                        //pasture
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
                            String verifycontent = penContent.getAttribute("content-desc");
                            String[] pen = verifycontent.split("\\r?\\n");
                            System.out.println("PenName : " + pen[0]);
                            System.out.println("No.of PenTag : " + pen[1]);
                            if (penContent.isDisplayed()){
                                penContent.click();
                            }
                        }
                }
                catch (Exception e){
                    System.out.println("aaaaa");
                    pastureContent.click();

                }

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
            enterPName.sendKeys("Cartoon");
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
                        editText.sendKeys("Cartoon"+rNumber);
                        driver.hideKeyboard();

                        //pasture
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
            String verifycontent = penContent.getAttribute("content-desc");
            String[] pen = verifycontent.split("\\r?\\n");
            System.out.println("PenName : " + pen[0]);
            System.out.println("No.of PenTag : " + pen[1]);
            if (penContent.isDisplayed()){
                penContent.click();
            }
        }
//done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
//move
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move']"))).click();

        //move successfully pop up
        WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Animal')]")));

        System.out.println(popUp.getAttribute("content-desc"));
        System.out.println("============================================================");
    }

    @Test(priority = 1, enabled = true)
    public void singleMove() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

//        Thread.sleep(1000);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]"))).click();
        //pen content
        Thread.sleep(1000);
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(5));
        try {
            WebElement penContent = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='1'])[4]")));
            String content = penContent.getAttribute("content-desc");
            String[] lines = content.split("\\r?\\n");
            System.out.println("PenName : " + lines[0]);
            System.out.println("No.of PenTag : " + lines[1]);


            if (Integer.parseInt(lines[1]) > 0) {
                penContent.click();
            }
        }
        catch (Exception e) {
            //plus icon
            Thread.sleep(5000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

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
            //select treatment type content
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Type']"))).click();
            //select treatment type
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Antibiotics']"))).click();
            //back arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
            //back arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

            for (int j = 0; j < 2; j++) {
                //right arrow
                Thread.sleep(50);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
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

            WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
            enter.click();
            Random r = new Random();
            int rNumber = r.nextInt(100, 999);
            enter.sendKeys("2" + rNumber);
            Thread.sleep(1500);

            try {
                //view summary
                WebElement viewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']")));
                if (viewButton.isEnabled()) {
                    viewButton.click();
                } else {
                    //enter tag
                    Thread.sleep(500);
                    WebElement enter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                    enter2.click();
                    enter2.clear();
                    Random r2 = new Random();
                    int rNumber2 = r2.nextInt(100, 999);
                    enter2.sendKeys("2" + rNumber2);

                    //pen content
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='1'])[4]"))).click();

                }
            } catch (Exception e1) {
                e1.getMessage();
            }
        }

           Thread.sleep(3000);
        //pen tag
        WebElement penTag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='0'])[14]")));
        String content3 = penTag.getAttribute("content-desc");
        String[] lines3 = content3.split("\\r?\\n");
        System.out.println("Pen to Pasture TagId : " + lines3[0].substring(4));
              //pen content
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0']//android.widget.ImageView[@index='1'])[3]"))).click();
            //move to pen/pasture
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move to Pen / Pasture']"))).click();
                //select
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
                //pasture
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Pastures')]"))).click();
                try{
                    //a pas
                    WebElement pastureContent = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[2]")));
                    String content2 = pastureContent.getAttribute("content-desc");
                    String[] lines2 = content2.split("\\r?\\n");
                    System.out.println("PastureName : " + lines2[0]);
                    System.out.println("No.of PastureTag : " + lines2[1]);
                    if (pastureContent.isDisplayed()){
                        pastureContent.click();
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
                    WebElement pastureContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[2]")));
                    String content2 = pastureContent.getAttribute("content-desc");
                    String[] lines2 = content2.split("\\r?\\n");
                    System.out.println("PastureName : " + lines2[0]);
                    System.out.println("No.of PastureTag : " + lines2[1]);
                    if (pastureContent.isDisplayed()){
                        pastureContent.click();
                    }
                }
                //done
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
                //move
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move']"))).click();
        //a pas
        WebElement pastureContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
        String content2 = pastureContent.getAttribute("content-desc");
        String[] lines2 = content2.split("\\r?\\n");
//        System.out.println("PastureName : " + lines2[0]);
        System.out.println("No.of PastureTag : " + lines2[1]);
        //move successfully pop up
        WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Animal Moved')]")));

        System.out.println(popUp.getAttribute("content-desc"));

        //

        }

//        @Test
        public void check() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Animal')]"))).click();

            Thread.sleep(5000);
            WebElement penContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index=1])[4]")));

            String under = penContent.getAttribute("content-desc");
            String[] line = under.split("\\r?\\n");
            System.out.println(line[25]);

        }

    }