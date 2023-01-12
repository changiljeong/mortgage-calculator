package mortgagepay.view;

import java.util.Locale;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mortgagepay.model.CommonVariables;
import mortgagepay.model.LocalBanks;
import mortgagepay.model.RateType;
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
  private JTextField JtfBankName = new JTextField();

  String[] choices1 = { "LONG","SHORT", };
  String[] choices2 = { "Pentagon","Navy Federal Bank","USAA"};
  String[] choices3 = {"FIXED","STANDARD"};
  final JComboBox<String> cb1 = new JComboBox<String>(choices1);
  final JComboBox<String> cb2 = new JComboBox<String>(choices2);
  final JComboBox<String> cb3 = new JComboBox<String>(choices3);

  private double monthlyPayment = 3728.45;

  private JLabel messageLabel = new JLabel("");
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


        Terms term = Terms.valueOf((String)cb1.getSelectedItem());
        String bankName = (String)cb2.getSelectedItem();
        RateType rateType = RateType.valueOf((String)cb3.getSelectedItem());

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
    setPreferredSize(new Dimension(240, 380));
    pane.setLayout(new GridLayout(10, 2));

    pane.add(new JLabel("HomeValue"));
    pane.add(jtfHomeValue);
    pane.add(new JLabel("Down payment"));
    pane.add(jtfDownPayment);
    pane.add(new JLabel("PropertyTax"));
    pane.add(jtfPropertyTax);
    pane.add(new JLabel("OwnerInsurance"));
    pane.add(jtfOwnerInsurance);
    pane.add(new JLabel("HOAFee"));
    pane.add(jtfHOAFee);
    pane.add(new JLabel("Loan Term"));
    pane.add(cb1);
    pane.add(new JLabel("Bank"));
    pane.add(cb2);
    pane.add(new JLabel("Rate Type"));
    pane.add(cb3);
    pane.add(new JLabel("Interest Rate"));
    pane.add(jtfInterestRate);

//    jtfHomeValue.setDocument(new NumberDocument());
//    jtfLoanTerm.setDocument(new NumberDocument());
//    jtfDownPayment.setDocument(new NumberDocument());


    jtfInterestRate.setBackground(Color.LIGHT_GRAY);
    jtfInterestRate.setEditable(false);
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