package Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class AlertTest {
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

        WebElement Alerts = driver.findElement(By.xpath("//a[text()='Alerts']"));
        Alerts.click();

        //navigam catre un url specific
        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
        //Driver.get acceseaza un url si asteapta sa se incarce pagina.
        //Driver.navigate acceseaza un Url

        List<WebElement>AlertOptions= driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        AlertOptions.get(0).click();

        WebElement AlertOkButton = driver.findElement(By.cssSelector("#OKTab>button"));
        AlertOkButton.click();

        Alert AlertOk = driver.switchTo().alert();
        AlertOk.accept();

        AlertOptions.get(1).click();

        WebElement CancelTabButton = driver.findElement(By.cssSelector("#CancelTab>button "));
        CancelTabButton.click();

        Alert AlertOkCancel = driver.switchTo().alert();
        AlertOkCancel.dismiss();

        AlertOptions.get(2).click();

        WebElement AlertWithTextBox = driver.findElement(By.cssSelector("#Textbox>button "));
        AlertWithTextBox.click();

        Alert AlertText = driver.switchTo().alert();
        AlertText.sendKeys("Nume Prenume");
        AlertText.accept();


    }
}
