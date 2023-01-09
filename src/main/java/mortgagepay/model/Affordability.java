package mortgagepay.model;

// model for option 2 (affordability calculator)
// Calculator gives simple afforadability amount which combines all the taxes, insurace, PMI, HOA fees that users needs to consider.... message showing
// all the expenese related to homebuying & sustaining is included in the final amount??

public class Affordability {
  double monthlyIncomeBeforeTax;
  double monthlyCurrentLoanOrRent;
  double monthlyDebts;

  double monthlyUtilityBills;
  // give some examples in terminal that what kind of expenses should be combined to the user (e.g., car, cell phone, internet, gas bill, etc.)
  double monthlyOtherExpenses;
  double monthlyNetIncome;


  public Affordability(double monthlyIncomeBeforeTax, double monthlyCurrentLoanOrRent,
      double monthlyDebts, double monthlyUtilityBills, double monthlyOtherExpenses,
      double monthlyNetIncome) {
    this.monthlyIncomeBeforeTax = monthlyIncomeBeforeTax;
    this.monthlyCurrentLoanOrRent = monthlyCurrentLoanOrRent;
    this.monthlyDebts = monthlyDebts;
    this.monthlyUtilityBills = monthlyUtilityBills;
    this.monthlyOtherExpenses = monthlyOtherExpenses;
    this.monthlyNetIncome = monthlyNetIncome;
  }


  // amount of net income + credit score should determine how much they can afford + if any banks can offer them any loan.


  public double getMonthlyIncomeBeforeTax() {
    return monthlyIncomeBeforeTax;
  }

  public void setMonthlyIncomeBeforeTax(double monthlyIncomeBeforeTax) {
    this.monthlyIncomeBeforeTax = monthlyIncomeBeforeTax;
  }

  public double getMonthlyCurrentLoanOrRent() {
    return monthlyCurrentLoanOrRent;
  }

  public void setMonthlyCurrentLoanOrRent(double monthlyCurrentLoanOrRent) {
    this.monthlyCurrentLoanOrRent = monthlyCurrentLoanOrRent;
  }

  public double getMonthlyDebts() {
    return monthlyDebts;
  }

  public void setMonthlyDebts(double monthlyDebts) {
    this.monthlyDebts = monthlyDebts;
  }

  public double getMonthlyUtilityBills() {
    return monthlyUtilityBills;
  }

  public void setMonthlyUtilityBills(double monthlyUtilityBills) {
    this.monthlyUtilityBills = monthlyUtilityBills;
  }

  public double getMonthlyOtherExpenses() {
    return monthlyOtherExpenses;
  }

  public void setMonthlyOtherExpenses(double monthlyOtherExpenses) {
    this.monthlyOtherExpenses = monthlyOtherExpenses;
  }

  public double getMonthlyNetIncome() {
    return monthlyNetIncome;
  }

  public void setMonthlyNetIncome(double monthlyNetIncome) {
    this.monthlyNetIncome = monthlyNetIncome;
  }


}
