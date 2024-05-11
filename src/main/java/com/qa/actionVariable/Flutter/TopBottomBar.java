package com.qa.actionVariable.Flutter;

import com.qa.Interfaces.ITopBottomBar;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TopBottomBar extends ActionUtils implements ITopBottomBar {

    //Bottom Bar
    @iOSXCUITFindBy(accessibility = "audio_mute_button")
    @AndroidFindBy(accessibility = "audio_mute_button")
    public MobileElement audio_mute_button;

    @iOSXCUITFindBy(accessibility = "video_mute_button")
    @AndroidFindBy(accessibility = "video_mute_button")
    public MobileElement video_mute_button;

    @iOSXCUITFindBy(accessibility = "screen_share_button")
    @AndroidFindBy(accessibility = "screen_share_button")
    public MobileElement screen_share_button;

    @iOSXCUITFindBy(accessibility = "leave_button")
    @AndroidFindBy(accessibility = "leave_button")
    public MobileElement leave_button;

    @iOSXCUITFindBy(accessibility = "start_hls_button")
    @AndroidFindBy(accessibility = "start_hls_button")
    public MobileElement start_hls_button;

    @iOSXCUITFindBy(accessibility = "more_button")
    @AndroidFindBy(accessibility = "more_button")
    public MobileElement more_button;

    //Top Bar
    @iOSXCUITFindBy(accessibility = "hand_raise_button")
    @AndroidFindBy(accessibility = "hand_raise_button")
    public MobileElement hand_raise_button;

    @iOSXCUITFindBy(accessibility = "participants_button")
    @AndroidFindBy(accessibility = "participants_button")
    public MobileElement participants_button;

    @iOSXCUITFindBy(accessibility = "chat_button")
    @AndroidFindBy(accessibility = "chat_button")
    public MobileElement chat_button;

    @Override
    public void click_audio_mute_button() {

    }

    @Override
    public void click_video_mute_button() {

    }

    @Override
    public void click_chat_button() {

    }

    @Override
    public void click_leave_button() {

    }

    @Override
    public void click_participant_list_button() {

    }

    @Override
    public void click_toggle_volume_button() {

    }

    @Override
    public void click_more_button() {

    }
}
