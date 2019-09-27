package pathfinder;

/**
 *
 * @author jethulk
 */
public class LevelPrinter {

    /**
     * Prints a view of the level.
     *
     * @param tiles The tile grid of the level
     * @return view of the level in string form
     */
    public static String printLevel(String tiles[][]) {
        String printed = "";
        System.out.println("Level layout:");

        for (int i = 0; i < 15; i++) {
            printed += "\n";
            for (int j = 0; j < 15; j++) {
                printed += tiles[i][j] + " ";
            }
        }
        return printed;
    }

    /**
     * Prints a view of the solved level, displaying "+" in areas where the
     * player has travelled.
     *
     * @param tiles The tile grid of the level
     * @param solution The solution to the level as a sequence of command
     * inputs.
     * @param startX The x coordinate of the starting position
     * @param startY The y coordinate of the starting position
     * @return view of the level in string form
     */
    public static String printSolution(String tiles[][], String solution, int startX, int startY) {
        String printed = "";
        int printX = 0;
        int printY = 0;
        while (!solution.isEmpty() && solution.length() != 1) {
            switch (solution.charAt(0)) {
                case 'w':
                    printY--;
                    break;
                case 'a':
                    printX--;
                    break;
                case 's':
                    printY++;
                    break;
                case 'd':
                    printX++;
                    break;
            }
            solution = solution.substring(1);
            tiles[startX + printY][startY + printX] = "+";
        }

        for (int i = 0; i < 15; i++) {
            printed += "\n";
            for (int j = 0; j < 15; j++) {
                printed += tiles[i][j] + " ";
            }
        }
        return printed;
    }
}
