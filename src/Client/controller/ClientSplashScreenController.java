package Client.controller;

import com.jfoenix.controls.JFXProgressBar;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientSplashScreenController implements Initializable{
    public AnchorPane splashScreenContext;
    public JFXProgressBar pgb;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        splashScreenContext.setStyle("-fx-background-color: linear-gradient(#4131a3,#2c2397,#1b146c,#130856,#0a0534);"+"-fx-background-radius:30");

        pgb.setProgress(0);
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(120), event -> {
            if (pgb.getProgress() <= 1) {
                pgb.setProgress(pgb.getProgress() + 0.01);
            }
        }));
        tl.setRate(3);
        tl.setCycleCount(Animation.INDEFINITE);
        tl.playFromStart();
        pgb.progressProperty().addListener((observable, oldValue, newValue) -> {

            try {
                if (newValue.intValue() == 1) {
                    tl.stop();
                    Stage window = (Stage) splashScreenContext.getScene().getWindow();
                    window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginFormCoach.fxml"))));
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        });
    }
}
