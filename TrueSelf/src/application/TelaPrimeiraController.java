package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
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

		Text texto = new Text();
		stage.setScene(new Scene(new StackPane(texto)));
		stage.setTitle("Importante");
		texto.setText("True self é uma espécie de rede social offline\n\n\nCriado com o intuito de as pessoas"
				+ " interagirem\nentre elas, dando sua opinião uma sobre a outra\n\nDesenvolvido por acadêmicos da UNOESC- Xanxerê\n"
				+ "do curso de Tecnologia em Análise e Desenvolvimento\nde Sistemas - 3ª fase\n\n\n\n\n TrueSelf® 2017");

		stage.setWidth(390);
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
