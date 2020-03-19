package buzz.fizz.generator;

import buzz.fizz.checker.AndChecker;
import buzz.fizz.checker.Checker;
import buzz.fizz.checker.IntegerDivisibilityChecker;
import java.util.logging.Logger;

public class StandardFizzBuzzGenerator implements Generator {

  private static final Logger log = Logger.getLogger(StandardFizzBuzzGenerator.class.getName());

  @Override
  public void generate(int lower, int upper) {
    Checker fizzChecker = new IntegerDivisibilityChecker(3, "Fizz");
    Checker buzzChecker = new IntegerDivisibilityChecker(5, "Buzz");
    Checker fizzBuzzChecker = new AndChecker(fizzChecker, buzzChecker);

    for(int i = lower; i <= upper; i++) {
      if (fizzBuzzChecker.isValid(i)) {
        log.info(fizzBuzzChecker.getReplacement());
      } else if (fizzChecker.isValid(i)) {
        log.info(fizzChecker.getReplacement());
      } else if (buzzChecker.isValid(i)) {
        log.info(buzzChecker.getReplacement());
      } else {
        log.info(Integer.toString(i));
      }
    }
  }
}
