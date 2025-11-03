package Notes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class stocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String apiKey = "0ad06c84cf75448e978c07035c1fba5b";
		String symbol = "AAPL";
		//String symbolTwo = "DIS";
		String interval = "1min";
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
					String price = result.substring(start,end);
					System.out.println(symbol + "Price $" + price);
				}
				Thread.sleep(6000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
