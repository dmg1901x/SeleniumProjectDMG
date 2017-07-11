package login;

import login.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by RXC8414 on 5/11/2017.
 */
public class LandingPage extends MainPage {
    public static final String LANDING_PAGE = ".//span[@class='original-keyword u__regular' and contains(text(),'TO_REPLACE')]";
    //public static final String ADD_TO_CART_ITEM = "(.//span[@class='bttn__content' and text() = 'Add To Cart'])[]";
    public static final String ADD_TO_CART_ITEM = "(.//span[@class='bttn__content' and text() = 'Add To Cart'])";
    public static final String ADD_TO_CART_ITEM_GALVANIZED = "(.//button[@class='bttn bttn--primary']//span[@class='bttn__content' and text() = 'Add To Cart'])";
    public static final String ADD_QTY_TO_CART = ".//input[@class='form-input__field']";
    public static final String WRAPPER = ".//div[contains(@class,'plp-pod plp-pod--default pod-item--')]";
    public static final String PRICE = ".//div[@class='price']";
    public static final String DESCRIPTION = ".//div[@class='pod-plp__description js-podclick-analytics']//a";
    public static final String GALVANIZED = ".//*[contains(text(),'Galvanized')]";
    public static final String HUSKY = ".//*[contains(text(),'Husky')]";
    public static final String PICKITUP = "(.//div[contains(text(),'Pick it up')])";
    public static final String CLOSE_OVERLAY = ".//a[@class='u__default-link' and  contains(text(),'Continue Shopping')]";
    public static final String GAL_DESC = "(.//header[@class='thd-overlay__header']//h2[@class='u__medium' and contains(text(),'Galvanized')])";
    public static final String CART_ITEM_COUNT = "(.//span[@class='MyCart__itemCount' and text() = '[]'])";
    public static final String CART = "(.//span[@class='MyCart__itemCount'])";
    public static final String CURRENT_CNT = ".//span[@class='Inventory-Stock__quantity']";
    public static final String CART_WRAPPER = ".//div[@class='cartItem']";
    public static final String HAMMER = ".//*[contains(text(),'Hammer')]";


    ///////// Using the By class /////////
    public static final By DESC = By.xpath(".//div[@class='pod-plp__description js-podclick-analytics']//a");


    // Keeping this as a sample reference for now
    public boolean verifyAnyAddToCartButtonCanBeSelected(String element1, String element2, int index) {
        System.out.println("Got to Here 0 " + element1);
        if (waitUntilElementDisplayed(element1)) {
            System.out.println("Got to Here 1");
            element2 = insertIndexIntoXpath(element2, index);
            System.out.println("Got to Here 2");
            if (waitUntilElementDisplayed(element2)) {
                driver.findElement(By.xpath(element2)).click();
                return true;
            }
        }
        return false;
    }


    public boolean verifyLandingPage(String item) {
        String str = LANDING_PAGE;
        str = str.replace("TO_REPLACE", item);
        if (super.verifyLandingPage(str)) {
            return true;
        }
        return false;
    }


    public boolean validateItemDescriptionFromPrice() {
        if (waitUntilElementDisplayed(WRAPPER)) {
            for (WebElement element : getElements(WRAPPER)) {
                String price = element.findElement(By.xpath(PRICE)).getText();
                price = price.substring(1, price.length() - 2);
                int thePrice = Integer.parseInt(price);
                if (thePrice >= 10 && thePrice < 15) {
                //if (thePrice >= 359 && thePrice < 360) {
                    String desc = element.findElement(By.xpath(DESCRIPTION)).getText();
                    System.out.println("          " + desc);
                    System.out.println("          Price ~ " + price);

                    // Store the item description for future reference
                    Metrics.setTestItem1(desc);

                    // Actually add the item to the cart by clicking
        //            String element2 = insertIndexIntoXpath(ADD_TO_CART_ITEM, 1);
        //            String element2 = ADD_TO_CART_ITEM;
                    element.findElement(By.xpath(ADD_TO_CART_ITEM)).click();

                    return true;
                }
            }
        }
        return false;
    }


    public boolean validateItemDescriptionForGalvanized() {
        if (waitUntilElementDisplayed(WRAPPER)) {
            for (WebElement element : getElements(WRAPPER)) {
                if (waitUntilElementDisplayed(GALVANIZED)) {
                    // Verified that "Galvanized" is in the title page

                    // Store the item description for future reference
                    String desc = element.findElement(By.xpath(DESCRIPTION)).getText();
                    System.out.println("          " + desc);
                    Metrics.setTestItem2(desc);

                    String element2 = insertIndexIntoXpath(ADD_TO_CART_ITEM, 1);
                    if (waitUntilElementDisplayed(element2)) {
                        element.findElement(By.xpath(element2)).click();
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean verifyCartItemCount(int cartItemCount){
        String element = insertIndexIntoXpathTwo(CART_ITEM_COUNT, cartItemCount);
        if (waitUntilElementDisplayed(element)) {
            return true;
        }
        return false;
    }


    public boolean verifyCart(){
        if (driver.findElement(By.xpath(CART)).isDisplayed()){
            driver.findElement(By.xpath(CART)).click();
            return true;
        }
        return false;
    }


    public boolean updateHammer(){
        for (WebElement element : getElements(CART_WRAPPER)) {
            try {
                if (waitUntilElementDisplayed(HAMMER)) {
                    String hammerQTY = element.findElement(By.xpath(PRICE)).getText();

                }
            } catch (Exception e){
            }
        }
        return false;
    }



    public boolean validateItemDescriptionScrewdriver() {
        int cnt = 0;
        String husky;
        String pickitup;
        if (waitUntilElementDisplayed(WRAPPER)) {
            for (WebElement element : getElements(WRAPPER)) {
                husky = "";
                pickitup = "";
                try {
                    husky = element.findElement(By.xpath(HUSKY)).getText();
                    try {
                        pickitup = element.findElement(By.xpath(PICKITUP)).getText();
                        cnt++;
                        if (cnt == 2) {
                            String desc = element.findElement(By.xpath(DESCRIPTION)).getText();
                            System.out.println("          " + desc);
                            // Store the item description for future reference
                            Metrics.setTestItem3(desc);
                            // Actually add the item to the cart by clicking
                            String element3 = insertIndexIntoXpath(ADD_TO_CART_ITEM, 1);
                            element.findElement(By.xpath(element3)).click();

                            String currentCount = element.findElement(By.xpath(CURRENT_CNT)).getText();
                            System.out.println("Current item inventory = " + currentCount);
                            Metrics.setTestItem3Count(currentCount);

                            return true;
                        }
                    } catch (Exception e){
                    }
                } catch (Exception e){
                }
            }
        }
        return false;
    }


    public boolean closeCartOverlayWindow(){
        if (driver.findElement(By.xpath(CLOSE_OVERLAY)).isDisplayed()) {   // Verify displayed...
            driver.findElement(By.xpath(CLOSE_OVERLAY)).click();           // Actually click
            return true;
        }
        return false;
    }
}


