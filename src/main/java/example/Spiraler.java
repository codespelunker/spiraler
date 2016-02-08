package example;

import java.util.ArrayList;
import java.util.List;

public class Spiraler {

    public static void main(String[] args) {

        Spiraler s = new Spiraler();
        int[][] multi = new int[][] {{1, 2, 3, 4, 5, 6, 7}, {28, 29, 30, 31, 32, 33, 8}, {27, 48, 49, 50, 51, 34, 9},
                {26, 47, 60, 61, 52, 35, 10}, {25, 46, 59, 62, 53, 36, 11}, {24, 45, 58, 63, 54, 37, 12},
                {23, 44, 57, 56, 55, 38, 13}, {22, 43, 42, 41, 40, 39, 14}, {21, 20, 19, 18, 17, 16, 15}};
        System.out.println(s.spiral(multi));
    }

    //
    // Assumptions: 
    // - every row in the input array is the same length
    //
    public List<Integer> spiral(int[][] multi) {
        if (multi == null || multi.length == 0) {
            return new ArrayList<Integer>();
        }

        return crawlOuterLoop(multi, 0, 0, multi[0].length - 1, multi.length - 1);
    }

    private List<Integer> crawlOuterLoop(int[][] multi, int startx, int starty, int maxx, int maxy) {
        List<Integer> list = new ArrayList<>();
        if (multi[starty].length == 0) {
            return list;
        }

        // across
        for (int x = startx; x <= maxx; x++) {
            list.add(multi[starty][x]);
        }

        // down (skips the first and the last)
        if (maxy - starty > 1) {
            for (int y = starty + 1; y < maxy; y++) {
                list.add(multi[y][maxx]);
            }
        }

        // back
        if (maxy - starty > 0) {
            for (int x = maxx; x >= startx; x--) {
                list.add(multi[maxy][x]);
            }
        }

        // up (skips the first and the last)
        if (maxy - starty > 1 && maxx - startx > 0) {
            for (int y = maxy - 1; y >= starty + 1; y--) {
                list.add(multi[y][startx]);
            }
        }

        // Recursion cases:
        // 1.  Remaining inner values along the "x" access
        // 2.  Remaining inner values along the "y" access
        // 3.  Exactly one point in the middle (for a 3x3)
        if (maxx - startx > 2 || maxy - starty > 2 || (startx + 1 == maxx - 1 && starty + 1 == maxy - 1)) {
            list.addAll(crawlOuterLoop(multi, startx + 1, starty + 1, maxx - 1, maxy - 1));
        }

        return list;

    }

}
