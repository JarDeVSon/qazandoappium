package steps;

import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {
    private static AppiumDriver<?> driver;
    public static String plataforma = "";

    public static AppiumDriver<?> validarDriver() throws MalformedURLException {

        plataforma = System.getProperty("plataforma");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(plataforma.equals("androidlocal")) {
            capabilities.setCapability("app", "C:\\Users\\pesso\\Documents\\app-debug.apk");
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("platformName", "Android");
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } else if(plataforma.equals("ioslocal")) {

            capabilities.setCapability("app", "C:\\Users\\pesso\\Documents\\LoginExample.app");
            capabilities.setCapability("deviceName", "iPhone 13");
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("platformVersion", "15.0");
            capabilities.setCapability("automationName", "XCUITest");
            driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } else if(plataforma.equals("androidfarm")) {

            System.out.println("Vai rodar no Farm - ANDROID ");

            // Set your access credentials
            capabilities.setCapability("browserstack.user", "seu user");
            capabilities.setCapability("browserstack.key", "sua key");

            // Set URL of the application under test
            capabilities.setCapability("app", "bs://646e0a44e06665154fa910f54b023426b10226e0");

            // Specify device and os_version for testing
            capabilities.setCapability("device", "Google Pixel 3");
            capabilities.setCapability("os_version", "9.0");

            driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities);

        } else if(plataforma.equals("iosfarm")) {

            // Set your access credentials
            capabilities.setCapability("browserstack.user", "seu user");
            capabilities.setCapability("browserstack.key", "sua key");

            // Set URL of the application under test
            capabilities.setCapability("app", "bs://646e0a44e06665154fa910f54b023426b10226e0");

            // Specify device and os_version for testing
            capabilities.setCapability("device", "Google Pixel 3");
            capabilities.setCapability("os_version", "9.0");

            driver = new IOSDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
        }
        else {
            System.out.println("não foi passado os parametros");
        }
        return driver;
    }

    public static AppiumDriver<?> getDriver(){
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Before
    public static void iniciarProjeto() throws MalformedURLException {
        if (getDriver() != null) {
            getDriver().launchApp();
        }else {
            validarDriver();
        }
    }
}
