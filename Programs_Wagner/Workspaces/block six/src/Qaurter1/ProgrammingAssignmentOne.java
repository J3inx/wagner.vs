package Qaurter1;

public class ProgrammingAssignmentOne {
	public static void main(String [] args)
	{
		double num1 =  Math.round(100*Math.random());
		double num2 =  Math.round(100*Math.random());
		double num3 =  Math.round(100*Math.random());
		double num4 =  Math.round(100*Math.random());
		double num5 = (num1+num2+num3+num4);

		System.out.println("the average of :" + num1 + ", " + num2 + ", " + num3 + "," + num4 + ", is: " + (num5/4));
		
		double numl = Math.round(10*Math.random());
		double numk = Math.round(10*Math.random());
		double Badd = (numl+numk);
		double bubtract = (numl-numk);
		double bivide = (numl/numk);
		double bultiply = (numl*numk);
		System.out.println(numl + " + " + numk + " = " + Badd);
		System.out.println(numl + " - " + numk + " = " + bubtract);
		System.out.println(numl + " / " + numk + " = " + bivide);
		System.out.println(numl + " x " + numk + " = " + bultiply);
		
		
		double far1 = Math.round(100*Math.random());
		double far = (far1+30);
		
		double stepTwo = (far-32);
		double stepThree = 0.55555555555;
		double stepFour = Math.round(stepTwo*stepThree);

		System.out.println("farenheit = " + far + " so celsius must be around: " + stepFour + " celsius");
		System.out.println("if celsius = " + stepFour + " then farenheit mus be " + far);
		
		double miles = Math.round(100*Math.random());
		double km = (miles*1.60934);
		System.out.println("if miles = " + miles + " then km must be " + km);
	}

}
