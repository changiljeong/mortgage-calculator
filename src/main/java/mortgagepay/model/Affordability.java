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

  // amount of net income + credit score should determine how much they can afford + if any banks can offer them any loan.

}
