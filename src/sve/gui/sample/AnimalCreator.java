package sve.gui.sample;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sve.core.Animal;
import sve.core.Cheetah;
import sve.core.Point2D;
import sve.gui.RenderTypes;

import java.lang.reflect.ParameterizedType;

import static sve.gui.sample.helperMethods.randomlyLocationX;
import static sve.gui.sample.helperMethods.randomlyLocationY;

public class AnimalCreator {
    public AnimalCreator(Stage stage, Group gameDisplay, Animal animal, Point2D location){
        String imagePath = animal.pathTo(RenderTypes.ICON);

        ImageView imageView = new ImageView(new Image(imagePath));
        StatsPopup popup = new StatsPopup(animal.getClass().getSimpleName());
        Label label = new Label("?");
        label.setId("animalLabel");
        VBox vBox = new VBox(label);
        vBox.setTranslateX(/*location.x*/randomlyLocationX());
        vBox.setTranslateY(/*location.y*/randomlyLocationY());
        vBox.getChildren().add(imageView);
        vBox.setAlignment(Pos.CENTER);

        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!popup.isShowing()){
                    popup.show(stage);
                }
            }
        });

        gameDisplay.getChildren().addAll(vBox);
    }
}
