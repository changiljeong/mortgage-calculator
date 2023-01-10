package mortgagepay.model;

public enum RateType {
  FIXED("fixed"), STANDARD("standard");

  private final String type;

  RateType(String type){
    this.type = type;
  }

  public String getRateType(){
    return type;
  }

}
