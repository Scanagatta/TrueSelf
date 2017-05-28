
package application;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import TrueSelf.modelo.SimuladorDB;
import TrueSelf.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TelaPerfilDonoController {
	@FXML
	private Pane pane;

	@FXML
	private Text tNome;

	@FXML
	private Text tEstadoCivil;

	@FXML
	private TableView<String> lvComentarios;

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
	private ComboBox<ImageView> cbxAvaliacao;

	public void initialize() {
		SimuladorDB.getLogin(TelaLoginController.getDono());
		tNome.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getNome());
		tEstadoCivil.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getEstadoCivil());
		tDataNascimento.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getDataNascimento().toString());
		countAnjo.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getQtdAnjo().toString());
		countDemonio.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getQtdDemonio().toString());
		countNeutro.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getQtdNeutro().toString());
		for(String img:  Arrays.asList("image.png","image2.jpg","image3.jpg")){
			  //encontra o lugar onde esta a imagem
			  InputStream input = TelaPerfilDonoController.class.getResourceAsStream(img);
			  //coloca a imagem em um image
			  Image imagem = new Image(input);
			  //coloca o image no imageView
			  ImageView icone = new ImageView();
			  icone.setImage(imagem);
			  //coloca o image view no combobox
			  cbxAvaliacao.getItems().addAll(icone);
		  }
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
			TelaPrincipal.root.setCenter(principal1View);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * é o botao de pesquisa dessa tela TelaPerfilDonoController
	 * 
	 * @param event
	 */
	@FXML
	void onPesquisar(final ActionEvent event) {
		// cria stage é uma janelinha
		Stage stage = new Stage();

		// cria um combobox que vai ser colocado dentro do stage
		ComboBox<Usuario> cmb = new ComboBox<>();
		cmb.setTooltip(new Tooltip());

		// no combobox vai conter os usuarios que tao no simuladorBD
		cmb.getItems().addAll(SimuladorDB.getUsuarios());
		stage.setScene(new Scene(new StackPane(cmb)));

		// mostra o stage, como seu titulo, e tamanho
		stage.show();
		stage.setTitle("Digite o nome do usuário desejado");
		stage.setWidth(400);
		stage.setHeight(100);

		// ele da um new pegando daquela classe que faz a pesquisa letra por
		// letra,
		// sem essa linha a pesquisa de letras não funciona
		new PesquisaCombobox<Usuario>(cmb);

		// com esse comando ele pega o click do mouse no combobox e executa as
		// ações abaixo
		cmb.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
			// ele consome o evento (pesquisar)
			event.consume();

			// pega o usuario do combobox e salva lá na outra classe
			TelaPerfilVisitanteController.setUsuario(cmb.getValue());

			// fecha o stage (telinha)
			stage.close();

			// carrega outra tela
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("telaPerfilVisitante.fxml"));
			try {
				AnchorPane loginView = (AnchorPane) loader.load();
				TelaPrincipal.root.setCenter(loginView);

			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

		);

		// stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		// @Override
		// public void handle(WindowEvent t) {
		// t.consume();
		//
		// TelaPerfilVisitanteController.setUsuario(cmb.getValue());
		//
		// FXMLLoader loader = new FXMLLoader();
		// loader.setLocation(getClass().getResource("telaPerfilVisitante.fxml"));
		// try {
		// AnchorPane loginView = (AnchorPane) loader.load();
		// TelaPrincipal.root.setCenter(loginView);
		//
		// } catch (IOException e1) {
		// e1.printStackTrace();
		// }
		//
		// stage1.close();
		//
		// }
		// });

	}

}
