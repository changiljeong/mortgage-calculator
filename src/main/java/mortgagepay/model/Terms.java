package mortgagepay.model;

public enum Terms {
  LONG_TERM(30),
  SHORT_TERM(15);

  private final int year;

  Terms(int year) {
    this.year = year;
  }

  public int getYear() {
    return year;
  }
}
