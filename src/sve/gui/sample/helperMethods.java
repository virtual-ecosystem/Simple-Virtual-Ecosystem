package sve.gui.sample;

import java.util.Random;

public class helperMethods implements environmentConstants{
    public static int randomlyLocationX(int width){
        Random random = new Random();
        return random.nextInt(width - NXN);
    }

    public static int randomlyLocationY(int height){
        Random random = new Random();
        return random.nextInt(height - NXN);
    }

    public static boolean randomlyCreate(int percentageOfLuck){
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        return randomNumber < percentageOfLuck;
    }
}