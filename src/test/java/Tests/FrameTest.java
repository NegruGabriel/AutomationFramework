package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class FrameTest {
    public WebDriver driver;

    @Test
    public void RegisterMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Index.html");
        driver.manage().window().maximize();

        WebElement SkipSingUp = driver.findElement(By.id("btn2"));
        SkipSingUp.click();

        WebElement SwitchTo = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(SwitchTo).perform();

        WebElement Frames = driver.findElement(By.xpath("//a[text()='Frames']"));
        Frames.click();

        //navigam catre un url specific
        driver.navigate().to("https://demo.automationtesting.in/Frames.html");
        //Driver.get acceseaza un url si asteapta sa se incarce pagina.
        //Driver.navigate acceseaza un Url

        List<WebElement> FramesOptions = driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        FramesOptions.get(0).click();

        driver.switchTo().frame("singleframe");
        WebElement InputElement = driver.findElement(By.cssSelector("input[type='text']"));
        InputElement.sendKeys("wordul este minunat");

        driver.switchTo().defaultContent();

        FramesOptions.get(1).click();
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));
        WebElement InputMultipleElement = driver.findElement(By.cssSelector("input[type='text']"));
        InputMultipleElement.sendKeys("wordul este minunat");

    }
}
