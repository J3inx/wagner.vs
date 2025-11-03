package Notes;




	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextArea;
	
	public class stocksGui extends JFrame  implements ActionListener {
		JLabel lowBound, highBound, results, stb, tots, totp, wallett;
		JTextArea highB, lowB, output, shares, totst, totpt, wallet;
		double low, high, priced;
		 static volatile String price = "0.0"; // shared between threads
		static boolean check;
		boolean checker;
		JButton refresh;
	
		int stocks =0;
		
		public static void main(String[] args) {
			stocksGui gui = new stocksGui();
			gui.setVisible(true);
			String apiKey = "0ad06c84cf75448e978c07035c1fba5b";
			String symbol = "AAPL";
			//String symbolTwo = "DIS";
			String interval = "1min";
	        Thread t1 = new stocker(symbol, interval, apiKey, gui);
			 t1.start();
			while(true) {
				try {
					String urlString = "https://api.twelvedata.com/time_series?symbol="+symbol+"&interval="+interval+"&apikey="+apiKey+"&outputsize=1";
					//String urlStringTwo = "https://api.twelvedata.come/time_series?symbol=" + symbolTwo + "&interval=" + interval+"&apiekey=" + apiKey + "&outputsize=1";
					URL url = new URL(urlString);
					//URL url2 = new URL(urlStringTwo);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					StringBuilder response = new StringBuilder();
					String line;
					while((line = in.readLine())!=null) {
						response.append(line);
						
					}
					in.close();
					String result = response.toString();
					//System.out.println(result);
					String searchPrice = "\"close\":\"";
					int start = result.indexOf(searchPrice);
					if(start!=-1) {
						start += searchPrice.length();
						int end = result.indexOf("\"", start);
						price = result.substring(start,end);
						System.out.println(symbol + "Price $" + price);
						check = true;
						
						
						
					}
					Thread.sleep(6000);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		public stocksGui() {
			super("stocks");
			setSize(800,400);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(null);
			JButton searchButton = new JButton("SEARCH");
			searchButton.addActionListener(this);
			searchButton.setBounds(25, 300, 100, 50);
			//add(searchButton);
			lowBound = new JLabel("lower bound: ");
			lowBound.setBounds(25, 0, 200, 100);
			add(lowBound);
			highBound = new JLabel("higher bound: ");
			highBound.setBounds(25, 40, 200, 100);
			add(highBound);
			lowB = new JTextArea("100.00");
			lowB.setBounds(150, 40, 200, 20);
			add(lowB);
			highB = new JTextArea("100.00");
			highB.setBounds(150, 80, 200, 20);
			add(highB);
			results = new JLabel("output: ");
			results.setBounds(150,200,200,100);
			add(results);
			output = new JTextArea();
			output.setBounds(200,240,100,20);
			add(output);
			doit();
			refresh = new JButton("refresh");
			refresh.setBounds(50,235,100,30);
			refresh.addActionListener(this);
			add(refresh);
			shares = new JTextArea("0");
			shares.setBounds(150,120,200,20);
			add(shares);
			stb = new JLabel("shares to buy:");
			stb.setBounds(25,80,200,100);
			add(stb);
			tots = new JLabel("shares you have:");
			tots.setBounds(370,0,200,100);
			add(tots);
			totst = new JTextArea("0");
			totst.setEditable(false);
			totst.setBounds(490,40,200,20);
			add(totst);
			totp = new JLabel("tot price of shares:");
			totp.setBounds(370,40,200,100);
			add(totp);
			totpt = new JTextArea("0.0");
			totpt.setEditable(false);
			totpt.setBounds(490,80,200,20);
			add(totpt);
			wallett = new JLabel("money in wallet:");
			wallett.setBounds(370,80,200,100);
			add(wallett);
			wallet = new JTextArea("500.0");
			wallet.setEditable(false);
			wallet.setBounds(490,120,200,20);
			add(wallet);
			 
			}
		public void doit() {
			//while(true) {
			 
				try {
				
			if(checker = check) {
				output.setText(price);
				double val = Double.parseDouble(output.getText());
				double lowber = Double.parseDouble(lowB.getText());;
				double highber = Double.parseDouble(highB.getText());;
				if(Integer.parseInt(shares.getText()) == 0){
					if(val > lowber && val < highber) {
						System.out.println("do nothing");
					}else if(val < lowber) {
						System.out.println("buy stock");
						stocks +=1;
						wallet.setText(" " + (Double.parseDouble(wallet.getText())- Double.parseDouble(price)));
						
					}else {
						System.out.println("sell stock");
						if(stocks >=1) {
							stocks -=1;
							wallet.setText(" " + (Double.parseDouble(wallet.getText())+ Double.parseDouble(price)));
						}
						
					}
				}
				
			}
			//Thread.sleep(6000);
			}
				catch(Exception e) {
				System.out.println("system had a boo boo");	
				}
				
			}
		//}
		
		public void setPrice(String priced) {
			output.setText(priced);
		}
		@Override
		
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("refresh")) {
				doit();
				stocks += Double.parseDouble(shares.getText());
				totst.setText("" + stocks);
				totpt.setText("" + Double.parseDouble(price) * stocks);
				
			}
			}
		
		}
	class stocker extends Thread{
		 private String symbol, interval, apiKey;
		    private stocksGui gui;

		    stocker(String symbol, String interval, String apiKey, stocksGui gui) {
		        this.symbol = symbol;
		        this.interval = interval;
		        this.apiKey = apiKey;
		        this.gui = gui;
		    }

		    public void run() {
		        while (true) {
		            try {
		                String urlString = "https://api.twelvedata.com/time_series?symbol=" +
		                        symbol + "&interval=" + interval + "&apikey=" + apiKey + "&outputsize=1";

		                HttpURLConnection conn = (HttpURLConnection) new URL(urlString).openConnection();
		                conn.setRequestMethod("GET");

		                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		                StringBuilder response = new StringBuilder();
		                String line;
		                while ((line = in.readLine()) != null)
		                    response.append(line);
		                in.close();

		                String result = response.toString();
		                String searchPrice = "\"close\":\"";
		                int start = result.indexOf(searchPrice);
		                if (start != -1) {
		                    start += searchPrice.length();
		                    int end = result.indexOf("\"", start);
		                    stocksGui.price = result.substring(start, end);
		                    gui.setPrice("$" + stocksGui.price);
		                    System.out.println("Thread price $" + stocksGui.price);
		                }

		                Thread.sleep(6000);
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
		    }
	}




