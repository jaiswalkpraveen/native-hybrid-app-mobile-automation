package com.qa.tests.LocalUpdates;

import com.qa.BasePO;
import com.qa.Interfaces.IMeetingRoom;
import com.qa.Interfaces.IMenu;
import com.qa.Interfaces.ITopBottomBar;
import com.qa.actionVariable.DesktopWebPage;
import com.qa.utils.ActionUtils;
import com.qa.utils.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class ChangeNameTest extends BasePO {

  IMeetingRoom meetingRoom;
  ITopBottomBar topBottomBar;
  IMenu menu;
  DesktopWebPage desktopWebPage= new DesktopWebPage();
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
      topBottomBar = ActionUtils.getClassFromEnv(  env, "TopBottomBar");
      menu = ActionUtils.getClassFromEnv(  env, "Menu");

  }

    @AfterMethod
    public void afterMethod() {
      sa.assertAll();
    }

    @Test
    public void Test_SetLayout() throws InterruptedException, IOException {
        System.out.println("Verify Participant Leave Room cancel option");
      meetingRoom.goto_meetingRoom_mic_cam(meetingDetail.getJSONObject("valid").getString("meeting_url"),
              meetingDetail.getJSONObject("valid").getString("username"),
              meetingDetail.getJSONObject("camera").getString("OFF"),
              meetingDetail.getJSONObject("mic").getString("OFF"));

      menu.click_change_my_name();
      topBottomBar.click_leave_button();
    }

}
