package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TelaPrimeiraController {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCadastro;

    @FXML
    private BorderPane bpTela;
    
  
    
     
    
    @FXML
    void onCadastrar(ActionEvent event) {
		Stage stage = new Stage();

		TextArea texto = new TextArea();
		texto.setTooltip(new Tooltip());
		stage.setScene(new Scene(new StackPane(texto)));
		stage.setTitle("Importante");
		texto.setText("True self é uma espécie de rede social offline\ntudo bem com vcs");
		stage.setWidth(300);
		stage.setHeight(300);
		stage.show();
		
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("telaCadastro.fxml"));
    	try{
    		AnchorPane agenciaView = (AnchorPane) loader.load();
    		TelaPrincipal.root.setCenter(agenciaView);
    		
    	} catch (IOException e1) {
    		e1.printStackTrace();
    	}

    }
    


    @FXML
    void onLogar(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("telaLogin.fxml"));
    	try{
    		AnchorPane loginView = (AnchorPane) loader.load();
    		TelaPrincipal.root.setCenter(loginView);
    		
    	} catch (IOException e1) {
    		e1.printStackTrace();
    	}

    }

}
