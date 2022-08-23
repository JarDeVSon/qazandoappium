package maps;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class LoginMap {
    @AndroidFindBy(id = "login_username")
    @iOSFindBy(accessibility = "login_username")
    public RemoteWebElement campoemail;
}
