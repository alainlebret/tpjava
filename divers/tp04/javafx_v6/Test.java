package tp04.javafx_v6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Test extends Application {

    private final TableView table = new TableView();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Exemple d'utilisation d'un tableview");
        stage.setWidth(500);
        stage.setHeight(500);

        final Label label = new Label("Films");
        label.setFont(new Font("Segoeui", 20));

        table.setEditable(true);

        TableColumn indexCol = new TableColumn("Index");
        TableColumn directorCol = new TableColumn("Réalisateur");
        TableColumn filmNameCol = new TableColumn("Titre");

        table.getColumns().addAll(indexCol, directorCol, filmNameCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
}