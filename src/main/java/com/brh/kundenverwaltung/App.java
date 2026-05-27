package com.brh.kundenverwaltung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class App extends Application {
    private static FileHandler fileHandler;

    @Override
    public void start(Stage stage) throws IOException {
        fileHandler = new FileHandler(
                "logs/logfile.%u.%g.txt",1024*50, 10
        );
        fileHandler.setFormatter( new SimpleFormatter() );

        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("view.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 1400, 720);
        stage.setTitle("Kundenverwaltung");
        stage.setScene(scene);
        stage.show();

    }

    public static FileHandler getLogFileHandler(){
        return fileHandler;
    }

}
