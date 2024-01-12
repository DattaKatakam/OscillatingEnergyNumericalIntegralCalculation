package homework1;

import org.mariuszgromada.math.mxparser.*;
import processing.core.*;

public class TestNumericalIntegralMet2 extends PApplet {
	public static void main(String[] args) {
		PApplet.main(homework1.TestNumericalIntegralMet2.class);
	}
	
	NumericalIntegralMet2 nifM2;
	FunctionPlotter plotter;
	public void settings() {
		size(500,500,P3D);
	}
	
	public void setup() {
		/* a1 = 3.088725, RegNumber = 123549 and divided by 40000 got the value*/
		/*given that f1 = 2Hz */ 
		/* function f is represented in terms of x as f(x) = a1*t + sin(2*pi*f1*t)*/
		
		double absVal = 617.745; // calculated by hand
		
		Function f = new Function ("f(x)= 3.088725*x + sin(2*pi*2*x)");
		
		nifM2= new NumericalIntegralMet2(0.0,20.0,f);
		plotter = new FunctionPlotter(f,0.0,20.0);
		double valueM2=nifM2.findIntegral();
		
		System.out.println("Integral value by method2 for the function f(x) in interval of 20 sec   " + valueM2);
		
		//finding error by calling the function
		errorAbsRel err= new errorAbsRel(absVal,valueM2);
		err.AbsError();
		err.RelError();
	}
	
	//Method to plot the function
	public void draw() {
		  background(0);	  
		  //draw the plot
		  plotter.plot(this);
		}
	
}
