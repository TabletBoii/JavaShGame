package com.gameproject.gameproject;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;

class MenuButton extends StackPane {
    private final Text text;
    private final String buttonMusicPath = "res/images/buttonSound.m4a";

    public MenuButton(String name) {

        setMusic buttonSound = new setMusic();

        text = new Text(name);
        text.getFont();
        text.setFont(Font.font("Courier New", 50));
        text.setFill(Color.WHITE);

        Rectangle bg = new Rectangle(500, 70);
        bg.setOpacity(0.6);
        bg.setFill(Color.BLACK);
        bg.setEffect(new GaussianBlur(3.5));


        setAlignment(Pos.CENTER_LEFT);
        setRotate(-0.5);
        getChildren().addAll(bg, text);

        setOnMouseEntered(event -> {
            bg.setTranslateX(10);
            text.setTranslateX(10);
            bg.setFill(Color.WHITE);
            text.setFill(Color.BLACK);
        });

        setOnMouseExited(event -> {
            bg.setTranslateX(0);
            text.setTranslateX(0);
            bg.setFill(Color.BLACK);
            text.setFill(Color.WHITE);
        });

        /*setOnMouseClicked(event -> {
            getChildren().addAll(buttonSound.setMusic(buttonMusicPath, 6.9, 7.5, 0.2));
            getChildren().removeAll(buttonSound.setMusic(buttonMusicPath, 6.9, 7.5, 0.2));
        });*/

        DropShadow drop = new DropShadow(50, Color.WHITE);
        drop.setInput(new Glow());

        setOnMousePressed(event -> {
            setEffect(drop);
            getChildren().addAll(buttonSound.setMusic(buttonMusicPath, 6.9, 7.5, 0.2));
            getChildren().removeAll(buttonSound.setMusic(buttonMusicPath, 6.9, 7.5, 0.2));
        });
        setOnMouseReleased(event -> setEffect(null));
    }


}