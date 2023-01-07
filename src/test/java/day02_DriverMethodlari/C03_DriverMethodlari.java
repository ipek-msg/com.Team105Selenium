package day02_DriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethodlari {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.amazon.com");
        System.out.println(driver.getPageSource());

        //pageSource 'un Meow icerdigini test edin

        String pageSourge = driver.getPageSource();

        String expectedKelime = "MEOW";
//contains =içerir demek.
        if (pageSourge.contains(expectedKelime)){
            System.out.println("page sourge testi Passed");
        }else {
            System.out.println("page sourge testi failed,MEOW kelimesi bulunamadi");
        }
    }
}
