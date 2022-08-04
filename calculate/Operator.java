package calculate;

/**
 * Operator class.
 * 
 * @author team23
 * @version 05/04/2022
 *
 */
public class Operator
{
  private String operator;

  /**
   * This is the constructor for operations.
   * 
   * @param operator
   *          the operation.
   */
  public Operator(String operator)
  {
    if (operator != null && (operator.equals("+") || operator.equals("-") || operator.equals("/")
        || operator.equals("*") || operator.equals("^")))
    {
      this.operator = operator;
    }
  }

  /**
   * This is a getter method.
   * 
   * @return operation
   */
  public String getOperator()
  {
    return this.operator;
  }

  public String toString()
  {
    return this.operator;
  }

}
