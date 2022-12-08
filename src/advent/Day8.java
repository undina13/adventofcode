package advent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//--- Day 8: Treetop Tree House ---
//        The expedition comes across a peculiar patch of tall trees all planted carefully in a grid. The Elves explain that a previous expedition planted these trees as a reforestation effort. Now, they're curious if this would be a good location for a tree house.
//
//        First, determine whether there is enough tree cover here to keep a tree house hidden. To do this, you need to count the number of trees that are visible from outside the grid when looking directly along a row or column.
//
//        The Elves have already launched a quadcopter to generate a map with the height of each tree (your puzzle input). For example:
//
//        30373
//        25512
//        65332
//        33549
//        35390
//        Each tree is represented as a single digit whose value is its height, where 0 is the shortest and 9 is the tallest.
//
//        A tree is visible if all of the other trees between it and an edge of the grid are shorter than it. Only consider trees in the same row or column; that is, only look up, down, left, or right from any given tree.
//
//        All of the trees around the edge of the grid are visible - since they are already on the edge, there are no trees to block the view. In this example, that only leaves the interior nine trees to consider:
//
//        The top-left 5 is visible from the left and top. (It isn't visible from the right or bottom since other trees of height 5 are in the way.)
//        The top-middle 5 is visible from the top and right.
//        The top-right 1 is not visible from any direction; for it to be visible, there would need to only be trees of height 0 between it and an edge.
//        The left-middle 5 is visible, but only from the right.
//        The center 3 is not visible from any direction; for it to be visible, there would need to be only trees of at most height 2 between it and an edge.
//        The right-middle 3 is visible from the right.
//        In the bottom row, the middle 5 is visible, but the 3 and 4 are not.
//        With 16 trees visible on the edge and another 5 visible in the interior, a total of 21 trees are visible in this arrangement.
//
//        Consider your map; how many trees are visible from outside the grid?
//
//        Your puzzle answer was 1794.
//
//        --- Part Two ---
//        Content with the amount of tree cover available, the Elves just need to know the best spot to build their tree house: they would like to be able to see a lot of trees.
//
//        To measure the viewing distance from a given tree, look up, down, left, and right from that tree; stop if you reach an edge or at the first tree that is the same height or taller than the tree under consideration. (If a tree is right on the edge, at least one of its viewing distances will be zero.)
//
//        The Elves don't care about distant trees taller than those found by the rules above; the proposed tree house has large eaves to keep it dry, so they wouldn't be able to see higher than the tree house anyway.
//
//        In the example above, consider the middle 5 in the second row:
//
//        30373
//        25512
//        65332
//        33549
//        35390
//        Looking up, its view is not blocked; it can see 1 tree (of height 3).
//        Looking left, its view is blocked immediately; it can see only 1 tree (of height 5, right next to it).
//        Looking right, its view is not blocked; it can see 2 trees.
//        Looking down, its view is blocked eventually; it can see 2 trees (one of height 3, then the tree of height 5 that blocks its view).
//        A tree's scenic score is found by multiplying together its viewing distance in each of the four directions. For this tree, this is 4 (found by multiplying 1 * 1 * 2 * 2).
//
//        However, you can do even better: consider the tree of height 5 in the middle of the fourth row:
//
//        30373
//        25512
//        65332
//        33549
//        35390
//        Looking up, its view is blocked at 2 trees (by another tree with a height of 5).
//        Looking left, its view is not blocked; it can see 2 trees.
//        Looking down, its view is also not blocked; it can see 1 tree.
//        Looking right, its view is blocked at 2 trees (by a massive tree of height 9).
//        This tree's scenic score is 8 (2 * 2 * 1 * 2); this is the ideal spot for the tree house.
//
//        Consider each tree on your map. What is the highest scenic score possible for any tree?
public class Day8 {



    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<>();
        int[][] trees;
        File file = new File("C:/adventofcode/src/advent/day8.txt");
        FileReader fr = new FileReader(file);


        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();


        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }

        int size = lines.size();
        trees = new int[size][size];
        int visible = size * 4 - 4;

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                trees[y][x] = lines.get(y).charAt(x);
            }
        }
//        for (int y = 1; y < size - 1; y++) {
//            for (int x = 1; x < size - 1; x++) {
//                if (checkWest(y, x, trees)) {
//                    visible++;
//                } else if (checkNorth(y, x, trees)) {
//                    visible++;
//                } else if (checkEast(y, x,trees)) {
//                    visible++;
//                } else if (checkSouth(y, x,trees)) {
//                    visible++;
//                }
//            }
//        }
//
//        System.out.println( visible);

        int highest = 0;
        for (int y = 1; y < size - 1; y++) {
            for (int x = 1; x < size - 1; x++) {
                int score = 1;
                score *= countWest(y, x, trees);
                score *= countNorth(y, x, trees);
                score *= countEast(y, x, trees);
                score *= countSouth(y, x, trees);

                if (score > highest) {
                    highest = score;
                }
            }
        }

        System.out.println(highest);
    }

    static boolean checkSouth(int y, int x, int[][]trees ) {
        int height = trees[y][x];
        for (int i = y + 1; i < trees[y].length; i++) {
            if (trees[i][x] >= height) {
                return false;
            }
        }
        return true;
    }

   static boolean checkEast(int y, int x, int[][]trees ) {
        int height = trees[y][x];
        for (int i = x + 1; i < trees[y].length; i++) {
            if (trees[y][i] >= height) {
                return false;
            }
        }
        return true;
    }

    static boolean checkNorth(int y, int x, int[][]trees ) {
        int height = trees[y][x];
        for (int i = y - 1; i >= 0; i--) {
            if (trees[i][x] >= height) {
                return false;
            }
        }
        return true;
    }

    static boolean checkWest(int y, int x, int[][]trees ) {
        int height = trees[y][x];
        for (int i = x - 1; i >= 0; i--) {
            if (trees[y][i] >= height) {
                return false;
            }
        }
        return true;
    }



    static int countSouth(int y, int x, int[][]trees) {
        int height = trees[y][x];
        int count = 0;
        for (int i = y + 1; i < trees[y].length; i++) {
            count++;
            if (trees[i][x] >= height) {
                break;
            }
        }
        return count;
    }

    static int countEast(int y, int x, int[][]trees) {
        int height = trees[y][x];
        int count = 0;
        for (int i = x + 1; i < trees[y].length; i++) {
            count++;
            if (trees[y][i] >= height) {
                break;
            }
        }
        return count;
    }

    static int countNorth(int y, int x, int[][]trees) {
        int height = trees[y][x];
        int count = 0;
        for (int i = y - 1; i >= 0; i--) {
            count++;
            if (trees[i][x] >= height) {
                break;
            }
        }
        return count;
    }

    static int countWest(int y, int x, int[][]trees) {
        int height = trees[y][x];
        int count = 0;
        for (int i = x - 1; i >= 0; i--) {
            count++;
            if (trees[y][i] >= height) {
                break;
            }
        }
        return count;
    }


}