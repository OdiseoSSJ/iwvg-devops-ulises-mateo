package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    Fraction fractionTest = new Fraction(7, 11);

    @Test
    void testGetNumerator() {
        assertEquals(7, fractionTest.getNumerator());
    }

    @Test
    void testSetNumerator() {
        fractionTest.setNumerator(8);
        assertEquals(8, fractionTest.getNumerator());
    }

    @Test
    void testGetDenominator() {
        assertEquals(11, fractionTest.getDenominator());
    }

    @Test
    void testSetDenominator() {
        fractionTest.setDenominator(23);
        assertEquals(23, fractionTest.getDenominator());
    }

    @Test
    void testDecimal() {
        double expectedResult = (double) 7 / 11;
        assertEquals(expectedResult, fractionTest.decimal());
    }

    @Test
    void testIsProper() {
        assertTrue(fractionTest.isProper());
    }

    @Test
    void testIsImproper() {

        assertFalse(fractionTest.isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction fraction = new Fraction(14, 22);
        assertTrue(fractionTest.isEquivalent(fraction));
    }

    @Test
    void testAdd() {
        Fraction fraction = new Fraction(1, 2);
        Fraction expectedFraction = new Fraction(25, 22);
        assertTrue(fractionTest.add(fraction).isEquivalent(expectedFraction));
    }

    @Test
    void testMultiply() {
        Fraction fraction = new Fraction(1, 2);
        Fraction expectedFraction = new Fraction(7, 22);
        assertTrue(fractionTest.multiply(fraction).isEquivalent(expectedFraction));
    }

    @Test
    void testDivide() {
        Fraction fraction = new Fraction(1, 2);
        Fraction expectedFraction = new Fraction(14, 11);
        assertTrue(fractionTest.divide(fraction).isEquivalent(expectedFraction));
    }

    @Test
    void testToString() {

        assertEquals("Fraction{numerator=7, denominator=11}", fractionTest.toString());
    }
}
