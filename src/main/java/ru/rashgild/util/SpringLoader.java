package ru.rashgild.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.rashgild.config.AppConfig;
import ru.rashgild.controller.Controller;

public class SpringLoader {

    private static final ApplicationContext APPLICATION_CONTEXT =
            new AnnotationConfigApplicationContext(AppConfig.class);

    public static Controller loadControllerFxml(String url) {
        try (InputStream fxmlStream = SpringLoader.class.getResourceAsStream(url)) {
            FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(aClass -> APPLICATION_CONTEXT.getBean(aClass));

            Node view = loader.load(fxmlStream);
            Controller controller = loader.getController();
            controller.setView(view);

            return controller;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getBean(String beanName) {
        return APPLICATION_CONTEXT.getBean(beanName);
    }

    public static Object getBean(Class beanName) {
        return APPLICATION_CONTEXT.getBean(beanName);
    }
}
