package com.qa;

import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BasePO {
	protected static ThreadLocal <AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	protected static ThreadLocal <Properties> props = new ThreadLocal<Properties>();
	protected static ThreadLocal <HashMap<String, String>> strings = new ThreadLocal<HashMap<String, String>>();
	protected static ThreadLocal <String> platform = new ThreadLocal<String>();
	protected static ThreadLocal <String> dateTime = new ThreadLocal<String>();
	protected static ThreadLocal <String> deviceName = new ThreadLocal<String>();
	protected static ThreadLocal <String> env = new ThreadLocal<String>();
	private static AppiumDriverLocalService server;
	TestUtils utils = new TestUtils();
	SoftAssert sa = new SoftAssert();

	public static AppiumDriver getDriver() {
		return driver.get();
	}

	public void setDriver(AppiumDriver driver2) {
		driver.set(driver2);
	}

	public Properties getProps() {
		return props.get();
	}

	public void setProps(Properties props2) {
		props.set(props2);
	}

	public HashMap<String, String> getStrings() {
		return strings.get();
	}

	public void setStrings(HashMap<String, String> strings2) {
		strings.set(strings2);
	}

	public String getPlatform() {
		return platform.get();
	}

	public void setPlatform(String platform2) {
		platform.set(platform2);
	}

	public String getDateTime() {
		return dateTime.get();
	}

	public void setDateTime(String dateTime2) {
		dateTime.set(dateTime2);
	}

	public String getDeviceName() {
		return deviceName.get();
	}

	public void setDeviceName(String deviceName2) {
		deviceName.set(deviceName2);
	}

	public BasePO() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	@BeforeMethod
	public void beforeMethod() {
		((CanRecordScreen) getDriver()).startRecordingScreen();
//		((IOSDriver) getDriver()).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done"); // Done can change to whatever valid on our screen

//		((CanRecordScreen) getDriver()).startRecordingScreen(
//				new IOSStartScreenRecordingOptions()
//						.withFps(24)
//						.withVideoScale("320:-2")
//						.withVideoType("h264")
//		);
	}

	//stop video capturing and create *.mp4 file
	@AfterMethod
	public synchronized void afterMethod(ITestResult result) throws Exception {
		String media = ((CanRecordScreen) getDriver()).stopRecordingScreen();

		Map <String, String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();
		String dirPath = "videos" + File.separator + params.get("platformName") + "_" + params.get("deviceName")
				+ File.separator + getDateTime() + File.separator + result.getTestClass().getRealClass().getSimpleName();

		File videoDir = new File(dirPath);

		synchronized(videoDir){
			if(!videoDir.exists()) {
				videoDir.mkdirs();
			}
		}
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
			stream.write(Base64.decodeBase64(media));
			stream.close();
			utils.log().info("video path: " + videoDir + File.separator + result.getName() + ".mp4");
		} catch (Exception e) {
			utils.log().error("error during video capture" + e.toString());
		} finally {
			if(stream != null) {
				stream.close();
			}
		}
	}

	@BeforeSuite
	public void beforeSuite() throws Exception, Exception {
		ThreadContext.put("ROUTINGKEY", "ServerLogs");
		server = getAppiumService(); // -> If using Mac, uncomment this statement and comment below statement
//		server = getAppiumServerDefault(); // -> If using Windows, uncomment this statement and comment above statement
		if(!checkIfAppiumServerIsRunnning(4723)) {
			server.start();
			server.clearOutPutStreams(); // -> Comment this if you don't want to see server logs in the console
			utils.log().info("Appium server started");
		} else {
			utils.log().info("Appium server already running");
		}
	}

	public boolean checkIfAppiumServerIsRunnning(int port) throws Exception {
		boolean isAppiumServerRunning = false;
		ServerSocket socket;
		try {
			socket = new ServerSocket(port);
			socket.close();
		} catch (IOException e) {
			System.out.println("1");
			isAppiumServerRunning = true;
		} finally {
			socket = null;
		}
		return isAppiumServerRunning;
	}

	@AfterSuite (alwaysRun = true)
	public void afterSuite() {
		if(server.isRunning()){
			server.stop();
			utils.log().info("Appium server stopped");
		}
	}

	// for Windows
//	public AppiumDriverLocalService getAppiumServerDefault() {
//		return AppiumDriverLocalService.buildDefaultService();
//	}

	// for Mac. Update the paths as per your Mac setup
	public AppiumDriverLocalService getAppiumService() {
		HashMap<String, String> environment = new HashMap<String, String>();

 		environment.put("PATH", "/Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin:/Users/praveen/Library/Android/sdk/tools:/Users/praveen/Library/Android/sdk/platform-tools:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Library/Apple/usr/bin" + System.getenv("PATH"));
 		environment.put("ANDROID_HOME", "/Users/praveen/Library/Android/sdk"); //Uncomment for local

//		environment.put("PATH", "/Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin:/Users/runner/Library/Android/sdk/tools:/Users/runner/Library/Android/sdk/platform-tools:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Library/Apple/usr/bin" + System.getenv("PATH"));
//		environment.put("ANDROID_HOME", "/Users/runner/Library/Android/sdk");  //Uncomment for CI

//		environment.put("PATH", "/hostedtoolcache/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin:/Users/runner/hostedtoolcache/Android/sdk/tools:/Users/runner/hostedtoolcache/Android/sdk/platform-tools:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/hostedtoolcache/Apple/usr/bin" + System.getenv("PATH"));
//		environment.put("ANDROID_HOME", "/Users/runner/hostedtoolcache/Android/sdk");  //Uncomment for CI

		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("/usr/local/bin/node"))
//				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))  //Uncomment for local new
// 				.withAppiumJS(new File("/Applications/Appium Server GUI.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))  //Uncomment for local old
    		.withAppiumJS(new File("/Users/runner/hostedtoolcache/node/16.20.2/x64/lib/node_modules/appium/build/lib/main.js"))  //Uncomment for CI

				.usingPort(4723)
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withArgument(() -> "--allow-insecure","chromedriver_autodownload")
				.withEnvironment(environment)
				.withLogFile(new File("ServerLogs/server.log")));
	}

	@Parameters({"emulator", "platformName", "env" , /*"udid",*/ "deviceName", "systemPort",
			"chromeDriverPort", "wdaLocalPort", "webkitDebugProxyPort"})
	@BeforeTest
	public void beforeTest(@Optional("androidOnly")String emulator, String platformName, String env, /*String udid,*/ String deviceName,
						   @Optional("androidOnly")String systemPort, @Optional("androidOnly")String chromeDriverPort,
						   @Optional("iOSOnly")String wdaLocalPort, @Optional("iOSOnly")String webkitDebugProxyPort) throws Exception {
		setDateTime(utils.dateTime());
		setPlatform(platformName);
		setDeviceName(deviceName);
		System.out.println("--------"+ env);
		URL url;
		InputStream inputStream = null;
		InputStream stringsis = null;
		Properties props = new Properties();
		AppiumDriver driver;

		String strFile = "logs" + File.separator + platformName + "_" + deviceName;
		File logFile = new File(strFile);
		if (!logFile.exists()) {
			logFile.mkdirs();
		}
		//route logs to separate file for each thread
		ThreadContext.put("ROUTINGKEY", strFile);
		utils.log().info("log path: " + strFile);

		try {
			props = new Properties();
			String propFileName = "config.properties";
			String xmlFileName = "strings/strings.xml";
			String androidAppUrl;

			utils.log().info("load " + propFileName);
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			props.load(inputStream);
			setProps(props);

			utils.log().info("load " + xmlFileName);
			stringsis = getClass().getClassLoader().getResourceAsStream(xmlFileName);
			setStrings(utils.parseStringXML(stringsis));

			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", platformName);
			desiredCapabilities.setCapability("deviceName", deviceName);
//			desiredCapabilities.setCapability("udid", udid);
			url = new URL("http://127.0.0.1:4723/wd/hub");


			switch(env) {
				case "Android_Flutter":
					desiredCapabilities.setCapability("automationName", "UiAutomator2");
					desiredCapabilities.setCapability("appPackage", "live.hms.flutter");
					desiredCapabilities.setCapability("appActivity", ".MainActivity");
					if(emulator.equalsIgnoreCase("true")) {
						desiredCapabilities.setCapability("avd", deviceName);
						desiredCapabilities.setCapability("avdLaunchTimeout", 120000);
					}
					desiredCapabilities.setCapability("systemPort", systemPort);
					desiredCapabilities.setCapability("chromeDriverPort", chromeDriverPort);
					androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
							+ File.separator + "resources" + File.separator + "app" + File.separator + "Android_Flutter.apk";
//				androidAppUrl = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
					utils.log().info("appUrl is" + androidAppUrl);
					desiredCapabilities.setCapability("app", androidAppUrl);
					desiredCapabilities.setCapability("noReset", "true");
					desiredCapabilities.setCapability("autoGrantPermissions", "true");
					driver = new AndroidDriver(url, desiredCapabilities);
					break;

				case "Android_Native":
					desiredCapabilities.setCapability("automationName", "UiAutomator2");
					desiredCapabilities.setCapability("appPackage", "live.hms.app2");
					desiredCapabilities.setCapability("appActivity", ".ui.home.HomeActivity");
					if(emulator.equalsIgnoreCase("true")) {
						desiredCapabilities.setCapability("avd", deviceName);
						desiredCapabilities.setCapability("avdLaunchTimeout", 120000);
					}
					desiredCapabilities.setCapability("systemPort", systemPort);
					desiredCapabilities.setCapability("chromeDriverPort", chromeDriverPort);
// 					androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
// 							+ File.separator + "resources" + File.separator + "app" + File.separator + "Android_Native.apk";
					androidAppUrl = System.getProperty("user.dir") + File.separator + "app-debug.apk"; //for CI
					utils.log().info("appUrl is" + androidAppUrl);
					desiredCapabilities.setCapability("app", androidAppUrl);
					desiredCapabilities.setCapability("noReset", "true");
					desiredCapabilities.setCapability("autoGrantPermissions", "true");
					driver = new AndroidDriver(url, desiredCapabilities);
					break;

				case "Android_RN":
					desiredCapabilities.setCapability("automationName", "UiAutomator2");
					desiredCapabilities.setCapability("appPackage", "live.hms.rn");
					desiredCapabilities.setCapability("appActivity", ".MainActivity");
					if(emulator.equalsIgnoreCase("true")) {
						desiredCapabilities.setCapability("avd", deviceName);
						desiredCapabilities.setCapability("avdLaunchTimeout", 120000);
					}
					desiredCapabilities.setCapability("systemPort", systemPort);
					desiredCapabilities.setCapability("chromeDriverPort", chromeDriverPort);
					androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
							+ File.separator + "resources" + File.separator + "app" + File.separator + "Android_RN.apk";
//				String androidAppUrl = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
					utils.log().info("appUrl is" + androidAppUrl);
					desiredCapabilities.setCapability("app", androidAppUrl);
					desiredCapabilities.setCapability("noReset", "true");
					desiredCapabilities.setCapability("autoGrantPermissions", "true");
					driver = new AndroidDriver(url, desiredCapabilities);
					break;

				case "iOS_Flutter":
					desiredCapabilities.setCapability("automationName", "XCUITest");
//				String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
//						+ File.separator + "resources" + File.separator + "app" + File.separator + "iOS_Flutter.app";
					//	String iOSAppUrl = getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
//				utils.log().info("appUrl is" + iOSAppUrl);

					desiredCapabilities.setCapability("platformName", platformName);
					desiredCapabilities.setCapability("platformVersion", "15.5");
					desiredCapabilities.setCapability("deviceName", deviceName);
					desiredCapabilities.setCapability("systemPort", systemPort);
					desiredCapabilities.setCapability("chromeDriverPort", chromeDriverPort);
					desiredCapabilities.setCapability("bundleId", "live.100ms.flutter");
					desiredCapabilities.setCapability("wdaLocalPort", wdaLocalPort);
					desiredCapabilities.setCapability("webkitDebugProxyPort", webkitDebugProxyPort);
					desiredCapabilities.setCapability("connectHardwareKeyboard", false);
					desiredCapabilities.setCapability("autoGrantPermissions", "true");

//				desiredCapabilities.setCapability("app", iOSAppUrl);

					driver = new IOSDriver(url, desiredCapabilities);

					break;

				case "iOS_Native":
					desiredCapabilities.setCapability("automationName", "XCUITest");
//					iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
//							+ File.separator + "resources" + File.separator + "app" + File.separator + "iOS_Native.app";
					//	String iOSAppUrl = getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
//					utils.log().info("appUrl is" + iOSAppUrl);
//					desiredCapabilities.setCapability("udid", "E75A7970-9032-4F49-959A-654BFA1FC38F");
					desiredCapabilities.setCapability("platformName", platformName);
					desiredCapabilities.setCapability("platformVersion", "15.5");
					desiredCapabilities.setCapability("deviceName", deviceName);
					desiredCapabilities.setCapability("systemPort", systemPort);
					desiredCapabilities.setCapability("chromeDriverPort", chromeDriverPort);
					desiredCapabilities.setCapability("bundleId", "live.100ms.videoapp");
					desiredCapabilities.setCapability("wdaLocalPort", wdaLocalPort);
					desiredCapabilities.setCapability("webkitDebugProxyPort", webkitDebugProxyPort);
					desiredCapabilities.setCapability("connectHardwareKeyboard", false);
					desiredCapabilities.setCapability("autoGrantPermissions", "true");
					desiredCapabilities.setCapability("camera", "true");
//					desiredCapabilities.setCapability("app", iOSAppUrl);

					driver = new IOSDriver(url, desiredCapabilities);

					break;


				case "iOS_RN":
					desiredCapabilities.setCapability("automationName", "XCUITest");
//					iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
//							+ File.separator + "resources" + File.separator + "app" + File.separator + "iOS_RN.app";
					//	String iOSAppUrl = getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
//					utils.log().info("appUrl is" + iOSAppUrl);
					desiredCapabilities.setCapability("bundleId", props.getProperty("iOSBundleId"));
					desiredCapabilities.setCapability("wdaLocalPort", wdaLocalPort);
					desiredCapabilities.setCapability("webkitDebugProxyPort", webkitDebugProxyPort);
//					desiredCapabilities.setCapability("app", iOSAppUrl);

					driver = new IOSDriver(url, desiredCapabilities);
					break;

				default:
					throw new Exception("Invalid platform! - " + platformName);
			}
			setDriver(driver);
			utils.log().info("driver initialized: " + driver);
		} catch (Exception e) {
			utils.log().fatal("driver initialization failure. ABORT!!!\n" + e.toString());
			throw e;
		} finally {
			if(inputStream != null) {
				inputStream.close();
			}
			if(stringsis != null) {
				stringsis.close();
			}
		}
	}

	public static void closeApp() {
		((InteractsWithApps) getDriver()).closeApp();
	}

	public static void launchApp() {
		((InteractsWithApps) getDriver()).launchApp();
	}

	@AfterTest (alwaysRun = true)
	public void afterTest() {
		if(getDriver() != null){
			getDriver().quit();
		}
	}
}
