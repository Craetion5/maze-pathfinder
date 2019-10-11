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
}
