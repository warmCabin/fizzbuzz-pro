package buzz.fizz.checker;

public interface Checker {

  boolean check(int n);

  /**
   * @deprecated Use {@link #check(int)} instead.
   */
  @Deprecated
  default boolean isValid(int n) {
    return check(n);
  }

  String getReplacement();
}
