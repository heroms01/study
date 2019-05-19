package factory.gui;

import javax.swing.*;
import java.awt.*;

public class WindowsButton implements Button {
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JButton button = new JButton("Exit");

    public void render() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(320, 200);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel label = new JLabel("hello world");
        label.setOpaque(true);
        label.setBackground(new Color(235, 233, 126));
        label.setFont(new Font("Dialog", Font.BOLD, 44));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        onClick();

        panel.add(label);
        panel.add(button);

        frame.setVisible(true);
    }

    public void onClick() {
        button.addActionListener(e -> {
            frame.setVisible(false);
            System.exit(0);
        });
    }
}
