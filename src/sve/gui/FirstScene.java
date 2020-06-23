package sve.gui;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sve.core.SVE;
import sve.event.EventType;

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
        layout.getStylesheets().add("file:assets/GameDisplay.css");

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
        start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SVE.getEventManager().callEvent(EventType.START_SVE);
            }
        });

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
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SVE.getEventManager().callEvent(EventType.QUIT);
            }
        });
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
