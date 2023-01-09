package mortgagepay.model;

public class LocalBanks {
  private String bankName;
  private double offerRate;
  private double credit;
  private double discount;
  private int years;
  private boolean autoPayment;

  public LocalBanks() {
  }

  public LocalBanks(String bankName, double discount, int years) {
    this.bankName = bankName;
//    this.offerRate = offerRate;
//    this.credit = credit;
    this.discount = discount;
    this.years = years;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public double getOfferRate() {
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

  public int getYears() {
    return years;
  }

  public void setYears(int years) {
    this.years = years;
  }



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

