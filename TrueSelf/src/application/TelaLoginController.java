package application;

import java.io.IOException;

import TrueSelf.modelo.SimuladorDB;
import TrueSelf.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class TelaLoginController {

	public Mensagens mensagens = new Mensagens();

	@FXML
	private AnchorPane tela;

	@FXML
	private TextField tfLogin;

	@FXML
	private PasswordField pfSenha;

	@FXML
	private Button btnEntrar;

	@FXML
	private Button btnVoltar;

	private static String dono;
	private static Usuario logado;

	@FXML
	void onEntrar(ActionEvent event) {

		String login = tfLogin.getText();
		String senha = pfSenha.getText();
		Usuario usuario = SimuladorDB.getLogin(login);
		setLogado(usuario);

		if (usuario != null && usuario.getSenha().equals(senha)) {
			setDono(login);
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("telaPerfilDono.fxml"));

			try {
				AnchorPane donoView = (AnchorPane) loader.load();
				TelaPrincipal.root.setCenter(donoView);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} else {
			mensagens.erroPrenchimento();
		}
	}

	@FXML
	void onVoltar(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("telaPrimeira.fxml"));

		try {
			AnchorPane principal1View = (AnchorPane) loader.load();
			TelaPrincipal.root.setCenter(principal1View);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		TelaLoginController.dono = dono;
	}

	public static Usuario getLogado() {
		return logado;
	}

	public static void setLogado(Usuario logado) {
		TelaLoginController.logado = logado;
	}

}
