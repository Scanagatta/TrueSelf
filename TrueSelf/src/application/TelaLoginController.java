package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

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
    
  
    
    @FXML
    void onVoltar(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("telaPrimeira.fxml"));
    	try{
    		AnchorPane principal1View = (AnchorPane) loader.load();
    		TelaPrincipal.root.setCenter(principal1View);
    		
    	} catch (IOException e1) {
    		e1.printStackTrace();
    	}
    }
	
}
