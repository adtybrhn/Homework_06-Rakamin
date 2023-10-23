package SwagLabs;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.FileReader;
import java.io.IOException;

public class ddtLogin {
    @Test
    public void login() throws InterruptedException {
        String baseUrl = "https://www.saucedemo.com/";
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions fo = new FirefoxOptions();
        fo.setHeadless(false);
        String csvDir = System.getProperty("user.dir")+"/src/test/data/testData.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvDir))){
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null){
                String userName = nextLine[0];
                String password = nextLine[1];
                String result   = nextLine[2];

                WebDriver driver = new FirefoxDriver(fo);
                driver.manage().window().maximize();
                driver.get(baseUrl);

                    //Input Form
                    driver.findElement(By.id("user-name")).sendKeys(userName);
                    Thread.sleep(1000);
                    driver.findElement(By.id("password")).sendKeys(password);
                    Thread.sleep(1000);

                    driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
                    Thread.sleep(3000);


                //Assertion
                if(result.equals("login sukses")){
                    String inventoryAssert = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
                    Assert.assertEquals(inventoryAssert,"Products");
                    Thread.sleep(3000);

                } else {
                    String loginGagalAssert = driver.findElement(By.xpath("//h3[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]")).getText();
                    Assert.assertEquals(loginGagalAssert,"Epic sadface: Username and password do not match any user in this service");
                    Thread.sleep(3000);
                }
                driver.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
