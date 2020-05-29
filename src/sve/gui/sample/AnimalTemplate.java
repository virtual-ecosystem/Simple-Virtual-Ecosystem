package sve.gui.sample;

public class AnimalTemplate {
    private String imagePath;
    // should add some properties

    public AnimalTemplate(String path){
        this.imagePath = path;
        //imageView = new ImageView(image);
    }

    public String getImagePath(){ return imagePath; }

}
