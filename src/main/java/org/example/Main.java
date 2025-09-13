package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.Controller.MainController;
import org.example.View.CenterPanel;
import org.example.View.MenuBarPanel;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        CenterPanel centerPanel = new CenterPanel();
        MainController mainController=new MainController(stage,centerPanel);
        MenuBarPanel menuBar = new MenuBarPanel(mainController);

        VBox root = new VBox(15);
        root.getChildren().addAll(menuBar, centerPanel);

        Scene scene = new Scene(root, 700, 500);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Docx to HTML converter");
        stage.show();
    }
}
