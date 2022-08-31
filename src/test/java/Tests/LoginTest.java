package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    public WebDriver driver;


    @Test
    public void LoginMethod(){
        //Setam driverul de Chrome
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        //deschidem un browser
        driver=new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Index.html");
        driver.manage().window().maximize();

        WebElement SingInElement =driver.findElement(By.id("btn1"));
        SingInElement.click();

        WebElement EmailElemnt = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String EmailValue ="email@YAHOO.COM";
        EmailElemnt.sendKeys(EmailValue);

        WebElement PasswordElement = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String PasswordValue ="acasa21";
        PasswordElement.sendKeys(PasswordValue);

        WebElement EnterElement = driver.findElement(By.id("enterbtn"));
        EnterElement.click();

        //Validam un mesaj de eroare
        WebElement ErrorElement = driver.findElement(By.id("errormsg"));
        String ActualResult = ErrorElement.getText();
        String ExpectedResult ="Invalid User Name or PassWord";
        Assert.assertEquals(ActualResult,ExpectedResult);

        //Ca sa inchidem un btowser ne folosim de quit
        //Ca sa inchidem un tab dintr-un browser ne folosim de close

       // driver.quit();

    }

}
