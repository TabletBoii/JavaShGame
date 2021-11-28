package com.gameproject.gameproject;



import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;

public class MainMenu extends Application {

    private GameMenu gameMenu;

    @Override
    public void start(Stage primaryStage) throws IOException {

        Pane root = new Pane();
        root.setPrefSize(1280, 900);

        InputStream is = Files.newInputStream(Paths.get("res/images/jVIhC3.jpg"));
        Image img = new Image(is);
        is.close();

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(1280);
        imgView.setFitHeight(900);

        gameMenu = new GameMenu();
        gameMenu.setVisible(true);


        root.getChildren().addAll(imgView, gameMenu);


        Scene menuScene = new Scene(root);


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
        primaryStage.setScene(menuScene);
        primaryStage.show();

    }





    public static void main(String[] args) {
        launch(args);
    }


}

