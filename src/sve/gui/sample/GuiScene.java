package sve.gui.sample;

import javafx.animation.AnimationTimer;
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
    private SecondScene secondScene = new SecondScene();

    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            //for update
        }
    };

    @Override
    public void start(Stage primaryStage) {
        primaryStage = firstScene.getStage();

        secondScene.secondSceneCreator(getTimer());
        firstScene.firstSceneCreator(secondScene.getScene());

        primaryStage.setScene(firstScene.getScene());
        primaryStage.show();
    }

    public void start(){
        launch();
    }

    @Override
    public void handle(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public AnimationTimer getTimer(){
        return timer;
    }
}




