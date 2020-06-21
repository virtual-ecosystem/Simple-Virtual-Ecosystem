package sve.gui;

import javafx.scene.image.ImageView;

public class Block extends BlockTemplate {
    private ImageView imageView;

    public Block(String path) {
        super(path);
        imageView = new ImageView(super.getImagePath());
        imageView.setX(0);
        imageView.setY(0);
    }

    public Block(String path,int x,int y) {
        super(path);
        imageView = new ImageView(super.getImagePath());
        imageView.setX(x);
        imageView.setY(y);
    }

    public ImageView getImageView() {
        return imageView;
    }
}