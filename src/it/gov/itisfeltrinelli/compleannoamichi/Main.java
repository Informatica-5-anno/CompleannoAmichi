package it.gov.itisfeltrinelli.compleannoamichi;
	
import it.gov.itisfeltrinelli.amichi.AmichiList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AmichiView.fxml"));
			FXMLLoader aLoader = new FXMLLoader(getClass().getResource("AmichiView.fxml"));
			BorderPane root = aLoader.load();
			// Aggiungere la seguente
			AmichiController aController=aLoader.getController();
			//Scene scene = new Scene(root,400,400);
			Scene scene = new Scene(root);
			// Creiamo il Model
			AmichiList aList=new AmichiList();
			// Passiamo il Model al controller
			aController.setModel(aList);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
