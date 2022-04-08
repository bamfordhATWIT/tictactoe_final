package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class label extends Application {
 
    // launch the application
    public void start(Stage s)
    {
        // set title for the stage
        s.setTitle("creating label");
 
        // create a label
        Label b = new Label("This is a label");
 
        // create a Stack pane
        StackPane r = new StackPane();
 
        // add password field
        r.getChildren().add(b);
 
        // create a scene
        Scene sc = new Scene(r, 200, 200);
 
        // set the scene
        s.setScene(sc);
 
        s.show();
    }
 
    public static void main(String args[])
    {
        // launch the application
        launch(args);
    }
}