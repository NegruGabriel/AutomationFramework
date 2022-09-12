package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest {
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

        WebElement Windows = driver.findElement(By.xpath("//a[text()='Windows']"));
        Windows.click();

        //navigam catre un url specific
        driver.navigate().to("https://demo.automationtesting.in/Windows.html");

        List<WebElement> WindowsOptions= driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        WindowsOptions.get(0).click();

        WebElement TabButton = driver.findElement(By.cssSelector("#Tabbed>a>button"));
        TabButton.click();

        //Cand lucram cu tab/window trebuie sa mutam noi focusul unde ne dorim.
        List<String>TabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(TabList.get(1));
        driver.close();
        driver.switchTo().window(TabList.get(0));

        WindowsOptions.get(1).click();
        WebElement WindowButton = driver.findElement(By.cssSelector("#Seperate>button"));
        WindowButton.click();
        List<String>WindowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(WindowsList.get(1));
        driver.close();
        driver.switchTo().window(WindowsList.get(0));

        WindowsOptions.get(2).click();
        WebElement TabsButton = driver.findElement(By.cssSelector("#Multiple>button"));
        TabsButton.click();
        List<String>TabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(TabsList.get(2));
        driver.close();
        driver.switchTo().window(TabsList.get(1));
        driver.close();
        driver.switchTo().window(TabsList.get(0));

    }
}
