package org.example.View;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import org.example.Controller.MainController;

public class MenuBarPanel extends HBox {

    private final Button chooseFileButton;
    private final Button saveButton;
    private final Button copyToClipboardButton;

    public MenuBarPanel(MainController controller) {
        super(10); // spacing
        this.setStyle("-fx-padding: 10; -fx-alignment: center; -fx-background-color: rgba(255,255,255,0.1);");

        chooseFileButton = new Button("Choose and Convert");
        chooseFileButton.setOnAction(e->controller.openFileChooser());

        saveButton = new Button("Save");
        saveButton.setOnAction(e->controller.saveFile());

        copyToClipboardButton = new Button("Copy To Clipboard");
        copyToClipboardButton.setOnAction(e->controller.copyToClipboard());

        this.getChildren().addAll(chooseFileButton, saveButton, copyToClipboardButton);
    }

    // Expose buttons if you want to add event handlers from Main
    public Button getChooseFileButton() { return chooseFileButton; }
    public Button getSaveButton() { return saveButton; }
    public Button getCopyToClipboardButton() { return copyToClipboardButton; }
}
