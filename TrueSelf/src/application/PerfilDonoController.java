package application;

import java.io.IOException;

import TrueSelf.modelo.SimuladorDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class PerfilDonoController {
	  @FXML
	    private Pane cbxAvaliacao;

	    @FXML
	    private Text tNome;

	    @FXML
	    private Text tIdade;

	    @FXML
	    private TableView<?> lvComentarios;

	    @FXML
	    private Text countAnjo;

	    @FXML
	    private Text countDemonio;

	    @FXML
	    private Text countNeutro;

	    @FXML
	    private Button btnAvaliacao;

	    @FXML
	    private Button btnSair;

	    @FXML
	    private Button btnPesquisar;
	    
	    public void initialize(){
	    	SimuladorDB.getLogin(TelaLoginController.getDono());
	    	tNome.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getNome());
	    	//tIdade.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getIdade().toString());
	    	countAnjo.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getQtdAnjo().toString());
	    	countDemonio.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getQtdAnjo().toString());
	    	countNeutro.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getQtdAnjo().toString());
	    }
	    
	    @FXML
	    void onSair(ActionEvent event){
	    	FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("telaPrimeira.fxml"));
			try {
				AnchorPane principal1View = (AnchorPane) loader.load();
				TelaPrincipal.root.setCenter(principal1View);

			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    }
	    
	    @FXML
	    void onPesquisar(ActionEvent event){
	    	//boa sorte joao
	    	
	    	// boa sorte tu kkk
	    }
	    
	    
	    
}
