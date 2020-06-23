package sve.gui;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sve.core.Cheetah;
import sve.core.Gazelle;
import sve.core.Point2D;
import sve.core.Sex;
import sve.stats.GraphType;

import static sve.gui.helperMethods.randomlyLocationX;
import static sve.gui.helperMethods.randomlyLocationY;

public class SecondScene implements environmentConstants {
    private Scene scene;
    private Group gameDisplay = new Group();
    private int mapWidth;
    private int mapHeight;
    private double gameDisplayX = 0;
    private double gameDisplayY = 0;
    private double gameDisplayDX;
    private double gameDisplayDY;

    public SecondScene(int mapWidth, int mapHeight){
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            // update paddle positions
            update();
        }
    };

    private void update(){
        gameDisplayX += getGameDisplayDX();
        gameDisplayY += getGameDisplayDY();

        setGameDisplayX(gameDisplayX);
        setGameDisplayY(gameDisplayY);
    }

    public void secondSceneCreator(Stage stage, FirstScene firstScene){
        Button back = new Button("Back to Menu");
        back.setAlignment(Pos.TOP_LEFT);
        back.setOnAction(e -> stage.setScene(firstScene.getScene()));

        TabPane tabPane = new TabPane();
        tabPane.setId("tabPane");
        tabPane.getStylesheets().add(getClass().getResource("GameDisplay.css").toExternalForm());

        Group myGroup = secondSceneGroupCreator(stage);
        Tab tab0 = new Tab("Main Tab");
        tab0.setContent(myGroup);

        Tab tab1 = new Tab("Statistics");
        StatisticsTab stat = new StatisticsTab("Population",GraphType.POPULATION);
        stat.addTab("Birth",GraphType.BIRTH);
        stat.addTab("Death",GraphType.DEATH);
        TabPane statisticsTab = stat.getTabPane();
        tab1.setContent(statisticsTab);

        tabPane.getTabs().addAll(tab0,tab1);

        BorderPane borderPane = new BorderPane(tabPane);
        borderPane.setTop(back);

        scene = new Scene(borderPane,MAIN_WIDTH,MAIN_HEIGHT);
    }

    public Group secondSceneGroupCreator(Stage stage) {
        gameDisplay.getStylesheets().add(getClass().getResource( "GameDisplay.css").toExternalForm());

        secondSceneBackgroundCreator(stage,gameDisplay);

        timer.start();

        return gameDisplay;
    }

    private void secondSceneBackgroundCreator(Stage stage,Group gameDisplay){
        Background background = new Background(gameDisplay);
        background.setBackground(mapWidth,mapHeight);
        background.setCanvas(new Canvas(mapWidth,mapHeight));

        background.getCanvas().setFocusTraversable(true);
        background.getCanvas().setOnKeyPressed(keyPressed);
        background.getCanvas().setOnKeyReleased(keyReleased);
        background.getCanvas().addEventFilter(MouseEvent.ANY, (e) -> background.getCanvas().requestFocus());

        gameDisplay.getChildren().add(background.getCanvas());
        secondSceneAnimalCreator(stage,gameDisplay);
    }

    private void secondSceneAnimalCreator(Stage stage,Group gameDisplay){
        AnimalCreator cheetah = new AnimalCreator(stage,gameDisplay,new Cheetah(Sex.FEMALE, 10, 10, 10, 10, 10),new Point2D(randomlyLocationX(mapWidth),randomlyLocationY(mapHeight)));

        AnimalCreator gazelle = new AnimalCreator(stage,gameDisplay,new Gazelle(Sex.FEMALE, 10, 10, 10, 10, 10),new Point2D(randomlyLocationX(mapWidth),randomlyLocationY(mapHeight)));
    }

    public Scene getScene(){ return scene; }

    private EventHandler<KeyEvent> keyReleased = new EventHandler<>() {
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

    private EventHandler<KeyEvent> keyPressed = new EventHandler<>() {
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
}
