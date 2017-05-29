package application;

import java.awt.TextArea;
import java.io.IOException;

import TrueSelf.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class TelaPerfilVisitanteController {

	@FXML
	private Text tnome;

	@FXML
	private Text tEstadoCivil;

	@FXML
	private Text countAnjo;

	@FXML
	private Text countDemonio;

	@FXML
	private Text countNeutro;

	@FXML
	private Button btnsair;

	@FXML
	private Button btnperfil;

	@FXML
	private Text tDataNascimento;
	
	@FXML
    private TableView<?> tblComentarios;

    @FXML
    private TableColumn<?, ?> cData;

    @FXML
    private TableColumn<?, ?> cComentario;

    @FXML
    private TableColumn<?, ?> cClassificacao;
    
    @FXML
    private TextArea taComentario;
    
    @FXML
    private Button btnPostar;

	private static Usuario usuario;

	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		TelaPerfilVisitanteController.usuario = usuario;
	}

	public void initialize() {

		// ele ta inicializando com o usuario que foi pego no combobox do metodo
		// onPesquisar
		// da classse TelaPerfilDonoController

		tnome.setText(getUsuario().getNome());
		tEstadoCivil.setText(getUsuario().getEstadoCivil());
		tDataNascimento.setText(getUsuario().getDataNascimento().toString());
		countAnjo.setText(getUsuario().getQtdAnjo().toString());
		countDemonio.setText(getUsuario().getQtdDemonio().toString());
		countNeutro.setText(getUsuario().getQtdNeutro().toString());
	}

	/**
	 * é o botao da tela de visitante para voltar pro perfil do dono
	 * 
	 * @param event
	 */
	@FXML
	void onPerfil(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("telaPerfilDono.fxml"));
		try {
			AnchorPane principal1View = (AnchorPane) loader.load();
			TelaPrincipal.root.setCenter(principal1View);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * é o botao da tela de visitante para sair, volta para tela inicial
	 * 
	 * @param event
	 */
	@FXML
	void onSair(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("telaPrimeira.fxml"));
		try {
			AnchorPane principal1View = (AnchorPane) loader.load();
			TelaPrincipal.root.setCenter(principal1View);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
