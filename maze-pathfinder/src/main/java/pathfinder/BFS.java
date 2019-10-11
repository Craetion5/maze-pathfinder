package pathfinder;

import datastructures.Point;
import datastructures.SimpleQueue;

/**
 *
 * @author jethulk
 */
public class BFS {

    /**
     * A modified BFS algorithm that attempts to find a solution to the level.
     *
     * @param tiles Array that contains information of the level layout
     * @param startX The x position where the search starts
     * @param startY The y position where the search starts
     * @param oldPath The path that the player has already travelled
     * @param hasKey Is the player carrying a key?
     *
     * These parameters are used to store information about the starting state
     * of the first search so we can redo the search if we mess up.
     * @param tilesAtFirst
     * @param startXAtFirst
     * @param startYAtFirst
     *
     * @return Sequence of commands required to solve the level
     */
    public static String solve(String tiles[][], int startX, int startY, String oldPath, boolean hasKey, String tilesAtFirst[][], int startXAtFirst, int startYAtFirst) {
        SimpleQueue<Point> queue = new SimpleQueue<>();
        Point parents[][] = new Point[15][15];
        boolean visited[][] = new boolean[15][15];
        visited[startX][startY] = true;
        queue.enqueue(new Point(startX, startY));
        Point tileVisiting;

        while (!queue.isEmpty()) {
            tileVisiting = queue.dequeue();
            if (tiles[tileVisiting.getX()][tileVisiting.getY()].equals("X") || tiles[tileVisiting.getX()][tileVisiting.getY()].equals("L") || ((tiles[tileVisiting.getX()][tileVisiting.getY()].equals("k") && !hasKey))) {
                // we are interacting with an object in this tile (finish, lock or key)
                String found = tiles[tileVisiting.getX()][tileVisiting.getY()];
                Point vCopy = new Point(tileVisiting.getX(), tileVisiting.getY());
                String reversedPath = "";
                while (true) {
                    try {
                        Point prevTile = new Point(parents[tileVisiting.getX()][tileVisiting.getY()].getX(), parents[tileVisiting.getX()][tileVisiting.getY()].getY());

                        if (tileVisiting.getX() - prevTile.getX() >= 1) {
                            reversedPath += "s"; //down
                        } else if (tileVisiting.getX() - prevTile.getX() <= -1) {
                            reversedPath += "w"; //up
                        } else if (tileVisiting.getY() - prevTile.getY() >= 1) {
                            reversedPath += "d"; //right
                        } else if (tileVisiting.getY() - prevTile.getY() <= -1) {
                            reversedPath += "a"; //left
                        }
                        tileVisiting = prevTile;
                    } catch (Exception e) {
                        //the coordinate has no parent so it's the start position of the search
                        break;
                    }
                }

                // path needs to be reversed
                String currentPath = "";
                int index = reversedPath.length() - 1;
                while (index >= 0) {
                    currentPath += reversedPath.charAt(index);
                    index--;
                }
                if (found.equals("X")) {
                    // finish was found, we are done.
                    return oldPath + currentPath;
                } else if (found.equals("L")) {
                    // lock was found and we have the key, open the lock and start searching for goal again.
                    tiles[vCopy.getX()][vCopy.getY()] = "-";
                    hasKey = false;
                    return solve(tiles, vCopy.getX(), vCopy.getY(), oldPath + currentPath, hasKey, tilesAtFirst, startXAtFirst, startYAtFirst);
                } else if (found.equals("k")) {
                    // key was found, pick up the key and start searching for goal again.
                    tiles[vCopy.getX()][vCopy.getY()] = "-";
                    hasKey = true;
                    return solve(tiles, vCopy.getX(), vCopy.getY(), oldPath + currentPath, hasKey, tilesAtFirst, startXAtFirst, startYAtFirst);
                }
            }

            // here we check all adjacent tiles if they haven't been checked already
            int stepX = 1;
            int stepY = 0;
            while (true) {
                try {
                    // if the tile is passable it'll get visited next (lock tiles are passable only if the player is holding a key)
                    if (!visited[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY] && !tiles[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY].equals("#") && !(tiles[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY].equals("L") && !hasKey) && !tiles[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY].equals("*") && !tiles[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY].equals("i")) {
                        visited[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY] = true;
                        queue.enqueue(new Point(tileVisiting.getX() + stepX, tileVisiting.getY() + stepY));
                        parents[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY] = new Point(tileVisiting.getX(), tileVisiting.getY());

                        // the player is sliding on ice
                    } else if (!visited[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY] && tiles[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY].equals("i")) {
                        int xBeforeSliding = stepX;
                        int yBeforeSliding = stepY;
                        while (true) {
                            stepX += xBeforeSliding;
                            stepY += yBeforeSliding;
                            //wall found, we stop
                            if (tiles[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY].equals("#") || tiles[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY].equals("L") && !hasKey) {
                                if (!visited[tileVisiting.getX() + stepX - xBeforeSliding][tileVisiting.getY() + stepY - yBeforeSliding]) {
                                    visited[tileVisiting.getX() + stepX - xBeforeSliding][tileVisiting.getY() + stepY - yBeforeSliding] = true;
                                    queue.enqueue(new Point(tileVisiting.getX() + stepX - xBeforeSliding, tileVisiting.getY() + stepY - yBeforeSliding));
                                    parents[tileVisiting.getX() + stepX - xBeforeSliding][tileVisiting.getY() + stepY - yBeforeSliding] = new Point(tileVisiting.getX(), tileVisiting.getY());
                                }
                                stepX = xBeforeSliding;
                                stepY = yBeforeSliding;
                                break;
                                //lava found, better not slide there!
                            } else if (tiles[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY].equals("*")) {
                                stepX = xBeforeSliding;
                                stepY = yBeforeSliding;
                                break;
                            } else if (!tiles[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY].equals("i")) {
                                if (!visited[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY]) {
                                    visited[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY] = true;
                                    queue.enqueue(new Point(tileVisiting.getX() + stepX, tileVisiting.getY() + stepY));
                                    parents[tileVisiting.getX() + stepX][tileVisiting.getY() + stepY] = new Point(tileVisiting.getX(), tileVisiting.getY());
                                }
                                stepX = xBeforeSliding;
                                stepY = yBeforeSliding;
                                break;
                            }
                        }
                    }
                } catch (Exception e) {

                }
                //we start looking at another adjacent tile if there are some unchecked ones left
                if (stepX == 1) {
                    stepX = -1;
                    stepY = 0;
                } else if (stepX == -1) {
                    stepX = 0;
                    stepY = 1;
                } else if (stepY == 1) {
                    stepY = -1;
                    stepX = 0;
                } else {
                    break;
                }
            }
        }
        //no path to goal was found.

        //we try searching again if we might've collected some unnecessary keys or opened some unneecssary locks
        if (startX != startXAtFirst && startY != startYAtFirst) {
            if ("k".equals(tilesAtFirst[startX][startY])) {
                tilesAtFirst[startX][startY] = "-";
            } else if ("L".equals(tilesAtFirst[startX][startY])) {
                tilesAtFirst[startX][startY] = "#";
            }
            return BFS.solve(tilesAtFirst, startXAtFirst, startYAtFirst, "", false, clone2DArray(tilesAtFirst), startXAtFirst, startYAtFirst);
        }

        return "\n\nCouldn't solve the level...";
    }

    /**
     * A modified BFS algorithm that attempts to find a solution to the level.
     * This method with less parameters is called when the search starts for the
     * first time.
     *
     * @param tiles Array that contains information of the level layout
     * @param startX The x position where the search starts
     * @param startY The y position where the search starts
     * @return
     */
    public static String solve(String tiles[][], int startX, int startY) {
        return BFS.solve(tiles, startX, startY, "", false, clone2DArray(tiles), startX, startY);
    }

    /**
     * Clones a 2D array
     *
     * @param array The array to clone
     * @return cloned array
     */
    public static String[][] clone2DArray(String[][] array) {
        String[][] clonedArray = new String[array.length][];
        for (int i = 0; i < array.length; i++) {
            clonedArray[i] = array[i].clone();
        }
        return clonedArray;
    }
}
