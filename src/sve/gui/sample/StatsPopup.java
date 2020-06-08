package sve.gui.sample;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;

public class StatsPopup {
    Popup popup = new Popup();

    public StatsPopup(){

    }

    public StatsPopup(String text){
        Label label = new Label(text);
        label.setId("popupLabel");

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
}
