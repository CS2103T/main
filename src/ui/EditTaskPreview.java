//@@author A0121442X
package ui;

import application.Constants;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class EditTaskPreview extends StackPane {

	private GridPane taskPreviewLayout;

	GridPane editTitleLayout;
	GridPane editStartTimeLayout;
	GridPane editEndTimeLayout;
	GridPane editDurationLayout;

	Label header;
	Label oldTitleLabel;
	Label oldStartTimeLabel;
	Label oldEndTimeLabel;
	Label oldRecurringLabel;

	Label oldTitle;
	Label oldStartTime;
	Label oldEndTime;
	Label oldRecurring;

	Label newTitleLabel;
	Label newStartTimeLabel;
	Label newEndTimeLabel;
	Label newRecurringLabel;

	StackPane newDetailsLayout;
	StackPane newField;

	Label newTitleField;
	Label newStartTimeField;
	Label newEndTimeField;
	Label newRecurringField;

	public EditTaskPreview() {

		header = new Label("Edit task");
		header.setId("taskPreviewHeader");

		oldTitleLabel = new Label("Title:");
		oldTitleLabel.setId("taskPreviewLabel");

		oldStartTimeLabel = new Label("Current Start Time:");
		oldStartTimeLabel.setId("taskPreviewLabel");

		oldEndTimeLabel = new Label("Current End Time:");
		oldEndTimeLabel.setId("taskPreviewLabel");

		oldRecurringLabel = new Label("Currently Repeating:");
		oldRecurringLabel.setId("taskPreviewLabel");

		oldTitle = new Label(Constants.COMMAND_INVALID);
		oldTitle.setId("taskPreviewDetails");

		oldStartTime = new Label();
		oldStartTime.setId("taskPreviewDetails");

		oldEndTime = new Label();
		oldEndTime.setId("taskPreviewDetails");

		oldRecurring = new Label();
		oldRecurring.setId("taskPreviewDetails");

		newTitleLabel = new Label("New Title: ");
		newTitleLabel.setId("taskPreviewLabel");

		newStartTimeLabel = new Label("New Start Time: ");
		newStartTimeLabel.setId("taskPreviewLabel");

		newEndTimeLabel = new Label("New End Time: ");
		newEndTimeLabel.setId("taskPreviewLabel");

		newRecurringLabel = new Label("New Repeating: ");
		newRecurringLabel.setId("taskPreviewLabel");

		newTitleField = new Label();
		newTitleField.setId("taskPreviewDetails");

		newStartTimeField = new Label();
		newStartTimeField.setId("taskPreviewDetails");

		newEndTimeField = new Label();
		newEndTimeField.setId("taskPreviewDetails");

		newRecurringField = new Label();
		newRecurringField.setId("taskPreviewDetails");

		ColumnConstraints columnConstraint = new ColumnConstraints(150);
		ColumnConstraints columnConstraint1 = new ColumnConstraints(400);

		editTitleLayout = new GridPane();
		editTitleLayout.add(newTitleLabel, 0, 0);
		editTitleLayout.add(newTitleField, 1, 0);
		// editTitleLayout.setVisible(false);
		editTitleLayout.getColumnConstraints().addAll(columnConstraint, columnConstraint1);

		editStartTimeLayout = new GridPane();
		editStartTimeLayout.add(oldStartTimeLabel, 0, 0);
		editStartTimeLayout.add(oldStartTime, 1, 0);
		editStartTimeLayout.add(newStartTimeLabel, 0, 1);
		editStartTimeLayout.add(newStartTimeField, 1, 1);
		// editStartTimeLayout.setVisible(false);
		editStartTimeLayout.getColumnConstraints().add(columnConstraint);

		editEndTimeLayout = new GridPane();
		editEndTimeLayout.add(oldEndTimeLabel, 0, 0);
		editEndTimeLayout.add(oldEndTime, 1, 0);
		editEndTimeLayout.add(newEndTimeLabel, 0, 1);
		editEndTimeLayout.add(newEndTimeField, 1, 1);
		// editEndTimeLayout.setVisible(false);
		editEndTimeLayout.getColumnConstraints().addAll(columnConstraint, columnConstraint);

		editDurationLayout = new GridPane();
		editDurationLayout.add(oldStartTimeLabel, 0, 0);
		editDurationLayout.add(oldStartTime, 1, 0);
		editDurationLayout.add(newStartTimeLabel, 2, 0);
		editDurationLayout.add(newStartTimeField, 3, 0);
		editDurationLayout.add(oldEndTimeLabel, 0, 1);
		editDurationLayout.add(oldEndTime, 1, 1);
		editDurationLayout.add(newEndTimeLabel, 2, 1);
		editDurationLayout.add(newEndTimeField, 3, 1);
		// editDurationLayout.setVisible(false);
		editDurationLayout.getColumnConstraints().addAll(columnConstraint, columnConstraint, columnConstraint,
				columnConstraint);

		newDetailsLayout = new StackPane();
		// newDetailsLayout = new StackPane(editTitleLayout,
		// editStartTimeLayout, editEndTimeLayout, editDurationLayout);

		taskPreviewLayout = new GridPane();
		GridPane.setConstraints(header, 0, 0, 2, 1);
		GridPane.setConstraints(oldTitleLabel, 0, 1);
		GridPane.setConstraints(oldTitle, 1, 1);
		GridPane.setConstraints(newDetailsLayout, 0, 2);

		taskPreviewLayout.setPrefSize(700, 50);
		taskPreviewLayout.setPadding(new Insets(20, 20, 20, 20));
		taskPreviewLayout.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius:20");

		taskPreviewLayout.getColumnConstraints().add(columnConstraint);
		taskPreviewLayout.getChildren().addAll(header, oldTitleLabel, oldTitle, newDetailsLayout);

		getChildren().addAll(taskPreviewLayout);
		setPrefSize(700, 50);
		setStyle("-fx-background-color: rgba(255,255,255,0.5)");
		setPadding(new Insets(200, 50, 100, 50));
	}

	public void clearAllDetails() {
		newTitleField.setText(Constants.EMPTY_STRING);
		newRecurringField.setText(Constants.EMPTY_STRING);
	}

	public void detailsToShow(String field) {
		newDetailsLayout.getChildren().clear();
		if (field.equalsIgnoreCase("title")) {
			newDetailsLayout.getChildren().add(editTitleLayout);
		} else if (field.equalsIgnoreCase("start")) {
			newDetailsLayout.getChildren().add(editStartTimeLayout);
		} else if (field.equalsIgnoreCase("end")) {
			newDetailsLayout.getChildren().add(editEndTimeLayout);
		} else if (field.equalsIgnoreCase("time")) {
			newDetailsLayout.getChildren().add(editDurationLayout);
		}
		/*
		 * if (field.equalsIgnoreCase("title")) {
		 * newDetailsLayout.getChildren().get(0).setVisible(true);
		 * newDetailsLayout.getChildren().get(1).setVisible(false);
		 * newDetailsLayout.getChildren().get(2).setVisible(false);
		 * newDetailsLayout.getChildren().get(3).setVisible(false); } else if
		 * (field.equalsIgnoreCase("start")) {
		 * newDetailsLayout.getChildren().get(0).setVisible(false);
		 * newDetailsLayout.getChildren().get(1).setVisible(true);
		 * newDetailsLayout.getChildren().get(2).setVisible(false);
		 * newDetailsLayout.getChildren().get(3).setVisible(false); } else if
		 * (field.trim().equalsIgnoreCase("end")) {
		 * newDetailsLayout.getChildren().get(0).setVisible(false);
		 * newDetailsLayout.getChildren().get(1).setVisible(false);
		 * newDetailsLayout.getChildren().get(2).setVisible(true);
		 * newDetailsLayout.getChildren().get(3).setVisible(false);
		 * System.out.println("showing end"); } else if
		 * (field.equalsIgnoreCase("time")) {
		 * newDetailsLayout.getChildren().get(0).setVisible(false);
		 * newDetailsLayout.getChildren().get(1).setVisible(false);
		 * newDetailsLayout.getChildren().get(2).setVisible(false);
		 * newDetailsLayout.getChildren().get(3).setVisible(true);
		 * System.out.println("showing time"); }
		 */
	}
}