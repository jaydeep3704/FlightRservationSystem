package com.example.frs;
import javafx.scene.control.TextField;
public class TextFieldUtils {
  public void copyText(TextField source, TextField target) {
            source.textProperty().addListener((observable, oldValue, newValue) -> {
                target.setText(newValue);
            });
        }
}
