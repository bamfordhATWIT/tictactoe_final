package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

public class Main extends Application implements EventHandler<ActionEvent> {
	@Override
	public void start(Stage primaryStage) {
		try {
			// LineGrid lGrid = new LineGrid(0,0,0,100,10);
			StackPane pane = new StackPane();
			Scene scene = new Scene(pane, 400, 400);

			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			/*
			 * Button button = new Button(); button.setOnAction(this);
			 * button.setText("Click me"); pane.getChildren().add(button);
			 */

			float startX, startY;

			Line line1 = new Line(1, 0, 100, pane.getHeight());
			//line1.setS
			//line1.setTranslateX(100);
	        //line1.setTranslateY(100);
			/*Line line2 = new Line();
			Line line3 = new Line();
			Line line4 = new Line();*/
			
			pane.getChildren().add(line1);

			/*line2.setStartX(2.0 * pane.getWidth() / 3.0);
			line2.setStartY(0);
			line2.setEndX(2.0 * pane.getWidth() / 3.0);
			line2.setEndY(pane.getHeight());*/
			//pane.getChildren().add(line2);

			/*
			 * line3.setStartX(0); line3.setStartY(0); line3.setEndX(0); line3.setEndY(100);
			 * 
			 * line4.setStartX(0); line4.setStartY(0); line4.setEndX(0); line4.setEndY(100);
			 */

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
