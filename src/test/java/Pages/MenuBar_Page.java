package Pages;

import Common.JavaUtility;
import Test_Pages.Engine;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuBar_Page extends Home_page{
    JavaUtility ju;

    AndroidDriver driver;
    public MenuBar_Page(AndroidDriver driver){
        super(driver);
        ju=new JavaUtility(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

//Create assigned readers
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@index='0'])[1]")
    private WebElement MenuBar;
    @AndroidFindBy(xpath = "//*[@content-desc='Settings']")
    private WebElement Settings;
    @AndroidFindBy(xpath = "//*[@content-desc='Name Your Readers']")
    private WebElement ReaderName;
    @AndroidFindBy(xpath = "(//android.view.View[@index='0']//android.widget.ImageView[@index='1'])[2]")
    private WebElement CreateEdiIcon;
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement EnterName;
    @AndroidFindBy(xpath = "//*[@content-desc='Apply']")
    private WebElement Apply;

    public void menuBarIcon(){
        ju.explicitWait(MenuBar).click();;

    }

    public void setting(){
        ju.explicitWait(Settings).click();
    }
    public void readerName(){
        ju.explicitWait(ReaderName).click();

    }
    public void createAliasName(){

        WebElement editICon = ju.explicitWait(CreateEdiIcon);
        editICon.click();
        WebElement enterName = ju.explicitWait(EnterName);
        enterName.click();
        enterName.sendKeys("pandya");
        ju.explicitWait(Apply).click();
    }



}
