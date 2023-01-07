package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByClassName {
    public static void main(String[] args) throws InterruptedException {
        //amazon'a gidip nutella icin arama yapin
        //ilk sayfada cıkan urunlerin icerisinde
        //en yuksek fiyati bulun

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        List<WebElement> fiyatlarListesi = driver.findElements(By.className("a-price-whole"));

        //WebElement bir obje oldugundan direk yazdırılamaz
        System.out.println(fiyatlarListesi);

        //bunun icin for-each loop kullanarak
        //her bir webElement uzerindeki yaziları tek tek yazdırmalıyız

        for (WebElement each : fiyatlarListesi
        ) {
            System.out.print(each.getText() + " ");
//sonucu aralarında boslukla yanyana yazmak icin print yapıp +" " ekledik

        }

        //en yüksek fiyati bulabilmek icin java bilgimizi kullanmalıyız
        //1-web elementlerden getText ile fiyati String olarak alin
        //2-string fiyati kıyaslama yapabilmek icin Integer'a cevirin
        //3-en yüksek fiyatı bulup yazdırın

        String fiyatStr;
        Integer fiyatInt;
        Integer enYuksekFiyat = 0;
        for (WebElement each : fiyatlarListesi
        ) {
            fiyatStr = each.getText();
            fiyatInt = Integer.parseInt(fiyatStr);

            if ((fiyatInt > enYuksekFiyat)) {
                enYuksekFiyat = fiyatInt;
            }
        }

        System.out.println("");
        System.out.println("en yuksek urun fiyati :" + enYuksekFiyat);

        Thread.sleep(3000);
        driver.close();
    }

}
