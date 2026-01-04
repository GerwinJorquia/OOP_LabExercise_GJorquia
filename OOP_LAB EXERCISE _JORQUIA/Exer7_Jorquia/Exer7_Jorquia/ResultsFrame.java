import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class ResultsFrame extends JFrame {
    public ResultsFrame() {
        setTitle("Transaction Records");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Main.SKY_BLUE);

        String[] columns = {"Name", "Address", "Contact", "Problem", "Residence", "Date"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);

        File f = new File("transactors.csv");
        if (!f.exists()) {
          
        } else {
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String line = br.readLine(); 
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 6) {
                        model.addRow(data);
                    }
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        JButton save = new JButton("Save");
        save.addActionListener(e -> saveTableToCSV(model));

        JButton edit = new JButton("Edit");
        edit.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a record to edit.");
                return;
            }
            JOptionPane.showMessageDialog(this, "Edit function not implemented yet.");
        });

        JButton delete = new JButton("Delete");
        delete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a record to delete.");
                return;
            }
            model.removeRow(row);
        });

        JButton back = new JButton("Back");
        back.addActionListener(e -> { new TransactionOptions(); dispose(); });

        JPanel bottom = new JPanel();
        bottom.add(back);
        bottom.add(edit);
        bottom.add(delete);
        bottom.add(save);
        bottom.setBackground(Main.SKY_BLUE);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(sp, BorderLayout.CENTER);
        getContentPane().add(bottom, BorderLayout.SOUTH);
        setVisible(true);
    }
    private void saveTableToCSV(DefaultTableModel model) {
        try (FileWriter fw = new FileWriter("transactors.csv")) {
            fw.write("Name,Address,Contact,Problem,Residence,Date\n");
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    fw.write(model.getValueAt(i, j).toString());
                    if (j < model.getColumnCount() - 1) fw.write(",");
                }
                fw.write("\n");
            }
            JOptionPane.showMessageDialog(this, "Changes saved successfully.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
        }
    }
}
