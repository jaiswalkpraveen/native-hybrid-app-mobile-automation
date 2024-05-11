package com.qa.actionVariable.iOS_Native;

import com.qa.Interfaces.IHomePage;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends ActionUtils implements IHomePage {

    //Landing Page
    @iOSXCUITFindBy(accessibility = "login-meeting-id-text-field")
    public static MobileElement meetingUrlField;

    @iOSXCUITFindBy(accessibility = "login-join-meeting-button")
    public MobileElement joinMeetingBtn;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup[5]")
    public MobileElement join;

    //HomePage Participant name Popup
    @iOSXCUITFindBy(accessibility = "login-popup-enter-name-textfield")
    public MobileElement participantNameField;

    @Override
    public void put_meeting_url_and_join(String meetingUrl) throws InterruptedException {
        ActionUtils.waitForVisibility(meetingUrlField);
        assertTrue(meetingUrlField.isDisplayed(),"meetingUrlField","isDisplayed");
        clear(meetingUrlField);
        sendKeys(meetingUrlField, meetingUrl, "login with " + meetingUrl);
        ActionUtils.waitForVisibility(joinMeetingBtn);
        ActionUtils.waitForClickable(joinMeetingBtn);
        click(joinMeetingBtn, "joinMeetingBtn");
//        Thread.sleep(5000);
    }

    @Override
    public void enter_name_join(String participantName) throws InterruptedException{
        ActionUtils.waitForVisibility(participantNameField);
        assertTrue(participantNameField.isDisplayed(),"joinMeetingBtn","isDisplayed");
        ActionUtils.clear(participantNameField);
        sendKeys(participantNameField, participantName, "login with " + participantName);
//        ActionUtils.iosAlertSendKeys(participantName);
        ActionUtils.waitForVisibility(join);
        ActionUtils.waitForClickable(join);
        assertTrue(join.isDisplayed(),"join","isDisplayed");
        click(join, "join");
//        Thread.sleep(5000);
    }

    @Override
    public void are_homepage_elements_displayed() {

    }

}
