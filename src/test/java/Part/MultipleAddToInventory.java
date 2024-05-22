package Part;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class MultipleAddToInventory extends Herd {
    String Type="";

    String existingPenName="";

    String newPenName="";

    int noTagsCount= 0;
//    ArrayList<String> createdTagsList="";
    ArrayList<String> createdTagsList = new ArrayList<>();

    String path;
    FileInputStream file;
    Properties pro;
    @Test(priority = 0,enabled = true)
    public void createMultipleTags() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(5));
        TouchAction touchAction = new TouchAction(driver);
        path="C:\\Users\\E-7\\IdeaProjects\\HerdX\\src\\main\\resources\\MultipleAddToInventory.properties";
        file=new FileInputStream(path);
        pro=new Properties();
        pro.load(file);
        Thread.sleep(5000);
        WebElement totalAnimals = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
        totalAnimals.click();

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
        Thread.sleep(4000);
        //click pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen / Pasture']"))).click();
        //click weight
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Weight']"))).click();
        //click sex/type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Sex / Type']"))).click();
        //click breeder
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Breeder']"))).click();
        //click lot id
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Lot Id']"))).click();
        //click breed
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Breed']"))).click();
        //click sire
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Sire']"))).click();
        //click dam
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Dam']"))).click();
        //Click Treatment
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatments']"))).click();
        //click receiving
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Date Received']"))).click();
        //click purchase date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Purchase Date']"))).click();
        //purchase price
        touchAction.press(PointOption.point(469, 1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519, 547))
                .release()
                .perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Purchase Price']"))).click();
        //order buyer
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Order Buyer']"))).click();
        // Right Arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index=3])[2]"))).click();

        //select pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();
        try {
            WebElement penContent = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]")));
            String penNameGet = penContent.getAttribute("content-desc");
            String[] line = penNameGet.split("\\r?\\n");
            existingPenName=line[0];
            if (penContent.isDisplayed()) {
                System.out.println("Pen Name : "+line[0]);
                penContent.click();
            }
        }
        catch (Exception e) {
            e.getMessage();
            //plus icon
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
            //add pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
            //enter add pasture
            WebElement enterPName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            enterPName.click();
            Thread.sleep(100);
            enterPName.sendKeys("Titans");
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
                        editText.sendKeys("Titans"+rNumber);
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
            WebElement penContent = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]")));
            String penNameGet = penContent.getAttribute("content-desc");
            String[] line = penNameGet.split("\\r?\\n");
            newPenName=line[0];
            System.out.println("Pen Name : "+line[0]);
            penContent.click();
        }
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]"))).click();
        //done
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //lot id
        WebElement enterLodId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterLodId.click();
        enterLodId.sendKeys(pro.getProperty("lotID"));
        driver.hideKeyboard();

        //breed
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();
        //select breed
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        //weight
        WebElement enterWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterWeight.click();
        enterWeight.sendKeys("186");
        driver.hideKeyboard();

        //weight date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Enter Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //sex/type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //select bull
        Thread.sleep(200);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]"))).click();
        }
        catch (StaleElementReferenceException s){
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]"))).click();
        }
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        //scroll
        touchAction.press(PointOption.point(537, 1899))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(523, 1610))
                .release()
                .perform();

        //breeder
        WebElement enterBreeder = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterBreeder.click();
        Thread.sleep(200);
        enterBreeder.sendKeys(pro.getProperty("breeder"));
        driver.hideKeyboard();

        //sire//android.widget.EditText[@index='4']
        WebElement enterSire = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterSire.click();
        Thread.sleep(200);
        enterSire.sendKeys(pro.getProperty("sire"));
        driver.hideKeyboard();

        //dam//android.widget.EditText[@index='4']
        WebElement enterDam = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterDam.click();
        enterDam.sendKeys(pro.getProperty("dam"));
        driver.hideKeyboard();

        //treatment
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add']"))).click();

        // select treatment
//      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatment']//*[@class='android.widget.ImageView']"))).click();
        //select treatment type content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Type']"))).click();
        //select treatment type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
        //medicineContent
        try{
            Thread.sleep(3000);
            WebElement textVerify = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='No Medicines Added Yet']")));
            if (textVerify.isDisplayed()) {
                Thread.sleep(500);
                //medicine Plus icon
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[2]"))).click();
                //Select medicine
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Medicine']"))).click();
                //select painkiller
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
                //back arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

                //scroll
                touchAction.press(PointOption.point(501, 1948))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                        .moveTo(PointOption.point(505, 1709))
                        .release()
                        .perform();

                //amount
                WebElement enterAmount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));
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
                int next = 5;
                for (int i = 0; i < next; i++) {
                    Thread.sleep(50);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
                }
            }
        }
        catch (Exception e){
            Thread.sleep(500);
            int next=5;
            for(int i=0;i < next;i++){
                Thread.sleep(50);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
            }
        }

        //receiving date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Enter Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        touchAction.press(PointOption.point(469, 1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519, 547))
                .release()
                .perform();
        //purchase date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Enter Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //purchase price
        WebElement enterPurchasePrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        enterPurchasePrice.click();
        Thread.sleep(200);
        enterPurchasePrice.clear();
        enterPurchasePrice.sendKeys(pro.getProperty("purchasePrice"));
        driver.hideKeyboard();

        touchAction.press(PointOption.point(469, 1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519, 547))
                .release()
                .perform();

        //order buyer//android.widget.EditText[@index='6']
        Thread.sleep(1000);
        WebElement enterOder = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterOder.click();
        enterOder.sendKeys(pro.getProperty("orderBuyer"));
        driver.hideKeyboard();

        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        try {
            wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Continue']"))).click();
        } catch (Exception e) {
            e.getMessage();
        }
        //pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen / Pasture']"))).click();
        //secondary
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Secondary Id']"))).click();
        //usda
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='USDA 840 Tag']"))).click();
        //date of birth
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Date of Birth']"))).click();
        //treatments
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatments']"))).click();
        //weaning date & weight
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Weaning Date & Weight']"))).click();
        Thread.sleep(2500);
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

        int count = Integer.parseInt(createTags);
        noTagsCount=count;
        ArrayList<String> tagsList=new ArrayList<String>();
        createdTagsList= tagsList;
        for (int i=0;i < count;i++) {
            //add info
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0']//*[@content-desc='Add Info'])[1]"))).click();
            Thread.sleep(500);
            //tag id
            WebElement tagId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]")));
            Thread.sleep(500);
            String tags = tagId.getAttribute("content-desc");
            String[] lines = tags.split("\\r?\\n");
            String createTagId = lines[3];
            int tagIncrease = i + 1;
            tagsList.add(createTagId);

            //select pen/pasture
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
            //select bull
            Thread.sleep(1000);
            try{
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
            }
            catch (StaleElementReferenceException s){
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
            }
            //done
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

            //secondary id
            WebElement enterSecdaryId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            enterSecdaryId.click();
            enterSecdaryId.sendKeys(pro.getProperty("secondaryID"));
            driver.hideKeyboard();

            //usda tag

            WebElement enterUsdaTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
            enterUsdaTag.click();
            enterUsdaTag.sendKeys(pro.getProperty("USDA840Tag"));
            driver.hideKeyboard();

            //date of birth
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Date']"))).click();
            //done
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

            //treatment
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add']"))).click();
            //select treatment type content
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Type']"))).click();
            //select treatment type
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
            //back arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
            //back arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

            touchAction.press(PointOption.point(469, 1885))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                    .moveTo(PointOption.point(519, 547))
                    .release()
                    .perform();

            //weaning weight
            WebElement enterWeaningWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
            enterWeaningWeight.click();
            enterWeaningWeight.sendKeys("404");
            driver.hideKeyboard();
            Thread.sleep(200);
            touchAction.press(PointOption.point(469, 1885))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                    .moveTo(PointOption.point(519, 547))
                    .release()
                    .perform();
            //weaning date
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Date']"))).click();
            //done
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();


            //save
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

            System.out.println("created tagId "+tagIncrease+" : " + createTagId);
        }
        Thread.sleep(500);
        //add animals to inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
        //yes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();

        //created pop up
        WebDriverWait loadWait=new WebDriverWait(driver,Duration.ofSeconds(60));
        loadWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Successfully')]")));
        System.out.println("created successfully");

        //pen content
        WebElement penName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
        String verifyPenName = penName.getAttribute("content-desc");
        String[] lineV = verifyPenName.split("\\r?\\n");

        try {
            Assert.assertEquals(lineV[0], existingPenName);
            System.out.println("Existing pen");
            penName.click();
        } catch (Exception e) {
            Assert.assertEquals(lineV[0], newPenName);
            System.out.println("New pen");
            penName.click();
        }
        for (int j = 0; j < noTagsCount; j++) {
            System.out.println("Tag id : " + createdTagsList.get(j));
            //tag search bar
            WebElement tagS = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
            Thread.sleep(500);
            try {
                Thread.sleep(1000);
                tagS.click();
            }
            catch (StaleElementReferenceException s){
                Thread.sleep(1000);
                tagS.click();
            }
            Thread.sleep(500);
            tagS.clear();
            tagS.sendKeys((CharSequence) createdTagsList.get(j));
            driver.hideKeyboard();
//tag
            WebElement afterTagId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[15]")));
            afterTagId.click();
            //tag details
            Thread.sleep(200);
            WebElement tagD = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@index='4']")));
            String tagValue = tagD.getAttribute("content-desc");
            String[] lines3 = tagValue.split("\\r?\\n");

            //back arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();


            //lot id
            Assert.assertEquals(lines3[1], pro.getProperty("lotID"));
            System.out.println("Actual lotId :" + lines3[1] + "  " + "Expected lotId : " + pro.getProperty("lotID"));

            //secondary id
            Assert.assertEquals(lines3[3], pro.getProperty("secondaryID"));
            System.out.println("Actual secondaryId :" + lines3[3] + "  " + "Expected secondaryId : " + pro.getProperty("secondaryID"));
            //USDA
            Assert.assertEquals(lines3[5], pro.getProperty("USDA840Tag"));
            System.out.println("Actual USDA840Tag :" + lines3[5] + "  " + "Expected USDA840Tag : " + pro.getProperty("USDA840Tag"));
            //breeder
            Assert.assertEquals(lines3[7], pro.getProperty("breeder"));
            System.out.println("Actual breeder :" + lines3[7] + "  " + "Expected breeder : " + pro.getProperty("breeder"));
            //order buyer
            Assert.assertEquals(lines3[9], pro.getProperty("orderBuyer"));
            System.out.println("Actual orderBuyer :" + lines3[9] + "  " + "Expected orderBuyer : " + pro.getProperty("orderBuyer"));

            //purchase price
            Assert.assertEquals(lines3[11], pro.getProperty("purchasePrice"));
            System.out.println("Actual purchasePrice :" + lines3[11] + "  " + "Expected purchasePrice : " + pro.getProperty("purchasePrice"));

            //dam
            Assert.assertEquals(lines3[15], pro.getProperty("dam"));
            System.out.println("Actual dam :" + lines3[15] + "  " + "Expected dam : " + pro.getProperty("dam"));

            //sire
            Assert.assertEquals(lines3[17], pro.getProperty("sire"));
            System.out.println("Actual sire :" + lines3[17] + "  " + "Expected sire : " + pro.getProperty("sire"));

            //breed
//            Assert.assertEquals(lines3[23], pro.getProperty("breed"));
//            System.out.println("Actual breed :" + lines3[23] + "  " + "Expected breed : " + pro.getProperty("breed"));


            //sex type
//            Assert.assertEquals(lines3[25], Type);
//            System.out.println("Actual sexType :" + lines3[25] + "  " + "Expected sexType : " + Type);

            //weaning weight
            Assert.assertEquals(lines3[29], pro.getProperty("weaningWeight")+".0 lbs");
            System.out.println("Actual weaningWeight :" + lines3[29] + "  " + "Expected weaningWeight : " + pro.getProperty("weaningWeight")+".0 lbs");

        }
        Thread.sleep(200);
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
  }
}
