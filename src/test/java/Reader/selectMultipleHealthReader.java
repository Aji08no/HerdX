package Reader;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

public class selectMultipleHealthReader extends  Herd{

    @Test(priority = -1)
    public void selectAllTags() throws InterruptedException, IOException {

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(8));

        String path="C:\\Users\\E-7\\IdeaProjects\\HerdX\\src\\main\\resources\\Reader.properties";
        FileInputStream file=new FileInputStream(path);
        Properties pro=new Properties();
        pro.load(file);

        //total animals
        Thread.sleep(5000);
        WebElement totalAnimals = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
        totalAnimals.click();
        //pen content
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]"))).click();

        //===========================================================================================================================//
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
                            //pen content
                            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]"))).click();
                            addCondition = false;
                        }

                    }

                }
            }
        }
        //pen tag
        try {

            WebElement penContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
            String content2 = penContent.getAttribute("content-desc");
            String[] lines2 = content2.split("\\r?\\n");
            String totalTag = lines2[1];
            if (Integer.parseInt(totalTag) > 3) {
                penContent.click();
            } else {
                //plus icon
                Thread.sleep(5000);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

                //Add animal to inventory
                Thread.sleep(500);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

                //Manual Entry
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
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
                    //view summary
                    WebElement viewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']")));
                    if (viewButton.isEnabled()) {
                        viewButton.click();
                    } else {

                        boolean condition = false;
                        while (!condition){
                            try{
                                String summeryView = viewButton.getAttribute("enabled");
                                if (summeryView.equals("false")){
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
                                    condition=true;
                                }
                            }
                            catch (Exception e2){
                                e2.getMessage();
                            }
                        }
                        //view summary
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='View Summary']"))).click();

                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                //add animals to inventory
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
                //yes
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
                //pen content
                WebElement content = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
                String verifyContent = content.getAttribute("content-desc");
                String[] lines = verifyContent.split("\\r?\\n");
                content.click();
            }
        }catch (Exception e){
            e.getMessage();
        }
        //===========================================================================================================================//

        //menu dot
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        //select animals
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Animals - Scan']"))).click();
        //herdView readers
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'HerdView')]"))).click();
        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        Thread.sleep(5000);
        //reader
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Goodnow')]//android.widget.ImageView[@index='0']"))).click();

        //reader
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'"+pro.getProperty("multipleHealthReader")+"')]//android.widget.ImageView[@index='0']"))).click();
        Thread.sleep(3000);
        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='5'])"))).click();
        //no
        try {
            driver.findElement(By.xpath("//*[@content-desc='No']")).click();
        } catch (Exception e) {
            e.getMessage();
        }
//        try {
//            WebElement screen = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='5'])[2]")));
//            if(screen.isEnabled()){
//                screen.click();
//            }
//            else {
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='5'])[2]"))).click();
//            }
//        }
//        catch (Exception e){
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='5'])[2]"))).click();
//        }
        Thread.sleep(8000);
        //scan stop
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='7'])"))).click();
        //confirm tag
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Confirm Tags']"))).click();
        //quick action
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Quick Actions']"))).click();
        //animal health
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Animal Health']"))).click();

    }

    @Test(priority = 0)
    public void createSymptomsAllTags() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        //symptoms
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Symptoms']"))).click();
        //select symptoms
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Symptoms']"))).click();
        Thread.sleep(2000);
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(454,1933))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(465,999)).release().perform();

        //warts
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Warts']"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //comment
        WebElement enterComment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='8']")));
        enterComment.click();
        enterComment.sendKeys("Warts are caused by the human papillomavirus");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }

    @Test(priority = 1)
    public void createDiagnosisAllTags(){

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        //diagnosis
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Diagnosis']"))).click();
        //select diagnosis
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Diagnosis']"))).click();
        //pneumonia
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pneumonia']"))).click();
        //back
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])"))).click();
        //diagnosis by
        WebElement enterDiagnosisBY = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterDiagnosisBY.click();
        enterDiagnosisBY.sendKeys("caused by");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //comment
        WebElement enterComment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));
        enterComment.click();
        enterComment.sendKeys("Pneumonia is an infection that inflames the air sacs in one or both lungs.");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 2)
    public void createHealthScoreAllTags(){

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        //healthScore
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Score')]"))).click();
        //seekBar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.SeekBar"))).click();
        //comment
        WebElement enterComment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='9']")));
        enterComment.click();
        enterComment.sendKeys("A health score can be a number that indicates.");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 3)
    public void createBCSAllTags(){

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        //bcs
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='BCS']"))).click();
        //condition score
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='8']"))).click();
        //comment
        WebElement enterComment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='17']")));
        enterComment.click();
        enterComment.sendKeys("BCS stands for Body Conditioning Scoring.");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 4)
    public void createTempAllTags(){

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        //temp
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Temp.']"))).click();
        //enter temperature
        WebElement enterTemperature = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterTemperature.click();
        enterTemperature.sendKeys("110");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //recorded by
        WebElement enterRecord = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterRecord.click();
        enterRecord.sendKeys("Best");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //comment
        WebElement enterComment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));
        enterComment.click();
        enterComment.sendKeys("Temperature is a measure of the average kinetic energy of the particles in an object.");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 5)
    public void createHealthNoteAllTag() throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        //health notes
        Thread.sleep(6000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Notes')]"))).click();
        //health note
        WebElement enterNotes = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterNotes.click();
        enterNotes.sendKeys("Health Conditions Find information about conditions.");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 6)
    public void createWatchList() throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(4000);
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(41,1804))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(72,1127))
                .release()
                .perform();
        //watch list
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'List')]"))).click();
        //to date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        //comment
        WebElement enterComment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterComment.click();
        enterComment.sendKeys("Internal Watch List");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
    }
    @Test(priority = 7)
    public void verifyCreateAnimalHealth() throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(4000);
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(616,1693))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(648,643))
                .release()
                .perform();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='  Save  ']"))).click();
        //pop up save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        //1400
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'1400')]//*[@index='1']"))).click();
        //animal health
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Animal Health')]"))).click();
        Thread.sleep(2000);
        touchAction.press(PointOption.point(590,1925))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(581,978))
                .release()
                .perform();
    }
}
