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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

public class Multiple_DeleteAnimals extends Herd {

    String penName = "";
    String transferPenName = "";


    @Test(priority = 0)
    public void deletePenTagId() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(8));
        TouchAction touchAction = new TouchAction<>(driver);

        String path = "C:\\Users\\E-7\\IdeaProjects\\HerdX\\src\\main\\resources\\Imformation.properties";
        FileInputStream file = new FileInputStream(path);
        Properties pro = new Properties();
        pro.load(file);
        //Total Animals
        WebElement location1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
        location1.click();
        Thread.sleep(1000);

        try {
            WebDriverWait waitStart = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement penContent = waitStart.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='1'])[4]")));
            String content = penContent.getAttribute("content-desc");
            String[] lines = content.split("\\r?\\n");
            penName = lines[0];
            System.out.println("PenName : " + lines[0]);


            //pen count
            if (Integer.parseInt(lines[1]) > 2) {
                System.out.println("Before delete a tag id count : " + lines[1]);
                penContent.click();
                //tag
                WebElement tagContent = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='0'])[14]")));
                String content2 = tagContent.getAttribute("content-desc");
                String[] lines2 = content2.split("\\r?\\n");
                String getTagId = lines2[0].substring(4).trim();
                Thread.sleep(200);
//                tagId = getTagId;
//                System.out.println("Edit TagId :" + getTagId);

                try {
                    //menu dot
                    Thread.sleep(200);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
                    WebDriverWait waitBack = new WebDriverWait(driver, Duration.ofSeconds(8));
                    //select animals-manual
                    Thread.sleep(200);
                    waitBack.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Select Animals - M')]"))).click();
                } catch (Exception e) {
                    Thread.sleep(200);
                    System.out.println("Tags are under transfer");
                    //back arrow
                    Thread.sleep(2000);
                    driver.pressKey(new KeyEvent(AndroidKey.BACK));
//                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
                    Thread.sleep(200);
                    //back arrow
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

                    //plus icon create pen
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
                    //add pen/pasture
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
                    //enter add pasture
                    Random ran = new Random();
                    int outR = ran.nextInt(0, 10);
                    WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
                    enter.click();
                    String penName = "0aa" + outR;
                    transferPenName = penName;
                    Thread.sleep(200);
                    enter.sendKeys(transferPenName);
                    driver.hideKeyboard();
                    //pen
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
                    //save
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
                    //try
                    try {
                        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Added Successfully')]")));
                    } catch (Exception e1) {
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
                                String penName2 = "0aa" + outR;
                                transferPenName = penName2;
                                Thread.sleep(200);
                                enter.sendKeys(transferPenName);
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
                    //plus icon create inventory
                    Thread.sleep(5000);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

                    //Add animal to inventory
                    Thread.sleep(500);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

                    //Manual Entry
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
                    //Manual click arrow
                    Thread.sleep(200);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
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
                    Thread.sleep(500);
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
                    } catch (Exception e1) {
                        e1.getMessage();
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
                    int rNumber = r.nextInt(400, 499);
                    Thread.sleep(200);
                    fromEnter.sendKeys(rNumber + "0");

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
                                int rNumber1 = r1.nextInt(400, 499);
                                Thread.sleep(200);
                                fromEnter1.sendKeys(rNumber1 + "0");
                            } catch (Exception e3) {
                                condition = true;
                            }
                        }
                    } catch (Exception e2) {
                        System.out.println(e2.getMessage());
                    }

                    //get text
                    Thread.sleep(2000);
                    WebElement fromEnterValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='0']")));
                    String toEnter = fromEnterValue.getText().substring(0, 3);


                    //to enter
                    try {
                        boolean condition = false;

                        while (!condition) {
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
                                int rNumber2 = r2.nextInt(0, 10);
                                Thread.sleep(200);
                                enter2.sendKeys(toEnter + rNumber2);
                            } else {
                                condition = true;
                            }
                        }
                    } catch (Exception e1) {
                        System.out.println(e1.getMessage());
                    }
                    //tags count 54
                    WebElement tagsCount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[11]")));
                    String pageContent = tagsCount.getAttribute("content-desc");
                    String[] line = pageContent.split("\\r?\\n");
                    String createTags = line[3];
                    System.out.println("No.of created tags : " + createTags);
                    //view summary
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']"))).click();
                    //add animals to inventory
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
                    //yes
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();//pen content
                    WebElement penContent1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='1'])[4]")));
                    String content1 = penContent1.getAttribute("content-desc");
                    String[] lines1 = content1.split("\\r?\\n");
                    System.out.println("PenName : " + lines1[0]);
                    System.out.println("Before delete a tag id count : " + lines1[1]);
                    penContent1.click();
                    //menu dot
                    Thread.sleep(200);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

                    //select animals-manual
                    Thread.sleep(200);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Select Animals - M')]"))).click();
                }
            } else {
                System.out.println("Created new tags");
                //plus icon
                Thread.sleep(5000);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

                //Add animal to inventory
                Thread.sleep(500);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

                //Manual Entry
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
                //Manual click arrow
                Thread.sleep(200);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
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
                wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
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
                int rNumber = r.nextInt(400, 499);
                Thread.sleep(200);
                fromEnter.sendKeys(rNumber + "0");

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
                            int rNumber1 = r1.nextInt(400, 499);
                            Thread.sleep(200);
                            fromEnter1.sendKeys(rNumber1 + "0");
                        } catch (Exception e) {
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

                    while (!condition) {
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
                            int rNumber2 = r2.nextInt(0, 10);
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
                System.out.println("No.of created tags : " + createTags);
                //view summary
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']"))).click();
                //add animals to inventory
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
                //yes
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();

                WebElement penContent2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='1'])[4]")));
                String content2 = penContent2.getAttribute("content-desc");
                String[] lines2 = content2.split("\\r?\\n");
                System.out.println("Before delete a tag id count : " + lines2[1]);

                if (Integer.parseInt(lines2[1]) > 0) {
                    penContent2.click();
                    //tag
                    WebElement tagContent = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='0'])[14]")));
                    String tagD = tagContent.getAttribute("content-desc");
                    String[] lines3 = tagD.split("\\r?\\n");
                    String getTagId = lines3[0].substring(4).trim();
                    Thread.sleep(200);
//                    tagId = getTagId;
//                    System.out.println("created TagId :" + getTagId);
                    //menu dot
                    Thread.sleep(200);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

                    //select animals-manual
                    Thread.sleep(200);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Select Animals - M')]"))).click();

                } else {
                    System.out.println("Doesn't created the tag");
                }
            }
        } catch (Exception e) {
            //plus icon
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
            //add pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
            //enter add pasture
            WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            enter.click();
            Thread.sleep(100);
            penName = "Cartoon";
            enter.sendKeys("Cartoon");
            driver.hideKeyboard();
            //pen
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
            //save
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
            //try
            try {
                wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Added Successfully')]")));
                System.out.println("penName : " + penName);
            } catch (Exception e1) {
                boolean addCondition = true;
                while (addCondition) {
                    WebElement editText = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
                    if (editText.isDisplayed()) {
                        editText.click();
                        Thread.sleep(200);
                        editText.clear();
                        Random r = new Random();
                        int rNumber = r.nextInt(0, 99);
                        String generatePen = "Cartoon" + rNumber;
                        Thread.sleep(100);
                        penName = generatePen;
                        editText.sendKeys(generatePen);
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
                System.out.println("penName : " + penName);
            }
            System.out.println("Created new tags");
            //plus icon
            Thread.sleep(5000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

            //Add animal to inventory
            Thread.sleep(500);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

            //Manual Entry
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
            //Manual click arrow
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
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
            try {
                //EPC Prefix
                wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'No tags assigned to this organization')]")));
                System.out.println("No tags assigned to this organization! Please contact HerdX support.");
                //back arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

                //close pop up
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Close']"))).click();
                driver.pressKey(new KeyEvent(AndroidKey.BACK));
            } catch (Exception e1) {
                e1.getMessage();
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
            //multiple tags toggle
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.Switch"))).click();
            //from enter
            WebElement fromEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='0']")));
            fromEnter.click();
            Thread.sleep(200);
            Random r = new Random();
            int rNumber = r.nextInt(400, 499);
            Thread.sleep(200);
            fromEnter.sendKeys(rNumber + "0");

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
                        int rNumber1 = r1.nextInt(400, 499);
                        Thread.sleep(200);
                        fromEnter1.sendKeys(rNumber1 + "0");
                    } catch (Exception e3) {
                        condition = true;
                    }
                }
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }

            //get text
            Thread.sleep(2000);
            WebElement fromEnterValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'From')]//android.widget.EditText[@index='0']")));
            String toEnter = fromEnterValue.getText().substring(0, 3);


            //to enter
            try {
                boolean condition = false;

                while (!condition) {
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
                        int rNumber2 = r2.nextInt(0, 10);
                        Thread.sleep(200);
                        enter2.sendKeys(toEnter + rNumber2);
                    } else {
                        condition = true;
                    }
                }
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
            //tags count 54
            WebElement tagsCount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[11]")));
            String pageContent = tagsCount.getAttribute("content-desc");
            String[] line = pageContent.split("\\r?\\n");
            String createTags = line[3];
            System.out.println("No.of created tags : " + createTags);
            //view summary
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']"))).click();
            //add animals to inventory
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
            //yes
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();

            WebElement penContent2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='1'])[4]")));
            String content2 = penContent2.getAttribute("content-desc");
            String[] lines2 = content2.split("\\r?\\n");
            System.out.println("Before delete a tag id count : " + lines2[1]);
            penContent2.click();
            //tag
            WebElement tagContent = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='0'])[14]")));
            String tagD = tagContent.getAttribute("content-desc");
            String[] lines3 = tagD.split("\\r?\\n");
            String getTagId = lines3[0].substring(4).trim();
            Thread.sleep(200);
//                tagId = getTagId;
//                System.out.println("created TagId :" + getTagId);
            //menu dot
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

            //select animals-manual
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Select Animals - M')]"))).click();

        }

        Thread.sleep(1000);
        //select all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select All']"))).click();
        //quick actions
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Quick Actions']"))).click();
        //delete from inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Delete')]"))).click();


        Thread.sleep(1000);
        //accident scan
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Accidental Scan']"))).click();
        Thread.sleep(200);
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();

        try {
            WebElement nextButton = driver.findElement(By.xpath("//*[@content-desc='Next']"));
            //accident scan
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Accidental Scan']"))).click();
            Thread.sleep(200);
            //next
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();

        } catch (Exception e) {
            e.getMessage();
        }

        //delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']")));

        Thread.sleep(200);
        try {
            //delete
            driver.findElement(By.xpath("//*[@content-desc='Delete']")).click();
        } catch (StaleElementReferenceException s) {
            s.getMessage();
        }

        try {
            WebElement deleteButton = driver.findElement(By.xpath("//*[@content-desc='Delete']"));
            if (deleteButton.isDisplayed()) {
                Thread.sleep(200);
                deleteButton.click();
            }
        } catch (Exception e) {
            e.getMessage();

        }

        WebDriverWait loadWait = new WebDriverWait(driver, Duration.ofSeconds(50));
        loadWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));

        //pop up
        WebElement success = loadWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@content-desc,'Deleted')])[2]")));
        System.out.println(success.getAttribute("content-desc"));

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @Test(priority = 1)
    public void verifyDeleteAnimal() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //Total Animals
        Thread.sleep(1000);
        WebElement location1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
        location1.click();
        Thread.sleep(1000);
        //pen content
        WebElement verifyPenContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
        String verifyPen = verifyPenContent.getAttribute("content-desc");
        String[] line = verifyPen.split("\\r?\\n");
        int tagCount=0;
        if (line[0].equals(penName)) {
            System.out.println("After delete a tag id count : " + line[1]);
            Assert.assertEquals(Integer.parseInt(line[1]),tagCount);
            System.out.println("Verified Successfully");
        } else {
            WebElement inventorySearchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
            inventorySearchBar.click();
            Thread.sleep(200);
            inventorySearchBar.sendKeys(transferPenName);
            driver.hideKeyboard();
            WebElement verifyTransferPenContent=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[19]")));
            String verifyTransferPen = verifyTransferPenContent.getAttribute("content-desc");
            String[] lineTransfer = verifyTransferPen.split("\\r?\\n");

            if (lineTransfer[0].equals(transferPenName)) {
                System.out.println("After delete a tag id count : " + line[1]);
                Assert.assertEquals(Integer.parseInt(line[1]),tagCount);
                System.out.println("Verified Successfully");
            }
        }
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
