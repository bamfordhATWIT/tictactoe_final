package application;

import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.beans.binding.BooleanExpression;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

public class Main extends Application implements EventHandler<ActionEvent> {
	final int WIDTH = 600;
	final int HEIGHT = 600;

	@Override
	public void start(Stage primaryStage) {
		try {
			
			GamePiece img = new GamePiece(WIDTH / 3); // instantiates gamepiece, width/3 is the size
			LineGrid lines = new LineGrid(WIDTH, HEIGHT); // instantiate lines -> width and height are for line size

			Group root = new Group();
			
			root.getChildren().add(img.placeImgs()); //images are added to the group
			
			for (int i = 0; i < lines.grid().size(); i++) {
				root.getChildren().add(lines.grid().get(i)); //each line is added to the group
			}

			

			Scene scene = new Scene(root, WIDTH, HEIGHT);

			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Tic Tac Toe");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void handle(ActionEvent event) {
		System.out.println("You clicked me.");
	}

}
