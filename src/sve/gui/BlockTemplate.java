package sve.gui;

public class BlockTemplate {
    private String blockName;
    private String imagePath;
    // should add some properties

    public BlockTemplate(String path){
        this.blockName = "null";
        this.imagePath = path;
        //imageView = new ImageView(image);
    }

    public BlockTemplate(String blockName,String path){
        this.blockName = blockName;
        this.imagePath = path;
        //imageView = new ImageView(image);
    }

    public String getImagePath(){ return imagePath; }

    public String getBlockName(){ return blockName; }
}
