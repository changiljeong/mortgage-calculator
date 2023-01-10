package mortgagepay.model;

public enum CreditScores {
  POOR(500, "poor"), // user credit between 500-600, then is poor
  FAIR(600, "fair"), // user credit between 600-700, then is fair
  GOOD(700, "good"), // user credit between 700-800, then is good
  EXCELLENT(800, "excellent");// user credit above 800, then is excellent

  private final int score;
  private final String level;

  CreditScores(int score, String level){
    this.score = score;
    this.level = level;
  }

  public int getScore(){
    return score;
  }
  public String getLevel(){
    return level;
  }


}

// if poor, not quality for any loan offers
// fair, maybe only 2 banks are offering the loan
// high, all offers
// excellence - all offers - 1% lower rate? due to high credit score benefit.
