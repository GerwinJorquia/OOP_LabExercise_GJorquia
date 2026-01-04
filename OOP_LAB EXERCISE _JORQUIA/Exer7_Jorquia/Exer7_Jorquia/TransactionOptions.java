import javax.swing.*;
import java.awt.*;

public class TransactionOptions extends JFrame {
    public TransactionOptions() {
        setTitle("Transaction Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 350);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Main.SKY_BLUE);

        JLabel title = new JLabel("Community Water Quality System", SwingConstants.CENTER);
        title.setFont(new Font("Times New Roman", Font.BOLD, 28));

        JPanel northPanel = new JPanel();
        northPanel.setBackground(Main.SKY_BLUE);
        northPanel.add(title);
        northPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));

        JPanel p = new JPanel(new GridLayout(3,1,15,15));
        p.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));
        p.setBackground(Main.SKY_BLUE);

        JButton reg = new JButton("Registration");
        JButton results = new JButton("Record");
        JButton services = new JButton("Services");

        Dimension btnSize = new Dimension(300, 55);
        Font btnFont = new Font("Times New Roman", Font.BOLD, 20);
        for (JButton b : new JButton[]{reg, results, services}) {
            b.setPreferredSize(btnSize);
            b.setFont(btnFont);
            b.setFocusable(false);
        }

        reg.addActionListener(e -> { new RegistrationForm(null); dispose(); });
        results.addActionListener(e -> { new ResultsFrame(); dispose(); });
        services.addActionListener(e -> { new ServicesRequestForm(null); dispose(); });

        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.CENTER)); row1.setBackground(Main.SKY_BLUE); row1.add(reg);
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.CENTER)); row2.setBackground(Main.SKY_BLUE); row2.add(services);
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); row3.setBackground(Main.SKY_BLUE); row3.add(results);

        p.add(row1); p.add(row2); p.add(row3);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(northPanel, BorderLayout.NORTH);
        getContentPane().add(p, BorderLayout.SOUTH);
        setVisible(true);
    }
}
