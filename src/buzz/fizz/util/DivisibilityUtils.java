package buzz.fizz.util;

public class DivisibilityUtils {

  private DivisibilityUtils() {
    // static utility class
  }

  public static int safeMod(int dividend, int divisor) {
    try {
      return dividend % divisor;
    } catch (ArithmeticException exc) {
      return 0;
    }
  }

  public static boolean isDivisibleBy(int dividend, int divisor) {
    return safeMod(dividend, divisor) == 0;
  }
}
