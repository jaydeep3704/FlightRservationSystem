package com.example.frs.animations;

import javafx.animation.PauseTransition;

import javafx.scene.control.Label;
import javafx.util.Duration;



public class LabelDisappear {

    public void disappear(Label label) {
        PauseTransition visiblePause = new PauseTransition(
                Duration.seconds(3)
        );
        visiblePause.setOnFinished(
                e -> label.setVisible(false)
        );
        visiblePause.play();
    }
}
