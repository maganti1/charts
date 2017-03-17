package charts;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
 
public class Bar extends Application {
    final static String param1 = "Param1";
    final static String param2 = "Param2";
    final static String param3 = "Param3";
    final static String param4 = "Param4";
    final static String param5 = "Param5";
	 static int I=0;
	 static int J=0;
	 int count=0;
	 
    @Override public void start(Stage stage) {
    	FileChooser fileChooser = new FileChooser();
		 fileChooser.setTitle("Open Resource File");
		 fileChooser.getExtensionFilters().addAll(
		         new ExtensionFilter("Text Files", "*.txt"),
		         new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
		         new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
		         new ExtensionFilter("All Files", "*.*"));
		 File selectedFile = fileChooser.showOpenDialog(stage);
		 String p[] = new String[1000];
		 String h[] = new String[1000];
		try{
		 FileReader fr = new FileReader(selectedFile);
		 BufferedReader b = new BufferedReader(fr);
		 String x;
		  
		 while((x=b.readLine())!=null){
			  p = x.split(" ");
			  h[I]=p[1];
			  count++;
			  I++;
		 }
		 fr.close();
		}
		catch(Exception e){
		e.getCause();
		}
		
		Double a[] = new Double[10];
		
		 for(int i=0; i< count; i++){
			 a[i]=Double.parseDouble(h[i]); 
		 }
        stage.setTitle("DataSet");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("DataSet");
        xAxis.setLabel("Param");       
        yAxis.setLabel("Number");
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("param1");       
        series1.getData().add(new XYChart.Data(param1, a[J]));      
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("param2");
        series2.getData().add(new XYChart.Data(param2, a[J++]));
 
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("param3");
        series3.getData().add(new XYChart.Data(param3, a[J++]));
        
        XYChart.Series series4 = new XYChart.Series();
        series3.setName("param4");
        series3.getData().add(new XYChart.Data(param4, a[J++]));
        
        XYChart.Series series5 = new XYChart.Series();
        series3.setName("param5");
        series3.getData().add(new XYChart.Data(param5, a[J++]));
  
        
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1, series2, series3, series4, series5);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}