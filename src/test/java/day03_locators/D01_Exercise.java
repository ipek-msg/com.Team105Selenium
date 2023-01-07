package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class D01_Exercise {
    public static void main(String[] args) {

        //1-Bir test class'i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        //3- Sayfada 147 adet Link bulundugunu test edin
        List<WebElement> linkListesi =driver.findElements(By.tagName("a"));
        //linkler birden fazla olacağı icin findElements kullanıldı
        //bütün linklerin tagı "a " oldugu icin tagname e a yazıldı.
        if(linkListesi.size()==147){
            System.out.println("link testi passed");
        }else{
            System.out.println("sayfada"+linkListesi.size()+"adet link var,test failed");

        }
        //4-products Linkine tıklayın

       //driver.findElement(By.linkText(" Products")).click(); linkText'le çalışmadı / partialLinkText'le oldu

        driver.findElement(By.partialLinkText(" Products")).click();

        //5-special offer yazisinin gorundugunu test edin

        WebElement specialOfferElementi=driver.findElement(By.id("sale_image")); //locate edildi

//test etmek icin if kullandık
//isDisplayed = görüntüleme
//eğer specialOfferElementi.isDisplayed(görünüyorsa)
//sout(passed)
//else
//sout(failed)
        if (specialOfferElementi.isDisplayed()){
            System.out.println("special offer testi PASSED");
        }else {
            System.out.println("special offer testi FAİLED");

        }
        /*

        NoSuchElementException driver findElement ile aradigi bir elementi bulamazsa olusur.

         */

        //6-sayfayi kapatin.
        driver.close();
    }
}
