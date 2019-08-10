package ru.rashgild.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import ru.rashgild.util.SpringLoader;

public abstract class AbstractController implements Controller {

    private Node view;
    private Stage stage;

    static void alert(String message, String title, Alert.AlertType type) {
        Platform.runLater(() -> {
            Alert alert = new Alert(type);
            alert.setHeaderText(title);
            alert.setTitle(title);
            alert.setContentText(message);

            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.setAlwaysOnTop(true);
            stage.getIcons().add(new Image("icon/icon.png"));

            alert.showAndWait();
        });
    }

    public Node getView() {
        return view;
    }

    public void setView(Node view) {
        this.view = view;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    void closeThisWindow() {
        Stage stage = (Stage) getView().getScene().getWindow();
        stage.close();
    }


    Controller runController(String formName, String formTitle, boolean resizeable, boolean fullscreen) {
        Controller controller = SpringLoader.loadControllerFxml("/fxml/" + formName + ".fxml");
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) controller.getView());
        scene.getStylesheets().add((getClass().getResource("/css/mainStyle.css")).toExternalForm());
        stage.setScene(scene);
        stage.setTitle(formTitle);
        stage.setAlwaysOnTop(true);
        stage.getIcons().add(new Image(String.valueOf(ClassLoader.getSystemResource("icon/icon.png"))));
        stage.resizableProperty().setValue(resizeable);
        stage.setMaximized(fullscreen);
        stage.show();
        controller.setStage(stage);
        return controller;
    }

    Controller runController(String formName, String formTitle) {
        return runController(formName, formTitle, false, false);
    }

    @FXML
    public void cancel() {
        getStage().getOnCloseRequest().handle(new WindowEvent(this.getStage(), WindowEvent.WINDOW_CLOSE_REQUEST));
        closeThisWindow();
    }
}

