package com.qa.actionVariable.iOS_Native;

import com.qa.Interfaces.IMeetingRoom;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MeetingRoom extends PreviewPage implements IMeetingRoom {

    @iOSXCUITFindBy(accessibility = "Back")
    public static MobileElement myTile;

    @iOSXCUITFindBy(accessibility =  "meeting-leave-call-button" )
    public static MobileElement leave;

    @iOSXCUITFindBy(accessibility = "Back")
    public static MobileElement myTile_nameChange;

    @iOSXCUITFindBy(accessibility = "Back")
    public static MobileElement VideoTile_myTile;

    public void goto_meetingRoom_mic_cam(String meetingUrl, String name, String cam,String mic) throws InterruptedException {
        put_meeting_url_and_join(meetingUrl);
        enter_name_join(name);
        Thread.sleep(10000);
        
        assertTrue(micBtn.isDisplayed(),"micBtn","isDisplayed");
        assertTrue(camBtn.isDisplayed(),"camBtn","isDisplayed");
        assertTrue(joinNowBtn.isDisplayed(),"joinNowBtn","isDisplayed");


        if(cam.equalsIgnoreCase("on") && mic.equalsIgnoreCase("off"))
            click(micBtn, "micBtn");
        else if(cam.equalsIgnoreCase("off") && mic.equalsIgnoreCase("on"))
        {click(camBtn, "camBtn");Thread.sleep(5000);}
        else if(cam.equalsIgnoreCase("off") && mic.equalsIgnoreCase("off"))
        {click(micBtn, "micBtn"); click(camBtn,"camBtn");}

        Thread.sleep(5000);
//        click(joinNowBtn,"joinNowBtn");
        click_joinNowBtn();
        assertTrue(leave.isDisplayed(),"leave","isDisplayed");

    }

    @Override
    public void is_mic_displayed(){

    }

    @Override
    public void is_cam_displayed(){

    }
    @Override
    public void is_muteIconDisplayed() {

    }

    @Override
    public void is_avatarDisplayed() {

    }

    @Override
    public void is_switch_cam_enabled(boolean b) {

    }

    @Override
    public void open_menu() {

    }

    @Override
    public void click_endstream_leave_button() {

    }

    @Override
    public void click_leave_button() {

    }

    @Override
    public void click_viewer_leave_button() {

    }

    @Override
    public void is_start_recording_displayed() {

    }

    @Override
    public void open_message_box() {

    }

    @Override
    public void send_message() {

    }

    @Override
    public void was_message_sent() {

    }

    @Override
    public void start_recording() {

    }

    @Override
    public void stop_recording() {

    }

    @Override
    public void is_recording_running(boolean b) {

    }

}
