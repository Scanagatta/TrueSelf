package application;

import TrueSelf.modelo.SimuladorDB;
import TrueSelf.modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class CadastroController {
	
    @FXML
    private AnchorPane apPrincipal;
	
	@FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    @FXML
    private DatePicker dtNascimento;

    @FXML
    private TextField tfLogin;

    @FXML
    private ComboBox<String> cbEstadoCivil;

    @FXML
    private PasswordField pfSenha;

    @FXML
    private PasswordField cpsSenha;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;
    
    private Usuario usuario;
    
    public void initialize(){
    	cbEstadoCivil.setItems(FXCollections.observableArrayList("solteiro","namorando","casado","divorciado"));
    }
    
    public void novo(){
    	usuario = new Usuario();
    }
    
    @FXML
    void onsalvar(ActionEvent event) {
    	novo();
    	usuario.setNome(tfNome.getText());
    	usuario.setTelefone(tfTelefone.getText());
    	usuario.setDataNascimento(dtNascimento.getValue());
    	usuario.setLogin(tfLogin.getText());
    	conferirSenha();
    	SimuladorDB.insert(usuario);
    }
    
    public boolean conferirSenha(){
    	String senha = pfSenha.getText();
    	String confirmaSenha = cpsSenha.getText();
    	// ver se as senhas estao vazias
    	if(senha.isEmpty() || confirmaSenha.isEmpty()){
    		return false;
    	}
    	// ver se as senhas sao iguais
    	if(senha.equals(confirmaSenha)){
    		usuario.setSenha(senha);
    		return true;
    	} else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Erro");
			alert.setHeaderText(senha);
			alert.setContentText(confirmaSenha);
			alert.showAndWait();
			limparSenha();
			return false;
    	}
    }
    
    public void limparSenha(){
    	pfSenha.setText("");
    	cpsSenha.setText("");
    }
    

}
