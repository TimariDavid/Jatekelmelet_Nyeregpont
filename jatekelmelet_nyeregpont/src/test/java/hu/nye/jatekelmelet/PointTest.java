package hu.nye.jatekelmelet;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PointTest {

    private static final double MINIMUM_FROM_FIRST_ROW = -5.6;
    private static final double MAXIMUM_FROM_FIRST_COLUMN = 4.7;
    private static final double[][] array = {
            {3.4, 7.2, -5.6, 6.9},
            {4.7, -8.5, 7.2, 6.4},
            {2.1, 3.9, 2.3, -1.6}
    };

    private Point underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Point();
        underTest.setSIZE(array.length);
    }

    @Test
    public void testWhenGivenTheMinimumElement() {
        //given in setup

        //when
        double result = underTest.rowMin(array, 0);

        //then
        assertEquals(MINIMUM_FROM_FIRST_ROW, result);
    }

    @Test
    public void testWhenGivenTheMaximumElement() {
        //given in setup

        //when
        double result = underTest.columnMax(array, 0);

        //then
        assertEquals(MAXIMUM_FROM_FIRST_COLUMN, result);
    }

    @Test
    public void testWhenTheCurrentPointIsAValidPoint() {
        //given in setup

        //when
        boolean result = underTest.validPoint();

        //then
        assertTrue(result);
    }

    @Test
    public void testWhenTheCurrentPointIsNotAValidPoint() {
        //given
        double[][] arr = {
                {5, -3, 2, 0},
                {4, 2, 0, 1},
                {7, -1, 5, 3}
        };
        underTest.setArray(arr);
        underTest.setSIZE(arr.length);

        //when
        boolean result = underTest.validPoint();

        //then
        assertFalse(result);
    }
}
