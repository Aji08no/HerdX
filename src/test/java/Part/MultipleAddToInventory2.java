package Part;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class MultipleAddToInventory2 extends Herd{

    String Type="";

    String existingPenName="";

    String newPenName="";

    int noTagsCount= 0;
    //    ArrayList<String> createdTagsList="";
    ArrayList<String> createdTagsList = new ArrayList<>();

    String path;
    FileInputStream file;
    Properties pro;

    @Test(priority = 0)
    public  void selectParticularCommonAndSpecific() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        Thread.sleep(5000);
        TouchAction touchAction = new TouchAction(driver);
        path = "C:\\Users\\E-7\\IdeaProjects\\HerdX\\src\\main\\resources\\MultipleAddToInventory.properties";
        file = new FileInputStream(path);
        pro = new Properties();
        pro.load(file);
        Thread.sleep(3000);
        WebElement totalAnimals = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
        //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
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
        try {
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

        } catch (Exception e) {
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();
        }
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

        // Right Arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index=3])[2]"))).click();

        //select pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();
        try {
            WebElement penContent = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]")));
            String penNameGet = penContent.getAttribute("content-desc");
            String[] line = penNameGet.split("\\r?\\n");
            existingPenName = line[0];
            if (penContent.isDisplayed()) {
                System.out.println("Pen Name : " + line[0]);
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
                while (addCondition) {
                    WebElement editText = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
                    if (editText.isDisplayed()) {
                        editText.click();
                        Thread.sleep(200);
                        editText.clear();
                        Random r = new Random();
                        int rNumber = r.nextInt(0, 99);
                        Thread.sleep(100);
                        editText.sendKeys("Titans" + rNumber);
                        driver.hideKeyboard();

                        //pasture
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
                        //save
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

                        try {
                            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Enclosure Name Already Exists')]")));
                        } catch (Exception e2) {
                            addCondition = false;
                        }

                    }

                }
            }
            WebElement penContent = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]")));
            String penNameGet = penContent.getAttribute("content-desc");
            String[] line = penNameGet.split("\\r?\\n");
            newPenName = line[0];
            System.out.println("Pen Name : " + line[0]);
            penContent.click();
        }
//      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //weight
        WebElement enterWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterWeight.click();
        Thread.sleep(200);
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
        WebElement sexType = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]")));
        sexType.click();
        String aSexType = sexType.getAttribute("content-desc");
        Type = aSexType;
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();


        //breeder
        WebElement enterBreeder = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        enterBreeder.click();
        Thread.sleep(100);
        enterBreeder.sendKeys(pro.getProperty("breeder"));
        driver.hideKeyboard();

        //right arrow
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        try {
            wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Continue']"))).click();
        } catch (Exception e) {
            e.getMessage();
        }

        //secondary
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Secondary Id']"))).click();
        //usda
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='USDA 840 Tag']"))).click();
        //treatments
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatments']"))).click();
        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

        try {
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='E26878430']"))).click();//4last
        //select
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[3]"))).click();
        //select dropDown
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='99911942914']"))).click();//99977149481

        //multiple tags toggle
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.Switch"))).click();

        //from enter
        WebElement fromEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='0']")));
        fromEnter.click();
        Thread.sleep(200);
        Random r = new Random();
        int rNumber = r.nextInt(902, 946);
        Thread.sleep(200);
        fromEnter.sendKeys("0" + rNumber);

        //try  pop up this tag is already existing
        try {
            boolean condition = false;

            while (!condition) {
                try {
                    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='This Tag Already Exists In Your Inventory ']")));
                    //from enter
                    WebElement fromEnter1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='0']")));
                    fromEnter1.click();
                    Thread.sleep(200);
                    fromEnter1.clear();
                    Random r1 = new Random();
                    int rNumber1 = r1.nextInt(902, 946);
                    Thread.sleep(200);
                    fromEnter1.sendKeys("0"+rNumber1);
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
        noTagsCount = count;
        ArrayList<String> tagsList = new ArrayList<String>();
        createdTagsList = tagsList;
        for (int i = 0; i < count; i++) {
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
            //secondary id
            WebElement enterSecdaryId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
            enterSecdaryId.click();
            enterSecdaryId.sendKeys(pro.getProperty("secondaryID"));
            driver.hideKeyboard();

            //usda tag

            WebElement enterUsdaTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            enterUsdaTag.click();
            enterUsdaTag.sendKeys(pro.getProperty("USDA840Tag"));
            driver.hideKeyboard();


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

            //save
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
            System.out.println("created tagId " + tagIncrease + " : " + createTagId);
        }
        Thread.sleep(500);
        //add animals to inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
        //yes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();

        //created pop up
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Successfully')]")));
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



            //secondary id
            Assert.assertEquals(lines3[3], pro.getProperty("secondaryID"));
            System.out.println("Actual secondaryId :" + lines3[3] + "  " + "Expected secondaryId : " + pro.getProperty("secondaryID"));
            //USDA
            Assert.assertEquals(lines3[5], pro.getProperty("USDA840Tag"));
            System.out.println("Actual USDA840Tag :" + lines3[5] + "  " + "Expected USDA840Tag : " + pro.getProperty("USDA840Tag"));
            //breeder
            Assert.assertEquals(lines3[7], pro.getProperty("breeder"));
            System.out.println("Actual breeder :" + lines3[7] + "  " + "Expected breeder : " + pro.getProperty("breeder"));
            //sex type
            Assert.assertEquals(lines3[25], Type);
            System.out.println("Actual sexType :" + lines3[25] + "  " + "Expected sexType : " + Type);
        }
        Thread.sleep(200);
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }
}
