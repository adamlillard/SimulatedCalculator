package testing;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import calculate.Expression;
import calculate.ExpressionManager;
import calculate.Operand;
import calculate.Operator;

class ExpressionManagerTest {

  @Test
  void testExpressionManagerValid() {
    Operand op = new Operand(1.0, "Hi");
    Operand op1 = new Operand(1.0, null);
    Operand op2 = new Operand(1.0, "/");
    Operand op3 = new Operand(1.0, "-");
    ExpressionManager c = new ExpressionManager();
    ExpressionManager c1 = new ExpressionManager();
    ExpressionManager c2 = new ExpressionManager();
    ExpressionManager c3 = new ExpressionManager();
    c2.addOperand(1.0, null);
    c2.addOperand(1.0, "-");
    c3.addOperand(1.0, "/");
    c.getCurrExpression();
    c.addOperand(1.0, "Hi");
    c.addOperand(1.0, "=");
    c.addOperand(1.0, "+");
    c.addOperator("=");
    c.addOperator("+");
    assertEquals("",c1.getHistory());
    assertEquals("", c.getHistory());
    assertEquals("1.0 Hi", op.toString());
    assertEquals("1.0", op1.toString());
    assertTrue(op2.isSlash());
    assertTrue(op3.isDash());
    assertEquals(1, op1.getValue());
    assertEquals("Hi", op.getUnits());
    assertThrows(IllegalArgumentException.class, () -> 
    {
      Operand op4 = new Operand(1.0, "-/");
    });
    
    op2.setDefined("Lbs");
    assertEquals("Lbs", op2.getDefined());
  }
}
