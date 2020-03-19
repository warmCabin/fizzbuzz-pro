package buzz.fizz.util;

import java.util.Iterator;

public class Range implements Iterable<Integer> {

  private final int start;
  private final int stop;
  private final int step;

  public Range(final int start, final int stop, final int step) {
    this.start = start;
    this.stop = stop;
    this.step = step;

    validate();
  }

  public Range(final int start, final int stop) {
    this(start, stop, 1);
  }

  private void validate() {
    if (Integer.compare(stop, start) != Integer.signum(step)) {
      throw new IllegalArgumentException("Range should step from start to stop.");
    }
  }

  public int getStart() {
    return this.start;
  }

  public int getStop() {
    return this.stop;
  }

  public int getStep() {
    return this.step;
  }

  @Override
  public Iterator<Integer> iterator() {
    return new RangeIterator(this);
  }

  private static class RangeIterator implements Iterator<Integer> {

    private final Range range;
    private int accumulator;

    public RangeIterator(final Range range) {
      this.range = range;
      this.accumulator = range.getStart();
    }

    @Override
    public boolean hasNext() {
      return range.getStep() > 0 ?
          accumulator <= range.getStop() :
          accumulator >= range.getStop();
    }

    @Override
    public Integer next() {
      final int ret = accumulator;
      accumulator += range.getStep();
      return ret;
    }
  }
}
