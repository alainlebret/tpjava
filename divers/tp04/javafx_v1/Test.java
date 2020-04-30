package tp04.javafx_v1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Test extends Application {

    public static void main(String[] args) {
        Application.launch(Test.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Application no 1");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.IVORY);
        Button buttonHello = new Button();
        buttonHello.setLayoutX(390);
        buttonHello.setLayoutY(295);
        buttonHello.setText("Afficher");
        buttonHello.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Bonjour");
            }
        });
        root.getChildren().add(buttonHello);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
