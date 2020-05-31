package sve.gui.sample;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class SecondScene implements environmentConstants {
    private Scene scene;
    private Group gameDisplay = new Group();
    private double gameDisplayX = 0;
    private double gameDisplayY = 0;
    private double gameDisplayDX;
    private double gameDisplayDY;

    public Scene getScene(){ return scene; }

    private EventHandler<KeyEvent> keyReleased = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                case W:
                case S:
                    gameDisplayDY = 0;
                    break;
                case A:
                case D:
                    gameDisplayDX = 0;
                    break;
            }
        }
    };

    private EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            // start movement according to key pressed
            switch (event.getCode()) {
                case W:
                    gameDisplayDY = -6;
                    break;
                case S:
                    gameDisplayDY = 6;
                    break;
                case A:
                    gameDisplayDX = -6;
                    break;
                case D:
                    gameDisplayDX = 6;
                    break;
            }
        }
    };

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
