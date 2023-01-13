package mortgagepay.view;

import java.util.Locale;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import mortgagepay.model.CommonVariables;
import mortgagepay.model.LocalBanks;
import mortgagepay.model.RateType;
import mortgagepay.model.Terms;


public class MonthlyCalculator extends JFrame implements CalculatorRender {

  private JTextField jtfHomeValue = new JTextField();
  private JTextField jtfDownPayment = new JTextField();
  private JTextField jtfPropertyTax = new JTextField();
  private JTextField jtfOwnerInsurance = new JTextField();
  private JTextField jtfHOAFee = new JTextField();
  private JTextField jtfInterestRate = new JTextField();
  private JTextField jtfLoanTerm = new JTextField();
  private JTextField JtfBankName = new JTextField();
  private JTextField jtfRateType = new JTextField();
  private JTextField jtfMonthlyPayment = new JTextField();


  String[] choices1 = { "LONG","SHORT", };
  String[] choices2 = { "Pentagon","Navy Federal Bank","USAA"};
  String[] choices3 = {"FIXED","STANDARD"};
  final JComboBox<String> cb1 = new JComboBox<String>(choices1);
  final JComboBox<String> cb2 = new JComboBox<String>(choices2);
  final JComboBox<String> cb3 = new JComboBox<String>(choices3);

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
        double homeValue= Double.parseDouble(jtfHomeValue.getText());
        double downPayment= Double.parseDouble(jtfDownPayment.getText());
        double propertyTax= Double.parseDouble(jtfPropertyTax.getText());
        double ownerInsurance= Double.parseDouble(jtfOwnerInsurance.getText());
        double hoaFee= Double.parseDouble(jtfHOAFee.getText());

        Terms term = Terms.valueOf((String)cb1.getSelectedItem());
        String bankName = (String)cb2.getSelectedItem();
        RateType rateType = RateType.valueOf((String)cb3.getSelectedItem());

        localbanks = new LocalBanks(bankName,term, rateType);
        variables = new CommonVariables(homeValue, downPayment, propertyTax, ownerInsurance,
        hoaFee, bankName, term, rateType);

        double[] offerRate = localbanks.getOfferRate();
        jtfInterestRate.setText(String.format("%.002f", offerRate[0]*100));

        double[] payment = variables.getTotalMonthlyPayment();
        if(rateType.getRateType().equals("fixed")){
          jtfMonthlyPayment.setText("MonthlyPayment $" + String.format("%.002f", payment[0]));
          System.out.println("MonthlyPayment $" + String.format("%.002f", payment[0]));
        } else{
          String str = "MonthlyPayment $" + String.format("%.002f", payment[0]) + "\n";
          jtfMonthlyPayment.setText(str);
          for(int i= 1, j=6; i<offerRate.length; i++, j=j+2){
            if((j+1)>30)
              str += "Your " + j + "th year monthly payment $" + String.format("%.002f", payment[i]) +"\n";
            else
              str += "Your " + j + "th and " + (j+1) + "th year monthly payment $" + String.format("%.002f", payment[i]) +"\n";
          }
          System.out.println(str);
        }
      }
    };
    jbtCalculator.addActionListener(listenner);

  }
  @Override
    public void buildUI() {
    Container pane = getContentPane();
    pane.setLayout(new GridLayout(10, 2));
    pane.setSize(840, 800);
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
    pane.add(jbtCalculator);
    pane.add(jtfMonthlyPayment);


    jtfHomeValue.setDocument(new NumberDocument());
    jtfDownPayment.setDocument(new NumberDocument());

    jtfInterestRate.setBackground(Color.LIGHT_GRAY);
    jtfInterestRate.setEditable(false);
    jtfMonthlyPayment.setBackground(Color.LIGHT_GRAY);
    jtfMonthlyPayment.setEditable(false);


  }

  private void setFrameOptions() {
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    pack();
  }

}