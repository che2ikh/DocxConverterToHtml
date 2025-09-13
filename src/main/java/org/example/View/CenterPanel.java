package org.example.View;


import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class CenterPanel extends VBox {

    // In CenterPanel.java
    private ProgressIndicator progressIndicator;


    private final Label message;
    private final TextArea textArea;
    private final StackPane stackPane;


    public CenterPanel() {
        super(10); // spacing

        message = new Label("No File Chosen");
        textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setEditable(false);
        progressIndicator = new ProgressIndicator();
        progressIndicator.setVisible(false); // hidden by default

        stackPane = new StackPane(textArea, progressIndicator);

        this.setStyle("-fx-padding: 10; -fx-background-color: rgba(255,255,255,0.05); -fx-border-radius: 12; -fx-background-radius: 12;");

        textArea.setStyle("-fx-background-color: rgba(255,255,255,0.9); -fx-text-fill: #333; -fx-font-family: Consolas, monospace; -fx-font-size: 13px; -fx-background-radius: 12;");

        this.getChildren().addAll(message, stackPane);
    }

    // Expose components if needed
    public Label getMessageLabel() { return message; }
    public TextArea getTextArea() { return textArea; }
    public ProgressIndicator getProgressIndicator() { return progressIndicator; }
}

