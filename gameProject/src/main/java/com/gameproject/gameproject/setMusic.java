package com.gameproject.gameproject;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;

public class setMusic {
    private boolean setPlayStop;
    public MediaView setMusic(String musicPath, double fMark, double sMark, double volume) {
        Media media = new Media(new File(musicPath).toURI().toString());
        MediaPlayer buttonMusicPlayer = new MediaPlayer(media);
        MediaView buttonMusicView = new MediaView(buttonMusicPlayer);
        buttonMusicPlayer.setVolume(volume);
        buttonMusicPlayer.setStartTime(Duration.seconds(fMark));
        //6.9 7.5
        buttonMusicPlayer.setStopTime(Duration.seconds(sMark));
        buttonMusicPlayer.play();
        return buttonMusicView;
    }
}
