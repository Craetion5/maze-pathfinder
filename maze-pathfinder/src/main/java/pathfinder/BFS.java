
package pathfinder;

import java.util.ArrayDeque;
import java.util.HashMap;
import javafx.util.Pair;

/**
 *
 * @author jethulk
 */
public class BFS {

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
    public static String solve(String tiles[][], int startX, int startY, String oldPath, boolean hasKey) {

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
                    if (v.getKey() - p.getKey() >= 1) {
                        path += "s"; //down
                    } else if (v.getKey() - p.getKey() <= -1) {
                        path += "w"; //up
                    } else if (v.getValue() - p.getValue() >= 1) {
                        path += "d"; //right
                    } else if (v.getValue() - p.getValue() <= -1) {
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
                    return solve(tiles, vCopy.getKey(), vCopy.getValue(), oldPath + realPath, hasKey);
                } else if (found.equals("k")) {
                    // key was found, pick up the key and start searching for goal again.
                    tiles[vCopy.getKey()][vCopy.getValue()] = "-";
                    hasKey = true;
                    return solve(tiles, vCopy.getKey(), vCopy.getValue(), oldPath + realPath, hasKey);
                }
            }

            // here we check all adjacent tiles if they haven't been checked already
            int xx = 1;
            int yy = 0;
            while (true) {
                try {
                    // if the tile is passable it'll get visited next (lock tiles are passable only if the player is holding a key)
                    if (!visited[v.getKey() + xx][v.getValue() + yy] && !tiles[v.getKey() + xx][v.getValue() + yy].equals("#") && !(tiles[v.getKey() + xx][v.getValue() + yy].equals("L") && !hasKey) && !tiles[v.getKey() + xx][v.getValue() + yy].equals("i")) {
                        visited[v.getKey() + xx][v.getValue() + yy] = true;
                        queue.push(new Pair<>(v.getKey() + xx, v.getValue() + yy));
                        parents.put(new Pair<>(v.getKey() + xx, v.getValue() + yy), new Pair<>(v.getKey(), v.getValue()));

                        // the player is sliding on ice
                    } else if (!visited[v.getKey() + xx][v.getValue() + yy] && tiles[v.getKey() + xx][v.getValue() + yy].equals("i")) {
                        int xxx = xx;
                        int yyy = yy;
                        while (true) {
                            xx += xxx;
                            yy += yyy;
                            if (tiles[v.getKey() + xx][v.getValue() + yy].equals("#") || tiles[v.getKey() + xx][v.getValue() + yy].equals("L") && !hasKey) {
                                if (!visited[v.getKey() + xx - xxx][v.getValue() + yy - yyy]) {
                                    visited[v.getKey() + xx - xxx][v.getValue() + yy - yyy] = true;
                                    queue.push(new Pair<>(v.getKey() + xx - xxx, v.getValue() + yy - yyy));
                                    parents.put(new Pair<>(v.getKey() + xx - xxx, v.getValue() + yy - yyy), new Pair<>(v.getKey(), v.getValue()));
                                }
                                xx = xxx;
                                yy = yyy;
                                break;
                            } else if (!tiles[v.getKey() + xx][v.getValue() + yy].equals("i")) {
                                if (!visited[v.getKey() + xx][v.getValue() + yy]) {
                                    visited[v.getKey() + xx][v.getValue() + yy] = true;
                                    queue.push(new Pair<>(v.getKey() + xx, v.getValue() + yy));
                                    parents.put(new Pair<>(v.getKey() + xx, v.getValue() + yy), new Pair<>(v.getKey(), v.getValue()));
                                }
                                xx = xxx;
                                yy = yyy;
                                break;
                            }
                        }
                    }
                } catch (Exception e) {

                }
                //we start looking at another adjacent tile if there are some unchecked ones left
                if (xx == 1) {
                    xx = -1;
                    yy = 0;
                } else if (xx == -1) {
                    xx = 0;
                    yy = 1;
                } else if (yy == 1) {
                    yy = -1;
                    xx = 0;
                } else {
                    break;
                }
            }
        }
        return "\n\nCouldn't solve the level...";
    }
}
