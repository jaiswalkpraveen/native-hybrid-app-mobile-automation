package com.qa.Interfaces;

public interface IHomePage {

    public void put_meeting_url_and_join(String meetingUrl) throws InterruptedException;
    public void enter_name_join(String participantName) throws InterruptedException;

    void are_homepage_elements_displayed();
}
