package steps;

import cucumber.api.java.Before;

import java.net.MalformedURLException;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.validarDriver;

public class Hooks {

    @Before
    public static void iniciarProjeto() throws MalformedURLException {
        if (getDriver() != null) {
            getDriver().launchApp();
        }else {
            validarDriver();
        }
    }
}
