package Task;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectAllCommonAndSpecificInformation_Toggle extends Herd {
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
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Receiving Date']"))).click();
        //click purchase date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Purchase Date']"))).click();
        //purchase price
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Purchase Price']"))).click();
        //order buyer
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Order Buyer']"))).click();
        // Right Arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index=3])[2]"))).click();

        //select pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();
        //select pen
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull2')]"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //lot id
        WebElement enterLodId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterLodId.click();
        enterLodId.sendKeys("08");
        driver.hideKeyboard();

        //breed
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();
        //select breed
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Brahman']"))).click();
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Bull']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

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

        //receiving date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Enter Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

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

        //order buyer//android.widget.EditText[@index='6']
        Thread.sleep(3000);
        WebElement enterOder = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterOder.click();
        enterOder.sendKeys("good");
        driver.hideKeyboard();



        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[11]"))).click();
        //select
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[3]"))).click();
        //select dropDown
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='4']"))).click();
        //multiple tags toggle
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.Switch"))).click();
        //from enter
        WebElement fromEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='0']")));
        fromEnter.click();
        fromEnter.sendKeys("2802");
        //to enter
        WebElement toEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='1']")));
        toEnter.click();
        toEnter.sendKeys("2804");
        //view summary
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='View Summary']"))).click();

        //add info
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@content-desc,'2802')]//*[contains(@content-desc,'Add Info')]"))).click();


        //select pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //select bull
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull')]"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //secondary id
        WebElement enterSecdaryId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enterSecdaryId.click();
        enterSecdaryId.sendKeys("02");
        driver.hideKeyboard();

        //usda tag
        WebElement enterUsdaTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterUsdaTag.click();
        enterUsdaTag.sendKeys("840785869236584");
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

        //weaning date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //weaning weight
        WebElement enterWeaningWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterWeaningWeight.click();
        enterWeaningWeight.sendKeys("404");
        driver.hideKeyboard();

        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        //edit info
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@content-desc,'2802')]//*[contains(@content-desc,'Add Info')]"))).click();
        //select pen/pasture
        Thread.sleep(2000);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen bull2']"))).click();
//        //select bull
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Pasture')]"))).click();
//        //select bull
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Bull')]"))).click();
//        //done
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //secondary id
        WebElement enterSecdaryId1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enterSecdaryId1.click();
        enterSecdaryId1.clear();
        enterSecdaryId1.sendKeys("04");
        driver.hideKeyboard();

        //usda tag
//        WebElement enterUsdaTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
//        enterUsdaTag.click();
//        enterUsdaTag.sendKeys("840785869236584");
//        driver.hideKeyboard();


        //treatment
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='4']"))).click();
        //select treatment type content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
        //select treatment type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Antibiotics']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        //weaning weight
        WebElement enterWeaningWeight1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterWeaningWeight1.click();
        enterWeaningWeight1.clear();
        enterWeaningWeight1.sendKeys("201");
        driver.hideKeyboard();

        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        //add animals to inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
        //yes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();

    }
    @Test(priority = 1)
    public void verifyAddTagId(){
        //pens bull2
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull')]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();


    }

    public void editAddInfo(){
        //select pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]"))).click();
        //select bull
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Pasture')]"))).click();
        //select bull
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Bull')]"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //secondary id
        WebElement enterSecdaryId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enterSecdaryId.click();
        enterSecdaryId.clear();
        enterSecdaryId.sendKeys("04");
        driver.hideKeyboard();

        //usda tag
//        WebElement enterUsdaTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
//        enterUsdaTag.click();
//        enterUsdaTag.sendKeys("840785869236584");
//        driver.hideKeyboard();


        //treatment
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='4']"))).click();
        //select treatment type content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[3]"))).click();
        //select treatment type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Antibiotics']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        //weaning weight
        WebElement enterWeaningWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterWeaningWeight.click();
        enterWeaningWeight.clear();
        enterWeaningWeight.sendKeys("201");
        driver.hideKeyboard();

        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

    }

}
