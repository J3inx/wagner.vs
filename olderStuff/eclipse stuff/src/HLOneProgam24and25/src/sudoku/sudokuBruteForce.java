package sudoku;
import java.util.Scanner;
import java.util.Random;

public class sudokuBruteForce {

    private static int stepCounter = 0; // Step counter to track solving progress

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain;
        do {
            // Difficulty selection
            System.out.println("Select Difficulty:");
            System.out.println("1. Easy (4x4 with 6 pre-filled cells)");
            System.out.println("2. Medium (9x9 with 20 pre-filled cells)");
            System.out.println("3. Hard (16x16 with 40 pre-filled cells)");
            System.out.print("Enter your choice (1, 2, or 3): ");
            int choice = scanner.nextInt();

            int size = 0, prefilledCount = 0, delay = 0;
            switch (choice) {
                case 1:
                    size = 4;
                    prefilledCount = 6;
                    delay = 200;
                    break;
                case 2:
                    size = 9;
                    prefilledCount = 20;
                    delay = 25;
                    break;
                case 3:
                    size = 16;
                    prefilledCount = 40;
                    delay = 5;
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Medium difficulty.");
                    size = 9;
                    prefilledCount = 20;
                    delay = 75;
                    break;
            }

            boolean solved = false;
            int[][] board;

            do {
                board = initializeBoard(size, prefilledCount);
                System.out.println("\nInitial Board:");
                printBoard(board);
                System.out.println();

                stepCounter = 0; // Reset step counter

                if (solveSudoku(board, delay)) {
                    solved = true;
                    System.out.println("\nSolved Board:");
                } else {
                    System.out.println("\nNo solution exists. Restarting board creation...");
                    for (int i = 3; i > 0; i--) {
                        System.out.println("Restarting in " + i + "...");
                        Thread.sleep(1000);
                    }
                }
            } while (!solved);

            printBoard(board);

            // Ask user if they want to play again with a box around the text
            printPlayAgainPrompt();

            // Get the user's choice
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");

        } while (playAgain);

        scanner.close();
    }

    // Print a small box around the prompt text
    public static void printPlayAgainPrompt() {
        String message = "Do you want to play again?";
        int length = message.length() + 4;

        // Print the top border of the box
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Print the message inside the box
        System.out.println("| " + message + " |");

        // Print the bottom border of the box
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // Initializes a Sudoku board with random pre-filled numbers
    public static int[][] initializeBoard(int size, int prefilledCount) {
        int[][] board = new int[size][size];
        Random random = new Random();

        for (int i = 0; i < prefilledCount; i++) {
            int row, col, num;
            do {
                row = random.nextInt(size);
                col = random.nextInt(size);
                num = random.nextInt(size) + 1;
            } while (board[row][col] != 0 || !isValid(board, row, col, num));
            board[row][col] = num;
        }
        return board;
    }

    // Solves the Sudoku while showing step-by-step visualization
    public static boolean solveSudoku(int[][] board, int delay) throws InterruptedException {
        int size = board.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == 0) { // Find an empty cell
                    for (int num = 1; num <= size; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // Place the number
                            stepCounter++;
                            printStep(board, stepCounter);
                            Thread.sleep(delay); // Pause based on difficulty

                            if (solveSudoku(board, delay)) {
                                return true; // Solution found
                            }
                            board[row][col] = 0; // Undo the move (backtrack)
                            stepCounter++;
                            printStep(board, stepCounter);
                            Thread.sleep(delay); // Pause based on difficulty
                        }
                    }
                    return false; // No valid number found
                }
            }
        }
        return true; // Board is fully solved
    }

    // Checks if placing num at board[row][col] is valid
    public static boolean isValid(int[][] board, int row, int col, int num) {
        int size = board.length;
        int sqrt = (int) Math.sqrt(size);

        for (int x = 0; x < size; x++) {
            if (board[row][x] == num || board[x][col] == num ||
                board[row - row % sqrt + x / sqrt][col - col % sqrt + x % sqrt] == num) {
                return false;
            }
        }
        return true;
    }

    // Prints the Sudoku board with step counter and a visual divider
    public static void printStep(int[][] board, int stepCounter) {
        System.out.println("=====================================");
        System.out.println("Step " + stepCounter + ":");
        System.out.println("=====================================");
        printBoard(board);
        System.out.println();
    }

    // Prints the Sudoku board with ASCII box styling
    public static void printBoard(int[][] board) {
        int size = board.length;
        int sqrt = (int) Math.sqrt(size);

        for (int i = 0; i < size; i++) {
            if (i % sqrt == 0) {
                printHorizontalBorder(size, sqrt);
            }
            for (int j = 0; j < size; j++) {
                if (j % sqrt == 0) {
                    System.out.print("| ");
                }
                System.out.print((board[i][j] == 0 ? " " : board[i][j]) + " ");
            }
            System.out.println("|");
        }
        printHorizontalBorder(size, sqrt);
    }

    // Prints the horizontal border for the Sudoku board
    public static void printHorizontalBorder(int size, int sqrt) {
        for (int i = 0; i < size; i++) {
            System.out.print((i % sqrt == 0 ? "+---" : "---"));
        }
        System.out.println("+");
    }
}
