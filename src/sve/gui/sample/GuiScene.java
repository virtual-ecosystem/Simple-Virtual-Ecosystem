package sve.gui.sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class GuiScene extends Application implements EventHandler<ActionEvent>,environmentConstants{
    private FirstScene firstScene = new FirstScene(new Stage());

    @Override
    public void start(Stage primaryStage) {
        primaryStage = firstScene.getStage();

        firstScene.firstSceneCreator();

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
}




