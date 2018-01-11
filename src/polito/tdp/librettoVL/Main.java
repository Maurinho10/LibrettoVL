package polito.tdp.librettoVL;
	
import javafx.application.Application;
import javafx.stage.Stage;
import polito.tdp.librettoVL.model.LibrettoModel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LibrettoVL.fxml"));
			BorderPane root = (BorderPane)loader.load();
			
			LibrettoVlController controller = loader.getController();
			LibrettoModel model = new LibrettoModel();
			controller.setLibrettoModel(model);
			
			Scene scene = new Scene(root);
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
