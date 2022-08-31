package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegisterTest {
    public WebDriver driver;
     @Test
    public void RegisterMethod(){
         System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
     driver = new ChromeDriver();
     driver.get("https://demo.automationtesting.in/Register.html");
     driver.manage().window().maximize();

         WebElement FirstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
         String FirstNameValue ="Florin";
         FirstNameElement.sendKeys(FirstNameValue);

         WebElement LastNameElement = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
         String LastNameValue ="Oancea";
         LastNameElement.sendKeys(LastNameValue);

         WebElement AddressElement = driver.findElement(By.cssSelector("textarea[rows='3']"));
         String AddressValue ="Laminoristilor n18 Bloc C3 ap 21";
         AddressElement.sendKeys(AddressValue);

         WebElement EmailAddressElement = driver.findElement(By.xpath("//input[@type='email']"));
         String EmailAddressValue = "casadehartie@yahoo.co.uk";
         EmailAddressElement.sendKeys(EmailAddressValue);

         WebElement PhoneElement = driver.findElement(By.cssSelector("input[type='tel']"));
         String PhoneValue = "0754879451";
         PhoneElement.sendKeys(PhoneValue);

         WebElement GenderElement = driver.findElement(By.xpath("//input[@value='Male']"));
         GenderElement.click();

         WebElement HobbiesElement =driver.findElement(By.cssSelector("input[id='checkbox2']"));
         HobbiesElement.click();

         WebElement HobbiesElement2 = driver.findElement(By.xpath("//input[@id='checkbox3']"));
         HobbiesElement2.click();

        // WebElement LanguagesElement = driver.findElement(By.cssSelector("div[id='msdd']"));
        // LanguagesElement.click();

         WebElement PasswordElement = driver.findElement(By.xpath("//input[@id='firstpassword']"));
         String PasswordValue = "LapteParajit4";
         PasswordElement.sendKeys(PasswordValue);

         WebElement ConfirmPasswordElement = driver.findElement(By.cssSelector("input[id='secondpassword'"));
         String ConfirmPasswordValue = "LapteParajit4";
         ConfirmPasswordElement.sendKeys(ConfirmPasswordValue);




    }




}
