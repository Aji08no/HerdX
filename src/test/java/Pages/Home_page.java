package Pages;

import Test_Pages.MenuBarPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Home_page{

    AndroidDriver driver;
    public Home_page(AndroidDriver driver){
        this.driver=driver;
//        JavaUtility.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "(//*[@class='android.widget.ImageView'])[5]")
    private WebElement totalAnimal;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.ImageView'])[3]")
    private WebElement plusIcon;

    @AndroidFindBy(xpath = "//*[@index='0' and @class='android.widget.ImageView']")
    private WebElement addAnimalToInventory;

    public void clickTotalAnimal(){
        totalAnimal.click();
    }
    public void clickPlusIcon(){
        plusIcon.click();
    }
    public void clickAddAnimalToInventory(){

        addAnimalToInventory.click();
    }


}
