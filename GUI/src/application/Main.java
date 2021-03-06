package application;
	
import automationFramework.SeleniumCommands;
import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;


public class Main extends Application {
	protected SeleniumCommands selenium = SeleniumCommands.getInstance();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));	
			//Parent root = FXMLLoader.load(getClass().getResource("PassengerScene.fxml"));
			Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
			Scene scene = new Scene(root, primScreenBounds.getWidth(), primScreenBounds.getHeight() - 50);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Raport�ri Online");
			primaryStage.setScene(scene);
			primaryStage.show();
			//Activate Selenium and Login
			selenium.login();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
