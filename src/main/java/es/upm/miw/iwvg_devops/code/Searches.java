package es.upm.miw.iwvg_devops.code;

import org.apache.logging.log4j.LogManager;

import java.util.Comparator;
import java.util.stream.Stream;

public class Searches {

    public Stream<String> findUserFamilyNameByUserNameDistinct(String userName) {
        return new UsersDatabase().findAll()
                .filter(user -> userName.equals(user.getName()))
                .map(User::getFamilyName)
                .distinct();
    }

    public Stream<Integer> findFractionNumeratorByUserFamilyName(String userFamilyName) {
        return new UsersDatabase().findAll()
                .peek(x -> LogManager.getLogger(this.getClass()).info("before: " + x))
                .filter(user -> userFamilyName.equals(user.getFamilyName()))
                .peek(x -> LogManager.getLogger(this.getClass()).info("after: " + x))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::getNumerator);
    }

    public Stream<String> findUserFamilyNameByFractionDenominator(int fractionDenominator) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fractionDenominator == fraction.getDenominator()))
                .map(User::getFamilyName);
    }

    public Stream<String> findUserFamilyNameInitialByAnyProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fraction.isProper()))
                .map(User::getFamilyName)
                .map(familyName -> familyName.substring(0, 1));
    }

    public Stream<String> findUserIdByAnyProperFraction() {
        return Stream.empty();
    }

    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFamilyName().equals(familyName))
                .map(user -> user.getFractions())
                .flatMap(fractions -> fractions.stream())
                .reduce(((fraction, fraction2) -> fraction2.multiply(fraction)))
                .get();
    }

    public Fraction findFirstFractionDivisionByUserId(String id) {
        return null;
    }

    public Double findFirstDecimalFractionByUserName(String name) {
        return null;
    }

    public Stream<String> findUserIdByAllProperFraction() {
        return Stream.empty();
    }

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return Stream.empty();
    }

    public Fraction findFirstProperFractionByUserId(String id) {
        return null;
    }

    public Stream<String> findUserFamilyNameByImproperFraction() {
        return Stream.empty();
    }

    public Fraction findHighestFraction() {
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream())
                .reduce((fraction, fraction2) -> fraction.compareHigher(fraction2))
                .get();
    }

    public Stream<String> findUserNameByAnyImproperFraction() {
        return Stream.empty();
    }

    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return Stream.empty();
    }

    public Stream<Double> findDecimalFractionByUserName(String name) {
        return Stream.empty();
    }

    public Stream<Double> findDecimalFractionByNegativeSignFraction() {
        return new UsersDatabase().findAll()
                .map(user -> user.getFractions())
                .flatMap(fractions -> fractions.stream())
                .filter(fraction -> fraction.isNegative())
                .map(fraction -> fraction.decimal());
    }

    public Fraction findFractionAdditionByUserId(String id) {
        return null;
    }

    public Fraction findFirstFractionSubtractionByUserName(String name) {
        return null;
    }

}
