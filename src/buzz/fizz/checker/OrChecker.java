package buzz.fizz.checker;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrChecker implements Checker {

  private List<Checker> constituents;
  private String replacement;

  public OrChecker(List<Checker> checkers) {
    this.constituents = checkers;
    setReplacementFromConstituents();
  }

  public OrChecker(Checker... checkers) {
    this(Arrays.asList(checkers));
  }

  public OrChecker(String replacement, List<Checker> checkers) {
    this.replacement = replacement;
    this.constituents = checkers;
  }

  public OrChecker(String replacement, Checker... checkers) {
    this(replacement, Arrays.asList(checkers));
  }

  private void setReplacementFromConstituents() {
    replacement = constituents.stream()
        .map(Checker::getReplacement)
        .collect(Collectors.joining());
  }

  @Override
  public boolean isValid(int n) {
    return constituents.stream().anyMatch(checker -> checker.isValid(n));
  }

  @Override
  public String getReplacement() {
    return replacement;
  }
}
