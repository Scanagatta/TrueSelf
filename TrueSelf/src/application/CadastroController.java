package application;

import java.io.IOException;

import TrueSelf.modelo.SimuladorDB;
import TrueSelf.modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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

	@FXML
	private RadioButton rdmasculino;

	@FXML
	private RadioButton rdfeminino;

	@FXML
	private ToggleGroup radios;

	private boolean mulher = false;

	private boolean homem = false;

	private Usuario usuario;

	private String vazio = "";

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
		if (tfNome.getText().equals(vazio) || tfTelefone.getText().equals(vazio)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setHeaderText("Ação inválida");
			alert.setContentText("Preencha TODOS os campos");
			alert.showAndWait();
		} else {
			if (homem == false && mulher == false) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro");
				alert.setHeaderText("Ação inválida");
				alert.setContentText("Selecione o sexo");
				alert.showAndWait();
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
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Erro");
						alert.setHeaderText("Ação inválida");
						alert.setContentText("Login existente");
						alert.showAndWait();
						limparSenha();
					}
				}
			}
		}
	}

	public boolean conferirSenha() {
		String senha = pfSenha.getText();
		String confirmaSenha = cpsSenha.getText();
		// ver se as senhas estao vazias
		if (senha.isEmpty() || confirmaSenha.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setHeaderText("Ação inválida");
			alert.setContentText("Preencha TODOS os campos");
			alert.showAndWait();
			limparSenha();
			return false;

		}
		// ver se as senhas sao iguais
		if (senha.equals(confirmaSenha)) {
			usuario.setSenha(senha);
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setHeaderText("As senhas não são iguais");
			alert.setContentText("Digite a senha corretamente");
			alert.showAndWait();
			limparSenha();
			return false;
		}
	}

	public void limparSenha() {
		pfSenha.setText("");
		cpsSenha.setText("");
	}

}
