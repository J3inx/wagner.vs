package Notes;

public class abstractClass {
//primitive data type: smallest level of data that the language can work with
	public static void main(String [] args) {
		Shape [] shapes = new Shape[4];
		shapes[0] = new Rectangle(10.0,12.0);
		System.out.println(shapes[0].getArea());
	}
	
}

abstract class Shape {
public abstract double getArea();
public abstract double getPerimeter();
}

class Rectangle extends Shape{
	private double width, height;
	public Rectangle(double width, double height){
		this.width = width;
		this.height = height;
		
		}
	public double getPerimeter() {
		return width*height;
	}
	public double getArea() {
		return 2*width+2*height;
	}
}


