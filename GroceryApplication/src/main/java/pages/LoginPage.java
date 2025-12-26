package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Wait;

public class LoginPage {

public WebDriver driver;

public LoginPage(WebDriver driver)
{
this.driver = driver;
PageFactory.initElements(driver, this); // initElements - method is used to find elements
}

Wait wt = new Wait();

@FindBy(name="username")WebElement username; // @FindBy - used to find elements
@FindBy(name="password")WebElement password;
@FindBy(xpath="//button[text()='Sign In']")WebElement loginbutton;
@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement logintext;



public LoginPage enterUserNameOnUserNameField(String usernamevalue) // instead of void we given the page name were user go after this method call. here user still on the same page thats why return is this(chaining)
{
username.sendKeys(usernamevalue);
return this;
}

public LoginPage enterPasswordOnPasswordField(String passwordvalue) //chaining
{
password.sendKeys(passwordvalue);
return this;
}

public HomePage clickOnLoginButton() //after clicking user go to homepage that's why instead of void HomePage used (chaining)
{
	wt.waitUntilElementToBeClickable(driver, loginbutton);
loginbutton.click();
return new HomePage(driver); // driver control needs to be in homepage 
}

public boolean isDashboardDisplayed()
{
	return dashboard.isDisplayed(); // method return boolean value
}


public String isTitleDisplayed()
{
	return logintext.getText();
	
}

} 

