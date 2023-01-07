package day02_DriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMetodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");

        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();//tam ekran yapmak icin  her zman yazmaya calsalım

        driver.navigate().to("http://www.amazon.com");
        //get ile ayni islevi görür

        Thread.sleep(3000);
        driver.get("https://wisequarter.com");

        Thread.sleep(3000);
        //yeniden amazon'a dönelim

        driver.navigate().back();

        Thread.sleep(3000);
        //tekrar wiseQuarter.com'a gitmek istersek

        driver.navigate().forward();




        Thread.sleep(3000);
        driver.quit();

    }
}
