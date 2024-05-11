package com.qa.actionVariable.iOS_Native;

import com.qa.Interfaces.ITopBottomBar;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TopBottomBar extends ActionUtils implements ITopBottomBar {

    //Bottom Bar
    @iOSXCUITFindBy(accessibility = "meeting-audio-publish-button")
    public MobileElement audio_mute_button;

    @iOSXCUITFindBy(accessibility = "meeting-video-publish-button")
    public MobileElement video_mute_button;

    @iOSXCUITFindBy(accessibility = "meeting-chat-button")
    public MobileElement chat_button;

    @iOSXCUITFindBy(accessibility = "meeting-hand-raise-button")
    public MobileElement raise_hand_button;

    @iOSXCUITFindBy(accessibility = "meeting-leave-call-button")
    public MobileElement leave_button;

    //Top Bar
    @iOSXCUITFindBy(accessibility = "meeting-room-name-label")
    public MobileElement participant_list_button;

    @iOSXCUITFindBy(accessibility = "screen sharing")
    public MobileElement screen_share_button;

    @iOSXCUITFindBy(accessibility = "meeting-speaker-button")
    public MobileElement toggle_volume_button;

    @iOSXCUITFindBy(accessibility = "meeting-camera-switch-button")
    public MobileElement camera_switch_button;

    @iOSXCUITFindBy(accessibility = "meeting-settings-button")
    public MobileElement more_button;

    public void click_audio_mute_button(){
        ActionUtils.assertTrue(audio_mute_button.isDisplayed(),"audio_mute_button","isDisplayed");
        ActionUtils.click(audio_mute_button, "audio_mute_button");
    }
    public void click_video_mute_button(){
        ActionUtils.assertTrue(video_mute_button.isDisplayed(),"video_mute_button","isDisplayed");
        ActionUtils.click(video_mute_button, "video_mute_button");
    }
    public void click_chat_button(){
        ActionUtils.assertTrue(chat_button.isDisplayed(),"chat_button","isDisplayed");
        ActionUtils.click(chat_button, "chat_button");
    }
    public void click_raise_hand_button(){
        ActionUtils.assertTrue(raise_hand_button.isDisplayed(),"raise_hand_button","isDisplayed");
        ActionUtils.click(raise_hand_button, "raise_hand_button");
    }
    public void click_leave_button(){
        ActionUtils.assertTrue(leave_button.isDisplayed(),"leave_button","isDisplayed");
        ActionUtils.click(leave_button, "leave_button");
    }

    public void click_participant_list_button(){
        ActionUtils.assertTrue(participant_list_button.isDisplayed(),"participant_list_button","isDisplayed");
        ActionUtils.click(participant_list_button, "participant_list_button");
    }
    public void click_screen_share_button(){
        ActionUtils.assertTrue(screen_share_button.isDisplayed(),"screen_share_button","isDisplayed");
        ActionUtils.click(screen_share_button, "screen_share_button");
    }
    public void click_toggle_volume_button(){
        ActionUtils.assertTrue(toggle_volume_button.isDisplayed(),"toggle_volume_button","isDisplayed");
        ActionUtils.click(toggle_volume_button, "toggle_volume_button");
    }
    public void click_camera_switch_button(){
        ActionUtils.assertTrue(camera_switch_button.isDisplayed(),"camera_switch_button","isDisplayed");
        ActionUtils.click(camera_switch_button, "camera_switch_button");
    }
    public void click_more_button(){
        ActionUtils.assertTrue(more_button.isDisplayed(),"more_button","isDisplayed");
        ActionUtils.click(more_button, "more_button");
    }
}
