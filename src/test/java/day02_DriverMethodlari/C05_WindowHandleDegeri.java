package day02_DriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_WindowHandleDegeri {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.drive","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println(driver.getWindowHandle());//CDwindow-F5BBDAECD15E1712A38C10AF36100BB7
                                                     //unique bir deger döndürdü her yeni sayfa olusturdugun yeni unique bir referans deger verir.

        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://wisequarter.com");
        System.out.println(driver.getWindowHandle()); //getWindowHandle farklı pencerede açar

        Thread.sleep(3000);
        driver.quit();
    }
}
