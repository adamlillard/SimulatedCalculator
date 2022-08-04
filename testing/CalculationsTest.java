package testing;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import calculate.Operand;
import utilities.Calculations;

class CalculationsTest {

  @Test
  void testCalculations() throws IOException {
    Calculations calculator = new Calculations();
    assertEquals(2.0, Calculations.add(1.0, 1.0));
    assertEquals(2.0, Calculations.multiply(2.0, 1.0));
    assertEquals(2.0, Calculations.divide(2.0, 1.0));
    assertEquals(2.0, Calculations.subtract(3.0, 1.0));
    assertEquals(1.0/9.0, Calculations.inverse(9.0));
    assertEquals(4, Calculations.power(2.0, 2.0));
    assertThrows(IllegalArgumentException.class, () -> 
    {
      Calculations.divide(2.0, 0.0);
    });
  }

}
