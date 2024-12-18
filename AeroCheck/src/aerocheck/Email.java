package aerocheck;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Email {

    public static void sendBoardingPass(Passenger passenger) {
        JFrame frame = new JFrame("Email Confirmation");
        frame.setSize(500, 300);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        int windowWidth = frame.getWidth();
        int windowHeight = frame.getHeight();
        frame.setLocation((screenWidth - windowWidth) / 2, (screenHeight - windowHeight) / 2);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("Send boarding pass to your email?");
        label.setFont(new Font("Monospaced", Font.BOLD, 18));
        label.setBounds(20, 90, 460, 20);
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label);

        JButton yes = new JButton("Yes");
        yes.setBounds(150, 140, 80, 20);
        panel.add(yes);

        JButton no = new JButton("No");
        no.setBounds(250, 140, 80, 20);
        panel.add(no);

        yes.addActionListener((ActionEvent e) -> {
            frame.setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "<html>\tBoarding pass sent to<br><font color='blue'>"
                    + passenger.getEmail() + "</font></html>");
            frame.dispose();
        });

        no.addActionListener((ActionEvent e) -> {
            frame.setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "Your boarding pass will not be sent to your email.");
            frame.dispose();
        });
        frame.setAlwaysOnTop(true);

        frame.setVisible(true);
    }
}
