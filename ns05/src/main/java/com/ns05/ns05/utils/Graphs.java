package com.ns05.ns05.utils;
import javax.swing.JFrame;  
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
public class Graphs extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public Graphs(String appTitle) {  
    super(appTitle);  
  
    // Create Dataset  
    CategoryDataset dataset = createDataset();  
      
    //Create chart  
    JFreeChart chart=ChartFactory.createBarChart(  
        "Detection rate", //Chart Title  
        "X-Time(ms)", // Category axis  
        "Y-ThroughOuts (bps)/1000", // Value axis  
        dataset,  
        PlotOrientation.VERTICAL,  
        true,true,false  
       );  
  
    ChartPanel panel=new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private CategoryDataset createDataset() {  
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
  
    // Population in 2005  
    dataset.addValue(10, "BFOA", "10");  
    dataset.addValue(15, "EE-OHRA", "20");  
    dataset.addValue(20, "EA-DRP", "30");  
  
  
    return dataset;  
  }  
  
  public static void main(String[] args) throws Exception {  
    SwingUtilities.invokeAndWait(()->{  
      Graphs example=new Graphs("Bar Chart Window");  
      example.setSize(800, 400);  
      example.setLocationRelativeTo(null);  
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true);  
    });  
  }  
}  