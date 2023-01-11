package mortgagepay;

import mortgagepay.model.Affordability;
import mortgagepay.model.RateType;
import mortgagepay.model.Terms;

public class main {

  public static void main(String[] args) {
    Affordability affordability = new Affordability(200000, RateType.FIXED, Terms.LONG_TERM, "Chase Bank");
    System.out.println(affordability.getAffordabilityAmount());

  }
}
