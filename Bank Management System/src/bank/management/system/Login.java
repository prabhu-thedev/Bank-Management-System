package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JTextField textField1;
    JPasswordField passwordField2;
    JButton button1, button2, button3;

    Login(){
        super("Bank Management System");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630,325,100,100);
        add(iimage);

        label1 = new JLabel(" WELCOME TO ATM ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde",Font.BOLD,30));
        label1.setBounds(225,125,350,40);
        add(label1);

        label2 = new JLabel("Card No : ");
        label2.setFont(new Font("Railway",Font.BOLD,25));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        label3 = new JLabel("Pin :");
        label3.setFont(new Font("Railway",Font.BOLD,25));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,240,375,30);
        add(label3);

        textField1 = new JTextField(15);
        textField1.setBounds(285,190,350,30);
        textField1.setFont(new Font("Arial",Font.BOLD,16));
        add(textField1);

        passwordField2 = new JPasswordField(15);
        passwordField2.setBounds(285,240,350,30);
        passwordField2.setFont(new Font("Arail",Font.BOLD,16));
        add(passwordField2);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setFocusPainted(false);
        button1.setBorderPainted(false);
        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button1.setBounds(290,290,100,30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setFocusPainted(false);
        button2.setBorderPainted(false);
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button2.setBounds(400,290,100,30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setFocusPainted(false);
        button3.setBorderPainted(false);
        button3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button3.setBounds(290,330,210,30);
        button3.addActionListener(this);
        add(button3);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(800,450,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,800,450);

        add(iiimage);
        setLayout(null);
        setSize(800,450);
        setLocation(220,30);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource() == button1){

            } else if (e.getSource() == button2) {
                textField1.setText("");
                passwordField2.setText("");
            } else if (e.getSource() == button3) {
                new SignUp();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
