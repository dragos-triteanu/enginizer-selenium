package com.enginizer.testing.pages;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {

	@Resource(name = "webDriver")
	private WebDriver webDriver;

	@Value("${page.login.url}")
	private String URL;

	@FindBy(how = How.ID, using = "coretailorUsername")
	private WebElement loginUsernameInput;

	@FindBy(how = How.ID, using = "coretailorPassword")
	private WebElement loginPasswordInput;

	@FindBy(how = How.ID, using = "login")
	private WebElement loginButton;

	@FindBy(how = How.ID, using = "resetPassword")
	private WebElement resetPasswordButton;

	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/form/table/tbody/tr[4]/td/span/div")
	private WebElement failedLoginText;

	@FindBy(how = How.XPATH, using = "")
	private WebElement homeButton;

	@PostConstruct
	public void init() {
		PageFactory.initElements(webDriver, this);
	}

	public void login(String username, String password) {
		loginUsernameInput.sendKeys(username);
		loginPasswordInput.sendKeys(password);
		loginButton.click();
	}

	public void clickOnResetPassword() {
		resetPasswordButton.click();
	}

	public void open() {
		webDriver.get(URL);
	}

	public String getURL() {
		return URL;
	}

	public String getErrorMessageText() {
		return failedLoginText.getText();
	}

	public void goHome() {
		this.webDriver.findElement(By.xpath("//form[@id='homePageLinkForm']//a")).click();
	}
}
