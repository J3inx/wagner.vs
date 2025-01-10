package GamesWithObjects;

public class Ball {
	//global variables-chracteristics or a ball
		private int xSpeed, ySpeed;
		private int xPos, yPos;
		private int red, blue, green;
		private String name;
		//constructor method
		public Ball() {
			xSpeed = 1;
			ySpeed = 1;
			xPos = (int)(Math.random()*800);
			yPos = 400;
			red = (int)(Math.random()*256);
			blue = (int)(Math.random()*256);
			green = (int)(Math.random()*256);
		}
		public int getXpos() {
			xPos = xPos + xSpeed;
			if(xPos >= 800) {
				xSpeed = xSpeed*-1;
			}
			if(xPos <= 0) {
				xSpeed = xSpeed*-1;
			}

			return xPos;
		}
		public int getYpos() {
			yPos = yPos + ySpeed;
			if(yPos >= 750) {
				ySpeed = ySpeed*-1;
			}
			if(yPos <= 0) {
				ySpeed = (int)(Math.random()*5+1);
				if(yPos >= 780) {
				ySpeed = -1*(int)(Math.random()*5+1);
			}
			}

			return yPos;
		}
		public int getRed() {
			return red;
		}
		public int getGreen() {
			return green;
		}
		public int getBlue() {
			return blue;
		}
		public int setYspeed(int x) {
			ySpeed = ySpeed*x;
			return ySpeed;
		}

		

}
