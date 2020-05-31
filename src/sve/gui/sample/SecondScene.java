package sve.gui.sample;

import javafx.scene.Group;
import javafx.scene.Scene;

public class SecondScene implements environmentConstants {
    private Scene scene;
    private Group gameDisplay = new Group();
    private double gameDisplayX = 0;
    private double gameDisplayY = 0;
    private double gameDisplayDX;
    private double gameDisplayDY;

    public Scene getScene(){ return scene; }

    public void setGameDisplayX(double x){ gameDisplay.setTranslateX(x); }

    public void setGameDisplayY(double y){ gameDisplay.setTranslateY(y); }

    public double getGameDisplayDX() {
        return gameDisplayDX;
    }

    public double getGameDisplayDY() {
        return gameDisplayDY;
    }

    public double getGameDisplayX() {
        return gameDisplayX;
    }

    public double getGameDisplayY() {
        return gameDisplayY;
    }
}
