package com.jayktec.grafico;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.media.Track;
import javafx.stage.Stage;

/**
 * A sample media player which loops indefinitely over the same video
 */
public class a extends Application {
private static final String MEDIA_URL = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
private static String arg1;

    @Override public void start(Stage stage) {
        stage.setTitle("Media Player");

// Create media player
        Media media = new Media((arg1 != null) ? arg1 : MEDIA_URL);
        javafx.scene.media.MediaPlayer mediaPlayer = new javafx.scene.media.MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);

// Print track and metadata information
        media.getTracks().addListener(new ListChangeListener<Track>() {
public void onChanged(Change<? extends Track> change) {
                //System.out.println("Track> "+change.getList());
            }
        });
        media.getMetadata().addListener(new MapChangeListener<String,Object>() {
public void onChanged(MapChangeListener.Change<? extends String, ? extends Object> change) {
                //System.out.println("Metadata> "+change.getKey()+" -> "+change.getValueAdded());
            }
        });

// Add media display node to the scene graph
        MediaView mediaView = new MediaView(mediaPlayer);
        Group root = new Group();
        Scene scene = new Scene(root,800,600);
        root.getChildren().add(mediaView);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.play();
    }

public static void main(String[] args) {
if (args.length > 0) {
            arg1 = args[0];
        }
        Application.launch(args);
 
}

}
