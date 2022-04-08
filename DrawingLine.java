package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DrawingLine extends Application {
	@Override
	public void start(Stage stage) {
		int w = 600;
		int h = 600;
		
		//vertical lines, startX, startY, endX, endY
		Line line1 = new Line(w/3, 0, w/3, h);
		Line line2 = new Line(2*w/3, 0, 2*w/3, h);
		
		//horizontal lines
		Line line3 = new Line(0, h/3, w, h/3);
		Line line4 = new Line(0, 2*h/3, w, 2*h/3);

		// Creating a Group
		Group root = new Group(line1, line2, line3, line4);

		// Creating a Scene
		Scene scene = new Scene(root, w, h);

		// Setting title to the scene
		stage.setTitle("Sample application");

		// Adding the scene to the stage
		stage.setScene(scene);

		// Displaying the contents of a scene
		stage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}