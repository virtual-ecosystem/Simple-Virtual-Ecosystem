package sve.gui.sample;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.Background;
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
        Label label = new Label("Group 9");
        label.setId("firstSceneLabel");
        label.setTranslateY(-350);
        Label label2 = new Label("Simple Virtual Ecosystem");
        label2.setId("firstSceneLabel");
        label2.setTranslateY(-300);

        firstSceneButtonCreator("Start","Options","Exit");
        StackPane layout = new StackPane();
        layout.setId("firstScenePane");
        layout.getChildren().addAll(start,options,exit,label,label2);
        layout.getStylesheets().add("file:src/sve/gui/sample/GameDisplay.css");

        scene = new Scene(layout, MAIN_WIDTH, MAIN_HEIGHT);
    }

    public void firstSceneButtonCreator(String text1, String text2, String text3){
        OptionScene optionScene = new OptionScene();
        optionScene.OptionSceneCreator(window,this);

        secondScene.secondSceneCreator(window,this);

        start = new Button(text1);
        start.setId("firstSceneButton");
        start.setPrefSize(300, 100);
        start.setTranslateX(0);
        start.setTranslateY(-150);
        start.setOnAction(e -> window.setScene(secondScene.getScene()));

        options = new Button(text2);
        options.setId("firstSceneButton");
        options.setPrefSize(300, 100);
        options.setTranslateX(0);
        options.setTranslateY(0);
        options.setOnAction(e -> window.setScene(optionScene.getScene()));

        exit = new Button(text3);
        exit.setId("firstSceneButton");
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
