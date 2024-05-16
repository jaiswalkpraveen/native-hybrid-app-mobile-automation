# Prerequisites 

1. Install Appium Server GUI - https://github.com/appium/appium-desktop/releases
2. Install Appium Inspector - https://github.com/appium/appium-inspector/releases
3. Download Android Studio - https://developer.android.com/studio/install

Issues:
Error - https://discuss.appium.io/t/getting-error-while-launching-appium-server-pragmatically-but-it-getting-started-manual-hitting-the-command/25200

Setting needed for inspector and appium server:


----
To run the test for RN
mvn clean test -Dsurefire.suiteXmlFiles=android_rn.xml
