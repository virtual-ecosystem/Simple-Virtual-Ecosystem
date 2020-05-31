package sve.gui.sample;

import javafx.scene.Group;

import static sve.gui.sample.helperMethods.randomlyCreate;

public class Background implements environmentConstants{
    private Group gameDisplay;
    BlockTemplate grassTemplate = new BlockTemplate("file:src/sample/images/img1.png");
    BlockTemplate sandTemplate = new BlockTemplate("file:src/sample/images/img2.png");
    BlockTemplate soilTemplate = new BlockTemplate("file:src/sample/images/img3.png");
    BlockTemplate stoneTemplate = new BlockTemplate("file:src/sample/images/img4.png");
    BlockTemplate waterTemplate = new BlockTemplate("file:src/sample/images/img5.png");
    BlockTemplate tree1Template = new BlockTemplate("file:src/sample/images/img_tree1.png");
    BlockTemplate tree2Template = new BlockTemplate("file:src/sample/images/img_tree2.png");
    BlockTemplate small_tree1Template = new BlockTemplate("file:src/sample/images/img_tree_small1.png");
    BlockTemplate small_tree2Template = new BlockTemplate("file:src/sample/images/img_tree_small2.png");
    BlockTemplate environment_grass1Template = new BlockTemplate("file:src/sample/images/img_grass1.png");
    BlockTemplate environment_grass2Template = new BlockTemplate("file:src/sample/images/img_grass2.png");

    public Background(Group gameDisplay){
        this.gameDisplay = gameDisplay;
    }

    public void setBackground(){
        int x = MAIN_WIDTH / 64;  // 20
        int y = MAIN_HEIGHT / 64;  // 15

        for(int i=0;i<x;++i){
            for(int j=0;j<y;++j){
                Block grass = new Block(grassTemplate.getImagePath(),i*64,j*64);
                gameDisplay.getChildren().add(grass.getImageView());

                if(i<6 && i>3 && j<6 && j>3){
                    Block water = new Block(waterTemplate.getImagePath(),i*64,j*64);
                    gameDisplay.getChildren().add(water.getImageView());
                } else{
                    if(randomlyCreate(3)) {
                        Block tree = new Block(tree1Template.getImagePath(), i * 64, j * 64);
                        gameDisplay.getChildren().add(tree.getImageView());
                    }
                    if(randomlyCreate(3)) {
                        Block tree2 = new Block(tree2Template.getImagePath(), i * 64, j * 64);
                        gameDisplay.getChildren().add(tree2.getImageView());
                    }
                    if(randomlyCreate(6)) {
                        Block environment_grass = new Block(environment_grass1Template.getImagePath(), i * 64, j * 64);
                        gameDisplay.getChildren().add(environment_grass.getImageView());
                    }
                }
            }
        }
    }
}