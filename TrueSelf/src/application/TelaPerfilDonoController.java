
package application;

import java.io.IOException;

import TrueSelf.modelo.SimuladorDB;
import TrueSelf.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class TelaPerfilDonoController {
	@FXML
	private Pane cbxAvaliacao;

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

	public void initialize() {
		SimuladorDB.getLogin(TelaLoginController.getDono());
		tNome.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getNome());
		tEstadoCivil.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getEstadoCivil());
		tDataNascimento.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getDataNascimento().toString());
		countAnjo.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getQtdAnjo().toString());
		countDemonio.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getQtdDemonio().toString());
		countNeutro.setText(SimuladorDB.getLogin(TelaLoginController.getDono()).getQtdNeutro().toString());
	}

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
	void onPesquisar(ActionEvent event) {
		Stage stage = new Stage();
		
		ComboBox<Usuario> cmb = new ComboBox<>();
		cmb.setTooltip(new Tooltip());
		cmb.getItems().addAll(SimuladorDB.getUsuarios());
		stage.setScene(new Scene(new StackPane(cmb)));
		stage.show();
		stage.setTitle("Pesquisa de usuário");
		stage.setWidth(450);
		stage.setHeight(100);
		
		Stage stage1 = new Stage();
		Label label = new Label();
		stage1.setScene(new Scene(new StackPane(label)));
		label.setText("Selecione um perfil e clique no [x]");
		stage1.show();
		
		new PesquisaCombobox<Usuario>(cmb);
		
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent t) {
				t.consume();

				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("telaPerfilVisitante.fxml"));
				try {
					AnchorPane loginView = (AnchorPane) loader.load();
					TelaPrincipal.root.setCenter(loginView);

				} catch (IOException e1) {
					e1.printStackTrace();
				}

				stage.close();
				stage1.close();

			}
		});

	}

}
