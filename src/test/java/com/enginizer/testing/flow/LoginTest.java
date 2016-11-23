package com.enginizer.testing.flow;

import com.enginizer.testing.flow.base.BaseTest;
import com.enginizer.testing.pages.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Resource(name = "webDriver")
    private WebDriver webDriver;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private IntroPage introPage;

    @Autowired
    private BusinessPage businessPage;

    @Value("${account.crc.username}")
    private String crcUsername;

    @Value("${account.crc.password}")
    private String crcPassword;

    @Value("${account.admin.username}")
    private String adminUsername;

    @Value("${account.admin.password}")
    private String adminPassword;

    /**
     * Validates flow from T1 to T4
     */
    @Test
    public void shouldLoginAndLogoutAsACRCUser() throws InterruptedException {
        introPage.open();
        introPage.clickOnLogin();
        loginPage.login(crcUsername, crcPassword);
        businessPage.clickOnLogout();
        TimeUnit.SECONDS.sleep(2);
        businessPage.confirmOnPopup();

        assertEquals(webDriver.getCurrentUrl(), loginPage.getURL() + "?logout=true");
    }

}
