package com.enginizer.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class IntroPage {

    @Resource(name = "webDriver")
    private WebDriver webDriver;

    @Value("${page.study.url}")
    private String URL;

    @PostConstruct
    public void init() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.ID, using = "login")
    private WebElement studyLoginButton;

    public void clickOnLogin() {
        studyLoginButton.click();
    }

    public String getURL() {
        return URL;
    }

    public void open(){
        webDriver.get(URL);
    }

}
