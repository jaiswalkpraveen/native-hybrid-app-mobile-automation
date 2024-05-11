package com.qa.actionVariable.ReactNative;

import com.qa.Interfaces.IMeetingRoom;
import com.qa.actionVariable.Flutter.PreviewPage;
import com.qa.utils.ActionUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Keys;

public class MeetingRoom extends PreviewPage implements IMeetingRoom {


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='platform_view[0]']/XCUIElementTypeOther/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]//android.view.ViewGroup[2]/android.widget.ImageView")
    public MobileElement mic;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='platform_view[0]']/XCUIElementTypeOther/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]//android.view.ViewGroup[3]/android.widget.ImageView")
    public MobileElement cam;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='platform_view[0]']/XCUIElementTypeOther/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.view.ViewGroup[2]/android.widget.ImageView")
    public MobileElement muteIcon;

    @iOSXCUITFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    public MobileElement avatar;

    @iOSXCUITFindBy(xpath = "switch")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView")
    public MobileElement switchCamButton;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[5]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]")
    public MobileElement menuButton;

    @iOSXCUITFindBy(xpath = "//android.widget.FrameLayout//android.view.ViewGroup[1]//android.view.ViewGroup[4]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
    public MobileElement selectAudioOutputButton;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup")
    public MobileElement audioOutputToast;

    @iOSXCUITFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")
    public MobileElement defaultOutputButton;

    @iOSXCUITFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]")
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]")
    public MobileElement speakerButton;
    @iOSXCUITFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]")
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]")
    public MobileElement phoneButton;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.ImageView[2]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.ImageView[2]")
    public MobileElement speakerSelectedImage;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[5]/android.widget.ImageView[2]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[5]/android.widget.ImageView[2]")
    public MobileElement phoneSelectedImage;


    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")
    public MobileElement endStreamLeaveButton;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[2]//android.widget.TextView[@text=\"Leave\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.widget.TextView[@text=\"Leave\"]")
    public MobileElement confirmLeaveButton;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[1]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[1]")
    public MobileElement viewerLeaveButton;


    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text=\"Start Recording\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Start Recording\"]")
    public MobileElement startRecordingButton;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text=\"Stop Recording\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Stop Recording\"]")
    public MobileElement stopRecordingButton;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[2]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[2]")
    public MobileElement recordingStatusImage;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView[@text=\"Stop Recording\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView[@text=\"Stop Recording\"]")
    public MobileElement confirmStopRecordingButton;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[3]//android.view.ViewGroup[4]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]//android.view.ViewGroup[4]")
    public MobileElement chatWindowButton;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[2]//android.widget.EditText")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.widget.EditText")
    public MobileElement chatTextbox;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    public MobileElement sendChatButton;

    @iOSXCUITFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    public MobileElement sentMessage;

    public void goto_meetingRoom_mic_cam(String meetingUrl, String name, String cam,String mic) throws InterruptedException {
        put_meeting_url_and_join(meetingUrl);
        enter_name_join(name);
        assertTrue(micBtn.isDisplayed(),"micBtn","isDisplayed");
        assertTrue(camBtn.isDisplayed(),"camBtn","isDisplayed");
        assertTrue(joinNowBtn.isDisplayed(),"joinNowBtn","isDisplayed");


        if(cam.equalsIgnoreCase("on") && mic.equalsIgnoreCase("off"))
            click(micBtn, "micBtn");
        else if(cam.equalsIgnoreCase("off") && mic.equalsIgnoreCase("on"))
        {click(camBtn, "camBtn");Thread.sleep(5000);}
        else if(cam.equalsIgnoreCase("off") && mic.equalsIgnoreCase("off"))
        {click(micBtn, "micBtn"); click(camBtn,"camBtn");}

        click(joinNowBtn,"joinNowBtn");

    }
  
    @Override
    public void is_mic_displayed(){
        ActionUtils.waitForVisibility(mic);
        ActionUtils.assertTrue(mic.isDisplayed(),"micBtn","isDisplayed");
    }

    @Override
    public void is_cam_displayed(){
        ActionUtils.waitForVisibility(cam);
        ActionUtils.assertTrue(cam.isDisplayed(),"camBtn","isDisplayed");
    }

    @Override
    public void enter_name(String name) {}

    @Override
    public void click_go_live() {}

    @Override
    public void click_cam(){
        ActionUtils.waitForVisibility(cam);
        ActionUtils.assertTrue(cam.isDisplayed(),"cam","isDisplayed");
        ActionUtils.click(cam,"Click cam button");
    }

    @Override
    public void click_mic(){
        ActionUtils.waitForVisibility(mic);
        ActionUtils.assertTrue(mic.isDisplayed(),"mic","isDisplayed");
        ActionUtils.click(mic,"Click mic button");
    }

    @Override
    public void is_avatarDisplayed(){
        ActionUtils.waitForVisibility(avatar);
        ActionUtils.assertTrue(avatar.isDisplayed(),"mic","isDisplayed");
    }

    @Override
    public void is_muteIconDisplayed(){
        ActionUtils.waitForVisibility(muteIcon);
        ActionUtils.assertTrue(muteIcon.isDisplayed(),"muteIcon","isDisplayed");
    }

    @Override
    public void is_switch_cam_enabled(boolean status){
        if(status){
            ActionUtils.waitForVisibility(switchCamButton);
            ActionUtils.assertTrue(switchCamButton.isEnabled(), "switchCamButton", "isDisplayed");
        }else{
            ActionUtils.assertFalse(switchCamButton.isEnabled(), "switchCamButton", "isDisplayed");
        }
    }

    public void open_menu(){
        ActionUtils.waitForVisibility(menuButton);
        ActionUtils.waitForClickable(menuButton);
        menuButton.click();
    }

    public void click_select_audio_output_button(){
        ActionUtils.waitForVisibility(selectAudioOutputButton);
        ActionUtils.waitForClickable(selectAudioOutputButton);
        selectAudioOutputButton.click();
    }

    public void click_select_default_audio_output(){
        ActionUtils.waitForClickable(defaultOutputButton);
        defaultOutputButton.click();
    }

    public void click_select_speaker_audio_output(){
        ActionUtils.waitForClickable(speakerButton);
        speakerButton.click();
    }

    public void click_select_phone_audio_output(){
        ActionUtils.waitForClickable(phoneButton);
        phoneButton.click();
    }

    public void is_speaker_selected(){
        ActionUtils.waitForVisibility(speakerSelectedImage);
        ActionUtils.assertTrue(speakerSelectedImage.isDisplayed(), "speakerSelectedImage","isDisplayed");
    }

    public void is_phone_selected(){
        ActionUtils.waitForVisibility(phoneSelectedImage);
        ActionUtils.assertTrue(phoneSelectedImage.isDisplayed(), "phoneSelectedImage","isDisplayed");
    }

    public void click_endstream_leave_button(){
        ActionUtils.waitForClickable(endStreamLeaveButton);
        endStreamLeaveButton.click();
    }

    public void click_leave_button(){
        ActionUtils.waitForClickable(confirmLeaveButton);
        confirmLeaveButton.click();
    }

    public void click_viewer_leave_button(){
        ActionUtils.waitForClickable(viewerLeaveButton);
        viewerLeaveButton.click();
    }

    public void start_recording(){
        try{
            ActionUtils.waitForClickable(stopRecordingButton);
            stopRecordingButton.click();
        }catch (Exception e){
            System.out.println("No recording running, start recording and continue testing");
        }
         ActionUtils.waitForClickable(startRecordingButton);
        startRecordingButton.click();
    }

    public void is_start_recording_displayed(){
        ActionUtils.waitForClickable(startRecordingButton);
        assertTrue(startRecordingButton.isEnabled(),"startRecordingButton","isEnabled");
    }

    public void stop_recording(){
        ActionUtils.waitForClickable(stopRecordingButton);
        stopRecordingButton.click();
        ActionUtils.waitForClickable(confirmStopRecordingButton);
        confirmStopRecordingButton.click();
    }

    public void is_recording_running(boolean status){
        if(status) {
            ActionUtils.waitForVisibility(recordingStatusImage);
            assertTrue(recordingStatusImage.isDisplayed(),"recordingStatusImage","isDisplayed");
        }else{
            assertTrue(ActionUtils.is_element_present(recordingStatusImage),"recordingStatusImage","false");
        }
    }

    public void open_message_box(){
        ActionUtils.waitForClickable(chatWindowButton);
        chatWindowButton.click();
    }

    public void send_message(){
        ActionUtils.waitForVisibility(chatTextbox);
        chatTextbox.sendKeys("Hello, chat testing");
        ActionUtils.waitForClickable(sendChatButton);
        sendChatButton.click();
    }

    public void was_message_sent(){
        ActionUtils.waitForVisibility(sentMessage);
        assertTrue(sentMessage.isDisplayed(),"sentMessage","isDisplayed");
    }
}
