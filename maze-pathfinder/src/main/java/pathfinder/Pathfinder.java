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
                    }
                    indx++;
                }
            }

            //print the level
            System.out.println("");
            for (int i = 0; i < 15; i++) {
                System.out.println("");
                for (int j = 0; j < 15; j++) {
                    System.out.print(tiles[i][j] + " ");
                }
            }

            return (BFS(tiles, startX, startY));
            
        } catch (Exception e) {
            return "\n\nInvalid level code!";
        }
    }

    /**
     * A modified BFS algorithm that attempts to find a solution to the level.
     *
     * @param tiles Array that contains information of the level layout
     * @param startX The x position where the level starts
     * @param startY The y position where the level starts
     * @return Sequence of commands required to solve the level
     */
    public static String BFS(String tiles[][], int startX, int startY) {

        ArrayDeque<Pair<Integer, Integer>> queue = new ArrayDeque();
        HashMap<Pair, Pair> parents = new HashMap();
        boolean visited[][] = new boolean[15][15];
        visited[startX][startY] = true;
        queue.push(new Pair<>(startX, startY));
        Pair<Integer, Integer> v;

        while (!queue.isEmpty()) {
            v = queue.pop();
            if (tiles[v.getKey()][v.getValue()].equals("X")) {
                // finish reached, time to get the path
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
                System.out.println("\n\nSolution found:\n");
                return realPath;
            }

            // here we check all adjacent tiles if they haven't been checked already
            int xx = 1;
            int yy = 0;
            while (true) {
                try {
                    if (!visited[v.getKey() + xx][v.getValue() + yy] && !tiles[v.getKey() + xx][v.getValue() + yy].equals("#")) {
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
