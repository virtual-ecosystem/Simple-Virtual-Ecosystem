package sve.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sve.core.SVE;
import sve.event.EventType;

public class OptionScene implements environmentConstants{
    private Scene scene;

    public OptionScene(){
        super();
    }

    public void OptionSceneCreator(Stage stage,FirstScene firstScene){
        TextField mapWidthText = new TextField();
        mapWidthText.setPromptText("Map Width");
        mapWidthText.setAlignment(Pos.CENTER);

        TextField mapHeightText = new TextField();
        mapHeightText.setPromptText("Map Height");
        mapHeightText.setAlignment(Pos.CENTER);

        Label label = new Label("Options");
        label.setId("firstSceneLabel");
        label.setTranslateY(-30);

        final Slider slider = new Slider(0,100,6);
        final Label sliderCaption = new Label("Day per second: ");
        sliderCaption.setId("popupLabel");
        final Label sliderValue = new Label(Double.toString(slider.getValue()));
        sliderValue.setId("popupLabel");

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                sliderValue.setText(String.format("%.2f", new_val));
            }
        });

        HBox sliderHbox = new HBox(sliderCaption,slider,sliderValue);
        sliderHbox.setSpacing(20);
        sliderHbox.setAlignment(Pos.CENTER);

        Button save = new Button("Save");
        save.setId("firstSceneButton");
        save.setTranslateY(30);
        save.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SecondScene secondScene;
                try {
                    int mapW = Integer.parseInt(mapWidthText.getText());
                    int mapH = Integer.parseInt(mapHeightText.getText());
                    if(mapW < 0 || mapH < 0){
                        mapW = 1280;
                        mapH = 960;
                        Toast.makeText(stage, "Both values must be positive.", 2000, 500, 500);
                    } else if(mapW > 6000 || mapH > 6000){
                        mapW = 1280;
                        mapH = 960;
                        Toast.makeText(stage, "Values can't be higher than 6000.", 2000, 500, 500);
                    }
                    secondScene = new SecondScene(mapW, mapH);
                    secondScene.secondSceneCreator(stage, firstScene);
                    Toast.makeText(stage, "Saved", 1500, 500, 500);
                } catch (Exception ex) {
                    int mapW = 1280;
                    int mapH = 960;
                    secondScene = new SecondScene(mapW, mapH);
                    secondScene.secondSceneCreator(stage, firstScene);
                    Toast.makeText(stage, "Please enter a valid value", 2000, 500, 500);
                }
                firstScene.setSecondScene(secondScene);
            }
        });

        Button back = new Button("Back to Menu");
        back.setId("firstSceneButton");
        back.setAlignment(Pos.TOP_LEFT);
        back.setOnAction(e -> stage.setScene(firstScene.getScene()));

        VBox vbox = new VBox(label,mapWidthText,mapHeightText,sliderHbox,save);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(360);
        vbox.setSpacing(15);

        HBox hbox = new HBox(vbox);
        hbox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane(hbox);
        borderPane.setId("firstScenePane");
        borderPane.setTop(back);

        this.scene = new Scene(borderPane,MAIN_WIDTH,MAIN_HEIGHT);
        this.scene.getStylesheets().add("file:assets/GameDisplay.css");
    }

    public Scene getScene(){ return scene; }
}
