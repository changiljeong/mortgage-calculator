package mortgagepay;

import mortgagepay.model.Affordability;
import mortgagepay.model.CommonVariables;
import mortgagepay.model.LocalBanks;
import mortgagepay.model.RateType;
import mortgagepay.model.Terms;

public class main {

  public static void main(String[] args) {
//    Affordability affordability = new Affordability(800000, RateType.STANDARD, Terms.LONG, "Chase Bank");
//    System.out.println(affordability.getAffordabilityAmount());
    CommonVariables variables = new CommonVariables(500000, 80000, 100, 200, 50, "USAA" ,Terms.LONG, RateType.STANDARD);
    double[] payment = variables.getTotalMonthlyPayment();
    for(int i=0; i<payment.length; i++){
      System.out.println(variables.getInterestRate()[i]);
      System.out.println("The monthly payment would be: " + payment[i]);
    }
  }
}
