import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasketPage extends BasePage{

    By productNameLocator = new By.ByCssSelector("a.a-link-normal span.a-size-medium ");


    public BasketPage(WebDriver driver){
        super(driver);
    }

    public boolean checkIfProductAdded() {
        return getProduct().size() > 0;
    }
    private List<WebElement> getProduct(){
        return findAll(productNameLocator);
    }
}
