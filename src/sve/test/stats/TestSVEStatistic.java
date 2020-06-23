package sve.test.stats;

import sve.stats.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * The test class to show the charts.
 */
public class TestSVEStatistic extends Application {

    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) throws Exception {

        SVECharts sveCharts = new SVECharts();
        primaryStage.setScene(sveCharts.getChartScene());
        primaryStage.show();

        //every line represents an animal
        sveCharts.getLineChart(GraphType.POPULATION).addNewLine("Cheetah");
        sveCharts.getLineChart(GraphType.POPULATION).addNewLine("Gazelle");


        //All updates should be in different thread.
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; ++i) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    sveCharts.getLineChart(GraphType.POPULATION).add(random.nextInt(100),"Cheetah");
                    sveCharts.getLineChart(GraphType.POPULATION).add(random.nextInt(100),"Gazelle");

                }
            }
        };
        thread.start();

        /*
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        }).start();
        */
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) { launch(args); }
}