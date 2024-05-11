package com.qa.tests.InRoom;

import com.qa.BasePO;
import com.qa.Interfaces.IHomePage;
import com.qa.Interfaces.IMeetingRoom;
import com.qa.Interfaces.IPreviewPage;
import com.qa.Interfaces.IMenu;
import com.qa.utils.ActionUtils;
import com.qa.utils.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.InputStream;
import java.lang.reflect.Method;

public class InRoomTest extends BasePO {

    IMeetingRoom meetingRoom;
    IHomePage homePage;
    IPreviewPage previewPage;
    IMenu menu;
    JSONObject meetingDetail;
    TestUtils utils = new TestUtils();
    SoftAssert sa;

    @BeforeClass
    public void beforeClass() throws Exception {
      InputStream datais = null;
      try {
        String dataFileName = "data/meetingDetail.json";
        datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
        JSONTokener tokener = new JSONTokener(datais);
        meetingDetail = new JSONObject(tokener);
      } catch(Exception e) {
        e.printStackTrace();
        throw e;
      } finally {
        if(datais != null) {
          datais.close();
        }
      }
    }

    @AfterClass
    public void afterClass() {
    }

    @Parameters({"env"})
    @BeforeMethod
    public void beforeMethod(Method m, String env) throws Exception {
      closeApp();
      launchApp();
      utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
      sa = new SoftAssert();
        meetingRoom = ActionUtils.getClassFromEnv(  env, "MeetingRoom");
        homePage = ActionUtils.getClassFromEnv(env, "HomePage");
        previewPage = ActionUtils.getClassFromEnv(env, "PreviewPage");
        menu = ActionUtils.getClassFromEnv(env, "Menu");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        meetingRoom.click_endstream_leave_button();
        meetingRoom.click_leave_button();
        homePage.are_homepage_elements_displayed();
    }


    @Test
    public void Test_cam_mic_toggle_status() throws InterruptedException {
        System.out.println("Verify cam and mic toggle");
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("valid").getString("meeting_url"));
        previewPage.enter_name(meetingDetail.getJSONObject("prebuilt").getString("username"));
        previewPage.click_go_live();
        meetingRoom.click_mic();
        meetingRoom.is_muteIconDisplayed();
        meetingRoom.click_cam();
        meetingRoom.is_avatarDisplayed();
        meetingRoom.is_switch_cam_enabled(false);
        meetingRoom.click_mic();
        meetingRoom.click_cam();
        meetingRoom.is_switch_cam_enabled(true);
    }

    @Test
    public void Test_switch_cam_test() throws InterruptedException {
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("valid").getString("meeting_url"));
        previewPage.enter_name(meetingDetail.getJSONObject("prebuilt").getString("username"));
        previewPage.click_go_live();
        meetingRoom.is_switch_cam_enabled(true);
        meetingRoom.click_cam();
        meetingRoom.is_switch_cam_enabled(false);
    }

    @Test
    public void Test_join_room_with_mute_mic_on_preview_and_inside_room() throws InterruptedException {
        System.out.println("Mic is muted on preview, state should be same inside meeting room");
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("valid").getString("meeting_url"));
        previewPage.enter_name(meetingDetail.getJSONObject("prebuilt").getString("username"));
        previewPage.click_mic();
        previewPage.is_muteIconDisplayed();
        previewPage.is_cam_displayed();
        previewPage.is_switch_cam_enabled(true);
        previewPage.click_go_live();
        meetingRoom.is_muteIconDisplayed();
        meetingRoom.is_cam_displayed();
        meetingRoom.is_switch_cam_enabled(true);
    }

    @Test
    public void Test_join_room_with_mute_cam_on_preview_and_inside_room() throws InterruptedException {
        System.out.println("Cam is muted on preview, state should be same inside meeting room");
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("valid").getString("meeting_url"));
        previewPage.enter_name(meetingDetail.getJSONObject("prebuilt").getString("username"));
        previewPage.click_cam();
        previewPage.is_mic_displayed();
        previewPage.is_avatarDisplayed();
        previewPage.is_switch_cam_enabled(false);
        previewPage.click_go_live();
        meetingRoom.is_avatarDisplayed();
        meetingRoom.is_mic_displayed();
        meetingRoom.is_switch_cam_enabled(false);
    }

    @Test
    public void Test_join_room_with_mute_cam_mic_on_preview_and_inside_room() throws InterruptedException {
        System.out.println("Cam and mic is muted on preview, state should be same inside meeting room");
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("valid").getString("meeting_url"));
        previewPage.enter_name(meetingDetail.getJSONObject("prebuilt").getString("username"));
        previewPage.click_mic();
        previewPage.click_cam();
        previewPage.is_avatarDisplayed();
        previewPage.is_muteIconDisplayed();
        previewPage.is_switch_cam_enabled(false);
        previewPage.click_go_live();
        meetingRoom.is_avatarDisplayed();
        meetingRoom.is_muteIconDisplayed();
        meetingRoom.is_switch_cam_enabled(false);
    }

    @Test
    public void Test_join_room_with_unmuted_cam_mic_on_preview_and_inside_room() throws InterruptedException {
        System.out.println("Cam and mic is un-muted on preview, state should be same inside meeting room");
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("valid").getString("meeting_url"));
        previewPage.enter_name(meetingDetail.getJSONObject("prebuilt").getString("username"));
        previewPage.is_mic_displayed();
        previewPage.is_cam_displayed();
        previewPage.is_switch_cam_enabled(true);
        previewPage.click_go_live();
        meetingRoom.is_mic_displayed();
        meetingRoom.is_cam_displayed();
        meetingRoom.is_switch_cam_enabled(true);
    }


    @Test
    public void Test_select_audio_output() throws InterruptedException {
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("valid").getString("meeting_url"));
        previewPage.enter_name(meetingDetail.getJSONObject("prebuilt").getString("username"));
        previewPage.click_go_live();
        meetingRoom.click_select_audio_output_button();
        meetingRoom.click_select_phone_audio_output();
        meetingRoom.click_select_audio_output_button();
        meetingRoom.is_phone_selected();
        meetingRoom.click_select_speaker_audio_output();
        meetingRoom.click_select_audio_output_button();
        meetingRoom.is_speaker_selected();
        meetingRoom.click_select_default_audio_output();
        meetingRoom.click_select_audio_output_button();
        meetingRoom.is_speaker_selected();
    }

    @Test
    public void Test_start_stop_recording() throws InterruptedException{
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("valid").getString("meeting_url"));
        previewPage.enter_name(meetingDetail.getJSONObject("prebuilt").getString("username"));
        previewPage.click_go_live();
        meetingRoom.open_menu();
        meetingRoom.start_recording();
        meetingRoom.is_recording_running(true);
        meetingRoom.open_menu();
        meetingRoom.stop_recording();
        meetingRoom.is_recording_running(false);
    }

    @Test
    public void Test_open_and_close_peerlist() throws InterruptedException{
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("prebuilt").getString("co-broadcaster_meeting_url"));
        previewPage.enter_name(meetingDetail.getJSONObject("prebuilt").getString("username"));
        previewPage.click_go_live();
        meetingRoom.open_menu();
        menu.open_participant();
        //menu.is_current_peer_present_in_participantlist(meetingDetail.getJSONObject("prebuilt").getString("username"));
        menu.close_participant();
    }

    @Test
    public void Test_send_message() throws InterruptedException{
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("prebuilt").getString("co-broadcaster_meeting_url"));
        previewPage.enter_name(meetingDetail.getJSONObject("prebuilt").getString("username"));
        previewPage.click_go_live();
        meetingRoom.open_message_box();
        meetingRoom.send_message();
        meetingRoom.was_message_sent();
    }

//        @Test
//    public void Test_leave_room_viewer() throws InterruptedException{
//        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("prebuilt").getString("vnrt_meeting_url"));
//        previewPage.enter_name(meetingDetail.getJSONObject("prebuilt").getString("username"));
//        previewPage.click_go_live();
//        meetingRoom.click_viewer_leave_button();
//        meetingRoom.click_leave_button();
//        homePage.are_homepage_elements_displayed();
//    }

    
}
