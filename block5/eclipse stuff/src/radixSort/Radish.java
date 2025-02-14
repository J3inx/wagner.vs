package radixSort;
import java.util.ArrayList;
import java.util.List;

public class Radish {
    public static int nums[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {
        setup();
        System.out.println("\nBefore Sorting:");
        printArray();
        calculate();
        finalCheck();
    }

    public static void setup() {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) ((Math.random() * 99) + 1); 
        }
    }

    public static void calculate() {
        int maxDigits = 3; 
        int placeValue = 1; 

        for (int d = 0; d < maxDigits; d++) {
            System.out.println("\nSorting by place value: " + placeValue);
            radixSortStep(placeValue);
            printArray();
            placeValue *= 10; 
        }
    }

    public static void radixSortStep(int placeValue) {
        List<Integer>[] buckets = new ArrayList[10];

        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }

       
        for (int num : nums) {
            int digit = (num / placeValue) % 10;
            buckets[digit].add(num);
        }

        
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int num : buckets[i]) {
                nums[index++] = num;
            }
        }
    }

    public static void finalCheck() {
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    System.out.println("Sorting error detected. Retrying sorting...");
                    calculate(); 
                    sorted = false;
                    break;
                }
            }
        }

        System.out.println("\nFinal sorted array:");
        printArray();
    }

    public static void printArray() {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
