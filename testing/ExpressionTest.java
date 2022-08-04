package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import calculate.Expression;
import calculate.Operand;
import calculate.Operator;

class ExpressionTest {

  @Test
  void testExpressionValid() {
    Expression c = new Expression();
    Expression c2 = new Expression(new Operand(1.0, "Lbs"), new Operand(1.0, "Ounces"), new Operator("+"));
    c.addOperand(new Operand(1.0, "Ounces"));
    c.addOperand(0, "unit1");
    c.addOperator("Unit 2");
    c.addOperand(0, "unit2");
    assertEquals("1.0 Ounces null 0.0 unit1", c.toString());
  }
  
  @Test
  void testExpressionNoOperator() {
    Expression c = new Expression();
    c.addOperand(0, "unit1");
    c.addOperator(new Operator("+"));
    c.addOperator(new Operator("="));
    assertEquals("0.0 unit1 +", c.toString());
  }
  
  @Test
  void testExpressionInValid() {
    Expression c = new Expression();
    assertEquals("", c.toString());
  }

}
