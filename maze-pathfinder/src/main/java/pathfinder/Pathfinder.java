package pathfinder;

import java.util.Scanner;
import performancetest.PerformanceTester;

/**
 *
 * @author jethulk
 */
public class Pathfinder {

    /**
     * The main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter level code or type 'test' for performance testing");
        String code = scanner.nextLine();
        if (!code.equals("test")) {
            // we try to solve the level
            System.out.println(solve(code, false, 0));
        } else {
            // we are testing the algorithm performance
            System.out.println("How many times to run the code?");
            try {
                int amount = Integer.parseInt(scanner.nextLine());
                if (amount > 0) {
                    System.out.println("Enter level code:");
                    code = scanner.nextLine();
                    solve(code, true, amount);
                } else {
                    System.out.println("Invalid value!");
                }
            } catch (Exception e) {
                System.out.println("Invalid value!");
            }

        }
    }

    /**
     * Attempts to find a solution to a level. Turns the level code into a tile
     * map and calls the search algorithm
     *
     * @param levelCode The level code in its original form
     * @param testing
     * @param times
     * @return Sequence of commands required to solve the level
     */
    public static String solve(String levelCode, boolean testing, int times) {
        try {
            //load the level code
            String tiles[][] = new String[15][15];
            String[] codeArray = levelCode.split(",");
            int indx = 0;
            int startX = 0;
            int startY = 0;
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    switch (codeArray[indx]) {
                        case "1": //WALL
                            tiles[j][i] = "#";
                            break;
                        case "0": //FLOOR
                            tiles[j][i] = "-";
                            break;
                        case "8": //START
                            tiles[j][i] = "S";
                            startX = j;
                            startY = i;
                            break;
                        case "9": //GOAL
                            tiles[j][i] = "X";
                            break;
                        case "25": //KEY
                            tiles[j][i] = "k";
                            break;
                        case "28": //LOCK
                            tiles[j][i] = "L";
                            break;
                        case "2": //ICE
                            tiles[j][i] = "i";
                            break;
                        case "3": //LAVA
                            tiles[j][i] = "*";
                            break;
                    }
                    indx++;
                }
            }

            //print the level
            if (!testing) {
                System.out.println("");
                System.out.print(LevelPrinter.printLevel(tiles));
            }

            if (testing) {
                //test algorithm performance
                new PerformanceTester(tiles, startX, startY, times);
            } else {
                //get and print the solution
                String path = BFS.solve(tiles, startX, startY);

                if (!path.contains("Couldn't solve the level")) {
                    System.out.println("\n\nSolution found:");
                }

                System.out.println("");
                return path;
            }
            return "";

        } catch (Exception e) {
            return "\nInvalid level code!";
        }
    }

}
