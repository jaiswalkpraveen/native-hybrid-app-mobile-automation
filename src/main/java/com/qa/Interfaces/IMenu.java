package com.qa.Interfaces;

public interface IMenu {
    void click_end_room();
    void click_remote_mute_all();
    void click_screen_share();
    void enable_BRB();
    void is_BRB_enabled();
    void is_BRB_disabled();
    void disable_BRB();
    void is_BRB_option_present(boolean b);
    void is_participant_option_present(boolean b);
    void is_current_peer_present_in_participantlist(String name);
    void open_participant();
    void close_participant();
    public void click_audio_only_mode();
    public void click_show_active_speakers();
    public void click_video_only_mode();
    public void click_all_pinned_mode();
    public void click_spotlight_mode();
    public void click_hero_mode();
    public void click_default_mode();
    public void click_change_my_name();

    void is_screenshare_started();

    void click_stop_screenshare();

    void is_screeshare_option_present(boolean b);
}
