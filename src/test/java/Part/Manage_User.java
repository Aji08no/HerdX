package Part;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Manage_User extends Herd{

    String name="";

    @Test(priority = 0)
    public void createUser() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(8));

        //menu icon
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //manage user
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Manage Users']"))).click();


        Thread.sleep(6000);
        // plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

        //enter name
        WebElement enterName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and @index='1']")));
        Random r=new Random();
        enterName.click();
        Thread.sleep(200);
        int ran = r.nextInt(0, 25);
        name="Hardik"+ran;
        enterName.sendKeys(name);
        driver.hideKeyboard();
        //enter mail
        WebElement enterMail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and @index='3']")));
        enterMail.click();
        Thread.sleep(500);
        enterMail.sendKeys("qaqc11no20"+ran+"@gmail.com");
        driver.hideKeyboard();

        //check box
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.CheckBox']"))).click();

        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Save')]"))).click();

        //created pop up
        try {
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Successfully')]")));
        }
        catch (Exception e){
            //enter name
            WebElement name1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and @index='1']")));
            WebElement mail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));

            boolean condition = true;
            while (condition){
                Random r1=new Random();
                int ran1 = r1.nextInt(0, 25);
                name1.click();
                Thread.sleep(200);
                name1.clear();
                name="Hardik"+ran1;
                name1.sendKeys(name);
                driver.hideKeyboard();
                mail.click();
                Thread.sleep(200);
                mail.clear();
                mail.sendKeys("qaqc11no20"+ran1+"@gmail.com");
                driver.hideKeyboard();

                //save
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

                try {
                    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'already exist')]")));
                }
                catch (Exception e1){
                    condition = false;
                }
            }

        }

        //pop up
//        WebElement success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Successfully')]")));
//        System.out.println(success.getAttribute("content-desc"));

        Thread.sleep(500);
        //verify search bar
        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and @index='2']")));
        searchBar.click();
        Thread.sleep(200);
        searchBar.sendKeys(name);
        driver.hideKeyboard();
        //get name
        WebElement nameContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@index='4']")));
        String verifyName = nameContent.getAttribute("content-desc");
        String[] line = verifyName.split("\\r?\\n");
        Assert.assertEquals(line[0],name);
        System.out.println("User created successfully");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @Test(priority = 1)
    public void createOperationUser() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(8));
        Thread.sleep(2000);
        //manage user
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Manage Users']"))).click();

        Thread.sleep(2000);
        //verify search bar
        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and @index='2']")));
        searchBar.click();
        Thread.sleep(200);
        searchBar.sendKeys(name);
        driver.hideKeyboard();

        //edit icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@index='4']//android.widget.ImageView[@index='1']"))).click();
        //check box
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.CheckBox[@index='4']"))).click();
        //location
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Select Location']"))).click();
        //location drop down
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'A t')]"))).click();
        //role
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='9']"))).click();
        //role drop down
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Loc Operation User')]"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Save')]"))).click();
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(2000);
        //manage user
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Manage Users']"))).click();

        Thread.sleep(2000);
        //verify search bar
        WebElement searchBarV = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and @index='2']")));
        searchBarV.click();
        Thread.sleep(200);
        searchBarV.sendKeys(name);
        driver.hideKeyboard();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Loc Operation User')]")));

        System.out.println("Loc Operation User created successfully");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @Test(priority = 2)
    public void createSuperUser() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(8));
        Thread.sleep(2000);
        //manage user
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Manage Users']"))).click();

        Thread.sleep(2000);
        //verify search bar
        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and @index='2']")));
        searchBar.click();
        Thread.sleep(200);
        searchBar.sendKeys(name);
        driver.hideKeyboard();

        //edit icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@index='4']//android.widget.ImageView[@index='1']"))).click();

        //role
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='9']"))).click();
        //role drop down
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Loc Super User')]"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Save')]"))).click();
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(2000);
        //manage user
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Manage Users']"))).click();

        Thread.sleep(2000);
        //verify search bar
        WebElement searchBarV = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and @index='2']")));
        searchBarV.click();
        Thread.sleep(200);
        searchBarV.sendKeys(name);
        driver.hideKeyboard();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Loc Super User')]")));

        System.out.println("Loc Super User created successfully");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

}
