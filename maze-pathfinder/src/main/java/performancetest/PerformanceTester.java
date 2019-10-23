package performancetest;

import pathfinder.BFS;

/**
 *
 * @author jethulk
 */
public class PerformanceTester {

    /**
     * Used to test the speed of the pathfinding algorithm. Prints the speed
     * displayed in nanoseconds.
     *
     * @param tiles Array that contains information of the level layout
     * @param startX The x position where the level starts
     * @param startY The y position where the level starts
     *
     * @param times How many times is the algorithm executed?
     */
    public PerformanceTester(String tiles[][], int startX, int startY, int times) {
        BFS.solve(tiles, startX, startY);
        double t = System.nanoTime();
        for (int i = 0; i < times; i++) {
            BFS.solve(tiles, startX, startY);
        }
        t = System.nanoTime() - t;
        System.out.println("\nAverage time in nanoseconds: " + t / times);
        System.out.println("\nSum in nanoseconds: " + t);
    }
}
