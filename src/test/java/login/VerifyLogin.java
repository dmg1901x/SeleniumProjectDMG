package login;
import org.junit.*;
import org.openqa.selenium.By;

import java.util.ArrayList;

/**
 * Created by dmg01 on 5/25/2017.
 */
public class VerifyLogin {
    public static final String HOME_PAGE = "http://homedepot.com/";
    // Instantiation of our Utilities class
    static Overlay utils = new Overlay();

    // All my DOM objects
    public static String item;


    @BeforeClass
    public static void setupTHD() {
        // Open URL page based on the driver object
        Assert.assertTrue("Test(1.0) Could not validate main page.",
                utils.navigateURL(HOME_PAGE));
        System.out.println("Setup(1.1) Validated successful navigation to " + HOME_PAGE);
    }

    public void setup(String item) {
        //Search for header search bar and enter 'item'
        System.out.println("----------------------------------------------");
        Assert.assertTrue("Setup(1.1) Could not validate search box.",
                utils.enterItemIntoSearchBox(utils.SEARCH_BOX, item));
        System.out.println("Setup(1.1) Validated search box is present and entered " + item);


        // Click on search button
        Assert.assertTrue("Setup(1.2) Could not validate search button.",
                utils.clickButton(utils.SEARCH_BUTTON));
        System.out.println("Setup(1.2) Validated search button is present and event = click.");


        // Verify we land on the correct page = Landing Page
        Assert.assertTrue("Setup(1.3) Could not validate that the landing page contained the item",
                utils.verifyLandingPage(item));
        System.out.println("Setup(1.3) Validated landing contains word " + item);
    }


    @Test
    public void getDescriptionHammer() {
        item = "hammer";
        setup(item);

        Assert.assertTrue("(2.0) Could not verify the item from price",
                utils.validateItemDescriptionFromPrice());
        System.out.println("(2.0) Validated the item price between $10 & $15");

        // Verify we land at the Overlay after selecting Add To Cart
        Assert.assertTrue("(3.1) Could not verify Overlay division and Item Added to Cart phrase.",
                utils.verifyOverlayPage());
        System.out.println("(3.1) Validated Overlay for 'Item Added to Cart'");
        System.out.println("(3.2) and... Validated the 'Item Added to Cart' phrase");
//        utils.driver.switchTo().defaultContent();   // Switch focus back to the default   (No need here; the switch is done in the verifyOverlayPage method)

        // Verify that the original item selected matches the item actually added to the cart
        Assert.assertTrue("(3.3) Could not verify Overlay Item description matches the original item selected.",
                utils.verifyOverlayPage2(1));
        System.out.println("(3.3) and... The selected item does match the originally identified item.");

        // Verify the Overlay can be closed
        Assert.assertTrue("(4.0) Could not close the Cart Overlay",
                utils.closeCartOverlayWindow());
        System.out.println("(4.0) The Cart Overlay successfully closed");

        utils.driver.switchTo().defaultContent();   // Switch focus back to the default

        // Verify we land on the correct page = Landing Page
        Assert.assertTrue("3.6) Could not validate that focus was returned to landing page",
                utils.verifyLandingPage(item));
        System.out.println("(3.6) Validated the return to focus to the landing page for " + item);

//    }


//    @Test
//    public void getDescriptionGalvanizedNail() {
        item = "nail";
        setup(item);

        item = "nail galvanized";
        setup(item);


        Assert.assertTrue("(5.1) Could not verify the Galvanized nail",
                utils.validateItemDescriptionForGalvanized());
        System.out.println("(5.1) Validated the Galvanized nail");


        // Verify we land at the Overlay after selecting Add To Cart
        Assert.assertTrue("(5.2) Could not verify Overlay division with: Show Nearby Stores phrase etc.",
                utils.verifyOverlayPage4());
        System.out.println("(5.2) Validated the Show Nearby Stores phrase");
        System.out.println("(5.3) and... Validated the 'Add to Cart' phrase");
        System.out.println("(5.4) and... added '1' to the Quantity");


        // Verify we land at the Overlay after selecting Add To Cart
        Assert.assertTrue("(5.5) Could not verify Overlay division and Item Added to Cart phrase.",
                utils.verifyOverlayPage());
        System.out.println("(5.5) Validated Overlay for 'Item Added to Cart'");
        System.out.println("(5.6) and... Validated the 'Item Added to Cart' phrase");


        // Verify that the original item selected matches the item actually added to the cart
        Assert.assertTrue("(5.7) Could not verify Overlay Item description matches the original item selected.",
                utils.verifyOverlayPage2(2));
        System.out.println("(5.7) and... The selected item does match the originally identified item.");


        // Verify the Overlay can be closed
        Assert.assertTrue("(5.8) Could not close the Cart Overlay",
                utils.closeCartOverlayWindow());
        System.out.println("(5.8) The Cart Overlay successfully closed");

        utils.driver.switchTo().defaultContent();   // Switch focus back to the default

        // Verify we land on the correct page = Landing Page
        Assert.assertTrue("5.9) Could not validate that focus was returned to landing page",
                utils.verifyLandingPage(item));
        System.out.println("(5.9) Validated the return to focus to the landing page for " + item);


        // Verify the Cart Item count
        Assert.assertTrue("(5.10) Could not validate the item count",
                utils.verifyCartItemCount(2));
        System.out.println("(5.10) Validated the item count");
//    }


//    @Test
//    public void getDescriptionScrewDriver() {
        item = "screwdriver";
        setup(item);

        Assert.assertTrue("(6.1) Could not verify the Husky screwdriver",
                utils.validateItemDescriptionScrewdriver());
        System.out.println("(6.1) Validated the Husky screwdriver");

        // Verify we land at the Overlay after selecting Add To Cart
        Assert.assertTrue("(6.2) Could not verify Overlay division and Item Added to Cart phrase.",
                utils.verifyOverlayPage());
        System.out.println("(6.2) Validated Overlay for 'Item Added to Cart'");
        System.out.println("(6.3) and... Validated the 'Item Added to Cart' phrase");

        // Verify that the original item selected matches the item actually added to the cart
        Assert.assertTrue("(6.4) Could not verify Overlay Item description matches the original item selected.",
                utils.verifyOverlayPage2(3));
        System.out.println("(6.4) and... The selected item does match the originally identified item.");

        // Verify the Overlay can be closed
        Assert.assertTrue("(6.5) Could not close the Cart Overlay",
                utils.closeCartOverlayWindow());
        System.out.println("(6.5) The Cart Overlay successfully closed");

        utils.driver.switchTo().defaultContent();   // Switch focus back to the default

        // Verify we land on the correct page = Landing Page
        Assert.assertTrue("6.6) Could not validate that focus was returned to landing page",
                utils.verifyLandingPage(item));
        System.out.println("(6.6) Validated the return to focus to the landing page for " + item);

        //---------------------------------------------------------------------------------------------
        // Test #14

        // Verify the Cart Item count
        Assert.assertTrue("(14.1) Could not validate the cart sub total page",
                utils.verifyCart());
        System.out.println("(14.1) Validated the cart sub total page");
    }


    @AfterClass
    public static void cleanUp() {
        // Close the driver
        utils.driver.close();
        report();
    }


    public static void report() {
        System.out.println("=======================================");
        System.out.println("Program output:");
        System.out.println("");
        System.out.println("Hammer:       " + Metrics.getTestItem1());
        System.out.println("Nail:         " + Metrics.getTestItem2());
        System.out.println("Screwdriver:  " + Metrics.getTestItem3());
        System.out.println("Available Screwdrivers in store:  " + Metrics.getTestItem3Count());

    }
}
