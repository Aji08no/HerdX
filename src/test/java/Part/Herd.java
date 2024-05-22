package Part;

import Common.JavaUtility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Herd {

    static AndroidDriver driver;
    public JavaUtility javaUtility;


    @BeforeTest
    public void openApp() throws MalformedURLException, InterruptedException {

        //Automatic start the appiumServer
//        AppiumDriverLocalService server = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\E-7\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//                .withIPAddress("127.0.0.1").usingPort(4723).build();
//
//        server.start();

        UiAutomator2Options options = new UiAutomator2Options();
//        options.setDeviceName("Hardik...");
//        options.setPlatformName("Android");
//        options.setApp("C:\\APk_files\\HerdxBuild(4).apk");

        options.setPlatformName("Android");
        options.setPlatformVersion("13");
        options.setDeviceName("Galaxy Note20");
        options.setUdid("RZ8N81X10EH");
        options.setAppActivity("com.herdx.herdviewnewapp.MainActivity");
        options.setAppPackage("com.herdx.herdviewnewapp");
        options.setAutomationName("UiAutomator2");

//        DesiredCapabilities cap=new DesiredCapabilities();
//        cap.setCapability("plaftformName","Android");
//        cap.setCapability("plaftformVersion","13");

//        cap.setCapability("deviceName","Galaxy Note20");
//        cap.setCapability("Udid","RZ8N81X10EH");
//        cap.setCapability("appPackage","com.herdx.herdviewnewapp.MainActivity");
//        cap.setCapability("appActivity","com.herdx.herdviewnewapp");


        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        driver = new AndroidDriver(url, options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))).click();

        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
        Thread.sleep(500);
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();

        WebElement mail =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.EditText'])[1]")));
        mail.click();
        Thread.sleep(1000);
        mail.sendKeys("gangappan@pro17analytics.com");
//        mail.sendKeys("muthuselvan1708@gmail.com");

        try {
            WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.EditText'])[2]")));
            password.click();
            Thread.sleep(500);
            password.sendKeys("Otis@2023");
//            password.sendKeys("Tokyo@1708");

            driver.findElement(By.xpath("(//*[@content-desc='Log In'])[2]")).click();

        }
        catch (Exception e){
            WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.EditText'])[2]")));
            password.click();
            Thread.sleep(500);
            password.sendKeys("Otis@2023");
            driver.findElement(By.xpath("(//*[@content-desc='Log In'])[2]")).click();
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Update Later']"))).click();
        }
        catch (Exception e){
            e.getMessage();

        }



        javaUtility=new JavaUtility(driver);
    }

    //       @BeforeMethod
//    @BeforeClass
    public void homePage() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement location = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
//        WebElement location = driver.findElement(By.xpath("//*[@content-desc='Abi test']"));
        String locate = location.getText();
        if(locate.contains("Abi test")){
            System.out.println(locate);
        }
        else {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("A test"))).click();
//        driver.findElement(By.xpath("(//android.view.View[@index='0'])[9]")).click();
            //Total Animals
//            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement location1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
//            //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
//            location1.click();
            //use beforeClass
//            driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        }
    }

    @Test(enabled = false,priority = 0)
    public void createTagId() throws InterruptedException {


//        driver.findElement(By.xpath("(//*[@class='android.widget.EditText'])[1]")).sendKeys("gangappan@pro17analytics.com");

//        WebElement mail = driver.findElement(By.xpath("(//*[@class='android.widget.EditText'])[1]"));
//        mail.click();
//        mail.sendKeys("gangappan@pro17analytics.com");

//        System.out.println(mail.getText());
//        Assert.assertEquals(input,"gangappan@pro17analytics.com");
//        driver.findElement(By.xpath("(//*[@class='android.widget.EditText'])[2]")).sendKeys("Otis@2023");

//        System.out.println(password.getText());


        //Total Animals
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement location1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
        //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        location1.click();
        Thread.sleep(8000);
        //plus icon
        driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[4]")).click();

        Thread.sleep(3000);
        //Add animal to inventory
        driver.findElement(By.xpath("//*[@index='0' and @class='android.widget.ImageView']")).click();

        Thread.sleep(2000);
        //Manual Entry
        driver.findElement(By.xpath("//*[@index='7']")).click();
        //Manual click
        Thread.sleep(4000);
        //Right Arrow
        driver.findElement(By.xpath("(//*[@index=3])[2]")).click();
        //Click Treatment
        driver.findElement(By.xpath("//*[@content-desc='Treatments']")).click();
        //Right Arrow
        driver.findElement(By.xpath("(//*[@index=3])[2]")).click();
        //EPC Prefix
        driver.findElement(By.xpath("//*[@content-desc='Select']")).click();

//        WebElement out = driver.findElement(By.xpath("(//*[@index='0' and @class='android.view.View'])[8]"));
//        Select dropdown = new Select(out);
//        dropdown.selectByVisibleText("E26878434");

        Thread.sleep(1000);
        //EPC Prefix dropdown select
        driver.findElement(By.xpath("(//*[@index='1'])[1]")).click();
        //select
        driver.findElement(By.xpath("(//android.widget.Button)[3]")).click();
        Thread.sleep(500);
        //select dropDown
        driver.findElement(By.xpath("//*[@index='3']")).click();
        //enter tag
        Thread.sleep(500);
        WebElement out = driver.findElement(By.xpath("(//*[@index='1'])[3]"));
        out.click();
        out.sendKeys("2802");

        //treatment
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
        //select treatment type
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//android.widget.ImageView[@index='1'])[3]")).click();
        //select vaccine
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@content-desc='Vaccine']")).click();
        //back arrow
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
        //treatment back arrow
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("(//android.widget.ImageView[@index='0'])[1]")).click();
        Thread.sleep(1000);
        //Next
        driver.findElement(By.xpath("//*[@content-desc='Next']")).click();
        Thread.sleep(1000);
        //Plus icon
        driver.findElement(By.xpath("(//android.widget.ImageView)[8]")).click();
        Thread.sleep(1000);
        //Select medicine
        driver.findElement(By.xpath("//*[@content-desc='Select Medicine']")).click();
        Thread.sleep(3000);
        //select
        driver.findElement(By.xpath("//*[@content-desc='BOVILIS® COVEXIN® 8']")).click();
        //back arrow
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
        //scroll
//        driver.findElementByAndroidUIAutomator("new UiScrollable(" +
//                "new UiSelector()).scrollIntoView(" +
//                "text(\"WebView\"))");

//        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
//                ImmutableMap.of("left",100,"top",100,"width",200,"height",200,
//                "direction","down",
//                        "percent",2.0));

        Thread.sleep(3000);
        //Enter dosage
        WebElement Amount = driver.findElement(By.xpath("(//android.widget.EditText)[2]"));

        Amount.click();
        Amount.sendKeys("8");
        //scroll
        //Enter Duration
        Thread.sleep(5000);
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement duration = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.EditText)[4]")));
        duration.click();
        duration.sendKeys("4");
        driver.hideKeyboard();
        //save
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Save")).click();
        //Next
        Thread.sleep(500);
        driver.findElement(AppiumBy.accessibilityId("Next")).click();
        driver.findElement(AppiumBy.accessibilityId("Next")).click();
        driver.findElement(AppiumBy.accessibilityId("Next")).click();
        driver.findElement(AppiumBy.accessibilityId("Next")).click();
        //pop up next
        driver.findElement(AppiumBy.accessibilityId("Next")).click();
        //Save button
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.Button[@index='3']")).click();
        //view summary
        driver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();

        //add animals to inventory
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();
        //pop up yes
        driver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();
        //unassigned
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement location = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[2]")));
        location.click();
        //driver.findElement(By.xpath("(//android.widget.ImageView[@index='2'])[2]")).click();

        //unassigned content
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//android.view.View[@index='0'])[2]")).click();
        //treatment vaccine icon
        Thread.sleep(2000);
//        WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='4'])[2]"))).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }

    @Test(enabled = false, priority = 1)
    public void deleteTagId() throws InterruptedException {
        //Total Animals
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement location1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
        //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        location1.click();
        //unassigned content delete
        Thread.sleep(3000);
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[2]"))).click();
        //driver.findElement(By.xpath("(//android.widget.ImageView[@index='2'])[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("((//android.view.View[@index='0'])[14]//android.widget.ImageView)[2]")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Delete from inventory")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Accidental Scan")).click();
        driver.findElement(AppiumBy.accessibilityId("Next")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Delete")).click();
        //Confirm deletes
        Thread.sleep(2000);
        driver.findElement(AppiumBy.accessibilityId("Delete")).click();
//        Thread.sleep(8000);
//        WebElement there = driver.findElement(By.xpath("(//android.widget.ImageView[@index='2'])[2]"));
//        boolean out = there.isEnabled();
//        Assert.assertFalse(out,"Tag is Delete");

        WebDriverWait wait2 =new WebDriverWait(driver,Duration.ofSeconds(15));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Pen')])[1]")));

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    //createProtocolsTreatment

    @Test(priority = 1,enabled = false)
    public void editProtocolsTreatment() throws InterruptedException {
        //menuBar
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //settings
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Settings']"))).click();
        //protocols
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Protocols']")).click();

        //edit icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Para')]//*[@index='0']"))).click();
        //active
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Switch"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@content-desc='Save']")).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(500);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }
    @Test(priority = 2,enabled = false)
    public void createProtocolsTreatment() throws InterruptedException {
        //Total Animals
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement location1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
        //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        location1.click();
        Thread.sleep(8000);
        //plus icon
        driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[4]")).click();

        Thread.sleep(3000);
        //Add animal to inventory
        driver.findElement(By.xpath("//*[@index='0' and @class='android.widget.ImageView']")).click();

        Thread.sleep(2000);
        //Manual Entry
        driver.findElement(By.xpath("//*[@index='7']")).click();
        //Manual click
        Thread.sleep(4000);
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatments']"))).click();
        //Click Treatment
//        driver.findElement(By.xpath("//*[@content-desc='Treatments']")).click();
        //Right Arrow
        driver.findElement(By.xpath("(//*[@index=3])[2]")).click();
        //select treatment
        driver.findElement(By.xpath("//*[@content-desc='Add']")).click();
        //select treatment type
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//android.widget.ImageView[@index='1'])[3]")).click();
        //select paracetamol
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Paracetamol']"))).click();

        //back arrow
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
        //next
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@content-desc='Next']")).click();
        //next
        Thread.sleep(1000);
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
        driver.findElement(By.xpath("//*[@content-desc='Next']")).click();
        driver.findElement(By.xpath("//*[@content-desc='Next']")).click();
        driver.findElement(By.xpath("//*[@content-desc='Next']")).click();
//        driver.findElement(By.xpath("//*[@content-desc='Next']")).click();
        //pop up next
        driver.findElement(By.xpath("//*[@content-desc='Next']")).click();
        //right arrow
        driver.findElement(By.xpath("(//*[@index=3])")).click();
        //right arrow
        driver.findElement(By.xpath("(//*[@index=3])[2]")).click();
        //EPC Prefix
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Select']")).click();
        Thread.sleep(1000);
        //EPC Prefix dropdown select
        driver.findElement(By.xpath("(//*[@index='1'])[1]")).click();
        //select
        driver.findElement(By.xpath("(//android.widget.Button)[3]")).click();
        Thread.sleep(500);
        //select dropDown
        driver.findElement(By.xpath("//*[@index='3']")).click();
        //enter tag
        Thread.sleep(500);
        WebElement out = driver.findElement(By.xpath("(//*[@index='1'])[3]"));
        out.click();
        out.sendKeys("2802");
        //view summary
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']"))).click();
        //add animals to inventory
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Add Animals to Inventory']")).click();
        //pop up yes
        driver.findElement(By.xpath("//*[@content-desc='Yes']")).click();
        //unassigned
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement location = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Un')]")));
        location.click();
        //unassigned content
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//android.view.View[@index='0'])[2]")).click();
        //treatment vaccine icon
        Thread.sleep(2000);
        WebDriverWait wait3=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView)[12]"))).click();
    }
    //create added user medicines

    //@Test(priority = 0)
    public void editMedicinesTreatment(){
        //menuBar
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //settings
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Settings']"))).click();

        //user added medicines
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='User Added Medicines']"))).click();
        //edit icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'pain')]//*[@index='0']"))).click();
        //active
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Switch"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        WebElement display = driver.findElement(By.xpath("//*[contains(@content-desc,'User Added')]"));
        boolean verify = display.isDisplayed();
        if(verify){
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }
    }

    //@Test(priority = 1)
    public void createMedicinesTreatment() throws InterruptedException {
        //Total Animals
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement location1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
        //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        location1.click();
//        Thread.sleep(8000);
        //plus icon
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[4]"))).click();

        Thread.sleep(500);
        //Add animal to inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

        Thread.sleep(2000);
        //Manual Entry
        driver.findElement(By.xpath("//*[@index='7']")).click();
        //Manual click
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatments']"))).click();
        //Click Treatment
//        driver.findElement(By.xpath("//*[@content-desc='Treatments']")).click();
        //Right Arrow
        driver.findElement(By.xpath("(//*[@index=3])[2]")).click();
        //select treatment
        driver.findElement(By.xpath("//*[@content-desc='Add']")).click();
        //select treatment type
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//android.widget.ImageView[@index='1'])[3]")).click();
        //select paracetamol
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Hormones']"))).click();
        //back arrow
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
        //next
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@content-desc='Next']")).click();
        //Plus icon
        Thread.sleep(500);
        driver.findElement(By.xpath("(//android.widget.ImageView)[8]")).click();
        Thread.sleep(1000);
        //Select medicine
        driver.findElement(By.xpath("//*[@content-desc='Select Medicine']")).click();
        Thread.sleep(3000);
        //select
        driver.findElement(By.xpath("//*[contains(@content-desc,'pain')]")).click();
        //back arrow
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
        //Enter dosage
        Thread.sleep(1000);
        WebElement Amount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='11']")));

        Amount.click();
        Amount.sendKeys("8");
        //scroll
        //Enter Duration
        Thread.sleep(1000);
        WebElement duration = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));
        duration.click();
        duration.sendKeys("4");
        driver.hideKeyboard();
        //save
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Save")).click();
        //Next
        Thread.sleep(500);
        driver.findElement(AppiumBy.accessibilityId("Next")).click();
        driver.findElement(AppiumBy.accessibilityId("Next")).click();
        driver.findElement(AppiumBy.accessibilityId("Next")).click();
        driver.findElement(AppiumBy.accessibilityId("Next")).click();
        //pop up next
        driver.findElement(AppiumBy.accessibilityId("Next")).click();
        //Right Arrow
        driver.findElement(By.xpath("//android.widget.ImageView[@index='3']")).click();
        //pen/pasture
        driver.findElement(By.xpath("//*[contains(@content-desc,'Pen')]")).click();
        //Right Arrow
        driver.findElement(By.xpath("//android.widget.ImageView[@index='3']")).click();
        //EPC Prefix
        driver.findElement(By.xpath("//*[@content-desc='Select']")).click();
        Thread.sleep(1000);
        //EPC Prefix dropdown select
        driver.findElement(By.xpath("(//*[@index='1'])[1]")).click();
        //select
        Thread.sleep(500);
        driver.findElement(By.xpath("(//android.widget.Button)[3]")).click();
        Thread.sleep(500);
        //select dropDown
        driver.findElement(By.xpath("//*[@index='3']")).click();
        //enter tag
        Thread.sleep(500);
        WebElement out = driver.findElement(By.xpath("(//*[@index='1'])[3]"));
        out.click();
        out.sendKeys("2804");
        //save
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@content-desc='Save']")).click();
        //cancel
        driver.findElement(By.xpath("//*[@content-desc='Cancel']")).click();
        //select pen/pasture
        driver.findElement(By.xpath("//*[@content-desc='Select']")).click();
        //select pen
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[contains(@content-desc,'bull2')]")).click();
        //done
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        //save
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@content-desc='Save']")).click();
        //view summary
        driver.findElement(By.xpath("//*[@content-desc='View Summary']")).click();
        //add animals to inventory
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();
        //pop up yes
        driver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();
        //bull2
        WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'bull2')]"))).click();
        //2804
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'2804')]"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//android.widget.ImageView[@index='4'])[2]")).click();

    }

}
