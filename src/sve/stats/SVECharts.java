package sve.stats;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;

/**
 * To first build of the charts that we will use for SVE project.
 */
public class SVECharts{

    private Scene chartScene;
    private LineChart[] allCharts;
    private TabPane tabPane;

    /**
     * Constructs the all required line charts in separated tabs.
     */
    public SVECharts(){

        allCharts = new LineChart[GraphType.TYPE_SIZE.ordinal()];

        tabPane = new TabPane();

        tabPane.getTabs().add(this.getChartAsTab(GraphType.POPULATION));
        tabPane.getTabs().add(this.getChartAsTab(GraphType.REPRODUCTIVE));
        tabPane.getTabs().add(this.getChartAsTab(GraphType.DEATH));
        tabPane.getTabs().add(this.getChartAsTab(GraphType.BIRTH));
        tabPane.getTabs().add(this.getChartAsTab(GraphType.RESOURCE));
        tabPane.getTabs().add(this.getChartAsTab(GraphType.FOOD));
        tabPane.getTabs().add(this.getChartAsTab(GraphType.WATER));

        StackPane pane = new StackPane(tabPane);
        chartScene = new Scene(pane,600,400);
    }

    /**
     * creates a new tab which have an empty chart.
     * @param graphType type of the chart.
     * @return a new tab which have an empty chart.
     */
    private Tab getChartAsTab(GraphType graphType){
        if(graphType == null)
            return null;

        allCharts[graphType.ordinal()] = new LineChart(graphType.name(),"time","yAxis");
        Tab tab = new Tab(graphType.toString());
        tab.setContent(allCharts[graphType.ordinal()].getChartAsSwingNode());
        return tab;
    }

    /**
     * returns the scene.
     * @return the scene.
     */
    public Scene getChartScene() {
        return chartScene;
    }

    /**
     * returns the specified LineChart.
     * @param graphType type of the chart.
     * @return the specified LineChart.
     */
    public LineChart getLineChart(GraphType graphType){
        if(graphType == null)
            return null;

        return allCharts[graphType.ordinal()];
    }

    /**
     * returns the tabPane.
     * @return the tabPane.
     */
    public TabPane getTabPane() {
        return tabPane;
    }
}