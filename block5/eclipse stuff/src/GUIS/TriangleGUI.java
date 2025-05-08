package GUIS;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
	
public class TriangleGUI extends JFrame implements ActionListener{
	private JPanel box;
	private JButton drawButton;
	public static void main(String [] args) {
		TriangleGUI gui = new TriangleGUI();
		gui.setVisible(true);
		
		}
	public TriangleGUI() {
		setSize(500,400);
		setTitle("triangle identifier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JButton drawButton = new JButton("START");
			drawButton.setForeground(Color.blue);
			drawButton.addActionListener(this);
			drawButton.setBounds(10,10,75,25);
		add(drawButton);
		JButton triButton = new JButton("Draw Triangle");
		triButton.setForeground(Color.blue);
		triButton.addActionListener(this);
		triButton.setBounds(80,10,125,25);
		add(triButton);
		box = new JPanel();
			box.setBackground(Color.blue);
			box.setBounds(40,40,415,305);
		add(box);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("START")) {
			fillUP();
		}
		if(e.getActionCommand().equals("Draw Triangle")) {
			drawTri();
		}
	}
	public void fillUP() {
		Graphics g = box.getGraphics();
		//make 3 points
		//draw a triangle
		//tell me if the triangle is acute, right, or obtuse
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		g.setColor(new Color(red, green, blue));
		for(int top = 2; top<300; top +=5) {
			for(int left = 2; left < 410; left+=5) {
				g.fillOval(left,top,5,5);
				red = (int)(Math.random()*256);
				green = (int)(Math.random()*256);
				blue = (int)(Math.random()*256);
				g.setColor(new Color(red, green, blue));
				slowDown(1);
			}
		}
	}
	public void drawTri() {
		int point1x = (int)(Math.random()*410);
		int point1y = (int)(Math.random()*300);
		int point2x = (int)(Math.random()*410);
		int point2y = (int)(Math.random()*300);
		int point3x = (int)(Math.random()*410);
		int point3y = (int)(Math.random()*300);
		double magnA = (Math.sqrt(Math.pow((point1x-point2x),2)+ Math.pow((point1y-point2y),2)));
		double magnb = (Math.sqrt(Math.pow((point2x-point3x),2)+ Math.pow((point2y-point3y),2)));
		int doProduct = (point1x *point1y) + (point2x*point2y);
		System.out.println(doProduct / (magnA * magnb));
		Graphics g = box.getGraphics();
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		g.setColor(new Color(red, green, blue));
		g.fillOval(point1x-1, point1y, 5,5);
		g.fillOval(point2x-1, point2y, 5,5);
		g.fillOval(point3x-1, point3y, 5,5);
		g.drawLine(point1x-1, point1y+2, point2x-1,point2y+2);
		g.drawLine(point2x-1, point2y+2, point3x-1,point3y+2);
		g.drawLine(point1x-1, point1y+2, point3x-1,point3y+2);
		if((doProduct / (magnA * magnb))%1 == 0) {
			System.out.println("right");
		}else if(doProduct / (magnA * magnb)>10) {
			System.out.println("obtuse");
			
		}else if(doProduct / (magnA * magnb) < 10){
			System.out.println("acute");
		}
		
	}
	public void slowDown(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		}
		catch(InterruptedException e){
			System.out.println("a colin like error has occured (not my fault)");
			System.exit(0);
		}
	}
}
