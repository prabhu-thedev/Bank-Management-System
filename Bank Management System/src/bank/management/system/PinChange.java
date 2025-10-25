package bank.management.system;

import com.sun.source.tree.SwitchExpressionTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class PinChange extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    PinChange(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1300,650);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(390,120,400,35);
        l3.add(label1);

        JLabel label2 = new JLabel("New PIN :");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(350,160,400,35);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setFont(new Font("Raleway",Font.BOLD,16));
        p1.setBounds(500,160,200,30);
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.WHITE);
        l3.add(p1);

        JLabel label3 = new JLabel("Re-Enter New PIN :");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System",Font.BOLD,16));
        label3.setBounds(350,200,400,35);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setFont(new Font("Raleway",Font.BOLD,16));
        p2.setBounds(500,200,200,30);
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.WHITE);
        l3.add(p2);

        b1 = new JButton("CHANGE");
        b1.setBounds(610,285,100,25);
        b1.setBackground(new Color(65,125,128));
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(610,325,100,25);
        b2.setBackground(new Color(65,125,128));
        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN Does not match");
                return;
            }
            if (e.getSource() == b1) {
                if (p1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (p2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                    return;
                }

                Con c1 = new Con();

                // Prepared statements for each table
                String q1 = "UPDATE bank SET pin = ? WHERE pin = ?";
                String q2 = "UPDATE login SET pin = ? WHERE pin = ?";
                String q3 = "UPDATE signUpThree SET pin = ? WHERE pin = ?";

                // Create prepared statements
                PreparedStatement ps1 = c1.connection.prepareStatement(q1);
                PreparedStatement ps2 = c1.connection.prepareStatement(q2);
                PreparedStatement ps3 = c1.connection.prepareStatement(q3);

                ps1.setString(1, pin1);
                ps1.setString(2, pin);

                ps2.setString(1, pin1);
                ps2.setString(2, pin);

                ps3.setString(1, pin1);
                ps3.setString(2, pin);

                ps1.executeUpdate();
                ps2.executeUpdate();
                ps3.executeUpdate();

                JOptionPane.showMessageDialog(null, "PIN changed successfully!");

                setVisible(false);
                new main_Class(pin1);
            } else if (e.getSource() == b2) {
                setVisible(false);
                new main_Class(pin);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
