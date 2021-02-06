package com.caglauzel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class GittigidiyorTest {

    public  WebDriver driver;

    @Before
    public void driverKaldir(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\cagla\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        String url = "https://www.gittigidiyor.com/";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void testIslemleri() throws InterruptedException {

        Actions action = new Actions(driver);
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div"));
        action.moveToElement(btn).perform();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        WebElement kulaniciAdi= driver.findElement(By.xpath("//*[@id=\"L-UserNameField\"]"));
        kulaniciAdi.click();
        kulaniciAdi.sendKeys("caglauzel05@gmail.com");

        WebElement sifre= driver.findElement(By.id("L-PasswordField"));
        sifre.click();
        sifre.sendKeys("caglauzel05");

        WebElement loginTikla= driver.findElement(By.id("gg-login-enter"));
        loginTikla.click();

        WebElement arama= driver.findElement(By.xpath(" //*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input"));
        arama.click();
        arama.sendKeys("Bilgisayar");

        WebElement Bul= driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button"));
        Bul.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //2.sayfa açılır

        WebElement kaydir = driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", kaydir);
        Thread.sleep(500);

        WebElement tikla= driver.findElement(By.xpath(" //*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a"));
        tikla.click();

        //rastgele ürün seç

        WebElement urunSec= driver.findElement(By.xpath("//*[@id=\"item-info-block-616000870\"]/div/div[1]/div[1]/h3"));
        urunSec.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //sepete ekleme

        WebElement Sec= driver.findElement(By.id("add-to-basket"));
        Sec.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(300);

        //sepete git
        WebElement sepeteGit= driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[2]/a/div/div[2]"));
        sepeteGit.click();
        Thread.sleep(300);

        //ürün arttır
        WebElement urunArttir= driver.findElement(By.xpath("//*[@id=\"cart-item-456630039\"]/div[2]/div[4]/div/span[2]"));
        urunArttir.click();

        //ürünü sil
        WebElement urunSil= driver.findElement(By.xpath("//*[@id=\"cart-item-456630039\"]/div[2]/div[3]/div/div[2]/div/a[1]/span"));
        urunSil.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    //sayfayı kapatıp testi bitiriyoruz
    @After
    public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
    }
}