package sve.gui.sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FirstScene implements environmentConstants {
    private Scene scene;
    private Button start,options,exit;
    private Stage window;

    public FirstScene(Stage window){
        this.window = window;
    }
}
