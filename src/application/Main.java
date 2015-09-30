package application;

import javafx.application.Application;
import javafx.stage.Stage;
import storage.Storage;
import ui.GUIService;

public class Main extends Application{

	@Override
	public void start(Stage stage) {
		GUIService myGui = new GUIService(stage);
		myGui.showStage();	// Loads the GUI window
		myGui.showTray();	// Loads the System Tray instance
	}

	public static void main(String[] args) {
		Storage.createFile("database.txt");
		launch(args);
	}
}