package mortgagepay.model;

// model for option 2 (affordability calculator)
// Calculator gives simple afforadability amount which combines all the taxes, insurace, PMI, HOA fees that users needs to consider.... message showing
// all the expenese related to homebuying & sustaining is included in the final amount??

import java.io.PrintStream;

public class Affordability {

  private double PERCERTAGE1 = 0.28;
  private double PERCERTAGE2 = 0.36;

  private double monthlyIncomeBeforeTax;
  private double otherDebt;
  private int monthsOfTerm ;

//  private double monthlyPayment;
  private int downPayment;
  private RateType rateType;
  private Terms term;
  private String bankName;

  public Affordability(double monthlyIncomeBeforeTax, RateType rateType, Terms term, String bankName) {
    this.monthlyIncomeBeforeTax = monthlyIncomeBeforeTax;
    this.rateType = rateType;

    this.bankName = bankName;
    this.term= term;
  }

  public double getMonthlyPayment(){
    return 0;
  }


  public double getAffordabilityAmount(){
     double payment = monthlyIncomeBeforeTax*PERCERTAGE1;
    int monthsOfTerm = term.getYear()*12;
     double[] offerRate = new LocalBanks(bankName,term, rateType).getOfferRate();
     double rte = offerRate[0];
    double amt = payment/(rte + (rte/(Math.pow((1+rte), monthsOfTerm)))-1);
     return amt;
  }

}
