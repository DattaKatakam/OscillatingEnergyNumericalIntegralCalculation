package homework1;

import org.mariuszgromada.math.mxparser.Function;
import grafica.GPoint;
import processing.core.PApplet;
import java.awt.Color;

public class NumericalIntegralInterpolate {
	
	private double a;
	private double b;
	private static final double interval = 2;
	private static final double interpol=1e-4;
	private Function f;
	
	public static double getInterval() {
		return interval;
	}

	private FunctionPlotter fp;
	
	public NumericalIntegralInterpolate(double a, double b, Function f) {
		this.a=a;
		this.b=b;
		this.f=f;
		fp = new FunctionPlotter(this.f, this.a, this.b);
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
		
		while(x<=b) {
			area+= interpolateFx(x);
			x+=interval;
		}
		
		return area;
		
	}
	
	public double interpolateFx(double x) {
		double x2=x;
		double x1=x2-interval;
				
		double ip = x1+interpol;
		double area=0;
		while(x1<x2) {
						
			area+= (ip-x1)*( this.f.calculate(x1) +  (ip-x1)*(this.f.calculate(x2)-this.f.calculate(x1))/(x2-x1));
			
			// graphics
			GPoint firstPoint = new GPoint((float) x1, 0);
			GPoint secondPoint = new GPoint((float) ip, (float) this.f.calculate(ip));
			this.fp.addLine(firstPoint, secondPoint, Color.BLUE);
			
			x1=ip;
			ip+=interpol;
		}
		
		return area;
		
	}
	
	
}
