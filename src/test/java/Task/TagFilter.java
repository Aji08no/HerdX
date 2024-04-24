package Task;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TagFilter extends Herd{

    WebDriverWait wait;
    TouchAction touchAction;

    @BeforeClass
    public void homePage() throws InterruptedException {

        Thread.sleep(5000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        touchAction = new TouchAction(driver);
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
    public void filterAscending_Descending() throws InterruptedException {

        //Total Animals
        WebElement location1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
        location1.click();
        //search bar
        WebElement enterSearchValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
        enterSearchValue.click();
        enterSearchValue.sendKeys("pen");
        javaUtility.hideKeyBoard();


        //test pen
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'test pen')]"))).click();
        //Tag
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //show result
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show All')]"))).click();
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //descending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Descending')]"))).click();
        //show result
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show All')]"))).click();

        //Weight
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //ascending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Ascending')]"))).click();
        //weight
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Weight')]"))).click();
        //show result
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show All')]"))).click();
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //descending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Descending')]"))).click();
        //show result
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show All')]"))).click();

        //ADG
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //ascending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Ascending')]"))).click();
        //adg
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'ADG')]"))).click();
        //show result
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show All')]"))).click();
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //descending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Descending')]"))).click();
        //show result
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show All')]"))).click();

        //Time on yard
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //ascending//*[contains(@content-desc,'Ascending')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //time on yard//*[contains(@content-desc,'Time on Yard')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //show result//*[contains(@content-desc,'Show All')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //filter icon //android.widget.ImageView[@index='2']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //descending//*[contains(@content-desc,'Descending')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //show result//*[contains(@content-desc,'Show All')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();

        //Age
        //filter icon //android.widget.ImageView[@index='2']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //ascending//*[contains(@content-desc,'Ascending')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //age//*[contains(@content-desc,'Age')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //show result//*[contains(@content-desc,'Show All')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //filter icon //android.widget.ImageView[@index='2']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //descending//*[contains(@content-desc,'Descending')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //show result//*[contains(@content-desc,'Show All')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
    }

    @Test(priority = 1)
    public void selectRangeOFTags(){
        //filter icon //android.widget.ImageView[@index='2']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //from tag//android.widget.EditText[@index='0']
        WebElement enterFrom = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
        enterFrom.click();
        enterFrom.sendKeys("1055");
        //to tag//android.widget.EditText[@index='1']
        WebElement enterTo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
        enterTo.click();
        enterTo.sendKeys("1085");
        //show result//*[contains(@content-desc,'Show All')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //negativeFilter
        //filter icon //android.widget.ImageView[@index='2']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //from tag//android.widget.EditText[@index='0']
        WebElement enterFrom2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
        enterFrom2.click();
        enterFrom2.sendKeys("1055");
        //to tag//android.widget.EditText[@index='1']
        WebElement enterTo2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
        enterTo2.click();
        enterTo2.sendKeys("1085");
        //show result//*[contains(@content-desc,'Show All')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
    }

    @Test(priority = 2)
    public void filterBy(){
        //filter icon //android.widget.ImageView[@index='2']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //bull
        //bull//*[@content-desc='Bull']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //show result//*[contains(@content-desc,'Show All')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //filter icon //android.widget.ImageView[@index='2']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();

        //cow
        //cow//*[@content-desc='Cow']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //show result//*[contains(@content-desc,'Show All')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //filter icon //android.widget.ImageView[@index='2']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();


        //heifer
        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();
        //heifer//*[@content-desc='Heifer']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //show result//*[contains(@content-desc,'Show All')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //filter icon //android.widget.ImageView[@index='2']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();

        //steer
        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();
        //steer//*[@content-desc='Steer']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //show result//*[contains(@content-desc,'Show All')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //filter icon //android.widget.ImageView[@index='2']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();

        //not specified
        touchAction.press(PointOption.point(469,1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519,547))
                .release()
                .perform();
        //not specified//*[@content-desc='Not Specified']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //show result//*[contains(@content-desc,'Show All')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //filter icon //android.widget.ImageView[@index='2']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //clear//*[@content-desc='Clear All']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();

        //treatments
        touchAction.press(PointOption.point(492,1998))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(510,1303))
                .release()
                .perform();
        //treatment assigned//*[@content-desc='Treatment Assigned']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //show result//*[contains(@content-desc,'Show All')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //filter icon //android.widget.ImageView[@index='2']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();

        touchAction.press(PointOption.point(492,1998))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(510,1303))
                .release()
                .perform();
        //no treatment assigned//*[@content-desc='No Treatment Assigned']]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //show result//*[contains(@content-desc,'Show All')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //filter icon //android.widget.ImageView[@index='2']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //clear//*[@content-desc='Clear All']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();

        //840
        touchAction.press(PointOption.point(514,1998))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(478,510))
                .release()
                .perform();

        touchAction.press(PointOption.point(460,1655))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(428,704))
                .release()
                .perform();

        //840 tag assigned//*[@content-desc='USDA 840 Tag Assigned']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //show result//*[contains(@content-desc,'Show All')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //filter icon //android.widget.ImageView[@index='2']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();

        touchAction.press(PointOption.point(514,1998))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(478,510))
                .release()
                .perform();

        touchAction.press(PointOption.point(460,1655))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(428,704))
                .release()
                .perform();
        //840 tag no assigned//*[@content-desc='No USDA 840 Tag Assigned']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //show result//*[contains(@content-desc,'Show All')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
        //filter icon //android.widget.ImageView[@index='2']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();

    }
}
