package day02_DriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethodlari {

    public static void main(String[] args) throws InterruptedException {

        //Biz browser'lari olusturdugumuz driver sayesinde otomate edebiliyoruz
        //bunun icin her testin basında mutlaka driver objesi olusturacagız
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver =new ChromeDriver();

        driver.get("https://www.amazon.com");
        //acilan sayfanin baslıgının amazon icerdigini test edin

        String expectedKelime ="amazon";
        String actualResult=driver.getTitle();

// software test expectedresult ve actualresult in karşılaştırılmasıdır.
//expectedResult=beklenen sonuç
//actualResult  =gerçek sonuç
//title =başlık
        if(actualResult.contains((expectedKelime))){  //amazon sayfasını içeriyorsa passed
            System.out.println("Title testi passed");
        }else{
            System.out.println("Title amazon icermiyor,test failed");
            System.out.println(driver.getTitle());
        }

        //gittiginiz sayfanın url'ini https://www.amazon.com/ oldugunu test edin

        String expectedUrl="https://www.amazon.com/";
        String actualUrl= driver.getCurrentUrl();
 //actual degerler her zaman driverla alınır

        if (expectedUrl.equals(actualUrl)){   //beklenen url gerçeklesen url e eşitse
            System.out.println("url testi passed");
        }else{
            System.out.println("url istediginiz degerde degil");
            System.out.println(driver.getCurrentUrl()); //url test edildi doğrusunu yazdırdı
        }

        Thread.sleep(5000);
        driver.close();
    }
}
