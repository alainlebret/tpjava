package tp04.javafx_v5;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
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

        Rectangle rectangle = new Rectangle();
        rectangle.setX(110);
        rectangle.setY(110);
        rectangle.setWidth(200);
        rectangle.setHeight(150);
        rectangle.setFill(Color.FIREBRICK);
        rectangle.setStroke(Color.DARKRED);
        rectangle.setStrokeWidth(5);
        rectangle.setArcHeight(10);
        rectangle.setArcWidth(10);

        root.getChildren().add(circle);
        root.getChildren().add(rectangle);

        primaryStage.show();
    }
}
