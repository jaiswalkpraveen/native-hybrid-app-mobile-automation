package com.qa.tests.Home;


import com.qa.BasePO;
import com.qa.Interfaces.IHomePage;
import com.qa.utils.ActionUtils;
import com.qa.utils.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import static com.qa.utils.ActionUtils.assertTrue;

public class HomePageTest extends BasePO{

    IHomePage homePage;

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
    public void beforeMethod(Method m, String env) throws Exception{
        closeApp();
        launchApp();
        System.out.println(env);
        utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
        sa = new SoftAssert();
        homePage = ActionUtils.getClassFromEnv(  env, "HomePage");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        sa.assertAll();
    }

    @Test
    public void Test_HomePage_elements() throws InterruptedException, IOException {
        homePage.put_meeting_url_and_join(meetingDetail.getJSONObject("prebuilt").getString("broadcaster_meeting_url"));
        homePage.are_homepage_elements_displayed();
    }

}
