package agario;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TurtleBullet {
	public Image turtle;
	int xPos = 230;
	int yPos = 230;
	int ySpeed;
	int xSpeed;
	
		public  TurtleBullet(int xPos, int yPos) {
			try {
		 turtle = ImageIO.read(new File("box.png"));
				}catch (IOException e){
					e.printStackTrace();
					System.out.println("image not found");
					System.exit(404);
				}
			this.xPos = xPos;
			this.yPos = yPos;
			
	}

		public Image getTurtle() {
			return turtle;
		}

		public void setTurtle(Image turtle) {
			//TurtleBullet.turtle = turtle;
		}

		public int getxPos() {
			return xPos;
		}

		public void setxPos(int xPos) {
			this.xPos = xPos;
		}

		public int getyPos() {
			return yPos;
		}

		public void setyPos(int yPos) {
			this.yPos = yPos;
		}

		public int getySpeed() {
			return ySpeed;
		}

		public void setySpeed(int ySpeed) {
			this.ySpeed = ySpeed;
		}

		public int getxSpeed() {
			return xSpeed;
		}

		public void setxSpeed(int xSpeed) {
			this.xSpeed = xSpeed;
		}
}
