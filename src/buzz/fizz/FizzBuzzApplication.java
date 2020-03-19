package buzz.fizz;

import buzz.fizz.config.FizzBuzzConfiguration;
import buzz.fizz.generator.Generator;
import buzz.fizz.generator.StandardFizzBuzzGenerator;
import buzz.fizz.util.Range;

public class FizzBuzzApplication {

  public static void main(String[] args) {

    FizzBuzzConfiguration.configure();

    Generator gen = new StandardFizzBuzzGenerator();
    gen.generate(new Range(0, 100));
  }
}
