package com.gameproject.gameproject;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

class GameMenu extends Parent {
    public GameMenu() {
        VBox menu0 = new VBox(10);
        VBox menu1 = new VBox(10);

        menu0.setTranslateX(100);
        menu0.setTranslateY(200);

        menu1.setTranslateX(100);
        menu1.setTranslateY(200);

        final int offset = 800;

        menu1.setTranslateX(offset);

        MenuButton btnResume = new MenuButton("NEW GAME");
        btnResume.setOnMouseClicked(event -> {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> setVisible(false));
            ft.play();
        });


        MenuButton btnOptions = new MenuButton("OPTIONS");
        btnOptions.setOnMouseClicked(event -> {
            getChildren().add(menu1);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
            tt.setToX(menu0.getTranslateX() - offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
            tt1.setToX(menu0.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> {
                getChildren().remove(menu0);
            });
        });

        MenuButton btnAbout = new MenuButton("ABOUT");
        btnAbout.setOnMouseClicked(event -> {

        });

        MenuButton btnExit = new MenuButton("EXIT");
        btnExit.setOnMouseClicked(event -> {
            System.exit(0);
        });

        MenuButton btnBack = new MenuButton("BACK");
        btnBack.setOnMouseClicked(event -> {
            getChildren().add(menu0);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
            tt.setToX(menu1.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
            tt1.setToX(menu1.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(event1 -> {
                getChildren().remove(menu1);
            });
        });

        MenuButton btnSound = new MenuButton("SOUND");
        MenuButton btnVideo = new MenuButton("VIDEO");

        menu0.getChildren().addAll(btnResume, btnOptions, btnExit);
        menu1.getChildren().addAll(btnBack, btnSound, btnVideo);

        Rectangle bg = new Rectangle(1280, 900);
        bg.setFill(Color.GREY);
        bg.setOpacity(0.4);

        getChildren().addAll(bg, menu0);
    }
}
