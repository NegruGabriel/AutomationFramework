package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterTest {
    public WebDriver driver;
     @Test
    public void RegisterMethod(){
         System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
     driver = new ChromeDriver();
     driver.get("https://demo.automationtesting.in/Index.html");
     driver.manage().window().maximize();

     WebElement SkipSingUp = driver.findElement(By.id("btn2"));
     SkipSingUp.click();

     WebElement FirstNameElement = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
     String FirstNameValue = "Andrei";
     FirstNameElement.sendKeys(FirstNameValue);

     WebElement LastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
     String LastNameValue = "Scripcaru";
     LastNameElement.sendKeys(LastNameValue);

     WebElement AddressElement = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
     String AddressValue = "Strada Laminoristilor nr 15 Bloc C3 Am 21";
     AddressElement.sendKeys(AddressValue);

     WebElement EmailAddressElement = driver.findElement(By.cssSelector("input[type='email']"));
     String EmailAddressValue = "andrei.sc@YAHOO.CO.UK";
     EmailAddressElement.sendKeys(EmailAddressValue);

     WebElement PhoneElement = driver.findElement(By.xpath("//input[@ng-model='Phone']"));
     String PhoneValue = "0730058000";
     PhoneElement.sendKeys(PhoneValue);

     WebElement GenderElement = driver.findElement(By.cssSelector("input[value='Male']"));
     GenderElement.click();

     WebElement Hobbies1Element = driver.findElement(By.xpath("//input[@id='checkbox1']"));
     Hobbies1Element.click();

     WebElement Hobbies2Element = driver.findElement(By.cssSelector("input[id='checkbox2']"));
     Hobbies2Element.click();

     WebElement Hobbies3Element = driver.findElement(By.xpath("//input[@id='checkbox3']"));
     Hobbies3Element.click();

     WebElement PasswordElement = driver.findElement(By.cssSelector("input[id='firstpassword']"));
     String PasswordValue = "parola buna";
     PasswordElement.sendKeys(PasswordValue);

     WebElement ConfirmPasswordElement = driver.findElement(By.xpath("//input[@id='secondpassword']"));
     String ConfirmPasswordValue = "parola buna";
     ConfirmPasswordElement.sendKeys(ConfirmPasswordValue);

     WebElement SkillsElement = driver.findElement(By.id("Skills"));
      Select SkillsSelect = new Select(SkillsElement);
      SkillsSelect.selectByVisibleText("AutoCAD");

      WebElement YearBoxElement = driver.findElement(By.id("yearbox"));
      Select YearBoxSelect = new Select(YearBoxElement);
      YearBoxSelect.selectByVisibleText("1950");

      WebElement MonthBoxElement = driver.findElement(By.cssSelector("select[ng-model='monthbox']"));
      Select MonthBoxSelect = new Select(MonthBoxElement);
      MonthBoxSelect.selectByVisibleText("March");

      WebElement DayBoxElement = driver.findElement(By.id("daybox"));
      Select DayBoxSelect = new Select(DayBoxElement);
      DayBoxSelect.selectByVisibleText("25");




      WebElement LanguagesElement = driver.findElement(By.id("msdd"));
      LanguagesElement.click();

      List<WebElement> LanguagesOptions = driver.findElements(By.cssSelector(".ui-autocomplete>li>a"));
      for (Integer index =0; index<LanguagesOptions.size(); index++){
       if (LanguagesOptions.get(index).getText().equals("English") || LanguagesOptions.get(index).getText().equals("Romanian") ){
        LanguagesOptions.get(index).click();
       }
      }
      GenderElement.click();

      WebElement SelecetCountryElement = driver.findElement(By.cssSelector(".select2-container"));
      SelecetCountryElement.click();

      WebElement SelectCountryElement = driver.findElement(By.className("select2-search__field"));
      String SelectCountryValue= "Japan";
      SelectCountryElement.sendKeys(SelectCountryValue);
      SelectCountryElement.sendKeys(Keys.ENTER);





    }




}
