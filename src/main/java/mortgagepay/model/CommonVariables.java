package mortgagepay.model;

// use for commonly shared variable on manual, affordability, and local bank offers.
public class CommonVariables {

  public double getHomeValue() {
    return homeValue;
  }

  public void setHomeValue(double homeValue) {
    this.homeValue = homeValue;
  }

  public double getDownPayment() {
    return downPayment;
  }

  public void setDownPayment(double downPayment) {
    this.downPayment = downPayment;
  }

  public double getInterestRate() {
    return InterestRate;
  }

  public void setInterestRate(double interestRate) {
    InterestRate = interestRate;
  }

  public int getLoanTerm() {
    return loanTerm;
  }

  public void setLoanTerm(int loanTerm) {
    this.loanTerm = loanTerm;
  }

  public double getLoanAmount() {
    return loanAmount;
  }

  public void setLoanAmount(double loanAmount) {
    this.loanAmount = loanAmount;
  }

  public double getHoaFee() {
    return hoaFee;
  }

  public void setHoaFee(double hoaFee) {
    this.hoaFee = hoaFee;
  }

  public double getPropertyTax() {
    return propertyTax;
  }

  public void setPropertyTax(double propertyTax) {
    this.propertyTax = propertyTax;
  }

  public double getOwnerInsurance() {
    return ownerInsurance;
  }

  public void setOwnerInsurance(double ownerInsurance) {
    this.ownerInsurance = ownerInsurance;
  }

  public int getZipCode() {
    return zipCode;
  }

  public void setZipCode(int zipCode) {
    this.zipCode = zipCode;
  }

  public int getCreditScore() {
    return creditScore;
  }

  public void setCreditScore(int creditScore) {
    this.creditScore = creditScore;
  }

  public double getTotalPaymentDue() {
    return totalPaymentDue;
  }

  public void setTotalPaymentDue(double totalPaymentDue) {
    this.totalPaymentDue = totalPaymentDue;
  }

  public double getTotalMonthlyPayment() {
    return totalMonthlyPayment;
  }

  public void setTotalMonthlyPayment(double totalMonthlyPayment) {
    this.totalMonthlyPayment = totalMonthlyPayment;
  }

  public CommonVariables(double homeValue, double downPayment, double interestRate, int loanTerm,
      double loanAmount, double hoaFee, double propertyTax, double ownerInsurance, int zipCode,
      int creditScore, double totalPaymentDue, double totalMonthlyPayment) {
    this.homeValue = homeValue;
    this.downPayment = downPayment;
    InterestRate = interestRate;
    this.loanTerm = loanTerm;
    this.loanAmount = loanAmount;
    this.hoaFee = hoaFee;
    this.propertyTax = propertyTax;
    this.ownerInsurance = ownerInsurance;
    this.zipCode = zipCode;
    this.creditScore = creditScore;
    this.totalPaymentDue = totalPaymentDue;
    this.totalMonthlyPayment = totalMonthlyPayment;
  }

  double homeValue;
  double downPayment;
  double InterestRate;
  int loanTerm;
  double loanAmount;
  double hoaFee;
  double propertyTax;
  double ownerInsurance;
  int zipCode;
  int creditScore;
  double totalPaymentDue;
  double totalMonthlyPayment;

  //private UserInfo user = new UserInfo(inputlater, userinputlater);


}
