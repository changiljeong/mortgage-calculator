package mortgagepay.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mortgagepay.model.CommonVariables;
import mortgagepay.model.LocalBanks;
import mortgagepay.model.Terms;


public class MonthlyCalculator extends JFrame implements CalculatorRender {

  private JTextField jtfHomeValue = new JTextField();
  private JTextField jtfDownPayment = new JTextField();
  private JTextField jtfLoanTerm = new JTextField();
  private JTextField jtfRateType = new JTextField();
  private JTextField jtfInterestRate = new JTextField();
  private JTextField jtfPropertyTax = new JTextField();
  private JTextField jtfOwnerInsurance = new JTextField();
  private JTextField jtfHOAFee = new JTextField();
  private double monthlyPayment = 1000000;

  private JLabel messageLabel = new JLabel();
  private JButton jbtCalculator=new JButton("Submit");

  private CommonVariables variables;
  private LocalBanks localbanks;

  public MonthlyCalculator() {
    super("MonthlyPaymentCalculator");
    buildUI();
    setFrameOptions();

    ActionListener listenner = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        double homeValue=
            Double.parseDouble(jtfHomeValue.getText());
        double downPayment=
            Double.parseDouble(jtfDownPayment.getText());
        localbanks.setTerm(Terms.valueOf(jtfLoanTerm.getText()));

        jtfInterestRate.setText(String.format("%.2f", monthlyPayment));

      }
    };
    jbtCalculator.addActionListener(listenner);

  }
  @Override
    public void buildUI() {
    Container pane = getContentPane();
    setPreferredSize(new Dimension(1000, 300));
    pane.setLayout(new GridLayout(5, 4));

    pane.add(new JLabel("HomeValue"));
    pane.add(jtfHomeValue);
    pane.add(new JLabel("Down payment"));
    pane.add(jtfDownPayment);
    pane.add(new JLabel("Loan Term"));
    pane.add(jtfLoanTerm);
    pane.add(new JLabel("Interest Rate"));
    pane.add(jtfInterestRate);
    pane.add(new JLabel("PropertyTax"));
    pane.add(jtfPropertyTax);
    pane.add(new JLabel("OwnerInsurance"));
    pane.add(jtfOwnerInsurance);
    pane.add(new JLabel("HOAFee"));
    pane.add(jtfHOAFee);

//    jtfHomeValue.setDocument(new NumberDocument());
//    jtfLoanTerm.setDocument(new NumberDocument());
//    jtfDownPayment.setDocument(new NumberDocument());


//    jtfPropertyTax.setBackground(Color.LIGHT_GRAY);
//    jtfPropertyTax.setEditable(false);
//    jtfOwnerInsurance.setBackground(Color.LIGHT_GRAY);
//    jtfOwnerInsurance.setEditable(false);
//    jtfHOAFee.setBackground(Color.LIGHT_GRAY);
//    jtfHOAFee.setEditable(false);

    pane.add(jbtCalculator);
    pane.add(messageLabel);
  }

  private void setFrameOptions() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    pack();
  }

  public static void main(String[] args) {
    new MonthlyCalculator().setVisible(true);
  }
}