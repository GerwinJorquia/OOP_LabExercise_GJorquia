import javax.swing.*;
import java.awt.*;

public class WelcomeFrame extends JFrame {
    public WelcomeFrame() {
        setTitle("welcome to Community Water Quality System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 200);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Main.SKY_BLUE);

        JLabel title = new JLabel("Welcome to Community Water Quality System", SwingConstants.CENTER);
        title.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JButton next = new JButton("Next");
        next.addActionListener(e -> { new TransactionOptions(); dispose(); });

        JPanel bottom = new JPanel(); bottom.add(next);
        bottom.setBackground(Main.SKY_BLUE);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(title, BorderLayout.CENTER);
        getContentPane().add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }
}