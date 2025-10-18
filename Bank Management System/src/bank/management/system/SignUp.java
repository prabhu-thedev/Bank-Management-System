package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {

    JTextField name, fname,email, address,city,pincode,state;
    JRadioButton r1,r2,r3,r4;
    JButton next;
    JDateChooser dateChooser;

    Random rand = new Random();
    long first4 = (rand.nextLong() % 9000L) + 1000L;

    String first = String.valueOf(Math.abs(first4));


    SignUp(){
        super("Application Form");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO. "+first);
        label1.setBounds(140,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,36));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        label2.setBounds(330,60,600,30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setBounds(290,95,600,22);
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        add(label3);

        JLabel labelName = new JLabel("Name ");
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        labelName.setBounds(100,150,100,30);
        add(labelName);

        name = new JTextField();
        name.setFont(new Font("Raleway :",Font.BOLD,14));
        name.setBounds(300,150,400,30);
        add(name);

        JLabel labelfName = new JLabel("Father Name :");
        labelfName.setFont(new Font("Raleway",Font.BOLD,20));
        labelfName.setBounds(100,190,200,30);
        add(labelfName);

        fname = new JTextField();
        fname.setFont(new Font("Raleway",Font.BOLD,14));
        fname.setBounds(300,190,400,30);
        add(fname);

        JLabel dob = new JLabel("Date Of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);

        JLabel labelG = new JLabel("Gender :");
        labelG.setFont(new Font("Raleway",Font.BOLD,20));
        labelG.setBounds(100,290,200,30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setBackground(new Color(222,255,220));
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(300,290,80,25);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(new Color(222,255,220));
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(420,290,150,25);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel labelEmail = new JLabel("Email :");
        labelEmail.setFont(new Font("Ralewat", Font.BOLD,20));
        labelEmail.setBounds(100,330,100,30);
        add(labelEmail);

        email = new JTextField();
        email.setFont(new Font("Raleway",Font.BOLD,14));
        email.setBounds(300,330,400,30);
        add(email);

        JLabel labelMS = new JLabel("Married Status :");
        labelMS.setFont(new Font("Ralewat", Font.BOLD,20));
        labelMS.setBounds(100,370,100,30);
        add(labelMS);

        r3 = new JRadioButton("Married");
        r3.setBackground(new Color(222,255,220));
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(300,370,120,25);
        add(r3);

        r4 = new JRadioButton("Single");
        r4.setBackground(new Color(222,255,220));
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(430,370,150,25);
        add(r4);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r3);
        buttonGroup1.add(r4);

        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Ralewat", Font.BOLD,20));
        labelAdd.setBounds(100,410,100,30);
        add(labelAdd);

        address = new JTextField();
        address.setFont(new Font("Raleway",Font.BOLD,14));
        address.setBounds(300,410,400,30);
        add(address);

        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Ralewat", Font.BOLD,20));
        labelCity.setBounds(100,450,100,30);
        add(labelCity);

        city = new JTextField();
        city.setFont(new Font("Raleway",Font.BOLD,14));
        city.setBounds(300,450,400,30);
        add(city);

        JLabel labelPin = new JLabel("PinCode :");
        labelPin.setFont(new Font("Ralewat", Font.BOLD,20));
        labelPin.setBounds(100,490,100,30);
        add(labelPin);

        pincode = new JTextField();
        pincode.setFont(new Font("Raleway",Font.BOLD,14));
        pincode.setBounds(300,490,400,30);
        add(pincode);

        JLabel labelState = new JLabel("State :");
        labelState.setFont(new Font("Ralewat", Font.BOLD,20));
        labelState.setBounds(100,530,100,30);
        add(labelState);

        state = new JTextField();
        state.setFont(new Font("Raleway",Font.BOLD,14));
        state.setBounds(300,530,400,30);
        add(state);

        next = new JButton("NEXT");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        next.setFocusPainted(false);
        next.setBorderPainted(false);
        next.setBounds(620,575,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(800,650);
        setLocation(220,30);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String formNo = first;
            String Sname = name.getText().trim();
            String Sfname = fname.getText().trim();
            String Sdob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText().trim();

            String Sgender = null;
            if (r1.isSelected()) Sgender = "Male";
            else if (r2.isSelected()) Sgender = "Female";

            String Semail = email.getText().trim();

            String SmarriedStatus = null;
            if (r3.isSelected()) SmarriedStatus = "Married";
            else if (r4.isSelected()) SmarriedStatus = "Single";

            String Saddress = address.getText().trim();
            String Scity = city.getText().trim();
            String Spincode = pincode.getText().trim();
            String Sstate = state.getText().trim();

            if (Sname.equals("") || Sfname.equals("") || Sdob.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all required fields!");
                return;
            }

            Con con1 = new Con();
            String query = "INSERT INTO signUp(formNo, name, fname, dob, gender, email, marriedStatus, address, city, pincode, state) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = con1.connection.prepareStatement(query);
            pst.setString(1, formNo);           // <-- your formNo variable
            pst.setString(2, Sname);
            pst.setString(3, Sfname);
            pst.setString(4, Sdob);
            pst.setString(5, Sgender);
            pst.setString(6, Semail);
            pst.setString(7, SmarriedStatus);
            pst.setString(8, Saddress);
            pst.setString(9, Scity);
            pst.setString(10, Spincode);
            pst.setString(11, Sstate);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Details submitted successfully!");
            new SignUp2(first); // move to next form
            setVisible(false);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
