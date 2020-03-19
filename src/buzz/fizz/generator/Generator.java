package buzz.fizz.generator;

import buzz.fizz.util.Range;

public interface Generator {

  /**
   * @deprecated Use {@link #generate(Range)} instead.
   */
  @Deprecated
  default void generate(int lower, int upper) {
    generate(new Range(lower, upper, 1));
  }

  void generate(Range range);
}
