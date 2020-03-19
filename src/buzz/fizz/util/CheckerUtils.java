package buzz.fizz.util;

import buzz.fizz.checker.AndChecker;
import buzz.fizz.checker.Checker;
import buzz.fizz.checker.OrChecker;

public class CheckerUtils {

  private CheckerUtils() {
    // static utility class
  }

  public static Checker and(Checker... checkers) {
    return new AndChecker(checkers);
  }

  public static Checker and(String replacement, Checker... checkers) {
    return new AndChecker(replacement, checkers);
  }

  public static Checker or(Checker... checkers) {
    return new OrChecker(checkers);
  }

  public static Checker or(String replacement, Checker... checkers) {
    return new OrChecker(replacement, checkers);
  }

}
