package com.gameproject.gameproject;


import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    Pane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void loadSplashScreen () throws IOException {


        StackPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Splash.fxml")));
        rootPane.getChildren().addAll(pane);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);

        fadeIn.play();

    }
}

