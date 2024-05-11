package com.qa.actionVariable.ReactNative;

import com.qa.Interfaces.IMenu;
import com.qa.actionVariable.Android_Native.TopBottomBar;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

import javax.swing.event.AncestorEvent;

public class Menu extends TopBottomBar implements IMenu {

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[5]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[5]")
    public MobileElement screenShareButton;

    @iOSXCUITFindBy(id = "android:id/button1")
    @AndroidFindBy(id = "android:id/button1")
    public MobileElement startConfirmButton;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup")
    public MobileElement screenShareRibbon;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    public MobileElement stopScreenshareButton;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[5]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[6]")
    public MobileElement BRBButton;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[5]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView")
    public MobileElement BRBButtonText;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[5]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[3]")
    public MobileElement participantButton;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[5]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView")
    public MobileElement closeParticipantButton;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[5]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")
    public MobileElement participantName;


    @Override
    public void click_end_room() {

    }

    @Override
    public void click_remote_mute_all() {

    }

    public void is_screeshare_option_present(boolean status){
        if(status)
            ActionUtils.assertTrue(screenShareButton.isDisplayed(),"screenShareButton","isDisplayed");
        else
            ActionUtils.assertFalse(screenShareButton.isDisplayed(),"screenShareButton","isDisplayed");
    }


    @Override
    public void click_screen_share() {
        ActionUtils.waitForVisibility(screenShareButton);
        ActionUtils.waitForClickable(screenShareButton);
        is_screeshare_option_present(true);
        screenShareButton.click();
        ActionUtils.waitForVisibility(startConfirmButton);
        ActionUtils.waitForClickable(startConfirmButton);
        startConfirmButton.click();
    }

    public void is_screenshare_started(){
        ActionUtils.waitForVisibility(screenShareRibbon);
        ActionUtils.assertTrue(screenShareRibbon.isDisplayed(),"screenShareRibbon","isDisplayed");
        ActionUtils.waitForVisibility(stopScreenshareButton);
        ActionUtils.waitForClickable(stopScreenshareButton);
        ActionUtils.assertTrue(stopScreenshareButton.isEnabled(),"stopScreenshareButton","isDisplayed");
    }

    public void click_stop_screenshare() {
        ActionUtils.waitForClickable(stopScreenshareButton);
        stopScreenshareButton.click();
    }

    @Override
    public void enable_BRB() {
        ActionUtils.waitForVisibility(BRBButton);
        ActionUtils.waitForClickable(BRBButton);
        is_BRB_option_present(true);
        BRBButton.click();
    }

    @Override
    public void is_BRB_enabled() {
        ActionUtils.waitForVisibility(BRBButton);
        ActionUtils.waitForClickable(BRBButton);
        is_BRB_option_present(true);
        Assert.assertEquals(BRBButtonText.getText(), "I'm Back", "BRB Text mismatch");
    }

    @Override
    public void is_BRB_disabled() {
        ActionUtils.waitForVisibility(BRBButton);
        ActionUtils.waitForClickable(BRBButton);
        is_BRB_option_present(true);
        Assert.assertEquals(BRBButtonText.getText(), "Be Right Back", "BRB Text mismatch");
    }

    @Override
    public void disable_BRB() {
        ActionUtils.waitForVisibility(BRBButton);
        ActionUtils.waitForClickable(BRBButton);
        is_BRB_option_present(true);
        BRBButton.click();
    }

    @Override
    public void is_BRB_option_present(boolean status){
        if(status)
            ActionUtils.assertTrue(BRBButton.isDisplayed(),"screenShareButton","isDisplayed");
        else
            ActionUtils.assertFalse(BRBButton.isDisplayed(),"screenShareButton","isDisplayed");
    }

    @Override
    public void is_participant_option_present(boolean status){
        if(status)
            ActionUtils.assertTrue(participantButton.isDisplayed(),"participantButton","isDisplayed");
        else
            ActionUtils.assertFalse(participantButton.isDisplayed(),"participantButton","isDisplayed");
    }

    @Override
    public void open_participant() {
        ActionUtils.waitForVisibility(participantButton);
        ActionUtils.waitForClickable(participantButton);
        is_participant_option_present(true);
        participantButton.click();
    }

    @Override
    public void is_current_peer_present_in_participantlist(String expectedPeerName) {
        String actualPeername = participantName.getText();
        System.out.println("Expected: "+expectedPeerName);
        System.out.println("actualPeername: "+actualPeername);
        Assert.assertTrue(actualPeername.contains(expectedPeerName));
    }

    @Override
    public void close_participant() {
        ActionUtils.waitForVisibility(closeParticipantButton);
        ActionUtils.waitForClickable(closeParticipantButton);
        closeParticipantButton.click();
    }

    @Override
    public void click_audio_only_mode() {

    }

    @Override
    public void click_show_active_speakers() {

    }

    @Override
    public void click_video_only_mode() {

    }

    @Override
    public void click_all_pinned_mode() {

    }

    @Override
    public void click_spotlight_mode() {

    }

    @Override
    public void click_hero_mode() {

    }

    @Override
    public void click_default_mode() {

    }

    @Override
    public void click_change_my_name() {

    }
}
