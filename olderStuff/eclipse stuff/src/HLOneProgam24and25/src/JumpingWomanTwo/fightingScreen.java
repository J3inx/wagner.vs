package JumpingWomanTwo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class fightingScreen extends JPanel implements KeyListener {
    static Woman hannah = new Woman();
    static Woman sofia = new Woman();
    private static int Shealth = 100;
    private static int SoldPos, HoldPos, SoldY, HoldY;
    private static int Hhealth = 100;
    private int SswordX, SswordY,HswordX, HswordY;
    private static int Sjumped = 0;
    private static int Hjumped = 0;
    private boolean damagedS = false;
    private boolean damagedH = false;
    private static boolean Ssword;
	private static boolean Hsword;
    private static boolean aPressed, dPressed, leftPressed, rightPressed, Hmove, Smove;
    private boolean bleedS = false;
    private static int SendPos, HendPos;
    private static boolean Hthrow, Sthrow;
    private boolean bleedH = false;
    private int rock = 0;
    private static int HBlockX, HBlockY, SBlockX, SBlockY;
    private static boolean Sblock, Hblock;
    private int SofiaThrowDirection = 1, HannahThrowDirection = 1;

    public static void main(String[] args) throws InterruptedException{
        JFrame gui = new JFrame();
        fightingScreen game = new fightingScreen();
        gui.add(game);
        gui.setSize(800, 800);
        gui.setTitle("Hannah vs Sofia");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        game.addKeyListener(game);
        game.setFocusable(true);
        game.requestFocusInWindow();
        int temp = 0;
        while (true) {
            game.repaint();
            Thread.sleep(30);
            game.movementH();  
            game.movementS();
            game.collisions();
            if(Hhealth <0 || Shealth <0) {
            	aPressed = false;
            	dPressed = false;
            	leftPressed = false;
            	rightPressed = false;
            	sofia.setxVelocity(0);
            	hannah.setxVelocity(0);
            	sofia.setyVelocity(0);
            	hannah.setyVelocity(0);
            	if(temp == 0) {
            	SendPos = sofia.getxPos();
            	
            	HendPos = hannah.getxPos();
            	}
            	temp++;
            	sofia.setxPos(SendPos);
            	hannah.setxPos(HendPos);
            	Sjumped = 1;
            	Hjumped = 1;
            	Ssword = false;
            	Hsword = false;
            	
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, 800, 800);
        g.setColor(new Color(hannah.getRed(), hannah.getGreen(), hannah.getBlue()));
        g.fillRect(hannah.getxPos(), hannah.getyPos(), 25, 25);
        g.setColor(new Color(sofia.getRed(), sofia.getGreen(), sofia.getBlue()));
        g.fillRect(sofia.getxPos(), sofia.getyPos(), 25, 25);
        g.setColor(Color.GREEN);
        g.fillOval(-300, 500, 1500, 900);
        g.setColor(Color.RED);
        g.fillRect(10, 10, Shealth, 20);
        g.fillRect(10, 70, Hhealth, 20);
        g.setColor(Color.WHITE);
        g.fillRect(0, 400, 300, 800);
        g.fillRect(600, 400, 350, 800);
        if (Sthrow) {
            g.setColor(Color.YELLOW);
            g.fillRect(SoldPos, SoldY, 20, 20);
            SoldPos += 10 * SofiaThrowDirection;
            if (SoldPos > 800 || SoldPos < 0) {
                Sthrow = false;
                
            }
        }
        if (Hthrow) {
            g.setColor(Color.ORANGE);
            g.fillRect(HoldPos, HoldY, 20, 20);
            HoldPos += 10 * HannahThrowDirection;
            if (HoldPos > 800 || HoldPos < 0) {
                Hthrow = false;
                
            }
        }
        if(Sblock) {
        	g.setColor(Color.green);
        	if(sofia.getxPos()<hannah.getxPos()) {
            	g.fillRect(sofia.getxPos()+40,sofia.getyPos(), 10, 30);
            	SBlockX = sofia.getxPos()+40;
            	SBlockY = sofia.getyPos();
            	}else {
            		g.fillRect(sofia.getxPos()-40,sofia.getyPos(), 10, 30);
            		SBlockX = sofia.getxPos()-40;
                	SBlockY = sofia.getyPos();
        }
        }
        if(Hblock) {
        	g.setColor(Color.green);
        	if(hannah.getxPos()<sofia.getxPos()) {
            	g.fillRect(hannah.getxPos()+40,hannah.getyPos(), 10, 30);
            	HBlockX = hannah.getxPos()+40;
            	HBlockY = hannah.getyPos();
            	}else {
            		g.fillRect(hannah.getxPos()-40,hannah.getyPos(), 10, 30);
            		HBlockX = hannah.getxPos()-40;
                	HBlockY = hannah.getyPos();
        }
        }
        
        if(bleedS== true) {
        	Shealth = -1;
        	g.setColor(Color.RED);
        	
        		g.fillRect(sofia.getxPos()+(int)(Math.random()*30)+1, sofia.getyPos()+(int)(Math.random()*20)+1, 20, 20);
   
        	
        }
        if(bleedH== true) {
        	Hhealth = -1;
        	g.setColor(Color.RED);
        	
        		g.fillRect(hannah.getxPos()+(int)(Math.random()*30)+1, hannah.getyPos()+(int)(Math.random()*20)+1, 20, 20);
   
        	
        }
        if(Ssword) {
        	g.setColor(Color.white);
        	if(sofia.getxPos()<hannah.getxPos()) {
        	g.fillRect(sofia.getxPos()+40,sofia.getyPos()+10, 20, 5);
        	HswordX = sofia.getxPos()+40;
        	HswordY = sofia.getyPos()+10;
        	}else {
        		g.fillRect(sofia.getxPos()-40,sofia.getyPos()+10, 20, 5);
        		HswordX = sofia.getxPos()-40;
            	HswordY = sofia.getyPos()+10;
        	}
        }
       
        if(Hsword) {
        	g.setColor(Color.white);
        	if(hannah.getxPos()<sofia.getxPos()) {
        	g.fillRect(hannah.getxPos()+40,hannah.getyPos()+10, 20, 5);
        	SswordX = hannah.getxPos()+40;
        	SswordY = hannah.getyPos()+10;
        	}else {
        		g.fillRect(hannah.getxPos()-40,hannah.getyPos()+10, 20, 5);
        		SswordX = hannah.getxPos()-40;
            	SswordY = hannah.getyPos()+10;
        	}
        }
        
    }

    public void movementH() {
        int yo = hannah.getyPos();
        hannah.setyPos(yo += hannah.getyVelocity());
        int oldVel = hannah.getyVelocity();
        hannah.setyVelocity(oldVel + 1);
        if(hannah.getxPos()>=775) {
        	hannah.setxPos(775);
        }
        if(hannah.getxPos()<=0) {
        	hannah.setxPos(1);
        }
        if (hannah.getyPos() >= 500) {
            hannah.setyVelocity((int) ((Math.random() * -21) - 10));
            setupH();
        }
        if(hannah.getxPos()<300) {
        	if(hannah.getyPos()>=380) {
        		Hjumped = 0;
        		hannah.setyPos(380);
        		//hannah.setyVelocity((int) ((Math.random() * -21) - 3));
           		if(Hjumped == 0) {
        			hannah.setyVelocity(0);	
        		}
        	}
        }
        if(hannah.getxPos()>600) {
        	if(hannah.getyPos()>=380) {
        		Hjumped = 0;
        		hannah.setyPos(380);
        		//hannah.setyVelocity((int) ((Math.random() * -21) - 3));
           		if(Hjumped == 0) {
        			hannah.setyVelocity(0);	
        		}
        		
        	}
        }
        
        if(aPressed) {
        	int oldxPos = hannah.getxPos();
        	hannah.setxPos(oldxPos -=10);
        }
        if(dPressed) {
			 int oldxPos = hannah.getxPos();
	            hannah.setxPos(oldxPos +=10);
        }
    }

    public void movementS() {
        int yo = sofia.getyPos();
        sofia.setyPos(yo += sofia.getyVelocity());
        int oldVel = sofia.getyVelocity();
        sofia.setyVelocity(oldVel + 1);
        if(sofia.getxPos()>=775) {
        	sofia.setxPos(775);
        }
        if(sofia.getxPos()<=0) {
        	sofia.setxPos(1);
        }
        
        if(sofia.getxPos()<300) {
        	if(sofia.getyPos()>=380) {
        		sofia.setyPos(380);
        		Sjumped = 0;
        		//sofia.setyVelocity((int) ((Math.random() * -21) - 3));
        		if(Sjumped == 0) {
        			sofia.setyVelocity(0);	
        		}
        		
        		
        		
        	}
        }
        if(sofia.getxPos()>600) {
        	if(sofia.getyPos()>=380) {
        		sofia.setyPos(380);
        		Sjumped = 0;
        		//sofia.setyVelocity((int) ((Math.random() * -21) - 3));
           		if(Sjumped == 0) {
        			sofia.setyVelocity(0);	
        		}
        		
        	}
        }
        if (sofia.getyPos() >= 500) {
            sofia.setyVelocity((int) ((Math.random() * -21) - 10));
            System.out.println("velocity: " + sofia.getyVelocity() + " position: " + sofia.getyPos());
            setupS();
        }
        
        if(leftPressed) {
        	int oldxPos = sofia.getxPos();
        	sofia.setxPos(oldxPos -=10);
        }
        if(rightPressed) {
			 int oldxPos = sofia.getxPos();
	            sofia.setxPos(oldxPos +=10);
        }
    }

    public void collisions() {
     
        if (Sthrow) {
        	if(Hblock && Math.abs(HBlockX - SoldPos) < 10 && Math.abs(HBlockY - SoldY) < 10) {
        		Sthrow = false;
        		damagedH = true;
        	}else if (Math.abs(hannah.getxPos() - SoldPos) < 10 && Math.abs(hannah.getyPos() - SoldY) < 10) {
                if (!damagedH) {
                    Hhealth -= 10;
                    Sthrow = false; 
                    damagedH = true; 
                }
        	
            }
        }

        
        if (Hthrow) {
        	if(Sblock && Math.abs(SBlockX - HoldPos) < 10 && Math.abs(SBlockY - HoldY) < 10) {
        		Hthrow = false;
        		damagedS = true;
        	}else if (Math.abs(sofia.getxPos() - HoldPos) < 10 && Math.abs(sofia.getyPos() - HoldY) < 10) {
                if (!damagedS) {
                    Shealth -= 10;
                    Hthrow = false; 
                    damagedS = true; 
                }
            }
        }

       
        if (SoldPos > 800 || SoldPos < 0) {
            Sthrow = false;
            damagedH = false; 
        }
        if (HoldPos > 800 || HoldPos < 0) {
            Hthrow = false;
            damagedS = false; 
        }

        
        if (Shealth <= 0) {
            bleedS = true;
        }
        if (Hhealth <= 0) {
            bleedH = true;
        }
    }

    		
    public void setupS() {
        sofia.setxPos((int) (Math.random() * 400 + 100));
        Shealth+=(int)(Math.random()*-20)-5;
    }

    public void setupH() {
        //hannah.setxPos((int) (Math.random() * 400 + 100));
    	//sets xpos to a random value after bouncing
        Hhealth+=(int)(Math.random()*-20)-5;
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		 if (e.getKeyChar() == 'a') {
			 aPressed = true;
			 Hmove = false;
	            
	        } else if (e.getKeyChar() == 'd') {
	        	dPressed = true;
	        	Hmove = true;
	        }else if(e.getKeyCode() == 32) {
	        	Hsword = true;
	        }else if(e.getKeyChar() == 'w') {
	        	if(Hjumped == 0) {
	        		Hjumped = 1;
	        		hannah.setyVelocity(-20);
	        			        		
	        	}
	        }else if(e.getKeyCode() == 37) {
	        	leftPressed = true;
	        }else if(e.getKeyCode() == 39) {
	        	rightPressed = true;
	        }else if(e.getKeyCode() == 38) {
	        	if(Sjumped == 0) {
	        		Sjumped = 1;
	        		sofia.setyVelocity(-20);
	        			        		
	        	}
	        	
	        }else if(e.getKeyCode()== 40) {
	        	Ssword = true;
	        }else if(e.getKeyChar() == 's'){
	        	if (Sthrow == false) {
	        	    SoldPos = sofia.getxPos();
	                SoldY = sofia.getyPos();
	                SofiaThrowDirection = (sofia.getxPos() <= hannah.getxPos()) ? 1 : -1;
	                Sthrow = true;
	            }
	        	} else if (e.getKeyCode() == 16) {
	                if (Hthrow== false) {
	                    HoldPos = hannah.getxPos();
	                    HoldY = hannah.getyPos();
	                    HannahThrowDirection = (hannah.getxPos() <= sofia.getxPos()) ? 1 : -1;
	                    Hthrow = true;
	                }
	            }else if(e.getKeyChar() == 'q') {
	            	//sofia
	            	Sblock = true;
	            }else if(e.getKeyChar() == 'p') {
	            	//hannah
	            	Hblock = true;
	            }
	        }
		
		 
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		 if (e.getKeyChar() == 'a') {
			 aPressed = false;
			 System.out.println("pressed");
			 
	            
	        } else if (e.getKeyChar() == 'd') {
	        	dPressed = false;
	        	
	        }else if(e.getKeyCode() == 32) {
	        	Hsword = false;
	        	damagedS = false;
	        }else if(e.getKeyCode() == 37) {
	        	leftPressed = false;
	        }else if(e.getKeyCode() == 39) {
	        	rightPressed = false;
	        }else if(e.getKeyCode() == 38) {
	        	
	        }else if(e.getKeyCode()== 40) {
	        	Ssword = false;
	        	damagedH = false;
	        }else if(e.getKeyChar() == 'q') {
            	//sofia
            	Sblock = false;
            }else if(e.getKeyChar() == 'p') {
            	//hannah
            	Hblock = false;
            }
	}
}
