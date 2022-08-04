package calculate;

import utilities.Calculations;
import utilities.UnitConversions;

/**
 * Represents a single math equation with a single operator and two operands.
 * 
 * @author team23
 * @version 05/02/2022
 */
public class Expression
{
  private static final String PLUS = "+";
  private static final String MINUS = "-";
  private static final String MULTIPLY = "*";
  private static final String DIVIDE = "/";
  private static final String POWER = "^";
  private static final String SPACE = " ";

  private Operand[] operands;
  private Operator operator;
  private Operand answer;
  private String resultUnit;

  /**
   * Default constructor.
   */
  public Expression()
  {
    this.operands = new Operand[2];
  }

  /**
   * Explicit value constructor.
   * 
   * @param operandOne incoming
   * @param operandTwo incoming
   * @param operator incoming
   */
  public Expression(final Operand operandOne, final Operand operandTwo, final Operator operator)
  {
    this.operands = new Operand[2];
    addOperand(operandOne);
    addOperand(operandTwo);
    this.operator = operator;
  }

  /**
   * Add an incoming operand with a value and unit.
   * 
   * @param value incoming
   * @param unit incoming
   */
  public void addOperand(final double value, final String unit)
  {
    if (operands[0] == null)
    {
      operands[0] = new Operand(value, unit);
    }
    else if (operands[1] == null)
    {
      operands[1] = new Operand(value, unit);
    }
  }

  /**
   * Add an incoming predefined operand.
   * 
   * @param operand incoming
   */
  public void addOperand(final Operand operand)
  {
    if (operands[0] == null)
    {
      operands[0] = operand;
    }
    else if (operands[1] == null)
    {
      operands[1] = operand;
    }
  }

  /**
   * Add an incoming predefined operator.
   * 
   * @param op incoming
   */
  public void addOperator(final Operator op)
  {
    if (this.operator == null)
    {
      this.operator = op;
    }
  }

  /**
   * Add an operator with a string.
   * 
   * @param op incoming
   */
  public void addOperator(final String op)
  {
    if (op.equals("="))
    {

    }
    else if (this.operator == null)
    {
      this.operator = new Operator(op);
    }
  }

  /**
   * Figure out the answer to this expression.
   * 
   * @return if expression was successfully evaluated
   */
  public boolean evaluateExpression()
  {

    Operand one = getOperands()[0];
    Operand two = getOperands()[1];

    double first = one.getValue();
    double second = two.getValue();

    boolean wasEvaluated = false;
    boolean hasEqualUnits = false;

    if (one.getUnits().equals(two.getUnits()))
    {
      hasEqualUnits = true;
    }
    else
    {
      double[] cons = conversionsBefore(one, two);
      first = cons[0];
      second = cons[1];
    }

    if (completeExpression())
    {
      switch (operator.getOperator())
      {

        case PLUS:
          if (hasEqualUnits && one.getDefined().equals(two.getDefined()))
          {
            answer = new Operand(Calculations.add(first, second), one.getUnits());
            answer.setDefined(one.getDefined());
            double temp = conversionAfter(one.getUnits());
            answer = new Operand(temp, unitCalculate());
          }
          else
          {
            answer = new Operand(Calculations.add(first, second), unitCalculate());
          }
          wasEvaluated = true;
          break;
        case MINUS:
          if (hasEqualUnits && one.getDefined().equals(two.getDefined()))
          {
            answer = new Operand(Calculations.subtract(first, second), one.getUnits());
            answer.setDefined(one.getDefined());
            double temp = conversionAfter(one.getUnits());
            answer = new Operand(temp, unitCalculate());
          }
          else
          {
            answer = new Operand(Calculations.subtract(first, second), unitCalculate());
          }
          wasEvaluated = true;
          break;
        case DIVIDE:
          if (hasEqualUnits && one.getDefined().equals(two.getDefined()))
          {
            answer = new Operand(Calculations.divide(first, second), one.getUnits());
            answer.setDefined(one.getDefined());
            double temp = conversionAfter(one.getUnits());
            answer = new Operand(temp, unitCalculate());
          }
          else
          {
            answer = new Operand(Calculations.divide(first, second), unitCalculate());
          }
          wasEvaluated = true;
          break;
        case MULTIPLY:
          if (hasEqualUnits && one.getDefined().equals(two.getDefined()))
          {
            answer = new Operand(Calculations.multiply(first, second), one.getUnits());
            answer.setDefined(one.getDefined());
            double temp = conversionAfter(one.getUnits());
            answer = new Operand(temp, unitCalculate());
          }
          else
          {
            answer = new Operand(Calculations.multiply(first, second), unitCalculate());
          }
          wasEvaluated = true;
          break;
        case POWER:
          if (hasEqualUnits && one.getDefined().equals(two.getDefined()))
          {
            answer = new Operand(Calculations.power(first, second), one.getUnits());
            answer.setDefined(one.getDefined());
            double temp = conversionAfter(one.getUnits());
            answer = new Operand(temp, unitCalculate());
          }
          else
          {
            answer = new Operand(Calculations.power(first, second), unitCalculate());
          }
          wasEvaluated = true;
          break;
        default:
          return wasEvaluated;
      }
    }
    return wasEvaluated;
  }

  private double[] conversionsBefore(final Operand one, final Operand two)
  {
    double first = one.getValue();
    double second = two.getValue();

    if (!one.getDefined().equals("") && !two.getDefined().equals(""))
    {
      if (one.getDefined().equals(two.getDefined()))
      {
        switch (one.getDefined())
        {
          case "LENGTH":
            first = UnitConversions.lengthConversions(one.getUnits(), one.getValue(), resultUnit);
            second = UnitConversions.lengthConversions(two.getUnits(), two.getValue(), resultUnit);
            break;
          case "MONEY":
            first = UnitConversions.moneyConversions(one.getUnits(), one.getValue(), resultUnit);
            second = UnitConversions.moneyConversions(two.getUnits(), two.getValue(), resultUnit);
            break;
          case "TIME":
            first = UnitConversions.timeConversions(one.getUnits(), one.getValue(), resultUnit);
            second = UnitConversions.timeConversions(two.getUnits(), two.getValue(), resultUnit);
            break;
          case "VOLUME":
            first = UnitConversions.volumeConversions(one.getUnits(), one.getValue(), resultUnit);
            second = UnitConversions.volumeConversions(two.getUnits(), two.getValue(), resultUnit);
            break;
          case "WEIGHT":
            first = UnitConversions.weightConversions(one.getUnits(), one.getValue(), resultUnit);
            second = UnitConversions.weightConversions(two.getUnits(), two.getValue(), resultUnit);
            break;
          default:
            first = one.getValue();
            second = two.getValue();
        }
      }
    }

    double[] cons = new double[2];
    cons[0] = first;
    cons[1] = second;

    return cons;
  }

  private double conversionAfter(final String unit)
  {

    double temp = answer.getValue();

    if (!answer.getUnits().equals(""))
    {
      switch (answer.getDefined())
      {
        case "LENGTH":
          temp = UnitConversions.lengthConversions(answer.getUnits(), answer.getValue(),
              resultUnit);
          break;
        case "MONEY":
          temp = UnitConversions.moneyConversions(answer.getUnits(), answer.getValue(), resultUnit);
          break;
        case "TIME":
          temp = UnitConversions.timeConversions(answer.getUnits(), answer.getValue(), resultUnit);
          break;
        case "VOLUME":
          temp = UnitConversions.volumeConversions(answer.getUnits(), answer.getValue(),
              resultUnit);
          break;
        case "WEIGHT":
          temp = UnitConversions.weightConversions(answer.getUnits(), answer.getValue(),
              resultUnit);
          break;
        default:
          temp = answer.getValue();
      }
    }

    return temp;
  }

  /**
   * Calculate the correct unit for the answer.
   * 
   * @return unit
   */
  private String unitCalculate()
  {
    String result = "";
    Operand one = operands[0];
    Operand two = operands[1];

    boolean equals = one.getUnits().equals(two.getUnits());
    boolean noneEmpty = !(one.getUnits().isEmpty() || two.getUnits().isEmpty());

    if (!resultUnit.equals("") && one.getDefined().equals(two.getDefined()))
    {
      return resultUnit;
    }

    switch (operator.toString())
    {
      case PLUS:
        if (equals && noneEmpty)
        {
          result = one.getUnits();
        }
        break;
      case MINUS:
        if (equals && noneEmpty)
        {
          result = one.getUnits();
        }
        break;
      case POWER:
        if (equals && noneEmpty)
        {
          result = one.getUnits();
        }
        break;
      case MULTIPLY:
        if (equals && noneEmpty)
        {
          result = one.getUnits() + "^2";
        }
        else if (noneEmpty)
        {
          result = one.getUnits() + MINUS + two.getUnits();
        }
        break;
      case DIVIDE:
        if (equals && noneEmpty)
        {
          result = one.getUnits();
        }
        else if (noneEmpty)
        {
          result = one.getUnits() + DIVIDE + two.getUnits();
        }
        break;
      default:
        // do nothing
        result = one.getUnits();
    }
    return result;
  }

  /**
   * This method checks to see if an expression is complete.
   * 
   * @return if full;
   */
  public boolean completeExpression()
  {
    return operator != null && operands[0] != null && operands[1] != null;
  }

  /**
   * This method prints out the whole expression
   */
  public String toString()
  {
    String a = "";
    if (operands[0] == null)
      return a;
    a += operands[0].toString();
    if (operator == null)
      return a;
    a += " " + operator.toString();
    if (operands[1] == null)
      return a;
    a += " " + operands[1].toString();
    if (answer == null)
      return a;
    return a + " = " + answer.toString();
  }

  /**
   * Get expression operator.
   * 
   * @return operator
   */
  public Operator getOperator()
  {
    return this.operator;
  }

  /**
   * Get expression values.
   * 
   * @return operands
   */
  public Operand[] getOperands()
  {
    return this.operands;
  }

  /**
   * Get expression answer.
   * 
   * @return answer
   */
  public Operand getAnswer()
  {
    return this.answer;
  }

  /**
   * Set all expressions components to null.
   */
  public void setNull()
  {
    this.operands[0] = null;
    this.operands[1] = null;
    this.operator = null;
  }

  /**
   * Get the specified answer unit.
   * 
   * @return answer unit
   */
  public String getResultUnit()
  {
    return resultUnit;
  }

  /**
   * Set specified answer unit.
   * 
   * @param incoming incoming
   */
  public void setResultUnit(final String incoming)
  {
    this.resultUnit = incoming;
  }
}
