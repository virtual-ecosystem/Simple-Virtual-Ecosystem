package sve.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sve.core.SVE;
import sve.core.SVEModule;
import sve.event.EventType;

public class GuiScene extends Application implements EventHandler<ActionEvent>,environmentConstants,SVEModule {
    private FirstScene firstScene = new FirstScene(new Stage());

    @Override
    public void start(Stage primaryStage) {
        primaryStage = firstScene.getStage();

        firstScene.firstSceneCreator();

        primaryStage.setScene(firstScene.getScene());
        primaryStage.show();
    }

    public static void start(){
        GuiScene.launch(GuiScene.class);
    }

    @Override
    public void handle(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void init(){

    }

    @Override
    public void update() {

    }

    @Override
    public void finish() {
    }

    @Override
    public void stop(){
        System.exit(0);
    }
}




