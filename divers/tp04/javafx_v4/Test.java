package tp04.javafx_v4;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Test extends Application {

    public static void main(String[] args) {
        Application.launch(Test.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.LIGHTBLUE);
        primaryStage.setScene(scene);

        Circle circle = new Circle();
        circle.setCenterX(400);
        circle.setCenterY(300);
        circle.setRadius(100);
        circle.setFill(Color.IVORY);
        circle.setStroke(Color.FUCHSIA);
        circle.setStrokeWidth(20);

        root.getChildren().add(circle);

        primaryStage.show();
    }
}
