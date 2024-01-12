package homework1;

public class errorAbsRel {
	private double DELTA;
	private double absVal;
	private double val;
	private double relErr;
	
	public errorAbsRel(double absVal, double val) {
		this.absVal=absVal;
		this.val=val;
		this.DELTA = Math.abs(this.absVal - this.val);
		
		this.relErr=this.DELTA/this.absVal;
	}
	
	
	//setter method to set absolute value
	public void setAbsVal(double absVal) {
		this.absVal=absVal;
	}
	
	//setter method to set integrated value from program
	public void setVal(double val) {
		this.val=val;
	}
	
	public void AbsError() {
		this.DELTA = this.absVal-this.val;
		System.out.println("Absolute error for value wrt 20 sec"+Math.abs(DELTA));
	}
	
	public void RelError() {
		this.relErr = this.DELTA/this.val;
		System.out.println("Relative error for value wrt 20 sec"+Math.abs(relErr));
	}
	
	
	
}
