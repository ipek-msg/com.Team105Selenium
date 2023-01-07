package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C03_RelativeLocators {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //2- Berlini 3 farklı relative locate ile locate edin

        WebElement sailorElementi=driver.findElement(By.xpath("//p[text()='Sailor']"));
        WebElement berlin1= driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailorElementi));



        //Boston'ın sağı

        WebElement bostonElementi= driver.findElement(By.xpath("//p[text()='Boston']"));
          //tarif etmek istediginiz webelementin bir özelliğini kullanurız
        //orn:tagname=img

        WebElement berlin2= driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(bostonElementi));

        //NewYorkCity altındaki

        WebElement nyc= driver.findElement(By.xpath("//p[text()='NYC']"));
        WebElement berlin3= driver.findElement(RelativeLocator.with(By.tagName("img")).below(nyc));

        //eger bir tane elementten tarif ettiğimizde yinede bulamazsak
        //birden fazla refere edebiliriz.

        WebElement berlin4= driver.findElement(RelativeLocator.with(By.tagName("img"))
                .below(nyc)
                .toRightOf(bostonElementi)
                .above(sailorElementi));



        //normal aratmalarda bulamazsak relative locater yaparız yani berlinin sağındaki solundaki aşağısında ki üsütündeki gibi aratabiliriz

        //3-Relative locator'ların dogru calıstıgını test edin
        // id'si   pid7_thumb oldugunu test edelim

        String expectedIdDegeri="pid7_thumb";
        String actualIdDegeri=berlin1.getAttribute("Id");

        if (expectedIdDegeri.equals(actualIdDegeri)){
            System.out.println("Relative Locater testi Passed");
        }else{
            System.out.println("Relative Locater testi Failed");
        }
        driver.close();
    }
}
