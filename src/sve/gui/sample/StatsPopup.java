package sve.gui.sample;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PopupControl;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Window;

public class StatsPopup extends PopupControl implements environmentConstants{
    public StatsPopup(Animal animal){
        StackPane pane = new StackPane();
        pane.getStylesheets().add("file:src/sve/gui/sample/GameDisplay.css");

        Rectangle rec = new Rectangle(180,295);
        rec.setFill(Color.WHITE);
        rec.setId("dashed-border");

        Label text = new Label(animal.getName());
        text.setId("popupLabelTitle");

        Image image = new Image("file:src/sve/gui/sample/images/64-" + animal.getName() + ".jpg");
        ImageView imageView = new ImageView(image);

        Label speed = new Label("Speed: " + "null");
        speed.setId("popupLabel");

        Label age = new Label("Age: " + "null");
        age.setId("popupLabel");

        Label weight = new Label("Weight: " + "null");
        weight.setId("popupLabel");

        Label height = new Label("Height: " + "null");
        height.setId("popupLabel");

        Label sex = new Label("Sex: " + "null");
        sex.setId("popupLabel");

        Label fertility = new Label("Fertility: " + "null");
        fertility.setId("popupLabel");

        Label heat = new Label("Heat: " + "null");
        heat.setId("popupLabel");

        Label periodOfLife = new Label("Period of Life: " + "null");
        periodOfLife.setId("popupLabel");

        final Separator separator2 = new Separator();
        separator2.setOrientation(Orientation.HORIZONTAL);

        VBox vbox = new VBox(text,separator2,imageView,speed,age,weight,height,sex,fertility,heat,periodOfLife);
        vbox.setAlignment(Pos.CENTER);

        pane.getChildren().addAll(rec,vbox);

        setAutoHide(true);
        getScene().setRoot(pane);
        getScene().getStylesheets().add("file:src/sve/gui/sample/GameDisplay.css");
    }

    @Override
    public void show(Window owner) {
        super.show(owner);
        setX(owner.getX() + MAIN_WIDTH + 8);
        setY(owner.getY() + 2);
    }
}
