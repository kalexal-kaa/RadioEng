/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radioplayer;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
/**
 *
 * @author alex
 */
public class Toast {
    void setMessage(final String toastMsg){
        Stage toastStage=new Stage();
        toastStage.setResizable(false);
        toastStage.initStyle(StageStyle.TRANSPARENT);
        Text t = new Text(toastMsg);
        t.setFont(Font.font("Verdana",20));
        t.setFill(Color.WHITE);
        StackPane root = new StackPane(t);
        root.getStyleClass().add("toast");
        root.setOpacity(0);
        Scene scene = new Scene(root);
        scene.getStylesheets().add((getClass().getResource("style.css")).toExternalForm());
        scene.setFill(null);
        toastStage.setScene(scene);
        toastStage.show();
        Timeline tl1 = new Timeline();
        KeyFrame fadeInKey1 = new KeyFrame(Duration.millis(500),new KeyValue (toastStage.getScene().getRoot().opacityProperty(), 1));
        tl1.getKeyFrames().add(fadeInKey1);
        tl1.setOnFinished((ae) ->
                new Thread(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }
                    Timeline tl2 = new Timeline();
                    KeyFrame fadeOutKey1 = new KeyFrame(Duration.millis(500), new KeyValue(toastStage.getScene().getRoot().opacityProperty(), 0));
                    tl2.getKeyFrames().add(fadeOutKey1);
                    tl2.setOnFinished((aeb) -> toastStage.close());
                    tl2.play();
                }).start());
        tl1.play();
    }
}
