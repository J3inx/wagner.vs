package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class homeworkthingfordayone {
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		String result = "yes";
		 ArrayList<Integer> cinq = new ArrayList<>();
		while(result.equalsIgnoreCase("yes") || result.equalsIgnoreCase("y")) {
			
			System.out.println("***************************");
			System.out.println("1. prob 1");
			System.out.println("***************************");
			System.out.println("2. prob 2");
			System.out.println("***************************");
			System.out.println("3. prob 3");
			System.out.println("***************************");
			System.out.println("4. prob 4");
			System.out.println("***************************");
			System.out.println("5. prob 5");
			System.out.println("***************************");
			System.out.println("6. prob 6");
			System.out.println("***************************");
			System.out.println("7. prob 7");
			System.out.println("***************************");
			System.out.println("8. prob 8");
			System.out.println("***************************");
			System.out.println("9. prob 9");
			System.out.println("***************************");
			System.out.println("10. prob 10");
			System.out.println("***************************");
			System.out.println("11. prob 11");
			System.out.println("***************************");
			System.out.println("12. prob 12");
			System.out.println("***************************");
			System.out.println("13. prob 13");
			System.out.println("***************************");
			System.out.println("14. prob 14");
			System.out.println("***************************");
			System.out.println("what would you like to do");
			System.out.println("***************************");
			int choice = kb.nextInt();
			if(choice == 1) {
				ArrayListone();
			}
			if(choice == 2) {
				ArrayListtwo();
			}
			if(choice == 3) {
				ArrayListthree();
			}
			if(choice == 4) {
				ArrayListfour();
			}
			if(choice ==5) {
				Arrfive();
			}
			if(choice ==6) {
				Arrsix();
			}
			if(choice == 7) {
				Arrseven();
			}
			if(choice == 8) {
				Arreight();
			}
			if(choice == 9) {
				Arrnine();
			}
			if(choice == 10) {
				Arrten();
			}
			if(choice ==11) {
				
			}
			if(choice ==12) {
				
			}
			if(choice ==13) {
				
			}
			if(choice ==14) {
				
			}
			System.out.println("Run again?");
			result = kb.next();
		}
		System.out.println("have a good day");
	}
	
	public static void ArrayListone() {
		ArrayList <Integer> partuno = new ArrayList<>();
		partuno.add(84);
		partuno.add(65);
		partuno.add(2);
		partuno.add(0);
		partuno.add(97);
		partuno.add(456);
		partuno.add(152);
		partuno.add(34);
		partuno.add(3,54);
		partuno.remove(4);
		partuno.set(5, 656);
		partuno.add(70);
		System.out.println(partuno);
	}
	
	public static void ArrayListtwo() {
		ArrayList <Integer> partdos = new ArrayList<>();
		for(int i = 0; i<16; i++) {
			partdos.add((int)((Math.random()*100)+1)+1);
		}
		System.out.println(partdos);
		partdos.remove(10);
		partdos.add(9,(int)(Math.random()*5)+2);
		partdos.remove(3);
		partdos.remove(8);
		System.out.println(partdos);
	}
	public static void ArrayListthree() {
		ArrayList <String> trois = new ArrayList<>();
		trois.add("New Jersey");
		trois.add("Pensylvania");
		trois.add("Ohio");
		trois.add("Wisconsin");
		trois.add("Colorado");
		trois.add("California");
		trois.add("Washington");
		trois.add("New Mexico");
		trois.set(3,"North Dakota");
		trois.add(5,"Texas");
		trois.remove(2);
		System.out.println(trois);
		
	}
	public static void ArrayListfour() {
		
		ArrayList <Double> partdos = new ArrayList<>();
		
		for(int i = 0; i<16; i++) {
			partdos.add(((Math.random()*100)+1)+1);
		}
		double max = partdos.get(0);
		for(double numbers: partdos) {
			if(max<numbers) {
				max = numbers;
			}
		}
		System.out.println(partdos);
	}
	public static void Arrfive() {
	    ArrayList<Integer> cinq = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            cinq.add(((int) (Math.random() * 100) + 1) + 1);
        }
        System.out.println("original: " + cinq);
        // Sort the cinq list in descending order
        Collections.sort(cinq, Collections.reverseOrder());



        System.out.println("the new one: " + cinq);
    }
		





	
	
	public static void Arrsix() {
		ArrayList <Integer> six = new ArrayList<>();
		for(int i = 0; i<16; i++) {
			six.add(((int)Math.random()*99)+1);
		}
		int total = 0;
		for(int numbers: six){
			total+= numbers;
		}
		System.out.println(total);
		System.out.println("part 2 now");
		//to do
	}
	
	public static void Arrseven() {
		int count = 0;
		ArrayList <Integer> sept = new ArrayList<>();
		for(int i = 0; i<16; i++) {
			sept.add(((int)Math.random()*99)+1);
		}
		for(int numbers: sept) {
			if(numbers%2 <= 1) {
				count ++;
			}
		}
		System.out.println(count);
	}
	
	public static void Arreight() {
		ArrayList <Integer> huit = new ArrayList<>();
		for(int i = 0; i<16; i++) {
			huit.add((int)(Math.random()*99)+1);
		}
		System.out.println("before");
		System.out.println(huit);
		int place = 0;
		int max = huit.get(0);
		for(int numbers: huit) {
			if(max<numbers) {
				max = numbers;
				place = huit.indexOf(numbers);
			}
			
		}
		huit.add(max);
		huit.remove(place);
		System.out.println("after");
		System.out.println(huit);
		
	}
	
	public static void Arrnine() {
		ArrayList <Integer> neuf = new ArrayList<>();
		for(int i = 0; i<16; i++) {
			neuf.add((int)(Math.random()*99)+1);
		}
		int max = neuf.get(0);
		int min = neuf.get(0);
		for(int numbers: neuf) {
			if(max<numbers) {
				max = numbers;
			}
		}
		for(int numbers: neuf) {
			if(min>numbers) {
				min = numbers;
			}
		}
		System.out.println("the max is: " + max + " and the min is: " + min + " and the difference is: " + (max-min));
	}
	   public static void Arrten() {
	        ArrayList<String> dix = new ArrayList<>();
	        dix.add("hello");
	        dix.add("fine");
	        dix.add("day");
	        dix.add("computer");
	        dix.add("last");
	        dix.add("click");

	        ArrayList<String> modi = new ArrayList<>();
	        for (String word : dix) {
	            if (word.length() == 5) {
	                modi.add("!" + word);
	            } else {
	                modi.add(word);
	            }
	        }

	        System.out.println(modi);
	    }
}

