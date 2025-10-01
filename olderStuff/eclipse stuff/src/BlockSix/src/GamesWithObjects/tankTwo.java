package GamesWithObjects;

public class tankTwo {
	//global variables
		private int xWheelPos, yWheelPos, xWheelSpeed, yWheelSpeed;
		//constructor
		public tankTwo() {
			xWheelPos=150;
			yWheelPos=500;
			xWheelSpeed = 0;
			yWheelSpeed = 0;
			
		}
		public int getXwheelPos() {
			return xWheelPos;
		}
		public int getYwheelPos() {
			return yWheelPos;
		}
		public void setXwheelSpeed(int speed) {
			xWheelPos += speed;
		}
		public void setYwheelSpeed(int speed) {
			yWheelPos += speed;
		}
	}
