package com.gameproject.gameproject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class cardGame {
    public Scene GameClass() {
        StackPane gameBoard = new StackPane();
        gameBoard.setPrefSize(1280,720);

        Rectangle gameField = new Rectangle(1280,720);
        gameField.setFill(Color.rgb(255,153,51));

        Rectangle mainBoard = new Rectangle(1250,700);
        mainBoard.setFill(Color.rgb(255, 153, 255));

        Rectangle firstPlayerBoard = new Rectangle(1200, 200);
        firstPlayerBoard.setTranslateY(250);
        firstPlayerBoard.setFill(Color.WHITE);

        Rectangle secondPlayerBoard = new Rectangle(1200, 200);
        secondPlayerBoard.setTranslateY(-250);
        secondPlayerBoard.setFill(Color.WHITE);

        gameBoard.setAlignment(Pos.CENTER);
        gameBoard.getChildren().addAll(gameField, mainBoard, firstPlayerBoard, secondPlayerBoard);
        gameBoard.setVisible(true);
        return new Scene(gameBoard);
    }
}
