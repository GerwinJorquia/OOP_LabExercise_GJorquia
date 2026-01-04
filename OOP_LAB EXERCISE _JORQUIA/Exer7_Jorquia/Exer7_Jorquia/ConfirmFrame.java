import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConfirmFrame extends JFrame {
    public ConfirmFrame(Transactor t) {
        setTitle("Confirm Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Main.SKY_BLUE);

        JPanel panel = new JPanel(new GridLayout(0,1));
        panel.setBackground(Main.SKY_BLUE);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.add(new JLabel("Name: " + t.getName()));
        panel.add(new JLabel("Address/Location: " + t.getAddress()));
        panel.add(new JLabel("Contact Number: " + t.getContact()));
        panel.add(new JLabel("Problem: " + t.getProblem()));
        panel.add(new JLabel("Residence: " + t.getResidence()));
        panel.add(new JLabel("Date: " + t.getDate().toString()));

        JButton edit = new JButton("Edit");
        edit.addActionListener(e -> { new RegistrationForm(t); dispose(); });

        JButton save = new JButton("Save");
        save.addActionListener(e -> saveToCSV(t));

        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> System.exit(0));

        JPanel bottom = new JPanel(); bottom.add(edit); bottom.add(save); bottom.add(exit);
        bottom.setBackground(Main.SKY_BLUE);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void saveToCSV(Transactor t) {
        File f = new File("transactors.csv");
        boolean writeHeader = !f.exists();
        try (FileWriter fw = new FileWriter(f, true)) {
            if (writeHeader) fw.write("Name,Address,Contact,Problem,Residence,Date\n");
            fw.write(t.toCSV() + "\n");
            JOptionPane.showMessageDialog(this, "Saved to transactors.csv", "Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}