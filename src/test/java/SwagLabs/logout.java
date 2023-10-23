package SwagLabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class logout {
    @Test
    public void logOut()  throws InterruptedException{
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
        Thread.sleep(3000);

        // Logout
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(1000);

        // Keluar Browser
        driver.close();

    }
}
