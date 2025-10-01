package prisonergui;

import java.util.ArrayList;

public class assignmentSixDriver {

	public static void main(String[] args) {
		ArrayList <assignmentSix> cars = new ArrayList();
		cars.add(new assignmentSix());
		cars.add(new assignmentSix());
		cars.add(new assignmentSix("lamborghini countach", 414, true));
		cars.add(new assignmentSix("kia soul", 147, false));
		for(int k = 0; k<cars.size(); k++) {
			cars.get(k).getName();
			System.out.print(cars.get(k).getName() + ", ");
			cars.get(k).getHP();
			System.out.print(cars.get(k).getHP() + " hp, ");
			cars.get(k).getCool();
			System.out.println(cars.get(k).getCool());
		}

	}

}
