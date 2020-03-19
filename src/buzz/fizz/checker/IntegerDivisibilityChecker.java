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

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private int divisor;
    private String replacement;

    private Builder() {
      // must instantiate via static method
    }

    public Builder divisor(final int divisor) {
      this.divisor = divisor;
      return this;
    }

    public Builder replacement(final String replacement) {
      this.replacement = replacement;
      return this;
    }

    public IntegerDivisibilityChecker build() {
      return new IntegerDivisibilityChecker(divisor, replacement);
    }
  }
}
