package pageObjects;

import BaseTest.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(className = "btn_inventory")
    private List<WebElement> addToCartBtn;


    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    public  boolean isInitialised(){
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
            if (url == null || url == "") {
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
//        addToCartBtn.get(i).getAttribute("button").toString();
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    public void removeFromCart(int x) {
//        System.out.println("Remove method called: " + x);
        int i = 0;
        while (i < addToCartBtn.size() && x > 0) {
            if (!addToCartBtn.get(i).getText().equals("REMOVE")) {
//                System.out.println("i = " + i + addToCartBtn.get(i).getText());
//                i++;
            } else {
                addToCartBtn.get(i).click();
//                System.out.println("Click remove i = " + i + ", x = " + x);
                x--;
//                i++;
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
            System.out.println("Return 0 - No element");
            return 0;
        }

    }
}
