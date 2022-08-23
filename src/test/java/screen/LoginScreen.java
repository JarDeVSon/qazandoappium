package screen;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import maps.LoginMap;
import org.openqa.selenium.support.PageFactory;
import steps.Hooks;

public class LoginScreen {
    LoginMap loginMap;

    public LoginScreen(){
        loginMap = new LoginMap();
        PageFactory.initElements(new AppiumFieldDecorator(Hooks.getDriver()), loginMap);
    }

    public void DadosEscrever(String email){
        if (email != null){
            loginMap.campoemail.sendKeys(email);
        }
    }
}
