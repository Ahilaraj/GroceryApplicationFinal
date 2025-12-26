package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add'and contains (@class,'btn btn-rounded btn-danger')]") WebElement newbutton;
	@FindBy(id="news") WebElement newstext;
	@FindBy(name="create") WebElement savebtn;
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-primary' and @href='javascript:void(0)']") WebElement searchbtn;
	@FindBy(name="un") WebElement searchnewstitle;
	@FindBy(name="Search") WebElement searchbtnnews;
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-warning' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']") WebElement reset;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertText;
	@FindBy(xpath="//h1[@class='m-0 text-dark' and text()='Manage News']")WebElement managenewstext;
	
	
	public ManageNewsPage clickOnNewButton()
	{
		newbutton.click();
		return this;
	}
	
	public ManageNewsPage enterNewsContent(String newstextvalue)
	{
		newstext.sendKeys(newstextvalue );
		return this;
	}
	
	public ManageNewsPage clickOnSavebtn()
	{
		savebtn.click();
		return this;
	}
	
	public ManageNewsPage clickOnSearchbtn()
	{
		searchbtn.click();
		return this;
	}
	
	public ManageNewsPage searchNews(String searchnews)
	{
		searchnewstitle.sendKeys(searchnews);
		return this;
	}
	
	public ManageNewsPage clickOnSearchNewsbtn()
	{
		searchbtnnews.click();
		return this;
	}
	
	public ManageNewsPage clickOnReset()
	{
		reset.click();
		return this;
	}
	
	public boolean isManageNewsDisplayed()
	{
		return managenewstext.isDisplayed();
	}
	public boolean isAlertTextDisplayed()
	{
		return alertText.isDisplayed();
	}
}
