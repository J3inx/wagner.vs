package Photoshop;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PictureMerge extends JFrame implements ActionListener{
	private JLabel pictureLabel;
	private File file1 = new File("shovel.jpeg");
	private BufferedImage image1 = ImageIO.read(file1);
	private Icon icon1 = new ImageIcon(image1);
	private File file2 = new File("hurdler.jpeg");
	private BufferedImage image2 = ImageIO.read(file2);
	private Icon icon2 = new ImageIcon(image2);
	private File file3 = new File("smilingbucktooth.png");
	private BufferedImage image3 = ImageIO.read(file3);
	private Icon icon3 = new ImageIcon(image3);
	private int rs,gs,bs;
	public static void main(String [] args) throws IOException {
		PictureMerge gui = new PictureMerge();
		gui.setVisible(true);
	}
	public PictureMerge() throws IOException{
		super("Paul and his knee");
		setSize(1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		 pictureLabel = new JLabel("Words");
		pictureLabel.setBounds(10,20,400,400);
		pictureLabel.setVisible(true);
		add(pictureLabel);
		JButton pictButton = new JButton("broken knee");
		pictButton.setBounds(475,55,150,25);
		pictButton.setVisible(true);
		pictButton.addActionListener(this);
		add(pictButton);
		JButton pictoButton = new JButton("hurdler");
		pictoButton.setBounds(475,20,150,25);
		pictoButton.setVisible(true);
		pictoButton.addActionListener(this);
		add(pictoButton);
		JButton pictaButton = new JButton("More Red");
		pictaButton.setBounds(475, 90,150,25);
		pictaButton.setVisible(true);
		pictaButton.addActionListener(this);
		add(pictaButton);
		JButton pictohButton = new JButton("More Blue");
		pictohButton.setBounds(475, 120,150,25);
		pictohButton.setVisible(true);
		pictohButton.addActionListener(this);
		add(pictohButton);
		JButton pictahButton = new JButton("More Green");
		pictahButton.setBounds(475, 150,150,25);
		pictahButton.setVisible(true);
		pictahButton.addActionListener(this);
		add(pictahButton);
		JButton pictahshButton = new JButton("grayscale");
		pictahshButton.setBounds(475, 180,150,25);
		pictahshButton.setVisible(true);
		pictahshButton.addActionListener(this);
		add(pictahshButton);
		JButton pictahsButton = new JButton("original photo 1");
		pictahsButton.setBounds(475, 210,150,25);
		pictahsButton.setVisible(true);
		pictahsButton.addActionListener(this);
		add(pictahsButton);
		JButton pictahshaButton = new JButton("original photo 2");
		pictahshaButton.setBounds(475, 240,150,25);
		pictahshaButton.setVisible(true);
		pictahshaButton.addActionListener(this);
		add(pictahshaButton);
		JButton pictahshsButton = new JButton("original photo 3");
		pictahshsButton.setBounds(475, 270,150,25);
		pictahshsButton.setVisible(true);
		pictahshsButton.addActionListener(this);
		add(pictahshsButton);
		JButton merge = new JButton("merge 1&2");
		merge.setBounds(475, 300,150,25);
		merge.setVisible(true);
		merge.addActionListener(this);
		add(merge);
		JButton merger = new JButton("merge 2&3");
		merger.setBounds(475, 330,150,25);
		merger.setVisible(true);
		merger.addActionListener(this);
		add(merger);
		JButton merged = new JButton("merge 1&3");
		merged.setBounds(475, 360,150,25);
		merged.setVisible(true);
		merged.addActionListener(this);
		add(merged);
		ArrayList <Integer> red = new ArrayList<>();
		ArrayList <Integer> blue = new ArrayList<>();
		ArrayList <Integer> green = new ArrayList<>();

		for(int x = 0; x<image1.getWidth(); x++) {
			for(int y=0; y<image1.getHeight(); y++) {
				Color was = new Color(image1.getRGB(x, y));
				 rs = (int)(was.getRed());					
				 gs= (int) (was.getGreen());
				 bs = (int)(was.getBlue());
				red.add(x,rs);
				blue.add(x,bs);
				green.add(x,gs);
			}
			}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("broken knee")) {
			pictureLabel.setIcon(icon1);
		}else if(e.getActionCommand().equals("hurdler")){
			pictureLabel.setIcon(icon2);
			
		}else if(e.getActionCommand().equals("More Red")) {
			for(int x = 0; x<image1.getWidth(); x++) {
				for(int y=0; y<image1.getHeight(); y++) {
					Color was = new Color(image1.getRGB(x, y));
					int r = (int)(was.getRed());					
					int g= (int) (was.getGreen());
					int b = (int)(was.getBlue());
					//System.out.println(x+" " + y + " red: " + r + " green: " + g + " blue: " + b);
					if(r< 245) {
						r+=10;
						if(r+g+(b+10) == 255) {
							r = 0;
						}
						}
					Color now = new Color(r,g,b);
					image1.setRGB(x, y,now.getRGB());
					
				}
				icon1 = new ImageIcon(image1);
				pictureLabel.setIcon(icon1);
			}
		}else if(e.getActionCommand().equals("More Blue")) {
			for(int x = 0; x<image1.getWidth(); x++) {
				for(int y=0; y<image1.getHeight(); y++) {
					Color was = new Color(image1.getRGB(x, y));
					int r = (int)(was.getRed());					
					int g= (int) (was.getGreen());
					int b = (int)(was.getBlue());
					//System.out.println(x+" " + y + " red: " + r + " green: " + g + " blue: " + b);				
					if(b< 245) {
						b+=10;
						if(r+g+(b+10) == 255) {
							b = 0;
						}
						}
					Color now = new Color(r,g,b);
					image1.setRGB(x, y,now.getRGB());
					
				}
				icon1 = new ImageIcon(image1);
				pictureLabel.setIcon(icon1);
			}
		}else if(e.getActionCommand().equals("More Red")) {
			for(int x = 0; x<image1.getWidth(); x++) {
				for(int y=0; y<image1.getHeight(); y++) {
					Color was = new Color(image1.getRGB(x, y));
					int r = (int)(was.getRed());					
					int g= (int) (was.getGreen());
					int b = (int)(was.getBlue());
					//System.out.println(x+" " + y + " red: " + r + " green: " + g + " blue: " + b);
					if((r+10)+g+b == 255) {
						r = 0;
					}
					if(r< 244) {
						r+=10;
						}
					Color now = new Color(r,g,b);
					image1.setRGB(x, y,now.getRGB());
					
				}
				icon1 = new ImageIcon(image1);
				pictureLabel.setIcon(icon1);
			}
				}else if(e.getActionCommand().equals("More Green")) {
			for(int x = 0; x<image1.getWidth(); x++) {
				for(int y=0; y<image1.getHeight(); y++) {
					Color was = new Color(image1.getRGB(x, y));
					int r = (int)(was.getRed());					
					int g= (int) (was.getGreen());
					int b = (int)(was.getBlue());
					//System.out.println(x+" " + y + " red: " + r + " green: " + g + " blue: " + b);
					if(g< 245) {
						g+=10;
						if(r+g+(b+10) == 255) {
							g = 0;
						}
						}
					Color now = new Color(r,g,b);
					image1.setRGB(x, y,now.getRGB());
					
				}
				icon1 = new ImageIcon(image1);
				pictureLabel.setIcon(icon1);
			}
		}else if(e.getActionCommand().equals("original photo 1")) {
			  try {
				image1 = ImageIO.read(file1);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  icon1 = new ImageIcon(image1);
				pictureLabel.setIcon(icon1);
			  
		}else if(e.getActionCommand().equals("grayscale")) {
			for(int x = 0; x<image1.getWidth(); x++) {
				for(int y=0; y<image1.getHeight(); y++) {
					Color was = new Color(image1.getRGB(x, y));
					int r = (int)(was.getRed());					
					int g= (int) (was.getGreen());
					int b = (int)(was.getBlue());
					
					int gray = (r+g+b)/3;
					Color now = new Color(gray, gray, gray);
					image1.setRGB(x, y, now.getRGB());
				}
			}
			 icon1 = new ImageIcon(image1);
				pictureLabel.setIcon(icon1);
				}else if(e.getActionCommand().equals("original photo 2")) {
			  try {
				image2 = ImageIO.read(file2);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  icon2 = new ImageIcon(image2);
				pictureLabel.setIcon(icon2);
				}else if(e.getActionCommand().equals("original photo 3")) {
			  try {
				image3 = ImageIO.read(file3);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  icon3 = new ImageIcon(image3);
				pictureLabel.setIcon(icon3);
	}else if(e.getActionCommand().equals("merge 1&2")) {
			pictureLabel.setIcon(icon1);
		for(int x = 0; x<image1.getWidth(); x++) {
			for(int y=0; y<image1.getHeight(); y++) {
				Color was = new Color(image2.getRGB(x, y));
				if(y%2 == 0) {
					image1.setRGB(x, y, was.getRGB());
				}
			}
		}
		icon1 = new ImageIcon(image1);
		pictureLabel.setIcon(icon1);
	}else if(e.getActionCommand().equals("merge 2&3")) {
		pictureLabel.setIcon(icon2);
	for(int x = 0; x<image2.getWidth(); x++) {
		for(int y=0; y<image2.getHeight(); y++) {
			Color was = new Color(image3.getRGB(x, y));
			if(y%2 == 0) {
				image2.setRGB(x, y, was.getRGB());
			}
		}
	}
	icon2 = new ImageIcon(image2);
	pictureLabel.setIcon(icon2);

	}else if(e.getActionCommand().equals("merge 1&3")) {
			pictureLabel.setIcon(icon1);
		for(int x = 0; x<image1.getWidth(); x++) {
			for(int y=0; y<image1.getHeight(); y++) {
				Color was = new Color(image3.getRGB(x, y));
				if(y%2 == 0) {
					image1.setRGB(x, y, was.getRGB());
				}
			}
		}
		icon1 = new ImageIcon(image1);
		pictureLabel.setIcon(icon1);
	}
		
}
}	
		
	


