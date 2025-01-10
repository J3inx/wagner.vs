package Photoshop;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class greenscreen extends JFrame implements ActionListener{
	private JLabel pictureLabel;
	private File file1 = new File("jerma.jpeg");
	private BufferedImage image1 = ImageIO.read(file1);
	private Icon icon1 = new ImageIcon(image1);
	private File file2 = new File("meridian.jpeg");
	private BufferedImage image2 = ImageIO.read(file2);
	private Icon icon2 = new ImageIcon(image2);
	public static void main(String [] args) throws IOException {
		greenscreen gui = new greenscreen();
		gui.setVisible(true);
	}
	public greenscreen() throws IOException{
		super("Greenscreen Shenanigans");
		setSize(1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		 pictureLabel = new JLabel("Words");
		pictureLabel.setBounds(10,20,400,400);
		pictureLabel.setVisible(true);
		add(pictureLabel);
		JButton pictButton = new JButton("Suprise Jerma");
		pictButton.setBounds(475,55,150,25);
		pictButton.setVisible(true);
		pictButton.addActionListener(this);
		add(pictButton);
		pictureLabel.setIcon(icon2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Suprise Jerma")) {
			pictureLabel.setIcon(icon1);
			for(int x = 0; x<image1.getWidth(); x++) {
				for(int y=0; y<image1.getHeight(); y++) {
					Color was = new Color(image1.getRGB(x, y));
					int r = (int)(was.getRed());					
					int g= (int) (was.getGreen());
					int b = (int)(was.getBlue());
					Color newb = new Color(image2.getRGB(x, y));
				
						if(g >= 190) {
						
								image1.setRGB(x, y, newb.getRGB());
							}
						}
						
					
				
				}
		}
	}
}
