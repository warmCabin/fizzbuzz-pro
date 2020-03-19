package buzz.fizz.checker;

import buzz.fizz.util.DivisibilityUtils;

public class IntegerDivisibilityChecker implements Checker {

  private final int divisor;
  private final String replacement;

  public IntegerDivisibilityChecker(int divisor, String replacement) {
    this.divisor = divisor;
    this.replacement = replacement;
  }

  @Override
  public boolean check(int n) {
    return DivisibilityUtils.isDivisibleBy(n, divisor);
  }

  @Override
  public String getReplacement() {
    return replacement;
  }
}
