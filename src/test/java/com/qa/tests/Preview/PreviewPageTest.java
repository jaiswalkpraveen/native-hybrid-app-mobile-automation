package com.qa.tests.Preview;

import com.qa.BasePO;
import com.qa.Interfaces.IHomePage;
import com.qa.Interfaces.IMeetingRoom;
import com.qa.Interfaces.IPreviewPage;
import com.qa.utils.ActionUtils;
import com.qa.utils.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.InputStream;
import java.lang.reflect.Method;

public class PreviewPageTest extends BasePO {

    IHomePage homePage;
    IPreviewPage previewPage;
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
        previewPage = ActionUtils.getClassFromEnv(  env, "PreviewPage");
        homePage = ActionUtils.getClassFromEnv(  env, "HomePage");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
      sa.assertAll();
    }

    @Test
    public void Test_PreviewPage_Cta() throws InterruptedException {
        System.out.println("Verify Preview page locators: mic, camera and switch camera interactive");
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("valid").getString("meeting_url"));
        previewPage.verify_preview_page_cta();
        homePage.enter_name_join(meetingDetail.getJSONObject("valid").getString("username"));
    }

    @Test
    public void Test_Join_Meeting_with_muted_cam_mic() throws InterruptedException {
        System.out.println("Turn off cam, mic and switch camera and click on join now");
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("valid").getString("meeting_url"));
        previewPage.click_switch_cam();
        previewPage.click_cam();
        previewPage.click_mic();
        homePage.enter_name_join(meetingDetail.getJSONObject("valid").getString("username"));
        //previewPage.click_go_live();
    }

    @Test
    public void Test_check_go_live_for_broadcaster_join_now_for_other_roles()throws InterruptedException{
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("prebuilt").getString("broadcaster_meeting_url"));
        previewPage.is_go_live_text_displayed_on_button(true);
        ActionUtils.hitBackButton();
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("prebuilt").getString("vnrt_meeting_url"));
        previewPage.is_join_now_text_displayed_on_button(true);
        ActionUtils.hitBackButton();
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("prebuilt").getString("vos_meeting_url"));
        previewPage.is_join_now_text_displayed_on_button(true);
        ActionUtils.hitBackButton();
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("prebuilt").getString("vrt_meeting_url"));
        previewPage.is_join_now_text_displayed_on_button(true);
        ActionUtils.hitBackButton();
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("prebuilt").getString("co-broadcaster_meeting_url"));
        previewPage.is_join_now_text_displayed_on_button(true);
    }

    @Test
    public void Test_cam_mic_toggle_status() throws InterruptedException {
        System.out.println("Verify cam and mic toggle");
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("valid").getString("meeting_url"));
        previewPage.enter_name(meetingDetail.getJSONObject("prebuilt").getString("username"));
        previewPage.click_mic();
        previewPage.is_muteIconDisplayed();
        previewPage.click_cam();
        previewPage.is_avatarDisplayed();
        previewPage.is_switch_cam_enabled(false);
        previewPage.click_mic();
        previewPage.click_cam();
        previewPage.is_switch_cam_enabled(true);
    }

   @Test
    public void Test_switch_cam_test() throws InterruptedException {
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("valid").getString("meeting_url"));
        previewPage.enter_name(meetingDetail.getJSONObject("prebuilt").getString("username"));
        previewPage.is_switch_cam_enabled(true);
        previewPage.click_cam();
        previewPage.is_switch_cam_enabled(false);
    }

    @Test
    public void Test_select_audio_output() throws InterruptedException{
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("valid").getString("meeting_url"));
        previewPage.click_select_audio_output_button();
        previewPage.click_select_phone_audio_output();
        previewPage.click_select_audio_output_button();
        previewPage.is_phone_selected();

        previewPage.click_select_speaker_audio_output();
        previewPage.click_select_audio_output_button();
        previewPage.is_speaker_selected();

        previewPage.click_select_default_audio_output();
        previewPage.click_select_audio_output_button();
        previewPage.is_speaker_selected();
    }

}
