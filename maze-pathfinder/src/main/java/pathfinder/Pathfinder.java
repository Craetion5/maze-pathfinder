package pathfinder;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;
import javafx.util.Pair;

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
        System.out.println("Enter level code: ");
        String code = scanner.nextLine();
        System.out.println(solve(code));
    }

    /**
     * Attempts to find a solution to a level. Turns the level code into a tile
     * map and calls the search algorithm
     *
     * @param levelCode The level code in its original form
     * @return Sequence of commands required to solve the level
     */
    public static String solve(String levelCode) {
        try {
            //load the level code
            String tiles[][] = new String[15][15];
            String[] codeArray = levelCode.split(",");
            int indx = 0;
            int startX = 0;
            int startY = 0;
            boolean ice = false;
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
                            ice = true;
                            break;
                    }
                    indx++;
                }
            }

            //print the level
            System.out.println("");
            System.out.print(LevelPrinter.printLevel(tiles));

            //get and print the solution
            String path = BFS.solve(tiles, startX, startY, "", false);
            //printing the solution in levels featuring ice is currently disabled due to errors
            if (!path.contains("Couldn't solve the level") && !ice) {
                System.out.println(LevelPrinter.printSolution(tiles, path, startX, startY));
            }
            System.out.println("");
            return path;

        } catch (Exception e) {
            return "\nInvalid level code!";
        }
    }

}
