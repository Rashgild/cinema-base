package ru.rashgild;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.rashgild.controller.MainController;
import ru.rashgild.util.SpringLoader;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        runDatabaseMigrations();
        launch(args);
    }

    public void start(Stage primaryStage) {
        Platform.setImplicitExit(false);
        Stage stageMain = new Stage();
        stageMain.setTitle("Кинобаза");

        MainController controller = (MainController) SpringLoader.loadControllerFxml("/fxml/main-form.fxml");
        Scene scene = new Scene((Parent) controller.getView());
        stageMain.setScene(scene);
        controller.setStage(stageMain);
        stageMain.show();
    }

    private static void runDatabaseMigrations() {
        String host = null;

        try (InputStream input =
                     MainApp.class.getClassLoader().getResourceAsStream("application.properties")) {
            Properties property = new Properties();
            property.load(input);
            host = property.getProperty("jdbc.url");

        } catch (IOException e) {
            log.error("IOException:", e.getMessage());
        }

        Flyway.configure()
                .dataSource(host, null, null)
                .locations("classpath:db/migration")
                .load()
                .migrate();
    }
}
