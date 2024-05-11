package com.qa.actionVariable.Flutter;

import com.qa.Interfaces.IMenu;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Menu extends TopBottomBar implements IMenu {

    //Bottom Bar
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[1]")
    public MobileElement flip_camera;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[2]")
    public MobileElement settings;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[3]")
    public MobileElement hls_start;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[4]")
    public MobileElement hls_stop;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[5]")
    public MobileElement end_room;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[6]")
    public MobileElement lock_end_room;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[7]")
    public MobileElement remote_mute_role;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[8]")
    public MobileElement grid_view;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[9]")
    public MobileElement hero_view;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[10]")
    public MobileElement audio_only_view;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[11]")
    public MobileElement active_speaker_view;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[12]")
    public MobileElement HLS_view;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[13]")
    public MobileElement enable_background;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[14]")
    public MobileElement disable_background;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[15]")
    public MobileElement raise_hand;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[16]")
    public MobileElement PIP_mode;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[17]")
    public MobileElement change_name;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[18]")
    public MobileElement screen_share;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[19]")
    public MobileElement stop_screen_share;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[20]")
    public MobileElement recording;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[21]")
    public MobileElement stop_rec_rtmp;

    public void click_audio_only_mode(){}
    public void click_show_active_speakers(){}
    public void is_BRB_option_present(boolean status){}
    public void is_participant_option_present(boolean status){}
    public void open_participant(){}
    public void close_participant() {}
    public void is_current_peer_present_in_participantlist(String name){}
    public void enable_BRB() {}
    public void is_BRB_enabled() {}
    public void disable_BRB() {}
    public void is_BRB_disabled() {}
    public void click_video_only_mode(){
    }
    public void click_all_pinned_mode(){
    }
    public void click_spotlight_mode(){
    }
    public void click_hero_mode(){
    }
    public void click_default_mode(){
    }
    public void click_enable_virtual_background(){
    }
    public void click_change_my_name(){
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

    public void click_end_room(){
        ActionUtils.click(more_button, "more_button");
        ActionUtils.assertTrue(end_room.isDisplayed(),"end_room","isDisplayed");
        ActionUtils.click(end_room, "end_room");
    }

    @Override
    public void click_remote_mute_all() {

    }

    @Override
    public void click_screen_share() {

    }
}
