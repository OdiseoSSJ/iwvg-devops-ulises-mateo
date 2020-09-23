package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    List<Fraction> fractions = new ArrayList<>();
    User userTest = new User("bk0064", "Ulises", "Mateo", fractions);

    @Test
    void testGetId() {
        assertEquals("bk0064", userTest.getId());
    }

    @Test
    void testGetName() {
        assertEquals("Ulises", userTest.getName());
    }

    @Test
    void testSetName() {
        userTest.setName("Prometeo");
        assertEquals("Prometeo", userTest.getName());
    }

    @Test
    void testGetFamilyName() {
        assertEquals("Mateo", userTest.getFamilyName());
    }

    @Test
    void testSetFamilyName() {
        userTest.setFamilyName("Ortega");
        assertEquals("Ortega", userTest.getFamilyName());
    }

    @Test
    void testGetFractions() {
        assertEquals(fractions, userTest.getFractions());
    }

    @Test
    void testSetFractions() {
        ArrayList<Fraction> anotherFraction = new ArrayList<>();
        userTest.setFractions(anotherFraction);
        assertEquals(anotherFraction, userTest.getFractions());
    }

    @Test
    void testAddFraction() {
        Fraction fraction = new Fraction(1, 2);
        userTest.addFraction(fraction);
        assertEquals(fraction, userTest.getFractions().get(userTest.getFractions().size() - 1));
    }

    @Test
    void testFullName() {
        assertEquals("Ulises Mateo", userTest.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("U.", userTest.initials());
    }

    @Test
    void testToString() {
        assertEquals("User{id='bk0064', name='Ulises', familyName='Mateo', fractions=[]}", userTest.toString());
    }
}
