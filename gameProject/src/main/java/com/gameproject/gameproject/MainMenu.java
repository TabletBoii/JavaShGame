package com.gameproject.gameproject;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.animation.FadeTransition;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import org.controlsfx.control.action.Action;

public class MainMenu extends Application {

    private GameMenu gameMenu;
    private final String mainMenuMusicPath = "res/images/mainMenuLoop.m4a";

    @Override
    public void start(Stage primaryStage) throws IOException {

        Pane root = new Pane();


        root.setPrefSize(1280, 720);

        InputStream is = Files.newInputStream(Paths.get("res/images/jVIhC3.jpg"));
        Image img = new Image(is);
        is.close();

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(1280);
        imgView.setFitHeight(720);

        Media media = new Media(new File(mainMenuMusicPath).toURI().toString());
        MediaPlayer mainMenuMusicPlayer = new MediaPlayer(media);
        MediaView mainMenuMusicView = new MediaView(mainMenuMusicPlayer);
        mainMenuMusicPlayer.setVolume(0.05);
        mainMenuMusicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mainMenuMusicPlayer.setAutoPlay(true);


        gameMenu = new GameMenu();
        gameMenu.setVisible(true);


        root.getChildren().addAll(imgView, mainMenuMusicView, gameMenu);


        Scene menuScene = new Scene(root);
        cardGame cardGame = new cardGame();


        gameMenu.btnNewGame.setOnMouseClicked(e -> {
            FadeTransition ft = new FadeTransition();
            ft.setDuration(Duration.seconds(2));
            ft.setNode(root);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.play();
            ft.setOnFinished((ActionEvent event)->{
                mainMenuMusicPlayer.stop();
                primaryStage.setScene(cardGame.GameClass());
                primaryStage.show();
            });
        });

        menuScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                if (!gameMenu.isVisible()) {
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);

                    ft.setFromValue(0);
                    ft.setToValue(1);
                    gameMenu.setVisible(true);
                    ft.play();
                }
                else {
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(evt -> gameMenu.setVisible(false));
                    ft.play();
                }
            }
        });
        splashScreen splashScreen = new splashScreen();
        //splashScreen.loadSplashScreen();
        new Thread(){
            public void run() {
                try{
                    Thread.sleep(1);

                }catch(InterruptedException e){
                    System.out.println(e);
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        //splashScreen.stage.close();
                        primaryStage.setScene(menuScene);
                        primaryStage.show();
                    }
                });
            }
        }.start();

    }



    public static void main(String[] args) {
        launch(args);
    }


}

