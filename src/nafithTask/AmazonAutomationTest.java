package nafithTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AmazonAutomationTest extends BaseTest {
    String URL = "https://www.amazon.com";
    String userName = "mousafaisal987@gmail.com";
    String password = "0798240484";

    @Test
    public void amazonLoginTest() {

        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));

        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(userName);
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();


    }

    @Test(dependsOnMethods = "amazonLoginTest")
    public void amazonPurchaseTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));

        searchForProduct("laptop");
        selectProduct();
        goToCart();
        proceedToCheckout();
    }

    public void searchForProduct(String productName) {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        searchBox.sendKeys(productName);
        searchBox.submit();
    }

    public void selectProduct() {
        driver.findElement(By.xpath("//*[@id=\"a-autoid-2-announce\"]")).click();
    }

    public void goToCart() {
        driver.findElement(By.xpath("//*[@id=\"ewc-compact-actions-container\"]/div/div[2]/span/span/a")).click();
    }

    public void proceedToCheckout() {
        driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input")).click();
    }
}

//Please note that I could not proceed with the 'place an order' method because it requires payment details beforehand
