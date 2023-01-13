package mortgagepay.model;

/*
 * Affordability is used to calculate if a house price
 * is affordable for a customer according his income and debt
 */
public class Affordability {

  //28/36 rule
  private double PERCERTAGE1 = 0.28;
  private double PERCERTAGE2 = 0.36;


  private double monthlyIncomeBeforeTax;
  private double monthlyLiabilities;

  private RateType rateType;
  private Terms term;
  private String bankName;

  //constructor
  public Affordability(double monthlyIncomeBeforeTax, RateType rateType, Terms term, String bankName) {
    this.monthlyIncomeBeforeTax = monthlyIncomeBeforeTax;
    this.rateType = rateType;
    this.bankName = bankName;
    this.term= term;
  }

  public Affordability(double monthlyIncomeBeforeTax, RateType rateType, Terms term, String bankName, double monthlyLiabilities) {
    this.monthlyIncomeBeforeTax = monthlyIncomeBeforeTax;
    this.rateType = rateType;
    this.bankName = bankName;
    this.term= term;
    this.monthlyLiabilities = monthlyLiabilities;
  }

  public double getAffordabilityAmount(){

    double paymentTwentyEight = monthlyIncomeBeforeTax*PERCERTAGE1;
    double paymentThirtySix = (monthlyIncomeBeforeTax-monthlyLiabilities)*PERCERTAGE2;
    double payment=0.0;

    if (paymentTwentyEight<paymentThirtySix) {
      payment = paymentTwentyEight;
    } else {
      payment = paymentThirtySix;
    }

    int monthsOfTerm = term.getYear()*12;
    double[] offerRate = new LocalBanks(bankName,term, rateType).getOfferRate();
    double rte = offerRate[0]/12;
    double amt = payment/(rte + (rte/(Math.pow((1+rte), (monthsOfTerm))-1)));

    System.out.println("\n"
        + "----------------------------------------------------------------------------------------------------------");
    System.out.printf("Hey There! Thank you for using our affordability calculator!\n"
        + "With your current monthly income of $%.2f & current monthly debts of $%.2f, you can afford %s mortgage up to $%.2f.\n"
        + "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: \n"
        + "FYI - Most banks utilize 28 or 36 percent rule which is that your mortgage payment shouldn't be 28 percent of your monthly pre-tax income \n"
        + "and 36 percent of your total debt.\n"
        + "Our result displays the lower available amount from the rule as most of lenders will expect. ", monthlyIncomeBeforeTax, monthlyLiabilities,term, amt);
    System.out.println("\n"
        + "----------------------------------------------------------------------------------------------------------");
    return amt;
  }

}