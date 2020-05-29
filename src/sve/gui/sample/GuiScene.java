package sve.gui.sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiScene extends Application implements EventHandler<ActionEvent>,environmentConstants{
    private FirstScene firstScene = new FirstScene(new Stage());
    StackPane layout;
    Stage window;
    Scene scene1;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        firstSceneCreator();
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public void start(){
        launch();
    }

    public void firstSceneCreator() {
        layout = new StackPane();
        scene1 = new Scene(layout, MAIN_WIDTH, MAIN_HEIGHT);
    }

    @Override
    public void handle(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}




