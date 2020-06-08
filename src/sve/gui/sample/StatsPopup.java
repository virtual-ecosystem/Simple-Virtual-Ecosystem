package sve.gui.sample;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class StatsPopup implements environmentConstants{
    Stage stage;
    Popup popup = new Popup();

    public StatsPopup(){

    }

    public StatsPopup(Stage stage, String text){
        this.stage = stage;
        Label label = new Label(text);
        label.setId("popupLabelTitle");

        Label label2 = new Label(text);
        label2.setId("popupLabel");

        VBox vBox = new VBox(label,label2);
        vBox.getStylesheets().add("file:src/sve/gui/sample/GameDisplay.css");

        popup.getContent().add(vBox);
        popup.setAutoHide(true);
    }

    public Popup getPopup() {
        return popup;
    }

    public void showPopup(){
        popup.show(stage);
        popup.setX(stage.getX() + MAIN_WIDTH + 8);
        popup.setY(stage.getY() + 2);
    }
}
