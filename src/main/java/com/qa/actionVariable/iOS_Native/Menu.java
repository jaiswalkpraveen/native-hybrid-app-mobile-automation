package com.qa.actionVariable.iOS_Native;

import com.qa.Interfaces.IMenu;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Menu extends TopBottomBar implements IMenu {

    @iOSXCUITFindBy(accessibility = "Audio Only Mode")
    public MobileElement audio_only_mode;
    @iOSXCUITFindBy(accessibility = "Show Active Speakers")
    public MobileElement show_active_speakers;
    @iOSXCUITFindBy(accessibility = "Video Only Mode")
    public MobileElement video_only_mode;
    @iOSXCUITFindBy(accessibility = "All Pinned Mode")
    public MobileElement all_pinned_mode;
    @iOSXCUITFindBy(accessibility = "Spotlight Mode")
    public MobileElement spotlight_mode;
    @iOSXCUITFindBy(accessibility = "Hero Mode")
    public MobileElement hero_mode;
    @iOSXCUITFindBy(accessibility = "Default Mode")
    public MobileElement default_mode;
    @iOSXCUITFindBy(accessibility = "Enable virtual background")
    public MobileElement enable_virtual_background;
    @iOSXCUITFindBy(accessibility = "Change my name")
    public MobileElement change_my_name;
    @iOSXCUITFindBy(accessibility = "Room State")
    public MobileElement room_state;
    @iOSXCUITFindBy(accessibility = "Remote Mute Role")
    public MobileElement remote_mute_role;
    @iOSXCUITFindBy(accessibility = "Remote Mute All")
    public MobileElement remote_mute_all;
    @iOSXCUITFindBy(accessibility = "Change All Role To Role")
    public MobileElement change_all_role_to_role;
    @iOSXCUITFindBy(accessibility = "Start RTMP or Recording")
    public MobileElement start_rtmp_or_recording;
    @iOSXCUITFindBy(accessibility = "Stop RTMP and Recording")
    public MobileElement stop_rtmp_and_recording;
    @iOSXCUITFindBy(accessibility = "Start HLS Streaming")
    public MobileElement start_hls_streaming;
    @iOSXCUITFindBy(accessibility = "Stop HLS Streaming")
    public MobileElement stop_hls_streaming;
    @iOSXCUITFindBy(accessibility = "End Room")
    public MobileElement end_room;
    @iOSXCUITFindBy(accessibility = "End Room And Lock")
    public MobileElement end_room_and_lock;

    public void click_audio_only_mode(){
        ActionUtils.click(more_button, "more_button");
        ActionUtils.assertTrue(audio_only_mode.isDisplayed(),"audio_only_mode","isDisplayed");
        ActionUtils.click(audio_only_mode, "audio_only_mode");
    }
    public void click_show_active_speakers(){
        ActionUtils.click(more_button, "more_button");
        ActionUtils.assertTrue(show_active_speakers.isDisplayed(),"show_active_speakers","isDisplayed");
        ActionUtils.click(show_active_speakers, "show_active_speakers");
    }
    public void click_video_only_mode(){
        ActionUtils.click(more_button, "more_button");
        ActionUtils.assertTrue(video_only_mode.isDisplayed(),"video_only_mode","isDisplayed");
        ActionUtils.click(video_only_mode, "video_only_mode");
    }
    public void click_all_pinned_mode(){
        ActionUtils.click(more_button, "more_button");
        ActionUtils.assertTrue(all_pinned_mode.isDisplayed(),"all_pinned_mode","isDisplayed");
        ActionUtils.click(all_pinned_mode, "all_pinned_mode");
    }
    public void click_spotlight_mode(){
        ActionUtils.click(more_button, "more_button");
        ActionUtils.assertTrue(spotlight_mode.isDisplayed(),"spotlight_mode","isDisplayed");
        ActionUtils.click(spotlight_mode, "spotlight_mode");
    }
    public void click_hero_mode(){
        ActionUtils.click(more_button, "more_button");
        ActionUtils.assertTrue(hero_mode.isDisplayed(),"hero_mode","isDisplayed");
        ActionUtils.click(hero_mode, "hero_mode");
    }
    public void click_default_mode(){
        ActionUtils.click(more_button, "more_button");
        ActionUtils.assertTrue(default_mode.isDisplayed(),"default_mode","isDisplayed");
        ActionUtils.click(default_mode, "default_mode");
    }
    public void click_enable_virtual_background(){
        ActionUtils.click(more_button, "more_button");
        ActionUtils.assertTrue(enable_virtual_background.isDisplayed(),"enable_virtual_background","isDisplayed");
        ActionUtils.click(enable_virtual_background, "enable_virtual_background");
    }
    public void click_change_my_name(){
        ActionUtils.click(more_button, "more_button");
        ActionUtils.assertTrue(change_my_name.isDisplayed(),"change_my_name","isDisplayed");
        ActionUtils.click(change_my_name, "change_my_name");
    }

    @Override
    public void is_screenshare_started() {

    }

    @Override
    public void click_stop_screenshare() {

    }

    @Override
    public void is_screeshare_option_present(boolean b) {

    }

    @Override
    public void enable_BRB() {}

    public void is_BRB_enabled() {}
    public void disable_BRB() {}
    public void is_BRB_disabled() {}
    public void is_participant_option_present(boolean status){}
    public void open_participant(){}
    public void close_participant() {}
    public void is_current_peer_present_in_participantlist(String name){}

    public void click_remote_mute_all(){
        ActionUtils.click(more_button, "more_button");
        ActionUtils.assertTrue(remote_mute_all.isDisplayed(),"remote_mute_all","isDisplayed");
        ActionUtils.click(remote_mute_all, "remote_mute_all");
    }

    @Override
    public void click_screen_share() {
        //not working
        ActionUtils.assertTrue(screen_share_button.isDisplayed(),"screen_share_button","isDisplayed");
        ActionUtils.click(screen_share_button, "screen_share_button");
    }

    @Override
    public void is_BRB_option_present(boolean status){

    }

    public void click_end_room(){
        ActionUtils.click(more_button, "more_button");
        ActionUtils.assertTrue(end_room.isDisplayed(),"end_room","isDisplayed");
        ActionUtils.click(end_room, "end_room");
    }

}
