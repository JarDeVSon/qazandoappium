package screen;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import maps.LoginMap;
import org.openqa.selenium.support.PageFactory;
import core.DriverFactory;

public class LoginScreen {
    LoginMap loginMap;

    public LoginScreen(){
        loginMap = new LoginMap();
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getDriver()), loginMap);
    }

    public void DadosEscrever(String email){
        if (email != null){
            loginMap.campoemail.sendKeys(email);
        }
    }
    public void QuandoescreverSenha(String senha) {
        if (senha != null)
        loginMap.camposenha.sendKeys(senha);
    }

    public void EntaoclicarParaLogar() {
        loginMap.botaologin.click();
    }

    public void logar() {
        loginMap.campoemail.sendKeys("qazando@gmail.com");
        loginMap.camposenha.sendKeys("1234678");
        loginMap.botaologin.click();
    }
}
