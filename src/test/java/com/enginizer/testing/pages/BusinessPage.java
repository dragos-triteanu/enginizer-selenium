package com.enginizer.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class BusinessPage {

    @Resource(name = "webDriver")
    private WebDriver webDriver;

    @Value("${page.study.url}")
    private String URL;

    @FindBy(how = How.ID, using = "logoutBtn")
    private WebElement logoutButton;

    @FindBy(how = How.ID, using = "okBtn")
    private WebElement popupOKButton;

    @FindBy(how = How.ID, using = "CRCActions:patientListingHomeBtn")
    private WebElement patientsListButton;

    @FindBy(how = How.ID, using = "CRCActions:endStudyHomeBtn")
    public WebElement endStudyButton;

    @FindBy(how = How.XPATH, using = "//p[@id='event_Visit1']//a")
    private WebElement visit1Button;
    @FindBy(how = How.ID, using = "CRCActions:signHomeBtn")
    public WebElement doctorSignatureButton;

    @FindBy(how = How.ID, using = "CRCActions:missingDataCountPriorityActionBtn")
    public WebElement missingDataButton;

    @FindBy(how = How.XPATH, using = "//*[text()='Visit 2 Week 26']")
    private WebElement visit2Button;

    @FindBy(how = How.XPATH, using = "//*[@id='event_AdverseEventEvent']/a")
    private WebElement adverseEventButton;

    @FindBy(how = How.ID, using = "event_form:newEventLink")
    private WebElement newEventEntryButton;

    @FindBy(how = How.XPATH, using = "//a/img[@src='/rwedctest/resources/images/tabs/back_arrow.gif']")
    private WebElement generalBackButton;

    @PostConstruct
    public void init() {
        PageFactory.initElements(webDriver, this);
    }

    public String getURL() {
        return URL;
    }

    public void open() {
        webDriver.get(URL);
    }

    public void clickOnLogout() {
        logoutButton.click();
    }

    public void confirmOnPopup() {
        popupOKButton.click();
    }

    public void clickOnPatient(String patientNumber) {
        webDriver.findElement(By.xpath("//tbody[@id='usersForm:j_idt197_data']//td[.='" + patientNumber + "']")).click();
    }

    public void clickOnVisit1Button() {
        this.visit1Button.click();
    }

    public void clickOnVisit2Button() {
        visit2Button.click();
    }

    public boolean checkIfGreenCheckAppeared() {
        return webDriver.findElement(By.xpath("//*[@id=\"form_status\"]/img[@src=\"/rwedctest/resources/images/stat_k.gif\"]")).isDisplayed();
    }

    public void clickOnVisitInfoButton() {
        this.webDriver.findElement(By.xpath("//p[@id='task_VisitInformation']//a")).click();
    }

    public void clickOnCOPDDiseaseDataButton() {
        this.webDriver.findElement(By.xpath("//p[@id='task_COPDDiseaseData']//a")).click();
    }

    public void clickOnCOPDQuestionaireButton() {
        webDriver.findElement(By.xpath("//p[@id='task_COPDQuestionnaire']//a")).click();
    }

    public void clickOnVisitReviewButton() {
        this.webDriver.findElement(By.xpath("//p[@id='task_VisitReview']//a")).click();
    }

    public boolean reasonFormIsDeplayed() {
        WebElement reasonForm;
        try {
            reasonForm = webDriver.findElement(By.id("reason_form"));
        } catch (Exception e) {
            return false;
        }

        return reasonForm.isDisplayed();
    }

    public void clickOnRadioButtonOfEditReasonForm() {
        webDriver.findElement(By.id("reason_form:rfc_radio:0")).click();
    }

    public void clickOnSaveButtonForReasonForm() {
        webDriver.findElement(By.id("reason_form:save")).click();
    }

    public void clickOnPatientListingsButton() {
        this.patientsListButton.click();
    }

    public void clickOnAdverseEventButton() {
        adverseEventButton.click();
    }

    public void clickOnNewAdverseEventEntry() {
        newEventEntryButton.click();
    }

    public void clickOnEndStudyButton() {
        endStudyButton.click();
    }

    public void selectPatientByNumber(String patientNumber) {
        this.webDriver.findElement(By.id("usersForm:j_idt197:j_idt198:filter")).click();

        this.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.webDriver.findElement(By.id("usersForm:j_idt197:j_idt198:filter")).sendKeys(patientNumber);

        this.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.webDriver.findElement(By.xpath("//tbody[@id='usersForm:j_idt197_data']//td[.='" + patientNumber + "']")).click();
    }

    public String getStatusOfPacient(String pacientID) {
        return this.webDriver.findElement(By.cssSelector("tr[data-rk='" + pacientID + "'] :last-child")).getText();
    }

    public void clickOnDoctorSignatureButton() {
        doctorSignatureButton.click();
    }

    public void clickOnMissingDataButton() {
        missingDataButton.click();
    }

    public void clickOnGeneralBackButton() {
        generalBackButton.click();
    }

}
