package com.qa.actionVariable.ReactNative;

import com.qa.Interfaces.IPreviewPage;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PreviewPage extends HomePage implements IPreviewPage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='platform_view[0]']/XCUIElementTypeOther/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//android.view.View[1]/android.widget.FrameLayout")
    public MobileElement videoTile;

    @iOSXCUITFindBy(accessibility = "previewMuteAudio")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.view.ViewGroup[1]")
    public MobileElement micBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='Flutter 100ms']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.view.ViewGroup[2]")
    public MobileElement camBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.view.ViewGroup[3]")
    public MobileElement switchCamBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='platform_view[0]']/XCUIElementTypeOther/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.view.ViewGroup[2]/android.widget.ImageView")
    public MobileElement muteIcon;

    @iOSXCUITFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
    public MobileElement avatar;

    @iOSXCUITFindBy(accessibility = "previewModalJoin")
    @AndroidFindBy(accessibility = "Join Now")
    public MobileElement joinNowBtn;

    @iOSXCUITFindBy(accessibility = "previewModalJoin")
    @AndroidFindBy(xpath = "//android.widget.Button[1]")
    public MobileElement previewList;

    @iOSXCUITFindBy(accessibility = "previewModalJoin")
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ImageView")
    public MobileElement networkBar;

    @iOSXCUITFindBy(accessibility = "Back")
    @AndroidFindBy(accessibility = "Back")
    public MobileElement backBtn;

    @iOSXCUITFindBy(accessibility = "Preview")
    @AndroidFindBy(accessibility = "Preview")
    public MobileElement previewPageHeading;

    @iOSXCUITFindBy(xpath = "Preview")
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public MobileElement nameTextBox;

    @iOSXCUITFindBy(xpath = "Preview")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[5]/android.widget.TextView")
    public MobileElement goLiveButton;

    @iOSXCUITFindBy(xpath = "Switch")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup[3]")
    public MobileElement switchCamButton;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text=\"Go Live\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Go Live\"]")
    public MobileElement goLiveButtonText;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text=\"Join Now\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Join Now\"]")
    public MobileElement joinNowButtonText;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup[4]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup[4]")
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

    @Override
    public void is_mic_displayed(){
        ActionUtils.waitForVisibility(micBtn);
        ActionUtils.assertTrue(micBtn.isDisplayed(),"micBtn","isDisplayed");
    }

    @Override
    public void is_cam_displayed(){
        ActionUtils.waitForVisibility(camBtn);
        ActionUtils.assertTrue(camBtn.isDisplayed(),"camBtn","isDisplayed");
    }

    @Override
    public void verify_preview_page_cta() {
        is_mic_displayed();
        is_cam_displayed();
        is_switch_cam_enabled(true);
    }

    @Override
    public void click_mic() {
        ActionUtils.waitForClickable(micBtn);
        ActionUtils.assertTrue(micBtn.isDisplayed(), "micBtn", "isDisplayed");
        ActionUtils.click(micBtn, "micBtn");
    }

    @Override
    public void click_switch_cam() {
        ActionUtils.waitForClickable(camBtn);
        ActionUtils.assertTrue(camBtn.isDisplayed(),"camBtn","isDisplayed");
        ActionUtils.waitForClickable(switchCamBtn);
        ActionUtils.click(switchCamBtn, "camBtn");
    }

    @Override
    public void click_cam() {
        ActionUtils.waitForClickable(camBtn);
        ActionUtils.assertTrue(camBtn.isDisplayed(), "camBtn", "isDisplayed");
        ActionUtils.click(camBtn, "camBtn");
    }

    @Override
    public void click_joinNowBtn() {
        ActionUtils.waitForClickable(joinNowBtn);
        ActionUtils.assertTrue(joinNowBtn.isDisplayed(), "joinNowBtn", "isDisplayed");
        ActionUtils.click(joinNowBtn, "joinNowBtn");
    }

    @Override
    public void click_backBtn() {
        ActionUtils.waitForClickable(backBtn);
        ActionUtils.assertTrue(backBtn.isDisplayed(), "joinNowBtn", "isDisplayed");
        ActionUtils.click(backBtn, "joinNowBtn");
    }


    public void is_go_live_button_enabled(boolean status){
        if(status){
            ActionUtils.waitForVisibility(goLiveButton);
            ActionUtils.assertTrue(goLiveButton.isEnabled(), "goLiveButton", "isDisplayed");
        }else{
            ActionUtils.assertFalse(goLiveButton.isEnabled(), "goLiveButton", "isDisplayed");
        }
    }

    public void is_go_live_text_displayed_on_button(boolean status){
        if(status){
            ActionUtils.waitForVisibility(goLiveButtonText);
            ActionUtils.assertTrue(goLiveButtonText.isDisplayed(), "goLiveButtonText", "isDisplayed");
        }else{
            ActionUtils.assertFalse(goLiveButtonText.isDisplayed(), "goLiveButtonText", "isDisplayed");
        }
    }

    public void is_join_now_text_displayed_on_button(boolean status){
        if(status){
            ActionUtils.waitForVisibility(joinNowButtonText);
            ActionUtils.assertTrue(joinNowButtonText.isDisplayed(), "joinNowButtonText", "isDisplayed");
        }else{
            ActionUtils.assertFalse(joinNowButtonText.isDisplayed(), "joinNowButtonText", "isDisplayed");
        }
    }

    public void are_preview_elements_displayed(){
        ActionUtils.waitForVisibility(logo);
        assertTrue(logo.isDisplayed(),"logo","isDisplayed");
        ActionUtils.waitForVisibility(titleText);
        System.out.println(titleText.getText());
        assertTrue(titleText.isDisplayed(),"titleText","isDisplayed");
        System.out.println(subtitleText.getText());
        ActionUtils.waitForVisibility(subtitleText);
        assertTrue(subtitleText.isDisplayed(),"subtitleText","isDisplayed");
    }


    public void enter_name(String userName) {
        ActionUtils.waitForVisibility(nameTextBox);
        ActionUtils.waitForClickable(nameTextBox);
        ActionUtils.assertTrue(nameTextBox.isDisplayed(), "nameTextBox", "isDisplayed");
        ActionUtils.sendKeys(nameTextBox, "", "removed name");
        ActionUtils.sendKeys(nameTextBox, userName, "name entered");
    }

    public void click_go_live() {
        try {
            ActionUtils.waitForVisibility(goLiveButton);
            ActionUtils.assertTrue(goLiveButton.isDisplayed(), "goLiveButton", "isDisplayed");
            ActionUtils.click(goLiveButton, "Clicked Go Live Button");
        }catch (Exception e){
            ActionUtils.waitForVisibility(joinNowButtonText);
            ActionUtils.assertTrue(joinNowButtonText.isDisplayed(), "goLiveButton", "isDisplayed");
            ActionUtils.click(joinNowButtonText, "Clicked Go Live Button");
        }

    }

    public void check_networkBar() {
        ActionUtils.assertTrue(networkBar.isDisplayed(), "joinNowBtn", "isDisplayed");
    }

    public void toggle_mic_cam(String cam, String mic) throws InterruptedException {
        if(cam.equalsIgnoreCase("on") && mic.equalsIgnoreCase("off")){
            click_mic();
        } else if (cam.equalsIgnoreCase("off") && mic.equalsIgnoreCase("on")) {
            click_cam();
        } else if (cam.equalsIgnoreCase("off") && mic.equalsIgnoreCase("off")) {
            click_mic();
            click_cam();
        }else {
            System.out.println("invalid status for cam and/or mic. Joining meeting with default status");
        }
    }

    @Override
    public void is_muteIconDisplayed(){
        ActionUtils.waitForVisibility(muteIcon);
        ActionUtils.assertTrue(muteIcon.isDisplayed(),"muteIcon","isDisplayed");
    }

    @Override
    public void is_avatarDisplayed(){
        ActionUtils.waitForVisibility(avatar);
        ActionUtils.assertTrue(avatar.isDisplayed(),"avatar","isDisplayed");
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

    public void click_select_audio_output_button(){
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
}
