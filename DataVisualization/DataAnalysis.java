package org.ml;

import java.io.IOException;

import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.AreaPlot;
import tech.tablesaw.plotly.api.BubblePlot;
import tech.tablesaw.plotly.api.ScatterPlot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.traces.BarTrace;
import tech.tablesaw.plotly.traces.BoxTrace;
import tech.tablesaw.plotly.traces.Histogram2DTrace;
import tech.tablesaw.plotly.traces.HistogramTrace;
import tech.tablesaw.plotly.traces.ScatterTrace;
public class DataAnalysis {
	public static void main(String args[]) {
		System.out.println("Data Visualization");
		try {
			Table data = Table.read().csv("/home/joshita/eclipse-workspace/org.ml/src/main/java/org/ml/loanpredict_traindata_after_preprocess.csv");
			System.out.println(data.shape());
		     System.out.println(data.structure());
		     System.out.println(data.summary());
	
		     //HISTOGRAM
		     Layout layout1 = Layout.builder().title("Distribution of Loan Amount").build();
		     HistogramTrace trace1 = HistogramTrace.builder(data.nCol("LoanAmount")).build();
		     Plot.show(new Figure(layout1, trace1));
		     
		     Layout layout4 = Layout.builder().title("Distribution of Applicant Income").build();
		     HistogramTrace trace4 = HistogramTrace.builder(data.nCol("ApplicantIncome")).build();
		     Plot.show(new Figure(layout4, trace4));
		     
		     Layout layout7 = Layout.builder().title("Distribution of Co-Applicant Income").build();
		     HistogramTrace trace7 = HistogramTrace.builder(data.nCol("CoapplicantIncome")).build();
		     Plot.show(new Figure(layout7, trace7));
		     
		     //BOX PLOT
		     Layout layout2 = Layout.builder().title("Loan Amount by loan Status").build();
		     BoxTrace trace2 = BoxTrace.builder(data.categoricalColumn("Loan_Status"),data.nCol("LoanAmount")).build();
		     Plot.show(new Figure(layout2, trace2));
		     
		     //SCATTER PLOT
		     Layout layout3 = Layout.builder().title("Scatter plot of Loan Amount and Applicant Income").build();
		     ScatterTrace trace3 = ScatterTrace.builder(data.nCol("ApplicantIncome"),data.nCol("LoanAmount")).build();
		     Plot.show(new Figure(layout3, trace3));
		     
		     //BAR GRAPH
		     Layout layout5 = Layout.builder().title("Bar Graph").build();
		     BarTrace trace5 = BarTrace.builder(data.categoricalColumn("Property_Area"),data.nCol("LoanAmount")).build();
		     Plot.show(new Figure(layout5,trace5));
		     
		     //2D HISTOGRAM
		     Layout layout6 = Layout.builder().title("2D Histogram for Applicant income and Coapplicant Income").build();
		     Histogram2DTrace trace6 = Histogram2DTrace.builder(data.nCol("ApplicantIncome"), data.nCol("CoapplicantIncome")).build();
		     Plot.show(new Figure(layout6,trace6));
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}







