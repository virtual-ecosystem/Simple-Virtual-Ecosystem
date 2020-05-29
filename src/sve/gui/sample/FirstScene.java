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

    public FirstScene(Stage window){
        this.window = window;
    }

    public void firstSceneCreator(Scene scene2){
        firstSceneButtonCreator(scene2,"Start","Options","Exit");
        StackPane layout = new StackPane();
        layout.getChildren().addAll(start,options,exit);
        scene = new Scene(layout, MAIN_WIDTH, MAIN_HEIGHT);
    }

    public void firstSceneButtonCreator(Scene scene2,String text1,String text2,String text3){
        start = new Button(text1);
        start.setPrefSize(300, 100);
        start.setTranslateX(0);
        start.setTranslateY(-150);
        start.setOnAction(e -> window.setScene(scene2));

        options = new Button(text2);
        options.setPrefSize(300, 100);
        options.setTranslateX(0);
        options.setTranslateY(0);
        options.setOnAction(e -> window.setScene(scene2));

        exit = new Button(text3);
        exit.setPrefSize(300, 100);
        exit.setTranslateX(0);
        exit.setTranslateY(150);
        exit.setOnAction(e -> Platform.exit());
    }

    public Scene getScene(){ return scene; }

    public Stage getStage(){ return window; }
}
