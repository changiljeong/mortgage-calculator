package mortgagepay.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;


import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import mortgagepay.model.CommonVariables;
import mortgagepay.model.LocalBanks;


public class PrimaryWelcomeView extends JFrame implements CalculatorRender {


  private JTextField jtfHomeValue = new JTextField();
  private JTextField jtfDownPayment = new JTextField();
  private double monthlyPayment = 1000000;
  private JLabel messageLabel = new JLabel();
  private JButton monthlyCal=new JButton("Monthly Mortgage Calculator");
  private JButton affordabilityCal=new JButton("Affordability Calculator");

  private CommonVariables variables;
  private LocalBanks localbanks;
  private JFormattedTextField welcomeMsg;


  public PrimaryWelcomeView() {

    super("MonthlyPaymentCalculator");
    buildUI();
    setFrameOptions();


    ActionListener monthlyListenner = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        MonthlyCalculator test1 = new MonthlyCalculator();
        test1.setVisible(true);
      }
    };
    monthlyCal.addActionListener(monthlyListenner);

    ActionListener affordabilityListenner = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        AffordabilityCalculator test2 = new AffordabilityCalculator();
        test2.setVisible(true);
      }
    };
    affordabilityCal.addActionListener(affordabilityListenner);
  }


  @Override
  public void buildUI() {

    Container pane = getContentPane();

    setPreferredSize(new Dimension(1024, 800));
    pane.setLayout(new GridLayout(4, 1));


    this.setTitle("Welcome!");

    JTextArea textMain1 = new JTextArea("::::::::::::::::::::::::::::::::::::::::::::: WELCOME ::::::::::::::::::::::::::::::::::::::::::::: \n"
        + "Thank you for utilizing our mortgage calculator! Our mission is to support potential\n"
        + "home buyers for getting connected with local banks for competitive rates \n"
        + "OR simply to see how much of home prices one can afford with their current debt-to-income ratio.\n"
        + "\n"
        + "Please select one of options below for your journey today with us!");

    textMain1.setFont(textMain1.getFont().deriveFont(Font.BOLD));
    Font font = new Font("Verdana", Font.BOLD, 12);

    textMain1.setFont(font);
    textMain1.setForeground(Color.getHSBColor(250, 150, 150));
    pane.add(new JLabel(new ImageIcon(("/Users/albertli/Downloads/3.png"))));
    pane.add(textMain1);
    pane.add(monthlyCal);
    pane.add(affordabilityCal);
//    pane.add(messageLabel);
  }

  private void setFrameOptions() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    pack();
  }


  public static void main(String[] args) {
    new PrimaryWelcomeView().setVisible(true);
}