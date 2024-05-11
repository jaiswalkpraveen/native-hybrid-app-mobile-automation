package com.qa.actionVariable.Android_Native;

import com.qa.Interfaces.IPreviewPage;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PreviewPage extends HomePage implements IPreviewPage {

    @Override
    public void is_mic_displayed(){

    }

    @Override
    public void is_cam_displayed(){

    }

    @AndroidFindBy(xpath = "live.hms.app2:id/preview_view")
    public MobileElement videoTile;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.view.ViewGroup[3]")
    public MobileElement switchCamBtn;

    @AndroidFindBy(id = "live.hms.app2:id/button_toggle_video")
    public MobileElement camBtn;

    @AndroidFindBy(id = "live.hms.app2:id/button_toggle_audio")
    public MobileElement micBtn;

    @AndroidFindBy(id = "live.hms.app2:id/button_join_meeting")
    public MobileElement joinNowBtn;

    @AndroidFindBy(id = "live.hms.app2:id/action_participants")
    public MobileElement previewList;

    @AndroidFindBy(id = "//android.view.View/android.widget.ImageView")
    public MobileElement networkBar;

    @AndroidFindBy(id = "live.hms.app2:id/action_volume")
    public MobileElement toggleSpeaker;

    @AndroidFindBy(accessibility = "live.hms.app2:id/toolbar")
    public MobileElement previewPageToolbar;

    public void click_mic(){
        ActionUtils.assertTrue(micBtn.isDisplayed(),"micBtn","isDisplayed");
        ActionUtils.click(micBtn, "micBtn");
    }
    public void click_cam() {
        ActionUtils.assertTrue(camBtn.isDisplayed(),"camBtn","isDisplayed");
        ActionUtils.click(camBtn, "camBtn");
    }
    public void click_joinNowBtn(){
        ActionUtils.assertTrue(joinNowBtn.isDisplayed(),"joinNowBtn","isDisplayed");
        ActionUtils.click(joinNowBtn, "joinNowBtn");
    }

    @Override
    public void verify_preview_page_cta() {
        ActionUtils.assertTrue(micBtn.isDisplayed(),"micBtn","isDisplayed");
        ActionUtils.assertTrue(camBtn.isDisplayed(),"micBtn","isDisplayed");
        ActionUtils.assertTrue(switchCamBtn.isDisplayed(),"micBtn","isDisplayed");
    }

    @Override
    public void click_switch_cam() {
        ActionUtils.assertTrue(camBtn.isDisplayed(),"camBtn","isDisplayed");
        ActionUtils.click(switchCamBtn, "camBtn");
    }


    public void click_backBtn() {
        ActionUtils.assertTrue(joinNowBtn.isDisplayed(),"joinNowBtn","isDisplayed");
        ActionUtils.click(joinNowBtn, "joinNowBtn");
    }
    public void check_networkBar() {
        ActionUtils.assertTrue(networkBar.isDisplayed(),"joinNowBtn","isDisplayed");
    }

    @Override
    public void enter_name(String name) {

    }

    @Override
    public void click_go_live() {

    }

    @Override
    public void is_go_live_text_displayed_on_button(boolean b) {

    }

    @Override
    public void is_join_now_text_displayed_on_button(boolean b) {

    }

    @Override
    public void is_muteIconDisplayed(){

    }

    @Override
    public void is_avatarDisplayed(){

    }

    @Override
    public void is_switch_cam_enabled(boolean status){

    }

    @Override
    public void click_select_audio_output_button() {

    }

    @Override
    public void click_select_default_audio_output() {

    }

    @Override
    public void click_select_speaker_audio_output() {

    }

    @Override
    public void click_select_phone_audio_output() {

    }

    @Override
    public void is_speaker_selected() {

    }

    @Override
    public void is_phone_selected() {

    }
}
