package sve.stats;

import javafx.embed.swing.SwingNode;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Creates a line chart by using JFreeChart
 */
public class LineChart {

    private JFreeChart theChart;
    private XYSeriesCollection dataSet;
    private LinkedList<Integer> data;
    private HashMap<String,Line> series;
    //private int time;

    /**
     * constructs a new line chart.
     * @param title title of the chart.
     * @param xAxis x axis label of the chart.
     * @param yAxis y axis label of the chart.
     */
    public LineChart(String title, String xAxis, String yAxis){
        //time = 0;

        dataSet = new XYSeriesCollection();
        theChart = ChartFactory.createXYLineChart(title,xAxis,yAxis,dataSet);

        series = new HashMap<>();

        data = new LinkedList<Integer>(){
            @Override
            public boolean add(Integer integer) {
                LineChart.this.add(integer,"Default");
                return super.add(integer);
            }
        };
    }

    /**
     * add s new line to the chart.
     * @param newLineName name of the new line.
     */
    public void addNewLine(String newLineName){
        Line newLine = new Line((newLineName));
        series.put(newLineName,newLine);
        dataSet.addSeries(newLine.theSeries);
    }

    /**
     * adds a new item to specified line.
     * @param data the data.
     * @param lineName name of the line.
     */
    public void add(Integer data,String lineName){
        Line theLine = series.get(lineName);

        if(theLine == null){
            System.err.println("There is no line which its name is " + lineName);
            return;
        }

        theLine.theSeries.add(theLine.time++,data);
        if(theLine.time > 20){
            theLine.theSeries.remove(0);
        }
    }

    /**
     * returns a SwingNode which have a chart.
     * @return a SwingNode which have a chart.
     */
    public SwingNode getChartAsSwingNode(){
        SwingNode swingNode = new SwingNode();
        swingNode.setContent(new ChartPanel(theChart));

        return swingNode;
    }

    /**
     * returns the data.
     * @return the data.
     */
    public LinkedList<Integer> getTheContainer(){
        return data;
    }

    /**
     * the inner static class to represents the lines.
     */
    public static class Line {

        String name;
        XYSeries theSeries;
        int time;

        /**
         * constructs a new Line.
         * @param name name of the new line.
         */
        Line(String name){
            this.time = 0;
            this.name = name;
            this.theSeries = new XYSeries(name);
        }
    }
}
