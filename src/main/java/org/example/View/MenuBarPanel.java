package org.example.View;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import org.example.Controller.MainController;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;

public class MenuBarPanel extends HBox {

    private final Button chooseFileButton;
    private final Button saveButton;
    private final Button copyToClipboardButton;

    public MenuBarPanel(MainController controller) {
        super(10); // spacing
        this.getStyleClass().add("menu-bar-panel");

        // Choose File Button with Icon
        chooseFileButton = new Button("Choose and Convert");
        FontIcon fileIcon = new FontIcon(FontAwesomeSolid.FILE_ALT);
        fileIcon.setIconSize(16);
        fileIcon.getStyleClass().add("button-icon");
        chooseFileButton.setGraphic(fileIcon);
        chooseFileButton.setOnAction(e->controller.openFileChooser());

        // Save Button with Icon
        saveButton = new Button("Save");
        FontIcon saveIcon = new FontIcon(FontAwesomeSolid.SAVE);
        saveIcon.setIconSize(16);
        saveIcon.getStyleClass().add("button-icon");
        saveButton.setGraphic(saveIcon);
        saveButton.setOnAction(e->controller.saveFile());

        // Copy Button with Icon
        copyToClipboardButton = new Button("Copy To Clipboard");
        FontIcon copyIcon = new FontIcon(FontAwesomeSolid.COPY);
        copyIcon.setIconSize(16);
        copyIcon.getStyleClass().add("button-icon");
        copyToClipboardButton.setGraphic(copyIcon);
        copyToClipboardButton.setOnAction(e->controller.copyToClipboard());

        this.getChildren().addAll(chooseFileButton, saveButton, copyToClipboardButton);
    }

    // Expose buttons if you want to add event handlers from Main
    public Button getChooseFileButton() { return chooseFileButton; }
    public Button getSaveButton() { return saveButton; }
    public Button getCopyToClipboardButton() { return copyToClipboardButton; }
}