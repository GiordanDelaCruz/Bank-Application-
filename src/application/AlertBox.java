package application;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

	public static void display(String title, String message) {
		
		Stage window = new Stage();
		
		// Makes this window the only window the user can click on
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(430);
		window.setMinHeight(200);
		
		// Text and Button that will be displayed
		Label label1 = new Label();
		label1.setText(message);
		Button closeButton = new Button("Close window");
		closeButton.setOnAction(e -> window.close());
		
		// Layout of Scene
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label1, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		// Setting up the window
		Scene scene1 = new Scene(layout);
		window.setScene(scene1);
		window.showAndWait();	
		
	}
	
}
