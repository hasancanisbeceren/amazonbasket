import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Add_Product_To_Cart extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    BasketPage basketPage;

    @Test
    @Order(1)
    public void search_a_product(){
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("laptop");
        Assertions.assertTrue(productsPage.isOnProductPage(),
                "Not on product page!");
    }

    @Test
    @Order(2)
    public void select_a_product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(1);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                "Not on product detail page!");
    }
    @Test
    @Order(3)
    public void add_product_basket(){
        productDetailPage.addToBasket();
        Assertions.assertTrue(homePage.isProductCountUp(),
                "Product count did not increase!");

    }
    @Test
    @Order(4)
    public void go_to_basket(){
        basketPage = new BasketPage(driver);
        homePage.goToBasket();
        Assertions.assertTrue(basketPage.checkIfProductAdded(),
                "Product was not added to basket!");
    }
}
