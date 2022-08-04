package calculate;

import java.util.ArrayList;
import java.util.List;

/**
 * Expression Manager is used to keep the expressions in the calculator neat.
 * 
 * @author team23
 * @version 1
 */
public class ExpressionManager
{
  private Expression currExpression;
  private List<Expression> pastExpressions;
  private Operand lastAnswer;
  private boolean evaluatedExpression;

  /**
   * Expression Manager constructor creates a new manager with the current and past expression.
   */
  public ExpressionManager()
  {
    currExpression = new Expression();
    pastExpressions = new ArrayList<Expression>();
    evaluatedExpression = false;
  }

  /**
   * Gets the current expression held in the manager.
   * 
   * @return current expression
   */
  public Expression getCurrExpression()
  {
    return this.currExpression;
  }

  /**
   * Adds an operand to the current expression.
   * 
   * @param value incoming
   * @param units incoming
   */
  public void addOperand(double value, String units)
  {
    // checkReset();

    currExpression.addOperand(value, units);
  }

  /**
   * Adds the operator to the current expression.
   * 
   * @param operator incoming
   */
  public void addOperator(String operator)
  {
    // checkReset();

    // Evaluates expression
    if (operator.equals("="))
    {
      if (currExpression.completeExpression())
      {
        evalutateExpression();
      }
      return;
    }

    // Last Answer
    if (currExpression.getOperands()[0] == null && lastAnswer != null)
    {
      currExpression.addOperand(lastAnswer);
      currExpression.addOperator(operator);
    }

    // Adds normal operater
    if (currExpression.getOperands()[0] != null && currExpression.getOperator() == null)
    {
      currExpression.addOperator(operator);
    }
  }
  //
  // private void checkReset() {
  // if (currExpression.getAnswer() != null) {
  // currExpression = new Expression();
  // }
  // }

  /**
   * Provides a string version of the expression.
   * 
   * @return String representing the whole expression held in the manager.
   */
  public String toString()
  {
    if (pastExpressions.size() != 0)
    {
      if (currExpression.toString().equals("")
          && pastExpressions.get(pastExpressions.size() - 1).getAnswer() != null)
      {
        return getLastExpression();
      }
    }

    return currExpression.toString();
  }

  /**
   * Evaluates the expression in the manager.
   */
  private void evalutateExpression()
  {
    if (currExpression.evaluateExpression())
    {
      lastAnswer = currExpression.getAnswer();
      pastExpressions.add(currExpression);
      currExpression = new Expression();
    }
  }

  /**
   * Grabs the history of the expression.
   * 
   * @return String value of the history
   */
  public String getHistory()
  {
    String history = "";
    for (Expression expression : pastExpressions)
    {
      history += "\n" + expression.toString();
    }
    return history;
  }

  /**
   * Grabs the last expression in the manager and returns a string version.
   * 
   * @return String value representing the last expression in the manager
   */
  public String getLastExpression()
  {
    if (pastExpressions.size() == 0)
      return "";
    return pastExpressions.get(pastExpressions.size() - 1).toString();
  }

  /**
   * removes the last expression in the manager and adds a new one.
   * 
   * @param ex incoming
   */
  public void removeLastExpressionAndAddNew(Expression ex)
  {
    if (pastExpressions.size() == 0)
    {
      pastExpressions.add(ex);
    }
    else
    {
      pastExpressions.set(pastExpressions.size() - 1, ex);
    }
  }
}
