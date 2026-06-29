# TechnicalTest_QA — Automation Test Project

This repository will consist of the 3 main task of automating App, Web, and API Scenario 
that each platform has seperated task/use case needs to be completed. It uses Java as the programming language, Cucumber
It uses Java, Cucumber (Gherkin), Appium for App Automation, Selenium WebDriver for Web Automation and RestAssured for API Testing, with Gradle as the build tool.

The purpose is to validate functionality of each given scenario of this condition:
1. App: mda-2.2.0-25.apk
2. Bibit Website
3. API: https://jsonplaceholder.typicode.com/

Tech Stack
- Language: Java
- Build Tool: Gradle
- Test Framework: Cucumber (BDD)
- Mobile Automation: Appium
- Mobile Inspector: Appium Inspector
- Web Automation: Selenium WebDriver
- API Testing: RestAssured

## Prerequisites

### General
- Java JDK (java 23.0.2)
- IntelliJ IDEA
- Gradle (bundled via Gradle Wrapper)

### For App Tests
1. Install Android Studio
2. Create and start an Android Emulator (API level 30+ recommended)
3. Install Appium Server: npm install -g appium
4. Download the APK: https://github.com/saucelabs/my-demo-app-android/releases/download/2.2.0/mda-2.2.0-25.apk
5. Install the APK on the emulator
6. Connect to Appium Server, type "Appium" on the console
7.To run the test, can be done with these option:
   a. Custom Task: ./gradlew runAppTests
   b. Run the test from feature file in  /resources/appfeatures

### For Web Tests
1. To bypass Bibit Verification Process (OTP,PIN). user has to login manually their Bibit Account using the specific chrome port on console (cmd)
   : "C:\Program Files\Google\Chrome\Application\chrome.exe" --remote-debugging-port=9222 --user-data-dir="C:\chrome-debug"
3. Go to `https://app.bibit.id` and login manually (Should be in Homepage) 
3. To run the test, can be done with these option:
   a. Custom Task: ./gradlew runWebTests
   b. Run the test from feature file in  /resources/webfeatures
  
### For API Test
1. To run the test, can be done with these option:
   a. Custom Task: ./gradlew runAPITests
   b. Run the test from feature file in  /resources/apifeatures (Recommended for result clarity)

Thank you very much