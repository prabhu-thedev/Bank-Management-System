package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Mini extends JFrame implements ActionListener {
    JButton button;
    String pin;

    Mini(String pin) {
        this.pin = pin;
        setLayout(null);
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLocation(400, 50);

        JLabel label1 = new JLabel();
        label1.setBounds(20, 140, 400, 300);
        label1.setVerticalAlignment(SwingConstants.TOP);
        add(label1);

        JLabel label2 = new JLabel("Shree Bank");
        label2.setFont(new Font("System", Font.BOLD, 18));
        label2.setBounds(130, 20, 200, 25);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20, 80, 350, 20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20, 460, 300, 20);
        add(label4);

        // ✅ Fetch card number
        try {
            Con c = new Con();
            PreparedStatement ps = c.connection.prepareStatement("SELECT card_number FROM login WHERE pin = ?");
            ps.setString(1, pin);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String cardNum = rs.getString("card_number");
                String masked = cardNum.substring(0, 4) + "XXXXXXXX" + cardNum.substring(cardNum.length() - 4);
                label3.setText("Card Number: " + masked);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR " + e.getMessage());
        }

        // ✅ Fetch mini statement + balance
        try {
            int bal = 0;
            Con c1 = new Con();
            PreparedStatement ps = c1.connection.prepareStatement("SELECT * FROM bank WHERE pin = ?");
            ps.setString(1, pin);
            ResultSet rs = ps.executeQuery();

            StringBuilder sb = new StringBuilder("<html>");
            while (rs.next()) {
                sb.append(rs.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("type"))
                        .append("&nbsp;&nbsp;&nbsp;Rs. ")
                        .append(rs.getString("amount"))
                        .append("<br>");

                String type = rs.getString("type");
                int amt = rs.getInt("amount");
                if ("Deposit".equalsIgnoreCase(type))
                    bal += amt;
                else
                    bal -= amt;
            }
            sb.append("</html>");
            label1.setText(sb.toString());
            label4.setText("Your Total Balance: Rs " + bal);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR " + e.getMessage());
        }

        button = new JButton("Exit");
        button.setBounds(20, 520, 100, 25);
        button.addActionListener(this);
        add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(pin);
    }

    public static void main(String[] args) {
        new Mini("");
    }
}
