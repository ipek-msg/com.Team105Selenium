package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ByLinkText {
    public static void main(String[] args) throws InterruptedException {
        //amazon anasayfay agidin
        //gift cards linkine tıklayın
        //gift cards sayfasına gittigini test edin

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

       // WebElement giftCardLinki= driver.findElement(By.linkText("Gift Cards"));

        Thread.sleep(4000);
        WebElement giftCardLinki= driver.findElement(By.partialLinkText("Gift"));

        //By.linkText linkin hepsini yazılmasını ister
        //by.partialLinkTexte linkin bir kısmını yazabiliriz örn;Gift Card ,Gift gibi

        giftCardLinki.click();

        //istenen sayfaya gittigini test etmek icin
        //title in gift card icerdigini test edebiliriz

        String expectedKelime ="Gift Cards";
        String actualTitle= driver.getTitle();

        if(actualTitle.contains(expectedKelime)){
            System.out.println("Gift Cards testi Passed");
        }else {
            System.out.println("Gift Cards testi Failed");
        }

         driver.close();
    }
}
