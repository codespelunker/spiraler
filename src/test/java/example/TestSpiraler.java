package example;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

public class TestSpiraler {

    @Test
    public void shouldBeEmptyForAnNullInput() {
        Spiraler spiraler = new Spiraler();
        List<Integer> actual = spiraler.spiral(null);

        assertEquals(new ArrayList<Integer>(), actual);
    }

    @Test
    public void shouldBeEmptyForAnEmptyMatrix() {
        int[][] multi = new int[0][0];
        Spiraler spiraler = new Spiraler();
        List<Integer> actual = spiraler.spiral(multi);

        assertEquals(new ArrayList<Integer>(), actual);
    }

    @Test
    public void shouldPrintForA1x1Matrix() {
        int[][] multi = new int[][] {{1}};
        Spiraler spiraler = new Spiraler();
        List<Integer> actual = spiraler.spiral(multi);

        List<Integer> expected = Arrays.asList(1);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPrintForA2x1Matrix() {
        int[][] multi = new int[][] {{1, 2}};
        Spiraler spiraler = new Spiraler();
        List<Integer> actual = spiraler.spiral(multi);

        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPrintForA1x2Matrix() {
        int[][] multi = new int[][] {{1}, {2}};
        Spiraler spiraler = new Spiraler();
        List<Integer> actual = spiraler.spiral(multi);

        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPrintForA2x2Matrix() {
        int[][] multi = new int[][] {{1, 2}, {4, 3}};
        Spiraler spiraler = new Spiraler();
        List<Integer> actual = spiraler.spiral(multi);

        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPrintForA2x3Matrix() {
        int[][] multi = new int[][] {{1, 2}, {6, 3}, {5, 4}};
        Spiraler spiraler = new Spiraler();
        List<Integer> actual = spiraler.spiral(multi);

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPrintForA3x3Matrix() {
        int[][] multi = new int[][] {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        Spiraler spiraler = new Spiraler();
        List<Integer> actual = spiraler.spiral(multi);

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(expected, actual);
    }

    // tail ends right
    @Test
    public void shouldPrintForA5x3Matrix() {
        int[][] multi = new int[][] {{1, 2, 3, 4, 5}, {12, 13, 14, 15, 6}, {11, 10, 9, 8, 7}};
        Spiraler spiraler = new Spiraler();
        List<Integer> actual = spiraler.spiral(multi);

        List<Integer> expected = IntStream.rangeClosed(1, 15).boxed().collect(toList());
        assertEquals(expected, actual);
    }

    // tail ends down
    @Test
    public void shouldPrintForA3x5Matrix() {
        int[][] multi = new int[][] {{1, 2, 3}, {12, 13, 4}, {11, 14, 5}, {10, 15, 6}, {9, 8, 7}};
        Spiraler spiraler = new Spiraler();
        List<Integer> actual = spiraler.spiral(multi);

        List<Integer> expected = IntStream.rangeClosed(1, 15).boxed().collect(toList());
        assertEquals(expected, actual);
    }

    // tail ends left
    @Test
    public void shouldPrintForA5x4Matrix() {
        int[][] multi = new int[][] {{1, 2, 3, 4, 5}, {14, 15, 16, 17, 6}, {13, 20, 19, 18, 7}, {12, 11, 10, 9, 8}};
        Spiraler spiraler = new Spiraler();
        List<Integer> actual = spiraler.spiral(multi);

        List<Integer> expected = IntStream.rangeClosed(1, 20).boxed().collect(toList());
        assertEquals(expected, actual);
    }

    // tail ends up
    @Test
    public void shouldPrintForA4x5Matrix() {
        int[][] multi = new int[][] {{1, 2, 3, 4}, {14, 15, 16, 5}, {13, 20, 17, 6}, {12, 19, 18, 7}, {11, 10, 9, 8}};
        Spiraler spiraler = new Spiraler();
        List<Integer> actual = spiraler.spiral(multi);

        List<Integer> expected = IntStream.rangeClosed(1, 20).boxed().collect(toList());
        assertEquals(expected, actual);
    }

    // not needed, but just to double-check
    @Test
    public void shouldPrintForA5x5Matrix() {
        int[][] multi = new int[][] {{1, 2, 3, 4, 5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}};
        Spiraler spiraler = new Spiraler();
        List<Integer> actual = spiraler.spiral(multi);

        List<Integer> expected = IntStream.rangeClosed(1, 25).boxed().collect(toList());
        assertEquals(expected, actual);
    }

}
