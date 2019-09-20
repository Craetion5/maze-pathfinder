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
                    }
                    indx++;
                }
            }

            //print the level
            System.out.println("");
            printLevel(tiles);

            //get and print the solution
            String path = (BFS(tiles, startX, startY, "", false));
            if (!path.contains("Couldn't solve the level")) {
                printSolution(tiles, path, startX, startY);
            }
            System.out.println("\n");
            return path;

        } catch (Exception e) {
            return "\nInvalid level code!";
        }
    }

    /**
     * Prints a view of the level.
     * @param tiles The tile grid of the level
     */
    public static void printLevel(String tiles[][]) {

        System.out.println("Level layout:");

        for (int i = 0; i < 15; i++) {
            System.out.println("");
            for (int j = 0; j < 15; j++) {
                System.out.print(tiles[i][j] + " ");
            }
        }
    }

    /**
     * Prints a view of the solved level, displaying "+" in areas where the player has travelled.
     * @param tiles The tile grid of the level
     * @param solution The solution to the level as a sequence of command inputs.
     * @param startX The x coordinate of the starting position
     * @param startY The y coordinate of the starting position
     */
    public static void printSolution(String tiles[][], String solution, int startX, int startY) {

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
            System.out.println("");
            for (int j = 0; j < 15; j++) {
                System.out.print(tiles[i][j] + " ");
            }
        }
    }

    /**
     * A modified BFS algorithm that attempts to find a solution to the level.
     *
     * @param tiles Array that contains information of the level layout
     * @param startX The x position where the level starts
     * @param startY The y position where the level starts
     * @param oldPath The path that the player has already travelled
     * @param hasKey Is the player carrying a key?
     * @return Sequence of commands required to solve the level
     */
    public static String BFS(String tiles[][], int startX, int startY, String oldPath, boolean hasKey) {

        ArrayDeque<Pair<Integer, Integer>> queue = new ArrayDeque();
        HashMap<Pair, Pair> parents = new HashMap();
        boolean visited[][] = new boolean[15][15];
        visited[startX][startY] = true;
        queue.push(new Pair<>(startX, startY));
        Pair<Integer, Integer> v;

        while (!queue.isEmpty()) {
            v = queue.pop();
            if (tiles[v.getKey()][v.getValue()].equals("X") || tiles[v.getKey()][v.getValue()].equals("L") || ((tiles[v.getKey()][v.getValue()].equals("k") && !hasKey))) {
                // we are interacting with an object in this tile (finish, lock or key)
                String found = tiles[v.getKey()][v.getValue()];
                Pair<Integer, Integer> vCopy = v;
                String path = "";
                while (true) {
                    Pair<Integer, Integer> p = parents.get(v);
                    if (p == null) {
                        break;
                    }
                    if (v.getKey() - p.getKey() == 1) {
                        path += "s"; //down
                    } else if (v.getKey() - p.getKey() == -1) {
                        path += "w"; //up
                    } else if (v.getValue() - p.getValue() == 1) {
                        path += "d"; //right
                    } else if (v.getValue() - p.getValue() == -1) {
                        path += "a"; //left
                    }
                    v = p;
                }

                // path needs to be reversed
                String realPath = "";
                int index = path.length() - 1;
                while (index >= 0) {
                    realPath += path.charAt(index);
                    index--;
                }
                if (found.equals("X")) {
                    // finish was found, we are done.
                    System.out.println("\n\nSolution found:");
                    return oldPath + realPath;
                } else if (found.equals("L")) {
                    // lock was found and we have the key, open the lock and start searching for goal again.
                    tiles[vCopy.getKey()][vCopy.getValue()] = "-";
                    hasKey = false;
                    return BFS(tiles, vCopy.getKey(), vCopy.getValue(), oldPath + realPath, hasKey);
                } else if (found.equals("k")) {
                    // key was found, pick up the key and start searching for goal again.
                    tiles[vCopy.getKey()][vCopy.getValue()] = "-";
                    hasKey = true;
                    return BFS(tiles, vCopy.getKey(), vCopy.getValue(), oldPath + realPath, hasKey);
                }
            }

            // here we check all adjacent tiles if they haven't been checked already
            int xx = 1;
            int yy = 0;
            while (true) {
                try {
                    // if the tile is passable it'll get visited next (lock tiles are passable only if the player is holding a key)
                    if (!visited[v.getKey() + xx][v.getValue() + yy] && !tiles[v.getKey() + xx][v.getValue() + yy].equals("#") && !(tiles[v.getKey() + xx][v.getValue() + yy].equals("L") && !hasKey)) {
                        visited[v.getKey() + xx][v.getValue() + yy] = true;
                        queue.push(new Pair<>(v.getKey() + xx, v.getValue() + yy));
                        parents.put(new Pair<>(v.getKey() + xx, v.getValue() + yy), new Pair<>(v.getKey(), v.getValue()));
                    }
                } catch (Exception e) {

                }
                if (xx == 1) {
                    xx = -1;
                } else if (xx == -1) {
                    xx = 0;
                    yy = 1;
                } else if (yy == 1) {
                    yy = -1;
                } else {
                    break;
                }
            }
        }
        return "\n\nCouldn't solve the level...";
    }
}
