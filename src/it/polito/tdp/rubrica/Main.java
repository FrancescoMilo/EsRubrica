package it.polito.tdp.rubrica;
	
import it.polito.tdp.rubrica.model.RubricaModel;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Rubrica.fxml"));
			BorderPane root = (BorderPane)loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			RubricaController controller = loader.getController();
			
			// creo il modello
			RubricaModel model = new RubricaModel();
			// dovrei fare controller.setModel(model) ma non ho il riferimento a controller 
			// che viene creato nel load
			// ho spezzato la prima istruzione di sopra
			// BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("rubrica.fxml"));
			// l'ho divisa in due istruzioni
			controller.setModel(model);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
