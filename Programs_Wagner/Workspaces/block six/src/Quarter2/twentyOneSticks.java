package Quarter2;

import java.util.Scanner;

public class twentyOneSticks {
	static int turn = 1;
 @SuppressWarnings({ "unused", "resource" })
public static void main(String [] args) {
	 Scanner kb = new Scanner(System.in);
	 int sticks = 21;
	 int mysticks = 0;
	 int botsticks = 0;
	 while(true) {
	 if(turn == 1 & sticks >1) {
		 
	 
	 while(sticks > 0 & turn ==1) {
		 System.out.println("you have " + mysticks + " sticks, there are " + sticks + " on the table and your opponent has " + botsticks + " sticks, enter how many sticks you would like to grab");
		 int grabbed = kb.nextInt();
		 if(grabbed <= 4 & grabbed > 0) {
			 mysticks = grabber(grabbed);
			 sticks = sticks-mysticks;
			 System.out.println(sticks);
			 turn = 0;
		 }else {
			 System.out.println("please choose a number equal to or less than 4");
		 }

	 }
	 
	 }else {
		 System.out.println("you lost");
		 System.exit(0);
	 }
	 if(turn == 0 & sticks > 1) {
		 int temp = opponent(sticks);
		 if(temp > 0) {
		 botsticks += opponent(sticks);
		 sticks = sticks-opponent(sticks);
		 System.out.println(sticks);
		 turn = 1;
		 }
	 }else {
		 System.out.println("you won!");
		 System.exit(0);
	 }
	 }
 }
 public static int grabber(int num) {
	 int temp = num;
	 turn = 0;
	 return temp;
 }
 public static int opponent(int num) {
	 int temp = 0;
	 if(num > 4) {
		 temp =4;
	 }else {
		 if(num >= 3) {
			 temp = 2;
		 }else {
			 if(num == 2) {
				 temp = 1;
			 }else {
				 if(num == 1) {
					 temp = 0;
				 }
			 }
		 }
	 }
	 return temp;
 }
}
