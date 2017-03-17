package charts;
import java.io.File;
import java.io.FileInputStream;
import java.io.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

public class Pie extends Application {
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
		Scene scene = new Scene(new Group());
		stage.setTitle("DataSet");
		stage.setWidth(500);
		stage.setHeight(500);
		ObservableList<PieChart.Data> pieChartData =
				FXCollections.observableArrayList(
						new PieChart.Data("Param1", a[J]),
						new PieChart.Data("Param2", a[J++]),
						new PieChart.Data("Param3", a[J++]),
						new PieChart.Data("Param4", a[J++]),
						new PieChart.Data("Param5", a[J++]));
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("DataSet");
		((Group) scene.getRoot()).getChildren().add(chart);
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}