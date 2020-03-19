package buzz.fizz.generator;

import buzz.fizz.checker.AndChecker;
import buzz.fizz.checker.Checker;
import buzz.fizz.checker.IntegerDivisibilityChecker;
import buzz.fizz.util.Range;
import java.util.Arrays;
import java.util.List;
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
  public void generate(Range range) {

    range.forEach(i ->
        log.info(checkers.stream()
            .filter(checker -> checker.isValid(i))
            .findFirst()
            .map(Checker::getReplacement)
            .orElse(Integer.toString(i))
        )
    );
  }
}
