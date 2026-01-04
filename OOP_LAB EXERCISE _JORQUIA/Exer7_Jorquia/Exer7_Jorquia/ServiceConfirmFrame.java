import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ServiceConfirmFrame extends JFrame {

    public ServiceConfirmFrame(Transactor t) {
        setTitle("Confirm Service Request");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Main.SKY_BLUE);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBackground(Main.SKY_BLUE);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Name: " + t.getName()));
        panel.add(new JLabel("Address/Location: " + t.getAddress()));
        panel.add(new JLabel("Contact Number: " + t.getContact()));
        panel.add(new JLabel("Service Requested: " + t.getProblem()));
        panel.add(new JLabel("Type: " + t.getResidence()));
        panel.add(new JLabel("Date: " + t.getDate()));

        JButton edit = new JButton("Edit");
        edit.addActionListener(e -> {
            new ServicesRequestForm(t);
            dispose();
        });

        JButton save = new JButton("Save");
        save.addActionListener(e -> saveToServiceCSV(t));

        JButton back = new JButton("Back");
        back.addActionListener(e -> {
            new TransactionOptions();
            dispose();
        });

        JPanel bottom = new JPanel();
        bottom.setBackground(Main.SKY_BLUE);
        bottom.add(back);
        bottom.add(edit);
        bottom.add(save);

        add(panel, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void saveToServiceCSV(Transactor t) {
        File f = new File("services.csv");
        boolean writeHeader = !f.exists();

        try (FileWriter fw = new FileWriter(f, true)) {
            if (writeHeader) {
                fw.write("Name,Address,Contact,Service,Type,Date\n");
            }
            fw.write(t.toCSV() + "\n");

            JOptionPane.showMessageDialog(this,
                    "Service request saved successfully!",
                    "Saved",
                    JOptionPane.INFORMATION_MESSAGE);

            new TransactionOptions();
            dispose();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error saving file: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
