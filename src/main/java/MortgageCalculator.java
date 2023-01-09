import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class MortgageCalculator extends JFrame {

  private JTextField jtfInterestRate = new JTextField();
  private JTextField jtfLoanTerm = new JTextField();
  private JTextField jftLoanAmount = new JTextField();
  private JTextField jtfMonthlyPayment = new JTextField();
  private JTextField jtfTotalPayment = new JTextField();
  private JTextField jftDownPayment = new JTextField();
  private JTextField jftHomeValue = new JTextField();

  private JLabel messageLabel = new JLabel();
  private JButton jbtCalculator=new JButton("Your mortgage details");


  public MortgageCalculator() {
    super("Please Enter Home Value,Interest Rate,and Term");

    buildUI();
    setFrameOptions();


    ActionListener listenner = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        double homeValue=
            Double.parseDouble(jftHomeValue.getText());
        double downPayment=
            Double.parseDouble(jftDownPayment.getText());
        double interestRate=
            Double.parseDouble(jtfInterestRate.getText());
        int loanTerm=
            Integer.parseInt(jtfLoanTerm.getText());
        double loanAmount= homeValue - downPayment;

        double monthlyInterest=interestRate/1200;

        double monthlyPayment= loanAmount*monthlyInterest*Math.pow(1+monthlyInterest, loanTerm*12)/(Math.pow(1+monthlyInterest,loanTerm*12)-1);
        double totalPayment=monthlyPayment*loanTerm*12;

        jftLoanAmount.setText(String.format("%.2f", loanAmount));
        jtfMonthlyPayment.setText(String.format("%.2f", monthlyPayment));
        jtfTotalPayment.setText(String.format("%.2f", totalPayment));

      }
    };
    jbtCalculator.addActionListener(listenner);

  }



  private void buildUI() {
    Container pane = getContentPane();
    setPreferredSize(new Dimension(400, 300));
    pane.setLayout(new GridLayout(9, 2));

    pane.add(new JLabel("Home Value"));
    pane.add(jftHomeValue);
    pane.add(new JLabel("Down payment"));
    pane.add(jftDownPayment);
    pane.add(new JLabel("Interest Rate"));
    pane.add(jtfInterestRate);
    pane.add(new JLabel("Loan Term"));
    pane.add(jtfLoanTerm);
    pane.add(new JLabel("Loan Amount"));
    pane.add(jftLoanAmount);
    pane.add(new JLabel("Monthly Payment"));
    pane.add(jtfMonthlyPayment);
    pane.add(new JLabel("Total Payment"));
    pane.add(jtfTotalPayment);

//    jftHomeValue.setDocument(new NumberDocument());
//    jftDownPayment.setDocument(new NumberDocument());
//    jtfInterestRate.setDocument(new NumberDocument());
//    jtfLoanTerm.setDocument(new NumberDocument());

    jftLoanAmount.setBackground(Color.LIGHT_GRAY);
    jftLoanAmount.setEditable(false);
    jtfMonthlyPayment.setBackground(Color.LIGHT_GRAY);
    jtfMonthlyPayment.setEditable(false);
    jtfTotalPayment.setBackground(Color.LIGHT_GRAY);
    jtfTotalPayment.setEditable(false);

    pane.add(jbtCalculator);
    pane.add(messageLabel);
  }

  private void setFrameOptions() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    pack();
  }

  private void warning(String msg) {
    JOptionPane.showMessageDialog(this, msg, "Disaster Status", JOptionPane.WARNING_MESSAGE);
  }

  public static void main(String[] args) {
    new MortgageCalculator().setVisible(true);
  }

}