package sve.gui.sample;

import java.util.Random;

public class helperMethods implements environmentConstants{
    public static int randomlyLocationX(){
        Random random = new Random();
        return random.nextInt(MAIN_WIDTH);
    }

    public static int randomlyLocationY(){
        Random random = new Random();
        return random.nextInt(MAIN_HEIGHT);
    }

    public static boolean randomlyCreate(int percentageOfLuck){
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        return randomNumber < percentageOfLuck;
    }
}