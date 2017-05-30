package application;


import java.io.IOException;
import java.time.LocalDate;

import TrueSelf.modelo.Comentario;
import TrueSelf.modelo.SimuladorDB;
import TrueSelf.modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
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
    private TableView<Comentario> tblComentarios;

    @FXML
    private TableColumn<Comentario, LocalDate> cData;

    @FXML
    private TableColumn<Comentario, String> cComentario;

    @FXML
    private TableColumn<Comentario, ImageView> cClassificacao;
    
    @FXML
    private TextArea taComentario;
    
    @FXML
    private Button btnPostar;

	private static Usuario usuario;
	
	private Comentario comentario;

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
		cData.setCellValueFactory(new PropertyValueFactory<>("data"));
    	cComentario.setCellValueFactory(new PropertyValueFactory<>("comentario"));
		tblComentarios.setItems(FXCollections.observableArrayList(SimuladorDB.getComentarios()));
		novo();
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
	

    @FXML
    void onPostar(ActionEvent event) {
    	novo();
    	comentario.comentar(usuario, SimuladorDB.getLogin(TelaLoginController.getDono()), taComentario.getText());
    	SimuladorDB.insert(comentario);
    	tblComentarios.getItems().add(comentario);
    }
    
    private void novo(){
    	comentario = new Comentario();
    	limparCampos();
    }

    private void limparCampos(){
    	taComentario.setText("");
    }

}
