package com.gameproject.gameproject;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.scene.media.MediaView;
import java.io.IOException;
import java.util.Objects;

public class splashScreen {
    public Stage stage;

    private final String videoPath = "res/images/proekt.mp4";
    public void loadSplashScreen() throws IOException {

        try {

            Media media = new Media(new File(videoPath).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            mediaPlayer.setVolume(0.2);
            mediaPlayer.setAutoPlay(true);

            stage = new Stage();
            Pane rootPane = new Pane();
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Splash.fxml")));

            pane.getChildren().addAll(mediaView);
            rootPane.getChildren().addAll(pane);


            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);
            fadeIn.play();


            Scene scene = new Scene(rootPane);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
