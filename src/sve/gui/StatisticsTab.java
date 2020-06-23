package sve.gui;

import javafx.embed.swing.SwingNode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import sve.stats.GraphType;
import sve.stats.SVECharts;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StatisticsTab {
    private TabPane tabPane = new TabPane();

    public StatisticsTab(){
        super();
    }

    public StatisticsTab(String text,GraphType type){
        addTab(text,type);
    }

    public void addTab(String text,GraphType type){
        Random random = new Random();
        SVECharts sveCharts = new SVECharts();
        sveCharts.getLineChart(type).addNewLine("Cheetah");
        sveCharts.getLineChart(type).addNewLine("Gazelle");
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; ++i) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sveCharts.getLineChart(type).add(random.nextInt(100),"Cheetah");
                    sveCharts.getLineChart(type).add(random.nextInt(100),"Gazelle");
                }
            }
        };
        thread.start();
        SwingNode swingNode = sveCharts.getLineChart(type).getChartAsSwingNode();

        Tab tabStat0 = new Tab(text);
        tabStat0.setContent(swingNode);
        tabPane.getTabs().add(tabStat0);
    }

    public TabPane getTabPane() {
        return tabPane;
    }
}
