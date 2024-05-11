package com.qa.Interfaces;

public interface IPreviewPage {
    void click_mic();

    void click_cam();

    void click_switch_cam();
    void click_joinNowBtn();

    void verify_preview_page_cta();
    void click_backBtn();

    void check_networkBar();

    void enter_name(String name);
    void click_go_live();

    void is_go_live_text_displayed_on_button(boolean b);

    void is_join_now_text_displayed_on_button(boolean b);

    void is_muteIconDisplayed();

    void is_avatarDisplayed();

    void is_switch_cam_enabled(boolean b);


    void is_mic_displayed();

    void is_cam_displayed();

    void click_select_audio_output_button();

    void click_select_default_audio_output();

    void click_select_speaker_audio_output();

    void click_select_phone_audio_output();

    void is_speaker_selected();

    void is_phone_selected();

}
