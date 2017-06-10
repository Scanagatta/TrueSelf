package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Mensagens {
	
	
	public void erroLogin(){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro");
		alert.setHeaderText("");
		alert.setContentText("Preencha os campos");
		alert.showAndWait();
	}

}
