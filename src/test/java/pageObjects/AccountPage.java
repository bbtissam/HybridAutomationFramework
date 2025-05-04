package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnLogout;
	
	public Boolean isMyAccountDisplayed() {
		try {
		return (myAccount.isDisplayed());
		}catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
}
