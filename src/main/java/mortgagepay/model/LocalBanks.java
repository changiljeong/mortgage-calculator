package mortgagepay.model;

public class LocalBanks {
  private String bankName;
  private double[] offerRate;
  private double credit;
  private double discount;
  private int years;
  private boolean autoPayment = false;
  private RateType rateType;
  private Terms term;


  public LocalBanks() {
  }

  public LocalBanks(String bankName, Terms term, RateType rateType) {
    this.bankName = bankName;
    this.term = term;
    this.rateType = rateType;
  }

  public LocalBanks(String bankName, double credit, double discount, Terms term) {
    this.bankName = bankName;
    this.credit = credit;
    this.discount = discount;
    this.years = term.getYear();
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public double[] getOfferRate() {
    double[] offerRate1 = new double[14];
    double[] offerRate2 = new double[7];
    switch (bankName){
      case "Chase Bank":
        if(term.getYear() == 30){
          if(rateType.getRateType().equals("fixed")){
            offerRate1[0] = 0.05;
          }else{
            offerRate1[0] = 0.03;
            for(int i=6,j=0; i<=30; i=i+2,j++){
              offerRate1[j+1] = offerRate1[j]+0.0025;
            }
          }
          return offerRate1;
        }else if(term.getYear() == 15){
          if(rateType.getRateType().equals("fixed")){
            offerRate2[0] = 0.05;
          }else{
            offerRate2[0] = 0.0325;
            for(int i=6,j=0; i<=15; i=i+2,j++){
              offerRate2[j+1] = offerRate2[j]+0.0025;
            }
          }
          return offerRate2;
        }

      case "Navy Federal Bank":
        if(term.getYear() == 30){
          if(rateType.getRateType().equals("fixed")){
            offerRate1[0] = 0.0475;
          }else{
            offerRate1[0] = 0.0325;
            for(int i=6,j=0; i<=30; i=i+2,j++){
              offerRate1[j+1] = offerRate1[j]+0.005;
            }
          }
          return offerRate1;
        }else if(term.getYear() == 15){
          if(rateType.equals("fixed")){
            offerRate2[0] = 0.0525;
          }else{
            offerRate2[0] = 0.035;
            for(int i=6,j=0; i<=15; i=i+2,j++){
              offerRate2[j+1] = offerRate2[j]+0.005;
            }
          }
          return offerRate2;
        }

      case "USAA":
        if(term.getYear() == 30){
          if(RateType.FIXED.getRateType().equals("fixed")){
            offerRate1[0] = 0.045;
          }else{
            offerRate1[0] = 0.0375;
            for(int i=6,j=0; i<=30; i=i+2,j++){
              offerRate1[j+1] = offerRate1[j]+0.0075;
            }
          }
          return offerRate1;
        }else if(term.getYear() == 15){
          if(RateType.FIXED.getRateType().equals("fixed")){
            offerRate2[0] = 0.05;
          }else{
            offerRate2[0] = 0.0375;
            for(int i=6,j=0; i<=15; i=i+2,j++){
              offerRate2[j+1] = offerRate2[j] + 0.0075;
            }
          }
          return offerRate2;
        }

    }


    return offerRate;
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
    this.years= years;
  }

  public Terms getTerm() {
    return term;
  }

  public void setTerm(Terms term) {
    this.term = term;
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

