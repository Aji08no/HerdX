package Task;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TasksFilter extends Herd{
    WebDriverWait wait;

    @Test(priority = 0)
    public void SortBy() throws InterruptedException {
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        //tasks
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Tasks')]"))).click();
        //filter icon
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //date descending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Due Date (Descending)']"))).click();
        //show result//*[contains(@content-desc,'Show')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //filter icon
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //date ascending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Date Created (Ascending)')]"))).click();
        //show result//*[contains(@content-desc,'Show')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //filter icon
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //date ascending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Date Created (Descending)')]"))).click();
        //show result//*[contains(@content-desc,'Show')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();
    }

    @Test(priority = 1)
    public void filterBy() throws InterruptedException {
        //filter icon
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //clear all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Clear All']"))).click();
        //all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='All'])[1]"))).click();
        // show result//*[contains(@content-desc,'Show')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //clear all //*[@content-desc='Clear All']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Clear All']"))).click();
        // show result//*[contains(@content-desc,'Show')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //manoj
        //filter icon
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //manoj
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=' Manoj']"))).click();
        //you
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='You']"))).click();
        //show result //*[contains(@content-desc,'Show')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //angappan
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //angappan
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Angappan G']"))).click();
        //manoj
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=' Manoj']"))).click();
        //show result //*[contains(@content-desc,'Show')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //sankar
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //sankar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=' Sankar']"))).click();
        //angappan
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Angappan G']"))).click();
        //show result //*[contains(@content-desc,'Show')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //samuel kishore
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //samuel krishore
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='samuel kishore']"))).click();
        //sankar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=' Sankar']"))).click();
        //show result //*[contains(@content-desc,'Show')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //samuel kumar
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //samuel kumar//*[@content-desc=' Samuelkumar']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=' Samuelkumar']"))).click();
        //samuel krishore
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='samuel kishore']"))).click();
        //show result //*[contains(@content-desc,'Show')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //priya pro
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //priya pro//*[@content-desc='Priya Pro']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Priya Pro']"))).click();
        //samuel kumar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=' Samuelkumar']"))).click();
        //show result //*[contains(@content-desc,'Show')]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //abraham
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //abraham
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=' Abraham']"))).click();
        //priya pro
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Priya Pro']"))).click();
        //show result
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

    }

    @Test(priority = 2)
    public void taskStatus(){
        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //clear all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Clear All']"))).click();
        //scroll
        TouchAction touchAction=new TouchAction<>(driver);
        touchAction.press(PointOption.point(451,1948))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(424,1353))
                .release()
                .perform();

        //completed
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pending']"))).click();
        //show result
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

        //filter icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
        //clear all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Clear All']"))).click();
        touchAction.press(PointOption.point(451,1948))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(424,1353))
                .release()
                .perform();
        //pending
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Completed']"))).click();
        //show result
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Show')]"))).click();

    }


}
