package sve.gui.sample;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static sve.gui.sample.helperMethods.randomlyLocationX;
import static sve.gui.sample.helperMethods.randomlyLocationY;

public class AnimalCreator {
    public static void create(Stage stage, Group gameDisplay){
        AnimalTemplate cheetahTemplate = new AnimalTemplate("file:src/sve/gui/sample/images/64-cheetah.jpg");
        AnimalTemplate gazelleTemplate = new AnimalTemplate("file:src/sve/gui/sample/images/64-gazelle.jpg");

        Animal cheetah = new Animal(cheetahTemplate.getImagePath(),randomlyLocationX(),randomlyLocationY());
        Animal gazelle = new Animal(gazelleTemplate.getImagePath(),randomlyLocationX(),randomlyLocationY());

        StatsPopup cheetahPopup = new StatsPopup(stage,"Cheetah");
        StatsPopup gazellePopup = new StatsPopup(stage,"Gazelle");

        cheetah.getImageView().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!cheetahPopup.getPopup().isShowing()){
                    cheetahPopup.showPopup();
                }
            }
        });

        gazelle.getImageView().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!gazellePopup.getPopup().isShowing()){
                    gazellePopup.showPopup();
                }
            }
        });

        gameDisplay.getChildren().addAll(cheetah.getImageView(),gazelle.getImageView());
    }
}
