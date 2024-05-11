package com.qa.actionVariable.Flutter;

import com.qa.Interfaces.IPreviewPage;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PreviewPage extends HomePage implements IPreviewPage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='platform_view[0]']/XCUIElementTypeOther/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//android.view.View[1]/android.widget.FrameLayout")
    public MobileElement videoTile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[2]")
    @AndroidFindBy(accessibility = "video_mute_button")
    public MobileElement camBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[1]")
    @AndroidFindBy(accessibility = "audio_mute_button")
    public MobileElement micBtn;

    @iOSXCUITFindBy(accessibility = "Enter Studio")
    @AndroidFindBy(accessibility = "Enter Studio")
    public MobileElement joinNowBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.view.ViewGroup[3]")
    public MobileElement switchCamBtn;

    @iOSXCUITFindBy(accessibility = "previewModalJoin")
    @AndroidFindBy(xpath = "//android.widget.Button[1]")
    public MobileElement previewList;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[3]")
    @AndroidFindBy(accessibility = "network_button")
    public MobileElement networkBar;

    @iOSXCUITFindBy(accessibility = "Back")
    @AndroidFindBy(accessibility = "Back")
    public MobileElement backBtn;

    @iOSXCUITFindBy(accessibility = "Preview")
    @AndroidFindBy(accessibility = "Preview")
    public MobileElement previewPageHeading;

    @Override
    public void is_mic_displayed(){

    }

    @Override
    public void is_cam_displayed(){

    }

    public void click_mic(){
        ActionUtils.assertTrue(micBtn.isDisplayed(),"micBtn","isDisplayed");
        ActionUtils.click(micBtn, "micBtn");
    }
    public void click_cam() {
        ActionUtils.assertTrue(camBtn.isDisplayed(),"camBtn","isDisplayed");
        ActionUtils.click(camBtn, "camBtn");
    }
    public void click_joinNowBtn() {
        ActionUtils.assertTrue(joinNowBtn.isDisplayed(),"joinNowBtn","isDisplayed");
        ActionUtils.click(joinNowBtn, "joinNowBtn");
    }

    @Override
    public void click_switch_cam() {
        ActionUtils.assertTrue(camBtn.isDisplayed(),"camBtn","isDisplayed");
        ActionUtils.click(switchCamBtn, "camBtn");
    }

    @Override
    public void verify_preview_page_cta() {
        ActionUtils.assertTrue(micBtn.isDisplayed(),"micBtn","isDisplayed");
        ActionUtils.assertTrue(camBtn.isDisplayed(),"micBtn","isDisplayed");
        ActionUtils.assertTrue(switchCamBtn.isDisplayed(),"micBtn","isDisplayed");
    }

    public void click_backBtn() {
        ActionUtils.assertTrue(backBtn.isDisplayed(),"backBtn","isDisplayed");
        ActionUtils.click(backBtn, "backBtn");
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
