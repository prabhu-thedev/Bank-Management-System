package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class SignUp2 extends JFrame implements ActionListener {
    String formNo;
    JComboBox comboBox, comboBox2, comboBox3, comboBox4, comboBox5;
    JTextField textPan, textAadhaar;
    JRadioButton r1,r2,r3,r4;
    JButton next;
    SignUp2(String first){
        super("APPLICATION FORM");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        this.formNo = formNo;

        JLabel l1 = new JLabel("Page 2 :- ");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(300,30,600,40);
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(300,60,600,40);
        add(l2);

        JLabel l3 = new JLabel("Religion :");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l3.setBounds(100,130,100,30);
        add(l3);

        String[] religion = {"Hindu","Muslim","Sick","Christian"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(252,208,76));
        comboBox.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox.setBounds(350,120,320,30);
        add(comboBox);

        JLabel l4 = new JLabel("Category :");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l4.setBounds(100,170,100,30);
        add(l4);

        String[] Category = {"General","OBC","SC","ST", "Others"};
        comboBox2 = new JComboBox(Category);
        comboBox2.setBackground(new Color(252,208,76));
        comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox2.setBounds(350,170,320,30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income :");
        l5.setFont(new Font("Raleway",Font.BOLD,18));
        l5.setBounds(100,210,100,30);
        add(l5);

        String[] Income = {"<1,50,000","<2,50,000","5,00,000","Upto 10,00,000", "Above 10,00,000"};
        comboBox3 = new JComboBox(Income);
        comboBox3.setBackground(new Color(252,208,76));
        comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox3.setBounds(350,210,320,30);
        add(comboBox3);

        JLabel l6 = new JLabel("Education :");
        l6.setFont(new Font("Raleway",Font.BOLD,18));
        l6.setBounds(100,250,200,30);
        add(l6);

        String[] Education = {"Non-Graduate","Graduate","Post-Graduate","Doctorate", "Other"};
        comboBox4 = new JComboBox(Education);
        comboBox4.setBackground(new Color(252,208,76));
        comboBox4.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox4.setBounds(350,250,320,30);
        add(comboBox4);

        JLabel l7 = new JLabel("Occupation :");
        l7.setFont(new Font("Raleway",Font.BOLD,18));
        l7.setBounds(100,290,200,30);
        add(l7);

        String[] Occupation = {"Salaried","Self-Employed","Business","Student", "Retired"};
        comboBox5 = new JComboBox(Occupation);
        comboBox5.setBackground(new Color(252,208,76));
        comboBox5.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox5.setBounds(350,290,320,30);
        add(comboBox5);

        JLabel l8 = new JLabel("PAN Number :");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(100,330,200,30);
        add(l8);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway",Font.BOLD,18));
        textPan.setBounds(350,330,320,30);
        add(textPan);

        JLabel l9 = new JLabel("Aadhaar Number :");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(100,370,200,30);
        add(l9);

        textAadhaar = new JTextField();
        textAadhaar.setFont(new Font("Raleway",Font.BOLD,18));
        textAadhaar.setBounds(350,370,320,30);
        add(textAadhaar);

        JLabel l10 = new JLabel("Senior Citizen :");
        l10.setFont(new Font("Raleway",Font.BOLD,18));
        l10.setBounds(100,410,200,30);
        add(l10);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Railway",Font.BOLD,18));
        r1.setBackground(new Color(252,208,76));
        r1.setBounds(350,410,100,30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Railway",Font.BOLD,18));
        r2.setBackground(new Color(252,208,76));
        r2.setBounds(450,410,100,30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel l11 = new JLabel("Existing Account :");
        l11.setFont(new Font("Raleway",Font.BOLD,18));
        l11.setBounds(100,450,200,30);
        add(l11);

        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Railway",Font.BOLD,18));
        r3.setBackground(new Color(252,208,76));
        r3.setBounds(350,450,100,30);
        add(r3);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Railway",Font.BOLD,18));
        r4.setBackground(new Color(252,208,76));
        r4.setBounds(450,450,100,30);
        add(r4);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r4);
        buttonGroup1.add(r3);

        JLabel l12 = new JLabel("Form No " + formNo);
        l12.setFont(new Font("Raleway",Font.BOLD,16));
        l12.setBounds(650,10,150,30);
        add(l12);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFocusPainted(false);
        next.setBorderPainted(false);
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        next.setBounds(570,550,100,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(new Color(252,208,76));
        setLayout(null);
        setSize(800,650);
        setLocation(220,20);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel  = (String) comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();

        String pan = (String) textPan.getText();
        String aadhar = (String) textAadhaar.getText();

        String sCitizen = null;
        if (r1.isSelected()) sCitizen = "Yes";
        else if (r2.isSelected()) sCitizen = "No";
        String eAccount = null;
        if (r3.isSelected()) eAccount = "Yes";
        else if (r4.isSelected()) eAccount = "No";
        try{
            if (textPan.getText().equals("") || textAadhaar.getText().equals("")) JOptionPane.showMessageDialog(null,"Fill all the fields");
            else {
                Con c1 = new Con();
                String query = "INSERT INTO signUpTwo(formNo, religion, category, income, education, pan, aadhar, senior_citizen, existing_account)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement pst = c1.connection.prepareStatement(query);
                pst.setString(1, formNo);           // <-- your formNo variable
                pst.setString(2, rel);
                pst.setString(3, cate);
                pst.setString(4, inc);
                pst.setString(5, edu);
                pst.setString(6, pan);
                pst.setString(7, aadhar);
                pst.setString(8, sCitizen);
                pst.setString(9, eAccount);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Details submitted successfully!");
                new SignUp3(formNo); // move to next form
                setVisible(false);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new SignUp2("");
    }
}
