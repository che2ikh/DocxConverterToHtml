package org.example.View;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;

public class CenterPanel extends VBox {

    private ProgressIndicator progressIndicator;
    private final Label message;
    private final TextArea textArea;
    private final StackPane stackPane;

    public CenterPanel() {
        super(10); // spacing

        // Message label with icon
        message = new Label("No File Chosen");
        FontIcon messageIcon = new FontIcon(FontAwesomeSolid.FILE);
        messageIcon.setIconSize(16);
        messageIcon.getStyleClass().add("label-icon");
        message.setGraphic(messageIcon);
        message.setGraphicTextGap(10); // Space between icon and text
        
                textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setEditable(false);
        textArea.getStyleClass().add("converter-text-area");

        progressIndicator = new ProgressIndicator();
        progressIndicator.setVisible(false); // hidden by default

        stackPane = new StackPane(textArea, progressIndicator);

        this.getStyleClass().add("center-panel");
        message.getStyleClass().add("message-label");

        this.getChildren().addAll(message, stackPane);
    }

    // Method to update message with different icons
    public void updateMessage(String text, boolean isSuccess) {
        FontIcon icon = new FontIcon(isSuccess ? FontAwesomeSolid.CHECK_CIRCLE : FontAwesomeSolid.EXCLAMATION_TRIANGLE);
        icon.setIconSize(16);
        icon.getStyleClass().add("label-icon");
        message.setGraphic(icon);
        message.setText(text);
    }

    // Expose components if needed
    public Label getMessageLabel() { return message; }
    public TextArea getTextArea() { return textArea; }
    public ProgressIndicator getProgressIndicator() { return progressIndicator; }
}