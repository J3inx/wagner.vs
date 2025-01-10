package ArrayList;

import java.util.ArrayList;

public class ArrayListDayone {
	public static void main(String [] args) {
		//int [] n = new int [] 10
		//array with 10 spots 0-9
		//array lists tho
		ArrayList <Integer> nums = new ArrayList<>();
		//int is primitive while Integer is a an actual object
				//capital letter is object, string is not tho
		System.out.println(nums);
		nums.add(8462);
		System.out.println(nums);
		nums.add(13);
		nums.add(493);
		System.out.println(nums);
		nums.remove(0);
		System.out.println(nums);
		//removes the object in the front of the qeue,
		//last thing in first thing out is a stack
		nums.set(1,22);
		System.out.println(nums);
		nums.add(1,77);
		System.out.println(nums);
		//if there is something in the spot it is being added to, it will add it after that spot
		int max = nums.get(0);
		//dont make it 0 because if it was negative it would have 0 as the highest
		for(int number: nums ) {
			if(number > max) {
				max = number;
			}
		}
		//number in this case will represent one spot for an individual moment and then go up to the next one. its like a shortened version of a regular for loop
		System.out.println(max);
	}
}
