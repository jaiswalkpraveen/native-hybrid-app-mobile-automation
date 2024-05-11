package com.qa.actionVariable.iOS_Native;

import com.qa.Interfaces.IPreviewPage;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PreviewPage extends HomePage implements IPreviewPage {

    @iOSXCUITFindBy(xpath = "preview-camera-toggle-button")
    public MobileElement videoTile;

    @iOSXCUITFindBy(accessibility = "preview-camera-toggle-button")
    public MobileElement camBtn;

    @iOSXCUITFindBy(accessibility = "preview-mic-toggle-button")
    public MobileElement micBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.view.ViewGroup[3]")
    public MobileElement switchCamBtn;

    @iOSXCUITFindBy(accessibility = "preview-join-meeting-button")
    public MobileElement joinNowBtn;

    @iOSXCUITFindBy(id = "live.hms.app2:id/action_participants")
    public MobileElement previewList;

    @iOSXCUITFindBy(accessibility = "preview-network-quality-view")
    public MobileElement networkBar;

    @iOSXCUITFindBy(accessibility = "preview-back-button")
    public MobileElement backBtn;

    @iOSXCUITFindBy(accessibility = "live.hms.app2:id/toolbar")
    public MobileElement previewPageToolbar;

    @Override
    public void is_mic_displayed(){

    }

    @Override
    public void is_cam_displayed(){

    }

    @Override
    public void click_mic(){
        ActionUtils.assertTrue(micBtn.isDisplayed(),"micBtn","isDisplayed");
        ActionUtils.click(micBtn, "micBtn");
    }

    @Override
    public void verify_preview_page_cta() {
        ActionUtils.assertTrue(micBtn.isDisplayed(),"micBtn","isDisplayed");
        ActionUtils.assertTrue(camBtn.isDisplayed(),"micBtn","isDisplayed");
        ActionUtils.assertTrue(switchCamBtn.isDisplayed(),"micBtn","isDisplayed");
    }

    @Override
    public void click_cam() {
        ActionUtils.assertTrue(camBtn.isDisplayed(),"camBtn","isDisplayed");
        ActionUtils.click(camBtn, "camBtn");
    }

    @Override
    public void click_switch_cam() {
        ActionUtils.assertTrue(camBtn.isDisplayed(),"camBtn","isDisplayed");
        ActionUtils.click(switchCamBtn, "camBtn");
    }

    @Override
    public void click_joinNowBtn(){
        ActionUtils.assertTrue(joinNowBtn.isDisplayed(),"joinNowBtn","isDisplayed");
        ActionUtils.click(joinNowBtn, "joinNowBtn");
    }

    @Override
    public void click_backBtn() {
        ActionUtils.assertTrue(backBtn.isDisplayed(),"backBtn","isDisplayed");
        ActionUtils.click(backBtn, "backBtn");
    }

    @Override
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
