package superMeatBoy;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Game extends JPanel{
	MeatBoy mb = new MeatBoy();
	public void gameLogic() {
		
		
		
	}
	public void paint(Graphics p) {
		
		p.setColor(Color.red);
		p.fillRect(mb.getxPos(),mb.getyPos(),mb.getWidth(),mb.getHeight());
	}

}
