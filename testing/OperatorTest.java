package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import calculate.Operator;

class OperatorTest {

  @Test
  void testOperator() {
    Operator op = new Operator("+");
    Operator op1 = new Operator("-");
    Operator op3 = new Operator("/");
    Operator op4 = new Operator("*");
    Operator op5 = new Operator("^");
    Operator op6 = new Operator(null);
    assertEquals("+", op.getOperator());
    assertEquals("+", op.toString());
  }

}
