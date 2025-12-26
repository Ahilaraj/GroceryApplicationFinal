package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	HomePage hp;
	ManageNewsPage mp;
	
	@Test (description ="user is trying to add news")

	
	public void verifyWhetherUserIsAbleToAddNewNews() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp =lp.clickOnLoginButton();
		
		
		
		mp =hp.clickOnManageNewsMoreinfo();
		
		String newstextvalue = ExcelUtility.getStringData(0, 0, "News");
		mp.clickOnNewButton().enterNewsContent(newstextvalue).clickOnSavebtn();
		
		boolean alertDisplayed = mp.isAlertTextDisplayed();
		Assert.assertTrue(alertDisplayed,Constant.ADDNEWSERROR);
		
		
		
	}
	
	@Test (description ="user is trying to search nely added news")
	public void verifyWhetherUserIsAbleToSearchNewlyAddedNews() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnLoginButton();
		
		//HomePage hp = new HomePage(driver);
		mp =hp.clickOnManageNewsMoreinfo();
		
		String searchnews = ExcelUtility.getStringData(0, 0, "News");
		mp.clickOnSearchbtn().searchNews(searchnews).clickOnSearchNewsbtn();
		
		boolean manageNewsDisplayed = mp.isManageNewsDisplayed();
		Assert.assertTrue(manageNewsDisplayed,Constant.SEARCHNEWSERROR);
	}
	
	@Test (description = "user is trying to reset the page")
	
	public void verifyUserIsAbleToReset() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp =lp.clickOnLoginButton();
		
		
		mp =hp.clickOnManageNewsMoreinfo();
		
		
		mp.clickOnReset();
		
		boolean manageNewsDisplayed = mp.isManageNewsDisplayed();
		Assert.assertTrue(manageNewsDisplayed,Constant.RESETNEWSERROR);
	}
}
