package application;

import java.io.IOException;

import TrueSelf.modelo.SimuladorDB;
import TrueSelf.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
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

	
	private static String visitado;
	
	public static String getVisitado() {
		return visitado;
	}

	public void setVisitado(String dono) {
		this.visitado = visitado;
	}
	
	private static Usuario usuario;
	
	
	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		TelaPerfilVisitanteController.usuario = usuario;
	}

	public void initialize() {
		
		
		tnome.setText(getUsuario().getNome());
		tEstadoCivil.setText(getUsuario().getEstadoCivil());
		tDataNascimento.setText(getUsuario().getDataNascimento().toString());
		countAnjo.setText(getUsuario().getQtdAnjo().toString());
		countDemonio.setText(getUsuario().getQtdDemonio().toString());
		countNeutro.setText(getUsuario().getQtdNeutro().toString());
		}
	
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
