package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class TelaPrimeiraController {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCadastro;

    @FXML
    private BorderPane bpTela;
    
    private static BorderPane bpTelaCompartilhada;
    
    public void initialize(){
    
    	
    }
    
    
    
    @FXML
    void onCadastrar(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("telaCadastro.fxml"));
    	try{
    		AnchorPane agenciaView = (AnchorPane) loader.load();
    		TelaPrincipal.root.setCenter(agenciaView);
    		
    	} catch (IOException e1) {
    		e1.printStackTrace();
    	}

    }
    
    public static void trocarTela(Node tela){
    	bpTelaCompartilhada.setCenter(tela);
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