package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class TelaPrincipal extends Application {

public static BorderPane root;

@Override
public void start(Stage primaryStage) throws Exception {
	try {
		root = (BorderPane) FXMLLoader.load(getClass()
				.getResource("telaPrincipal.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);

		
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("telaPrimeira.fxml"));
    	
    		AnchorPane agenciaView = (AnchorPane) loader.load();
    		root.setCenter(agenciaView);
    		
 
 
		
		primaryStage.show();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public static void main(String[] args) {
	launch(args);
}

public static BorderPane getRoot(){
	return root;
}


}
