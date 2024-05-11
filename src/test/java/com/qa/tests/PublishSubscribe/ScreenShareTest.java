package com.qa.tests.PublishSubscribe;

import com.qa.BasePO;
import com.qa.Interfaces.*;
import com.qa.actionVariable.DesktopWebPage;
import com.qa.utils.ActionUtils;
import com.qa.utils.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.InputStream;
import java.lang.reflect.Method;

public class ScreenShareTest extends BasePO {

    IMeetingRoom meetingRoom;
    ITopBottomBar topBottomBar;
    IHomePage homePage;
    IPreviewPage previewPage;
    IMenu menu;
    DesktopWebPage desktopWebPage = new DesktopWebPage();
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
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (datais != null) {
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
        meetingRoom = ActionUtils.getClassFromEnv(env, "MeetingRoom");
        //topBottomBar = ActionUtils.getClassFromEnv(  env, "TopBottomBar");
        menu = ActionUtils.getClassFromEnv(env, "Menu");
        homePage = ActionUtils.getClassFromEnv(env, "HomePage");
        previewPage = ActionUtils.getClassFromEnv(env, "PreviewPage");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        meetingRoom.click_endstream_leave_button();
        meetingRoom.click_leave_button();
        homePage.are_homepage_elements_displayed();
    }

    @Test
    public void Test_ScreenShare() throws InterruptedException {
        System.out.println("Verify user start share screen, verify and stop it");
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("prebuilt").getString("broadcaster_meeting_url"));
        homePage.enter_name_join(meetingDetail.getJSONObject("valid").getString("username"));
        meetingRoom.open_menu();
        menu.click_screen_share();
        menu.is_screenshare_started();
        menu.click_stop_screenshare();
    }

    //@Test
    //Keep this commented out. Will fix this once we have proper locators for element
    public void Test_screenshare_option_not_displayed_for_roles() throws InterruptedException {
        System.out.println("Verify Participant Leave Room cancel option");
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("prebuilt").getString("vnrt_meeting_url"));
        previewPage.enter_name(meetingDetail.getJSONObject("prebuilt").getString("username"));
        previewPage.click_go_live();
        meetingRoom.open_menu();
        menu.is_screeshare_option_present(false);
    }

}