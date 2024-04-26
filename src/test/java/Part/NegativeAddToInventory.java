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
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class NegativeAddToInventory extends Herd{

    WebDriverWait wait;
    TouchAction touchAction;

    @Test(priority = 0,enabled = false)//not complete this script
    public void tagId () throws InterruptedException {
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        touchAction=new TouchAction(driver);
        WebElement totalAnimals = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
        //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        totalAnimals.click();
        Thread.sleep(5000);
        //plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

        //Add animal to inventory
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

        //Manual Entry
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
        //Manual click
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
        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Purchase Price']"))).click();
        //order buyer
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Order Buyer']"))).click();
        // Right Arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index=3])[2]"))).click();

        //select pen/pasture
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();

        try {
            WebElement penContent = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]")));
            if (penContent.isDisplayed()) {
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

        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]"))).click();
        //done
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //lot id
        WebElement enterLodId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterLodId.click();
        enterLodId.sendKeys("123456789012345678");
        driver.hideKeyboard();

        //breed
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();
        //select breed
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        //weight
        WebElement enterWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterWeight.click();
        enterWeight.sendKeys("18608");
        Thread.sleep(1500);
        enterWeight.clear();
        enterWeight.sendKeys("809");
        driver.hideKeyboard();

        //weight date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Enter Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //sex/type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //select bull
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        //scroll
        touchAction.press(PointOption.point(537,1899))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(523,1610))
                .release()
                .perform();

        //breeder
        WebElement enterBreeder = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterBreeder.click();
        enterBreeder.sendKeys("second");
        driver.hideKeyboard();

        //sire//android.widget.EditText[@index='4']
        WebElement enterSire = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterSire.click();
        enterSire.sendKeys("one");
        driver.hideKeyboard();

        //dam//android.widget.EditText[@index='4']
        WebElement enterDam = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterDam.click();
        enterDam.sendKeys("dam");
        driver.hideKeyboard();

        //treatment
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add']"))).click();


//                // select treatment
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatment']//*[@class='android.widget.ImageView']"))).click();
        //select treatment type content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Type']"))).click();
        //select treatment type
        Thread.sleep(200);
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

        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
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
        enterPurchasePrice.sendKeys("290");
        driver.hideKeyboard();

        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();

        //order buyer//android.widget.EditText[@index='6']
        Thread.sleep(1000);
        WebElement enterOder = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterOder.click();
        enterOder.sendKeys("Good");
        driver.hideKeyboard();


        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        try {
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Continue']"))).click();
        }
        catch (Exception e){
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
        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
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
        Random r = new Random();
        int rNumber = r.nextInt(100, 999);
        String tagId = "5" + rNumber;
        WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
        enter.click();
        Thread.sleep(100);
        enter.sendKeys(tagId);
        driver.hideKeyboard();
        try {
            boolean condition = false;
            while (!condition){
                //view summary
                WebElement viewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']")));
                String summary = viewButton.getAttribute("enabled");
                if (summary.equals("false")) {
                    //enter tag
                    Thread.sleep(500);
                    WebElement enter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                    enter2.click();
                    enter2.clear();
                    Random r2 = new Random();
                    int rNumber2 = r2.nextInt(100, 999);
                    enter2.sendKeys("3" + rNumber2);
                    driver.hideKeyboard();
                }
                else {
                    condition=true;
                }
            }

        } catch (Exception e1) {
            e1.getMessage();
        }
        //select pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //select bull
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //secondary id
        WebElement enterSecdaryId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
        enterSecdaryId.click();
        enterSecdaryId.sendKeys("02");
        driver.hideKeyboard();

        //usda tag
        WebElement enterUsdaTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterUsdaTag.click();
        enterUsdaTag.sendKeys("763874648474637");
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();
        //weaning weight
        WebElement enterWeaningWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        enterWeaningWeight.click();
        enterWeaningWeight.sendKeys("404000");
        Thread.sleep(1500);
        enterWeaningWeight.clear();
        enterWeaningWeight.sendKeys("380");
        driver.hideKeyboard();

        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();
        //weaning date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //usda tag
        WebElement enterUsdaTag1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enterUsdaTag1.click();
        enterUsdaTag1.clear();
        enterUsdaTag1.sendKeys("840874648474");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();
        //usda tag
        WebElement enterUsdaTag12 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enterUsdaTag12.click();
        enterUsdaTag12.clear();
        enterUsdaTag12.sendKeys("840874648474632");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //scroll
        touchAction.press(PointOption.point(528,636))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(528,1321))
                .release()
                .perform();

        //scroll
//        touchAction.press(PointOption.point(528,636))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
//                .moveTo(PointOption.point(528,1321))
//                .release()
//                .perform();

        //add multiple tag id
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Tap to scan Animals']"))).click();
        //EPC Prefix
        Thread.sleep(200);
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
        Thread.sleep(100);
        fromEnter.sendKeys("2812");
        //to enter
        WebElement toEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='1']")));
        toEnter.click();
        Thread.sleep(100);
        toEnter.sendKeys("2813");
        //view summary
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='View Summary']"))).click();

        //add info
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@content-desc,'2812')]//*[contains(@content-desc,'Add Info')]"))).click();

        //select pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //select bull
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull')]"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //secondary id
        WebElement enterSecdaryId2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enterSecdaryId2.click();
        enterSecdaryId2.sendKeys("02");
        driver.hideKeyboard();

        //usda tag
        WebElement enterUsdaTag2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterUsdaTag2.click();
        enterUsdaTag2.sendKeys("785869236584234");
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Vaccine']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();
        //weaning weight
        WebElement enterWeaningWeight2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        enterWeaningWeight2.click();
        enterWeaningWeight2.sendKeys("404000");
        Thread.sleep(1500);
        enterWeaningWeight2.clear();
        enterWeaningWeight2.sendKeys("380");
        driver.hideKeyboard();

        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();
        //weaning date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //usda tag
        WebElement enterUsdaTag123 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enterUsdaTag123.click();
        enterUsdaTag123.clear();
        enterUsdaTag123.sendKeys("840874648474");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();
        //usda tag
        WebElement enterUsdaTag1234 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enterUsdaTag1234.click();
        enterUsdaTag1234.clear();
        enterUsdaTag1234.sendKeys("840874648474632");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        //add info
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@content-desc,'2813')]//*[contains(@content-desc,'Add Info')]"))).click();

        //select pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //select bull
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull')]"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //secondary id
        WebElement enterSecdaryId3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enterSecdaryId3.click();
        enterSecdaryId3.sendKeys("02");
        driver.hideKeyboard();

        //usda tag
        WebElement enterUsdaTag3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterUsdaTag3.click();
        enterUsdaTag3.sendKeys("84785869236584");
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Vaccine']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();
        //weaning weight
        WebElement enterWeaningWeight1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        enterWeaningWeight1.click();
        enterWeaningWeight1.sendKeys("404000");
        Thread.sleep(1500);
        enterWeaningWeight1.clear();
        enterWeaningWeight1.sendKeys("380");
        driver.hideKeyboard();

        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();
        //weaning date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //usda tag
        WebElement enterUsdaTag10 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enterUsdaTag10.click();
        enterUsdaTag10.clear();
        enterUsdaTag10.sendKeys("840874648474");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();
        //usda tag
        WebElement enterUsdaTag120 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enterUsdaTag120.click();
        enterUsdaTag120.clear();
        enterUsdaTag120.sendKeys("840874648474632");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        Thread.sleep(1000);
//        //view summary
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']"))).click();
//        Thread.sleep(2000);
        //add animals to inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
        //yes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
    }



    @Test(priority = -1)
    public void singleTagCreate() throws InterruptedException {
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        touchAction=new TouchAction(driver);
        Thread.sleep(5000);
        WebElement totalAnimals = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
        //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        totalAnimals.click();
        try {
            Thread.sleep(3000);
            //plus icon
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
        }
        catch (StaleElementReferenceException s){
            Thread.sleep(3000);
            //plus icon
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

        }
        //Add animal to inventory
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

        //Manual Entry
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
        //Manual click
        //click pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen / Pasture']"))).click();
        //click weight
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Weight']"))).click();
        //click lot id
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Lot Id']"))).click();
        //Click Treatment
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatments']"))).click();
       // Right Arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index=3])[2]"))).click();

        //select pen/pasture
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();

        try {
            WebElement penContent = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]")));
            if (penContent.isDisplayed()) {
                String penNameGet = penContent.getAttribute("content-desc");
                String[] line = penNameGet.split("\\r?\\n");
                String pName = line[0];
                System.out.println("Pen name : "+pName);
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

        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]"))).click();
        //done
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //lot id
        WebElement enterLodId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterLodId.click();
        enterLodId.sendKeys("123456789012345678");
        driver.hideKeyboard();

        //weight
        WebElement enterWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
        enterWeight.click();
        enterWeight.sendKeys("18608");
        driver.hideKeyboard();

        //weight date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Enter Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //treatment
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add']"))).click();


                // select treatment
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatment']//*[@class='android.widget.ImageView']"))).click();
        //select treatment type content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Type']"))).click();
        //select treatment type
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();

        //try
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

        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        //enter weight lees than 10000lbs
        try{
            WebElement weightError = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Enter weight less than 10000 lbs']")));
            System.out.println(weightError.getAttribute("content-desc")+" Actual weight:18608");
            enterWeight.click();
            Thread.sleep(200);
            enterWeight.clear();
            enterWeight.sendKeys("3359");
            driver.hideKeyboard();
            //right arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

        }
        catch (Exception e){
            e.getMessage();
        }

        //continue pop up
        try {
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Continue']"))).click();
        }
        catch (Exception e){
            e.getMessage();
        }
        //usda
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='USDA 840 Tag']"))).click();
        //weaning date & weight
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Weaning Date & Weight']"))).click();
        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
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
        Random r = new Random();
        int rNumber = r.nextInt(100, 999);
        String tagId = "5" + rNumber;
        WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
        enter.click();
        Thread.sleep(100);
        enter.sendKeys(tagId);
        driver.hideKeyboard();
        try {
            boolean condition = false;
            while (!condition){
                //view summary
                WebElement viewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']")));
                String summary = viewButton.getAttribute("enabled");
                if (summary.equals("false")) {
                    //enter tag
                    Thread.sleep(500);
                    WebElement enter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                    enter2.click();
                    enter2.clear();
                    Random r2 = new Random();
                    int rNumber2 = r2.nextInt(100, 999);
                    enter2.sendKeys("3" + rNumber2);
                    driver.hideKeyboard();
                }
                else {
                    condition=true;
                }
            }

        } catch (Exception e1) {
            e1.getMessage();
        }
        //usda tag
        WebElement enterUsdaTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterUsdaTag.click();
        enterUsdaTag.sendKeys("763874648474637");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        //weaning weight
        WebElement enterWeaningWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
        enterWeaningWeight.click();
        enterWeaningWeight.sendKeys("404000");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        //weaning date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        //usda start
        WebElement USDAStart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[15]")));
        System.out.println(USDAStart.getAttribute("content-desc"));
        //usda tag less than 15 characters
        WebElement enterUsdaTag1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterUsdaTag1.click();
        enterUsdaTag1.clear();
        enterUsdaTag1.sendKeys("840874648474");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        //usda
        WebElement USDALess = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[15]")));
        System.out.println(USDALess.getAttribute("content-desc"));

        //usda tag
        WebElement enterUsdaTag12 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterUsdaTag12.click();
        enterUsdaTag12.clear();
        enterUsdaTag12.sendKeys("840874648474632");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();


        //usda
        WebElement weightLess = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[16]")));
        System.out.println(weightLess.getAttribute("content-desc"));
        //enter vail weight
        enterWeaningWeight.click();
        Thread.sleep(200);
        enterWeaningWeight.clear();
        enterWeaningWeight.sendKeys("4000");
        driver.hideKeyboard();
       //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        //view summary
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']"))).click();
        //add animals to inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
        //yes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();

        //verifyPenContent
        //tag search bar

        //wait for successfully pop up
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Animal Added to Inventory Successfully')]")));

        //back
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
