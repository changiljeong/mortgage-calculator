package mortgagepay.view;

import java.util.Locale;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mortgagepay.model.Affordability;
import mortgagepay.model.CommonVariables;
import mortgagepay.model.LocalBanks;
import mortgagepay.model.RateType;
import mortgagepay.model.Terms;


public class AffordabilityCalculator extends JFrame implements CalculatorRender {


  private JTextField jtfMonthlyIncome = new JTextField();
  private JTextField jtfMonthlyLiabilities = new JTextField();
  private JTextField jtfAffordability = new JTextField();
  private JTextField jtfLoanTerm = new JTextField();
  private JTextField jtfRateType = new JTextField();
  private JTextField jtfInterestRate = new JTextField();
  private JTextField JtfBankName = new JTextField();

  String[] choices1 = { "LONG","SHORT", };
  String[] choices2 = { "Pentagon","Navy Federal Bank","USAA"};
  String[] choices3 = {"FIXED"};
  final JComboBox<String> cb1 = new JComboBox<String>(choices1);
  final JComboBox<String> cb2 = new JComboBox<String>(choices2);
  final JComboBox<String> cb3 = new JComboBox<String>(choices3);

  private double monthlyPayment = 3728.45;

  private JLabel messageLabel = new JLabel("");
  private JButton jbtCalculator=new JButton("Submit");

  private CommonVariables variables;
  private LocalBanks localbanks;

  public AffordabilityCalculator() {
    super("Home Affordability Calculator");
    buildUI();
    setFrameOptions();

    ActionListener listenner = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        double monthlyIncome=
            Double.parseDouble(jtfMonthlyIncome.getText());

        double monthlyLiabilities=
            Double.parseDouble(jtfMonthlyLiabilities.getText());

        Terms term = Terms.valueOf((String)cb1.getSelectedItem());
        String bankName = (String)cb2.getSelectedItem();
        RateType rateType = RateType.valueOf((String)cb3.getSelectedItem());

        Affordability affordability = new Affordability(monthlyIncome, rateType, term, bankName);
        double result = affordability.getAffordabilityAmount();
        jtfAffordability.setText(String.format("%.002f", result));

        //    Affordability affordability = new Affordability(800000, RateType.STANDARD, Terms.LONG, "Chase Bank");
//    System.out.println(affordability.getAffordabilityAmount());

        localbanks = new LocalBanks(bankName,term, rateType);
        double[] offerRate = localbanks.getOfferRate();
        System.out.println(offerRate[0]);
        jtfInterestRate.setText(String.format("%.002f", offerRate[0]*100));

      }
    };
    jbtCalculator.addActionListener(listenner);

  }
  @Override
  public void buildUI() {
    Container pane = getContentPane();
    setPreferredSize(new Dimension(360, 380));
    pane.setLayout(new GridLayout(8, 2));
    JTextArea textMain1 = new JTextArea("::::::::::::::::::::::::::::::::::::::::::::: WELCOME ::::::::::::::::::::::::::::::::::::::::::::: \n"
        + "Thank you for utilizing our mortgage calculator! Our mission is to support potential\n"
        + "home buyers for getting connected with local banks for competitive rates \n"
        + "OR simply to see how much of home prices one can afford with their current debt-to-income ratio.\n"
        + "\n"
        + "Please select one of options below for your journey today with us!");

    pane.add(new JLabel("Monthly Income Before Tax $"));
    pane.add(jtfMonthlyIncome);
    pane.add(new JLabel("Monthly Liabilities $"));
    pane.add(jtfMonthlyLiabilities);
    pane.add(new JLabel("Loan Term"));
    pane.add(cb1);
    pane.add(new JLabel("Bank"));
    pane.add(cb2);
    pane.add(new JLabel("Rate Type"));
    pane.add(cb3);

    pane.add(new JLabel("Home Affordability $"));
    pane.add(jtfAffordability);
    pane.setBounds(2,2,20,0);


    jtfAffordability.setBackground(Color.LIGHT_GRAY);
    jtfAffordability.setEditable(false);

    pane.add(jbtCalculator);
    pane.add(messageLabel);
  }

  private void setFrameOptions() {
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    pack();
  }

  public static void main(String[] args) {
    new AffordabilityCalculator().setVisible(true);
  }
}