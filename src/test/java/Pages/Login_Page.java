package Pages;

import Common.Attributes;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

    public AndroidDriver driver;
    public Login_Page(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @FindBy(how = How.ID,using= Attributes.Locator.whileAllowElement)
    private WebElement allow1;

    @FindBy(how = How.ID,using= Attributes.Locator.allowElement)
    private WebElement allow3;

    @FindBy(how = How.XPATH,using= Attributes.Locator.loginButton)
    private WebElement loginButton;

    @FindBy(how=How.XPATH,using = Attributes.Locator.assertHome)
    private  WebElement assertHome;

    @FindBy(how = How.XPATH,using = Attributes.Locator.assertLogin)
    private WebElement assertLogin;

    public void clickAllows() throws InterruptedException {
//        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
        allow1.click();
//        JavaUtility.explicitWaitID(Attributes.Locator.whileAllowElement);
        Thread.sleep(Attributes.TimeOut.sleep3);
        allow1.click();
        allow3.click();
    }
    public void loginButton(){
        loginButton.click();
    }
    public void enterMail(String mail) throws InterruptedException {
        WebElement mail1 = driver.findElement(By.xpath("(//*[@class='android.widget.EditText'])[1]"));
        mail1.click();
        Thread.sleep(1000);
        mail1.sendKeys(mail);
    }
    public void enterPassword(String password){
        WebElement password1 = driver.findElement(By.xpath("(//*[@class='android.widget.EditText'])[2]"));
        password1.click();
        password1.sendKeys(password);
    }
    public WebElement verifyHome(){
        WebElement verification = assertHome;
        return verification;
    }

    public WebElement verifyLogin(){
        WebElement verification = assertLogin;
        return verification;
    }
    public void closeApp(){
        driver.quit();
    }
}
