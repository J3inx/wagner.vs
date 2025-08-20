package ColourChanges;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SwappingColours extends JFrame implements ActionListener, ChangeListener{
	 JLabel pictureLabel;
	 BufferedImage image;
	 JSlider redSlider;
	 JTextArea colorArea;
	 public static void main(String [] args) {
		 SwappingColours gui = new SwappingColours();
		 gui.setVisible(true);
	 }
	 public SwappingColours() {
		 setTitle("swapping colors");
		 setSize(400,400);
		 setDefaultCloseOperation(3);
		 setLayout(null);
		 File input = new File("AoS.jpg");
		 image = null;
		 try {
			 image = ImageIO.read(input);
		 }
		 catch(IOException e){
			 System.out.println("file not found");
		 }
		 ImageIcon icon = new ImageIcon(image);
		 pictureLabel = new JLabel(icon);
		 pictureLabel.setBounds(50,60,300,300);
		 add(pictureLabel);
		 JButton swapButton = new JButton("swap");
		 swapButton.addActionListener(this);
		 swapButton.setBounds(10,10,100,25);
		 swapButton.setVisible(true);
		 add(swapButton);
		 redSlider = new JSlider(0,250);
		 	redSlider.addChangeListener(this);
		 	redSlider.setMajorTickSpacing(25);
		 	redSlider.setPaintTicks(true);
		 	//redSlider.setSnapToTicks(true);
		 	redSlider.setBounds(10,20,300,50);
		 add(redSlider);
		 colorArea = new JTextArea();
		 	colorArea.setBounds(300,30,30,20);
		 	colorArea.setEditable(false);
		 	colorArea.setText("null");
		 add(colorArea);
	 }
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		int red = redSlider.getValue();
		Integer Red = red;
		colorArea.setText(Red.toString());
		for(int width = 0; width <300; width++) {
			for(int height = 0; height < 300; height ++) {
				Color now = new Color(image.getRGB(width, height));
				
				int g = now.getGreen();
				int b = now.getBlue();
				Color newC = new Color(red,g,b);
				image.setRGB(width, height, newC.getRGB());
				
			}
		}
		ImageIcon i2 = new ImageIcon(image);
		pictureLabel.setIcon(i2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("swap")) {
			for(int width = 0; width <300; width++) {
				for(int height = 0; height < 300; height ++) {
					Color now = new Color(image.getRGB(width, height));
					int r = now.getRed();
					int g = now.getGreen();
					int b = now.getBlue();
					Color newC = new Color(g,b,r);
					image.setRGB(width, height, newC.getRGB());
					
				}
			}
			ImageIcon i2 = new ImageIcon(image);
			pictureLabel.setIcon(i2);
		}
	}

}
