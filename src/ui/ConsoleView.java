/**
 * This class:
 * Creates and instantiates the individual components for
 * the console view
 * The console view is where the user inputs commands
 * The console textfield extends an autocomplete feature
 */

package ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class ConsoleView extends Pane{

	Pane consolePane;

	Label applicationName;
	Label dateLabel;
	Label clock;
	ListView<ListItem> listView;
	AutoCompleteTextField inputConsole;
	Label status;

	public ConsoleView() {

		consolePane = new Pane();

		applicationName = new Label();
		applicationName.setText("TextBuddyAwesome");
		applicationName.setContentDisplay(ContentDisplay.CENTER);
		applicationName.setPrefHeight(25);
		applicationName.setPrefWidth(600);
		applicationName.setPadding(new Insets(0 ,0 , 0, 20));
		applicationName.setStyle("-fx-background-color: orange; -fx-background-radius: 30 30 0 0;");
		applicationName.setFont(Font.font("Georgia", 20));

		dateLabel = new Label();
		dateLabel.setStyle("-fx-background-color: rgba(255,255,255, 0.8); ");
		dateLabel.setFont(new Font("Arial", 30));
		dateLabel.setPrefWidth(300);
		dateLabel.setPadding(new Insets(0,0,0,20));


		clock = new Label();
		clock.setStyle("-fx-background-color: rgba(255,255,255, 0.8); ");
		clock.setFont(new Font("Arial", 30));
		clock.setTextAlignment(TextAlignment.CENTER);
		clock.setPrefWidth(300);
		clock.setPadding(new Insets(0,0,0,90));

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Timeline timeline = new Timeline();
		EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				dateLabel.setText(Calendar.getInstance().getTime().toString().split(" ")[0].trim() + ", " + dateFormat.format(Calendar.getInstance().getTime()));
				clock.setText(timeFormat.format(Calendar.getInstance().getTime()));
			}
		};
		timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), onFinished));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

		listView = new ListView<ListItem>();
		listView.setPrefHeight(470);
		listView.setPrefWidth(600);
		listView.setStyle("-fx-background-color: transparent;");

		inputConsole = new AutoCompleteTextField();
		inputConsole.setEditable(true);
		inputConsole.setPrefHeight(25);
		inputConsole.setPrefWidth(600);
		inputConsole.setStyle("-fx-background-color: lightgray;");
		inputConsole.setFocusTraversable(true);

		status = new Label();
		status.setPrefWidth(600);
		status.setPrefHeight(25);
		status.setPadding(new Insets(0,0,0, 80));
		status.setStyle("-fx-background-color: white; -fx-background-radius: 0 0 30 30;");

		HBox dateTime = new HBox();
		dateTime.getChildren().addAll(dateLabel, clock);
		VBox consoleLayout = new VBox();
		consoleLayout.setSpacing(1);
		consoleLayout.getChildren().addAll(applicationName, dateTime, listView, inputConsole, status);
		consolePane.getChildren().add(consoleLayout);
	}
}