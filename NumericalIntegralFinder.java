package homework1;

import java.awt.Color;

import org.mariuszgromada.math.mxparser.*;

import grafica.GPoint;
import processing.core.PApplet;

public class NumericalIntegralFinder {
	
	private double a;
	private double b;
	private static final double interval=1e-4;
	private Function f;
	private FunctionPlotter fp;
	
	public NumericalIntegralFinder(double a, double b, Function f) {
		this.a = a;
		this.b= b;
		this.f = f;
		fp= new FunctionPlotter(this.f, this.a, this.b);
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public Function getF() {
		return f;
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
			area+= interval * this.f.calculate(x);
			
			// graphics
			firstPoint = new GPoint((float) (x-interval), 0);
			this.fp.addLine(secondPoint, firstPoint, Color.BLUE);
			secondPoint = new GPoint((float) x, (float) this.f.calculate(x));
			this.fp.addLine(firstPoint, secondPoint, Color.BLUE);
			
			x+=interval;
		}
		
		return area;
		
	}
	
	
	
}
