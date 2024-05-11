# Prerequisites 

1. Install Appium Server GUI - https://github.com/appium/appium-desktop/releases
2. Install Appium Inspector - https://github.com/appium/appium-inspector/releases
3. Download Android Studio - https://developer.android.com/studio/install

Issues:
Error - https://discuss.appium.io/t/getting-error-while-launching-appium-server-pragmatically-but-it-getting-started-manual-hitting-the-command/25200

Setting needed for inspector and appium server:

<img width="519" alt="Screenshot 2023-08-21 at 1 56 51 PM" src="https://github.com/100mslive/mobile-automation/assets/52071017/156ff313-a1a3-491c-b469-e415332cb920">
<img width="1077" alt="Screenshot 2023-08-21 at 1 54 29 PM" src="https://github.com/100mslive/mobile-automation/assets/52071017/5a61280e-4ec9-4728-aa90-151e0710976f">

----
To run the test for RN
mvn clean test -Dsurefire.suiteXmlFiles=android_rn.xml
