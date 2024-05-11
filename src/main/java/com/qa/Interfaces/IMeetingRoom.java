package com.qa.Interfaces;

public interface IMeetingRoom {
    void goto_meetingRoom_mic_cam(String meetingUrl, String name, String cam,String mic) throws InterruptedException;

    void click_mic();
    void click_cam();

    void is_muteIconDisplayed();
    void is_avatarDisplayed();

    void is_switch_cam_enabled(boolean b);


    void is_mic_displayed();
    void is_cam_displayed();

    void open_menu();

    void click_select_audio_output_button();

    void click_select_phone_audio_output();

    void is_phone_selected();

    void click_select_speaker_audio_output();

    void is_speaker_selected();

    void click_select_default_audio_output();

    void start_recording();
    void stop_recording();
    void is_recording_running(boolean b);
    void click_endstream_leave_button();

    void click_leave_button();

    void click_viewer_leave_button();

    void is_start_recording_displayed();

    void open_message_box();

    void send_message();

    void was_message_sent();
}
