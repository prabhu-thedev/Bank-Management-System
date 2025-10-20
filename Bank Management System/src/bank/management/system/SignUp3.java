package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.concurrent.ThreadLocalRandom;

public class SignUp3 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton s,c;
    String formNo;
    SignUp3(String formNo){
        super("");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,10,100,100);
        add(image);
        this.formNo = formNo;

        JLabel l1 = new JLabel("Page 3 :-");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(260,60,400,40);
        add(l2);

        JLabel l3 = new JLabel("Account Type :");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l3.setBounds(100,130,200,30);
        add(l3);

        r1 = new JRadioButton("Saving Account ");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(new Color(215,252,252));
        r1.setBounds(140,160,200,30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(new Color(215,252,252));
        r2.setBounds(350,160,300,30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(new Color(215,252,252));
        r3.setBounds(140,190,200,30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(new Color(215,252,252));
        r4.setBounds(350,190,300,30);
        add(r4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        JLabel l4 = new JLabel("Card Number :");
        l4.setFont(new Font("Raleway",Font.BOLD,22));
        l4.setBounds(100,220,200,40);
        add(l4);

        JLabel l5 = new JLabel("(Your 16-digit Card Number)");
        l5.setFont(new Font("Raleway",Font.BOLD,16));
        l5.setBounds(100,250,400,20);
        add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-4861");
        l6.setFont(new Font("Raleway",Font.BOLD,16));
        l6.setBounds(330,235,400,20);
        add(l6);

        JLabel l7 = new JLabel("(It would appear on atm card/cheque Book ans Statement)");
        l7.setFont(new Font("Raleway",Font.BOLD,12));
        l7.setBounds(330,250,500,20);
        add(l7);

        JLabel l8 = new JLabel("PIN :");
        l8.setFont(new Font("Raleway",Font.BOLD,20));
        l8.setBounds(100,280,200,40);
        add(l8);

        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Raleway",Font.BOLD,20));
        l9.setBounds(330,280,200,40);
        add(l9);

        JLabel l10 = new JLabel("(4-Digit PIN)");
        l10.setFont(new Font("Raleway",Font.BOLD,16));
        l10.setBounds(100,310,400,30);
        add(l10);

        JLabel l11 = new JLabel("Service Required :");
        l11.setFont(new Font("Raleway",Font.BOLD,20));
        l11.setBounds(100,340,200,30);
        add(l11);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(new Color(215,252,252));
        c1.setFont(new Font("Railway",Font.BOLD,16));
        c1.setBounds(100,370,200,30);
        c1.setBorderPainted(false);
        c1.setFocusPainted(false);
        c1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(215,252,252));
        c2.setFont(new Font("Railway",Font.BOLD,16));
        c2.setBounds(350,370,200,30);
        c2.setBorderPainted(false);
        c2.setFocusPainted(false);
        c2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(215,252,252));
        c3.setFont(new Font("Railway",Font.BOLD,16));
        c3.setBounds(100,400,200,30);
        c3.setBorderPainted(false);
        c3.setFocusPainted(false);
        c3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(c3);

        c4 = new JCheckBox("Email Alerts");
        c4.setBackground(new Color(215,252,252));
        c4.setFont(new Font("Railway",Font.BOLD,16));
        c4.setBounds(350,400,200,30);
        c4.setBorderPainted(false);
        c4.setFocusPainted(false);
        c4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(215,252,252));
        c5.setFont(new Font("Railway",Font.BOLD,16));
        c5.setBounds(100,430,200,30);
        c5.setBorderPainted(false);
        c5.setFocusPainted(false);
        c5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(c5);

        c6 = new JCheckBox("E Statement");
        c6.setBackground(new Color(215,252,252));
        c6.setFont(new Font("Railway",Font.BOLD,16));
        c6.setBounds(350,430,200,30);
        c6.setBorderPainted(false);
        c6.setFocusPainted(false);
        c6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(c6);

        JCheckBox c7 = new JCheckBox("I here by declares that above entered details correct to the best of my knowledge. ",true);
        c7.setBackground(new Color(215,252,252));
        c7.setFont(new Font("Railway",Font.BOLD,12));
        c7.setBounds(100,480,600,20);
        c7.setBorderPainted(false);
        c7.setFocusPainted(false);
        c7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(c7);//

        s = new JButton("Submit");
        s.setFont(new Font("Raleway",Font.BOLD,16));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.setBounds(250,550,100,30);
        s.setFocusPainted(false);
        s.setBorderPainted(false);
        s.setCursor(new Cursor(Cursor.HAND_CURSOR));
        s.addActionListener(this);
        add(s);

        c = new JButton("Cancel");
        c.setFont(new Font("Raleway",Font.BOLD,16));
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
        c.setBounds(420,550,100,30);
        c.setFocusPainted(false);
        c.setBorderPainted(false);
        c.setCursor(new Cursor(Cursor.HAND_CURSOR));
        c.addActionListener(this);
        add(c);

        JLabel l12 = new JLabel("Form No : " + formNo);
        l12.setFont(new Font("Raleway",Font.BOLD,16));
        l12.setBounds(650,10,150,30);
        add(l12);

        getContentPane().setBackground(new Color(215,252,252));
        setLayout(null);
        setSize(800,650);
        setLocation(220,20);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String aType = "";
        if (r1.isSelected()) aType = "Saving Account";
        else if (r2.isSelected()) aType = "Fixed Deposit Account";
        else if (r3.isSelected()) aType = "Current Account";
        else if (r4.isSelected()) aType = "Recurring Deposit Account";

        long base = 140_996_300_000_000L;
        long randPart = ThreadLocalRandom.current().nextLong(0L, 90_000_000L); // 0 .. 89,999,999
        long cardVal = base + randPart;
        String cardNo = Long.toString(cardVal);          // use String.format("%015d", cardVal) if you need fixed width

        int pinVal = ThreadLocalRandom.current().nextInt(1000, 10000); // 1000 .. 9999
        String pin = String.format("%04d", pinVal);     // ensures exactly 4 digits


        String fac = "";
        if (c1.isSelected()) fac += "ATM CARD";
        else if (c2.isSelected()) fac += "Internet Banking";
        else if (c3.isSelected()) fac += "Mobile Banking";
        else if (c4.isSelected()) fac += "Email Alert";
        else if (c5.isSelected()) fac += "Cheque Book";
        else if (c6.isSelected()) fac += "E-Statement";
        try{
            if (e.getSource() == s){
                if (aType.equals("")) JOptionPane.showMessageDialog(null,"Fill all the fields");
                else {
                    Con c1 = new Con();
                    String queue1 = "INSERT INTO signUpThree(formNo, account_type, card_number, pin, facility)" +
                    "VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement pst = c1.connection.prepareStatement(queue1);
                    pst.setString(1, formNo);
                    pst.setString(2, aType);
                    pst.setString(3, cardNo);
                    pst.setString(4, pin);
                    pst.setString(5, fac);

                    String queue2 = "INSERT INTO login(formNo,card_number, pin)" +
                            "VALUES (?, ?, ?)";
                    PreparedStatement pst2 = c1.connection.prepareStatement(queue2);
                    pst2.setString(1,formNo);
                    pst2.setString(2,cardNo);
                    pst2.setString(3,pin);

                    pst.executeUpdate();
                    pst2.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Card Number : " + cardNo +"\n" + "Pin : " + pin);
                    new Deposit(pin);
                    setVisible(false);
                }
            } else if (e.getSource() == c) {
                System.exit(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new SignUp3("");
    }
}
