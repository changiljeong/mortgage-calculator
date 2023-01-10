package mortgagepay.model;

public class LocalBanks {
  private String bankName;
  private double[] offerRate;
  private double credit;
  private double discount;
  private int years;
  private boolean autoPayment = false;
  private String rateType;


  public LocalBanks() {
  }

  public LocalBanks(String bankName, Terms term) {
    this.bankName = bankName;
    this.years = term.getYear();
  }

  public LocalBanks(String bankName, double credit, double discount, Terms term) {
    this.bankName = bankName;
    this.offerRate = getOfferRate();
    this.credit = credit;
    this.discount = discount;
    this.years = getYears(term);
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public double[] getOfferRate() {
    switch (bankName){
      case "Chase Bank":
        if(years == 30){
          if(RateType.FIXED.getRateType().equals("fixed")){
            offerRate[0] = 0.05;
          }else{
            offerRate[0] = 0.03;
            for(int i=6,j=0; i<=30; i=i+2,j++){
              offerRate[j+1] = offerRate[j]+0.0025;
            }
          }
        }else if(years == 15){
          if(RateType.FIXED.getRateType().equals("fixed")){
            offerRate[0] = 0.05;
          }else{
            offerRate[0] = 0.0325;
            for(int i=6,j=0; i<=30; i=i+2,j++){
              offerRate[j+1] = offerRate[j]+0.0025;
            }
          }
          break;
        }

      case "Navy Federal Bank":
        if(years == 30){
          if(RateType.FIXED.getRateType().equals("fixed")){
            offerRate[0] = 0.0475;
          }else{
            offerRate[0] = 0.0325;
            for(int i=6,j=0; i<=30; i=i+2,j++){
              offerRate[j+1] = offerRate[j]+0.005;
            }
          }
        }else if(years == 15){
          if(RateType.FIXED.getRateType().equals("fixed")){
            offerRate[0] = 0.0525;
          }else{
            offerRate[0] = 0.035;
            for(int i=6,j=0; i<=30; i=i+2,j++){
              offerRate[j+1] = offerRate[j]+0.005;
            }
          }
          break;
        }

      case "USAA":
        if(years == 30){
          if(RateType.FIXED.getRateType().equals("fixed")){
            offerRate[0] = 0.045;
          }else{
            offerRate[0] = 0.0375;
            for(int i=6,j=0; i<=30; i=i+2,j++){
              offerRate[j+1] = offerRate[j]+0.0075;
            }
          }
        }else if(years == 15){
          if(RateType.FIXED.getRateType().equals("fixed")){
            offerRate[0] = 0.05;
          }else{
            offerRate[0] = 0.0375;
            for(int i=6,j=0; i<=30; i=i+2,j++){
              offerRate[j+1] = offerRate[j]+0.0075;
            }
          }
          break;
        }

    }


    return offerRate;
  }

  public void setOfferRate(String bankName, Terms term) {
    //use name and term to get offerRate
  }

  public double getCredit() {
    return credit;
  }

  public void setCredit(String bankName, boolean autoPayment) {
    //use bank name and auto payment to get credits.
  }

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public int getYears(Terms term) {
    return term.getYear();
  }

  public void setYears(int years) {
    this.years = years;
  }

//  public boolean decisionMake() { //
//    if(creditScore <700)
//      return false;
//    else{
//      if(monthlyPayment > (monthlyIncomeBeforeTax*PERCERTAGE1 + otherDebt) || monthlyPayment > monthlyIncomeBeforeTax*PERCERTAGE2){
//        return false;
//      }
//      return true;
//    }
//  }

}




/*    (Option 1) Chase Bank (ENUM)
    30 years - fixed (5%) or 3% first 5 years & .25% additional every 2 year
    15 years - fixed (5.5%) or 3.25% first 5 years & .25% additional every 2 year
    Additional Offer: .25% monthly payment off when sign up for auto-payment & 5,000 lender credit at closing.

    (Option 2) Navy Federal Bank
    30 years - fixed (4.75%) or 3.25% first 5 years & .50% additional every 2 year
    15 years - fixed (5.25%) or 3.50% first 5 years & .50% additional every 2 year
    Additional Offer: .15% monthly payment off when sign up for auto-payment.

    (Option 3) USAA
    30 years - fixed (4.5%) or 3.75% first 5 years & .75% additional every 2 year
    15 years - fixed (5%) or 3.75% first 5 years & .75% additional every 2 year
    Additional Offer: Lender credit at closing $1,000 & $10 off whn you sign up for auto-payment. */

