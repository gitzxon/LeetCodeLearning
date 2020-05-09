package study.stringtodouble;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void main() {
    }

    @Test
    public void convert_1() {
        assertTrue(
                doubleEquals(1.0, Solution.convert("1.0"))
        );
    }

    @Test
    public void convert_2() {
        assertTrue(
                doubleEquals(123.45, Solution.convert("123.45"))
        );
    }

    @Test
    public void convert_3() {
        assertTrue(
                doubleEquals(-2.0, Solution.convert("-2"))
        );
        assertTrue(
                doubleEquals(-2.0, Solution.convert("-2.0"))
        );
    }

    @Test
    public void convert_4() {
        assertTrue(
                doubleEquals(0.003, Solution.convert("0.003"))
        );
    }

    private boolean doubleEquals(double a, double b) {
        return (Math.abs(a - b) <= 0.00001);
    }
}