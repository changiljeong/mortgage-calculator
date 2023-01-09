package mortgagepay.model;

public enum CreditScores {
  POOR, FAIR, HIGH, EXCELLENT
}

// if poor, not quality for any loan offers
// fair, maybe only 2 banks are offering the loan
// high, all offers
// excellence - all offers - 1% lower rate? due to high credit score benefit.
