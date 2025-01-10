package Photoshop;

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

public class swapPictures extends JFrame implements ActionListener {
	File file1 = new File("heart.jpeg");
	File file2 = new File("duodenum.jpeg");
	BufferedImage image1 = ImageIO.read(file1);
	BufferedImage image2 = ImageIO.read(file2);
	JLabel pictures;
	
	public static void main(String[] args) throws IOException {
		swapPictures gui = new swapPictures();
		gui.setVisible(true);
	}
	public swapPictures() throws IOException {
		super("Swap internal organs");
		setSize(1000,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		ImageIcon icon = new ImageIcon(image1);
		pictures = new JLabel(icon);
		pictures.setBounds(100,15,600,400);
		add(pictures);
		JButton switchButton = new JButton("EVE");
		switchButton.setBounds(10,15,100,25);
		switchButton.addActionListener(this);
		add(switchButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("EVE")) {
			int x = (int)(Math.random()*10);
			if(x<5) {
				ImageIcon icon = new ImageIcon(image1);
				pictures.setIcon(icon);
			}else {
				ImageIcon icon = new ImageIcon(image2);
				pictures.setIcon(icon);
			}
		}
	}

}
