package services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyCalculatorTest {

    @DisplayName("Verify that addition works")
    @Test
    public void addShouldWork() {
        MyCalculator calc = new MyCalculator();
        int result = calc.add(3, 5);
        Assertions.assertEquals(8, result);
    }
}
