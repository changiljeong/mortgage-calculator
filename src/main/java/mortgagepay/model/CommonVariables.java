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

  public CommonVariables(double homeValue, double downPayment, double propertyTax, double ownerInsurance, double hoaFee,String bankName, Terms term, RateType rateType) {
    this.homeValue = homeValue;
    this.downPayment = downPayment;
    this.loanAmount = getLoanAmount();
    this.hoaFee = hoaFee;
    this.propertyTax = propertyTax;
    this.ownerInsurance = ownerInsurance;
    this.bankName = bankName;
    this.term = term;
    this.rateType = rateType;
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


  public double getLoanAmount() {
    return homeValue-downPayment;
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

  public double[] getTotalMonthlyPayment() {
    double[] offerRate = getInterestRate();
    int length = offerRate.length;
    double[] fixedMonthlyPayment = new double[1];
    double[] APRMonthlyPayment = new double[offerRate.length];
    double principal = homeValue-downPayment;
    if(rateType.getRateType().equals("fixed")){
      fixedMonthlyPayment[0] = principal*offerRate[0]/12*Math.pow((1+offerRate[0]), term.getYear()*12)/(Math.pow((1+offerRate[0]),term.getYear()*12)-1);
      return fixedMonthlyPayment;
    }else{
      APRMonthlyPayment[0] = principal*offerRate[0]/12*Math.pow((1+offerRate[0]),60)/(Math.pow((1+offerRate[0]),60)-1);
      principal -= APRMonthlyPayment[0]* 60 * 0.7;
      for(int i= 1; i<offerRate.length; i++){
        APRMonthlyPayment[i] = principal*offerRate[i]/12*Math.pow((1+offerRate[i]), 24)/(Math.pow((1+offerRate[i]),24)-1);
        principal -= APRMonthlyPayment[i]* 24 * 0.85;
      }
      return APRMonthlyPayment;
    }
  }



  public double getTotalLoanAmount() {
    return totalLoanAmount;
  }

  public void setTotalLoanAmount(double totalLoanAmount) {
    this.totalLoanAmount = totalLoanAmount;
  }


}
