import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.*;
import java.time.LocalDate;

public class ServicesRequestForm extends JFrame {
    private JTextField nameField;
    private JTextField addressField;
    private JTextField contactField;
    private JComboBox<String> serviceCombo;
    private JComboBox<String> residenceCombo;
    private JComboBox<String> monthCombo, dayCombo, yearCombo;

    public ServicesRequestForm(Transactor prefill) {
        setTitle("Service Request Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);

        nameField = new JTextField(30);
        addressField = new JTextField(30);
        contactField = new JTextField(30);

        String[] services = {"Water testing", "Pipe repair", "Community consultation"};
        serviceCombo = new JComboBox<>(services);

        String[] residences = {"Student", "Teacher/s", "Visitor", "Resident"};
        residenceCombo = new JComboBox<>(residences);

        monthCombo = new JComboBox<>(new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"});
        String[] days = new String[31]; for (int i = 0; i < 31; i++) days[i] = Integer.toString(i + 1);
        dayCombo = new JComboBox<>(days);
        int yearNow = LocalDate.now().getYear();
        String[] years = new String[21]; for (int i = 0; i < 21; i++) years[i] = Integer.toString(yearNow - 10 + i);
        yearCombo = new JComboBox<>(years);


        if (prefill != null) {
            nameField.setText(prefill.getName());
            addressField.setText(prefill.getAddress());
            contactField.setText(prefill.getContact());
            serviceCombo.setSelectedItem(prefill.getProblem());
            residenceCombo.setSelectedItem(prefill.getResidence());
            LocalDate d = prefill.getDate();
            monthCombo.setSelectedIndex(d.getMonthValue() - 1);
            dayCombo.setSelectedItem(Integer.toString(d.getDayOfMonth()));
            yearCombo.setSelectedItem(Integer.toString(d.getYear()));
        }

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Main.SKY_BLUE);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6,6,6,6); c.anchor = GridBagConstraints.WEST;

        int y = 0;
        c.gridx = 0; c.gridy = y; panel.add(new JLabel("Name:"), c);
        c.gridx = 1; panel.add(nameField, c); y++;

        c.gridx = 0; c.gridy = y; panel.add(new JLabel("Address/Location:"), c);
        c.gridx = 1; panel.add(addressField, c); y++;

        c.gridx = 0; c.gridy = y; panel.add(new JLabel("Contact Number:"), c);
        c.gridx = 1; panel.add(contactField, c); y++;

        c.gridx = 0; c.gridy = y; panel.add(new JLabel("Service requested:"), c);
        c.gridx = 1; panel.add(serviceCombo, c); y++;

        c.gridx = 0; c.gridy = y; panel.add(new JLabel("Type:"), c);
        c.gridx = 1; panel.add(residenceCombo, c); y++;

        c.gridx = 0; c.gridy = y; panel.add(new JLabel("Date:"), c);
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        datePanel.add(monthCombo); datePanel.add(dayCombo); datePanel.add(yearCombo);
        datePanel.setBackground(Main.SKY_BLUE);
        c.gridx = 1; panel.add(datePanel, c); y++;

        JButton next = new JButton("Next");
        next.addActionListener(e -> onNext());
        JButton back = new JButton("Back");
        back.addActionListener(e -> { new TransactionOptions(); dispose(); });
        JPanel bottom = new JPanel(); bottom.add(back); bottom.add(next);
        bottom.setBackground(Main.SKY_BLUE);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(Main.SKY_BLUE);
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void onNext() {
        String name = nameField.getText().trim();
        String address = addressField.getText().trim();
        String contact = contactField.getText().trim();
        String service = (String) serviceCombo.getSelectedItem();
        String residence = (String) residenceCombo.getSelectedItem();

        if (name.isEmpty() || address.isEmpty() || contact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill up or finish first the service request transaction.", "Incomplete", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int month = monthCombo.getSelectedIndex() + 1;
        int day = Integer.parseInt((String) dayCombo.getSelectedItem());
        int year = Integer.parseInt((String) yearCombo.getSelectedItem());

        LocalDate date;
        try {
            date = LocalDate.of(year, month, day);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid date selected.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Transactor t = new Transactor(name, address, contact, service, residence, date);
        new ServiceConfirmFrame(t);
        dispose();
    }

}