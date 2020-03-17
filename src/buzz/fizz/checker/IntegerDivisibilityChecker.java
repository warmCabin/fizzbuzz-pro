package buzz.fizz.checker;

import buzz.fizz.util.DivisibilityUtils;

public class IntegerDivisibilityChecker implements Checker {

  private int divisor;
  private String replacement;

  public IntegerDivisibilityChecker(int divisor, String replacement) {
    this.divisor = divisor;
    this.replacement = replacement;
  }

  @Override
  public boolean isValid(int n) {
    return DivisibilityUtils.isDivisibleBy(n, divisor);
  }

  @Override
  public String getReplacement() {
    return replacement;
  }
}
