package application;

import java.io.IOException;
import java.util.Arrays;

import TrueSelf.modelo.SimuladorDB;
import TrueSelf.modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;

public class CadastroController {

	public Mensagens mensagens = new Mensagens();

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

	@FXML
	private RadioButton rdmasculino;

	@FXML
	private RadioButton rdfeminino;

	@FXML
	private ToggleGroup radios;
	@Getter
	private boolean mulher = false;
	@Getter
	private boolean homem = false;
	
	@Getter
	private Usuario usuario;

	public void initialize() {
		cbEstadoCivil.setItems(FXCollections.observableArrayList("solteiro(a)", "namorando", "casado(a)",
				"divorciado(a)", "viúvo(a)"));
	}

	@FXML
	void onFeminino(ActionEvent event) {
		mulher = true; 

	}

	@FXML
	void onMasculino(ActionEvent event) {
		homem = true;

	}

	public void novo() {
		usuario = new Usuario();
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

	@FXML
	void onsalvar(ActionEvent event) {
		novo();

		if (homem) {
			usuario.setSexo("Sexo: masculino");
		}
		if (mulher) {
			usuario.setSexo("Sexo: feminino");
		}

		if (conferirCampos()) {
			mensagens.erroPrenchimento();
			return ;
		}
		if (homem == false && mulher == false) {
			mensagens.erroSexo();
		} else {
			usuario.setNome(tfNome.getText());
			usuario.setTelefone(tfTelefone.getText());
			usuario.setDataNascimento(dtNascimento.getValue());
			usuario.setLogin(tfLogin.getText());
			usuario.setEstadoCivil(cbEstadoCivil.getValue());
			if (conferirSenha()) {
				if (SimuladorDB.getLogin(tfLogin.getText()) == null) {
					SimuladorDB.insert(usuario);
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("telaLogin.fxml"));

					try {
						AnchorPane loginView = (AnchorPane) loader.load();
						TelaPrincipal.root.setCenter(loginView);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} else {
					mensagens.erroLoginJaExiste();
					limparSenha();
				}
			}
		}
	}

	public boolean conferirSenha() {
		String senha = pfSenha.getText();
		String confirmaSenha = cpsSenha.getText();

		// ver se as senhas estao vazias
		if (senha.isEmpty() || confirmaSenha.isEmpty()) {
			mensagens.erroSenha();
			limparSenha();
			return false;
		}

		// ver se as senhas sao iguais
		if (senha.equals(confirmaSenha)) {
			usuario.setSenha(senha);
			return true;
		} else {
			mensagens.senhaNaoExiste();
			limparSenha();
			return false;
		}
	}

	public void limparSenha() {
		pfSenha.setText("");
		cpsSenha.setText("");
	}

	
	public boolean conferirCampos() {
		for (TextField campos : Arrays.asList(tfNome, tfTelefone, tfLogin, cpsSenha, pfSenha)) {
			if (campos.getText().isEmpty()){
					return true;
			}
		}
		return false;
	}

}
