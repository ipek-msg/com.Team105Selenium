package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ByName {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();//ekran pencere ayarı genelde maximize ayarlanır
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//bu bekleme sayfa açılması icin verilen süre

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.name("field-keywords"));
        //locate ettigimiz aramaya bir web element ekleriz
        //field keywords amazon sayfasından aldıgımız isim

        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //önce nutellayı aratacak sonra enter tusuna basacak (keys.ENTER)



        Thread.sleep(3000);
        driver.close();

    }
}
