package com.qa.actionVariable.Flutter;

import com.qa.Interfaces.IHomePage;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends ActionUtils implements IHomePage {
    //Landing Page
    @iOSXCUITFindBy(accessibility = "Paste the link here")
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public MobileElement meetingUrlField;

    //Add later
    @iOSXCUITFindBy(accessibility = "removeText")
    @AndroidFindBy(xpath = "//android.view.View[2]/android.widget.EditText/android.widget.Button")
    public MobileElement crossBtn;

    @iOSXCUITFindBy(accessibility = "Join Now")
    @AndroidFindBy(accessibility = "Join Now")
    public MobileElement joinMeetingBtn;

    @iOSXCUITFindBy(accessibility = "Get Started")
    @AndroidFindBy(accessibility = "Get Started")
    public MobileElement getStartedBtn;

    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement Done;

    public void put_meeting_url_and_join(String meetingUrl) throws InterruptedException {
        assertTrue(meetingUrlField.isDisplayed(),"meetingUrlField","isDisplayed");
        click(meetingUrlField, "meetingUrlField");


        sendKeys(meetingUrlField, meetingUrl, "login with " + meetingUrl);
        ActionUtils.default_back();
//        click(Done, "Done");

    }

    public void enter_name_join(String participantName) throws InterruptedException {
        System.out.println(ActionUtils.selectPlatform());
        if (ActionUtils.selectPlatform().equals("android")) {
            assertTrue(joinMeetingBtn.isDisplayed(), "joinMeetingBtn", "isDisplayed");
            click(joinMeetingBtn, "joinMeetingBtn");
        } else if (ActionUtils.selectPlatform().equals("ios")) {
            click(Done, "Done");
        }
//        assertTrue(joinMeetingBtn.isDisplayed(),"joinMeetingBtn","isDisplayed");
//        click(joinMeetingBtn, "joinMeetingBtn");
//        Thread.sleep(10000);
        clear(participantNameField);
        assertTrue(participantNameField.isDisplayed(),"participantNameField","isDisplayed");
        sendKeys(participantNameField, participantName, "Participant name- " + participantName);

        sendKeys(participantNameField, participantName, "Participant name- " + participantName);
        click(getStartedBtn, "getStartedBtn");

    }

    @Override
    public void are_homepage_elements_displayed() {

    }

    //HomePage Participant name Popup
    @iOSXCUITFindBy(accessibility = "Enter your name here")
    @AndroidFindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText")
    public MobileElement participantNameField;

    @iOSXCUITFindBy(accessibility = "OK")
    @AndroidFindBy(accessibility = "OK")
    public MobileElement nameOKbtn;

    @iOSXCUITFindBy(accessibility = "Cancel")
    @AndroidFindBy(accessibility = "Cancel")
    public MobileElement nameCancelbtn;


}
