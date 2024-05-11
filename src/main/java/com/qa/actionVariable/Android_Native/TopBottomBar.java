package com.qa.actionVariable.Android_Native;

import com.qa.Interfaces.ITopBottomBar;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TopBottomBar extends MeetingRoom implements ITopBottomBar {

    //Bottom Bar
    @AndroidFindBy(accessibility = "Toggle Audio")
    public MobileElement audio_mute_button;

    @AndroidFindBy(accessibility = "Toggle Video")
    public MobileElement video_mute_button;

    @AndroidFindBy(accessibility = "Open Chat")
    public MobileElement chat_button;

    @AndroidFindBy(accessibility = "End Call")
    public MobileElement leave_button;

    //Top Bar
    @AndroidFindBy(accessibility = "Toggle Volume")
    public MobileElement toggle_volume_button;

    @AndroidFindBy(accessibility = "Show Participants")
    public MobileElement participant_list_button;

    @AndroidFindBy(accessibility = "More options")
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
    public void click_leave_button(){
        ActionUtils.assertTrue(leave_button.isDisplayed(),"leave_button","isDisplayed");
        ActionUtils.click(leave_button, "leave_button");
    }
    public void click_participant_list_button(){
        ActionUtils.assertTrue(participant_list_button.isDisplayed(),"participant_list_button","isDisplayed");
        ActionUtils.click(participant_list_button, "participant_list_button");
    }
    public void click_toggle_volume_button(){
        ActionUtils.assertTrue(toggle_volume_button.isDisplayed(),"toggle_volume_button","isDisplayed");
        ActionUtils.click(toggle_volume_button, "toggle_volume_button");
    }
    public void click_more_button(){
        ActionUtils.assertTrue(more_button.isDisplayed(),"more_button","isDisplayed");
        ActionUtils.click(more_button, "more_button");
    }
}
