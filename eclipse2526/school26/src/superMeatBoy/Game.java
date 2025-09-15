package superMeatBoy;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Game extends JPanel{
	MeatBoy mb = new MeatBoy();
	MeatBoy bl = new MeatBoy(300, 300, 30, 30);
	public void gameLogic() {
		
		
		
	}
	public void paint(Graphics p) {
		
		p.setColor(Color.red);
		p.fillRect(mb.getxPos(),mb.getyPos(),mb.getWidth(),mb.getHeight());
		p.setColor(Color.gray);
		p.fillRect(bl.getxPos(),bl.getyPos(),bl.getWidth(),bl.getHeight());
	}

}
