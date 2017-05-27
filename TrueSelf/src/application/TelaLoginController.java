package application;

import java.io.IOException;

import TrueSelf.modelo.SimuladorDB;
import TrueSelf.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class TelaLoginController {

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
	
	@FXML
	void onEntrar(ActionEvent event) {
		

		
		String login = tfLogin.getText();
		String senha = pfSenha.getText();
		Usuario usuario = SimuladorDB.getLogin(login);
		if (usuario != null && usuario.getSenha().equals(senha)) {
			setDono(login);
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(getClass().getResource("telaPerfilDono.fxml"));
	    	try{
	    		AnchorPane donoView = (AnchorPane) loader.load();
	    		TelaPrincipal.root.setCenter(donoView);
	    		
	    	} catch (IOException e1) {
	    		e1.printStackTrace();
	    	}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setHeaderText("");
			alert.setContentText("Preencha os campos");
			alert.showAndWait();
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
		this.dono = dono;
	}

}
