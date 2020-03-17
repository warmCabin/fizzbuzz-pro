package buzz.fizz.config;

public class FizzBuzzConfiguration {

  public static final String LOGGING_FORMAT = "[%1$tF %1$tT] [%4$-7s] [%2$s] %5$s %n";

  public static void configure() {
    System.setProperty("java.util.logging.SimpleFormatter.format",
        LOGGING_FORMAT
    );
  }
}
