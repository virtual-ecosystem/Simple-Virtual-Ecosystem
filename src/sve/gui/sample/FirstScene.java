package sve.gui.sample;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FirstScene implements environmentConstants {
    private Scene scene;
    private Button start,options,exit;
    private Stage window;
    private SecondScene secondScene = new SecondScene(1280,960);

    public FirstScene(Stage window){
        this.window = window;
    }

    public void firstSceneCreator(){
        firstSceneButtonCreator("Start","Options","Exit");
        StackPane layout = new StackPane();
        layout.getChildren().addAll(start,options,exit);
        scene = new Scene(layout, MAIN_WIDTH, MAIN_HEIGHT);
    }

    public void firstSceneButtonCreator(String text1, String text2, String text3){
        OptionScene optionScene = new OptionScene();
        optionScene.OptionSceneCreator(window,this);

        secondScene.secondSceneCreator();

        start = new Button(text1);
        start.setPrefSize(300, 100);
        start.setTranslateX(0);
        start.setTranslateY(-150);
        start.setOnAction(e -> window.setScene(secondScene.getScene()));

        options = new Button(text2);
        options.setPrefSize(300, 100);
        options.setTranslateX(0);
        options.setTranslateY(0);
        options.setOnAction(e -> window.setScene(optionScene.getScene()));

        exit = new Button(text3);
        exit.setPrefSize(300, 100);
        exit.setTranslateX(0);
        exit.setTranslateY(150);
        exit.setOnAction(e -> Platform.exit());
    }

    public Scene getScene(){ return scene; }

    public Stage getStage(){ return window; }

    public SecondScene getSecondScene() {
        return secondScene;
    }

    public void setSecondScene(SecondScene secondScene) {
        this.secondScene = secondScene;
    }
}
