package pageObjects;

import BaseTest.BasePage;
import org.openqa.selenium.NoSuchElementException;;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class InventoryPage extends BasePage {
    @FindBy(tagName = "a")
    private List<WebElement> links;
    @FindBy(className = "footer")
    private WebElement footer;
    @FindBy(className = "inventory_item_img")
    private List<WebElement> inventoryImages;
    @FindBy(className = "shopping_cart_badge")
    private WebElement cart;
    //    @FindBy(xpath = "//*[@class='inventory_list']/child::div//*[contains(@class,'add-to-cart-button')]")
    @FindBy(className = "shopping_cart_container")
    private WebElement cartIcon;
    @FindBy(className = "btn_inventory")
    private List<WebElement> addToCartBtn;
    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNames;
    @FindBy(className = "inventory_item_desc")
    private List<WebElement> itemDescription;
    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemPrice;
    @FindBy(className = "product_sort_container")
    private WebElement sortingDropDownList;


    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isInitialised() {
        return footer.isDisplayed();
    }

    public void checkLinks() {
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {
            url = it.next().getAttribute("href");
            System.out.print(url);
            if (url == null || url.equals("")) {
                System.out.println(" URL is either not configured for anchor tag or it is empty");
                continue;
            }
            if (!url.startsWith(getHomepage())) {
                System.out.println(" URL belongs to another domain, skipping it");
                continue;
            }
            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.connect();
                respCode = huc.getResponseCode();
                if (respCode >= 400) {
                    System.out.println(" is a broken link");
                } else {
                    System.out.println(" is a valid link");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showlinks() {
        for (int i = 0; i < links.size(); i++) {
            // System.out.println(links.get(i));
        }
    }

    public String test() {
        return footer.getText();
    }

    public boolean doesFooterContains(String text) {
        return footer.getText().contains(text);
    }

    public boolean areImagesDisplayed() {
        Iterator<WebElement> it = inventoryImages.iterator();
        while (it.hasNext()) {
            if (!it.next().isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public void addToCart(int x) {
        try {
            for (int i = 0; i < x; i++) {
                addToCartBtn.get(i).click();
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    public void removeFromCart(int x) {
//        System.out.println("Remove method called: " + x);
        int i = 0;
        while (i < addToCartBtn.size() && x > 0) {
            if (addToCartBtn.get(i).getText().equals("REMOVE")) {
                addToCartBtn.get(i).click();
                x--;
            }
            i++;
        }

    }

    /**
     * @return cart counter, if 0 then the element wouldn't be found.
     */
    public int getCartItems() {

        try {
            return Integer.parseInt(cart.getText());
        } catch (NoSuchElementException e) {
//            System.out.println("Return 0 - No element");
            return 0;
        }

    }

    public void selectSortingFilter(String sortOption) {
        Select dropdown = new Select(sortingDropDownList);
        dropdown.selectByVisibleText(sortOption);
    }

    public boolean checkPriceSortedFromLowToHigh() {
        for (int i = 0; i < itemPrice.size() - 1; i++) {
//            System.out.println(itemPrice.get(i).getText().substring(1)+ "> " + Double.parseDouble(itemPrice.get(i+1).getText().substring(1)));
            if (Double.parseDouble(itemPrice.get(i).getText().substring(1)) > Double.parseDouble(itemPrice.get(i + 1).getText().substring(1))) {
                return false;
            }
        }
//        System.out.println("=================TESTING=============" + itemPrice.get(0).getText().substring(1));
        return true;
    }

    public boolean checkPriceSortedFromHighToLow() {
        for (int i = 0; i < itemPrice.size() - 1; i++) {
            if (Double.parseDouble(itemPrice.get(i).getText().substring(1)) < Double.parseDouble(itemPrice.get(i + 1).getText().substring(1))) {
                return false;
            }
        }
//        System.out.println("=================TESTING=============" + itemPrice.get(0).getText().substring(1));
        return true;
    }

    public boolean checkItemsAscendingOrder() {
        for (int i = 0; i < itemPrice.size() - 1; i++) {
//            System.out.println(itemPrice.get(i).getText().substring(1)+ "> " + Double.parseDouble(itemPrice.get(i+1).getText().substring(1)));
            if (itemNames.get(i).getText().compareTo(itemNames.get(i + 1).getText()) > 0) {
                return false;
            }
        }
//        System.out.println("=================TESTING=============" + itemPrice.get(0).getText().substring(1));
        return true;
    }

    public boolean checkItemsDescendingOrder() {
        for (int i = 0; i < itemPrice.size() - 1; i++) {
//            System.out.println(itemPrice.get(i).getText().substring(1)+ "> " + Double.parseDouble(itemPrice.get(i+1).getText().substring(1)));
            if (itemNames.get(i).getText().compareTo(itemNames.get(i + 1).getText()) < 0) {
                return false;
            }
        }
//        System.out.println("=================TESTING=============" + itemPrice.get(0).getText().substring(1));
        return true;
    }

    public CartPage clickOnCartIcon() {
        cartIcon.click();
        return new CartPage();
    }


}
