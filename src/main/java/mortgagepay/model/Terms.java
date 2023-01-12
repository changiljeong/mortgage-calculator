package mortgagepay.model;

public enum Terms {
  LONG (30, "Long Term"),
  SHORT(15, "Short Term");

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
