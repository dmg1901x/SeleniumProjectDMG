package login;


import org.openqa.selenium.By;

/**
 * Created by dmg01 on 5/24/2017.
 */
public class Overlay extends LandingPage {
    public static final By OVERLAY = By.xpath(".//*[contains(text(),'Item Added to Cart')]");
    public static final By SHOW_NEARBY_STORES = By.xpath(".//*[contains(text(),'Show Nearby Stores')]");
    public static final By FRAME_OVERLAY = By.xpath("(.//iframe[@class='thd-overlay-frame'])[2]");
    public static final By OVERLAY_DESC = By.xpath("(.//a[@target='_top'])[1]");


    public boolean verifyOverlayPage() {
        switchDriver("iframe", FRAME_OVERLAY);

        if (waitUntilElementDisplayed(OVERLAY)) {
            switchDriver("", "");      // This switches the focus back to the main page but does not close the iframe
            return true;
        }
        return false;
    }


    public boolean verifyOverlayPage2(int testItemNumber) {
        switchDriver("iframe", FRAME_OVERLAY);

        String overlaydesc = driver.findElement(OVERLAY_DESC).getText();
        if (waitUntilElementDisplayed(OVERLAY_DESC)) {

            switch(testItemNumber){
                case 1 :
                    if (overlaydesc.equals(Metrics.getTestItem1())) {
                        return true;
                    }
                case 2 :
                    if (overlaydesc.equals(Metrics.getTestItem2())) {
                        return true;
                    }
                case 3 :
                    if (overlaydesc.equals(Metrics.getTestItem3())) {
                        return true;
                    }
                break;
            }


//            if (overlaydesc.equals(Metrics.getTestItem1())) {
//                //switchDriver("", "");    //  This switches the focus back to the main page but does not close the iframe
//                return true;
//            }
        }
        return false;
    }


    public boolean verifyOverlayPage4() {
        switchDriver("iframe", FRAME_OVERLAY);

        if (waitUntilElementDisplayed(SHOW_NEARBY_STORES)) {
            // The Add to cart button is displayed
            enterTextIntoTextBox(".//input[@class='form-input__field']","1");
            enterTextIntoTextBox(ADD_QTY_TO_CART,"1");
            clickButton(ADD_TO_CART_ITEM_GALVANIZED);
            return true;
        }
        return false;
    }
}

