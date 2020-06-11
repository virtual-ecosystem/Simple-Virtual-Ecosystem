package sve.gui.sample;

import javafx.scene.image.ImageView;

public class Animal extends AnimalTemplate {
    private ImageView imageView;
    private String name;

    public Animal(String path) {
        super(path);
        imageView = new ImageView(super.getImagePath());
        imageView.setX(0);
        imageView.setY(0);
    }

    public Animal(String path,String name,int x,int y) {
        super(path);
        this.name = name;
        imageView = new ImageView(super.getImagePath());
        imageView.setX(x);
        imageView.setY(y);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public String getName() {
        return name;
    }
}
