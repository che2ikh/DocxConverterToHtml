package org.example.Controller;

import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.View.CenterPanel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainController {
    Stage stage;
    CenterPanel centerPanel;
    File docxFile;
    public MainController(Stage stage, CenterPanel centerPanel){
        this.stage=stage;
        this.centerPanel=centerPanel;
    }

    public void openFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("DOCX files", "*.docx"));
        docxFile = fileChooser.showOpenDialog(stage);

        if (docxFile != null) {
            // show spinner
            ProgressIndicator progress = centerPanel.getProgressIndicator();
            progress.setVisible(true);

            Task<String> task = new Task<>() {
                @Override
                protected String call() throws Exception {
                    return DocxConverter.convertDocxToHtml(docxFile);
                }
            };

            task.setOnSucceeded(event -> {
                String finalHtml = task.getValue();
                centerPanel.getMessageLabel().setText("The chosen file: " + docxFile.getName());
                centerPanel.getTextArea().setText(finalHtml);

                progress.setVisible(false); // hide spinner
            });

            task.setOnFailed(event -> {
                progress.setVisible(false);
                Throwable ex = task.getException();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Conversion Error");
                alert.setHeaderText("Failed to convert DOCX");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            });

            Thread thread = new Thread(task);
            thread.setDaemon(true);
            thread.start();
        }
    }


    public void copyToClipboard(){
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(centerPanel.getTextArea().getText()); // copy the text
            clipboard.setContent(content);
    }

    public void saveFile() {
        if (docxFile != null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Text File");
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Text Files", "*.html")
            );
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(centerPanel.getTextArea().getText());
                } catch (IOException ex) {
                    ex.printStackTrace(); // better: show alert to user
                }
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("No file was selected!");
            alert.setContentText("Please choose a file and convert it to save it");
            alert.showAndWait();
        }

    }
}
