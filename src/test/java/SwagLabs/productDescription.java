package SwagLabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class productDescription {
    @Test
    public void productDetail()  throws InterruptedException{
        String baseUrl = "https://www.saucedemo.com/";
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get(baseUrl);

        // Menu Login
        String loginAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginAssert,"Swag Labs");

        //Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);

        //Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        Thread.sleep(3000);

        // Beranda Menu
        String inventoryAssert = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(inventoryAssert,"Products");
        Thread.sleep(1000);

        // Detail Produk
        String produk = "Sauce Labs Backpack";

        if (produk.equals("Sauce Labs Backpack")) {
            driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
            Thread.sleep(1000);

            String produkAssert = driver.findElement(By.xpath("//*[@class=\"inventory_item_container\"]//*[contains(text(), 'Sauce Labs Backpack')]")).getText();
            Assert.assertEquals(produkAssert,"Sauce Labs Backpack");
            Thread.sleep(1000);
        } else {
            // Code to be executed if 'produk' is not equal to "Sauce Labs Backpack"
            driver.close();
        }



        // Keluar Browser
        driver.close();

    }

}
