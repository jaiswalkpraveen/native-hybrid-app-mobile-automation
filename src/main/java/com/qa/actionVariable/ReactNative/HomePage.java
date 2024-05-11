package com.qa.actionVariable.ReactNative;

import com.qa.Interfaces.IHomePage;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class HomePage extends ActionUtils implements IHomePage {

    //Landing Page
    @iOSXCUITFindBy(accessibility = "roomIdInput")
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public static MobileElement meetingUrlField;

    //Add later
    @iOSXCUITFindBy(accessibility = "removeText")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"removeText\"]/android.widget.TextView")
    public MobileElement crossBtn;

    @iOSXCUITFindBy(accessibility = "joinButton")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.TextView[@text='Join Now']")
    public MobileElement joinMeetingBtnDisable;

    @iOSXCUITFindBy(accessibility = "joinButton")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView[@text='Join Now']")
    public MobileElement joinMeetingBtnEnable;

    @iOSXCUITFindBy(accessibility = "//android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup[5]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup[5]")
    public MobileElement getStartedBtn;

    @iOSXCUITFindBy(xpath = "(//android.view.ViewGroup[3]/android.widget.ImageView)[1]")
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[3]/android.widget.ImageView)[1]")
    public MobileElement logo;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.TextView[1]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.TextView[1]")
    public MobileElement titleText;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.TextView[2]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.TextView[2]")
    public MobileElement subtitleText;

    @Override
    public void put_meeting_url_and_join(String meetingUrl) {
        ActionUtils.waitForVisibility(meetingUrlField);
        assertTrue(meetingUrlField.isDisplayed(), "meetingUrlField", "isDisplayed");
        sendKeys(meetingUrlField, "");
        assertTrue(joinMeetingBtnDisable.isDisplayed(), "joinMeetingBtn", "isDisplayed");
        sendKeys(meetingUrlField, meetingUrl, "login with " + meetingUrl);
        ActionUtils.waitForVisibility(joinMeetingBtnEnable);
        assertTrue(joinMeetingBtnEnable.isEnabled(), "joinMeetingBtn", "isEnabled");
        click(joinMeetingBtnEnable, "joinMeetingBtnEnable");
    }

    @Override
    public void enter_name_join(String participantName) throws InterruptedException {
        //assertTrue(joinMeetingBtn.isDisplayed(),"meetingUrlField","isDisplayed");
        //click(joinMeetingBtn, "joinMeetingBtn");
        ActionUtils.waitForVisibility(participantNameField);
        ActionUtils.waitForClickable(participantNameField);
        assertTrue(participantNameField.isDisplayed(), "participantNameField", "isDisplayed");

        sendKeys(participantNameField, participantName, "Participant name- " + participantName);
        ActionUtils.waitForClickable(getStartedBtn);
        assertTrue(getStartedBtn.isDisplayed(), "getStartedBtn", "isDisplayed");

        click(getStartedBtn, "getStartedBtn");
    }

    @Override
    public void are_homepage_elements_displayed() {
        ActionUtils.waitForVisibility(meetingUrlField);
        assertTrue(meetingUrlField.isDisplayed(), "meetingUrlField", "isDisplayed");
        ActionUtils.waitForVisibility(joinMeetingBtnEnable);
        assertTrue(joinMeetingBtnEnable.isEnabled(), "joinMeetingBtn", "isEnabled");
    }


    //HomePage Participant name Popup
    @iOSXCUITFindBy(accessibility = "usernameInput")
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public MobileElement participantNameField;

    @iOSXCUITFindBy(accessibility = "joinButtonWithName")
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]")
    public MobileElement nameOKbtn;

    @iOSXCUITFindBy(accessibility = "cancelJoinButton")
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]")
    public MobileElement nameCancelbtn;
}


