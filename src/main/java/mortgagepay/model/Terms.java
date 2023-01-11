package mortgagepay.model;

public enum Terms {
  LONG_TERM(30, "long term"),
  SHORT_TERM(15, "short term");

  private final int year;
  private String name;

  Terms(int year, String name) {
    this.year = year;
    this.name = name;
  }

  public int getYear() {
    return year;
  }

  public String getName() {
    return name;
  }
}
