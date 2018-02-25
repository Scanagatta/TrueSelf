package application;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import TrueSelf.modelo.Comentario;
import TrueSelf.modelo.SimuladorDB;
import TrueSelf.modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Callback;

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
	private TableColumn<Comentario, Image> cClassificacao;

	@FXML
	private TextArea taComentario;

	@FXML
	private Button btnPostar;

	@FXML
	private Text lSexo;

	private static Usuario visitado;

	private Comentario comentario;

	@FXML
	private ImageView imagemPerfil;

	public static Usuario getVisitado() {
		return visitado;
	}

	public static void setVisitado(Usuario visitado) {
		TelaPerfilVisitanteController.visitado = visitado;
	}

	public void initialize() {

		// ele ta inicializando com o usuario que foi pego no combobox do metodo
		// onPesquisar
		// da classse TelaPerfilDonoController
		tnome.setText(getVisitado().getNome());
		lSexo.setText(getVisitado().getSexo());
		tEstadoCivil.setText(getVisitado().getEstadoCivil());
		tDataNascimento.setText(getVisitado().getDataNascimento().toString());
		countAnjo.setText(getVisitado().getQtdAnjo().toString());
		countDemonio.setText(getVisitado().getQtdDemonio().toString());
		countNeutro.setText(getVisitado().getQtdNeutro().toString());
		cData.setCellValueFactory(new PropertyValueFactory<>("data"));
		cComentario.setCellValueFactory(new PropertyValueFactory<>("comentario"));
		tblComentarios.setItems(
				FXCollections.observableArrayList(SimuladorDB.getLogin(visitado.getLogin()).getComentarios()));
		cClassificacao.setCellValueFactory(new PropertyValueFactory<>("imagemClassificacao"));
		cClassificacao.setCellFactory(new Callback<TableColumn<Comentario, Image>, TableCell<Comentario, Image>>() {

			@Override
			public TableCell<Comentario, Image> call(TableColumn<Comentario, Image> param) {
				final ImageView imageView = new ImageView();
				TableCell<Comentario, Image> cell = new TableCell<Comentario, Image>() {
					@Override
					protected void updateItem(Image item, boolean empty) {
						if (item != null) {
							imageView.setFitHeight(20);
							imageView.setFitWidth(20);
							imageView.setImage(item);
						}
					}
				};
				cell.setGraphic(imageView);
				return cell;
			}
		});
		iniciarImagensPerfil();
		limparCampos();
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
			Main.root.setCenter(principal1View);
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
			Main.root.setCenter(principal1View);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void onPostar(ActionEvent event) {

		comentario = new Comentario(taComentario.getText(), SimuladorDB.getLogin(TelaLoginController.getDono()),
				visitado, LocalDate.now());
		visitado.adicionarComentario(comentario);
		tblComentarios.getItems().add(comentario);
		SimuladorDB.atualizarUsuarios();
		limparCampos();
	}

	private void limparCampos() {
		taComentario.setText("");
	}
	
	public void iniciarImagensPerfil(){
		if (visitado.getSexo().equals("Sexo: feminino")) {
			InputStream input = TelaPerfilDonoController.class.getResourceAsStream("Feminino.jpg");
			Image imagem = new Image(input);
			imagemPerfil.setFitHeight(97);
			imagemPerfil.setLayoutX(25);
			imagemPerfil.setImage(imagem);
		} else {
			InputStream input = TelaPerfilDonoController.class.getResourceAsStream("Masculino.jpg");
			Image imagem = new Image(input);
			imagemPerfil.setFitHeight(99);
			imagemPerfil.setLayoutY(80);
			imagemPerfil.setImage(imagem);
		}
	}

}
