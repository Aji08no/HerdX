package Test_Pages;

import Common.Attributes;
import org.testng.annotations.Test;

public class HomePage extends Engine {


    @Test(enabled = true, priority = 0)
    public void createTagId() throws InterruptedException {

        javaUtility.explicitWaitXpath(Attributes.Locator.totalXpath);
        home.clickTotalAnimal();
        javaUtility.explicitWaitXpath(Attributes.Locator.plusIconXpath);
        home.clickPlusIcon();
        javaUtility.explicitWaitXpath(Attributes.Locator.addAnimalsToInventoryXpath);
        home.clickAddAnimalToInventory();

    }
}
