package exampleIA;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class gamesGUI extends JFrame implements ActionListener{
	public String [] games = {"", "hi-low", "blackjack", "3 card poker", "yahtzee"};
	public JComboBox gameBox;
	public JButton selectGameButton, exitButton, hiButton, lowButton, hlStartButton, submitButton, BjHit, BjStand;
	public JTextArea gameBoard, respondBoard;
	public String choice = "";
	public aHiLowGame hlGame = new aHiLowGame(this);
	public blackJackie BJ;
	public int card = -1;
	public gamesGUI() {
	    super("games with cards");
	    setSize(800,600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(null);

	    
	    gameBox = new JComboBox(games);
	    gameBox.setVisible(true);
	    gameBox.setBounds(10,40,100,25);
	    add(gameBox);

	    selectGameButton = new JButton("select Game");
	    selectGameButton.setVisible(true);
	    selectGameButton.setBackground(Color.PINK);
	    selectGameButton.setBounds(10,70,100,25);
	    selectGameButton.addActionListener(this);
	    add(selectGameButton);

	    
	    submitButton = new JButton("submit");
	    submitButton.setVisible(false);
	    submitButton.setBackground(Color.GREEN);
	    submitButton.setBounds(600,300,200,20);
	    submitButton.addActionListener(this); 
	    add(submitButton);

	    
	    gameBoard = new JTextArea(1,1);
	    gameBoard.setVisible(true);
	    gameBoard.setBackground(Color.pink);
	    gameBoard.setBounds(110,10,400,400);
	    gameBoard.setLineWrap(true);
	    gameBoard.setEditable(false);
	    add(gameBoard);
	    respondBoard = new JTextArea(1,1);
	    respondBoard.setVisible(true);
	    respondBoard.setBackground(Color.pink);
	    respondBoard.setBounds(110,430,400,30);
	    respondBoard.setEditable(true);
	    add(respondBoard);
	    BJ = new blackJackie(this);
	    
	    exitButton = new JButton("exit");
	    exitButton.setVisible(true);
	    exitButton.setBackground(Color.pink);
	    exitButton.setBounds(10,10,100,25);
	    exitButton.addActionListener(this);
	    add(exitButton);

	    hiButton = new JButton("higher");
	    hiButton.setVisible(false);
	    hiButton.setForeground(new Color(55,75,250));
	    hiButton.setBounds(600,350,200,20);
	    hiButton.addActionListener(this);
	    add(hiButton);

	    lowButton = new JButton("lower");
	    lowButton.setVisible(false);
	    lowButton.setForeground(new Color(55,75,250));
	    lowButton.setBounds(600,400,200,20);
	    lowButton.addActionListener(this);
	    add(lowButton);

	    hlStartButton = new JButton("start game");
	    hlStartButton.setVisible(false);
	    hlStartButton.setForeground(new Color(55,75,250));
	    hlStartButton.setBounds(600,300,200,20);
	    hlStartButton.addActionListener(this);
	    add(hlStartButton);
	    BjHit = new JButton("hit");
	    BjHit.setVisible(false);
	    BjHit.setForeground(new Color(55,75,250));
	    BjHit.setBounds(600,350,200,20);
	    BjHit.addActionListener(this);
	    add(BjHit);
	    BjStand = new JButton("stand");
	    BjStand.setVisible(false);
	    BjStand.setForeground(new Color(55,75,250));
	    BjStand.setBounds(600,400,200,20);
	    BjStand.addActionListener(this);
	    add(BjStand);
	}

	public void showHiLoButtons(boolean show) {
	    hiButton.setVisible(show);
	    lowButton.setVisible(show);
	    hlStartButton.setVisible(true);
	   
	}

	public void actionPerformed(ActionEvent e) {
		//clearing the board is bugged
	
		String rst = e.getActionCommand();
		if(e.getActionCommand().equals("submit")) {
			submitButton.setVisible(false);
			showHiLoButtons(true);
			hlGame.handleSubmitBet();
		}
		if(e.getActionCommand().equals("higher")) {
			hlGame.handleHiLoChoice("h");
		}
		if(e.getActionCommand().equals("lower")) {
			
			hlGame.handleHiLoChoice("l");
		}
		if(e.getActionCommand().equals("hit")) {
			gameBoard.setText("");
			System.out.println("Hit");
			BJ.Dealer(3);
			
		}
		if(e.getActionCommand().equals("stand")) {
			gameBoard.setText("");
			BJ.Dealer(4);
	
		
				
				
			
		}

		if(rst.equals("start game")) {
			if(choice == games[1]) {
				hlGame.starter();
				hlGame.HiLo();
				hiButton.setVisible(false);
				lowButton.setVisible(false);
				hlStartButton.setVisible(false);
				submitButton.setVisible(true);	
			}
			if(choice == games[2]) {
				
				BJ.playBJack();
				BjHit.setVisible(true);
				BjStand.setVisible(true);
				hlStartButton.setVisible(false);
			}
			
		}
		if(rst.equals("exit")) {
			System.exit(0);
		}
		if(rst.equals("select Game")) {
			choice = (String)gameBox.getSelectedItem();
			if(choice == games[1]) {
				//hi-low
				hilow();
			}else if(choice == games[2]) {
				blackjack();
			}else if(choice == games[3]) {
				threecardpoker();
			}else if(choice == games[4]) {
				yahtzee();
			}
		}
		
	}

	private void yahtzee() {
		gameBoard.setText(games[4]);
		while(choice == games[4]) {
			
		}
	}

	private void threecardpoker() {
		gameBoard.setText(games[3]);
while(choice == games[3]) {
			
		}
	}

	private void blackjack() {
		//gameBoard.setText(games[2]);
		BjHit.setVisible(false);
		BjStand.setVisible(false);
		hlStartButton.setVisible(true);
	}

	private void hilow() {
		//gameBoard.append(games[1]);
//while(choice == games[1]) {
			
	//	}
		
		hiButton.setVisible(false);
		lowButton.setVisible(false);
		hlStartButton.setVisible(true);
		submitButton.setVisible(false);
		
	}
	public void write(String input) {
		gameBoard.append(input + "\n");
	}
	public void write(String input, boolean NL) {
		gameBoard.append(input + " ");
	}
	public String respond() {
		String response = respondBoard.getText();
		respondBoard.setText("");
		
		return(response);
	}
	public String getAnswer(String input, boolean choice) {
		String rocker = null;
		if(choice == true) {
			rocker = input;
			return ("blah");
		}else {
			
			return input;
		}
		
	}

}
