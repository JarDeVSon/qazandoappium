package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import screen.LoginScreen;

public class LoginSteps {
    LoginScreen login;

    @Dado("^que eu escreva as informacoes do usuario$")
    public void que_eu_escreva_as_informacoes_do_usuario() {
        login = new LoginScreen();
        login.DadosEscrever("qazando@gmail.com");
        login.QuandoescreverSenha("1234567");
    }

    @Quando("^eu clicar em logar$")
    public void eu_clicar_em_logar() {
        login.EntaoclicarParaLogar();
    }

    @Entao("^vou estar logado no app$")
    public void vou_estar_logado_no_app() {
        System.out.println("Validar logado");
    }

}
