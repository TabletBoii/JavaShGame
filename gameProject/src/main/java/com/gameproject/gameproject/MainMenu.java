package com.gameproject.gameproject;



import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;

public class MainMenu extends Application {

    private GameMenu gameMenu;

    @Override
    public void start(Stage primaryStage) throws Exception {

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

    private static class GameMenu extends Parent {
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

    private static class MenuButton extends StackPane {
        private final Text text;

        public MenuButton(String name) {
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

            DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));
        }
    }
    /*private static class splashScreen extends StackPane{

        private void loadSplashScreen(Pane pane) {
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            //Finish splash with fade out effect
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            //After fade in, start fade out
            fadeIn.setOnFinished((e) -> {
                fadeOut.play();
            });

            //After fade out, load actual content
            *//*fadeOut.setOnFinished((e) -> {
                try {
                    AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("/main.fxml")));
                    root.getChildren().setAll(parentContent);
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }*//*
        }
    }*/




    public static void main(String[] args) {
        launch(args);
    }


}

