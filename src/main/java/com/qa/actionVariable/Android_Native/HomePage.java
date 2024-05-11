package com.qa.actionVariable.Android_Native;

import com.qa.Interfaces.IHomePage;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends ActionUtils implements IHomePage {

    //Landing Page
    @AndroidFindBy(id = "live.hms.app2:id/edt_meeting_url")
    public static MobileElement meetingUrlField;

    //Add later
    @AndroidFindBy(id = "live.hms.app2:id/text_input_end_icon")
    public MobileElement crossBtn;

    @AndroidFindBy(id = "live.hms.app2:id/btn_join_now")
    public MobileElement joinMeetingBtn;

    @AndroidFindBy(id = "live.hms.app2:id/button_join_meeting")
    public MobileElement getStartedBtn;

    //HomePage Participant name Popup
    @AndroidFindBy(id = "live.hms.app2:id/edit_text_name")
    public MobileElement participantNameField;

//    @Override
//    public void put_meeting_url(String meetingUrl) {
//        assertTrue(meetingUrlField.isDisplayed(),"meetingUrlField","isDisplayed");
//        sendKeys(meetingUrlField, meetingUrl, "login with " + meetingUrl);
//    }
//
//    @Override
//    public void enter_name_join(String participantName) {
//        assertTrue(participantNameField.isDisplayed(),"joinMeetingBtn","isDisplayed");
//        sendKeys(participantNameField, participantName, "login with " + participantName);
//        assertTrue(joinMeetingBtn.isDisplayed(),"joinMeetingBtn","isDisplayed");
//        click(joinMeetingBtn, "joinMeetingBtn");
//    }

    public void are_homepage_elements_displayed(){
        ActionUtils.waitForVisibility(meetingUrlField);
        assertTrue(meetingUrlField.isDisplayed(), "meetingUrlField","isDisplayed");
    }

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
//            click(Done, "Done");
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

}
