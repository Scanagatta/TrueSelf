
package application;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import TrueSelf.modelo.Comentario;
import TrueSelf.modelo.SimuladorDB;
import TrueSelf.modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TelaPerfilDonoController {

	public Mensagens mensagens = new Mensagens();

	@FXML
	private Pane pane;

	@FXML
	private Text tNome;

	@FXML
	private Text tEstadoCivil;

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
	private ComboBox<ImageView> cbxAvaliacao;

	@FXML
	private Text lSexo;

	private Comentario comentario;

	@FXML
	private ImageView imagemPerfil;

	public void initialize() {
		SimuladorDB.getLogin(TelaLoginController.getDono());
		tNome.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getNome());
		lSexo.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getSexo());
		tEstadoCivil.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getEstadoCivil());
		tDataNascimento.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getDataNascimento().toString());
		countAnjo.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getQtdAnjo().toString());
		countDemonio.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getQtdDemonio().toString());
		countNeutro.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getQtdNeutro().toString());
		imagensCombobox();
		iniciarImagensPerfil();
		cData.setCellValueFactory(new PropertyValueFactory<>("data"));
		cComentario.setCellValueFactory(new PropertyValueFactory<>("comentario"));
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
		tblComentarios.setItems(FXCollections
				.observableArrayList(SimuladorDB.getLogin(TelaLoginController.getDono()).getComentarios()));

	}

	/**
	 * é o botao da tela de visitante para voltar pro perfil do dono
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
	void onAvaliar(ActionEvent event) {
		comentario = tblComentarios.getSelectionModel().getSelectedItem();
		if (comentario.getClassificacao() != null) {
			mensagens.comentarioAvaliado();
			cbxAvaliacao.getSelectionModel().clearSelection();
			// já classificou...
			return;
		}

		switch ((cbxAvaliacao.getSelectionModel().getSelectedIndex())) {
		case 0:
			comentario.getUsuarioEnvia().setQtdAnjo(comentario.getUsuarioEnvia().getQtdAnjo() + 1);
			comentario.setClassificacao(0);
			break;
		case 1:
			comentario.getUsuarioEnvia().setQtdDemonio(comentario.getUsuarioEnvia().getQtdDemonio() + 1);
			comentario.setClassificacao(1);
			break;
		case 2:
			comentario.getUsuarioEnvia().setQtdNeutro(comentario.getUsuarioEnvia().getQtdNeutro() + 1);
			comentario.setClassificacao(2);
			break;
		default:
			break;
		}

		SimuladorDB.atualizarUsuarios();
		cbxAvaliacao.getSelectionModel().clearSelection();
		tblComentarios.refresh();
	}

	/**
	 * é o botao de pesquisa dessa tela TelaPerfilDonoController
	 * 
	 * @param event
	 */
	@FXML
	void onPesquisar(final ActionEvent event) {
		ComboBox<Usuario> cmb = new ComboBox<>();

		// cria uma lista
		ArrayList<Usuario> usuarioSemOdono = new ArrayList<>(SimuladorDB.getUsuarios());
		// ele remove o cara que esta logado e deixa todos os outros
		usuarioSemOdono.removeIf(u -> u.getLogin().equals(TelaLoginController.getLogado().getLogin()));

		// no combobox vai conter os usuarios que tao no simuladorBD
		cmb.getItems().addAll(usuarioSemOdono);

		// ele da um new pegando daquela classe que faz a pesquisa letra por
		// letra,
		// sem essa linha a pesquisa de letras não funciona
		new PesquisaCombobox<Usuario>(cmb);
		
		Stage palco = new Stage();
		// agora o pesquisar abre só uma vez
		palco.initModality(Modality.APPLICATION_MODAL);

		VBox raiz = new VBox(10); // 1
		raiz.setAlignment(Pos.CENTER); // 2
		Label campoTexto = new Label("Digite o nome do usuário que deseja buscar:"); // 5
		raiz.getChildren().addAll(campoTexto, cmb);
		Scene cena = new Scene(raiz, 350, 200);
		palco.setTitle("Pesquisa de Perfil");
		palco.setScene(cena);
		palco.show();

		// com esse comando ele pega o click do mouse no combobox e executa
		// as
		// ações abaixo
		cmb.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
			// ele consome o evento (pesquisar)
			event.consume();

			// pega o usuario do combobox e salva lá na outra classe
			TelaPerfilVisitanteController.setVisitado(cmb.getValue());
			palco.close();

			// carrega outra tela
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("telaPerfilVisitante.fxml"));

			try {
				AnchorPane loginView = (AnchorPane) loader.load();
				Main.root.setCenter(loginView);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

		);
	}
	
	public void iniciarImagensPerfil(){

		if (TelaLoginController.getLogado().getSexo().equals("Sexo: feminino")) {
			InputStream input = TelaPerfilDonoController.class.getResourceAsStream("Feminino.jpg");
			Image imagem = new Image(input);
			imagemPerfil.setFitHeight(95); 
			imagemPerfil.setLayoutX(25);
			imagemPerfil.setImage(imagem);

		} else {
			InputStream input = TelaPerfilDonoController.class.getResourceAsStream("Masculino.jpg");
			Image imagem = new Image(input);
			imagemPerfil.setFitHeight(95);
			imagemPerfil.setImage(imagem);
		}
	}
	
	public void imagensCombobox(){
		for (String img : Arrays.asList("image1.png", "image2.png", "image3.png")) {
			// encontra o lugar onde esta a imagem
			InputStream input = TelaPerfilDonoController.class.getResourceAsStream(img);
			// coloca a imagem em um image
			Image imagem = new Image(input);
			// coloca o image no imageView
			ImageView icone = new ImageView();
			icone.setImage(imagem);
			// coloca o image view no combobox
			cbxAvaliacao.getItems().addAll(icone);
		}
	}
	
}
