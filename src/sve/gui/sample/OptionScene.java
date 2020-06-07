package sve.gui.sample;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OptionScene implements environmentConstants{
    private Scene scene;

    public OptionScene(){
        super();
    }

    public void OptionSceneCreator(){
        TextField mainWidth = new TextField();
        mainWidth.setPromptText("Main Width");

        TextField mainHeight = new TextField();
        mainHeight.setPromptText("Main Height");

        Label label = new Label("Options");
        label.setId("options");
        label.setTranslateY(-30);

        Button save = new Button("Save");
        save.setTranslateY(30);
        save.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        VBox vbox = new VBox(label,mainWidth,mainHeight,save);
        vbox.setAlignment(Pos.CENTER);
        HBox hbox = new HBox(vbox);
        hbox.setAlignment(Pos.CENTER);
        scene = new Scene(hbox,MAIN_WIDTH,MAIN_HEIGHT);
        scene.getStylesheets().add("file:src/sve/gui/sample/GameDisplay.css");
    }

    public Scene getScene(){ return scene; }
}
