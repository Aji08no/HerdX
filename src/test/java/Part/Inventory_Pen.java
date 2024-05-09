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

public class Inventory_Pen extends Herd{

    WebDriverWait wait;
    WebDriverWait wait1;

    String penName="";

    String editPen="";


    @Test(priority = 0)
    public void createPen() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait1 = new WebDriverWait(driver, Duration.ofSeconds(8));

        //location
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@index='1']")));
        WebElement location = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
        String getLocationContent = location.getAttribute("content-desc");
        String[] locationContent = getLocationContent.split("\\r?\\n");
        System.out.println("Location name : "+locationContent[0]);

        Thread.sleep(5000);
        //Total animals
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


        //add pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
        //enter add pasture
        WebElement enterPName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterPName.click();
        Thread.sleep(100);
        enterPName.sendKeys("Jaguar");
        penName="Jaguar";
        driver.hideKeyboard();
        //pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        //try
        try {
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[ends-with(@content-desc,'Successfully')]")));

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
                    penName="Jaguar"+rNumber;
                    editText.sendKeys(penName);
                    driver.hideKeyboard();

                    //pasture
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
                    //save
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

                    try {
                        WebDriverWait loadWait=new WebDriverWait(driver,Duration.ofSeconds(3));
                        loadWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Enclosure Name Already Exists')]")));
                    }catch (Exception e2){
                        addCondition = false;
                    }

                }

            }
        }

        //successfully pop up
        WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[ends-with(@content-desc,'Successfully')]")));
        System.out.println(popUp.getAttribute("content-desc"));

        //search bar
        WebElement inventorySearchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
        inventorySearchBar.click();
        Thread.sleep(200);
        inventorySearchBar.sendKeys(penName);
        driver.hideKeyboard();
        //pen content
//        WebElement penContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[17]")));
//        String createPen = penContent.getAttribute("content-desc");
//        System.out.println(penContent.getAttribute("content-desc"));
//        String[] lineWord = createPen.split("\\r?\\n");
//        if(lineWord[0].equals(penName)){
//            System.out.println("Successfully created a new pen");
//        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'"+penName+"')]")));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }


    @Test(priority = 1)
    public void editPen() throws InterruptedException {

        Thread.sleep(1000);

        //search bar
        WebElement inventorySearchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
        inventorySearchBar.click();
        Thread.sleep(200);
        try {
            inventorySearchBar.sendKeys(penName);
        }
        catch (StaleElementReferenceException s){
            inventorySearchBar.sendKeys(penName);
        }
        driver.hideKeyboard();

        //pen menu icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'"+penName+"')]//android.widget.ImageView[@index='0']"))).click();


        //edit pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Edit Pen / Pasture']"))).click();

        //edit inputArea
        WebElement inputArea = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        inputArea.click();
        Random ran=new Random();
        Thread.sleep(200);
        inputArea.clear();
        editPen=penName+ran.nextInt(0,9);
        inputArea.sendKeys(editPen);
        driver.hideKeyboard();

        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        //try
        try {
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[ends-with(@content-desc,'Successfully')]")));

        }
        catch (Exception e1){
            boolean addCondition = true;
            while (addCondition){
                //search bar
                WebElement inventorySearchBar1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
                inventorySearchBar1.click();
                Thread.sleep(200);
                inventorySearchBar1.clear();
                try {
                    inventorySearchBar1.sendKeys(penName);
                }
                catch (StaleElementReferenceException s){
                    inventorySearchBar1.sendKeys(penName);
                }
                driver.hideKeyboard();

                //pen menu icon
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'"+penName+"')]//android.widget.ImageView[@index='0']"))).click();


                //edit pen/pasture
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Edit Pen / Pasture']"))).click();

                WebElement editText = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
                if (editText.isDisplayed()){
                    editText.click();
                    Thread.sleep(200);
                    editText.clear();
                    Random r=new Random();
                    int rNumber = r.nextInt(0, 99);
                    Thread.sleep(100);
                    editPen=penName+rNumber;
                    editText.sendKeys(editPen);
                    driver.hideKeyboard();

                    //save
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

                    try {
                        WebDriverWait loadWait=new WebDriverWait(driver,Duration.ofSeconds(3));
                        loadWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Enclosure Name Already Exists')]")));
                    }catch (Exception e2){
                        addCondition = false;
                    }

                }

            }
        }

        //successfully pop up
        WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[ends-with(@content-desc,'Successfully')]")));
        System.out.println(popUp.getAttribute("content-desc"));

        //search bar
        WebElement inventoryEditSearchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
        inventoryEditSearchBar.click();
        Thread.sleep(200);
        inventoryEditSearchBar.clear();
        inventoryEditSearchBar.sendKeys(editPen);
        driver.hideKeyboard();
        //pen content
        WebElement penContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[19]")));
        String createPen = penContent.getAttribute("content-desc");
        String[] lineWord = createPen.split("\\r?\\n");
        if(lineWord[0].equals(editPen)){
            System.out.println("Successfully edited pen");
        }
    }

    @Test(priority = 2)
    public void deletePen() throws InterruptedException {

        Thread.sleep(1000);

        //search bar
        WebElement inventorySearchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
        inventorySearchBar.click();
        Thread.sleep(200);
        inventorySearchBar.clear();
        try {
            inventorySearchBar.sendKeys(editPen);
        }
        catch (StaleElementReferenceException s){
            inventorySearchBar.sendKeys(editPen);
        }
        driver.hideKeyboard();

        //pen menu icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'"+penName+"')]//android.widget.ImageView[@index='0']"))).click();


        //delete pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete Pen / Pasture']"))).click();

        //delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']"))).click();

        //successfully pop up
        WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[ends-with(@content-desc,'Successfully')]")));
        System.out.println(popUp.getAttribute("content-desc"));

        //verify delete
        inventorySearchBar.click();
        Thread.sleep(200);
        inventorySearchBar.clear();
        try {
            inventorySearchBar.sendKeys(editPen);
        }
        catch (StaleElementReferenceException s){
            inventorySearchBar.sendKeys(editPen);
        }

        driver.hideKeyboard();
        WebElement deleteConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.view.View[@index='0'])[17]")));
        String deleteConfirmContent = deleteConfirm.getAttribute("content-desc");
        String[] lineWord = deleteConfirmContent.split("\\r?\\n");
        System.out.println(lineWord[0]);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }
}