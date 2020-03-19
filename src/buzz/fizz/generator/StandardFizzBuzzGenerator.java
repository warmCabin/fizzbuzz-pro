package buzz.fizz.generator;

import buzz.fizz.checker.AndChecker;
import buzz.fizz.checker.Checker;
import buzz.fizz.checker.IntegerDivisibilityChecker;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StandardFizzBuzzGenerator implements Generator {

  private static final Logger log = Logger.getLogger(StandardFizzBuzzGenerator.class.getName());

  private final List<Checker> checkers;

  public StandardFizzBuzzGenerator() {
    final Checker fizzChecker = new IntegerDivisibilityChecker(3, "Fizz");
    final Checker buzzChecker = new IntegerDivisibilityChecker(5, "Buzz");
    final Checker fizzBuzzChecker = new AndChecker(fizzChecker, buzzChecker);

    checkers = Arrays.asList(fizzBuzzChecker, fizzChecker, buzzChecker);
  }

  @Override
  public void generate(final int lower, final int upper) {

    for (int i = lower; i <= upper; i++) {
      final int val = i;
      if (log.isLoggable(Level.INFO)) {
        log.info(checkers.stream()
            .filter(checker -> checker.isValid(val))
            .findFirst()
            .map(Checker::getReplacement)
            .orElse(Integer.toString(i))
        );
      }
    }
  }
}
