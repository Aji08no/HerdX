package Part;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

public class EditAnimalDetails extends Herd {

//    @Test
    public void editTagIdDetails() throws InterruptedException, IOException {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        TouchAction touchAction=new TouchAction<>(driver);
        String path = "C:\\Users\\E-7\\IdeaProjects\\HerdX\\src\\main\\resources\\Imformation.properties";
        FileInputStream file=new FileInputStream(path);
        Properties pro=new Properties();
        pro.load(file);
        //Total Animals
        WebElement location1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
        location1.click();
        Thread.sleep(1000);
        WebElement penContent = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='1'])[4]")));
        String content = penContent.getAttribute("content-desc");
        String[] lines = content.split("\\r?\\n");
        System.out.println("PenName : " + lines[0]);
        penContent.click();
        //tag
        WebElement tagContent = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='0'])[14]")));
        String content2 = tagContent.getAttribute("content-desc");
        String[] lines2 = content2.split("\\r?\\n");
        String tagId = lines2[0].substring(4).trim();
        Thread.sleep(200);
        System.out.println("Edit TagId :"+tagId);
        //menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]//*[@index='1']"))).click();

        //edit
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Edit']"))).click();
        //purchase price
        WebElement enterPurchasePrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterPurchasePrice.click();
        Thread.sleep(100);
        enterPurchasePrice.clear();
        enterPurchasePrice.sendKeys(pro.getProperty("purchasePrice"));
        driver.hideKeyboard();
        //lot id
        WebElement enterLotId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
        enterLotId.click();
        Thread.sleep(100);
        enterLotId.clear();
        enterLotId.sendKeys(pro.getProperty("lotID"));
        driver.hideKeyboard();
        //secondary id
        WebElement enterSecondaryId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterSecondaryId.click();
        Thread.sleep(100);
        enterSecondaryId.clear();
        enterSecondaryId.sendKeys(pro.getProperty("secondaryID"));
        driver.hideKeyboard();
        //USDA 840 Tag
        WebElement enterUSDA = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterUSDA.click();
        Thread.sleep(100);
        enterUSDA.clear();
        enterUSDA.sendKeys(pro.getProperty("USDA840Tag"));
        driver.hideKeyboard();
        //breeder
        WebElement enterBreeder = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterBreeder.click();
        Thread.sleep(100);
        enterBreeder.clear();
        enterBreeder.sendKeys(pro.getProperty("breeder"));
        driver.hideKeyboard();
        //order buyer
        WebElement enterOrderBuyer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterOrderBuyer.click();
        Thread.sleep(100);
        enterOrderBuyer.clear();
        enterOrderBuyer.sendKeys(pro.getProperty("orderBuyer"));
        driver.hideKeyboard();
        //breeds
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='5']"))).click();
        //select breeds
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='"+pro.getProperty("breeds")+"']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //sex/type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='6'])"))).click();
        //select sex type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='"+pro.getProperty("sexType")+"']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //scroll
        touchAction.press(PointOption.point(505,1897))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                        .moveTo(PointOption.point(523,1642))
                                .release()
                                        .perform();
        //sire
        WebElement enterSire = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterSire.click();
        Thread.sleep(100);
        enterSire.clear();
        enterSire.sendKeys(pro.getProperty("sire"));
        driver.hideKeyboard();
        //dam
        WebElement enterDam = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        enterDam.click();
        Thread.sleep(100);
        enterDam.clear();
        enterDam.sendKeys(pro.getProperty("dam"));
        driver.hideKeyboard();
        //scroll
        touchAction.press(PointOption.point(523,1998))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(523,1732))
                .release()
                .perform();
        //weaning weight
        WebElement enterWeaningWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterWeaningWeight.click();
        Thread.sleep(200);
        enterWeaningWeight.clear();
        enterWeaningWeight.sendKeys(pro.getProperty("weaningWeight"));
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //search enter
        Thread.sleep(2000);
        WebElement sEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
        sEnter.click();
        Thread.sleep(200);
        sEnter.sendKeys(tagId);
        driver.hideKeyboard();
        //tag
        WebElement afterTagId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[15]")));
        afterTagId.click();
        //tag details
        Thread.sleep(200);
        WebElement tagD = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@index='4']")));
        String tagValue = tagD.getAttribute("content-desc");
        String[] lines3 = tagValue.split("\\r?\\n");
        System.out.println("=======================================");
        //lot id
        Assert.assertEquals(lines3[1],pro.getProperty("lotID"));
        System.out.println("Actual lotId :"+lines3[1]+"  "+"Expected lotId :"+pro.getProperty("lotID"));
        //secondary id
        Assert.assertEquals(lines3[3],pro.getProperty("secondaryID"));
        System.out.println("Actual secondaryId :"+lines3[3]+"  "+"Expected secondaryId :"+pro.getProperty("secondaryID"));
        //USDA
        Assert.assertEquals(lines3[5],pro.getProperty("USDA840Tag"));
        System.out.println("Actual USDA840Tag :"+lines3[5]+"  "+"Expected USDA840Tag :"+pro.getProperty("USDA840Tag"));
        //breeder
        Assert.assertEquals(lines3[7],pro.getProperty("breeder"));
        System.out.println("Actual breeder :"+lines3[7]+"  "+"Expected breeder :"+pro.getProperty("breeder"));
        //order buyer
        Assert.assertEquals(lines3[9],pro.getProperty("orderBuyer"));
        System.out.println("Actual orderBuyer :"+lines3[9]+"  "+"Expected orderBuyer :"+pro.getProperty("orderBuyer"));
        //purchase price
        Assert.assertEquals(lines3[11],pro.getProperty("purchasePrice"));
        System.out.println("Actual purchasePrice :"+lines3[11]+"  "+"Expected purchasePrice :"+pro.getProperty("purchasePrice"));
        //dam
        Assert.assertEquals(lines3[15],pro.getProperty("dam"));
        System.out.println("Actual dam :"+lines3[15]+"  "+"Expected dam :"+pro.getProperty("dam"));
        //sire
        Assert.assertEquals(lines3[17],pro.getProperty("sire"));
        System.out.println("Actual sire :"+lines3[17]+"  "+"Expected sire :"+pro.getProperty("sire"));
        //breed
        Assert.assertEquals(lines3[23],pro.getProperty("breeds"));
        System.out.println("Actual breeds :"+lines3[23]+"  "+"Expected breeds :"+pro.getProperty("breeds"));
        //sex type
        Assert.assertEquals(lines3[25],pro.getProperty("sexType"));
        System.out.println("Actual sexType :"+lines3[25]+"  "+"Expected sexType :"+pro.getProperty("sexType"));
        //weaning weight
        Assert.assertEquals(lines3[29],pro.getProperty("weaningWeight")+" lbs");
        System.out.println("Actual weaningWeight :"+lines3[29]+"  "+"Expected weaningWeight :"+pro.getProperty("weaningWeight")+" lbs");
    }


    @Test
    public void checkEdit() throws IOException, InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(5));
        TouchAction touchAction=new TouchAction<>(driver);
        String path = "C:\\Users\\E-7\\IdeaProjects\\HerdX\\src\\main\\resources\\Imformation.properties";
        FileInputStream file=new FileInputStream(path);
        Properties pro=new Properties();
        pro.load(file);
        //Total Animals
        WebElement location1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
        location1.click();
        Thread.sleep(1000);
        try {
            WebElement penContent = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='1'])[4]")));
            String content = penContent.getAttribute("content-desc");
            String[] lines = content.split("\\r?\\n");
            System.out.println("PenName : " + lines[0]);

            //pen count
            if(Integer.parseInt(lines[1])>0){
                penContent.click();
                //tag
                WebElement tagContent = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='0'])[14]")));
                String content2 = tagContent.getAttribute("content-desc");
                String[] lines2 = content2.split("\\r?\\n");
                String tagId = lines2[0].substring(4).trim();
                Thread.sleep(200);
                System.out.println("Edit TagId :"+tagId);
            }
            else {
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
                                condition=true;
                            }
                        }
                        catch (Exception e){
                            e.getMessage();
                        }
                    }
                System.out.println("Doesn't created");
                    if(Integer.parseInt(lines[1])>0){
                        penContent.click();
                        System.out.println(" created");
                        //tag
                        WebElement tagContent = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='0'])[14]")));
                        String content2 = tagContent.getAttribute("content-desc");
                        String[] lines2 = content2.split("\\r?\\n");
                        String tagId = lines2[0].substring(4).trim();
                        Thread.sleep(200);
                        System.out.println("Edit TagId :"+tagId);
                    }else {
                        System.out.println("Doesn't created the tag");
                    }
            }
        }catch (Exception e){
            //plus icon

        }


    }
}
