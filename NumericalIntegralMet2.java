package homework1;

import java.awt.Color;

import org.mariuszgromada.math.mxparser.*;

import grafica.GPoint;
import processing.core.PApplet;


public class NumericalIntegralMet2 {
	private double a;
	private double b;
	private static final double interval = 1e-4;
	private Function f;
	
	public static double getInterval() {
		return interval;
	}

	private FunctionPlotter fp;
	
	public NumericalIntegralMet2(double a, double b, Function f) {
		this.a=a;
		this.b=b;
		this.f=f;
		fp = new FunctionPlotter(this.f, this.a, this.b);
	}

	public double getA() {
		return this.a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return this.b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public Function getF() {
		return this.f;
	}

	public void setF(Function f) {
		this.f = f;
	}
	
	public void plot(PApplet app) {
		this.fp.plot(app);
	}
	
	public double findIntegral() {
		double area = 0;
		
		double x=this.a+interval;
		
		// graphics
		GPoint firstPoint = new GPoint((float) a, 0);
		GPoint secondPoint = new GPoint((float) a, (float) this.f.calculate(a));
		this.fp.addLine(firstPoint, secondPoint, Color.BLUE);
		
		while(x<b) {
			area+= interval * findAvg(x);
			
			// graphics
			firstPoint = new GPoint((float) (x-interval), 0);
			this.fp.addLine(secondPoint, firstPoint, Color.BLUE);
			secondPoint = new GPoint((float) x, (float) this.f.calculate(x));
			this.fp.addLine(firstPoint, secondPoint, Color.BLUE);
			
			x+=interval;
		}
		
		return area;
		
	}
	
	public double findAvg(double x) {
		double i=x;
		double f2=this.f.calculate(i);
		double f1 = this.f.calculate(i-interval);
		
		return Math.abs((f1+f2)/2);
	}
	
	
}
