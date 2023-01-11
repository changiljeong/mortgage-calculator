package mortgagepay.model;

// use for commonly shared variable on manual, affordability, and local bank offers.
public class CommonVariables {

  double homeValue;
  double downPayment;
  double[] interestRate;
  double loanAmount;
  double hoaFee;
  double propertyTax;
  double ownerInsurance;
  double totalMonthlyPayment;
  double totalLoanAmount;

//  int creditScore;
//  private UserInfo user;
  private String bankName;
  private Terms term;
  private RateType rateType;


  public CommonVariables(){};

  public CommonVariables(double homeValue, double downPayment, double[] interestRate,
      double loanAmount, double hoaFee, double propertyTax, double ownerInsurance,
      double totalMonthlyPayment, double totalLoanAmount) {
    this.homeValue = homeValue;
    this.downPayment = downPayment;
    this.interestRate = interestRate;
    this.loanAmount = loanAmount;
    this.hoaFee = hoaFee;
    this.propertyTax = propertyTax;
    this.ownerInsurance = ownerInsurance;
    this.totalMonthlyPayment = totalMonthlyPayment;
    this.totalLoanAmount = totalLoanAmount;
  }

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

  public double[] getInterestRate() {
    return (new LocalBanks(bankName, term, rateType)).getOfferRate();
  }

  public void setInterestRate(double[] interestRate) {
    this.interestRate = interestRate;
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

  public double getTotalMonthlyPayment() {
    double[] offerRate = getInterestRate();
    double monthlyPayment = 0;
    double principal = homeValue-downPayment;
    int length = offerRate.length;
    if(length == 1){
      monthlyPayment = principal*offerRate[0]*Math.pow((1+offerRate[0]), 60)/(Math.pow((1+offerRate[0]),60)-1);
    }else{
      for(int i= 1; i<offerRate.length; i++){
        monthlyPayment += principal*offerRate[i]*Math.pow((1+offerRate[i]), 24)/(Math.pow((1+offerRate[i]),24)-1);
      }
    }
    return monthlyPayment + hoaFee + propertyTax + ownerInsurance;
  }



  public double getTotalLoanAmount() {
    return totalLoanAmount;
  }

  public void setTotalLoanAmount(double totalLoanAmount) {
    this.totalLoanAmount = totalLoanAmount;
  }


}
