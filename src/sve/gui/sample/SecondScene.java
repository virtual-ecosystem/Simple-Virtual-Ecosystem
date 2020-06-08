package sve.gui.sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;

import static sve.gui.sample.helperMethods.randomlyLocationX;
import static sve.gui.sample.helperMethods.randomlyLocationY;

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
        Label label = new Label("Şuanlık buraya bir şey eklemedim.");
        Font val = new Font(35.6);
        label.setFont(val);
        Group statistics = new Group();
        statistics.getChildren().add(label);
        tab1.setContent(statistics);

        Tab tab2 = new Tab("Planned Features");
        Label label2 = new Label("- Arkadaki harita hareket edicek.");
        Label label3 = new Label("- Harita tam anlamıyla random bir şekilde atanacak.");
        Label label4 = new Label("- Parametreler simulasyona entegre edilecek.");
        Label label5 = new Label("- Graph'lar 2.sekmeye eklenicek.");
        label3.setLayoutY(label2.getLayoutY()+50);
        label4.setLayoutY(label3.getLayoutY()+50);
        label5.setLayoutY(label4.getLayoutY()+50);
        label2.setFont(val);
        label3.setFont(val);
        label4.setFont(val);
        label5.setFont(val);
        label2.setTextFill(Color.RED);
        label3.setTextFill(Color.RED);
        label4.setTextFill(Color.RED);
        label5.setTextFill(Color.RED);
        Group features = new Group();
        features.getChildren().addAll(label2,label3,label4,label5);
        tab2.setContent(features);

        tabPane.getTabs().addAll(tab0,tab1,tab2);

        BorderPane borderPane = new BorderPane(tabPane);
        borderPane.setTop(back);

        scene = new Scene(borderPane,MAIN_WIDTH,MAIN_HEIGHT);
    }

    public Group secondSceneGroupCreator(Stage stage) {
        gameDisplay.getStylesheets().add(getClass().getResource("GameDisplay.css").toExternalForm());

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
