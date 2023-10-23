package SwagLabs.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class swagLabs_stepDef {
    String baseUrl = "https://www.saucedemo.com/";
    WebDriver driver = new FirefoxDriver();

    @Given("Halaman Login SwagLabs")
    public void halamanLoginSwagLabs() {
        WebDriverManager.firefoxdriver().setup();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        // Menu Login
        String loginAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginAssert,"Swag Labs");
    }

    @When("Input username")
    public void inputUsername()throws InterruptedException{
        //Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
    }

    @And("Input password")
    public void inputPassword() throws InterruptedException{
        //Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
    }

    @And("Klik button login")
    public void klikButtonLogin() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        Thread.sleep(1000);
    }

    @Then("Berhasil masuk halaman menu inventory")
    public void berhasilMasukHalamanMenuInventory() throws InterruptedException {
        // Beranda Menu
        String inventoryAssert = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(inventoryAssert,"Products");
        Thread.sleep(1000);

    }

    @And("Input password salah")
    public void inputPasswordSalah() throws InterruptedException {
        //Password
        driver.findElement(By.id("password")).sendKeys("xxxxxx");
        Thread.sleep(1000);
    }

    @Then("Muncul alert pada menu login")
    public void munculAlertPadaMenuLogin() throws InterruptedException {
        String loginGagalAssert = driver.findElement(By.xpath("//h3[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]")).getText();
        Assert.assertEquals(loginGagalAssert,"Epic sadface: Username and password do not match any user in this service");
        Thread.sleep(1000);
    }

    @When("Input (.*) as username$")
    public void inputUsernameUsername(String userName) throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys(userName);
        Thread.sleep(1000);
    }

    @And("Input (.*) as password$")
    public void inputPasswordPassword(String password) throws InterruptedException{
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
    }


    @And("Pilih (.*) as produk$")
    public void pilihProdukProduk(String produk) throws InterruptedException {

        if (produk.equals("Sauce Labs Backpack")) {
            driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
            Thread.sleep(1000);
        } else {
            // Code to be executed if 'produk' is not equal to "Sauce Labs Backpack"
            driver.close();
        }

    }

    @Then("Tampilan detail produk")
    public void tampilanDetailProduk() throws InterruptedException{
        String inventoryAssert = driver.findElement(By.xpath("//*[@class=\"inventory_item_container\"]//*[contains(text(), 'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(inventoryAssert,"Sauce Labs Backpack");
        Thread.sleep(1000);

    }

    @And("Klik add to cart")
    public void klikAddToCart() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);
    }

    @Then("Cek item dalam keranjang")
    public void cekItemKeranjang() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]")).click();
        Thread.sleep(1000);

        String inventoryAssert = driver.findElement(By.xpath("//span[contains(text(), 'Your Cart')]")).getText();
        Assert.assertEquals(inventoryAssert,"Your Cart");

    }

    @And("Keluar dari Browser")
    public void keluarDariBrowser() {
        driver.close();
    }

    @And("Klik button checkout")
    public void klikButtonCheckout() throws InterruptedException {
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(1000);
    }

    @And("Klik button continue")
    public void klikButtonContinue() throws InterruptedException {
        driver.findElement(By.id("continue")).click();
        Thread.sleep(1000);
    }

    @And("Klik button finish")
    public void klikButtonFinish() throws InterruptedException {
        driver.findElement(By.id("finish")).click();
        Thread.sleep(1000);
    }


    @And("Input (.*) as firstname$")
    public void inputFirstname(String firstname) throws InterruptedException {
        driver.findElement(By.id("first-name")).sendKeys(firstname);
        Thread.sleep(1000);
    }

    @And("Input (.*) as lastname$")
    public void inputLastname(String lastname) throws InterruptedException {
        driver.findElement(By.id("last-name")).sendKeys(lastname);
        Thread.sleep(1000);
    }

    @And("Input (.*) as zip$")
    public void inputZip(String postalcode) throws InterruptedException {
        driver.findElement(By.id("postal-code")).sendKeys(postalcode);
        Thread.sleep(1000);
    }



    @Then("Verifikasi Pesanan")
    public void verifikasiPesanan() {
        String inventoryAssert = driver.findElement(By.xpath("//span[contains(text(), 'Checkout: Overview')]")).getText();
        Assert.assertEquals(inventoryAssert,"Checkout: Overview");
    }

    @And("Klik menu logout")
    public void klikMenuLogout() throws InterruptedException{
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(1000);

    }

}
